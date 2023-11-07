/*    */ package com.framework.components.wrappers;
/*    */ 
/*    */ import org.apache.commons.collections4.Closure;
/*    */ 
/*    */ final class ExecuteRefreshListenerClosure
/*    */   implements Closure
/*    */ {
/*    */   public void execute(Object arg0)
/*    */   {
/* 10 */     ((RefreshListener)arg0).isRefleshing();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.ExecuteRefreshListenerClosure
 * JD-Core Version:    0.6.0
 */