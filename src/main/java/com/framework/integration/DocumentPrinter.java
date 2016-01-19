package com.framework.integration;

import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.elegantj.util.printer.Printer;
import com.framework.abstractfactorys.AbstractGroup;
import com.framework.entities.DynamicFormDecorator;
import com.framework.print.builder.PrintableElementsBuilder;

public class DocumentPrinter implements PrintableElementsBuilder {
	private transient Log log = LogFactory.getLog(getClass());

	private JTextPane panel = new JTextPane();

	protected int indentCount = 0;
	private DynamicFormDecorator decorator;

	public DocumentPrinter(DynamicFormDecorator value) {
		this.decorator = value;
		this.log.info("se inicia un impresor de documentos para: " + value);
	}

	public PrintableElementsBuilder startDocument(String name) {
		this.log.debug("inicia el documento: " + name);
		return this;
	}

	public void endDocument() {
		this.log.debug("finalizo el documento");
	}

	public PrintableElementsBuilder startGroup(AbstractGroup group) {
		this.log.debug("Se agrega el grupo: " + group.getName());
		try {
			if (group.isEnabled()) {
				addSimpleTitle(group.getName());
			}
			return this;
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	protected void addSimpleTitle(String text) throws BadLocationException {
		SimpleAttributeSet set = getTitleAttributeSet();
		if (this.indentCount == 0)
			this.panel.getDocument().insertString(this.panel.getDocument().getLength(), "\n", null);
		this.panel.getDocument().insertString(this.panel.getDocument().getLength(), text + "\n", set);
		this.indentCount += 1;
	}

	public void endGroup(AbstractGroup group) {
		this.indentCount -= 1;
	}

	public void addInputValue(String name, Object valor) {
		this.log.debug("Se agrega el input: " + name + " con el valor: " + valor);
		try {
			StringBuilder stb = new StringBuilder();
			SimpleAttributeSet set = getInputNameAttributeSet();
			if (name.trim().length() > 0)
				stb.append(name).append(": ");
			this.panel.getDocument().insertString(this.panel.getDocument().getLength(), stb.toString(), set);
			SimpleAttributeSet set2 = getInputAttributeSet();
			this.panel.getDocument().insertString(this.panel.getDocument().getLength(), valor.toString().concat("\n"), set2);
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addImage(URL url) {
		this.panel.insertIcon(new ImageIcon(url));
	}
	
	protected int getTitleSize() {
		switch (this.indentCount) {
		case 0:
			return 16;
		case 1:
			return 13;
		case 2:
			return 12;
		}
		return 11;
	}

	protected SimpleAttributeSet getTitleAttributeSet() {
		SimpleAttributeSet set = new SimpleAttributeSet();
		set.addAttribute(StyleConstants.Bold, Boolean.TRUE);
		set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
		set.addAttribute(StyleConstants.FontSize, new Integer(getTitleSize()));
		return set;
	}

	protected SimpleAttributeSet getInputAttributeSet() {
		SimpleAttributeSet set = new SimpleAttributeSet();
		set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
		set.addAttribute(StyleConstants.LeftIndent, new Float(this.indentCount));
		set.addAttribute(StyleConstants.FontSize, new Integer(12));
		return set;
	}

	protected SimpleAttributeSet getInputNameAttributeSet() {
		SimpleAttributeSet set = new SimpleAttributeSet();
		set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
		set.addAttribute(StyleConstants.LeftIndent, new Float(this.indentCount));
		set.addAttribute(StyleConstants.FontSize, new Integer(11));
		set.addAttribute(StyleConstants.Italic, Boolean.TRUE);
		set.addAttribute(StyleConstants.Bold, Boolean.TRUE);
		return set;
	}

	public void print() {
		this.log.info("se lanza a imprimir el documento");
		Printer printer = new Printer();
		printer.setJTextPane(this.panel);
		printer.setLeftHeader(this.decorator.getDestinationName());
		printer.setCenterHeader(this.decorator.getName());
		printer.setRightHeader(" n°" + this.decorator.getNro());
		printer.setCenterFooter("C.E.N.S.");
		printer.setBottomMargin(0.3D);
		printer.setBookSize(Printer.A4_TYPE);
		printer.print();
	}

	protected void finalize() throws Throwable {
		this.log.info("Se finalzo el impresor de documentos");
		super.finalize();
	}

}
