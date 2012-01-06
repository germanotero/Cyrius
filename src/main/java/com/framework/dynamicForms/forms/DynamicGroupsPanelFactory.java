/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.EditRowTargetDecorator;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.DynamicGroupElementSearcher;
/*    */ import com.framework.dynamicForms.uc.DynamicGroupUseCaseFactory;
/*    */ 
/*    */ public class DynamicGroupsPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 21 */     FormGridBuilder gridBuilder = builder.addGrid(
/* 22 */       DynamicGroupElementSearcher.getInstance(), "findAll");
/* 23 */     gridBuilder.addColumn("name");
/* 24 */     gridBuilder.addColumn("description");
/* 25 */     gridBuilder.addSimpleRowSelectionMode("elementoSeleccionado");
/* 26 */     gridBuilder
/* 27 */       .addRowAction(new OpenUseCaseAction(
/* 28 */       DynamicGroupUseCaseFactory.class, 
/* 29 */       EditRowTargetDecorator.class));
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 36 */     builder.addAction(
/* 37 */       new OpenUseCaseAction(DynamicGroupUseCaseFactory.class));
/* 38 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicGroupsPanelFactory
 * JD-Core Version:    0.6.0
 */