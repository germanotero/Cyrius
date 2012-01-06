/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.NumberBox;
/*    */ 
/*    */ public class TipoNumberFormInput
/*    */   implements TipoFormInput
/*    */ {
/* 10 */   public static final TipoNumberFormInput INSTANCE = new TipoNumberFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 20 */     return new NumberBox(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoNumberFormInput
 * JD-Core Version:    0.6.0
 */