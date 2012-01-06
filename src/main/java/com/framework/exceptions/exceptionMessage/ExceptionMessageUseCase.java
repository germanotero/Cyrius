/*    */ package com.framework.exceptions.exceptionMessage;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.models.ExceptionMessageModel;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class ExceptionMessageUseCase extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 24 */     builder.addPanel(new ExceptionMessagePanel());
/* 25 */     builder.addPanel(new ExceptionDetalPanel());
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 33 */     return new Dimension(600, 300);
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 41 */     return ExceptionMessageModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.exceptionMessage.ExceptionMessageUseCase
 * JD-Core Version:    0.6.0
 */