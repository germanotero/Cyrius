/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.FormAction;
/*    */ import com.framework.components.builders.impl.GroupBuilderImpl;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicGroupElement;
/*    */ 
/*    */ public class DefaultTab extends AbstractPanel
/*    */ {
/*    */   private final GroupBuilderImpl groupBuilder;
/*    */   private final DynamicGroupElement element;
/*    */ 
/*    */   public DefaultTab(GroupBuilderImpl builder, DynamicGroupElement element)
/*    */   {
/* 21 */     this.groupBuilder = builder;
/* 22 */     this.element = element;
/* 23 */     setName(element.getName());
/*    */   }
/*    */ 
/*    */   protected boolean withScrollPanel()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ 
/*    */   public void initComponent()
/*    */   {
/* 33 */     super.initComponent();
/*    */   }
/*    */ 
/*    */   public void registerElements(FormElementsBuilder builder) {
/* 37 */     this.groupBuilder.withContainer(this);
/* 38 */     this.groupBuilder.withOutBorder();
/* 39 */     builder.addBuilder(this.groupBuilder);
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder) {
/* 43 */     builder.addFinalizeUseCaseAction();
/* 44 */     builder.addCancelUseCaseAction().confirm("cancel.dynamicForm");
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 49 */     return this.element.getName();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DefaultTab
 * JD-Core Version:    0.6.0
 */