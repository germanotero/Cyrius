package com.cyrius.searchers;

import com.framework.persistence.PersistenceService;
import com.framework.persistence.PersistibleObject;
import com.framework.utils.ExtraCollectionUtils;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections4.Transformer;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class ReportesService
{
  public static Collection getListaFacturacion(Date desde, Date hasta, Collection medicos, Collection obrasSociales)
  {
    Session currentSession = null;

    hasta.setHours(23);
    hasta.setMinutes(59);
    desde.setHours(23);
    desde.setMinutes(59);
    desde.setDate(desde.getDate() - 1);
    try {
      Collection idMedicos = ExtraCollectionUtils.transformedCollection(medicos, new EntityToIdTransformer());
      Collection idObrasSociales = ExtraCollectionUtils.transformedCollection(obrasSociales, 
        new EntityToIdTransformer());
      currentSession = PersistenceService.getInstance().getCurrentSession();
      currentSession.beginTransaction();
      Query listaFacturacion = currentSession.getNamedQuery("listaFacturacion");
      listaFacturacion.setParameterList("idObraSocial", idObrasSociales);
      listaFacturacion.setParameterList("idMedico", idMedicos);
      listaFacturacion.setDate("desde", desde);
      listaFacturacion.setDate("hasta", hasta);
      List result = listaFacturacion.list();
      currentSession.getTransaction().commit();
      return result;
    } catch (RuntimeException ex) {
      if (currentSession != null)
        currentSession.getTransaction().rollback(); 
	   throw ex;
    }
   
  }

  private static final class EntityToIdTransformer
    implements Transformer
  {
    public Object transform(Object arg0)
    {
      PersistibleObject ob = (PersistibleObject)arg0;
      return ob.getId();
    }
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.ReportesService
 * JD-Core Version:    0.6.0
 */