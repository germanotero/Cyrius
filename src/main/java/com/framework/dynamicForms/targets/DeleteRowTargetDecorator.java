/*    */ package com.framework.dynamicForms.targets;
/*    */ 
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DeleteRowTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public DeleteRowTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 10 */     super(target);
/*    */   }
/*    */ 
/*    */   protected void returnAction(FormModel childModel)
/*    */   {
/* 15 */     getRowCollection().remove(getSelectedValue().getValue());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.targets.DeleteRowTargetDecorator
 * JD-Core Version:    0.6.0
 */