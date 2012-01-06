/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.components.models.PrintTabsModel;
/*    */ 
/*    */ public class PrintTabsUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 20 */     builder.addPanel(new AbstractPanel()
/*    */     {
/*    */       public void registerElements(FormElementsBuilder builder) {
/* 23 */         FormGridBuilder grid = builder.addGrid("panelsRegistry.panels");
/* 24 */         grid.addColumn("name");
/* 25 */         grid.addRowSelector("tabsSelected");
/*    */       }
/*    */ 
/*    */       public void registerActions(FormActionBuilder builder) {
/* 29 */         builder.addCancelUseCaseAction();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 38 */     return PrintTabsModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.PrintTabsUseCaseFactory
 * JD-Core Version:    0.6.0
 */