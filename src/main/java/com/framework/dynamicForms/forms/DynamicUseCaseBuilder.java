package com.framework.dynamicForms.forms;

import com.framework.abstractfactorys.FrameworkUseCaseFactory;
import com.framework.dynamicForms.entities.DynamicForm;

public class DynamicUseCaseBuilder {
	public static DynamicUseCaseFactory build(DynamicForm form) {
		DynamicUseCaseFactory dynamicUseCaseFactory = new DynamicUseCaseFactory(form);
		DynamicUseCaseFactory useCase = (DynamicUseCaseFactory) FrameworkUseCaseFactory
				.createUseCase(dynamicUseCaseFactory);
		useCase.setMultiplePanels(true);
		return useCase;
	}
}
