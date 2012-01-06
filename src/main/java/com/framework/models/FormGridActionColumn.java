/*    */ package com.framework.models;
/*    */ 
/*    */ import com.framework.actions.AbstractFormAction;
/*    */ import javax.swing.table.TableColumn;
/*    */ 
/*    */ public class FormGridActionColumn extends TableColumn
/*    */   implements FormGridColumn
/*    */ {
/*    */   private AbstractFormAction action;
/* 17 */   public static final Object IDENTIFIER = "actionColumn";
/*    */ 
/*    */   public FormGridActionColumn(AbstractFormAction action)
/*    */   {
/* 21 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 26 */     return "Accion";
/*    */   }
/*    */ 
/*    */   public Object getIdentifier()
/*    */   {
/* 31 */     return IDENTIFIER;
/*    */   }
/*    */ 
/*    */   public Object transform(DefaultFormGridModel.GridRow rowModel) {
/* 35 */     return this.action.getText();
/*    */   }
/*    */ 
/*    */   public boolean isEditable()
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */ 
/*    */   public Class<?> getColumnClass() {
/* 46 */     return String.class;
/*    */   }
/*    */ 
/*    */   public void setValue(DefaultFormGridModel.GridRow rowModel, Object value)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridActionColumn
 * JD-Core Version:    0.6.0
 */