/*    */ package com.framework.persistence;
/*    */ 
/*    */ public class PersistenceException extends ApplicationException
/*    */ {
/*    */   public PersistenceException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PersistenceException(String message)
/*    */   {
/* 10 */     super(message);
/*    */   }
/*    */ 
/*    */   public PersistenceException(String message, Throwable cause) {
/* 14 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public PersistenceException(Throwable cause) {
/* 18 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.PersistenceException
 * JD-Core Version:    0.6.0
 */