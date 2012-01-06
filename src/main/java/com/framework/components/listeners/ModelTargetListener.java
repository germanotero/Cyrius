package com.framework.components.listeners;

import com.framework.models.FormModel;
import java.util.EventListener;

public abstract interface ModelTargetListener extends EventListener
{
  public abstract void load(FormModel paramFormModel);

  public abstract void unLoad(FormModel paramFormModel);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.ModelTargetListener
 * JD-Core Version:    0.6.0
 */