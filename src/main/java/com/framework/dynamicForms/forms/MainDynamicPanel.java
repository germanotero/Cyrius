/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.FormAction;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.entities.DynamicFormElement;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ final class MainDynamicPanel extends AbstractPanel
/*    */ {
/*    */   private DynamicForm form;
/*    */ 
/*    */   MainDynamicPanel(DynamicForm form)
/*    */   {
/* 20 */     this.form = form;
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder) {
/* 24 */     builder.addFinalizeUseCaseAction();
/* 25 */     builder.addCancelUseCaseAction().confirm("cancel.dynamicForm");
/*    */   }
/*    */ 
/*    */   public void registerElements(FormElementsBuilder formElementsBuilder) {
/* 29 */     formElementsBuilder.setColumnsCount(
/* 30 */       this.form.getCantidadColumnas().intValue());
/* 31 */     for (Iterator iter = this.form.getSimpleElements().iterator(); iter
/* 32 */       .hasNext(); )
/*    */     {
/* 33 */       DynamicFormElement element = (DynamicFormElement)iter.next();
/* 34 */       FormComponentBuilder formComponentBuilder = element
/* 35 */         .getBuilder();
/* 36 */       formComponentBuilder.withContainer(this);
/* 37 */       formElementsBuilder.addBuilder(formComponentBuilder);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 43 */     return this.form.getName();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.MainDynamicPanel
 * JD-Core Version:    0.6.0
 */