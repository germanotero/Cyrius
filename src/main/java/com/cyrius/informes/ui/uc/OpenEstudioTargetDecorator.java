package com.cyrius.informes.ui.uc;

import com.cyrius.informes.Informe;
import com.framework.actions.GridTargetDecorator;
import com.framework.actions.SimpleModelTarget;
import com.framework.entities.DynamicFormModel;
import com.framework.models.FormModel;

public class OpenEstudioTargetDecorator extends GridTargetDecorator {
	public OpenEstudioTargetDecorator(SimpleModelTarget target) {
		super(target);
	}

	protected FormModel initModel(FormModel parentModel) {
		Informe informe = (Informe) getSelectedValue().getValue();
		return new DynamicFormModel(informe);
	}
}
