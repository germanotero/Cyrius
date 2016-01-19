package com.cyrius.informes.ui.uc;

import java.awt.Container;

import com.framework.components.ModelTargetEnableContainer;
import com.framework.components.wrappers.JFrameWrapper;
import com.framework.entities.DynamicFormModel;

public class EmailModel {
	private String email;
	private DynamicFormModel parentModel;
	private JFrameWrapper parentUseCase;
	
	public EmailModel() {
	}
	
	public EmailModel(DynamicFormModel parentModel) {
		super();
		this.parentModel = parentModel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DynamicFormModel getParentModel() {
		return parentModel;
	}

	public void setParentUseCase(JFrameWrapper parent) {
		this.parentUseCase = parent;
	}
	
	public JFrameWrapper getParentUseCase() {
		return parentUseCase;
	}
	
}
