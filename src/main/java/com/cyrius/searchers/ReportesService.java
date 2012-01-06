/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.commons.collections.Transformer;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Transaction;
/*    */ import org.hibernate.classic.Session;
/*    */ 
/*    */ public class ReportesService
/*    */ {
/*    */   public static Collection getListaFacturacion(Date desde, Date hasta, Collection medicos, Collection obrasSociales)
/*    */   {
/* 28 */     Session currentSession = null;
/*    */ 
/* 30 */     hasta.setHours(23);
/* 31 */     hasta.setMinutes(59);
/* 32 */     desde.setHours(23);
/* 33 */     desde.setMinutes(59);
/* 34 */     desde.setDate(desde.getDate() - 1);
/*    */     try {
/* 36 */       Collection idMedicos = CollectionUtils.transformedCollection(medicos, new EntityToIdTransformer());
/* 37 */       Collection idObrasSociales = CollectionUtils.transformedCollection(obrasSociales, 
/* 38 */         new EntityToIdTransformer());
/* 39 */       currentSession = PersistenceService.getInstance().getCurrentSession();
/* 40 */       currentSession.beginTransaction();
/* 41 */       Query listaFacturacion = currentSession.getNamedQuery("listaFacturacion");
/* 42 */       listaFacturacion.setParameterList("idObraSocial", idObrasSociales);
/* 43 */       listaFacturacion.setParameterList("idMedico", idMedicos);
/* 44 */       listaFacturacion.setDate("desde", desde);
/* 45 */       listaFacturacion.setDate("hasta", hasta);
/* 46 */       List result = listaFacturacion.list();
/* 47 */       currentSession.getTransaction().commit();
/* 48 */       return result;
/*    */     } catch (RuntimeException ex) {
/* 50 */       if (currentSession != null)
/* 51 */         currentSession.getTransaction().rollback(); 
			   throw ex;
/*    */     }
/* 52 */    
/*    */   }
/*    */ 
/*    */   private static final class EntityToIdTransformer
/*    */     implements Transformer
/*    */   {
/*    */     public Object transform(Object arg0)
/*    */     {
/* 18 */       PersistibleObject ob = (PersistibleObject)arg0;
/* 19 */       return ob.getId();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.ReportesService
 * JD-Core Version:    0.6.0
 */