package com.framework.dynamicForms.entities;

import com.framework.exceptions.ShowableExceptionImpl;
import com.framework.persistence.PersistibleObject;

import java.util.Objects;

public class ComboItem
  implements PersistibleObject
{
  private Long id;
  private String name;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString()
  {
    return getName();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ComboItem)) {
      return false;
    }
    ComboItem that = (ComboItem)obj;
    if ((getId() != null) && (that.getId() != null)) {
      return getId().equals(that.getId());
    }
    return Objects.equals(this, that);
  }

  public void validate()
  {
    ShowableExceptionImpl.validateNotNull("combo.item.name", getName());
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.ComboItem
 * JD-Core Version:    0.6.0
 */