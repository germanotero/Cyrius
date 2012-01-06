/*    */ package com.framework.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.io.File;
/*    */ import java.net.URL;
/*    */ import javax.swing.border.BevelBorder;
/*    */ 
/*    */ public class Constants
/*    */ {
/* 25 */   public static final URL CONFIGFILE = Constants.class
/* 25 */     .getResource("/com/framework/configfiles/Cyrius.conf");
/*    */ 
/* 27 */   public static final File PROPERTY_COMBO_FILE = new File(
/* 28 */     "config/propertyFiles/combos.properties");
/*    */   public static final String PROPERTY_COMBO_ITEMS_PATH = "config/propertyFiles/";
/* 36 */   public static final Color FOREGROUND = new Color(10, 10, 10);
/*    */ 
/* 38 */   public static final Color FOREGROUND_BUTTON = new Color(10, 10, 10);
/*    */ 
/* 41 */   public static final Color BACKBUTTON = new Color(0, 51, 102);
/*    */ 
/* 44 */   public static final Color BACK_MENU_BAR = new Color(210, 200, 210);
/*    */ 
/* 46 */   public static final Font FONTPRINT = new Font("Serif", 0, 10);
/*    */ 
/* 48 */   public static final Font FONTPRINTTEXT = new Font("Serif", 0, 9);
/*    */ 
/* 50 */   public static final Font FONTLEYENDA = new Font("Serif", 0, 7);
/*    */ 
/* 53 */   public static final BevelBorder BORDEDEFAULT = new BevelBorder(
/* 54 */     0, null, null, null, null);
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.Constants
 * JD-Core Version:    0.6.0
 */