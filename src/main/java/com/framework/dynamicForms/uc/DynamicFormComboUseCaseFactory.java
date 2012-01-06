/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.DynamicFormElementModel;
/*    */ import com.framework.dynamicForms.forms.DynamicFormComboPanelFactory;
/*    */ 
/*    */ public class DynamicFormComboUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 12 */     builder.addPanel(new DynamicFormComboPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 17 */     return DynamicFormElementModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.DynamicFormComboUseCaseFactory
 * JD-Core Version:    0.6.0
 */