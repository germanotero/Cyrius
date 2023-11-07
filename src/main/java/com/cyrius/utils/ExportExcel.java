package com.cyrius.utils;

import com.framework.exceptions.ExceptionHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import static org.apache.poi.ss.usermodel.BorderStyle.THIN;


public class ExportExcel
  implements Runnable
{
  private String fileName;
  private HSSFWorkbook workbook = new HSSFWorkbook();

  private HSSFSheet sheet = this.workbook.createSheet();
  private JTable table;
  HSSFFont hssfFont = this.workbook.createFont();

  public ExportExcel(String filename, JTable table)
  {
    this.fileName = filename;
    this.table = table;
  }

  private void writeFile()
    throws IOException
  {
    FileOutputStream fout;
    if (this.fileName.substring(this.fileName.length() - 4, this.fileName.length())
      .equalsIgnoreCase(".xls"))
      fout = new FileOutputStream(this.fileName);
    else {
      fout = new FileOutputStream(this.fileName + ".xls");
    }

    this.workbook.write(fout);
    fout.close();
  }

  private void exportTableToSheet(JTable table, HSSFSheet sheet) {
    int rowCount = table.getRowCount();
    int colCount = table.getColumnCount();
    int currentSheetRow = 0;

    for (int tableColIndex = 0; tableColIndex < colCount; tableColIndex++)
    {
      createAndFormatTop(table, 0, tableColIndex, sheet, currentSheetRow);
    }

    currentSheetRow = 1;

    for (int tableRowIndex = 0; tableRowIndex < rowCount; tableRowIndex++) {
      for (int tableColIndex = 0; tableColIndex < colCount; tableColIndex++) {
        sheet.setColumnWidth((short)tableColIndex, 
          (short)(table.getColumnModel()
          .getColumn(tableColIndex).getWidth() * 50));
        createAndFormatCell(table, tableRowIndex, tableColIndex, sheet, 
          currentSheetRow);
      }

      currentSheetRow++;
    }
  }

  private void createAndFormatCell(JTable table, int tableRowIndex, int tableColIndex, HSSFSheet sheet, int currentSheetRow)
  {
    Object cellValue = table.getValueAt(tableRowIndex, tableColIndex);

    HSSFCell cell = createHSSFCell(sheet, cellValue, currentSheetRow, 
      tableColIndex);

    if ((cellValue instanceof Integer))
      cell.setCellValue(((Integer)cellValue).intValue());
    else if ((cellValue instanceof Float))
      cell.setCellValue(((Float)cellValue).floatValue());
    else if ((cellValue instanceof Boolean)) {
      cell.setCellValue(((Boolean)cellValue).booleanValue());
    }

    TableCellRenderer renderer = table.getCellRenderer(tableRowIndex, 
      tableColIndex);
    Component rendererComponent = renderer.getTableCellRendererComponent(
      table, cellValue, false, false, tableRowIndex, tableColIndex);

    if ((rendererComponent instanceof JLabel))
    {
      JLabel label = (JLabel)rendererComponent;
      cellValue = label.getText();
    }
  }

  private void createAndFormatTop(JTable table, int tableRowIndex, int tableColIndex, HSSFSheet sheet, int currentSheetRow)
  {
    Object cellValue = table.getColumnName(tableColIndex);
    HSSFCell cell = createHSSFCell(sheet, cellValue, currentSheetRow, 
      tableColIndex);
    TableCellRenderer renderer = table.getCellRenderer(tableRowIndex, 
      tableColIndex);
    Component rendererComponent = renderer.getTableCellRendererComponent(
      table, cellValue, false, false, tableRowIndex, tableColIndex);

    formatCell(cell, rendererComponent);
  }

  private HSSFCell createHSSFCell(HSSFSheet sheet, Object value, int row, int col)
  {
    HSSFRow hssfRow = sheet.getRow(row);
    hssfRow = hssfRow == null ? sheet.createRow(row) : hssfRow;

    HSSFCell cell = hssfRow.getCell((short)col);
    cell = cell == null ? hssfRow.createCell((short)col) : cell;

    String cellValue = value == null ? "" : value.toString();
    cell.setCellValue(cellValue);

    return cell;
  }

  private void formatCell(HSSFCell cell, Component rendererComponent)
  {
    HSSFCellStyle cellStyle = this.workbook.createCellStyle();
    
    cellStyle.setAlignment(HorizontalAlignment.LEFT);

    Color color = rendererComponent.getBackground();
    HSSFPalette palette = this.workbook.getCustomPalette();

    short someUnusedColorIndex = 10;
    palette.setColorAtIndex(someUnusedColorIndex, (byte)color.getRed(), 
      (byte)color.getGreen(), (byte)color.getBlue());
    cellStyle.setFillForegroundColor(someUnusedColorIndex);
    cellStyle.setBorderTop(THIN);
    cellStyle.setBorderBottom(THIN);
    cellStyle.setBorderLeft(THIN);
    cellStyle.setBorderRight(THIN);

    cell.setCellStyle(cellStyle);
  }

  private HSSFFont createHSSFFont(Font font)
  {
    this.hssfFont.setFontName(font.getName());
    this.hssfFont.setItalic(font.isItalic());
   
    this.hssfFont.setBold(font.isBold());
   
    this.hssfFont.setFontHeightInPoints((short)font.getSize());
    this.hssfFont.setUnderline(HSSFFont.U_NONE);

    return this.hssfFont;
  }

  public void run()
  {
    Font font = this.table.getFont();
    HSSFFont hssfFont = createHSSFFont(font);
    exportTableToSheet(this.table, this.sheet);
    try
    {
      writeFile();
    } catch (IOException e) {
      ExceptionHandler.getInstance().handle(e);
    }
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.ExportExcel
 * JD-Core Version:    0.6.0
 */