/*   */ package com.framework.models;
/*   */ 
/*   */ import javax.swing.table.DefaultTableColumnModel;
/*   */ 
/*   */ public class DefaultFormGridColumnModel extends DefaultTableColumnModel
/*   */ {
/*   */   public FormGridColumn getColumna(int columnIndex)
/*   */   {
/* 8 */     return (FormGridColumn)getColumn(columnIndex);
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.DefaultFormGridColumnModel
 * JD-Core Version:    0.6.0
 */