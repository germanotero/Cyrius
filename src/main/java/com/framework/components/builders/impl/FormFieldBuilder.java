package com.framework.components.builders.impl;

import com.framework.components.builders.interfaces.FormComponentBuilder;
import org.apache.commons.collections.Predicate;

public abstract interface FormFieldBuilder
{
  public abstract void setDisableOn(Predicate paramPredicate);

  public abstract void setNotVisibleOn(Predicate paramPredicate);

  public abstract FormComponentBuilder required();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormFieldBuilder
 * JD-Core Version:    0.6.0
 */