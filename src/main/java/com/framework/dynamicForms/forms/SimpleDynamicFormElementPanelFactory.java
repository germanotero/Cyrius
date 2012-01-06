/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*    */ 
/*    */ public class SimpleDynamicFormElementPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 18 */     builder.setColumnsCount(1);
/* 19 */     builder.addStringField("name").required();
/* 20 */     builder.addStringField("description").required();
/* 21 */     builder.addCombo(TipoFormElementSearcher.getInstance(), 
/* 22 */       "findSimpleTypes", "tipoDynamicFormElement");
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 29 */     builder.addFinalizeUseCaseAction();
/* 30 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.SimpleDynamicFormElementPanelFactory
 * JD-Core Version:    0.6.0
 */