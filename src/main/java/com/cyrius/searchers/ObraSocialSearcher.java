/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.ObraSocial;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class ObraSocialSearcher
/*    */ {
/*    */   public Collection<ObraSocial> findAll()
/*    */   {
/* 11 */     return PersistenceService.getInstance().loadAll(ObraSocial.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.ObraSocialSearcher
 * JD-Core Version:    0.6.0
 */