/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ 
/*    */ public class FormGridFindAllModelTableListener extends AbstractGridModelTargetListener
/*    */ {
/*    */   private Class entityClass;
/*    */ 
/*    */   public FormGridFindAllModelTableListener(Class entityClass)
/*    */   {
/* 21 */     this.entityClass = entityClass;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model)
/*    */   {
/*    */     try {
/* 27 */       getGridModel().setValues(
/* 28 */         PersistenceService.getInstance().loadAll(this.entityClass));
/*    */     } catch (Throwable e) {
/* 30 */       ExceptionHandler.getInstance().handle(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.FormGridFindAllModelTableListener
 * JD-Core Version:    0.6.0
 */