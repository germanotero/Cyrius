package com.framework.components.builders.interfaces;

import com.framework.abstractfactorys.AbstractGroup;
import com.framework.components.RowComponent;

public abstract interface MultiplicableGroupElementBuilder extends FormElementsBuilder
{
  public abstract GroupBuilder addGroup(Class<AbstractGroup> paramClass, int paramInt);

  public abstract RowComponent addRowComponent(RowComponent paramRowComponent);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.MultiplicableGroupElementBuilder
 * JD-Core Version:    0.6.0
 */