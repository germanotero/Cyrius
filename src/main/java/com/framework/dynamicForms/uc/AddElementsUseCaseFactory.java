/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.AddElementsModel;
/*    */ import com.framework.dynamicForms.elements.searchers.SimpleDynamicFormElementSearcher;
/*    */ import com.framework.dynamicForms.panels.AddElementsPanelFactory;
/*    */ 
/*    */ public class AddElementsUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 13 */     builder.addPanel(new AddElementsPanelFactory(getElementsSearcher()));
/*    */   }
/*    */ 
/*    */   protected Object getElementsSearcher()
/*    */   {
/* 20 */     return SimpleDynamicFormElementSearcher.getInstance();
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel() {
/* 24 */     return AddElementsModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.AddElementsUseCaseFactory
 * JD-Core Version:    0.6.0
 */