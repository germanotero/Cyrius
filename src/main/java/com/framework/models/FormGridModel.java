package com.framework.models;

import com.framework.components.FormGrid;
import java.util.Collection;
import javax.swing.table.TableModel;

public abstract interface FormGridModel extends TableModel
{
  public abstract void setValues(Collection paramCollection);

  public abstract FormModel getSelectedValue();

  public abstract FormModel getModel();

  public abstract void setGrid(FormGrid paramFormGrid);

  public abstract void addColumn(FormGridColumn paramFormGridColumn);

  public abstract Collection getSelectedValues();

  public abstract void setSelectedValues(Collection paramCollection);

  public abstract void refresh();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormGridModel
 * JD-Core Version:    0.6.0
 */