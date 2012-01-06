/*    */ package com.framework.dynamicForms.elements.searchers;
/*    */ 
/*    */ import com.framework.dynamicForms.entities.SimpleDynamicFormElement;
/*    */ import com.framework.dynamicForms.entities.TipoFormElement;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class SimpleDynamicFormElementSearcher
/*    */ {
/*    */   private static SimpleDynamicFormElementSearcher instance;
/*    */ 
/*    */   public static synchronized SimpleDynamicFormElementSearcher getInstance()
/*    */   {
/* 16 */     if (instance == null)
/* 17 */       instance = new SimpleDynamicFormElementSearcher();
/* 18 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection<SimpleDynamicFormElement> findAll() {
/* 22 */     return PersistenceService.getInstance().loadAll(SimpleDynamicFormElement.class);
/*    */   }
/*    */ 
/*    */   public Collection<SimpleDynamicFormElement> findAllNotCombo() {
/* 26 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(
/* 27 */       SimpleDynamicFormElement.class);
/* 28 */     builder.addNotEquals("tipoFormElementName", TipoFormElementSearcher.getComboElement().getName());
/* 29 */     return (Collection)builder.build();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.SimpleDynamicFormElementSearcher
 * JD-Core Version:    0.6.0
 */