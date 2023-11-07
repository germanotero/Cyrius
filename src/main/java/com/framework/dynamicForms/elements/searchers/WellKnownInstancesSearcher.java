package com.framework.dynamicForms.elements.searchers;

import com.framework.utils.ExtraCollectionUtils;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public abstract class WellKnownInstancesSearcher<T>
{
  private Collection<T> instances;

  public <T> T findByName(String name)
  {
    return (T)findByName2(name);
  }

  protected final <T> Object findByName2(final String name)
  {
    return CollectionUtils.find(getInstances(), new Predicate()
    {
      public boolean evaluate(Object arg0) {
        WellKnownInstance instance = (WellKnownInstance)arg0;
        return instance.getName().equals(name);
      }
    });
  }

  private Collection<T> getInstances() {
    if (this.instances == null) {
      this.instances = createWellKnownInstances();
    }
    return this.instances;
  }

  public final Collection<T> findAll()
  {
    return getInstances();
  }

  public abstract Collection<T> createWellKnownInstances();
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.WellKnownInstancesSearcher
 * JD-Core Version:    0.6.0
 */