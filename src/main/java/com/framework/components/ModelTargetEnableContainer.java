package com.framework.components;

public abstract interface ModelTargetEnableContainer extends ModelEnableComponent, Component, TargetEnable
{
  public abstract void turnOff();

  public abstract ModelTargetEnableContainer getContainer();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.ModelTargetEnableContainer
 * JD-Core Version:    0.6.0
 */