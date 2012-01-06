/*    */ package com.cyrius.informes.models;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TextoInforme
/*    */ {
/*    */   private String text;
/*    */ 
/*    */   public TextoInforme(String text)
/*    */   {
/* 17 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public String toString(Map<String, String> map) {
/* 21 */     Collection<String> keys = (Collection)map.keySet();
/* 22 */     for (String key : keys) {
/* 23 */       this.text.replaceAll(key, (String)map.get(keys));
/*    */     }
/* 25 */     return this.text;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.models.TextoInforme
 * JD-Core Version:    0.6.0
 */