package com.framework.components.builders.interfaces;

import com.framework.components.FormComponent;
import com.framework.components.RefreshableComponent;
import com.framework.components.builders.impl.ConstraintsProvider;
import com.framework.components.builders.impl.FormBuilder;
import org.apache.commons.collections4.Predicate;

public abstract interface FormComponentBuilder
{
  public abstract FormComponent build();

  public abstract FormComponentBuilder withName(String paramString);

  public abstract FormComponentBuilder withModelProperty(String paramString);

  public abstract FormComponentBuilder withContainer(RefreshableComponent paramRefreshableComponent);

  public abstract boolean isRowComponent();

  public abstract void addTo(FormBuilder paramFormBuilder, int paramInt, ConstraintsProvider paramConstraintsProvider);

  public abstract void setDisableOn(Predicate paramPredicate);

  public abstract FormComponentBuilder required();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.FormComponentBuilder
 * JD-Core Version:    0.6.0
 */