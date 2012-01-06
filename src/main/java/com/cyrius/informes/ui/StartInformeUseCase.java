/*     */ package com.cyrius.informes.ui;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.informes.Informe;
/*     */ import com.cyrius.informes.StartInformesModel;
/*     */ import com.cyrius.searchers.InformeSearcher;
/*     */ import com.framework.abstractfactorys.AbstractPanel;
/*     */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*     */ import com.framework.actions.AbstractFormAction;
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.OpenUseCaseAction;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*     */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*     */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*     */ import com.framework.dynamicForms.integration.OpenDynamicFormAction;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.AbstractPredicate;
/*     */ import java.awt.Dimension;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.collections.Transformer;
/*     */ 
/*     */ public class StartInformeUseCase extends AbstractUseCaseFactory
/*     */ {
/*     */   public void registerFactorys(UseCaseBuilder builder)
/*     */   {
/*  27 */     builder.addPanel(new AbstractPanel()
/*     */     {
/*     */       public void registerElements(FormElementsBuilder builder) {
/*  30 */         builder.setColumnsCount(1);
/*  31 */         builder.addCombo("turno.practica.estudios", 
/*  32 */           "estudioSeleccionado");
/*  33 */         builder.addCombo(Medico.class, "medicoRealizante");
/*     */       }
/*     */ 
/*     */       public void registerActions(FormActionBuilder builder) {
/*  37 */         builder.addAction(
/*  39 */           new OpenUseCaseAction(HistoriaClinicaUseCaseFactory.class, 
/*  39 */           HistoriaClinicaTargetDecorator.class));
/*  40 */         OpenDynamicFormAction openDynamicFormAction = new OpenDynamicFormAction(
/*  41 */           "estudioSeleccionado", new StartInformeUseCase.ModelToInformeTransformer());
/*  42 */         openDynamicFormAction
/*  43 */           .setNotVisibleOn(new StartInformeUseCase.TieneInformePredicate());
/*  44 */         builder.addAction(openDynamicFormAction);
/*  45 */         builder.addCancelUseCaseAction().setNotVisibleOn(
/*  46 */           new StartInformeUseCase.TieneInformePredicate());
/*  47 */         builder.addAction(new AbstractFormAction()
/*     */         {
/*     */           protected boolean isImpactableModelAction()
/*     */           {
/*  51 */             return false;
/*     */           }
/*     */ 
/*     */           protected void executeFormAction(FormModel model)
/*     */             throws Exception
/*     */           {
/*  57 */             getPadre().setVisible(false);
/*  58 */             getPadre().getReturnTarget().returning(model);
/*     */           }
/*     */ 
/*     */           protected String getActionKey()
/*     */           {
/*  63 */             return "closeActionAndRefreshParent";
/*     */           }
/*     */         }).setNotVisibleOn(new StartInformeUseCase.TieneInformePredicate().not());
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   protected Dimension setUseCaseDimension()
/*     */   {
/*  75 */     return new Dimension(450, 150);
/*     */   }
/*     */ 
/*     */   public Class getAsociatedModel()
/*     */   {
/*  81 */     return StartInformesModel.class;
/*     */   }
/*     */   private class TieneInformePredicate extends AbstractPredicate {
/*     */     private TieneInformePredicate() {
/*     */     }
/*  86 */     public boolean evaluate(Object arg0) { StartInformesModel model = (StartInformesModel)((FormModel)arg0)
/*  87 */         .getValue();
/*  88 */       return InformeSearcher.getInstance().exsistsByTurno(
/*  89 */         model.getTurno()); } 
/*     */   }
/*     */   private class ModelToInformeTransformer implements Transformer {
/*     */     private ModelToInformeTransformer() {
/*     */     }
/*     */ 
/*     */     public Object transform(Object arg0) {
/*  95 */       StartInformesModel model = (StartInformesModel)arg0;
/*  96 */       Informe informe = new Informe();
/*  97 */       informe.setFecha(new Date());
/*  98 */       informe.setForm(model.getEstudioSeleccionado());
/*  99 */       informe.setTurno(model.getTurno());
/* 100 */       informe.setMedicoRealizante(model.getMedicoRealizante());
/* 101 */       return informe;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.StartInformeUseCase
 * JD-Core Version:    0.6.0
 */