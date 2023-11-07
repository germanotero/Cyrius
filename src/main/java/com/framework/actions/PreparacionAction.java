package com.framework.actions;

import com.framework.models.FormModel;
import java.awt.Dimension;

public class PreparacionAction extends AbstractFormAction

{
  protected void setUpAction()
  {
    setSize(new Dimension(50, 20));
  }

  protected void executeFormAction(FormModel model)
    throws Exception
  {
    throw new RuntimeException(
      "Unsupported operation Yet!!! under Construction");
  }

  protected boolean isImpactableModelAction()
  {
    return false;
  }

}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.PreparacionAction
 * JD-Core Version:    0.6.0
 */