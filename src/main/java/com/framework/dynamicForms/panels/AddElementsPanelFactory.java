/*    */ package com.framework.dynamicForms.panels;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public final class AddElementsPanelFactory extends AbstractPanel
/*    */ {
/*    */   private Object searcher;
/*    */ 
/*    */   public AddElementsPanelFactory(Object elementsSearcher)
/*    */   {
/* 14 */     this.searcher = elementsSearcher;
/*    */   }
/*    */ 
/*    */   public final void registerElements(FormElementsBuilder builder) {
/* 18 */     FormGridBuilder grid = builder.addGrid(this.searcher, "findAll");
/* 19 */     grid.addRowSelector("selection");
/* 20 */     grid.addColumn("name");
/* 21 */     grid.addColumn("description");
/* 22 */     grid.addColumn("tipoDynamicFormElement");
/*    */   }
/*    */ 
/*    */   public final void registerActions(FormActionBuilder builder) {
/* 26 */     builder.addCancelUseCaseAction();
/* 27 */     builder.addFinalizeUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.panels.AddElementsPanelFactory
 * JD-Core Version:    0.6.0
 */