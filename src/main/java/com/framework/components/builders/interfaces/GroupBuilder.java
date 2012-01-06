package com.framework.components.builders.interfaces;

public abstract interface GroupBuilder extends FormElementsBuilder, FormComponentBuilder
{
  public abstract void setNotOneColumnComponent();

  public abstract GroupBuilder withModelClass(Class paramClass);

  public abstract void withOutBorder();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.GroupBuilder
 * JD-Core Version:    0.6.0
 */