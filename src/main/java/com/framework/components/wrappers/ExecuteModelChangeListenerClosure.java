/*    */ package com.framework.components.wrappers;
/*    */ 
/*    */ import com.framework.components.listeners.ModelChangeListener;
/*    */ import org.apache.commons.collections.Closure;
/*    */ 
/*    */ class ExecuteModelChangeListenerClosure
/*    */   implements Closure
/*    */ {
/*    */   public void execute(Object arg0)
/*    */   {
/* 12 */     ((ModelChangeListener)arg0).modelChanged();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.ExecuteModelChangeListenerClosure
 * JD-Core Version:    0.6.0
 */