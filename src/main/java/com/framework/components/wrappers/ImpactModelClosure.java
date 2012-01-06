/*    */ package com.framework.components.wrappers;
/*    */ 
/*    */ import org.apache.commons.collections.Closure;
/*    */ 
/*    */ class ImpactModelClosure
/*    */   implements Closure
/*    */ {
/*    */   private boolean validate;
/*    */ 
/*    */   public ImpactModelClosure(boolean validate)
/*    */   {
/* 14 */     this.validate = validate;
/*    */   }
/*    */ 
/*    */   public void execute(Object arg0)
/*    */   {
/* 19 */     ((ImpactModelListener)arg0).impactingToModel(this.validate);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.ImpactModelClosure
 * JD-Core Version:    0.6.0
 */