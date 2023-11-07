package com.framework.dynamicForms.integration;

import java.math.BigInteger;

import javax.swing.JOptionPane;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;

import com.framework.actions.AbstractFormAction;
import com.framework.actions.SimpleModelTarget;
import com.framework.components.FormComponent;
import com.framework.dynamicForms.entities.DynamicForm;
import com.framework.dynamicForms.forms.DynamicUseCaseBuilder;
import com.framework.dynamicForms.forms.DynamicUseCaseFactory;
import com.framework.entities.DynamicFormDecorator;
import com.framework.entities.DynamicFormModel;
import com.framework.models.FormModel;
import com.framework.utils.ClassUtils;
import com.framework.utils.ModelUtils;

public class OpenDynamicFormAction extends AbstractFormAction {
	private String formProperty;
	private Transformer transformer;
	private Class target;

	public OpenDynamicFormAction(String formProperty, Transformer decorator) {
		this.formProperty = formProperty;
		this.transformer = decorator;
	}

	public OpenDynamicFormAction(String formProperty) {
		this(formProperty, new ConstantTransformer(new DefaultDecorator()));
		this.formProperty = formProperty;
	}

	public OpenDynamicFormAction(String formProperty, Class target) {
		this(formProperty, new ConstantTransformer(new DefaultDecorator()));
		this.formProperty = formProperty;
		this.target = target;
	}

	public OpenDynamicFormAction() {
		super();
	}

	public OpenDynamicFormAction(Class target) {
		super();
		this.target = target;
	}

	public OpenDynamicFormAction(Transformer decorator) {
		this(null, decorator);
	}

	private SimpleModelTarget getTarget() {
		if (this.target == null) {
			return new DefaultTarget(getPadre().getOpenTarget());
		}
		return (SimpleModelTarget) ClassUtils.newInstance(this.target, new Class[] { SimpleModelTarget.class },
				new Object[] { getPadre().getOpenTarget() });
	}

	protected void executeFormAction(FormModel model) throws Exception {
		DynamicForm form;
		if (this.formProperty != null)
			form = (DynamicForm) ModelUtils.getNestedProperty(model, this.formProperty).getValue();
		else {
			form = (DynamicForm) model.getValue();
		}
		DynamicUseCaseFactory formBuilded = DynamicUseCaseBuilder.build(form);
		SimpleModelTarget target = getTarget();
		formBuilded.setModelo(target.getModel(model));
		formBuilded.setReturnTarget(target);
		formBuilded.startUseCase();
	}

	protected boolean isImpactableModelAction() {
		return true;
	}

	protected void setUpAction() {
		setActionKey("openDynamicForm");
	}

	private static class DefaultDecorator implements DynamicFormDecorator {
		public void finishForm(String xmlData) {
			JOptionPane.showMessageDialog(null, "Finalizacion exitosa");
		}

		public String getName() {
			return "";
		}

		public String getDestinationName() {
			return "";
		}

		public BigInteger getNro() {
			return null;
		}

		public String getDatosXML() {
			return "";
		}

		public boolean isPersisted() {
			return false;
		}
	}

	public class DefaultTarget extends SimpleModelTarget {
		public DefaultTarget(SimpleModelTarget target) {
			super(target);
		}

		protected FormModel initModel(FormModel model) {
			return new DynamicFormModel(
					(DynamicFormDecorator) OpenDynamicFormAction.this.transformer.transform(model.getValue()));
		}
	}
}
