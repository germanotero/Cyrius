/*    */ package com.framework.dynamicForms.elements.searchers;
/*    */ 
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.entities.TipoFormElement;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.classic.Session;
/*    */ 
/*    */ public class DynamicFormSearcher
/*    */ {
/*    */   private static DynamicFormSearcher instance;
/*    */ 
/*    */   public static synchronized DynamicFormSearcher getInstance()
/*    */   {
/* 24 */     if (instance == null)
/* 25 */       instance = new DynamicFormSearcher();
/* 26 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findDynamicFormOnly() {
/* 30 */     Session session = PersistenceService.getInstance().getCurrentSession();
/* 31 */     session.beginTransaction();
/* 32 */     Criteria criteria = session.createCriteria(DynamicForm.class);
/* 33 */     Collection select = CollectionUtils.select(criteria.list(), 
/* 34 */       new Predicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 37 */         DynamicForm form = (DynamicForm)arg0;
/* 38 */         return form.getTipoDynamicFormElement().equals(
/* 39 */           TipoFormElementSearcher.getForm());
/*    */       }
/*    */     });
/* 43 */     return select;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.DynamicFormSearcher
 * JD-Core Version:    0.6.0
 */