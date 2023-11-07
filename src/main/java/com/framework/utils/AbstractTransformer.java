/*   */ package com.framework.utils;
/*   */ 
/*   */ import org.apache.commons.collections4.Transformer;
/*   */ 
/*   */ public abstract class AbstractTransformer<T>
/*   */   implements Transformer
/*   */ {
/*   */   public final Object transform(Object arg0)
/*   */   {
/* 9 */     return transformValue((T)arg0);
/*   */   }
/*   */ 
/*   */   public abstract Object transformValue(T paramT);
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.AbstractTransformer
 * JD-Core Version:    0.6.0
 */