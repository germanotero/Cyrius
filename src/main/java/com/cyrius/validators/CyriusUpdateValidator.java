package com.cyrius.validators;

import com.cyrius.entities.Persona;

public abstract interface CyriusUpdateValidator
{
  public abstract boolean canBeUpdated(Persona paramPersona);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.validators.CyriusUpdateValidator
 * JD-Core Version:    0.6.0
 */