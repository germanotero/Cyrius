/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.informes.models.VerEstudiosPersonaModel;
/*    */ import com.cyrius.informes.ui.HistoriaClinicaUseCaseFactory;
/*    */ import com.cyrius.informes.ui.targets.VerHistoriaClinicaTargetDecorator;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.integration.OpenDynamicFormAction;
/*    */ 
/*    */ public class VerEstudiosPersonaUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 19 */     builder.addPanel(new AbstractPanel()
/*    */     {
/*    */       public void registerElements(FormElementsBuilder builder) {
/* 22 */         FormGridBuilder grid = builder.addGrid("informes");
/* 23 */         grid.addDateColumn("fecha", "dd/MM/yy");
/* 24 */         grid.addColumn("turno");
/* 25 */         grid.addColumn("form");
/* 26 */         grid.addColumn("nroProtocolo");
/* 27 */         grid.addRowAction(
/* 28 */           new OpenDynamicFormAction("form", 
/* 28 */           OpenEstudioTargetDecorator.class));
/*    */       }
/*    */ 
/*    */       public void registerActions(FormActionBuilder builder) {
/* 32 */         builder.addAction(
/* 34 */           new OpenUseCaseAction(HistoriaClinicaUseCaseFactory.class, 
/* 34 */           VerHistoriaClinicaTargetDecorator.class));
/* 35 */         builder.addCancelUseCaseAction();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 44 */     return VerEstudiosPersonaModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.VerEstudiosPersonaUseCaseFactory
 * JD-Core Version:    0.6.0
 */