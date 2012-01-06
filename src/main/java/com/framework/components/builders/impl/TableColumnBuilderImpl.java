package com.framework.components.builders.impl;

import com.framework.components.FormGrid;
import com.framework.models.FormGridModel;

public abstract interface TableColumnBuilderImpl
{
  public abstract void build(FormGridModel paramFormGridModel);

  public abstract void initColumns(FormGrid paramFormGrid);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.TableColumnBuilderImpl
 * JD-Core Version:    0.6.0
 */