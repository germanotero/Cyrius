/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelEnableElementsContainer;
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class CancelUseCaseAction extends AbstractFormAction
/*    */ {
/*    */   public CancelUseCaseAction(ModelEnableElementsContainer container)
/*    */   {
/* 22 */     super(container, new ImageIcon("Img/cancel.gif"));
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model)
/*    */     throws Exception
/*    */   {
/* 30 */     getPadre().turnOff();
/* 31 */     getPadre().getReturnTarget().failReturning();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 38 */     setActionKey("cancelar");
/* 39 */     setRefreshAfterExecute(false);
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 46 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.CancelUseCaseAction
 * JD-Core Version:    0.6.0
 */