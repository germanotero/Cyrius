/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.FrameworkUseCaseFactory;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ 
/*    */ public class DynamicUseCaseBuilder
/*    */ {
/*    */   public static DynamicUseCaseFactory build(DynamicForm form)
/*    */   {
/* 16 */     DynamicUseCaseFactory dynamicUseCaseFactory = new DynamicUseCaseFactory(form);
/* 17 */     DynamicUseCaseFactory useCase = (DynamicUseCaseFactory)FrameworkUseCaseFactory.createUseCase(dynamicUseCaseFactory);
/* 18 */     useCase.setMultiplePanels(true);
/* 19 */     return useCase;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicUseCaseBuilder
 * JD-Core Version:    0.6.0
 */