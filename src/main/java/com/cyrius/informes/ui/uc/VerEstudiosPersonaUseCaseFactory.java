package com.cyrius.informes.ui.uc;

import com.cyrius.informes.models.VerEstudiosPersonaModel;
import com.cyrius.informes.ui.HistoriaClinicaUseCaseFactory;
import com.cyrius.informes.ui.targets.VerHistoriaClinicaTargetDecorator;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.actions.OpenUseCaseAction;
import com.framework.components.builders.impl.FormGridBuilder;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;
import com.framework.dynamicForms.integration.OpenDynamicFormAction;

public class VerEstudiosPersonaUseCaseFactory extends AbstractUseCaseFactory {
	public void registerFactorys(UseCaseBuilder builder) {
		builder.addPanel(new AbstractPanel() {
			public void registerElements(FormElementsBuilder builder) {
				FormGridBuilder grid = builder.addGrid("informes");
				grid.addDateColumn("fecha", "dd/MM/yy");
				grid.addColumn("turno");
				grid.addColumn("form");
				grid.addColumn("nroProtocolo");
				grid.addRowAction(new OpenDynamicFormAction("form", OpenEstudioTargetDecorator.class));
			}

			public void registerActions(FormActionBuilder builder) {
				builder.addAction(new OpenUseCaseAction(HistoriaClinicaUseCaseFactory.class,
						VerHistoriaClinicaTargetDecorator.class));
				builder.addCancelUseCaseAction();
			}
		});
	}

	public Class getAsociatedModel() {
		return VerEstudiosPersonaModel.class;
	}
}
