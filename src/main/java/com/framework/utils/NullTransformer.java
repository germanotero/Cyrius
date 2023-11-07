/*    */ package com.framework.utils;
/*    */ 
/*    */ import org.apache.commons.collections4.Transformer;
/*    */ 
/*    */ public class NullTransformer
/*    */   implements Transformer
/*    */ {
/*  6 */   public static NullTransformer INSTANCE = new NullTransformer();
/*    */ 
/*    */   public Object transform(Object value)
/*    */   {
/* 13 */     return value;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.NullTransformer
 * JD-Core Version:    0.6.0
 */