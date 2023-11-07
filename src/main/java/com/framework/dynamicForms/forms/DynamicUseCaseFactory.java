package com.framework.dynamicForms.forms;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.collections4.Predicate;

import com.cyrius.informes.ui.uc.SendByEmailUseCaseFactory;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.actions.OpenUseCaseAction;
import com.framework.actions.ParentAction;
import com.framework.components.builders.impl.GroupBuilderImpl;
import com.framework.components.builders.interfaces.MenuBarBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;
import com.framework.dynamicForms.entities.DynamicForm;
import com.framework.dynamicForms.entities.DynamicGroupElement;
import com.framework.dynamicForms.entities.RelacionGroup;
import com.framework.entities.DynamicFormModel;
import com.framework.integration.PrintFormAction;
import com.framework.utils.CollectionFactory;

public final class DynamicUseCaseFactory extends AbstractUseCaseFactory {
	private DynamicForm form;

	DynamicUseCaseFactory(DynamicForm form) {
		setTabPopUp(true);
		this.form = form;
		setName(form.getName());
	}

	protected void addMenuBar(MenuBarBuilder menuBuilder) {
		menuBuilder.addMenu("Impresion").addMenuItem(new ParentAction(SendByEmailUseCaseFactory.class))
				.addMenuItem(new PrintFormAction()).addMenuItem(new PrintFormAction(new ImprimirReducido()));
	}

	public void registerFactorys(UseCaseBuilder builder) {
		Collection groupElements = this.form.getGroupElements();
		Collections.sort(CollectionFactory.createList(groupElements));
		for (Iterator iter = groupElements.iterator(); iter.hasNext();) {
			RelacionGroup relacion = (RelacionGroup) iter.next();
			DynamicGroupElement element = relacion.getGroup();
			GroupBuilderImpl groupBuilder = (GroupBuilderImpl) element.getBuilder();
			AbstractPanel panel = new DefaultTab(groupBuilder, element);
			panel.setImprimeReducido(relacion.getImprimeReducido());
			builder.addPanel(panel);
		}
		if (!this.form.getSimpleElements().isEmpty())
			builder.addPanel(new MainDynamicPanel(this.form));
	}

	public Class getAsociatedModel() {
		return DynamicFormModel.class;
	}

	private class ImprimirReducido implements Predicate {
		private ImprimirReducido() {
		}

		public boolean evaluate(Object arg0) {
			AbstractPanel panel = (AbstractPanel) arg0;
			return panel.isImprimeReducido().booleanValue();
		}
	}

	
}
