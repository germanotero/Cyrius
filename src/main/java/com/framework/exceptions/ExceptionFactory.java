/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ 
/*    */ public class ExceptionFactory
/*    */ {
/*    */   public static void validateNotNullArgument(String errorMessage, Object value)
/*    */   {
/* 31 */     if ((value == null) || ("".equals(value)))
/* 32 */       throw new IllegalArgumentException(errorMessage);
/*    */   }
/*    */ 
/*    */   public static void validateTrue(String messageKey, boolean value)
/*    */   {
/* 45 */     if (!value)
/* 46 */       throw new RuntimeException(StringProvider.getInstance()
/* 47 */         .getValueOf(messageKey));
/*    */   }
/*    */ 
/*    */   public static void validateFalse(String messageKey, boolean value)
/*    */   {
/* 56 */     if (value)
/* 57 */       throw new RuntimeException(StringProvider.getInstance()
/* 58 */         .getValueOf(messageKey));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.ExceptionFactory
 * JD-Core Version:    0.6.0
 */