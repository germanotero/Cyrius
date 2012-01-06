package com.framework.abstractfactorys;

import java.awt.Container;

public abstract interface FrameworkPanel
{
  public abstract void setDisableEnable(boolean paramBoolean);

  public abstract void initComponent();

  public abstract void addTab(String paramString, Container paramContainer);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FrameworkPanel
 * JD-Core Version:    0.6.0
 */