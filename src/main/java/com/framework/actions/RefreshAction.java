/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class RefreshAction extends SimpleTargetAction
/*    */ {
/*    */   private String text;
/* 15 */   private SimpleAction action = NullAction.INSTANCE;
/*    */ 
/*    */   public RefreshAction(String text)
/*    */   {
/* 19 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, SimpleAction action)
/*    */   {
/* 24 */     this.text = text;
/* 25 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, Class target) {
/* 29 */     super(target);
/* 30 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, SimpleAction action, Class target) {
/* 34 */     super(target);
/* 35 */     this.text = text;
/* 36 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, ImageIcon icon) {
/* 40 */     super(icon);
/* 41 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, SimpleAction action, ImageIcon icon) {
/* 45 */     super(icon);
/* 46 */     this.text = text;
/* 47 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, Class target, ImageIcon icon) {
/* 51 */     super(target, icon);
/* 52 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public RefreshAction(String text, SimpleAction action, Class target, ImageIcon icon) {
/* 56 */     super(target, icon);
/* 57 */     this.text = text;
/* 58 */     this.action = action;
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/* 74 */     if (super.getTarget() != null) {
/* 75 */       super.executeFormAction(model);
/*    */     }
/* 77 */     this.action.executeAction(model);
/* 78 */     getPadre().refreshComponent();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 86 */     setActionKey(this.text);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.RefreshAction
 * JD-Core Version:    0.6.0
 */