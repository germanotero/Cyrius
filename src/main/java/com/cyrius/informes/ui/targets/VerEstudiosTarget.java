package com.cyrius.informes.ui.targets;

import com.cyrius.entities.Persona;
import com.cyrius.informes.models.VerEstudiosPersonaModel;
import com.cyrius.searchers.InformeSearcher;
import com.framework.actions.GridTargetDecorator;
import com.framework.actions.SimpleModelTarget;
import com.framework.entities.FormModelUtils;
import com.framework.models.FormModel;
import java.util.Collection;

public class VerEstudiosTarget extends GridTargetDecorator {
	public VerEstudiosTarget(SimpleModelTarget target) {
		super(target);
	}

	protected FormModel initModel(FormModel parentModel) {
		Persona paciente = (Persona) getSelectedValue().getValue();
		Collection informes = InformeSearcher.getInstance().findInformesByPerson(paciente);
		return FormModelUtils.wrap(new VerEstudiosPersonaModel(paciente, informes));
	}
}
