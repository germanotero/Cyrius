package com.framework.components;

import com.framework.actions.FormDataComponent;
import com.framework.components.listeners.ModelTargetListener;
import java.awt.event.ItemListener;

public abstract interface FormCombo extends FormDataComponent
{
  public abstract void addItemListener(ItemListener paramItemListener);

  public abstract void addModelTargetListener(ModelTargetListener paramModelTargetListener);

  public abstract void addComboRestriction(Combo paramCombo, String paramString);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormCombo
 * JD-Core Version:    0.6.0
 */