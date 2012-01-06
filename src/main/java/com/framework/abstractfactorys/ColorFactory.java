/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class ColorFactory
/*    */ {
/*    */   public static Color createDefaultColor()
/*    */   {
/* 13 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createFormElementColor() {
/* 17 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createMultiplicableGroupColor()
/*    */   {
/* 27 */     return new Color(190, 195, 215);
/*    */   }
/*    */ 
/*    */   public static Color createGroupColor() {
/* 31 */     return new Color(200, 215, 0);
/*    */   }
/*    */ 
/*    */   public static Color createPanelColor() {
/* 35 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createActionsPanelColor() {
/* 39 */     return new Color(200, 200, 200);
/*    */   }
/*    */ 
/*    */   public static Color createElementsPanelColor() {
/* 43 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createChildUseCaseColor() {
/* 47 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createUseCaseColor() {
/* 51 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createFormInputColor() {
/* 55 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createComboColor() {
/* 59 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createBannerColor() {
/* 63 */     return new Color(230, 235, 230);
/*    */   }
/*    */ 
/*    */   public static Color createGroupBorderColor() {
/* 67 */     return new Color(100, 130, 150);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.ColorFactory
 * JD-Core Version:    0.6.0
 */