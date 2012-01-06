/*    */ package com.cyrius.providers;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.entities.Practica;
/*    */ import com.framework.components.builders.interfaces.ValueProvider;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ 
/*    */ public class Practicas4MedicosProvider
/*    */   implements ValueProvider
/*    */ {
/*    */   private Medico medico;
/*    */ 
/*    */   public Practicas4MedicosProvider(Medico medico)
/*    */   {
/* 18 */     this.medico = medico;
/*    */   }
/*    */ 
/*    */   public Collection getValues() {
/* 22 */     CriteriaBuilder col = PersistenceService.getInstance()
/* 23 */       .criteriaBuilder(Practica.class);
/* 24 */     return col.getCriteria().createAlias("medicos", "medi").add(
/* 25 */       Restrictions.eq("medi.id", this.medico.getId())).list();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.providers.Practicas4MedicosProvider
 * JD-Core Version:    0.6.0
 */