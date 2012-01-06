/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormGrid;
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import com.framework.persistence.ApplicationException;
/*    */ import java.awt.event.ItemEvent;
/*    */ import java.awt.event.ItemListener;
/*    */ 
/*    */ public class ComboSelectedGridDependency
/*    */   implements GridDependency, ItemListener
/*    */ {
/*    */   private FormGrid grid;
/*    */ 
/*    */   public void setGrid(FormGrid grid)
/*    */   {
/* 22 */     this.grid = grid;
/*    */   }
/*    */ 
/*    */   public void itemStateChanged(ItemEvent e) {
/* 26 */     if ((this.grid != null) && (e.getStateChange() == 1))
/*    */       try {
/* 28 */         this.grid.refreshComponent();
/*    */       } catch (ApplicationException ex) {
/* 30 */         ExceptionHandler.getInstance().handle(ex);
/*    */       }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.ComboSelectedGridDependency
 * JD-Core Version:    0.6.0
 */