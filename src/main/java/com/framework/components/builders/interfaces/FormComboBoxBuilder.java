package com.framework.components.builders.interfaces;

import com.framework.components.Combo;
import java.awt.event.ItemListener;
import org.apache.commons.collections.Transformer;

public abstract interface FormComboBoxBuilder extends FormComponentBuilder
{
  public abstract FormComboBoxBuilder addComboRestriction(Combo paramCombo, String paramString);

  public abstract FormComboBoxBuilder withListProperty(String paramString);

  public abstract FormComboBoxBuilder addItemListener(ItemListener paramItemListener);

  public abstract FormComboBoxBuilder addComboRefresh(FormComboBoxBuilder paramFormComboBoxBuilder);

  public abstract FormComboBoxBuilder withOutNullElement();

  public abstract void setOnCommitAction(Transformer paramTransformer);

  public abstract FormComboBoxBuilder refreshOnChange();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.FormComboBoxBuilder
 * JD-Core Version:    0.6.0
 */