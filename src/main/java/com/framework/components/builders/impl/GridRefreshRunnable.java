/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormGrid;
/*    */ 
/*    */ public class GridRefreshRunnable
/*    */   implements Runnable
/*    */ {
/*    */   private FormGrid grid;
/*    */   private long ms;
/*    */ 
/*    */   public GridRefreshRunnable(long ms)
/*    */   {
/* 13 */     this.ms = ms;
/*    */   }
/*    */ 
/*    */   public void run() {
/* 17 */     while (this.grid.isDisplayable())
/*    */       try {
/* 19 */         Thread.sleep(this.ms);
/* 20 */         this.grid.refreshComponent();
/*    */       } catch (InterruptedException e) {
/* 22 */         e.printStackTrace();
/*    */       }
/*    */   }
/*    */ 
/*    */   public void setGrid(FormGrid grid)
/*    */   {
/* 28 */     this.grid = grid;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.GridRefreshRunnable
 * JD-Core Version:    0.6.0
 */