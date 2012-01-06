/*    */ package com.framework.exceptions.exceptionMessage;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class SameModelTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public SameModelTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 20 */     return parentModel;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.exceptionMessage.SameModelTargetDecorator
 * JD-Core Version:    0.6.0
 */