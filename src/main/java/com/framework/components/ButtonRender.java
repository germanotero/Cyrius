/*    */ package com.framework.components;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ 
/*    */ public class ButtonRender extends JButton
/*    */   implements TableCellRenderer
/*    */ {
/*    */   public ButtonRender()
/*    */   {
/* 17 */     setOpaque(true);
/* 18 */     initComponent();
/*    */   }
/*    */ 
/*    */   private void initComponent() {
/* 22 */     setHorizontalAlignment(0);
/*    */   }
/*    */ 
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 27 */     if (isSelected) {
/* 28 */       setForeground(table.getSelectionForeground());
/* 29 */       setBackground(table.getSelectionBackground());
/*    */     } else {
/* 31 */       setForeground(table.getForeground());
/* 32 */       setBackground(UIManager.getColor("Button.background"));
/*    */     }
/* 34 */     setText(value == null ? "" : value.toString());
/* 35 */     return this;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.ButtonRender
 * JD-Core Version:    0.6.0
 */