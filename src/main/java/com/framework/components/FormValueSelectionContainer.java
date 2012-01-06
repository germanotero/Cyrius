package com.framework.components;

public abstract interface FormValueSelectionContainer extends FormModelContainer
{
  public abstract Object getValor();

  public abstract void setValue(Object paramObject);

  public abstract boolean isEmpty();

  public abstract void setFull();

  public abstract void setNotFull();

  public abstract boolean isVisible();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormValueSelectionContainer
 * JD-Core Version:    0.6.0
 */