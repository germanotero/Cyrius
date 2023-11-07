/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormComponent;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import com.framework.components.builders.interfaces.TreeBuilder;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class TreeBuilderImpl
/*    */   implements FormComponentBuilder, TreeBuilder
/*    */ {
/*    */   public TreeBuilderImpl(String property, String childrenProperty, RefreshableComponent container)
/*    */   {
/*    */   }
/*    */ 
/*    */   public FormComponent build()
/*    */   {
/* 24 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public boolean isRowComponent()
/*    */   {
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withID(Number id) {
/* 33 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withName(String name)
/*    */   {
/* 38 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withContainer(RefreshableComponent container)
/*    */   {
/* 43 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*    */   {
/* 49 */     formBuilder.addComponent(build(), "+");
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withModelProperty(String modelProperty)
/*    */   {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   public void setDisableOn(Predicate predicate) {
/* 58 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder required()
/*    */   {
/* 63 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.TreeBuilderImpl
 * JD-Core Version:    0.6.0
 */