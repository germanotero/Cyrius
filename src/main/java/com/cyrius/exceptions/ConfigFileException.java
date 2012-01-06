/*    */ package com.cyrius.exceptions;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class ConfigFileException extends RuntimeException
/*    */ {
/*    */   private File file;
/*    */ 
/*    */   public ConfigFileException(Throwable e)
/*    */   {
/* 25 */     super(e);
/*    */   }
/*    */ 
/*    */   public ConfigFileException(File file)
/*    */   {
/* 30 */     this.file = file;
/*    */   }
/*    */ 
/*    */   public ConfigFileException(File file, Throwable cause) {
/* 34 */     super(cause);
/* 35 */     this.file = file;
/*    */   }
/*    */ 
/*    */   public ConfigFileException(String s, File file)
/*    */   {
/* 42 */     super(s);
/* 43 */     this.file = file;
/*    */   }
/*    */ 
/*    */   public String getFileName() {
/* 47 */     return this.file.getName();
/*    */   }
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 54 */     return "No se encontro el archivo de configuracion";
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.exceptions.ConfigFileException
 * JD-Core Version:    0.6.0
 */