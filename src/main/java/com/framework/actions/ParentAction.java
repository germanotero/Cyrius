package com.framework.actions;

import java.awt.Container;

import javax.swing.ImageIcon;

import com.cyrius.informes.ui.uc.EmailModel;
import com.cyrius.informes.ui.uc.SendByEmailUseCaseFactory;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.abstractfactorys.ChildUseCaseExecutor;
import com.framework.components.wrappers.JFrameWrapper;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.entities.FormModelDecorator;
import com.framework.models.FormModel;

public class ParentAction extends OpenUseCaseAction {

	public ParentAction(AbstractUseCaseFactory childUseCase, Class target, ImageIcon icon) {
		super(childUseCase, target, icon);
	}

	public ParentAction(AbstractUseCaseFactory childUseCase, Class target) {
		super(childUseCase, target);
	}

	public ParentAction(AbstractUseCaseFactory childUseCase, ImageIcon icon) {
		super(childUseCase, icon);
	}

	public ParentAction(AbstractUseCaseFactory childUseCase) {
		super(childUseCase);
	}

	public ParentAction(Class childUseCase, Class target) {
		super(childUseCase, target);
	}

	public ParentAction(Class childUseCase, ImageIcon icon) {
		super(childUseCase, icon);
	}

	public ParentAction(Class childUseCase) {
		super(childUseCase);
	}
	@Override
	protected boolean isImpactableModelAction() {
	
		return true;
	}

	@Override
	protected void executeFormAction(FormModel model) throws Exception {
		ChildUseCaseExecutor executor = ChildUseCaseExecutor.newInstance();
		executor.setModelTargetDecorator(getTarget()).setModelo(getPadre().getModelo());
		if (this.useCaseToBeOpenned != null)
			executor.setUseCaseToBeOpenned(this.useCaseToBeOpenned);
		else
			executor.setUseCaseToBeOpennedInstance(this.useCaseToBeOpennedInstance);
		SendByEmailUseCaseFactory ucf = (SendByEmailUseCaseFactory) executor
				.execute((UseCaseImplementation) getPadre());
		((EmailModel) ((FormModelDecorator) ucf.getInternalWindow().getModelo()).getValue())
				.setParentUseCase((JFrameWrapper) getPadre());
	}

}
