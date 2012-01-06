/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.components.builders.impl.FormGridBuilderImpl;
/*    */ import com.framework.models.FormGridModel;
/*    */ 
/*    */ public abstract class AbstractGridModelTargetListener
/*    */   implements ModelTargetListener
/*    */ {
/*    */   private FormGridBuilderImpl builder;
/*    */   private FormGridModel gridModel;
/*    */   private String modelProperty;
/*    */ 
/*    */   public void setBuilder(FormGridBuilderImpl builder)
/*    */   {
/* 26 */     this.builder = builder;
/*    */   }
/*    */ 
/*    */   public String getModelProperty() {
/* 30 */     return this.modelProperty;
/*    */   }
/*    */ 
/*    */   public void setModelProperty(String modelProperty) {
/* 34 */     this.modelProperty = modelProperty;
/*    */   }
/*    */ 
/*    */   public void setGridModel(FormGridModel gridModel)
/*    */   {
/* 42 */     this.gridModel = gridModel;
/*    */   }
/*    */ 
/*    */   protected FormGridBuilderImpl getBuilder()
/*    */   {
/* 49 */     return this.builder;
/*    */   }
/*    */ 
/*    */   protected FormGridModel getGridModel()
/*    */   {
/* 56 */     return this.gridModel;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.AbstractGridModelTargetListener
 * JD-Core Version:    0.6.0
 */