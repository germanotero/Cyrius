/*     */ package com.framework.utils;
/*     */ 
/*     */ import com.framework.interfaces.Comparator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections.Closure;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.Transformer;
/*     */ 
/*     */ public class CollectionUtils extends org.apache.commons.collections.CollectionUtils
/*     */ {
/*     */   public static Collection<Object> arrayToCollection(Object[] array)
/*     */   {
/*  25 */     Collection col = new ArrayList();
/*  26 */     for (int i = 0; i < array.length; i++) {
/*  27 */       col.add(array[i]);
/*     */     }
/*  29 */     return col;
/*     */   }
/*     */ 
/*     */   public static Collection transformedCollection(Collection input, Transformer transformer)
/*     */   {
/*  34 */     Collection col = new ArrayList(input);
/*  35 */     transform(col, transformer);
/*  36 */     return col;
/*     */   }
/*     */ 
/*     */   public static Object first(Collection col) {
/*  40 */     return col.iterator().next();
/*     */   }
/*     */ 
/*     */   public static Collection<Object> select(Collection col, Predicate condition)
/*     */   {
/*  52 */     Collection result = new ArrayList();
/*  53 */     for (Iterator iter = col.iterator(); iter.hasNext(); ) {
/*  54 */       Object ob = iter.next();
/*  55 */       if (condition.evaluate(ob))
/*  56 */         result.add(ob);
/*     */     }
/*  58 */     return result;
/*     */   }
/*     */ 
/*     */   public static boolean and(Collection col, Predicate cmp)
/*     */   {
/*  68 */     for (Iterator iter = col.iterator(); iter.hasNext(); ) {
/*  69 */       Object element = iter.next();
/*  70 */       if (!cmp.evaluate(element))
/*  71 */         return false;
/*     */     }
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean any(Collection col, Comparator cmp)
/*     */   {
/*  84 */     for (Iterator iter = col.iterator(); iter.hasNext(); ) {
/*  85 */       Object element = iter.next();
/*  86 */       if (cmp.compare(element))
/*  87 */         return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   public static Collection union(Collection col1, Collection col2) {
/*  93 */     ArrayList answer = new ArrayList(col1.size() + col2.size());
/*  94 */     answer.addAll(col1);
/*  95 */     answer.addAll(col2);
/*  96 */     return answer;
/*     */   }
/*     */ 
/*     */   public static Collection predicatedTransformedCollection(Collection collection, Transformer transformer, Predicate predicate)
/*     */   {
/* 101 */     return collect(predicatedCollection(collection, predicate), transformer);
/*     */   }
/*     */ 
/*     */   public static int count(Collection collection, Predicate predicate) {
/* 105 */     int count = 0;
/* 106 */     for (Iterator iter = collection.iterator(); iter.hasNext(); ) {
/* 107 */       if (predicate.evaluate(iter.next())) {
/* 108 */         count++;
/*     */       }
/*     */     }
/* 111 */     return count;
/*     */   }
/*     */ 
/*     */   public static boolean containsAny(Collection col1, Collection col2)
/*     */   {
/* 118 */     for (Iterator iter = col1.iterator(); iter.hasNext(); ) {
/* 119 */      final  Object element = iter.next();
/* 120 */       if (find(col2, new Predicate()
/*     */       {
/*     */         public boolean evaluate(Object arg0) {
/* 123 */           return arg0.equals(element);
/*     */         }
/*     */       }) != null)
/*     */       {
/* 127 */         return false;
/*     */       }
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */   public static Collection collect(Collection input,final String attribute)
/*     */   {
/* 138 */     return collect(input, new Transformer()
/*     */     {
/*     */       public Object transform(Object arg0) {
/*     */         try {
/* 142 */           return PropertyUtils.getNestedProperty(arg0,attribute); } catch (Exception e) {
	/* 144 */         throw new RuntimeException(e);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public static boolean exists(Collection list, Predicate predicate)
/*     */   {
/* 152 */     return find(list, predicate) != null;
/*     */   }
/*     */ 
/*     */   public static Object last(Collection opciones) {
/* 156 */     Object last = null;
/* 157 */     for (Iterator iter = opciones.iterator(); iter.hasNext(); ) {
/* 158 */       Object element = iter.next();
/* 159 */       last = element;
/*     */     }
/* 161 */     return last;
/*     */   }
/*     */ 
/*     */   public static void forAllDo(Iterator iterator, Closure closure) {
/* 165 */     for (Iterator iter = iterator; iter.hasNext(); ) {
/* 166 */       Object element = iter.next();
/* 167 */       closure.execute(element);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void keep(Collection original, Collection options)
/*     */   {
/* 173 */     for (Iterator iter = original.iterator(); iter.hasNext(); ) {
/* 174 */       Object element = iter.next();
/* 175 */       if (!options.contains(element))
/* 176 */         iter.remove();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.CollectionUtils
 * JD-Core Version:    0.6.0
 */