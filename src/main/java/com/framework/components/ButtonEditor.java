/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.actions.AbstractAction;
/*    */ import java.awt.Component;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.DefaultCellEditor;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ public class ButtonEditor extends DefaultCellEditor
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   protected JButton button;
/*    */   private String label;
/*    */ 
/*    */   public ButtonEditor(JCheckBox checkBox, AbstractAction accion)
/*    */   {
/* 30 */     super(checkBox);
/* 31 */     this.button = accion;
/* 32 */     this.button.setOpaque(true);
/* 33 */     this.button.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 35 */         ButtonEditor.this.fireEditingStopped();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
/* 42 */     if (isSelected) {
/* 43 */       this.button.setForeground(table.getSelectionForeground());
/* 44 */       this.button.setBackground(table.getSelectionBackground());
/*    */     } else {
/* 46 */       this.button.setForeground(table.getForeground());
/* 47 */       this.button.setBackground(table.getBackground());
/*    */     }
/* 49 */     this.label = (value == null ? "" : value.toString());
/* 50 */     this.button.setText(this.label);
/* 51 */     return this.button;
/*    */   }
/*    */ 
/*    */   public Object getCellEditorValue() {
/* 55 */     return new String(this.label);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.ButtonEditor
 * JD-Core Version:    0.6.0
 */