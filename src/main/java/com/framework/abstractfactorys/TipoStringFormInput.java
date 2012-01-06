/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.TextBox;
/*    */ 
/*    */ public class TipoStringFormInput
/*    */   implements TipoFormInput
/*    */ {
/* 10 */   public static final TipoStringFormInput INSTANCE = new TipoStringFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 20 */     return new TextBox(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoStringFormInput
 * JD-Core Version:    0.6.0
 */