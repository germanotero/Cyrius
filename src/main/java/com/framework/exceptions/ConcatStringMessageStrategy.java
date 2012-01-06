/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class ConcatStringMessageStrategy extends I18nMessageStrategy
/*    */   implements ShowMessageStrategy
/*    */ {
/*    */   private final String value;
/*    */ 
/*    */   ConcatStringMessageStrategy(String valueToConcat)
/*    */   {
/* 14 */     this.value = valueToConcat;
/*    */   }
/*    */ 
/*    */   public String transformMessage(String message) {
/* 18 */     return super.transformMessage(message) + ": " + this.value;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.ConcatStringMessageStrategy
 * JD-Core Version:    0.6.0
 */