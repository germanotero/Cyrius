package com.framework.dynamicForms.elements.searchers;

import com.framework.dynamicForms.entities.DynamicForm;
import com.framework.dynamicForms.entities.TipoFormElement;
import com.framework.persistence.PersistenceService;
import com.framework.utils.ExtraCollectionUtils;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;

public class DynamicFormSearcher
{
  private static DynamicFormSearcher instance;

  public static synchronized DynamicFormSearcher getInstance()
  {
    if (instance == null)
      instance = new DynamicFormSearcher();
    return instance;
  }

  public Collection findDynamicFormOnly() {
    Session session = PersistenceService.getInstance().getCurrentSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(DynamicForm.class);
    Collection select = ExtraCollectionUtils.select(criteria.list(), 
      new Predicate()
    {
      public boolean evaluate(Object arg0) {
        DynamicForm form = (DynamicForm)arg0;
        return form.getTipoDynamicFormElement().equals(
          TipoFormElementSearcher.getForm());
      }
    });
    return select;
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.DynamicFormSearcher
 * JD-Core Version:    0.6.0
 */