/*     */ package com.cyrius.utils.prints;
/*     */ 
/*     */ import com.framework.utils.Constants;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Printable;
/*     */ import java.awt.print.PrinterException;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.JTableHeader;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class JPrintTable extends JTable
/*     */   implements Printable
/*     */ {
/*     */   public int print(Graphics g, PageFormat pageFormat, int pageIndex)
/*     */     throws PrinterException
/*     */   {
/*  45 */     JTable jTable1 = new JTable();
/*  46 */     jTable1.setModel(getModel());
/*     */ 
/*  48 */     jTable1.setFont(Constants.FONTPRINT);
/*  49 */     jTable1.setBackground(Color.WHITE);
/*     */ 
/*  51 */     Graphics2D g2 = (Graphics2D)g;
/*     */ 
/*  53 */     Font font = new Font("Helvetica", 0, 10);
/*  54 */     jTable1.setFont(font);
/*  55 */     g2.setColor(Color.DARK_GRAY);
/*  56 */     g2.setFont(font);
/*     */ 
/*  59 */     double pageHeight = pageFormat.getImageableHeight();
/*  60 */     double pageWidth = pageFormat.getImageableWidth();
/*  61 */     double tableWidth = jTable1.getColumnModel().getTotalColumnWidth();
/*  62 */     double scale = 1.0D;
/*     */ 
/*  64 */     if (tableWidth >= pageWidth) {
/*  65 */       scale = pageWidth / tableWidth;
/*     */     }
/*     */ 
/*  68 */     double headerHeightOnPage = jTable1.getTableHeader().getHeight() * 
/*  69 */       scale;
/*  70 */     double tableWidthOnPage = tableWidth * scale;
/*  71 */     double oneRowHeight = (jTable1.getRowHeight() + 6 + 
/*  72 */       jTable1.getRowMargin()) * 
/*  73 */       scale;
/*  74 */     int numRowsOnAPage = (int)((pageHeight - headerHeightOnPage) / oneRowHeight);
/*  75 */     double pageHeightForTable = oneRowHeight * numRowsOnAPage;
/*  76 */     int totalNumPages = (int)Math.ceil(jTable1.getRowCount() / 
/*  77 */       numRowsOnAPage) - 1;
/*     */ 
/*  79 */     if ((pageIndex > 0) && (pageIndex >= totalNumPages)) {
/*  80 */       return 1;
/*     */     }
/*     */ 
/*  83 */     g2.translate(pageFormat.getImageableX(), 
/*  84 */       pageFormat.getImageableY() + 20.0D);
/*     */ 
/*  87 */     g2
/*  88 */       .drawString("Pagina: " + (pageIndex + 1), 0.0F, 
/*  89 */       (float)(pageHeight + 5.0D));
/*     */ 
/*  92 */     g2.translate(0.0D, headerHeightOnPage + 5.0D);
/*  93 */     g2.translate(0.0D, -pageIndex * pageHeightForTable);
/*     */ 
/*  97 */     if (pageIndex + 1 == totalNumPages) {
/*  98 */       int lastRowPrinted = numRowsOnAPage * pageIndex;
/*  99 */       int numRowsLeft = jTable1.getRowCount() - lastRowPrinted;
/* 100 */       g2.setClip(0, (int)(pageHeightForTable * pageIndex), 
/* 101 */         (int)Math.ceil(tableWidthOnPage), 
/* 102 */         (int)Math.ceil(oneRowHeight * 
/* 102 */         numRowsLeft));
/*     */     }
/*     */     else
/*     */     {
/* 106 */       g2.setClip(0, (int)(pageHeightForTable * pageIndex), 
/* 107 */         (int)Math.ceil(tableWidthOnPage), 
/* 108 */         (int)Math.ceil(pageHeightForTable));
/*     */     }
/*     */ 
/* 111 */     g2.scale(scale, scale);
/* 112 */     jTable1.paint(g2);
/* 113 */     g2.scale(1.0D / scale, 1.0D / scale);
/* 114 */     g2.translate(0.0D, pageIndex * pageHeightForTable);
/* 115 */     g2.translate(0.0D, -headerHeightOnPage);
/* 116 */     g2.setClip(0, 0, (int)Math.ceil(tableWidthOnPage), 
/* 117 */       (int)Math.ceil(headerHeightOnPage));
/* 118 */     g2.scale(scale, scale);
/* 119 */     jTable1.getTableHeader().paint(g2);
/*     */ 
/* 121 */     return 0;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.prints.JPrintTable
 * JD-Core Version:    0.6.0
 */