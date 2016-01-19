package com.cyrius.informes.ui.uc;

import java.awt.Dimension;

import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.components.builders.interfaces.UseCaseBuilder;
import com.framework.integration.PDFPrintFormAction;

public class SendByEmailUseCaseFactory extends AbstractUseCaseFactory {
	public void registerFactorys(UseCaseBuilder builder) {
		builder.addPanel(new AbstractPanel() {
			public void registerElements(FormElementsBuilder builder) {
				builder.setColumnsCount(1);
				builder.addStringField("email");
			}

			public void registerActions(FormActionBuilder builder) {
				PDFPrintFormAction openDynamicFormAction = new PDFPrintFormAction();
				builder.addAction(openDynamicFormAction);
				builder.addCancelUseCaseAction();
			}
		});
	}

	protected Dimension setUseCaseDimension() {
		return new Dimension(450, 150);
	}

	public Class getAsociatedModel() {
		return EmailModel.class;
	}
}
