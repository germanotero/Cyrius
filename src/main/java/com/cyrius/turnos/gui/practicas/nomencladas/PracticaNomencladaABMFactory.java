package com.cyrius.turnos.gui.practicas.nomencladas;

import com.cyrius.entities.Medico;
import com.cyrius.entities.PracticaNomenclada;
import com.cyrius.entities.Preparacion;
import com.cyrius.searchers.EstudiosSearcher;
import com.framework.abstractfactorys.ABMUseCaseFactory;
import com.framework.actions.AbstractFormAction;
import com.framework.components.builders.impl.FormGridBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.models.FormModel;

public class PracticaNomencladaABMFactory extends ABMUseCaseFactory {
    protected void addEditElements(FormElementsBuilder builder) {
        builder.addStringField("codigo").required();
        builder.addStringField("description").required();

        builder.addDoubleField("cantGalenosHonorario").required();
        builder.addDoubleField("cantGalenosCosto").required();

        FormGridBuilder grillaMedicos = builder.addGrid(Medico.class);
        grillaMedicos.addColumn("nombre");
        grillaMedicos.addColumn("apellido");
        grillaMedicos.addRowSelector("medicos");
        grillaMedicos.setOneColumnGrid();

        FormGridBuilder grid = builder.addGrid(Preparacion.class);
        grid.addColumn("nombre");
        grid.addColumn("descripcion");
        grid.addSimpleRowSelectionMode("preparacion");
        grid.setOneColumnGrid();

        FormGridBuilder estudiosGrid = builder.addGrid(
                EstudiosSearcher.getInstance(), "findAllSinPractica");
        estudiosGrid.addColumn("name");
        estudiosGrid.addColumn("description");
        estudiosGrid.addRowSelector("estudios");
    }

    public Class getNewActionTargetDecorator() {
        return NuevaPracticaNomencladaTargetDecorator.class;
    }

    public Class getEditRowTargetDecorator() {
        return EditPracticaNomencladaTargetDecorator.class;
    }

    protected void addGridColumns(FormGridBuilder gridBuilder) {
        gridBuilder.addColumn("description");
    }

    public Class getAbmObject() {
        return PracticaNomenclada.class;
    }
}
