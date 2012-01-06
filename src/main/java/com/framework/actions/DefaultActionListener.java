/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import foxtrot.Task;
/*    */ import foxtrot.Worker;
/*    */ import java.awt.event.ActionEvent;
/*    */ 
/*    */ public class DefaultActionListener
/*    */   implements FrameworkActionListener
/*    */ {
/*    */   private AbstractAction action;
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/*    */     try
/*    */     {
/* 22 */       this.action.preExecution();
/* 23 */       Worker.post(new Task() {
/*    */         public Object run() throws Exception {
/* 25 */           DefaultActionListener.this.action.executeAction(null);
/* 26 */           return null;
/*    */         }
/*    */       });
/* 29 */       this.action.postExecution();
/*    */     } catch (Exception ex) {
/* 31 */       ExceptionHandler.getInstance().handle(ex);
/*    */     } finally {
/* 33 */       this.action.rearmOldState();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setAction(AbstractAction action) {
/* 38 */     this.action = action;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.DefaultActionListener
 * JD-Core Version:    0.6.0
 */