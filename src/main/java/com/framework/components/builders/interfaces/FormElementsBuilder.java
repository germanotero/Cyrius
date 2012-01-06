package com.framework.components.builders.interfaces;

import com.framework.components.FormComponent;
import com.framework.components.FormValueSelectionContainer;
import com.framework.components.TextBanner;
import com.framework.components.builders.impl.FormFieldBuilder;
import com.framework.components.builders.impl.FormGridBuilder;
import com.framework.components.builders.impl.FormInputBuilder;
import java.util.Collection;

public abstract interface FormElementsBuilder
{
  public abstract FormComboBoxBuilder addCombo(Class paramClass, String paramString);

  public abstract FormComboBoxBuilder addCombo(String paramString1, String paramString2);

  public abstract FormComboBoxBuilder addCombo(Object paramObject, String paramString1, String paramString2);

  public abstract FormComboBoxBuilder addCombo(ValueProvider paramValueProvider, String paramString);

  public abstract FormComponentBuilder addBuilder(FormComponentBuilder paramFormComponentBuilder);

  public abstract void addBuilders(Collection paramCollection);

  public abstract FormComponent addComponent(FormValueSelectionContainer paramFormValueSelectionContainer, String paramString1, String paramString2);

  public abstract FormComponent addComponent(FormComponent paramFormComponent, String paramString);

  public abstract TextBanner addBanner(String paramString);

  public abstract FormFieldBuilder addStringField(String paramString);

  public abstract FormFieldBuilder addTextArea(String paramString);

  public abstract FormFieldBuilder addFloatField(String paramString);

  public abstract FormFieldBuilder addDoubleField(String paramString);

  public abstract FormFieldBuilder addNumberField(String paramString);

  public abstract FormInputBuilder addMedidaField(String paramString);

  public abstract FormInputBuilder addCalendarBox(String paramString);

  public abstract FormInputBuilder addTimeBox(String paramString);

  public abstract GroupBuilder addGroup(Class paramClass, String paramString);

  public abstract GroupBuilder addGroup(Class paramClass);

  public abstract GroupBuilder addGroup(String paramString);

  public abstract FormGridBuilder addGrid(String paramString);

  public abstract FormGridBuilder addGrid(Object paramObject, String paramString);

  public abstract FormGridBuilder addGrid(Class paramClass);

  public abstract CheckBoxBuilder addCheckBox(String paramString);

  public abstract void setColumnsCount(int paramInt);

  public abstract TreeBuilder addTree(String paramString1, String paramString2);

  public abstract FormComponentBuilder addCombo(Object paramObject, String paramString);

  public abstract FormGridBuilder addGrid(Object paramObject, String paramString1, String paramString2);

  public abstract FormGridBuilder addGrid(Object paramObject, String paramString, String[] paramArrayOfString);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.interfaces.FormElementsBuilder
 * JD-Core Version:    0.6.0
 */