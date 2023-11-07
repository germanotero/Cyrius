/*    */ package com.framework.models;
/*    */ 
/*    */ import com.framework.utils.ModelUtils;
/*    */ import com.framework.utils.StringProvider;
/*    */ import javax.swing.table.TableColumn;
/*    */ import org.apache.commons.collections4.Transformer;
/*    */ 
/*    */ public class FormGridDataColumn extends TableColumn
/*    */   implements FormGridColumn
/*    */ {
/*    */   private String propertyName;
/*    */   private boolean editable;
/*    */   private Class<? extends Object> columnClass;
/*    */   private Transformer transformer;
/*    */ 
/*    */   public FormGridDataColumn(String modelProperty, Transformer transformer, boolean editable, Class<? extends Object> columnClass)
/*    */   {
/* 28 */     this.editable = editable;
/* 29 */     this.propertyName = modelProperty;
/* 30 */     this.transformer = transformer;
/* 31 */     this.columnClass = columnClass;
/* 32 */     setHeaderValue(StringProvider.getInstance()
/* 33 */       .getValueOf(modelProperty));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 40 */     return (String)getHeaderValue();
/*    */   }
/*    */ 
/*    */   public String getPropertyName()
/*    */   {
/* 47 */     return this.propertyName;
/*    */   }
/*    */ 
/*    */   public boolean isEditable()
/*    */   {
/* 55 */     return this.editable;
/*    */   }
/*    */ 
/*    */   public Object transform(DefaultFormGridModel.GridRow rowModel)
/*    */   {
/* 64 */     FormModel answer = rowModel.getProperty(this.propertyName);
/* 65 */     if (answer == null) {
/* 66 */       return null;
/*    */     }
/* 68 */     Object value = answer.getValue();
/* 69 */     return value;
/*    */   }
/*    */ 
/*    */   public Class<?> getColumnClass()
/*    */   {
/* 77 */     return this.columnClass;
/*    */   }
/*    */ 
/*    */   public void setValue(DefaultFormGridModel.GridRow rowModel, Object value) {
/* 81 */     if (this.editable) {
/* 82 */       ModelUtils.setNestedProperty(rowModel, this.propertyName, 
/* 83 */         this.transformer.transform(value));
/*    */ 
/* 86 */       rowModel.getValue();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridDataColumn
 * JD-Core Version:    0.6.0
 */