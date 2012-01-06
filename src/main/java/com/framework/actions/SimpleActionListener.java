/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import java.awt.event.ActionEvent;
/*    */ 
/*    */ public class SimpleActionListener
/*    */   implements FrameworkActionListener
/*    */ {
/*    */   private AbstractAction action;
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       this.action.preExecution();
/* 18 */       this.action.executeAction(null);
/* 19 */       this.action.postExecution();
/*    */     } catch (Throwable ex) {
/* 21 */       ExceptionHandler.getInstance().handle(ex);
/*    */     } finally {
/* 23 */       this.action.rearmOldState();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setAction(AbstractAction action) {
/* 28 */     this.action = action;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SimpleActionListener
 * JD-Core Version:    0.6.0
 */