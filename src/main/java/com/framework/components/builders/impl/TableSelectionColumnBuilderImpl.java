/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormGrid;
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormGridSelectionColumn;
/*    */ 
/*    */ public class TableSelectionColumnBuilderImpl
/*    */   implements TableColumnBuilderImpl
/*    */ {
/*    */   public void build(FormGridModel grid)
/*    */   {
/* 10 */     grid.addColumn(new FormGridSelectionColumn());
/*    */   }
/*    */ 
/*    */   public void initColumns(FormGrid column)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.TableSelectionColumnBuilderImpl
 * JD-Core Version:    0.6.0
 */