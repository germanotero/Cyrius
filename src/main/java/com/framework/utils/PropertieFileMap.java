/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.HashMap;
/*    */ import java.util.StringTokenizer;
/*    */ 
/*    */ public abstract class PropertieFileMap extends HashMap
/*    */ {
/*    */   protected PropertieFileMap()
/*    */   {
/* 25 */     createMap();
/*    */   }
/*    */ 
/*    */   public void createMap() {
/*    */     try {
/* 30 */       doInitLog();
/* 31 */       InputStream inputStream = getFileMap();
/* 32 */       BufferedReader br = new BufferedReader(
/* 33 */         new InputStreamReader(inputStream));
/* 34 */       while (br.ready()) {
/* 35 */         String value = br.readLine();
/* 36 */         if ((!value.equals("")) && (!value.substring(0, 1).equals("#"))) {
/* 37 */           StringTokenizer tk = new StringTokenizer(value, "=");
/* 38 */           String key = tk.nextToken().trim();
/*    */ 
/* 40 */           if (tk.hasMoreTokens()) {
/* 41 */             String keyValue = tk.nextToken().trim();
/* 42 */             put(key, keyValue);
/* 43 */             doKeyFoundLog(key, keyValue);
/*    */           }
/*    */         }
/*    */       }
/*    */ 
/* 48 */       doEndLog();
/*    */     }
/*    */     catch (Exception e) {
/* 51 */       doExceptionLog();
/* 52 */       throw new RuntimeException(
/* 53 */         "Error al levantar el archivo de Internacionalizacion", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   protected abstract void doExceptionLog();
/*    */ 
/*    */   protected abstract void doEndLog();
/*    */ 
/*    */   protected abstract void doKeyFoundLog(String paramString1, String paramString2);
/*    */ 
/*    */   protected abstract void doInitLog();
/*    */ 
/*    */   protected abstract InputStream getFileMap()
/*    */     throws FileNotFoundException;
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.PropertieFileMap
 * JD-Core Version:    0.6.0
 */