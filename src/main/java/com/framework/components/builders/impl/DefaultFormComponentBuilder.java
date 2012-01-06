/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormComponent;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ import org.apache.commons.collections.functors.FalsePredicate;
/*    */ 
/*    */ public class DefaultFormComponentBuilder
/*    */   implements FormComponentBuilder
/*    */ {
/*    */   private FormComponent component;
/* 17 */   private boolean rowComponent = false;
/*    */   private String constraints;
/* 21 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*    */ 
/*    */   public DefaultFormComponentBuilder(FormComponent component, String constraints)
/*    */   {
/* 26 */     this.component = component;
/* 27 */     this.constraints = constraints;
/*    */   }
/*    */ 
/*    */   public DefaultFormComponentBuilder(FormComponent component) {
/* 31 */     this(component, ".");
/*    */   }
/*    */ 
/*    */   public FormComponent build()
/*    */   {
/* 38 */     this.component.setDisableOn(this.disablePredicate);
/* 39 */     this.component.initComponent();
/* 40 */     return this.component;
/*    */   }
/*    */ 
/*    */   public boolean isRowComponent() {
/* 44 */     return this.rowComponent;
/*    */   }
/*    */ 
/*    */   public void setRowComponent(boolean value) {
/* 48 */     this.rowComponent = value;
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withID(Number id) {
/* 52 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withName(String name)
/*    */   {
/* 57 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withContainer(RefreshableComponent container)
/*    */   {
/* 62 */     return this;
/*    */   }
/*    */ 
/*    */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*    */   {
/* 67 */     formBuilder.addComponent(build(), this.constraints);
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder withModelProperty(String modelProperty) {
/* 71 */     return null;
/*    */   }
/*    */ 
/*    */   public void setDisableOn(Predicate predicate) {
/* 75 */     this.disablePredicate = predicate;
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder required()
/*    */   {
/* 80 */     return this;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.DefaultFormComponentBuilder
 * JD-Core Version:    0.6.0
 */