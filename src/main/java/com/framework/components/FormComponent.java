package com.framework.components;

import org.apache.commons.collections.Predicate;

public abstract interface FormComponent extends Component
{
  public abstract FormComponent setNotVisibleOn(Predicate paramPredicate);

  public abstract FormComponent setDisableOn(Predicate paramPredicate);

  public abstract void initComponent();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormComponent
 * JD-Core Version:    0.6.0
 */