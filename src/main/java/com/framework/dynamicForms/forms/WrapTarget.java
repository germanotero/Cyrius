package com.framework.dynamicForms.forms;

import com.cyrius.informes.ui.uc.EmailModel;
import com.framework.actions.SimpleModelTarget;
import com.framework.entities.DynamicFormModel;
import com.framework.entities.FormModelDecorator;
import com.framework.models.FormModel;

public class WrapTarget extends SimpleModelTarget {
	public WrapTarget(SimpleModelTarget target) {
		super(target);
	}

	protected FormModel initModel(FormModel model) {
		
		return new FormModelDecorator(new EmailModel((DynamicFormModel) model));
	}
}