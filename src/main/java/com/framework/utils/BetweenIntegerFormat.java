/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.text.ChoiceFormat;
/*    */ import java.text.Format;
/*    */ 
/*    */ public class BetweenIntegerFormat
/*    */ {
/*    */   public static Format createBetweenIntegerFormat()
/*    */   {
/* 12 */     return new ChoiceFormat(new double[] { 1.0D, 2.0D, 3.0D, 4.0D, 5.0D }, new String[] { 
/* 13 */       "1", "2", "3", "4", "5" });
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.BetweenIntegerFormat
 * JD-Core Version:    0.6.0
 */