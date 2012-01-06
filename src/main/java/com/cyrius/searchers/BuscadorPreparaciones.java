/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.Preparacion;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorPreparaciones
/*    */ {
/*    */   public static Collection findAll()
/*    */   {
/* 11 */     return PersistenceService.getInstance().loadAll(Preparacion.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorPreparaciones
 * JD-Core Version:    0.6.0
 */