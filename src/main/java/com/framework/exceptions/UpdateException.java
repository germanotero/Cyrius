/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class UpdateException extends RuntimeException
/*    */   implements ShowableException
/*    */ {
/*    */   private String message;
/*    */ 
/*    */   public UpdateException(String message, Exception e)
/*    */   {
/* 19 */     super(e);
/* 20 */     this.message = message;
/*    */   }
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 27 */     return this.message;
/*    */   }
/*    */ 
/*    */   public String getHelpMessage()
/*    */   {
/* 34 */     throw new RuntimeException("Under Construction");
/*    */   }
/*    */ 
/*    */   public int getMessageType() {
/* 38 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.UpdateException
 * JD-Core Version:    0.6.0
 */