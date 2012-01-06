/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Hashtable;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MapFactory
/*    */ {
/*    */   public static Map createMap()
/*    */   {
/* 12 */     return new HashMap();
/*    */   }
/*    */ 
/*    */   public static <T, V> Map<T, V> createMapWith(T firstObject, V firstObjectValue)
/*    */   {
/* 17 */     HashMap answer = new HashMap();
/* 18 */     answer.put(firstObject, firstObjectValue);
/* 19 */     return answer;
/*    */   }
/*    */ 
/*    */   public static <T, V> Hashtable<T, V> createMap(Class<T> keyType, Class<V> valueType)
/*    */   {
/* 24 */     return new Hashtable();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.MapFactory
 * JD-Core Version:    0.6.0
 */