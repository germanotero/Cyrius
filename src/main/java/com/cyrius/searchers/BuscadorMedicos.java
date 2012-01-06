/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorMedicos
/*    */ {
/*    */   private static BuscadorMedicos instance;
/*    */ 
/*    */   public static synchronized BuscadorMedicos getInstance()
/*    */   {
/* 22 */     if (instance == null)
/* 23 */       instance = new BuscadorMedicos();
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findAll() {
/* 28 */     return PersistenceService.getInstance().loadAll(Medico.class);
/*    */   }
/*    */ 
/*    */   public static Medico findById(Integer id)
/*    */   {
/* 39 */     return (Medico)PersistenceService.getInstance().load(Medico.class, id);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorMedicos
 * JD-Core Version:    0.6.0
 */