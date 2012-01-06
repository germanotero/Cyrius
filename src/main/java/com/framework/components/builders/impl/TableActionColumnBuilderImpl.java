/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.actions.AbstractFormAction;
/*    */ import com.framework.components.ButtonEditor;
/*    */ import com.framework.components.ButtonRender;
/*    */ import com.framework.components.FormGrid;
/*    */ import com.framework.components.builders.interfaces.TableActionColumnBuilder;
/*    */ import com.framework.models.FormGridActionColumn;
/*    */ import com.framework.models.FormGridModel;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.table.TableColumn;
/*    */ 
/*    */ public class TableActionColumnBuilderImpl
/*    */   implements TableActionColumnBuilder, TableColumnBuilderImpl
/*    */ {
/*    */   private int preferedSize;
/*    */   private AbstractFormAction action;
/*    */ 
/*    */   public void setAction(AbstractFormAction accion)
/*    */   {
/* 30 */     this.action = accion;
/*    */   }
/*    */ 
/*    */   public void setEditable(boolean editable) {
/* 34 */     throw new RuntimeException(
/* 35 */       "Las columnas de accion son siempre editables, no tiene sentido modificar este valor. columna: " + 
/* 36 */       this.action.getName());
/*    */   }
/*    */ 
/*    */   public void setPreferedSize(int prefered)
/*    */   {
/* 43 */     this.preferedSize = prefered;
/*    */   }
/*    */ 
/*    */   public void build(FormGridModel gridModel) {
/* 47 */     FormGridActionColumn column = new FormGridActionColumn(this.action);
/* 48 */     if (this.preferedSize > 0) {
/* 49 */       column.setPreferredWidth(this.preferedSize);
/* 50 */       column.setWidth(this.preferedSize);
/*    */     }
/* 52 */     gridModel.addColumn(column);
/*    */   }
/*    */ 
/*    */   public boolean hasActions() {
/* 56 */     return true;
/*    */   }
/*    */ 
/*    */   public void initColumns(FormGrid grid) {
/* 60 */     TableColumn column = grid.getActionsColumn();
/* 61 */     this.action.setParent(grid);
/* 62 */     this.action.initComponent();
/* 63 */     column.setCellRenderer(new ButtonRender());
/* 64 */     column.setPreferredWidth(this.preferedSize);
/* 65 */     column.setCellEditor(new ButtonEditor(new JCheckBox(), this.action));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.TableActionColumnBuilderImpl
 * JD-Core Version:    0.6.0
 */