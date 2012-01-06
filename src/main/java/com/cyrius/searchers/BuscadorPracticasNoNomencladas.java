/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.PracticaNoNomenclada;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorPracticasNoNomencladas
/*    */ {
/*    */   public static Collection findAll()
/*    */   {
/* 30 */     return PersistenceService.getInstance().loadAll(PracticaNoNomenclada.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorPracticasNoNomencladas
 * JD-Core Version:    0.6.0
 */