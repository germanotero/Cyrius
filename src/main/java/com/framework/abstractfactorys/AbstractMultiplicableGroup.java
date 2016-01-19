package com.framework.abstractfactorys;

import com.framework.actions.AbstractFormAction;
import com.framework.components.FormModelContainer;
import com.framework.components.FormValueSelectionContainer;
import com.framework.components.RowComponent;
import com.framework.components.builders.impl.DefaultFormComponentBuilder;
import com.framework.components.builders.impl.FormElementsBuilderImpl;
import com.framework.components.builders.impl.MultiplicableGroupElementBuilderImpl;
import com.framework.components.builders.impl.MultliplicableGroupBuilderImpl;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.entities.DynamicFormModel;
import com.framework.models.FormModel;
import com.framework.print.builder.PrintableElementsBuilder;
import com.framework.utils.ArrayIterator;
import com.framework.utils.CollectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractMultiplicableGroup extends AbstractGroup implements FormModelContainer, RowComponent {
	private FormTabbedPanel tabbedPanel;
	private int i = 0;
	private MultiplicableGroupElementBuilderImpl builder;
	private String emptyText = "";

	private boolean multplesEnable = false;

	private boolean initialized = false;

	protected void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
	}

	protected final void registerGroupElements(FormElementsBuilder elementBuilder) {
		((FormElementsBuilderImpl) elementBuilder).setColumnsCount(1);
		this.tabbedPanel = new FormTabbedPanel(this);
		elementBuilder.addBuilder(new DefaultFormComponentBuilder(this.tabbedPanel));
		this.builder = new MultiplicableGroupElementBuilderImpl(this);
		this.builder.setColumnsCount(1);
		this.builder.build();
	}

	public final void registerActions(FormActionBuilder builder) {
		builder.addAction(new AbstractFormAction() {
			protected boolean isImpactableModelAction() {
				return false;
			}

			protected void setUpAction() {
				setActionKey("newTab");
			}

			protected void executeFormAction(FormModel model) throws Exception {
				if (AbstractMultiplicableGroup.this.multplesEnable) {
					AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
					AbstractMultiplicableGroup.this.multplesEnable = false;
				}
				AbstractMultiplicableGroup.this.addTab();
			}
		});
		builder.addAction(new AbstractFormAction() {
			protected boolean isImpactableModelAction() {
				return false;
			}

			protected void setUpAction() {
				setActionKey("removeTab");
			}

			protected void executeFormAction(FormModel model) throws Exception {
				if (AbstractMultiplicableGroup.this.multplesEnable) {
					AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
					AbstractMultiplicableGroup.this.multplesEnable = false;
				} else {
					AbstractMultiplicableGroup.this.removeTab();
				}
			}
		});
		builder.addAction(new AbstractFormAction() {
			protected boolean isImpactableModelAction() {
				return false;
			}

			protected void executeFormAction(FormModel model) throws Exception {
				AbstractMultiplicableGroup.this.i = 0;
				AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
				AbstractMultiplicableGroup.this.addMultipleTab();
				AbstractMultiplicableGroup.this.refreshComponent();
			}

			protected void setUpAction() {
				setActionKey("multiplesAction");
			}
		});
	}

	protected final void initSubComponent() {
		if (this.initialized) {
			return;
		}
		this.initialized = true;
		List realModel = (List) getModelo().getValue();
		for (ListIterator iter = realModel.listIterator(); iter.hasNext();) {
			FormModel model = (FormModel) iter.next();

			if ((model.getValue() instanceof MultiplesModel))
				addMultipleTab();
			else
				addTab();
		}
	}

	protected Class getAsociatedModel() {
		return List.class;
	}

	private synchronized void addTab() {
		MultliplicableGroupBuilderImpl multiplicableGroupBuilder = addTabDefaultStrategy(this.builder, this.i);
		multiplicableGroupBuilder.withModelClass(DynamicFormModel.class);
		multiplicableGroupBuilder.withName(getName() + " N°" + (this.i + 1));
		multiplicableGroupBuilder.withOutBorder();
		AbstractGroup group = (AbstractGroup) multiplicableGroupBuilder.build();
		group.setPadre(this);
		this.tabbedPanel.addTab(group.getName(), group);
		this.i += 1;
	}

	private synchronized void addMultipleTab() {
		this.multplesEnable = true;
		MultliplicableGroupBuilderImpl multiplicableGroupBuilder = (MultliplicableGroupBuilderImpl) this.builder
				.addGroup(MultiplesGroup.class, this.i);
		multiplicableGroupBuilder.withModelClass(DynamicFormModel.class);
		multiplicableGroupBuilder.withName("");
		multiplicableGroupBuilder.withOutBorder();
		AbstractGroup group = (AbstractGroup) multiplicableGroupBuilder.build();
		group.setPadre(this);
		this.tabbedPanel.addTab(group.getName(), group);
	}

	protected MultliplicableGroupBuilderImpl addTabDefaultStrategy(MultiplicableGroupElementBuilderImpl builder,
			int index) {
		MultliplicableGroupBuilderImpl multiplicableGroupBuilder = (MultliplicableGroupBuilderImpl) builder
				.addGroup(getGroupToBeMultiplicated(), index);
		return multiplicableGroupBuilder;
	}

	private synchronized void removeTab() {
		if (this.tabbedPanel.getTabCount() > 0) {
			this.tabbedPanel.remove(this.tabbedPanel.getTabCount() - 1);
			this.i -= 1;
		}
	}

	protected Color getBackgroundColor() {
		return ColorFactory.createMultiplicableGroupColor();
	}

	public void direct(PrintableElementsBuilder print) {
		print.startGroup(this);
		if (this.tabbedPanel.getTabCount() < 1) {
			print.addInputValue("", this.emptyText);
			print.endGroup(this);
			return;
		}
		if (!this.multplesEnable)
			print.addInputValue("Cantidad", new Integer(this.i));
		Iterator groupsIterator = new ArrayIterator(this.tabbedPanel.getComponents());
		while (groupsIterator.hasNext()) {
			Object next = groupsIterator.next();
			if ((next instanceof AbstractPanel)) {
				AbstractPanel element = (AbstractPanel) next;
				if (element.isEnabled())
					element.direct(print);
			}
		}
		print.endGroup(this);
	}

	public Collection getAllValueSelectionComponents() {
		Collection col = CollectionFactory.createCollection();
		ArrayIterator iter = new ArrayIterator(this.tabbedPanel.getComponents());
		while (iter.hasNext()) {
			Component componente = (Component) iter.next();
			if ((componente instanceof AbstractPanel))
				col.addAll(getAllElements((AbstractPanel) componente));
			if ((componente instanceof FormValueSelectionContainer))
				col.add(componente);
		}
		return col;
	}

	protected abstract Class getGroupToBeMultiplicated();
}
