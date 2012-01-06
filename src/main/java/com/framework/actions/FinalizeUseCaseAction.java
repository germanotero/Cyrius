/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class FinalizeUseCaseAction extends AbstractFormAction
/*    */ {
/*    */   public FinalizeUseCaseAction()
/*    */   {
/* 17 */     super(new ImageIcon("Img/terminar.gif"));
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/* 25 */     getPadre().getReturnTarget().returning(model);
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 33 */     setActionKey(getClass().getName());
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.FinalizeUseCaseAction
 * JD-Core Version:    0.6.0
 */