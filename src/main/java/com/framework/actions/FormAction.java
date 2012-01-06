package com.framework.actions;

import com.framework.components.FormComponent;
import com.framework.components.ModelTargetEnableContainer;
import com.framework.models.FormModel;
import java.awt.event.ActionListener;

public abstract interface FormAction extends FormComponent
{
  public abstract void setText(String paramString);

  public abstract void addActionListener(ActionListener paramActionListener);

  public abstract void setParent(ModelTargetEnableContainer paramModelTargetEnableContainer);

  public abstract void setModelo(FormModel paramFormModel);

  public abstract void confirm(String paramString);

  public abstract void doClick();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.FormAction
 * JD-Core Version:    0.6.0
 */