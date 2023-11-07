package com.cyrius.informes.ui;

import com.cyrius.entities.Medico;
import com.cyrius.informes.Informe;
import com.cyrius.informes.StartInformesModel;
import com.cyrius.searchers.InformeSearcher;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.actions.AbstractFormAction;
import com.framework.actions.FormAction;
import com.framework.actions.OpenUseCaseAction;
import com.framework.actions.SimpleModelTarget;
import com.framework.components.ModelTargetEnableContainer;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;
import com.framework.dynamicForms.integration.OpenDynamicFormAction;
import com.framework.models.FormModel;
import com.framework.utils.AbstractPredicate;
import java.awt.Dimension;
import java.util.Date;
import org.apache.commons.collections4.Transformer;

public class StartInformeUseCase extends AbstractUseCaseFactory {
	public void registerFactorys(UseCaseBuilder builder) {
		builder.addPanel(new AbstractPanel() {
			public void registerElements(FormElementsBuilder builder) {
				builder.setColumnsCount(1);
				builder.addCombo("turno.practica.estudios", "estudioSeleccionado");
				builder.addCombo(Medico.class, "medicoRealizante");
			}

			public void registerActions(FormActionBuilder builder) {
				builder.addAction(new OpenUseCaseAction(HistoriaClinicaUseCaseFactory.class,
						HistoriaClinicaTargetDecorator.class));
				OpenDynamicFormAction openDynamicFormAction = new OpenDynamicFormAction("estudioSeleccionado",
						new StartInformeUseCase.ModelToInformeTransformer());
				openDynamicFormAction.setNotVisibleOn(new StartInformeUseCase.TieneInformePredicate());
				builder.addAction(openDynamicFormAction);
				builder.addCancelUseCaseAction().setNotVisibleOn(new StartInformeUseCase.TieneInformePredicate());
				builder.addAction(new AbstractFormAction() {
					protected boolean isImpactableModelAction() {
						return false;
					}

					protected void executeFormAction(FormModel model) throws Exception {
						getPadre().setVisible(false);
						getPadre().getReturnTarget().returning(model);
					}

					protected String getActionKey() {
						return "closeActionAndRefreshParent";
					}
				}).setNotVisibleOn(new StartInformeUseCase.TieneInformePredicate().not());
			}
		});
	}

	protected Dimension setUseCaseDimension() {
		return new Dimension(450, 150);
	}

	public Class getAsociatedModel() {
		return StartInformesModel.class;
	}

	private class TieneInformePredicate extends AbstractPredicate {
		private TieneInformePredicate() {
		}

		public boolean evaluate(Object arg0) {
			StartInformesModel model = (StartInformesModel) ((FormModel) arg0).getValue();
			return InformeSearcher.getInstance().exsistsByTurno(model.getTurno());
		}
	}

	private class ModelToInformeTransformer implements Transformer {
		private ModelToInformeTransformer() {
		}

		public Object transform(Object arg0) {
			StartInformesModel model = (StartInformesModel) arg0;
			Informe informe = new Informe();
			informe.setFecha(new Date());
			informe.setForm(model.getEstudioSeleccionado());
			informe.setTurno(model.getTurno());
			informe.setMedicoRealizante(model.getMedicoRealizante());
			return informe;
		}
	}
}
