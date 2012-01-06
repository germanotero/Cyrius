/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ 
/*    */ public class I18nMessageStrategy
/*    */   implements ShowMessageStrategy
/*    */ {
/*    */   public String transformMessage(String message)
/*    */   {
/* 13 */     return StringProvider.getInstance().getValueOf(message);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.I18nMessageStrategy
 * JD-Core Version:    0.6.0
 */