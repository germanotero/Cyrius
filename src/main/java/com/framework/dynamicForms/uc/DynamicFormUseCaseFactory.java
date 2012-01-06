/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.forms.DynamicPanelsPanelFactory;
/*    */ 
/*    */ public class DynamicFormUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 17 */     builder.addPanel(new DynamicPanelsPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 24 */     return DynamicForm.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.DynamicFormUseCaseFactory
 * JD-Core Version:    0.6.0
 */