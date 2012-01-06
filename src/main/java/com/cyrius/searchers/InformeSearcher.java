/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.cyrius.informes.Informe;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ 
/*    */ public class InformeSearcher
/*    */ {
/*    */   public static InformeSearcher instance;
/*    */ 
/*    */   public static synchronized InformeSearcher getInstance()
/*    */   {
/* 21 */     if (instance == null) {
/* 22 */       instance = new InformeSearcher();
/*    */     }
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findInformesByPerson(Persona persona) {
/* 28 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Informe.class);
/* 29 */     builder.getCriteria().createCriteria("turno").add(Restrictions.eq("paciente", persona));
/* 30 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public boolean exsistsByTurno(Turno turno) {
/* 34 */     CriteriaBuilder criteria = PersistenceService.getInstance().uniqueCriteriaBuilder(Informe.class);
/* 35 */     criteria.getCriteria().add(Restrictions.eq("turno", turno));
/* 36 */     return criteria.build() != null;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.InformeSearcher
 * JD-Core Version:    0.6.0
 */