/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.EditRowTargetDecorator;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.ComboElementSearcher;
/*    */ import com.framework.dynamicForms.uc.ComboElementUseCaseFactory;
/*    */ 
/*    */ public class DynamicFormComboPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 18 */     FormGridBuilder gridBuilder = builder.addGrid(
/* 19 */       ComboElementSearcher.getInstance(), "findAll");
/* 20 */     gridBuilder.addColumn("name");
/* 21 */     gridBuilder.addColumn("description");
/* 22 */     gridBuilder.addSimpleRowSelectionMode("elementoSeleccionado");
/* 23 */     gridBuilder
/* 24 */       .addRowAction(new OpenUseCaseAction(
/* 25 */       ComboElementUseCaseFactory.class, 
/* 26 */       EditRowTargetDecorator.class));
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 33 */     builder.addAction(
/* 34 */       new OpenUseCaseAction(ComboElementUseCaseFactory.class));
/* 35 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicFormComboPanelFactory
 * JD-Core Version:    0.6.0
 */