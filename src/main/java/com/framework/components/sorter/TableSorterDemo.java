/*     */ package com.framework.components.sorter;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.JTableHeader;
/*     */ 
/*     */ public class TableSorterDemo extends JPanel
/*     */ {
/*  22 */   private boolean DEBUG = false;
/*     */ 
/*     */   public TableSorterDemo() {
/*  25 */     super(new GridLayout(1, 0));
/*     */ 
/*  27 */     TableSorter sorter = new TableSorter(new MyTableModel());
/*     */ 
/*  30 */     JTable table = new JTable(sorter);
/*  31 */     sorter.setTableHeader(table.getTableHeader());
/*  32 */     table.setPreferredScrollableViewportSize(new Dimension(500, 70));
/*     */ 
/*  35 */     table
/*  36 */       .getTableHeader()
/*  37 */       .setToolTipText(
/*  38 */       "Click to specify sorting; Control-Click to specify secondary sorting");
/*     */ 
/*  41 */     JScrollPane scrollPane = new JScrollPane(table);
/*     */ 
/*  44 */     add(scrollPane);
/*     */   }
/*     */ 
/*     */   private static void createAndShowGUI()
/*     */   {
/* 140 */     JFrame.setDefaultLookAndFeelDecorated(true);
/*     */ 
/* 143 */     JFrame frame = new JFrame("TableSorterDemo");
/* 144 */     frame.setDefaultCloseOperation(3);
/*     */ 
/* 147 */     TableSorterDemo newContentPane = new TableSorterDemo();
/* 148 */     newContentPane.setOpaque(true);
/* 149 */     frame.setContentPane(newContentPane);
/*     */ 
/* 152 */     frame.pack();
/* 153 */     frame.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   class MyTableModel extends AbstractTableModel
/*     */   {
/*  48 */     private String[] columnNames = { "First Name", "Last Name", "Sport", 
/*  49 */       "# of Years", "Vegetarian" };
/*     */ 
/*  51 */     private Object[][] data = { 
/*  52 */       { "Mary", "Campione", "Snowboarding", new Integer(5), 
/*  53 */       new Boolean(false) }, 
/*  54 */       { "Alison", "Huml", "Rowing", new Integer(3), new Boolean(true) }, 
/*  55 */       { "Kathy", "Walrath", "Knitting", new Integer(2), 
/*  56 */       new Boolean(false) }, 
/*  57 */       { "Sharon", "Zakhour", "Speed reading", new Integer(20), 
/*  58 */       new Boolean(true) }, 
/*  59 */       { "Philip", "Milne", "Pool", new Integer(10), 
/*  60 */       new Boolean(false) } };
/*     */ 
/*     */     MyTableModel()
/*     */     {
/*     */     }
/*     */ 
/*     */     public int getColumnCount()
/*     */     {
/*  63 */       return this.columnNames.length;
/*     */     }
/*     */ 
/*     */     public int getRowCount() {
/*  67 */       return this.data.length;
/*     */     }
/*     */ 
/*     */     public String getColumnName(int col) {
/*  71 */       return this.columnNames[col];
/*     */     }
/*     */ 
/*     */     public Object getValueAt(int row, int col) {
/*  75 */       return this.data[row][col];
/*     */     }
/*     */ 
/*     */     public Class getColumnClass(int c)
/*     */     {
/*  84 */       return getValueAt(0, c).getClass();
/*     */     }
/*     */ 
/*     */     public boolean isCellEditable(int row, int col)
/*     */     {
/*  94 */       return col >= 2;
/*     */     }
/*     */ 
/*     */     public void setValueAt(Object value, int row, int col)
/*     */     {
/* 104 */       if (TableSorterDemo.this.DEBUG) {
/* 105 */         System.out.println("Setting value at " + row + "," + col + 
/* 106 */           " to " + value + " (an instance of " + 
/* 107 */           value.getClass() + ")");
/*     */       }
/*     */ 
/* 110 */       this.data[row][col] = value;
/* 111 */       fireTableCellUpdated(row, col);
/*     */ 
/* 113 */       if (TableSorterDemo.this.DEBUG) {
/* 114 */         System.out.println("New value of data:");
/* 115 */         printDebugData();
/*     */       }
/*     */     }
/*     */ 
/*     */     private void printDebugData() {
/* 120 */       int numRows = getRowCount();
/* 121 */       int numCols = getColumnCount();
/*     */ 
/* 123 */       for (int i = 0; i < numRows; i++) {
/* 124 */         System.out.print("    row " + i + ":");
/* 125 */         for (int j = 0; j < numCols; j++) {
/* 126 */           System.out.print("  " + this.data[i][j]);
/*     */         }
/* 128 */         System.out.println();
/*     */       }
/* 130 */       System.out.println("--------------------------");
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.sorter.TableSorterDemo
 * JD-Core Version:    0.6.0
 */