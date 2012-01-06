package com.framework.factorys;

import com.framework.components.Component;
import com.framework.components.RefreshableComponent;
import com.framework.components.builders.interfaces.FormActionBuilder;
import com.framework.components.builders.interfaces.FormElementsBuilder;
import com.framework.models.FormModel;

public abstract interface CyriusForm extends Component
{
  public abstract FormModel getModelo();

  public abstract void registerElements(FormElementsBuilder paramFormElementsBuilder);

  public abstract void registerActions(FormActionBuilder paramFormActionBuilder);

  public abstract RefreshableComponent getContainer();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.factorys.CyriusForm
 * JD-Core Version:    0.6.0
 */