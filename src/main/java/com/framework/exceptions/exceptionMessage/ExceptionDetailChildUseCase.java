/*    */ package com.framework.exceptions.exceptionMessage;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.models.ExceptionMessageModel;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class ExceptionDetailChildUseCase extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 23 */     builder.addPanel(new ExceptionDetalPanel());
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 30 */     return new Dimension(600, 300);
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 37 */     return ExceptionMessageModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.exceptionMessage.ExceptionDetailChildUseCase
 * JD-Core Version:    0.6.0
 */