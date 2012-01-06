/*    */ package com.framework.dynamicForms.elements.searchers;
/*    */ 
/*    */ import com.framework.dynamicForms.entities.ComboElement;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class ComboElementSearcher
/*    */ {
/*    */   private static ComboElementSearcher instance;
/*    */ 
/*    */   public static synchronized ComboElementSearcher getInstance()
/*    */   {
/* 12 */     if (instance == null)
/* 13 */       instance = new ComboElementSearcher();
/* 14 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findAll()
/*    */   {
/* 22 */     return PersistenceService.getInstance().loadAll(ComboElement.class);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.ComboElementSearcher
 * JD-Core Version:    0.6.0
 */