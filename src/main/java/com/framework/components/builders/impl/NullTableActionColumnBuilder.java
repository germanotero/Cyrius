/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormGrid;
/*    */ import com.framework.models.FormGridModel;
/*    */ 
/*    */ public class NullTableActionColumnBuilder extends TableActionColumnBuilderImpl
/*    */ {
/*  7 */   public static final NullTableActionColumnBuilder INSTANCE = new NullTableActionColumnBuilder();
/*    */ 
/*    */   public void build(FormGridModel grid)
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean hasActions()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ 
/*    */   public void initColumns(FormGrid grid)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.NullTableActionColumnBuilder
 * JD-Core Version:    0.6.0
 */