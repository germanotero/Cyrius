/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ 
/*    */ public class DataBaseRuntimeExceptionFactory
/*    */ {
/* 14 */   private static DataBaseRuntimeExceptionFactory instance = new DataBaseRuntimeExceptionFactory();
/*    */ 
/*    */   public static DataBaseRuntimeExceptionFactory getInstance()
/*    */   {
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */   public RuntimeException buildDeleteException() {
/* 28 */     return new RuntimeException(StringProvider.getInstance()
/* 29 */       .getValueOf("databaseDeleteGeneralError"));
/*    */   }
/*    */ 
/*    */   public RuntimeException buildDeleteException(String i18nKey) {
/* 33 */     return new RuntimeException(StringProvider.getInstance()
/* 34 */       .getValueOf(i18nKey));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.DataBaseRuntimeExceptionFactory
 * JD-Core Version:    0.6.0
 */