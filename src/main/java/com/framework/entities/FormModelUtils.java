/*    */ package com.framework.entities;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public final class FormModelUtils
/*    */ {
/*  9 */   public static FormModel NULL_MODEL = new FormModel()
/*    */   {
/*    */     public void refresh()
/*    */     {
/*    */     }
/*    */ 
/*    */     public Object getValue() {
/* 16 */       throw new RuntimeException(
/* 17 */         "No se le puede pedir el valor a un null model");
/*    */     }
/*    */ 
/*    */     public void setProperty(String aspect, Object value)
/*    */     {
/*    */     }
/*    */ 
/*    */     public FormModel getProperty(String aspect)
/*    */     {
/* 26 */       throw new RuntimeException(
/* 27 */         "No se le puede pedir un atributo a un null model");
/*    */     }
/*    */ 
/*    */     public void save() {
/*    */     }
/*    */ 
/*    */     public Class getDecoratedClass() {
/* 34 */       return getClass();
/*    */     }
/*    */ 
/*    */     public boolean isPersisted() {
/* 38 */       return false;
/*    */     }
/*  9 */   };
/*    */ 
/*    */   public static FormModel wrap(Object wrapee)
/*    */   {
/* 48 */     if (wrapee == null) {
/* 49 */       return new FormModel()
/*    */       {
/*    */         public void save()
/*    */         {
/*    */         }
/*    */ 
/*    */         public FormModel getProperty(String aspect) {
/* 56 */           throw new UnsupportedOperationException(
/* 57 */             "No se le puede pedir una propiedad a un modelo nulo");
/*    */         }
/*    */ 
/*    */         public void setProperty(String aspect, Object value)
/*    */         {
/* 62 */           throw new UnsupportedOperationException(
/* 63 */             "No se le puede setear una propiedad a un modelo nulo");
/*    */         }
/*    */ 
/*    */         public Object getValue()
/*    */         {
/* 68 */           return null;
/*    */         }
/*    */ 
/*    */         public void refresh()
/*    */         {
/*    */         }
/*    */ 
/*    */         public Class getDecoratedClass()
/*    */         {
/* 77 */           return null;
/*    */         }
/*    */ 
/*    */         public boolean isPersisted() {
/* 81 */           return false;
/*    */         }
/*    */       };
/*    */     }
/* 86 */     if ((wrapee instanceof FormModel))
/* 87 */       return (FormModel)wrapee;
/* 88 */     return new FormModelDecorator(wrapee);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.FormModelUtils
 * JD-Core Version:    0.6.0
 */