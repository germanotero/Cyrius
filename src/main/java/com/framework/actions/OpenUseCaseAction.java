package com.framework.actions;

import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.abstractfactorys.ChildUseCaseExecutor;
import com.framework.components.ModelTargetEnableContainer;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.models.FormModel;
import com.framework.utils.ClassUtils;
import javax.swing.ImageIcon;

public class OpenUseCaseAction extends AbstractFormAction {
	protected Class useCaseToBeOpenned;
	protected AbstractUseCaseFactory useCaseToBeOpennedInstance;
	private Class target;

	protected void setUpAction() {
	}

	public OpenUseCaseAction(Class childUseCase) {
		this.useCaseToBeOpenned = childUseCase;
	}

	public OpenUseCaseAction(Class childUseCase, ImageIcon icon) {
		super(icon);
		this.useCaseToBeOpenned = childUseCase;
	}

	public OpenUseCaseAction(AbstractUseCaseFactory childUseCase) {
		this(childUseCase, null, null);
	}

	public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, ImageIcon icon) {
		this(childUseCase, null, icon);
	}

	public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, Class target) {
		this(childUseCase);
		this.target = target;
	}

	public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, Class target, ImageIcon icon) {
		super(icon);
		this.useCaseToBeOpennedInstance = childUseCase;
		this.target = target;
	}

	public OpenUseCaseAction(Class childUseCase, Class target) {
		this(childUseCase);
		this.target = target;
	}

	protected void executeFormAction(FormModel model) throws Exception {
		ChildUseCaseExecutor executor = ChildUseCaseExecutor.newInstance();
		executor.setModelTargetDecorator(getTarget()).setModelo(getPadre().getModelo());
		if (this.useCaseToBeOpenned != null)
			executor.setUseCaseToBeOpenned(this.useCaseToBeOpenned);
		else
			executor.setUseCaseToBeOpennedInstance(this.useCaseToBeOpennedInstance);
		executor.execute((UseCaseImplementation) getPadre());
	}

	protected SimpleModelTarget getTarget() {
		if (this.target == null)
			return new SimpleTargetDecorator(getPadre().getOpenTarget());
		return (SimpleModelTarget) ClassUtils.newInstance(this.target, new Class[] { SimpleModelTarget.class },
				new Object[] { getPadre().getOpenTarget() });
	}

	protected String getActionKey() {
		if (this.useCaseToBeOpenned != null)
			return getTargetName() + this.useCaseToBeOpenned.getName();
		return getTargetName() + this.useCaseToBeOpennedInstance.getClass().getName();
	}

	private String getTargetName() {
		return this.target != null ? this.target.getName() + "." : "";
	}

	protected boolean isImpactableModelAction() {
		return true;
	}
}
