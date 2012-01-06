/*    */ package com.framework.components.wrappers;
/*    */ 
/*    */ import com.framework.actions.FormAction;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ 
/*    */ public class CloseUseCaseWindowListener extends WindowAdapter
/*    */ {
/*    */   private final FormAction action;
/*    */ 
/*    */   CloseUseCaseWindowListener(FormAction action)
/*    */   {
/* 12 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public void windowClosing(WindowEvent e)
/*    */   {
/* 17 */     this.action.doClick();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.CloseUseCaseWindowListener
 * JD-Core Version:    0.6.0
 */