/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ExceptionHandler
/*    */ {
/* 19 */   private static ExceptionHandler instance = new ExceptionHandler();
/*    */ 
/* 21 */   private transient Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   public static ExceptionHandler getInstance() {
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */   public void handle(Throwable ex) {
/* 28 */     startMessageSignal(ex);
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public void handle(JFrame padre, Throwable ex)
/*    */   {
/* 37 */     startMessageSignal(ex);
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public void handle(JDialog padre, Throwable ex)
/*    */   {
/* 46 */     startMessageSignal(ex);
/*    */   }
/*    */ 
/*    */   private void startMessageSignal(Throwable ex)
/*    */   {
/*    */     int messageType;
/* 51 */     if ((ex instanceof ShowableException)) {
/* 52 */       ShowableException showableException = (ShowableException)ex;
/* 53 */       messageType = showableException.getMessageType();
/* 54 */       this.log.warn("Error", ex);
/*    */     } else {
/* 56 */       messageType = 0;
/* 57 */       this.log.error("Error", ex);
/*    */     }
/* 59 */     JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensaje", 
/* 60 */       messageType);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.ExceptionHandler
 * JD-Core Version:    0.6.0
 */