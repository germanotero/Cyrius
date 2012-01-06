package com.framework.components.builders.interfaces;

import com.framework.actions.AbstractFormAction;
import javax.swing.Icon;

public abstract interface MenuBuilder
{
  public abstract MenuBuilder addSubMenu(String paramString);

  public abstract MenuBuilder addMenuItem(AbstractFormAction paramAbstractFormAction);

  public abstract MenuBuilder addMenuItem(AbstractFormAction paramAbstractFormAction, Icon paramIcon);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.MenuBuilder
 * JD-Core Version:    0.6.0
 */