package com.framework.components.builders.interfaces;

import java.util.Collection;

public abstract interface ElementsRegistry
{
  public abstract Collection getSimpleElements();

  public abstract Collection getRowElements();

  public abstract void add(FormComponentBuilder paramFormComponentBuilder);

  public abstract Collection getAllBuilders();

  public abstract void clear();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.ElementsRegistry
 * JD-Core Version:    0.6.0
 */