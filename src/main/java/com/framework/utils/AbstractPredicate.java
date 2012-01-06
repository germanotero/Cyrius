/*    */ package com.framework.utils;
/*    */ 
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public abstract class AbstractPredicate
/*    */   implements Predicate
/*    */ {
/*    */   public Predicate not()
/*    */   {
/*  8 */     return new AbstractPredicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 11 */         return !AbstractPredicate.this.evaluate(arg0);
/*    */       }
/*    */     };
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.AbstractPredicate
 * JD-Core Version:    0.6.0
 */