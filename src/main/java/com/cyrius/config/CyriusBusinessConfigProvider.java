/*    */ package com.cyrius.config;
/*    */ 
/*    */ import com.cyrius.exceptions.ConfigFileException;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ 
/*    */ public class CyriusBusinessConfigProvider
/*    */ {
/* 13 */   private static CyriusBusinessConfigProvider instance = new CyriusBusinessConfigProvider();
/*    */   private CyriusBusinessConfig bsConfig;
/*    */ 
/*    */   private CyriusBusinessConfigProvider()
/*    */   {
/* 19 */     loadBsConfig();
/*    */   }
/*    */ 
/*    */   public static CyriusBusinessConfigProvider getInstance()
/*    */   {
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */   public CyriusBusinessConfig getBusinessConfig()
/*    */   {
/* 31 */     return this.bsConfig != null ? this.bsConfig : new CyriusBusinessConfig();
/*    */   }
/*    */ 
/*    */   private void loadBsConfig() {
/* 35 */     File f = null;
/* 36 */     ObjectInputStream ois = null;
/*    */ 
/* 45 */     if (ois != null)
/*    */       try {
/* 47 */         ois.close();
/*    */       } catch (IOException e) {
/* 49 */         throw new ConfigFileException(e);
/*    */       }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.config.CyriusBusinessConfigProvider
 * JD-Core Version:    0.6.0
 */