/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import com.framework.persistence.ApplicationException;
/*    */ 
/*    */ public class ProgramException extends ApplicationException
/*    */ {
/*    */   public ProgramException(String message)
/*    */   {
/* 10 */     super(message);
/*    */   }
/*    */ 
/*    */   public ProgramException(String message, Throwable throwable) {
/* 14 */     super(message, throwable);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.ProgramException
 * JD-Core Version:    0.6.0
 */