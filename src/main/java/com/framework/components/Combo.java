package com.framework.components;

import com.framework.components.validators.FormValueSelectionContainerValidator;
import com.framework.models.DefaultComboModel;
import com.framework.models.FormModel;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.Collection;
import javax.swing.JComponent;
import org.apache.commons.collections.Transformer;

public abstract interface Combo extends FormCombo, FormValueSelectionContainer
{
  public abstract void setMaximumRowCount(int paramInt);

  public abstract String getName();

  public abstract void addItemListener(ItemListener paramItemListener);

  public abstract Object getSelectedItem();

  public abstract int getSelectedIndex();

  public abstract void removeItem(Object paramObject);

  public abstract void setSelectedItem(Object paramObject);

  public abstract void setValues(Collection paramCollection);

  public abstract DefaultComboModel getValues();

  public abstract void setToolTipText(String paramString);

  public abstract void setModel(FormModel paramFormModel);

  public abstract void setEnabled(boolean paramBoolean);

  public abstract void addMouseListener(MouseListener paramMouseListener);

  public abstract void setName(String paramString);

  public abstract void setMaximumSize(Dimension paramDimension);

  public abstract void setValidator(FormValueSelectionContainerValidator paramFormValueSelectionContainerValidator);

  public abstract void withOutNullElement();

  public abstract JComponent getLabel();

  public abstract void setOnCommitAction(Transformer paramTransformer);

  public abstract Transformer getOnCommitAction();

  public abstract void dontRefresh();

  public abstract void doRefresh();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.Combo
 * JD-Core Version:    0.6.0
 */