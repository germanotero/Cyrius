/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MapUtils extends org.apache.commons.collections.MapUtils
/*    */ {
/*    */   public static Object getKeyOf(Map map, Object value)
/*    */   {
/* 25 */     for (Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
/* 26 */       Object key = iter.next();
/* 27 */       if (map.get(key).equals(value)) {
/* 28 */         return key;
/*    */       }
/*    */     }
/* 31 */     throw new RuntimeException("el value, no se encuentra en el mapa");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.MapUtils
 * JD-Core Version:    0.6.0
 */