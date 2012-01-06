/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class DataBaseConnecitonException extends DataBaseException
/*    */   implements ShowableException
/*    */ {
/*    */   public DataBaseConnecitonException(String message, Throwable cause)
/*    */   {
/* 12 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public DataBaseConnecitonException() {
/* 16 */     super("");
/*    */   }
/*    */ 
/*    */   public DataBaseConnecitonException(String string) {
/* 20 */     super(string);
/*    */   }
/*    */ 
/*    */   public DataBaseConnecitonException(Throwable cause) {
/* 24 */     super(cause);
/*    */   }
/*    */ 
/*    */   public String getLocalizedMessage()
/*    */   {
/* 31 */     return "Error al intentar realizar una conexion con la base de datos. ";
/*    */   }
/*    */ 
/*    */   public String getHelpMessage()
/*    */   {
/* 39 */     return "Verifique que el servidor de Base de Datos se encuentra en estado correcto.";
/*    */   }
/*    */ 
/*    */   public int getMessageType()
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.DataBaseConnecitonException
 * JD-Core Version:    0.6.0
 */