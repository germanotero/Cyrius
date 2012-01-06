package com.framework.components;

import com.framework.components.listeners.ModelTargetListener;
import com.framework.components.validators.FormValueSelectionContainerValidator;
import com.framework.models.FormModel;
import java.awt.Dimension;
import javax.swing.JComponent;

public abstract interface FormInput extends Component, FormValueSelectionContainer
{
  public abstract void initComponent();

  public abstract void setValidator(FormValueSelectionContainerValidator paramFormValueSelectionContainerValidator);

  public abstract void setModel(FormModel paramFormModel);

  public abstract void addModelTargetListener(ModelTargetListener paramModelTargetListener);

  public abstract void impactModel(boolean paramBoolean);

  public abstract void refreshComponent();

  public abstract void setValue(Object paramObject);

  public abstract Object getValor();

  public abstract boolean isEmpty();

  public abstract boolean isColumnComponent();

  public abstract void setMaximumSize(Dimension paramDimension);

  public abstract String getName();

  public abstract JComponent getLabel();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormInput
 * JD-Core Version:    0.6.0
 */