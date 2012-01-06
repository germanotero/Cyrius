/*    */ package com.framework.persistence;
/*    */ 
/*    */ import com.framework.exceptions.ShowableExceptionImpl;
/*    */ 
/*    */ public abstract class ApplicationException extends ShowableExceptionImpl
/*    */ {
/*    */   public ApplicationException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplicationException(String message)
/*    */   {
/* 12 */     super(message);
/*    */   }
/*    */ 
/*    */   public ApplicationException(String message, Throwable cause) {
/* 16 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public ApplicationException(Throwable cause) {
/* 20 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.ApplicationException
 * JD-Core Version:    0.6.0
 */