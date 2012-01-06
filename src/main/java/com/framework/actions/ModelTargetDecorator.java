package com.framework.actions;

import com.framework.models.FormModel;

public abstract interface ModelTargetDecorator
{
  public abstract FormModel getModel(FormModel paramFormModel);

  public abstract void returning(FormModel paramFormModel);

  public abstract void failReturning();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.ModelTargetDecorator
 * JD-Core Version:    0.6.0
 */