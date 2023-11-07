package com.cyrius.providers;

import com.cyrius.entities.Medico;
import com.cyrius.entities.Practica;
import com.framework.components.builders.interfaces.ValueProvider;
import com.framework.persistence.CriteriaBuilder;
import com.framework.persistence.PersistenceService;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class Practicas4MedicosProvider
  implements ValueProvider
{
  private Medico medico;

  public Practicas4MedicosProvider(Medico medico)
  {
    this.medico = medico;
  }

  public Collection getValues() {
    CriteriaBuilder col = PersistenceService.getInstance()
      .criteriaBuilder(Practica.class);
    return col.getCriteria().createAlias("medicos", "medi").add(
      Restrictions.eq("medi.id", this.medico.getId())).list();
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.providers.Practicas4MedicosProvider
 * JD-Core Version:    0.6.0
 */