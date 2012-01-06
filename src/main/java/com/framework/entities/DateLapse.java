/*    */ package com.framework.entities;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DateLapse
/*    */ {
/*    */   private Date max;
/*    */   private Date min;
/*    */ 
/*    */   public DateLapse(Date min, Date max)
/*    */   {
/* 15 */     if (min.after(max)) {
/* 16 */       throw new IllegalArgumentException(
/* 17 */         "No se puede armar un periodo donde el minimo es posterior al maximo");
/*    */     }
/* 19 */     this.max = max;
/* 20 */     this.min = min;
/*    */   }
/*    */ 
/*    */   public Date getMax()
/*    */   {
/* 27 */     return this.max;
/*    */   }
/*    */ 
/*    */   public Date getMin()
/*    */   {
/* 34 */     return this.min;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.DateLapse
 * JD-Core Version:    0.6.0
 */