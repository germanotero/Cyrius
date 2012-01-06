/*    */ package com.cyrius.informes.ui;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ 
/*    */ public class HistoriaClinicaUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 14 */     builder.addPanel(new AbstractPanel()
/*    */     {
/*    */       public void registerElements(FormElementsBuilder builder) {
/* 17 */         builder.addTextArea("historiaClinica");
/*    */       }
/*    */ 
/*    */       public void registerActions(FormActionBuilder builder) {
/* 21 */         builder.addFinalizeUseCaseAction();
/* 22 */         builder.addCancelUseCaseAction();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 32 */     return Persona.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.HistoriaClinicaUseCaseFactory
 * JD-Core Version:    0.6.0
 */