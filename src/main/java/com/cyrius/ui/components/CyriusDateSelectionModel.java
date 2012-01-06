/*    */ package com.cyrius.ui.components;
/*    */ 
/*    */ import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.standbysoft.datepicker.DefaultDateSelectionModel;
/*    */ 
/*    */ public class CyriusDateSelectionModel extends DefaultDateSelectionModel
/*    */ {
/* 22 */   private static Calendar cal = Calendar.getInstance();
/*    */ 
/* 27 */   private Vector p = null;
/*    */ 
/* 29 */   private Vector tachados = null;
/*    */ 
/*    */   public CyriusDateSelectionModel()
/*    */   {
/* 33 */     this.p = new Vector(0);
/* 34 */     this.tachados = new Vector(0);
/*    */   }
/*    */ 
/*    */   public boolean isDateSelected(Date d) {
/* 38 */     return this.p.contains(d);
/*    */   }
/*    */ 
/*    */   public void addDay(Date d) {
/* 42 */     this.p.addElement(d);
/*    */   }
/*    */ 
/*    */   public void tachar(Date d) {
/* 46 */     this.tachados.addElement(d);
/*    */   }
/*    */ 
/*    */   public boolean isDisabled(Date date) {
/* 50 */     cal.setTime(date);
/*    */ 
/* 54 */     return (cal.get(7) == 7) || 
/* 53 */       (cal.get(7) == 1) || 
/* 54 */       (this.tachados.contains(date));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.CyriusDateSelectionModel
 * JD-Core Version:    0.6.0
 */