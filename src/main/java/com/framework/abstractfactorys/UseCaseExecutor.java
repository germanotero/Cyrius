/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import com.framework.factorys.UseCaseFactory;
/*    */ 
/*    */ public class UseCaseExecutor
/*    */ {
/*    */   public static void execute(UseCaseFactory uc)
/*    */   {
/*    */     try
/*    */     {
/* 16 */       uc.startUseCase();
/*    */     } catch (Throwable e) {
/* 18 */       ExceptionHandler.getInstance().handle(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.UseCaseExecutor
 * JD-Core Version:    0.6.0
 */