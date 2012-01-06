/*    */ package com.cyrius.utils;
/*    */ 
/*    */ import java.util.GregorianCalendar;
/*    */ 
/*    */ /** @deprecated */
/*    */ public class GregorianCyrius extends GregorianCalendar
/*    */ {
/*    */   public GregorianCyrius()
/*    */   {
/*    */   }
/*    */ 
/*    */   public GregorianCyrius(GregorianCalendar greg)
/*    */   {
/* 24 */     super.setTimeInMillis(greg.getTimeInMillis());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 28 */     String text = new String();
/* 29 */     String dia = "";
/*    */ 
/* 31 */     switch (get(7)) {
/*    */     case 2:
/* 33 */       dia = "Lunes";
/*    */ 
/* 35 */       break;
/*    */     case 3:
/* 38 */       dia = "Martes";
/*    */ 
/* 40 */       break;
/*    */     case 4:
/* 43 */       dia = "Miercoles";
/*    */ 
/* 45 */       break;
/*    */     case 5:
/* 48 */       dia = "Jueves";
/*    */ 
/* 50 */       break;
/*    */     case 6:
/* 53 */       dia = "Viernes";
/*    */     }
/*    */ 
/* 58 */     text = dia + " " + get(5) + "/" + (
/* 59 */       get(2) + 1);
/*    */ 
/* 61 */     return text;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.GregorianCyrius
 * JD-Core Version:    0.6.0
 */