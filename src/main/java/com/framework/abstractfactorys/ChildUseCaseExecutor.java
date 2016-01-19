package com.framework.abstractfactorys;

import com.framework.actions.SimpleModelTarget;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.exceptions.ShowableExceptionImpl;
import com.framework.models.FormModel;

public class ChildUseCaseExecutor {
	private SimpleModelTarget modelTargetDecorator;
	private Class useCaseToBeOpennedClass;
	private FormModel model;
	private AbstractUseCaseFactory useCaseToBeOpennedInstance;
	private FormModel targetModel;

	public static ChildUseCaseExecutor newInstance() {
		return new ChildUseCaseExecutor();
	}

	public AbstractUseCaseFactory execute(UseCaseImplementation container) {
		try {
			AbstractUseCaseFactory useCaseToBeOpenned = getChildUseCaseInstance(container);
			targetModel = this.modelTargetDecorator.getModel(this.model);
			useCaseToBeOpenned.setModelo(targetModel);
			useCaseToBeOpenned.setReturnTarget(this.modelTargetDecorator);
			useCaseToBeOpenned.startUseCase();
			return useCaseToBeOpenned;
		} catch (ShowableExceptionImpl ex) {
			throw ex;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * This method will return the target model after it has been created.
	 */
	public FormModel getTargetModel() {
		return targetModel;
	}

	private AbstractUseCaseFactory getChildUseCaseInstance(UseCaseImplementation container) {
		if (this.useCaseToBeOpennedClass != null)
			return FrameworkUseCaseFactory.createChildUseCase(this.useCaseToBeOpennedClass, container);
		return FrameworkUseCaseFactory.createChildUseCase(this.useCaseToBeOpennedInstance, container);
	}

	public ChildUseCaseExecutor setModelo(FormModel model) {
		this.model = model;
		return this;
	}

	public ChildUseCaseExecutor setModelTargetDecorator(SimpleModelTarget modelTargetDecorator) {
		this.modelTargetDecorator = modelTargetDecorator;
		return this;
	}

	public ChildUseCaseExecutor setUseCaseToBeOpenned(Class useCaseToBeOpenned) {
		this.useCaseToBeOpennedClass = useCaseToBeOpenned;
		return this;
	}

	public void setUseCaseToBeOpennedInstance(AbstractUseCaseFactory useCaseToBeOpennedInstance) {
		this.useCaseToBeOpennedInstance = useCaseToBeOpennedInstance;
	}
}
