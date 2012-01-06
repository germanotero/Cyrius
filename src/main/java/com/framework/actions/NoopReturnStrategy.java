/*   */ package com.framework.actions;
/*   */ 
/*   */ import com.framework.models.FormModel;
/*   */ 
/*   */ public class NoopReturnStrategy
/*   */   implements ReturnStrategy
/*   */ {
/* 6 */   public static ReturnStrategy INSTANCE = new NoopReturnStrategy();
/*   */ 
/*   */   public void returnAction(FormModel model)
/*   */   {
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.NoopReturnStrategy
 * JD-Core Version:    0.6.0
 */