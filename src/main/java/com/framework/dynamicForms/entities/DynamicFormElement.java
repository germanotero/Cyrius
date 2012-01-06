package com.framework.dynamicForms.entities;

import com.framework.components.builders.interfaces.FormComponentBuilder;
import com.framework.persistence.PersistibleObject;

public abstract interface DynamicFormElement extends PersistibleObject, Comparable
{
  public abstract TipoFormElement getTipoDynamicFormElement();

  public abstract FormComponentBuilder getBuilder();

  public abstract String getName();

  public abstract String getDescription();

  public abstract String getElementID();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.DynamicFormElement
 * JD-Core Version:    0.6.0
 */