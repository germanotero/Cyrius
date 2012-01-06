/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public class InternacionalizationMap extends PropertieFileMap
/*    */ {
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
/* 73 */     return FrameworkResources.getInstance().getI8nFile();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.InternacionalizationMap
 * JD-Core Version:    0.6.0
 */