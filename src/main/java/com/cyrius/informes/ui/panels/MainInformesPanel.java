package com.cyrius.informes.ui.panels;

import com.cyrius.informes.StartInformeTargetDecorator;
import com.cyrius.informes.ui.StartInformeUseCase;
import com.cyrius.searchers.BuscadorMedicos;
import com.cyrius.searchers.BuscadorTurnos;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.actions.OpenUseCaseAction;
import com.framework.components.builders.impl.FormGridBuilder;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormComboBoxBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;

public class MainInformesPanel extends AbstractPanel {
	public void registerElements(FormElementsBuilder builder) {
		FormComboBoxBuilder comboBoxBuilder = builder.addCombo(BuscadorMedicos.getInstance(), "findAll",
				"medicoSeleccionado");

		FormGridBuilder gridBuilder = builder.addGrid(BuscadorTurnos.getInstance(), "findByMedicoForInformes",
				"medicoSeleccionado");
		gridBuilder.setRefresh(10000L);
		gridBuilder.addDateColumn("hora", "HH:mm");
		gridBuilder.addColumn("description");
		gridBuilder.addColumn("obraSocial");
		gridBuilder.addComponentDependency(comboBoxBuilder);
		gridBuilder.setOnEmptyExceptionMessage("no.turnos.para.medico").addValue("medico", "medicoSeleccionado");
		OpenUseCaseAction openUseCaseAction = new OpenUseCaseAction(StartInformeUseCase.class,
				StartInformeTargetDecorator.class);
		gridBuilder.addRowAction(openUseCaseAction);
	}

	public void registerActions(FormActionBuilder builder) {
	}
}
