/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class NoopMessageStrategy
/*    */   implements ShowMessageStrategy
/*    */ {
/* 10 */   public static ShowMessageStrategy INSTANCE = new NoopMessageStrategy();
/*    */ 
/*    */   public String transformMessage(String message)
/*    */   {
/* 17 */     return message;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.NoopMessageStrategy
 * JD-Core Version:    0.6.0
 */