/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DeleteRowAction extends AbstractFormAction
/*    */ {
/*    */   private String collectionProperty;
/*    */ 
/*    */   public DeleteRowAction(String collectionProperty)
/*    */   {
/* 12 */     this.collectionProperty = collectionProperty;
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 17 */     return true;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model) throws Exception
/*    */   {
/* 22 */     FormModel selectedValue = ((GridTargetDecorator)getPadre()
/* 23 */       .getOpenTarget()).getSelectedValue();
/* 24 */     ((Collection)getPadre().getModelo().getProperty(
/* 25 */       this.collectionProperty).getValue())
/* 26 */       .remove(selectedValue.getValue());
/* 27 */     getPadre().refreshComponent();
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 35 */     setActionKey("eliminar");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.DeleteRowAction
 * JD-Core Version:    0.6.0
 */