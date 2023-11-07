package com.framework.dynamicForms.entities;

import com.framework.components.builders.interfaces.FormComponentBuilder;
import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
import com.framework.utils.CollectionFactory;
import com.framework.utils.ExtraCollectionUtils;
import java.util.Collection;

public class DynamicForm
  implements DynamicFormElement
{
  private Long id;
  private Integer cantidadColumnas = new Integer(2);

  private Collection simpleElements = CollectionFactory.createCollection();

  private Collection groupElements = CollectionFactory.createCollection();
  private String name;
  private String description;

  public Collection getGroupElements()
  {
    return this.groupElements;
  }

  public void setGroupElements(Collection groupElements) {
    this.groupElements = groupElements;
  }

  public Collection getSimpleElements() {
    return this.simpleElements;
  }

  public void setSimpleElements(Collection simpleElements) {
    this.simpleElements = simpleElements;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getCantidadColumnas() {
    return this.cantidadColumnas;
  }

  public void setCantidadColumnas(Integer cantidadColumnas) {
    if (cantidadColumnas != null)
      this.cantidadColumnas = cantidadColumnas;
  }

  public void addElements(Collection elements) {
    this.simpleElements.addAll(elements);
  }

  public void addGroupElements(Collection elements) {
    this.groupElements.addAll(ExtraCollectionUtils.transformedCollection(
      elements, new RelacionToGroupTransformer().backWard()));
  }

  public TipoFormElement getTipoDynamicFormElement() {
    return TipoFormElementSearcher.getForm();
  }

  public void setTipoDynamicFormElement(TipoFormElement nulla)
  {
  }

  public FormComponentBuilder getBuilder()
  {
    throw new RuntimeException(
      "No se deberia pedir un builder a un dynamic form");
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof DynamicForm))
      return false;
    DynamicForm that = (DynamicForm)obj;
    if (getId() == null)
      return super.equals(that);
    return getId().equals(that.getId());
  }

  public String getElementID()
  {
    throw new RuntimeException(
      "No se deberia pedir un builder a un dynamic form");
  }

  public String toString()
  {
    return getName() + " - " + 
      getDescription();
  }

  public int compareTo(Object o) {
    if ((o instanceof DynamicForm)) {
      DynamicForm that = (DynamicForm)o;
      return this.id.compareTo(that.id);
    }
    return 0;
  }

  public void validate()
  {
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.DynamicForm
 * JD-Core Version:    0.6.0
 */