/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class PropertyFileExceptionBuilder extends RuntimeException
/*    */ {
/*  7 */   public static PropertyFileExceptionBuilder instance = new PropertyFileExceptionBuilder();
/*    */ 
/*    */   public static PropertyFileExceptionBuilder getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */ 
/*    */   public boolean validate(String message, boolean value) {
/* 18 */     if (!value) {
/* 19 */       throw new PropertyFileException(message);
/*    */     }
/* 21 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.PropertyFileExceptionBuilder
 * JD-Core Version:    0.6.0
 */