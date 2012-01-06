/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.DynamicFormElementModel;
/*    */ import com.framework.dynamicForms.forms.DynamicFormElementPanelFactory;
/*    */ 
/*    */ public class DynamicFormElementsUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 17 */     builder.addPanel(new DynamicFormElementPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 24 */     return DynamicFormElementModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.DynamicFormElementsUseCaseFactory
 * JD-Core Version:    0.6.0
 */