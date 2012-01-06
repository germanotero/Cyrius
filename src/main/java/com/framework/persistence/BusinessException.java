/*    */ package com.framework.persistence;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ 
/*    */ public class BusinessException extends ApplicationException
/*    */ {
/*    */   public BusinessException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public BusinessException(String messageKey)
/*    */   {
/* 12 */     super(StringProvider.getInstance().getValueOf(messageKey));
/*    */   }
/*    */ 
/*    */   public BusinessException(String messageKey, Throwable cause) {
/* 16 */     super(StringProvider.getInstance().getValueOf(messageKey), cause);
/*    */   }
/*    */ 
/*    */   public BusinessException(Throwable cause) {
/* 20 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.BusinessException
 * JD-Core Version:    0.6.0
 */