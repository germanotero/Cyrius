/*    */ package com.framework.components.sorter;
/*    */ 
/*    */ import javax.swing.event.TableModelEvent;
/*    */ import javax.swing.event.TableModelListener;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ public class TableMap extends AbstractTableModel
/*    */   implements TableModelListener
/*    */ {
/*    */   protected TableModel model;
/*    */ 
/*    */   public TableModel getModel()
/*    */   {
/* 30 */     return this.model;
/*    */   }
/*    */ 
/*    */   public void setModel(TableModel model) {
/* 34 */     this.model = model;
/* 35 */     model.addTableModelListener(this);
/*    */   }
/*    */ 
/*    */   public Object getValueAt(int aRow, int aColumn)
/*    */   {
/* 42 */     return this.model.getValueAt(aRow, aColumn);
/*    */   }
/*    */ 
/*    */   public void setValueAt(Object aValue, int aRow, int aColumn) {
/* 46 */     this.model.setValueAt(aValue, aRow, aColumn);
/*    */   }
/*    */ 
/*    */   public int getRowCount() {
/* 50 */     return this.model == null ? 0 : this.model.getRowCount();
/*    */   }
/*    */ 
/*    */   public int getColumnCount() {
/* 54 */     return this.model == null ? 0 : this.model.getColumnCount();
/*    */   }
/*    */ 
/*    */   public String getColumnName(int aColumn) {
/* 58 */     return this.model.getColumnName(aColumn);
/*    */   }
/*    */ 
/*    */   public Class getColumnClass(int aColumn) {
/* 62 */     return this.model.getColumnClass(aColumn);
/*    */   }
/*    */ 
/*    */   public boolean isCellEditable(int row, int column) {
/* 66 */     return this.model.isCellEditable(row, column);
/*    */   }
/*    */ 
/*    */   public void tableChanged(TableModelEvent e)
/*    */   {
/* 74 */     fireTableChanged(e);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.sorter.TableMap
 * JD-Core Version:    0.6.0
 */