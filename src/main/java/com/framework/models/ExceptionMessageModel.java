/*    */ package com.framework.models;
/*    */ 
/*    */ public class ExceptionMessageModel
/*    */ {
/*    */   private Throwable throwable;
/*    */ 
/*    */   public ExceptionMessageModel(Throwable e)
/*    */   {
/* 19 */     this.throwable = e;
/*    */   }
/*    */ 
/*    */   public String getMessage() {
/* 23 */     return this.throwable.getLocalizedMessage() == null ? 
/* 24 */       this.throwable.getClass().getName() : this.throwable.getLocalizedMessage();
/*    */   }
/*    */ 
/*    */   public String getStackTrace() {
/* 28 */     return createStackTrace();
/*    */   }
/*    */ 
/*    */   private String createStackTrace() {
/* 32 */     StringBuffer stb = new StringBuffer(this.throwable.getLocalizedMessage() + 
/* 33 */       "\n");
/* 34 */     for (int i = 0; i < this.throwable.getStackTrace().length; i++) {
/* 35 */       StackTraceElement element = this.throwable.getStackTrace()[i];
/* 36 */       stb.append(element.toString());
/* 37 */       stb.append("\n");
/*    */     }
/* 39 */     return stb.toString();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.ExceptionMessageModel
 * JD-Core Version:    0.6.0
 */