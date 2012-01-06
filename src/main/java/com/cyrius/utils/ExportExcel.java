/*     */ package com.cyrius.utils;
/*     */ 
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*     */ import org.apache.poi.hssf.usermodel.HSSFPalette;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ 
/*     */ public class ExportExcel
/*     */   implements Runnable
/*     */ {
/*     */   private String fileName;
/*  38 */   private HSSFWorkbook workbook = new HSSFWorkbook();
/*     */ 
/*  40 */   private HSSFSheet sheet = this.workbook.createSheet();
/*     */   private JTable table;
/*  44 */   HSSFFont hssfFont = this.workbook.createFont();
/*     */ 
/*     */   public ExportExcel(String filename, JTable table)
/*     */   {
/*  48 */     this.fileName = filename;
/*  49 */     this.table = table;
/*     */   }
/*     */ 
/*     */   private void writeFile()
/*     */     throws IOException
/*     */   {
/*     */     FileOutputStream fout;
/*  56 */     if (this.fileName.substring(this.fileName.length() - 4, this.fileName.length())
/*  56 */       .equalsIgnoreCase(".xls"))
/*  57 */       fout = new FileOutputStream(this.fileName);
/*     */     else {
/*  59 */       fout = new FileOutputStream(this.fileName + ".xls");
/*     */     }
/*     */ 
/*  63 */     this.workbook.write(fout);
/*  64 */     fout.close();
/*     */   }
/*     */ 
/*     */   private void exportTableToSheet(JTable table, HSSFSheet sheet) {
/*  68 */     int rowCount = table.getRowCount();
/*  69 */     int colCount = table.getColumnCount();
/*  70 */     int currentSheetRow = 0;
/*     */ 
/*  72 */     for (int tableColIndex = 0; tableColIndex < colCount; tableColIndex++)
/*     */     {
/*  74 */       createAndFormatTop(table, 0, tableColIndex, sheet, currentSheetRow);
/*     */     }
/*     */ 
/*  77 */     currentSheetRow = 1;
/*     */ 
/*  79 */     for (int tableRowIndex = 0; tableRowIndex < rowCount; tableRowIndex++) {
/*  80 */       for (int tableColIndex = 0; tableColIndex < colCount; tableColIndex++) {
/*  81 */         sheet.setColumnWidth((short)tableColIndex, 
/*  82 */           (short)(table.getColumnModel()
/*  83 */           .getColumn(tableColIndex).getWidth() * 50));
/*  84 */         createAndFormatCell(table, tableRowIndex, tableColIndex, sheet, 
/*  85 */           currentSheetRow);
/*     */       }
/*     */ 
/*  88 */       currentSheetRow++;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void createAndFormatCell(JTable table, int tableRowIndex, int tableColIndex, HSSFSheet sheet, int currentSheetRow)
/*     */   {
/*  95 */     Object cellValue = table.getValueAt(tableRowIndex, tableColIndex);
/*     */ 
/*  98 */     HSSFCell cell = createHSSFCell(sheet, cellValue, currentSheetRow, 
/*  99 */       tableColIndex);
/*     */ 
/* 101 */     if ((cellValue instanceof Integer))
/* 102 */       cell.setCellValue(((Integer)cellValue).intValue());
/* 103 */     else if ((cellValue instanceof Float))
/* 104 */       cell.setCellValue(((Float)cellValue).floatValue());
/* 105 */     else if ((cellValue instanceof Boolean)) {
/* 106 */       cell.setCellValue(((Boolean)cellValue).booleanValue());
/*     */     }
/*     */ 
/* 110 */     TableCellRenderer renderer = table.getCellRenderer(tableRowIndex, 
/* 111 */       tableColIndex);
/* 112 */     Component rendererComponent = renderer.getTableCellRendererComponent(
/* 113 */       table, cellValue, false, false, tableRowIndex, tableColIndex);
/*     */ 
/* 115 */     if ((rendererComponent instanceof JLabel))
/*     */     {
/* 120 */       JLabel label = (JLabel)rendererComponent;
/* 121 */       cellValue = label.getText();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void createAndFormatTop(JTable table, int tableRowIndex, int tableColIndex, HSSFSheet sheet, int currentSheetRow)
/*     */   {
/* 129 */     Object cellValue = table.getColumnName(tableColIndex);
/* 130 */     HSSFCell cell = createHSSFCell(sheet, cellValue, currentSheetRow, 
/* 131 */       tableColIndex);
/* 132 */     TableCellRenderer renderer = table.getCellRenderer(tableRowIndex, 
/* 133 */       tableColIndex);
/* 134 */     Component rendererComponent = renderer.getTableCellRendererComponent(
/* 135 */       table, cellValue, false, false, tableRowIndex, tableColIndex);
/*     */ 
/* 137 */     formatCell(cell, rendererComponent);
/*     */   }
/*     */ 
/*     */   private HSSFCell createHSSFCell(HSSFSheet sheet, Object value, int row, int col)
/*     */   {
/* 143 */     HSSFRow hssfRow = sheet.getRow(row);
/* 144 */     hssfRow = hssfRow == null ? sheet.createRow(row) : hssfRow;
/*     */ 
/* 147 */     HSSFCell cell = hssfRow.getCell((short)col);
/* 148 */     cell = cell == null ? hssfRow.createCell((short)col) : cell;
/*     */ 
/* 151 */     String cellValue = value == null ? "" : value.toString();
/* 152 */     cell.setCellValue(cellValue);
/*     */ 
/* 154 */     return cell;
/*     */   }
/*     */ 
/*     */   private void formatCell(HSSFCell cell, Component rendererComponent)
/*     */   {
/* 159 */     HSSFCellStyle cellStyle = this.workbook.createCellStyle();
/*     */ 
/* 162 */     cellStyle.setFillPattern(HSSFCellStyle.ALIGN_LEFT);
/*     */ 
/* 164 */     Color color = rendererComponent.getBackground();
/* 165 */     HSSFPalette palette = this.workbook.getCustomPalette();
/*     */ 
/* 169 */     short someUnusedColorIndex = 10;
/* 170 */     palette.setColorAtIndex(someUnusedColorIndex, (byte)color.getRed(), 
/* 171 */       (byte)color.getGreen(), (byte)color.getBlue());
/* 172 */     cellStyle.setFillForegroundColor(someUnusedColorIndex);
/*     */ 
/* 181 */     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
/* 182 */     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
/* 183 */     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
/* 184 */     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
/*     */ 
/* 187 */     cell.setCellStyle(cellStyle);
/*     */   }
/*     */ 
/*     */   private HSSFFont createHSSFFont(Font font)
/*     */   {
/* 192 */     this.hssfFont.setFontName(font.getName());
/* 193 */     this.hssfFont.setItalic(font.isItalic());


/* 194 */     this.hssfFont.setBoldweight((short) (font.isBold() ? HSSFFont.BOLDWEIGHT_BOLD : 
/* 195 */       HSSFFont.BOLDWEIGHT_NORMAL));
/* 196 */     this.hssfFont.setFontHeightInPoints((short)font.getSize());
/* 197 */     this.hssfFont.setUnderline(HSSFFont.U_NONE);
/*     */ 
/* 199 */     return this.hssfFont;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 208 */     Font font = this.table.getFont();
/* 209 */     HSSFFont hssfFont = createHSSFFont(font);
/* 210 */     exportTableToSheet(this.table, this.sheet);
/*     */     try
/*     */     {
/* 213 */       writeFile();
/*     */     } catch (IOException e) {
/* 215 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.ExportExcel
 * JD-Core Version:    0.6.0
 */