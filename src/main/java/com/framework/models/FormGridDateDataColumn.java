/*    */ package com.framework.models;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.apache.commons.collections4.Transformer;
/*    */ 
/*    */ public class FormGridDateDataColumn extends FormGridDataColumn
/*    */ {
/*    */   private String pattern;
/*    */ 
/*    */   public FormGridDateDataColumn(String modelProperty, Transformer transformer, boolean editable, Class<? extends Object> columnClass, String pattern)
/*    */   {
/* 17 */     super(modelProperty, transformer, editable, columnClass);
/* 18 */     this.pattern = pattern;
/*    */   }
/*    */ 
/*    */   public Object transform(DefaultFormGridModel.GridRow rowModel)
/*    */   {
/* 23 */     Date fecha = (Date)super.transform(rowModel);
/* 24 */     SimpleDateFormat dateFormat = new SimpleDateFormat(this.pattern);
/* 25 */     return dateFormat.format(fecha);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridDateDataColumn
 * JD-Core Version:    0.6.0
 */