package com.framework.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public abstract interface Component
{
  public abstract void setBackground(Color paramColor);

  public abstract void setForeground(Color paramColor);

  public abstract void setVisible(boolean paramBoolean);

  public abstract void setLocation(int paramInt1, int paramInt2);

  public abstract void setEnabled(boolean paramBoolean);

  public abstract void setCursor(Cursor paramCursor);

  public abstract void setPreferredSize(Dimension paramDimension);

  public abstract void setMinimumSize(Dimension paramDimension);

  public abstract void refreshComponent();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.Component
 * JD-Core Version:    0.6.0
 */