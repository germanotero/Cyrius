package com.framework.components;

import java.awt.Component;
import java.awt.LayoutManager;

public abstract interface ModelEnableElementsContainer extends RefreshableComponent
{
  public abstract void addElement(FormComponent paramFormComponent, Object paramObject);

  public abstract void addElement(Component paramComponent, Object paramObject);

  public abstract void setLayout(LayoutManager paramLayoutManager);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.ModelEnableElementsContainer
 * JD-Core Version:    0.6.0
 */