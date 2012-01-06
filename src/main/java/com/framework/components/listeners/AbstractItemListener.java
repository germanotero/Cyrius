/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import java.awt.event.ItemEvent;
/*    */ import java.awt.event.ItemListener;
/*    */ 
/*    */ public abstract class AbstractItemListener
/*    */   implements ItemListener
/*    */ {
/* 11 */   private ItemListener otherListener = new NullComboListener();
/*    */ 
/*    */   public AbstractItemListener addJComboListener(AbstractItemListener listener) {
/* 14 */     this.otherListener = listener;
/* 15 */     return this;
/*    */   }
/*    */ 
/*    */   public void itemStateChanged(ItemEvent e)
/*    */   {
/* 22 */     this.otherListener.itemStateChanged(e);
/*    */   }
/*    */ 
/*    */   private class NullComboListener
/*    */     implements ItemListener
/*    */   {
/*    */     private NullComboListener()
/*    */     {
/*    */     }
/*    */ 
/*    */     public void itemStateChanged(ItemEvent e)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.AbstractItemListener
 * JD-Core Version:    0.6.0
 */