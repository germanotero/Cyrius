/*    */ package com.framework.exceptions;
/*    */ 
/*    */ public class CyriusUpdateException extends RuntimeException
/*    */ {
/*    */   public CyriusUpdateException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CyriusUpdateException(String arg0)
/*    */   {
/* 27 */     super(arg0);
/*    */   }
/*    */ 
/*    */   public CyriusUpdateException(Throwable arg0)
/*    */   {
/* 34 */     super("Error al intentar modificar el elemento", arg0);
/*    */   }
/*    */ 
/*    */   public CyriusUpdateException(String arg0, Throwable arg1)
/*    */   {
/* 42 */     super(arg0, arg1);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.CyriusUpdateException
 * JD-Core Version:    0.6.0
 */