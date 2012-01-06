package com.framework.models;

public abstract interface FormModel
{
  public abstract void save();

  public abstract FormModel getProperty(String paramString);

  public abstract void setProperty(String paramString, Object paramObject);

  public abstract Object getValue();

  public abstract void refresh();

  public abstract Class getDecoratedClass();

  public abstract boolean isPersisted();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.FormModel
 * JD-Core Version:    0.6.0
 */