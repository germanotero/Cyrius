/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.wrappers.UseCaseImplementation;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public final class SimpleUseCaseTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   private UseCaseImplementation useCase;
/*    */ 
/*    */   public SimpleUseCaseTargetDecorator(UseCaseImplementation useCase)
/*    */   {
/* 10 */     super(null);
/* 11 */     this.useCase = useCase;
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel) {
/* 15 */     return parentModel;
/*    */   }
/*    */ 
/*    */   protected void returnAction(FormModel childModel)
/*    */   {
/* 22 */     this.useCase.refreshComponent();
/*    */   }
/*    */ 
/*    */   public void failReturning()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SimpleUseCaseTargetDecorator
 * JD-Core Version:    0.6.0
 */