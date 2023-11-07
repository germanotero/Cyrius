/*     */ package com.framework.models;
/*     */ 
/*     */ import com.framework.components.FormGrid;
/*     */ import com.framework.components.builders.impl.I18nMessageBuilderImpl;
/*     */ import com.framework.entities.FormModelDecorator;
/*     */ import com.framework.entities.FormModelUtils;
/*     */ import com.framework.persistence.PresentationException;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.ExtraCollectionUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.table.TableModel;

import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ public class DefaultFormGridModel
/*     */   implements TableModel, FormGridModel
/*     */ {
/*  28 */   private List rows = CollectionFactory.createList(Object.class);
/*     */ 
/*  31 */   private List<FormGridColumn> columns = CollectionFactory.createList(FormGridColumn.class);
/*     */ 
/*  33 */   private EventListenerList events = new EventListenerList();
/*     */   private FormGrid grid;
/*     */   private I18nMessageBuilderImpl exceptionMessageBuilder;
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  43 */     return this.rows.size();
/*     */   }
/*     */ 
/*     */   public int getColumnCount()
/*     */   {
/*  50 */     return this.columns.size();
/*     */   }
/*     */ 
/*     */   public String getColumnName(int columnIndex)
/*     */   {
/*  57 */     return ((FormGridColumn)this.columns.get(columnIndex)).toString();
/*     */   }
/*     */ 
/*     */   public Class<?> getColumnClass(int columnIndex)
/*     */   {
/*  64 */     return ((FormGridColumn)this.columns.get(columnIndex)).getColumnClass();
/*     */   }
/*     */ 
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */   {
/*  71 */     return ((FormGridColumn)this.columns.get(columnIndex)).isEditable();
/*     */   }
/*     */ 
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/*  79 */     return ((FormGridColumn)this.columns.get(columnIndex)).transform((GridRow)this.rows.get(rowIndex));
/*     */   }
/*     */ 
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
/*     */   {
/*  87 */     if (aValue != null) {
/*  88 */       FormGridColumn column = (FormGridColumn)this.columns.get(columnIndex);
/*  89 */       column.setValue((GridRow)this.rows.get(rowIndex), aValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addTableModelListener(TableModelListener l)
/*     */   {
/*  98 */     this.events.add(TableModelListener.class, l);
/*     */   }
/*     */ 
/*     */   public void removeTableModelListener(TableModelListener l)
/*     */   {
/* 106 */     this.events.remove(TableModelListener.class, l);
/*     */   }
/*     */ 
/*     */   public void setValues(Collection newRows)
/*     */   {
/* 114 */     this.rows.clear();
/* 115 */     if (newRows == null) {
/* 116 */       return;
/*     */     }
/* 118 */     addRows(newRows);
/* 119 */     fireTableDataChanged();
/* 120 */     this.grid.fireTableDataChange();
/*     */   }
/*     */ 
/*     */   public void addRows(Collection newRows) {
/* 124 */     int i = 0;
/* 125 */     for (Iterator iter = newRows.iterator(); iter.hasNext(); ) {
/* 126 */       Object element = iter.next();
/* 127 */       this.rows.add(new GridRow(element, i++));
/*     */     }
/*     */   }
/*     */ 
/*     */   public FormModel getSelectedValue()
/*     */   {
/* 136 */     int selectedIndex = this.grid.getSelectedRowIndex();
/* 137 */     if (selectedIndex > -1) {
/* 138 */       GridRow gridRow = (GridRow)this.rows.get(selectedIndex);
/* 139 */       return FormModelUtils.wrap(gridRow.getValue());
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   public FormModel getModel()
/*     */   {
/* 148 */     return FormModelUtils.wrap(getRowValues(this.rows));
/*     */   }
/*     */ 
/*     */   public void setGrid(FormGrid grid)
/*     */   {
/* 156 */     this.grid = grid;
/*     */   }
/*     */ 
/*     */   public void addColumn(FormGridColumn column)
/*     */   {
/* 164 */     this.columns.add(column);
/*     */   }
/*     */ 
/*     */   public void fireTableDataChanged()
/*     */   {
/* 182 */     fireTableChanged(new TableModelEvent(this));
/*     */   }
/*     */ 
/*     */   public void fireTableChanged(TableModelEvent e)
/*     */   {
/* 199 */     Object[] listeners = this.events.getListenerList();
/*     */ 
/* 202 */     for (int i = listeners.length - 2; i >= 0; i -= 2)
/* 203 */       if (listeners[i] == TableModelListener.class)
/* 204 */         ((TableModelListener)listeners[(i + 1)]).tableChanged(e);
/*     */   }
/*     */ 
/*     */   public void fireTableStructureChanged()
/*     */   {
/* 223 */     fireTableChanged(new TableModelEvent(this, -1));
/*     */   }
/*     */ 
/*     */   public Collection getSelectedValues()
/*     */   {
/* 264 */     Collection selecteds = CollectionUtils.select(this.rows, 
/* 265 */       new Predicate()
/*     */     {
/*     */       public boolean evaluate(Object arg0) {
/* 268 */         DefaultFormGridModel.GridRow row = (DefaultFormGridModel.GridRow)arg0;
/* 269 */         return row.getSelected().booleanValue();
/*     */       }
/*     */     });
/* 273 */     return getRowValues(selecteds);
/*     */   }
/*     */ 
/*     */   public void setSelectedValues(Collection seleccionados) {
/* 277 */     for (Iterator iter = seleccionados.iterator(); iter.hasNext(); ) {
/* 278 */       Object element = iter.next();
/* 279 */       GridRowDecorePredicate gridRowDecorePredicate = new GridRowDecorePredicate(
/* 280 */         element);
/*     */ 
/* 281 */       if (!CollectionUtils.exists(this.rows, gridRowDecorePredicate)) {
/* 282 */         addRows(CollectionFactory.createCollectionWith(element));
/*     */       }
/* 284 */       GridRow row = (GridRow)CollectionUtils.find(this.rows, 
/* 285 */         gridRowDecorePredicate);
/* 286 */       if (row != null)
/* 287 */         row.setSelected(Boolean.valueOf(true));
/*     */     }
/*     */   }
/*     */ 
/*     */   private Collection getRowValues(Collection rows)
/*     */   {
/* 293 */     return CollectionUtils.collect(rows, new Transformer()
/*     */     {
/*     */       public Object transform(Object arg0) {
/* 296 */         DefaultFormGridModel.GridRow row = (DefaultFormGridModel.GridRow)arg0;
/* 297 */         return row.getValue();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void refresh() {
/* 304 */     if ((this.rows.isEmpty()) && (this.exceptionMessageBuilder != null)) {
/* 305 */       this.exceptionMessageBuilder.setModel(this.grid.getModelo());
/* 306 */       throw new PresentationException(this.exceptionMessageBuilder)
/* 307 */         .setMessageType(2);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setEmptyValuesMessage(I18nMessageBuilderImpl exceptionMessageBuilder)
/*     */   {
/* 313 */     this.exceptionMessageBuilder = exceptionMessageBuilder;
/*     */   }
/*     */ 
/*     */   private final class GridRowDecorePredicate
/*     */     implements Predicate
/*     */   {
/*     */     private final Object element;
/*     */ 
/*     */     private GridRowDecorePredicate(Object element)
/*     */     {
/* 231 */       this.element = element;
/*     */     }
/*     */ 
/*     */     public boolean evaluate(Object arg0) {
/* 235 */       DefaultFormGridModel.GridRow row = (DefaultFormGridModel.GridRow)arg0;
/* 236 */       return row.getValue().equals(this.element);
/*     */     }
/*     */   }
/*     */ 
/* 241 */   public final class GridRow extends FormModelDecorator { private Boolean selected = Boolean.FALSE;
/*     */     private int index;
/*     */ 
/*     */     public GridRow(Object value, int index) {
/* 246 */       super(value);
/* 247 */       this.index = index;
/*     */     }
/*     */ 
/*     */     public Boolean getSelected() {
/* 251 */       return this.selected;
/*     */     }
/*     */ 
/*     */     public void setSelected(Boolean b) {
/* 255 */       if (b.booleanValue())
/* 256 */         DefaultFormGridModel.this.grid.setSelectedIndex(this.index);
/* 257 */       this.selected = b;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.DefaultFormGridModel
 * JD-Core Version:    0.6.0
 */