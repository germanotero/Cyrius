/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class PrinterException extends RuntimeException
/*    */ {
/*    */   public PrinterException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PrinterException(String message)
/*    */   {
/* 20 */     super(message);
/*    */   }
/*    */ 
/*    */   public PrinterException(String message, Throwable cause)
/*    */   {
/* 29 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public PrinterException(Throwable cause)
/*    */   {
/* 37 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.PrinterException
 * JD-Core Version:    0.6.0
 */