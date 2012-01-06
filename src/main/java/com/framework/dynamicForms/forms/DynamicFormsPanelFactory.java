/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.EditRowTargetDecorator;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.DynamicFormSearcher;
/*    */ import com.framework.dynamicForms.uc.DynamicFormUseCaseFactory;
/*    */ 
/*    */ public class DynamicFormsPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 21 */     FormGridBuilder gridBuilder = builder.addGrid(
/* 22 */       DynamicFormSearcher.getInstance(), "findDynamicFormOnly");
/* 23 */     gridBuilder.addColumn("name");
/* 24 */     gridBuilder.addColumn("description");
/* 25 */     gridBuilder.addRowAction(
/* 26 */       new OpenUseCaseAction(DynamicFormUseCaseFactory.class, EditRowTargetDecorator.class));
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 33 */     builder
/* 34 */       .addAction(new OpenUseCaseAction(
/* 35 */       DynamicFormUseCaseFactory.class));
/* 36 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicFormsPanelFactory
 * JD-Core Version:    0.6.0
 */