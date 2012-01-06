/*   */ package com.framework.dynamicForms.forms;
/*   */ 
/*   */ import org.apache.commons.collections.Transformer;
/*   */ 
/*   */ public class StringToIntegerTransformer
/*   */   implements Transformer
/*   */ {
/*   */   public Object transform(Object arg0)
/*   */   {
/* 8 */     return new Integer(arg0.toString());
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.StringToIntegerTransformer
 * JD-Core Version:    0.6.0
 */