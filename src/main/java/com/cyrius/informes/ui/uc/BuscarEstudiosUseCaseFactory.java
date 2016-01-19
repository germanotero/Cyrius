package com.cyrius.informes.ui.uc;

import com.cyrius.informes.ui.targets.VerEstudiosTarget;
import com.cyrius.searchers.BuscadorPersona;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.actions.OpenUseCaseAction;
import com.framework.components.builders.impl.FormGridBuilder;
import com.framework.components.builders.impl.MessageBuilder;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;

public class BuscarEstudiosUseCaseFactory extends AbstractUseCaseFactory {
	public void registerFactorys(UseCaseBuilder builder) {
		builder.addPanel(new AbstractPanel() {
			public void registerElements(FormElementsBuilder builder) {
				builder.addGroup(BuscarEstudiosGroup.class);

				FormGridBuilder grid = builder.addGrid(BuscadorPersona.getInstance(), "findByNombreApellido",
						new String[] { "nombre", "apellido" });
				grid.addColumn("nombre");
				grid.addColumn("apellido");
				grid.addColumn("documento");
				grid.addRowAction(
						new OpenUseCaseAction(VerEstudiosPersonaUseCaseFactory.class, VerEstudiosTarget.class));
				grid.setOnEmptyExceptionMessage("no.se.encontraron.personas").addValue("nombre", "nombre")
						.addValue("apellido", "apellido");
			}

			public void registerActions(FormActionBuilder builder) {
				builder.addCancelUseCaseAction();
			}
		});
	}

	public Class getAsociatedModel() {
		return BuscarEstudiosModel.class;
	}
}
