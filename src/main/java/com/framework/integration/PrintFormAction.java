package com.framework.integration;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.abstractfactorys.AbstractPanel;
import com.framework.actions.AbstractFormAction;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.entities.DynamicFormModel;
import com.framework.models.FormModel;

public class PrintFormAction extends AbstractFormAction {
	private transient Log log = LogFactory.getLog(getClass());
	private Predicate printPredicate;

	public PrintFormAction() {
		this(TruePredicate.INSTANCE);
	}

	public PrintFormAction(Predicate predicate) {
		this.printPredicate = predicate;
	}

	protected void setUpAction() {
		setActionKey(getClass().getName() + "." + this.printPredicate.getClass().getName());
	}

	protected boolean isImpactableModelAction() {
		return true;
	}

	protected void executeFormAction(FormModel model) throws Exception {
		UseCaseImplementation useCase = (UseCaseImplementation) getPadre();

		DocumentPrinter print = new DocumentPrinter(((DynamicFormModel) useCase.getModelo()).getDecorator());
		print.startDocument(useCase.getName());
		
		for (Iterator iter = useCase.panelsIterator(); iter.hasNext();) {
			AbstractPanel panel = (AbstractPanel) iter.next();
			if (this.printPredicate.evaluate(panel))
				panel.direct(print);
		}
		// Agregar las imagenes al final
		print.addImage(new File("/tmp/eco1.jpg").toURL());
		
		print.print();
	}
}
