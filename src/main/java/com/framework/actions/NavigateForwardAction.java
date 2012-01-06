/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.factorys.NavigableUseCase;
/*    */ import com.framework.models.FormModel;
/*    */ import java.awt.Container;
/*    */ 
/*    */ public class NavigateForwardAction extends NavigateAction
/*    */ {
/* 16 */   private String text = "siguiente";
/*    */ 
/*    */   public NavigateForwardAction()
/*    */   {
/*    */   }
/*    */ 
/*    */   public NavigateForwardAction(String text)
/*    */   {
/* 24 */     this.text = text;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/* 34 */     ((NavigableUseCase)((AbstractPanel)getParent().getParent())
/* 35 */       .getContainer()).nextPanel();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 43 */     setActionKey(this.text);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.NavigateForwardAction
 * JD-Core Version:    0.6.0
 */