/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.CalendarBox;
/*    */ import com.framework.components.FormInput;
/*    */ 
/*    */ public class TipoCalendarFormInput
/*    */   implements TipoFormInput
/*    */ {
/*  7 */   public static TipoCalendarFormInput INSTANCE = new TipoCalendarFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 14 */     return new CalendarBox(name);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoCalendarFormInput
 * JD-Core Version:    0.6.0
 */