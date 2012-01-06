/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.DelegatingModel;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ 
/*    */ class SaveReturnStrategy
/*    */   implements ReturnStrategy
/*    */ {
/*    */   public void returnAction(FormModel model)
/*    */   {
/* 10 */     model.save();
/*    */ 
/* 12 */     if ((model.getValue() instanceof PersistibleObject))
/* 13 */       save(model.getValue());
/* 14 */     else if (((model.getValue() instanceof DelegatingModel)) && 
/* 15 */       ((((DelegatingModel)model.getValue()).getDelegatee() instanceof PersistibleObject)))
/* 16 */       save(((DelegatingModel)model.getValue()).getDelegatee());
/*    */   }
/*    */ 
/*    */   private boolean save(Object model)
/*    */   {
/* 25 */     return PersistenceService.getInstance().save((PersistibleObject)model);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SaveReturnStrategy
 * JD-Core Version:    0.6.0
 */