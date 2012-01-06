/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.wrappers.UseCaseImplementation;
/*    */ import com.framework.models.FormModel;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class CloseAndSaveUseCaseTargetDecorator extends SimpleModelTarget
/*    */ {
/* 16 */   private transient Log log = LogFactory.getLog(getClass());
/*    */   private UseCaseImplementation useCase;
/* 20 */   private ReturnStrategy returnStrategy = new SaveReturnStrategy();
/*    */ 
/*    */   public CloseAndSaveUseCaseTargetDecorator(UseCaseImplementation useCase) {
/* 23 */     super(null);
/* 24 */     this.useCase = useCase;
/*    */   }
/*    */ 
/*    */   public CloseAndSaveUseCaseTargetDecorator(UseCaseImplementation useCase, SimpleModelTarget target)
/*    */   {
/* 29 */     super(target);
/* 30 */     if ((target instanceof CloseAndSaveUseCaseTargetDecorator)) {
/* 31 */       this.log
/* 32 */         .warn("NO SE PUEDE ENCADENAR UN CLOSE TARGET CON OTRO CLOSE TARGET, esto va a causar que se grabe 2 veces. Se le anulara al segundo target la grabacion");
/* 33 */       CloseAndSaveUseCaseTargetDecorator close2 = (CloseAndSaveUseCaseTargetDecorator)target;
/* 34 */       close2.setReturnStrategy(NoopReturnStrategy.INSTANCE);
/*    */     }
/*    */ 
/* 37 */     this.useCase = useCase;
/*    */   }
/*    */ 
/*    */   private void setReturnStrategy(ReturnStrategy strategy) {
/* 41 */     this.returnStrategy = strategy;
/*    */   }
/*    */ 
/*    */   public void returning(FormModel childModel)
/*    */   {
/* 53 */     returnAction(childModel);
/* 54 */     if (getTarget() != null)
/* 55 */       getTarget().returning(childModel);
/*    */   }
/*    */ 
/*    */   protected void returnAction(FormModel model)
/*    */   {
/* 60 */     this.returnStrategy.returnAction(model);
/* 61 */     this.useCase.turnOff();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.CloseAndSaveUseCaseTargetDecorator
 * JD-Core Version:    0.6.0
 */