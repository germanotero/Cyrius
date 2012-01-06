/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.cyrius.entities.TipoDocumento;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.Transaction;
/*    */ import org.hibernate.classic.Session;
/*    */ import org.hibernate.criterion.MatchMode;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ 
/*    */ public class BuscadorPersona
/*    */ {
/*    */   private static BuscadorPersona instance;
/*    */ 
/*    */   public static synchronized BuscadorPersona getInstance()
/*    */   {
/* 32 */     if (instance == null)
/* 33 */       instance = new BuscadorPersona();
/* 34 */     return instance;
/*    */   }
/*    */ 
/*    */   public static Collection findAll() {
/* 38 */     return PersistenceService.getInstance().loadAll(Persona.class);
/*    */   }
/*    */ 
/*    */   public static Persona findById(Integer id)
/*    */   {
/* 50 */     return (Persona)PersistenceService.getInstance().load(Persona.class, id);
/*    */   }
/*    */ 
/*    */   public Collection findByNombreApellido(String nombre, String apellido) {
/* 54 */     CriteriaBuilder builder = createCriteriaNombreApellido(nombre, apellido);
/* 55 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public boolean existsByNombreApellido(String nombre, String apellido) {
/* 59 */     CriteriaBuilder builder = createCriteriaNombreApellido(nombre, apellido);
/* 60 */     return !((Collection)(Collection)builder.build()).isEmpty();
/*    */   }
/*    */ 
/*    */   private CriteriaBuilder<Collection> createCriteriaNombreApellido(String nombre, String apellido)
/*    */   {
/* 68 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Persona.class);
/* 69 */     builder.dontAcceptNullValues();
/* 70 */     builder.addilike("nombre", nombre, MatchMode.ANYWHERE);
/* 71 */     builder.addilike("apellido", apellido, MatchMode.ANYWHERE);
/* 72 */     return builder;
/*    */   }
/*    */ 
/*    */   public boolean existByDocumento(Integer nroDocumento, TipoDocumento tipoDocumento) {
/* 76 */     Session currentSession = PersistenceService.getInstance().getCurrentSession();
/* 77 */     currentSession.beginTransaction();
/* 78 */     Criteria builder = currentSession.createCriteria(Persona.class);
/* 79 */     builder.add(Restrictions.eq("documento", nroDocumento));
/* 80 */     builder.add(Restrictions.eq("tipoDocumento", tipoDocumento));
/* 81 */     builder.setMaxResults(1);
/* 82 */     boolean value = !builder.list().isEmpty();
/* 83 */     currentSession.getTransaction().commit();
/* 84 */     return value;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorPersona
 * JD-Core Version:    0.6.0
 */