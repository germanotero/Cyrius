/*     */ package com.framework.components.sorter;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.JTableHeader;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ 
/*     */ public class TableSorter extends AbstractTableModel
/*     */ {
/*     */   protected TableModel tableModel;
/*     */   public static final int DESCENDING = -1;
/*     */   public static final int NOT_SORTED = 0;
/*     */   public static final int ASCENDING = 1;
/*  78 */   private static Directive EMPTY_DIRECTIVE = new Directive(-1, 0);
/*     */ 
/*  80 */   public static final Comparator COMPARABLE_COMAPRATOR = new Comparator() {
/*     */     public int compare(Object o1, Object o2) {
/*  82 */       return ((Comparable)o1).compareTo(o2);
/*     */     }
/*  80 */   };
/*     */ 
/*  86 */   public static final Comparator LEXICAL_COMPARATOR = new Comparator() {
/*     */     public int compare(Object o1, Object o2) {
/*  88 */       return o1.toString().compareTo(o2.toString());
/*     */     }
/*  86 */   };
/*     */   private Row[] viewToModel;
/*     */   private int[] modelToView;
/*     */   private JTableHeader tableHeader;
/*     */   private MouseListener mouseListener;
/*     */   private TableModelListener tableModelListener;
/* 102 */   private Map columnComparators = new HashMap();
/*     */ 
/* 104 */   private List sortingColumns = new ArrayList();
/*     */ 
/*     */   public TableSorter() {
/* 107 */     this.mouseListener = new MouseHandler();
/* 108 */     this.tableModelListener = new TableModelHandler();
/* 109 */     setSortingStatus(0, 1);
/*     */   }
/*     */ 
/*     */   public TableSorter(TableModel tableModel) {
/* 113 */     this();
/* 114 */     setTableModel(tableModel);
/*     */   }
/*     */ 
/*     */   public TableSorter(TableModel tableModel, JTableHeader tableHeader) {
/* 118 */     this();
/* 119 */     setTableHeader(tableHeader);
/* 120 */     setTableModel(tableModel);
/*     */   }
/*     */ 
/*     */   private void clearSortingState() {
/* 124 */     this.viewToModel = null;
/* 125 */     this.modelToView = null;
/*     */   }
/*     */ 
/*     */   public TableModel getTableModel() {
/* 129 */     return this.tableModel;
/*     */   }
/*     */ 
/*     */   public void setTableModel(TableModel tableModel) {
/* 133 */     if (this.tableModel != null) {
/* 134 */       this.tableModel.removeTableModelListener(this.tableModelListener);
/*     */     }
/*     */ 
/* 137 */     this.tableModel = tableModel;
/* 138 */     if (this.tableModel != null) {
/* 139 */       this.tableModel.addTableModelListener(this.tableModelListener);
/*     */     }
/*     */ 
/* 142 */     clearSortingState();
/* 143 */     fireTableStructureChanged();
/*     */   }
/*     */ 
/*     */   public JTableHeader getTableHeader() {
/* 147 */     return this.tableHeader;
/*     */   }
/*     */ 
/*     */   public void setTableHeader(JTableHeader tableHeader) {
/* 151 */     if (this.tableHeader != null) {
/* 152 */       this.tableHeader.removeMouseListener(this.mouseListener);
/* 153 */       TableCellRenderer defaultRenderer = this.tableHeader
/* 154 */         .getDefaultRenderer();
/* 155 */       if ((defaultRenderer instanceof SortableHeaderRenderer)) {
/* 156 */         this.tableHeader
/* 157 */           .setDefaultRenderer(((SortableHeaderRenderer)defaultRenderer).tableCellRenderer);
/*     */       }
/*     */     }
/* 160 */     this.tableHeader = tableHeader;
/* 161 */     if (this.tableHeader != null) {
/* 162 */       this.tableHeader.addMouseListener(this.mouseListener);
/* 163 */       this.tableHeader.setDefaultRenderer(
/* 164 */         new SortableHeaderRenderer(this.tableHeader.getDefaultRenderer()));
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isSorting() {
/* 169 */     return this.sortingColumns.size() != 0;
/*     */   }
/*     */ 
/*     */   private Directive getDirective(int column) {
/* 173 */     for (int i = 0; i < this.sortingColumns.size(); i++) {
/* 174 */       Directive directive = (Directive)this.sortingColumns.get(i);
/* 175 */       if (directive.column == column) {
/* 176 */         return directive;
/*     */       }
/*     */     }
/* 179 */     return EMPTY_DIRECTIVE;
/*     */   }
/*     */ 
/*     */   public int getSortingStatus(int column) {
/* 183 */     return getDirective(column).direction;
/*     */   }
/*     */ 
/*     */   private void sortingStatusChanged() {
/* 187 */     clearSortingState();
/* 188 */     fireTableDataChanged();
/* 189 */     if (this.tableHeader != null)
/* 190 */       this.tableHeader.repaint();
/*     */   }
/*     */ 
/*     */   public void setSortingStatus(int column, int status)
/*     */   {
/* 195 */     Directive directive = getDirective(column);
/* 196 */     if (directive != EMPTY_DIRECTIVE) {
/* 197 */       this.sortingColumns.remove(directive);
/*     */     }
/* 199 */     if (status != 0) {
/* 200 */       this.sortingColumns.add(new Directive(column, status));
/*     */     }
/* 202 */     sortingStatusChanged();
/*     */   }
/*     */ 
/*     */   protected Icon getHeaderRendererIcon(int column, int size) {
/* 206 */     Directive directive = getDirective(column);
/* 207 */     if (directive == EMPTY_DIRECTIVE) {
/* 208 */       return null;
/*     */     }
/* 210 */     return new Arrow(directive.direction == -1, size, 
/* 211 */       this.sortingColumns.indexOf(directive));
/*     */   }
/*     */ 
/*     */   private void cancelSorting() {
/* 215 */     this.sortingColumns.clear();
/* 216 */     sortingStatusChanged();
/*     */   }
/*     */ 
/*     */   public void setColumnComparator(Class type, Comparator comparator) {
/* 220 */     if (comparator == null)
/* 221 */       this.columnComparators.remove(type);
/*     */     else
/* 223 */       this.columnComparators.put(type, comparator);
/*     */   }
/*     */ 
/*     */   protected Comparator getComparator(int column)
/*     */   {
/* 228 */     Class columnType = this.tableModel.getColumnClass(column);
/* 229 */     Comparator comparator = (Comparator)(Comparator)this.columnComparators.get(columnType);
/* 230 */     if (comparator != null) {
/* 231 */       return comparator;
/*     */     }
/* 233 */     if (Comparable.class.isAssignableFrom(columnType)) {
/* 234 */       return COMPARABLE_COMAPRATOR;
/*     */     }
/* 236 */     return LEXICAL_COMPARATOR;
/*     */   }
/*     */ 
/*     */   private Row[] getViewToModel() {
/* 240 */     if (this.viewToModel == null) {
/* 241 */       int tableModelRowCount = this.tableModel.getRowCount();
/* 242 */       this.viewToModel = new Row[tableModelRowCount];
/* 243 */       for (int row = 0; row < tableModelRowCount; row++) {
/* 244 */         this.viewToModel[row] = new Row(row);
/*     */       }
/*     */ 
/* 247 */       if (isSorting()) {
/* 248 */         Arrays.sort(this.viewToModel);
/*     */       }
/*     */     }
/* 251 */     return this.viewToModel;
/*     */   }
/*     */ 
/*     */   public int modelIndex(int viewIndex) {
/* 255 */     return getViewToModel()[viewIndex].modelIndex;
/*     */   }
/*     */ 
/*     */   private int[] getModelToView() {
/* 259 */     if (this.modelToView == null) {
/* 260 */       int n = getViewToModel().length;
/* 261 */       this.modelToView = new int[n];
/* 262 */       for (int i = 0; i < n; i++) {
/* 263 */         this.modelToView[modelIndex(i)] = i;
/*     */       }
/*     */     }
/* 266 */     return this.modelToView;
/*     */   }
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/* 272 */     return this.tableModel == null ? 0 : this.tableModel.getRowCount();
/*     */   }
/*     */ 
/*     */   public int getColumnCount() {
/* 276 */     return this.tableModel == null ? 0 : this.tableModel.getColumnCount();
/*     */   }
/*     */ 
/*     */   public String getColumnName(int column) {
/* 280 */     return this.tableModel.getColumnName(column);
/*     */   }
/*     */ 
/*     */   public Class getColumnClass(int column) {
/* 284 */     return this.tableModel.getColumnClass(column);
/*     */   }
/*     */ 
/*     */   public boolean isCellEditable(int row, int column) {
/* 288 */     return this.tableModel.isCellEditable(modelIndex(row), column);
/*     */   }
/*     */ 
/*     */   public Object getValueAt(int row, int column) {
/* 292 */     return this.tableModel.getValueAt(modelIndex(row), column);
/*     */   }
/*     */ 
/*     */   public void setValueAt(Object aValue, int row, int column) {
/* 296 */     this.tableModel.setValueAt(aValue, modelIndex(row), column);
/*     */   }
/*     */ 
/*     */   public class Row implements Comparable
/*     */   {
/*     */     private int modelIndex;
/*     */ 
/*     */     public Row(int index) {
/* 305 */       this.modelIndex = index;
/*     */     }
/*     */ 
/*     */     public int compareTo(Object o) {
/* 309 */       int row1 = this.modelIndex;
/* 310 */       int row2 = ((Row)o).modelIndex;
/*     */ 
/* 312 */       for (Iterator it = TableSorter.this.sortingColumns.iterator(); it.hasNext(); ) {
/* 313 */         TableSorter.Directive directive = (TableSorter.Directive)it.next();
/* 314 */         int column = directive.column;
/* 315 */         Object o1 = TableSorter.this.tableModel.getValueAt(row1, column);
/* 316 */         Object o2 = TableSorter.this.tableModel.getValueAt(row2, column);
/*     */ 
/* 318 */         int comparison = 0;
/*     */ 
/* 320 */         if ((o1 == null) && (o2 == null))
/* 321 */           comparison = 0;
/* 322 */         else if (o1 == null)
/* 323 */           comparison = -1;
/* 324 */         else if (o2 == null)
/* 325 */           comparison = 1;
/*     */         else {
/* 327 */           comparison = TableSorter.this.getComparator(column).compare(o1, o2);
/*     */         }
/* 329 */         if (comparison != 0) {
/* 330 */           return directive.direction == -1 ? -comparison : 
/* 331 */             comparison;
/*     */         }
/*     */       }
/* 334 */       return 0;
/*     */     }
/*     */   }
/*     */   private class TableModelHandler implements TableModelListener {
/*     */     private TableModelHandler() {
/*     */     }
/*     */ 
/*     */     public void tableChanged(TableModelEvent e) {
/* 341 */       if (!TableSorter.this.isSorting()) {
/* 342 */         TableSorter.this.clearSortingState();
/* 343 */         TableSorter.this.fireTableChanged(e);
/* 344 */         return;
/*     */       }
/*     */ 
/* 350 */       if (e.getFirstRow() == -1) {
/* 351 */         TableSorter.this.cancelSorting();
/* 352 */         TableSorter.this.fireTableChanged(e);
/* 353 */         return;
/*     */       }
/*     */ 
/* 380 */       int column = e.getColumn();
/* 381 */       if ((e.getFirstRow() == e.getLastRow()) && 
/* 382 */         (column != -1) && 
/* 383 */         (TableSorter.this.getSortingStatus(column) == 0) && 
/* 384 */         (TableSorter.this.modelToView != null)) {
/* 385 */         int viewIndex = TableSorter.this.getModelToView()[e.getFirstRow()];
/* 386 */         TableSorter.this
/* 387 */           .fireTableChanged(new TableModelEvent(TableSorter.this, 
/* 387 */           viewIndex, viewIndex, column, e.getType()));
/* 388 */         return;
/*     */       }
/*     */ 
/* 393 */       TableSorter.this.clearSortingState();
/* 394 */       TableSorter.this.fireTableDataChanged();
/*     */     }
/*     */   }
/*     */   private class MouseHandler extends MouseAdapter {
/*     */     private MouseHandler() {
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/* 401 */       JTableHeader h = (JTableHeader)e.getSource();
/* 402 */       TableColumnModel columnModel = h.getColumnModel();
/* 403 */       int viewColumn = columnModel.getColumnIndexAtX(e.getX());
/* 404 */       int column = columnModel.getColumn(viewColumn).getModelIndex();
/* 405 */       if (column != -1) {
/* 406 */         int status = TableSorter.this.getSortingStatus(column);
/* 407 */         if (!e.isControlDown()) {
/* 408 */           TableSorter.this.cancelSorting();
/*     */         }
/*     */ 
/* 414 */         status += (e.isShiftDown() ? -1 : 1);
/* 415 */         status = (status + 4) % 3 - 1;
/*     */ 
/* 417 */         TableSorter.this.setSortingStatus(column, status);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class Arrow implements Icon {
/*     */     private boolean descending;
/*     */     private int size;
/*     */     private int priority;
/*     */ 
/*     */     public Arrow(boolean descending, int size, int priority) {
/* 430 */       this.descending = descending;
/* 431 */       this.size = size;
/* 432 */       this.priority = priority;
/*     */     }
/*     */ 
/*     */     public void paintIcon(Component c, Graphics g, int x, int y) {
/* 436 */       Color color = c == null ? Color.GRAY : c.getBackground();
/*     */ 
/* 439 */       int dx = (int)(this.size / 2 * Math.pow(0.8D, this.priority));
/* 440 */       int dy = this.descending ? dx : -dx;
/*     */ 
/* 442 */       y = y + 5 * this.size / 6 + (this.descending ? -dy : 0);
/* 443 */       int shift = this.descending ? 1 : -1;
/* 444 */       g.translate(x, y);
/*     */ 
/* 447 */       g.setColor(color.darker());
/* 448 */       g.drawLine(dx / 2, dy, 0, 0);
/* 449 */       g.drawLine(dx / 2, dy + shift, 0, shift);
/*     */ 
/* 452 */       g.setColor(color.brighter());
/* 453 */       g.drawLine(dx / 2, dy, dx, 0);
/* 454 */       g.drawLine(dx / 2, dy + shift, dx, shift);
/*     */ 
/* 457 */       if (this.descending)
/* 458 */         g.setColor(color.darker().darker());
/*     */       else {
/* 460 */         g.setColor(color.brighter().brighter());
/*     */       }
/* 462 */       g.drawLine(dx, 0, 0, 0);
/*     */ 
/* 464 */       g.setColor(color);
/* 465 */       g.translate(-x, -y);
/*     */     }
/*     */ 
/*     */     public int getIconWidth() {
/* 469 */       return this.size;
/*     */     }
/*     */ 
/*     */     public int getIconHeight() {
/* 473 */       return this.size;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class SortableHeaderRenderer implements TableCellRenderer {
/*     */     private TableCellRenderer tableCellRenderer;
/*     */ 
/*     */     public SortableHeaderRenderer(TableCellRenderer tableCellRenderer) {
/* 481 */       this.tableCellRenderer = tableCellRenderer;
/*     */     }
/*     */ 
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*     */     {
/* 487 */       Component c = this.tableCellRenderer.getTableCellRendererComponent(
/* 488 */         table, value, isSelected, hasFocus, row, column);
/* 489 */       if ((c instanceof JLabel)) {
/* 490 */         JLabel l = (JLabel)c;
/* 491 */         l.setHorizontalTextPosition(2);
/* 492 */         int modelColumn = table.convertColumnIndexToModel(column);
/* 493 */         l.setIcon(TableSorter.this
/* 494 */           .getHeaderRendererIcon(modelColumn, 
/* 494 */           l.getFont().getSize()));
/*     */       }
/* 496 */       return c;
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class Directive {
/*     */     private int column;
/*     */     private int direction;
/*     */ 
/*     */     public Directive(int column, int direction) {
/* 506 */       this.column = column;
/* 507 */       this.direction = direction;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.sorter.TableSorter
 * JD-Core Version:    0.6.0
 */