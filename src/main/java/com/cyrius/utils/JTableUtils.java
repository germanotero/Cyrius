/*    */ package com.cyrius.utils;
/*    */ 
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ public class JTableUtils
/*    */ {
/*    */   public static int getRowOf(JTable table, Object o)
/*    */   {
/* 19 */     for (int col = 0; col < table.getColumnCount(); col++) {
/* 20 */       for (int row = 0; row < table.getRowCount(); row++)
/* 21 */         if ((table.getValueAt(row, col) != null) && 
/* 22 */           (table.getValueAt(row, col).equals(o)))
/* 23 */           return row;
/*    */     }
/* 25 */     throw new RuntimeException("El objeto buscado no existe en la tabla.");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.JTableUtils
 * JD-Core Version:    0.6.0
 */