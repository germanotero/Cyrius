/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NullMenuAction extends AbstractFormAction
/*    */ {
/*    */   private String key;
/*    */ 
/*    */   public NullMenuAction(String key)
/*    */   {
/* 15 */     this.key = key;
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 36 */     setActionKey(this.key);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.NullMenuAction
 * JD-Core Version:    0.6.0
 */