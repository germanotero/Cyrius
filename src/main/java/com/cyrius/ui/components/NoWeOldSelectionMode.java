/*    */ package com.cyrius.ui.components;
/*    */ 
/*    */ import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.standbysoft.datepicker.DefaultDateSelectionModel;
/*    */ 
/*    */ public class NoWeOldSelectionMode extends DefaultDateSelectionModel
/*    */ {
/* 22 */   private static Calendar cal = Calendar.getInstance();
/*    */ 
/*    */   public boolean isDisabled(Date date) {
/* 25 */     cal.setTime(date);
/*    */ 
/* 29 */     return (cal.get(7) == 7) || 
/* 28 */       (cal.get(7) == 1) || 
/* 29 */       (esAnterior(date));
/*    */   }
/*    */ 
/*    */   private boolean esAnterior(Date date) {
/* 33 */     GregorianCalendar fecha = new GregorianCalendar();
/* 34 */     fecha.setTimeInMillis(date.getTime());
/*    */ 
/* 36 */     GregorianCalendar hoy = new GregorianCalendar();
/*    */ 
/* 41 */     return (!hoy.before(fecha)) && 
/* 39 */       (hoy.get(6) != 
/* 40 */       fecha.get(6));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.NoWeOldSelectionMode
 * JD-Core Version:    0.6.0
 */