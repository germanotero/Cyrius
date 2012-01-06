package com.framework.models;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public abstract interface FormGridColumn
{
  public abstract boolean isEditable();

  public abstract Object transform(DefaultFormGridModel.GridRow paramGridRow);

  public abstract void setValue(DefaultFormGridModel.GridRow paramGridRow, Object paramObject);

  public abstract Class<?> getColumnClass();

  public abstract void setCellRenderer(TableCellRenderer paramTableCellRenderer);

  public abstract void setCellEditor(TableCellEditor paramTableCellEditor);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridColumn
 * JD-Core Version:    0.6.0
 */