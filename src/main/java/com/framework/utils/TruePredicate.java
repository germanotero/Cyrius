/*    */ package com.framework.utils;
/*    */ 
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public class TruePredicate
/*    */   implements Predicate
/*    */ {
/*  6 */   public static final TruePredicate INSTANCE = new TruePredicate();
/*    */ 
/*    */   public boolean evaluate(Object arg0)
/*    */   {
/* 13 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.TruePredicate
 * JD-Core Version:    0.6.0
 */