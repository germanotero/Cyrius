/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public abstract class SimpleModelTarget
/*    */   implements ModelTargetDecorator
/*    */ {
/*    */   private ModelTargetDecorator target;
/*    */   private FormModel parentModel;
/*    */ 
/*    */   public SimpleModelTarget(SimpleModelTarget target)
/*    */   {
/* 24 */     if (target != null)
/* 25 */       this.target = target;
/*    */   }
/*    */ 
/*    */   protected ModelTargetDecorator getTarget() {
/* 29 */     return this.target;
/*    */   }
/*    */ 
/*    */   public FormModel getParentModel() {
/* 33 */     return this.parentModel;
/*    */   }
/*    */ 
/*    */   public final FormModel getModel(FormModel parentModel)
/*    */   {
/* 40 */     this.parentModel = parentModel;
/* 41 */     return initModel(parentModel);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 48 */     return parentModel;
/*    */   }
/*    */ 
/*    */   public void returning(FormModel childModel)
/*    */   {
/* 57 */     returnAction(childModel);
/* 58 */     if (this.target != null)
/* 59 */       this.target.returning(childModel);
/*    */   }
/*    */ 
/*    */   public void failReturning() {
/* 63 */     if (this.target != null)
/* 64 */       this.target.failReturning();
/*    */   }
/*    */ 
/*    */   protected void returnAction(FormModel childModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SimpleModelTarget
 * JD-Core Version:    0.6.0
 */