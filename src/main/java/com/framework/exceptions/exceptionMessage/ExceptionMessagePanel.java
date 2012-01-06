/*    */ package com.framework.exceptions.exceptionMessage;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class ExceptionMessagePanel extends AbstractPanel
/*    */ {
/*    */   protected boolean withScrollPanel()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ 
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 28 */     builder.setColumnsCount(1);
/* 29 */     builder.addBanner("message");
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 40 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.exceptionMessage.ExceptionMessagePanel
 * JD-Core Version:    0.6.0
 */