/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.ObraSocial;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorObraSocial
/*    */ {
/*    */   public static Collection<ObraSocial> findAll()
/*    */   {
/* 29 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(ObraSocial.class);
/* 30 */     builder.addOrderBy("descripcion");
/* 31 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public static ObraSocial findById(Long id) {
/* 35 */     return (ObraSocial)PersistenceService.getInstance().load(ObraSocial.class, id);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorObraSocial
 * JD-Core Version:    0.6.0
 */