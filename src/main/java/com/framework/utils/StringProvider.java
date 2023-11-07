/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class StringProvider
/*    */ {
/* 18 */   private transient Logger log = Logger.getLogger(getClass());
/*    */ 
/* 20 */   private static StringProvider instance = new StringProvider();
/*    */ 
/* 22 */   private InternacionalizationMap map = new InternacionalizationMap();
/*    */ 
/*    */   public static StringProvider getInstance()
/*    */   {
/* 29 */     return instance;
/*    */   }
/*    */ 
/*    */   public String getValueOf(String key)
/*    */   {
/* 36 */     I18nKeyTokenizer itk = new I18nKeyTokenizer(key);
/* 37 */     while (itk.hasMoreKeys()) {
/* 38 */       String actualKey = itk.nextKey();
/* 39 */       String st = (String)this.map.get(actualKey);
/* 40 */       if (st != null)
/*    */       {
/* 48 */         return st + " ";
/*    */       }
/*    */     }
/* 51 */     this.log.error("Finalizo: no se encontro la  key: " + key);
/*    */ 
/* 53 */     return "ERROR I18N: " + key;
/*    */   }
/*    */ 
/*    */   private class I18nKeyTokenizer
/*    */   {
/* 65 */     private Collection keys ; 
/*    */ 
/* 64 */     private int actual = 0;
/*    */ 
/*    */     public I18nKeyTokenizer(String key) {
				keys = collect(new StringTokenizer(key, "."));
/*    */     }
/*    */     public boolean hasMoreKeys() {
/* 69 */       return this.actual < this.keys.size();
/*    */     }
/*    */ 
/*    */     public String nextKey() {
/* 73 */       return makeKey(this.actual++, this.keys);
/*    */     }
/*    */ 
/*    */     private String makeKey(int inic, Collection col) {
/* 77 */       List keys = CollectionFactory.createList(col);
/* 78 */       StringBuffer result = new StringBuffer((String)keys.get(inic));
/* 79 */       for (int i = inic + 1; i < keys.size(); i++) {
/* 80 */         result.append(".");
/* 81 */         result.append(keys.get(i));
/*    */       }
/* 83 */       return result.toString();
/*    */     }
/*    */ 
/*    */     private Collection collect(StringTokenizer stk) {
/* 87 */       Collection col = CollectionFactory.createCollection();
/* 88 */       while (stk.hasMoreTokens()) {
/* 89 */         col.add(stk.nextToken());
/*    */       }
/* 91 */       return col;
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.StringProvider
 * JD-Core Version:    0.6.0
 */