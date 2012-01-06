/*    */ package com.framework.models;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class DefaultComboModel extends Vector
/*    */ {
/*    */   public DefaultComboModel(Vector values)
/*    */   {
/* 16 */     super(values == null ? Collections.EMPTY_LIST : values);
/*    */   }
/*    */ 
/*    */   public DefaultComboModel(Collection values)
/*    */   {
/* 23 */     super(values == null ? Collections.EMPTY_LIST : values);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.DefaultComboModel
 * JD-Core Version:    0.6.0
 */