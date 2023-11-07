/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.framework.dynamicForms.elements.searchers.DynamicFormSearcher;
/*    */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.entities.TipoFormElement;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import com.framework.utils.ExtraCollectionUtils;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class EstudiosSearcher extends DynamicFormSearcher
/*    */ {
/*    */   private static EstudiosSearcher instance;
/*    */ 
/*    */   public static synchronized EstudiosSearcher getInstance()
/*    */   {
/* 30 */     if (instance == null) {
/* 31 */       instance = new EstudiosSearcher();
/*    */     }
/* 33 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findAllSinPractica()
/*    */   {
/* 40 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(DynamicForm.class);
/* 41 */     builder.addSql(" THIS_.ID NOT IN (SELECT ID_ESTUDIO FROM PRACTICA_ESTUDIOS) ");
/* 42 */     Collection select = ExtraCollectionUtils.select((Collection)(Collection)builder.build(), new Predicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 45 */         DynamicForm form = (DynamicForm)arg0;
/* 46 */         return form.getTipoDynamicFormElement().equals(TipoFormElementSearcher.getForm());
/*    */       }
/*    */     });
/* 50 */     return select;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.EstudiosSearcher
 * JD-Core Version:    0.6.0
 */