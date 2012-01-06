/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class CollectionFactory
/*    */ {
/*    */   public static <T> Collection<T> createCollectionWith(T firstObject)
/*    */   {
/* 15 */     ArrayList answer = new ArrayList();
/* 16 */     answer.add(firstObject);
/* 17 */     return answer;
/*    */   }
/*    */ 
/*    */   public static <T> Collection<T> createCollection(Class<T> c) {
/* 21 */     ArrayList answer = new ArrayList();
/* 22 */     return answer;
/*    */   }
/*    */ 
/*    */   public static Collection createCollection() {
/* 26 */     Collection col = new ArrayList();
/* 27 */     return col;
/*    */   }
/*    */ 
/*    */   public static <T> Collection<T> createCollection(Collection<T> elements) {
/* 31 */     Collection col = new ArrayList(elements);
/* 32 */     return col;
/*    */   }
/*    */ 
/*    */   public static <T> List<T> createList(Collection<T> col) {
/* 36 */     if ((col instanceof List))
/* 37 */       return (List)col;
/* 38 */     return new ArrayList(col);
/*    */   }
/*    */ 
/*    */   public static List createList() {
/* 42 */     return new ArrayList();
/*    */   }
/*    */ 
/*    */   public static Collection createCollectionWith(Collection col) {
/* 46 */     return new ArrayList(col);
/*    */   }
/*    */ 
/*    */   public static <T> List<T> createList(Class<T> c) {
/* 50 */     return new ArrayList();
/*    */   }
/*    */ 
/*    */   public static Vector createVector() {
/* 54 */     return new Vector();
/*    */   }
/*    */ 
/*    */   public static Vector createVector(Collection collection) {
/* 58 */     return new Vector(collection);
/*    */   }
/*    */ 
/*    */   public static Set createSet() {
/* 62 */     return new HashSet();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.CollectionFactory
 * JD-Core Version:    0.6.0
 */