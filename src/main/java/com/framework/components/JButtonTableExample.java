/*    */ package com.framework.components;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableModel;
/*    */ 
/*    */ public class JButtonTableExample extends JFrame
/*    */ {
/*    */   public JButtonTableExample()
/*    */   {
/* 20 */     super("JButtonTable Example");
/*    */ 
/* 22 */     DefaultTableModel dm = new DefaultTableModel();
/* 23 */     dm.setDataVector(new Object[][] { { "button 1", "foo" }, 
/* 24 */       { "button 2", "bar" } }, new Object[] { "Button", "String" });
/*    */ 
/* 26 */     JTable table = new JTable(dm);
/*    */ 
/* 30 */     JScrollPane scroll = new JScrollPane(table);
/* 31 */     getContentPane().add(scroll);
/* 32 */     setSize(400, 100);
/* 33 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 37 */     JButtonTableExample frame = new JButtonTableExample();
/* 38 */     frame.addWindowListener(new WindowAdapter() {
/*    */       public void windowClosing(WindowEvent e) {
/* 40 */         System.exit(0);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.JButtonTableExample
 * JD-Core Version:    0.6.0
 */