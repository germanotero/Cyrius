/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.EditRowTargetDecorator;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.SimpleDynamicFormElementSearcher;
/*    */ import com.framework.dynamicForms.uc.SimpleDynamicFormElementUseCaseFactory;
/*    */ 
/*    */ public class DynamicFormElementPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 22 */     FormGridBuilder gridBuilder = builder.addGrid(
/* 23 */       SimpleDynamicFormElementSearcher.getInstance(), 
/* 24 */       "findAllNotCombo");
/* 25 */     gridBuilder.addColumn("name");
/* 26 */     gridBuilder.addColumn("description");
/* 27 */     gridBuilder.addColumn("tipoDynamicFormElement");
/* 28 */     gridBuilder.addSimpleRowSelectionMode("elementoSeleccionado");
/* 29 */     gridBuilder.addRowAction(
/* 31 */       new OpenUseCaseAction(SimpleDynamicFormElementUseCaseFactory.class, 
/* 31 */       EditRowTargetDecorator.class));
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 38 */     builder.addAction(
/* 39 */       new OpenUseCaseAction(SimpleDynamicFormElementUseCaseFactory.class));
/* 40 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicFormElementPanelFactory
 * JD-Core Version:    0.6.0
 */