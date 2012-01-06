/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class NotFullFormExceptionBuilder
/*    */ {
/*  4 */   private StringBuffer buffer = new StringBuffer();
/*    */ 
/*    */   public NotFullFormExceptionBuilder add(NotFullFormException ex)
/*    */   {
/* 11 */     this.buffer.append(ex.getFieldName()).append(",\n");
/* 12 */     return this;
/*    */   }
/*    */ 
/*    */   public boolean hasException() {
/* 16 */     return this.buffer.length() > 0;
/*    */   }
/*    */ 
/*    */   public NotFullFormException build()
/*    */   {
/* 23 */     return new NotFullFormException(
/* 24 */       this.buffer.substring(0, this.buffer.length() - 2));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.NotFullFormExceptionBuilder
 * JD-Core Version:    0.6.0
 */