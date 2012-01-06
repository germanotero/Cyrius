/*    */ package com.framework.models;
/*    */ 
/*    */ import javax.swing.table.TableColumn;
/*    */ 
/*    */ public class FormGridSelectionColumn extends TableColumn
/*    */   implements FormGridColumn
/*    */ {
/*    */   public boolean isEditable()
/*    */   {
/* 11 */     return true;
/*    */   }
/*    */ 
/*    */   public Object transform(DefaultFormGridModel.GridRow rowModel) {
/* 15 */     return rowModel.getSelected();
/*    */   }
/*    */ 
/*    */   public Object getIdentifier()
/*    */   {
/* 20 */     return "Seleccion";
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 25 */     return (String)getIdentifier();
/*    */   }
/*    */ 
/*    */   public Class<?> getColumnClass()
/*    */   {
/* 30 */     return Boolean.class;
/*    */   }
/*    */ 
/*    */   public void setValue(DefaultFormGridModel.GridRow rowModel, Object value) {
/* 34 */     Boolean val = (Boolean)value;
/* 35 */     rowModel.setSelected(val);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridSelectionColumn
 * JD-Core Version:    0.6.0
 */