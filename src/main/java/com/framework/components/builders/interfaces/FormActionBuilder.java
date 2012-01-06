package com.framework.components.builders.interfaces;

import com.framework.actions.FinalizeUseCaseAction;
import com.framework.actions.FormAction;

public abstract interface FormActionBuilder
{
  public abstract FormAction addNavigateForwardAction();

  public abstract FormAction addNavigateForwardAction(String paramString);

  public abstract FinalizeUseCaseAction addFinalizeUseCaseAction();

  public abstract FormAction addNavigateBackAction();

  public abstract FormAction addNavigateBackAction(String paramString);

  public abstract FormAction addAction(FormAction paramFormAction);

  public abstract FormAction addCancelUseCaseAction();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.FormActionBuilder
 * JD-Core Version:    0.6.0
 */