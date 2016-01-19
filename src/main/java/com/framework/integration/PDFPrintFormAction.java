package com.framework.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.mail.MessagingException;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.TruePredicate;

import com.cyrius.informes.ui.uc.EmailModel;
import com.cyrius.services.SendMailService;
import com.framework.abstractfactorys.AbstractPanel;
import com.framework.actions.AbstractFormAction;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.entities.DynamicFormModel;
import com.framework.entities.FormModelDecorator;
import com.framework.models.FormModel;
import com.google.api.services.gmail.Gmail;

public class PDFPrintFormAction extends AbstractFormAction {
	private static final long serialVersionUID = -5151013366015209448L;
	private Predicate printPredicate;

	public PDFPrintFormAction() {
		this(TruePredicate.INSTANCE);
	}

	public PDFPrintFormAction(Predicate predicate) {
		this.printPredicate = predicate;
	}

	protected void setUpAction() {
		setActionKey(getClass().getName() + "." + this.printPredicate.getClass().getName());
	}

	protected boolean isImpactableModelAction() {
		return true;
	}

	protected void executeFormAction(FormModel model) throws Exception {

		FormModelDecorator deco = (FormModelDecorator) model;
		EmailModel emailModel = (EmailModel) deco.getValue();
		UseCaseImplementation useCase = (UseCaseImplementation) emailModel.getParentUseCase();
		PDFPrintableElementBuilder print = new PDFPrintableElementBuilder(
				((DynamicFormModel) (useCase.getModelo().getValue())).getDecorator());
		print.startDocument(useCase.getName());

		for (Iterator iter = useCase.panelsIterator(); iter.hasNext();) {
			AbstractPanel panel = (AbstractPanel) iter.next();
			if (this.printPredicate.evaluate(panel))
				panel.direct(print);
		}
		print.print();
		File informe = new File(print.getFileName());
		InputStream is = new FileInputStream(informe);

		// Build a new authorized API client service.
		Gmail service = SendMailService.getGmailService();

		// Print the labels in the user's account.
		String user = "me";

		try {
			SendMailService.sendMessage(service, user, emailModel.getEmail(), "Informe de Ecografia CENS.", "body",
					is);
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			informe.delete();
		}
		
		getPadre().getReturnTarget().returning(model);

	}
}
