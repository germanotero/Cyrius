/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.TimeBox;
/*    */ 
/*    */ public class TipoTimeFormInput
/*    */   implements TipoFormInput
/*    */ {
/*  8 */   public static final TipoTimeFormInput INSTANCE = new TipoTimeFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 15 */     return new TimeBox(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoTimeFormInput
 * JD-Core Version:    0.6.0
 */