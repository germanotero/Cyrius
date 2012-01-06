/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.border.SoftBevelBorder;
/*    */ 
/*    */ public class BorderFactory
/*    */ {
/*    */   public static Border createDefaultGroupBorder(String title)
/*    */   {
/* 22 */     Border borde = javax.swing.BorderFactory.createLineBorder(Color.BLACK);
/* 23 */     Font font = new Font("Times new Roman", 2, 18);
/* 24 */     return javax.swing.BorderFactory.createTitledBorder(borde, title, 
/* 25 */       2, 2, font, Color.black);
/*    */   }
/*    */ 
/*    */   public static Border createDefaultGridBorder(String title)
/*    */   {
/* 33 */     return createDefaultGroupBorder(title);
/*    */   }
/*    */ 
/*    */   public static Border createScrollPanelBorder()
/*    */   {
/* 44 */     return javax.swing.BorderFactory.createEmptyBorder();
/*    */   }
/*    */ 
/*    */   public static Border createDefaultComboBorder() {
/* 48 */     return new SoftBevelBorder(
/* 49 */       0);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.BorderFactory
 * JD-Core Version:    0.6.0
 */