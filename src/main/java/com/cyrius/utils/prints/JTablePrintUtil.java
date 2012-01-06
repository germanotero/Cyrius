/*    */ package com.cyrius.utils.prints;
/*    */ 
/*    */ import com.framework.exceptions.ExceptionHandler;
/*    */ import java.awt.print.Printable;
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ 
/*    */ public class JTablePrintUtil
/*    */   implements Runnable
/*    */ {
/*    */   private Printable tablaTurnos;
/*    */   private PrinterJob pj;
/*    */ 
/*    */   public JTablePrintUtil(Printable tabla)
/*    */   {
/* 31 */     this.pj = PrinterJob.getPrinterJob();
/* 32 */     this.tablaTurnos = tabla;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 41 */     if (this.pj.printDialog()) {
/* 42 */       this.pj.setPrintable(this.tablaTurnos);
/*    */       try {
/* 44 */         this.pj.print();
/*    */       } catch (PrinterException e) {
/* 46 */         ExceptionHandler.getInstance().handle(e);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.prints.JTablePrintUtil
 * JD-Core Version:    0.6.0
 */