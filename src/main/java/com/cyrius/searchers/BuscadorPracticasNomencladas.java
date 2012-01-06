/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.PracticaNomenclada;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorPracticasNomencladas
/*    */ {
/*    */   public static Collection findAll()
/*    */   {
/* 27 */     return PersistenceService.getInstance().loadAll(PracticaNomenclada.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorPracticasNomencladas
 * JD-Core Version:    0.6.0
 */