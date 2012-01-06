/*    */ package com.cyrius.utils.prints;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.print.PageFormat;
/*    */ import java.awt.print.Printable;
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ import javax.swing.RepaintManager;
/*    */ 
/*    */ public class PrintUtilities
/*    */   implements Printable
/*    */ {
/*    */   private Component componentToBePrinted;
/*    */ 
/*    */   public PrintUtilities(Component componentToBePrinted)
/*    */   {
/* 17 */     this.componentToBePrinted = componentToBePrinted;
/*    */   }
/*    */ 
/*    */   public static void printComponent(Component c) {
/* 21 */     new PrintUtilities(c).print();
/*    */   }
/*    */ 
/*    */   public void print() {
/* 25 */     PrinterJob printJob = PrinterJob.getPrinterJob();
/* 26 */     printJob.setPrintable(this);
/*    */ 
/* 28 */     if (printJob.printDialog())
/*    */       try {
/* 30 */         printJob.print();
/*    */       }
/*    */       catch (PrinterException localPrinterException)
/*    */       {
/*    */       }
/*    */   }
/*    */ 
/*    */   public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
/* 38 */     if (pageIndex > 0) {
/* 39 */       return 1;
/*    */     }
/* 41 */     Graphics2D g2d = (Graphics2D)g;
/* 42 */     g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
/* 43 */     disableDoubleBuffering(this.componentToBePrinted);
/* 44 */     this.componentToBePrinted.paint(g2d);
/* 45 */     enableDoubleBuffering(this.componentToBePrinted);
/*    */ 
/* 47 */     return 0;
/*    */   }
/*    */ 
/*    */   public static void disableDoubleBuffering(Component c) {
/* 51 */     RepaintManager currentManager = RepaintManager.currentManager(c);
/* 52 */     currentManager.setDoubleBufferingEnabled(false);
/*    */   }
/*    */ 
/*    */   public static void enableDoubleBuffering(Component c) {
/* 56 */     RepaintManager currentManager = RepaintManager.currentManager(c);
/* 57 */     currentManager.setDoubleBufferingEnabled(true);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.prints.PrintUtilities
 * JD-Core Version:    0.6.0
 */