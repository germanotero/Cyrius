/*    */ package com.framework.dynamicForms.elements.searchers;
/*    */ 
/*    */ import com.framework.dynamicForms.entities.DynamicGroupElement;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.classic.Session;
/*    */ 
/*    */ public class DynamicGroupElementSearcher
/*    */ {
/*    */   private static DynamicGroupElementSearcher instance;
/*    */ 
/*    */   public static synchronized DynamicGroupElementSearcher getInstance()
/*    */   {
/* 19 */     if (instance == null)
/* 20 */       instance = new DynamicGroupElementSearcher();
/* 21 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection<DynamicGroupElement> findAll() {
/* 25 */     Session session = PersistenceService.getInstance().getCurrentSession();
/* 26 */     session.beginTransaction();
/* 27 */     Criteria criteria = session.createCriteria(DynamicGroupElement.class);
/* 28 */     return criteria.list();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.DynamicGroupElementSearcher
 * JD-Core Version:    0.6.0
 */