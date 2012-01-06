/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.Recordatorio;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorRecordatorio
/*    */ {
/*    */   public Collection findAll()
/*    */   {
/* 14 */     return PersistenceService.getInstance().loadAll(Recordatorio.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorRecordatorio
 * JD-Core Version:    0.6.0
 */