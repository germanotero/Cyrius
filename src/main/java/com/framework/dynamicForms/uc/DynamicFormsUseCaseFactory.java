/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.forms.DynamicFormsPanelFactory;
/*    */ import com.framework.entities.DynamicFormModel;
/*    */ 
/*    */ public class DynamicFormsUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 17 */     builder.addPanel(new DynamicFormsPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 24 */     return DynamicFormModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.DynamicFormsUseCaseFactory
 * JD-Core Version:    0.6.0
 */