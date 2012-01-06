/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class EditRowTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public EditRowTargetDecorator(SimpleModelTarget target)
/*    */   {
/*  8 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 13 */     return getSelectedValue();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.EditRowTargetDecorator
 * JD-Core Version:    0.6.0
 */