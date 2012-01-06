/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public final class SimpleTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public SimpleTargetDecorator(SimpleModelTarget target)
/*    */   {
/*  8 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 13 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SimpleTargetDecorator
 * JD-Core Version:    0.6.0
 */