package com.framework.entities;

import java.math.BigInteger;

public abstract interface DynamicFormDecorator
{
  public abstract void finishForm(String paramString);

  public abstract String getName();

  public abstract String getDestinationName();

  public abstract BigInteger getNro();

  public abstract String getDatosXML();

  public abstract boolean isPersisted();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.DynamicFormDecorator
 * JD-Core Version:    0.6.0
 */