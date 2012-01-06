/*    */ package com.framework.exceptions.exceptionMessage;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class ExceptionDetalPanel extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 19 */     builder.addBanner("stackTrace");
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 26 */     builder.addNavigateBackAction();
/* 27 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.exceptionMessage.ExceptionDetalPanel
 * JD-Core Version:    0.6.0
 */