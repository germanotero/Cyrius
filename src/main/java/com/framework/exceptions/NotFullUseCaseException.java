/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class NotFullUseCaseException extends RuntimeException
/*    */   implements ShowableException
/*    */ {
/*    */   private String fields;
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 21 */     return this.fields;
/*    */   }
/*    */ 
/*    */   public NotFullUseCaseException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public NotFullUseCaseException(String arg0)
/*    */   {
/* 32 */     super(arg0);
/* 33 */     this.fields = arg0;
/*    */   }
/*    */ 
/*    */   public NotFullUseCaseException(String arg0, Throwable arg1)
/*    */   {
/* 41 */     super(arg0, arg1);
/*    */   }
/*    */ 
/*    */   public NotFullUseCaseException(Throwable arg0)
/*    */   {
/* 48 */     super(arg0);
/*    */   }
/*    */ 
/*    */   public String getHelpMessage() {
/* 52 */     return "Under Construction";
/*    */   }
/*    */ 
/*    */   public int getMessageType() {
/* 56 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.NotFullUseCaseException
 * JD-Core Version:    0.6.0
 */