/*   */ package com.framework.abstractfactorys;
/*   */ 
/*   */ import com.framework.components.FloatBox;
/*   */ import com.framework.components.FormInput;
/*   */ 
/*   */ public class TipoFloatNumberFormInput
/*   */   implements TipoFormInput
/*   */ {
/*   */   public FormInput getInput(String name)
/*   */   {
/* 9 */     return new FloatBox(name);
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoFloatNumberFormInput
 * JD-Core Version:    0.6.0
 */