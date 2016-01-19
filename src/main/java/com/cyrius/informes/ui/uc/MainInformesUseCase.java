package com.cyrius.informes.ui.uc;

import java.awt.Dimension;

import com.cyrius.informes.models.MainInformesModel;
import com.cyrius.informes.ui.panels.MainInformesPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.actions.OpenUseCaseAction;
import com.framework.components.builders.interfaces.MenuBarBuilder;
import com.framework.components.builders.interfaces.MenuBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;
import com.framework.dynamicForms.uc.DynamicFormComboUseCaseFactory;
import com.framework.dynamicForms.uc.DynamicFormElementsUseCaseFactory;
import com.framework.dynamicForms.uc.DynamicFormsUseCaseFactory;
import com.framework.dynamicForms.uc.DynamicGroupsUseCaseFactory;

public class MainInformesUseCase extends AbstractUseCaseFactory {
	public void registerFactorys(UseCaseBuilder builder) {
		builder.addPanel(new MainInformesPanel());
	}

	protected void addMenuBar(MenuBarBuilder builder) {
		MenuBuilder menuFormularios = builder.addMenu("ABM_Informes");
		menuFormularios.addMenuItem(new OpenUseCaseAction(DynamicFormsUseCaseFactory.class));
		MenuBuilder administradores = menuFormularios.addSubMenu("administradores");
		administradores.addMenuItem(new OpenUseCaseAction(DynamicFormElementsUseCaseFactory.class));
		administradores.addMenuItem(new OpenUseCaseAction(DynamicGroupsUseCaseFactory.class));
		administradores.addMenuItem(new OpenUseCaseAction(DynamicFormComboUseCaseFactory.class));
		MenuBuilder menuEstudios = builder.addMenu("EstudiosRealizados");
		menuEstudios.addMenuItem(new OpenUseCaseAction(BuscarEstudiosUseCaseFactory.class));
	}

	protected Dimension setUseCaseDimension() {
		return new Dimension(800, 600);
	}

	public Class getAsociatedModel() {
		return MainInformesModel.class;
	}
}
