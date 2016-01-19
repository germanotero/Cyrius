package com.framework.integration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.framework.abstractfactorys.AbstractGroup;
import com.framework.entities.DynamicFormDecorator;
import com.framework.print.builder.PrintableElementsBuilder;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PDFPrintableElementBuilder extends DocumentPrinter implements PrintableElementsBuilder {
	private Document document = null;
	private String fileName = "";

	public PDFPrintableElementBuilder(DynamicFormDecorator decorator) {
		super(decorator);
		document = new Document();
		fileName = "informe-" + decorator.getNro() + ".pdf";
		try {

			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			PdfPTable tbl = new PdfPTable(3);
			tbl.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			tbl.addCell(decorator.getDestinationName());
			tbl.addCell(decorator.getName());
			PdfPCell numberCell = new PdfPCell(new Phrase("Nro: " + decorator.getNro().toString()));
			numberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			numberCell.setBorder(Rectangle.NO_BORDER);
			tbl.addCell(numberCell);
			tbl.setWidthPercentage(100F);
			tbl.completeRow();

			document.add(tbl);
			LineSeparator ls = new LineSeparator();
			document.add(new Chunk(ls));
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void addSimpleTitle(String text) {
		Paragraph chunk = new Paragraph(text, FontFactory.getFont(FontFactory.COURIER, getTitleSize(), Font.BOLD));
		chunk.setIndentationLeft(this.indentCount);
		if (this.indentCount == 0)
			chunk.setSpacingBefore(10);
		try {
			document.add(chunk);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		this.indentCount += 1;
	}

	public PrintableElementsBuilder startGroup(AbstractGroup group) {
		if (group.isEnabled()) {
			addSimpleTitle(group.getName());
		}
		return this;
	}

	public void endGroup(AbstractGroup group) {
		this.indentCount -= 1;
	}

	public void addInputValue(String name, Object valor) {
		StringBuilder stb = new StringBuilder();
		if (name.trim().length() > 0)
			stb.append(name).append(": ");

		try {
			Chunk paragraph1 = new Chunk(stb.toString(), FontFactory.getFont(FontFactory.COURIER, 11, Font.BOLD));
			Chunk paragraph2 = new Chunk(valor.toString(), FontFactory.getFont(FontFactory.COURIER, 11, Font.ITALIC));
			Paragraph line = new Paragraph();
			line.add(paragraph1);
			line.add(paragraph2);
			line.setIndentationLeft(this.indentCount * 5);
			document.add(line);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void print() {
		document.close();
	}

	public String getFileName() {
		return fileName;
	}

}
