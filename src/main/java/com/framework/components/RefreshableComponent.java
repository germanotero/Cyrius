package com.framework.components;

import com.framework.actions.FormAction;

public abstract interface RefreshableComponent extends ModelTargetEnableContainer
{
  public abstract void refreshComponent();

  public abstract void setCloseAction(FormAction paramFormAction);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.RefreshableComponent
 * JD-Core Version:    0.6.0
 */