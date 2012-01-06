package com.cyrius.validators;

import com.cyrius.entities.Persona;

public abstract interface CyriusInsertValidator
{
  public abstract boolean canBeInserted(Persona paramPersona);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.validators.CyriusInsertValidator
 * JD-Core Version:    0.6.0
 */