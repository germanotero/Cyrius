package com.framework.exceptions;

public abstract class AbstractRuntimeExceptionBuilder
{
  protected String mensaje;

  public abstract RuntimeException buildException();

  public abstract AbstractRuntimeExceptionBuilder setMensaje(String paramString);

  public abstract String getMensaje();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.AbstractRuntimeExceptionBuilder
 * JD-Core Version:    0.6.0
 */