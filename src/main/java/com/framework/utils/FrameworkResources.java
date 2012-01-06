/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public class FrameworkResources extends PropertieFileMap
/*    */ {
/*  8 */   public static FrameworkResources instance = new FrameworkResources();
/*    */ 
/*    */   public static FrameworkResources getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */ 
/*    */   protected void doExceptionLog()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void doEndLog()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void doKeyFoundLog(String key, String keyValue)
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void doInitLog()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected InputStream getFileMap()
/*    */     throws FileNotFoundException
/*    */   {
/* 40 */     return new FileInputStream("config/framework-config.properties");
/*    */   }
/*    */ 
/*    */   public InputStream getI8nFile() throws FileNotFoundException {
/* 44 */     return new FileInputStream(get("i18n.file.path").toString().trim());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.FrameworkResources
 * JD-Core Version:    0.6.0
 */