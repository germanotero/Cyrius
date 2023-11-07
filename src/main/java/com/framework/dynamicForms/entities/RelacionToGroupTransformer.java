package com.framework.dynamicForms.entities;

import org.apache.commons.collections4.Transformer;

public class RelacionToGroupTransformer
  implements Transformer
{
  public Object transform(Object arg0)
  {
    RelacionGroup rel = (RelacionGroup)arg0;
    return rel.getGroup();
  }

  public Transformer backWard() {
    return new Transformer()
    {
      public Object transform(Object arg0) {
        DynamicGroupElement group = (DynamicGroupElement)arg0;
        RelacionGroup rel = new RelacionGroup();
        rel.setGroup(group);
        return rel;
      }
    };
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.RelacionToGroupTransformer
 * JD-Core Version:    0.6.0
 */