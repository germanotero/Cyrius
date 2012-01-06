/*    */ package com.framework.integration;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.AbstractFormAction;
/*    */ import com.framework.components.wrappers.UseCaseImplementation;
/*    */ import com.framework.entities.DynamicFormModel;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Iterator;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ import org.apache.commons.collections.functors.TruePredicate;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class PrintFormAction extends AbstractFormAction
/*    */ {
/* 22 */   private transient Log log = LogFactory.getLog(getClass());
/*    */   private Predicate printPredicate;
/*    */ 
/*    */   public PrintFormAction()
/*    */   {
/* 27 */     this(TruePredicate.INSTANCE);
/*    */   }
/*    */ 
/*    */   public PrintFormAction(Predicate predicate)
/*    */   {
/* 37 */     this.printPredicate = predicate;
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 42 */     setActionKey(getClass().getName() + "." + 
/* 43 */       this.printPredicate.getClass().getName());
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model) throws Exception
/*    */   {
/* 53 */     UseCaseImplementation useCase = (UseCaseImplementation)getPadre();
/* 54 */     this.log.debug("Se va a imprimir el informe: " + useCase.getName());
/*    */ 
/* 56 */     DocumentPrinter print = new DocumentPrinter(((DynamicFormModel)
/* 57 */       useCase.getModelo()).getDecorator());
/* 58 */     print.startDocument(useCase.getName());
/* 59 */     this.log.debug("Se inicia la iteracion de impresion");
/* 60 */     for (Iterator iter = useCase.panelsIterator(); iter.hasNext(); ) {
/* 61 */       AbstractPanel panel = (AbstractPanel)iter.next();
/* 62 */       if (this.printPredicate.evaluate(panel))
/* 63 */         panel.direct(print);
/*    */     }
/* 65 */     this.log.debug("Se termina la iteracion");
/* 66 */     print.print();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.integration.PrintFormAction
 * JD-Core Version:    0.6.0
 */