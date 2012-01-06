/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class DataBaseException extends RuntimeException
/*    */ {
/*    */   public DataBaseException(Throwable cause)
/*    */   {
/*  6 */     super(cause);
/*    */   }
/*    */ 
/*    */   public DataBaseException(String message, Throwable cause) {
/* 10 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public DataBaseException(String string) {
/* 14 */     super(string);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.DataBaseException
 * JD-Core Version:    0.6.0
 */