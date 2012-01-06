/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicGroupElement;
/*    */ import com.framework.dynamicForms.forms.DynamicGroupPanelFactory;
/*    */ 
/*    */ public class DynamicGroupUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 17 */     builder.addPanel(new DynamicGroupPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 24 */     return DynamicGroupElement.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.DynamicGroupUseCaseFactory
 * JD-Core Version:    0.6.0
 */