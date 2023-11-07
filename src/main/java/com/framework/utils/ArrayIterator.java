/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class ArrayIterator<E>
/*    */   implements Iterator<E>
/*    */ {
/*    */   private Predicate predicate;
/*    */   private E[] array;
/*    */   private E nextElement;
/* 17 */   private int actualIndex = 0;
/*    */ 
/*    */   public ArrayIterator(E[] array) {
/* 20 */     this(array, TruePredicate.INSTANCE);
/*    */   }
/*    */ 
/*    */   public ArrayIterator(E[] array, org.apache.commons.collections4.Predicate predicate) {
/* 24 */     this.predicate = predicate;
/* 25 */     this.array = array;
/*    */   }
/*    */ 
/*    */   public boolean hasNext() {
/* 29 */     if (this.actualIndex >= this.array.length)
/* 30 */       return false;
/* 31 */     if (this.predicate.evaluate(this.array[this.actualIndex])) {
/* 32 */       this.nextElement = this.array[this.actualIndex];
/* 33 */       this.actualIndex += 1;
/* 34 */       return true;
/*    */     }
/* 36 */     this.actualIndex += 1;
/* 37 */     return hasNext();
/*    */   }
/*    */ 
/*    */   public E next() {
/* 41 */     return this.nextElement;
/*    */   }
/*    */ 
/*    */   public void remove() {
/* 45 */     throw new UnsupportedOperationException(
/* 46 */       "Cant remove an element from an array");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.ArrayIterator
 * JD-Core Version:    0.6.0
 */