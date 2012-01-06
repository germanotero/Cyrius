/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.factorys.NavigableUseCase;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NavigateBackAction extends NavigateAction
/*    */ {
/*    */   private String key;
/*    */ 
/*    */   public NavigateBackAction()
/*    */   {
/* 19 */     this("atras");
/*    */   }
/*    */ 
/*    */   public NavigateBackAction(String i18nKey)
/*    */   {
/* 24 */     this.key = i18nKey;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/* 34 */     ((NavigableUseCase)((AbstractPanel)getPadre()).getContainer())
/* 35 */       .previousPanel();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 43 */     setActionKey(this.key);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.NavigateBackAction
 * JD-Core Version:    0.6.0
 */