/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.TextArea;
/*    */ 
/*    */ public class TipoTextAreaFormInput
/*    */   implements TipoFormInput
/*    */ {
/*  8 */   public static final TipoTextAreaFormInput INSTANCE = new TipoTextAreaFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 18 */     return new TextArea(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoTextAreaFormInput
 * JD-Core Version:    0.6.0
 */