/*    */ package com.cyrius.config;
/*    */ 
/*    */ import com.framework.utils.Constants;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.net.URISyntaxException;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class CyriusBusinessConfigSaver
/*    */ {
/*    */   public static void writeConfiguration(CyriusBusinessConfig bsConfig)
/*    */     throws IOException
/*    */   {
/*    */     try
/*    */     {
/* 20 */       FileOutputStream fos = new FileOutputStream(
/* 21 */         new File(Constants.CONFIGFILE.toURI()));
/*    */ 
/* 23 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 24 */       oos.writeObject(bsConfig);
/* 25 */       oos.close();
/* 26 */       fos.close();
/*    */     }
/*    */     catch (FileNotFoundException e) {
/* 29 */       e.printStackTrace();
/*    */     }
/*    */     catch (URISyntaxException e) {
/* 32 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.config.CyriusBusinessConfigSaver
 * JD-Core Version:    0.6.0
 */