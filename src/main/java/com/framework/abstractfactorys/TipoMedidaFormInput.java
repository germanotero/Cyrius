/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.MedidaBox;
/*    */ 
/*    */ public class TipoMedidaFormInput
/*    */   implements TipoFormInput
/*    */ {
/*  7 */   public static TipoMedidaFormInput INSTANCE = new TipoMedidaFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 14 */     return new MedidaBox(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoMedidaFormInput
 * JD-Core Version:    0.6.0
 */