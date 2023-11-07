package com.framework.components.builders.impl;

import com.framework.actions.AbstractFormAction;
import com.framework.components.builders.interfaces.FormComboBoxBuilder;
import com.framework.components.builders.interfaces.TableActionColumnBuilder;
import com.framework.components.builders.interfaces.TableColumnBuilder;
import org.apache.commons.collections4.Transformer;

public abstract interface FormGridBuilder
{
  public abstract TableColumnBuilder addColumn(String paramString);

  public abstract TableColumnBuilder addDateColumn(String paramString1, String paramString2);

  public abstract TableColumnBuilder addColumn(String paramString, Class paramClass);

  public abstract TableColumnBuilder addColumn(String paramString, Transformer paramTransformer);

  public abstract FormGridBuilder addRowSelector(String paramString);

  public abstract FormGridBuilder addSimpleRowSelectionMode(String paramString);

  public abstract TableActionColumnBuilder addRowAction(AbstractFormAction paramAbstractFormAction);

  public abstract FormGridBuilder setOneColumnGrid();

  public abstract FormGridBuilder addComponentDependency(FormComboBoxBuilder paramFormComboBoxBuilder);

  public abstract FormGridBuilder setRefresh(long paramLong);

  public abstract MessageBuilder setOnEmptyExceptionMessage(String paramString);
}
