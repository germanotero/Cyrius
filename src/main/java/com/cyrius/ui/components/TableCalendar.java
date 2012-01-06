/*    */ package com.cyrius.ui.components;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.GregorianCalendar;
/*    */ 
/*    */ public class TableCalendar extends GregorianCalendar
/*    */ {
/*    */   public String toString()
/*    */   {
/* 20 */     return get(11) + ":" + get(12);
/*    */   }
/*    */ 
/*    */   public boolean equals(Object arg0)
/*    */   {
/* 29 */     Calendar cal = (Calendar)arg0;
/*    */ 
/* 31 */     return (get(11) == cal.get(11)) && 
/* 31 */       (get(12) == cal.get(12));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.TableCalendar
 * JD-Core Version:    0.6.0
 */