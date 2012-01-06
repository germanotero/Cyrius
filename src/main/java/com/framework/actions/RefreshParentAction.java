/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import javax.swing.Icon;
/*    */ 
/*    */ public class RefreshParentAction extends SimpleTargetAction
/*    */ {
/*    */   private String key;
/*    */ 
/*    */   public RefreshParentAction(String key)
/*    */   {
/* 18 */     this.key = key;
/*    */   }
/*    */ 
/*    */   public RefreshParentAction(Class target) {
/* 22 */     super(target);
/*    */   }
/*    */ 
/*    */   public RefreshParentAction(String key, Icon icon) {
/* 26 */     super(icon);
/* 27 */     this.key = key;
/*    */   }
/*    */ 
/*    */   public RefreshParentAction(Class target, Icon icon) {
/* 31 */     super(target, icon);
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model) throws Exception
/*    */   {
/* 41 */     if (super.getTarget() != null) {
/* 42 */       super.executeFormAction(model);
/*    */     }
/* 44 */     getPadre().refreshComponent();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 49 */     if (this.key == null)
/* 50 */       super.setUpAction();
/*    */     else
/* 52 */       setActionKey(this.key);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.RefreshParentAction
 * JD-Core Version:    0.6.0
 */