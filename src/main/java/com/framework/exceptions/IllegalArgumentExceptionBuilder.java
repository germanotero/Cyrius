/*   */ package com.framework.exceptions;
/*   */ 
/*   */ public class IllegalArgumentExceptionBuilder
/*   */ {
/*   */   public static void validateTrue(String message, boolean validation)
/*   */   {
/* 9 */     if (!validation)
/* 10 */       throw new IllegalArgumentException(message);
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.IllegalArgumentExceptionBuilder
 * JD-Core Version:    0.6.0
 */