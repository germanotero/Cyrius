/*     */ package com.framework.integration;
/*     */ 
/*     */ import com.elegantj.util.printer.Printer;
/*     */ import com.framework.abstractfactorys.AbstractGroup;
/*     */ import com.framework.entities.DynamicFormDecorator;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.Document;
/*     */ import javax.swing.text.SimpleAttributeSet;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class DocumentPrinter
/*     */   implements PrintableElementsBuilder
/*     */ {
/*  20 */   private transient Log log = LogFactory.getLog(getClass());
/*     */ 
/*  22 */   private JTextPane panel = new JTextPane();
/*     */ 
/*  24 */   private int indentCount = 0;
/*     */   private DynamicFormDecorator decorator;
/*     */ 
/*     */   public DocumentPrinter(DynamicFormDecorator value)
/*     */   {
/*  29 */     this.decorator = value;
/*  30 */     this.log.info("se inicia un impresor de documentos para: " + value);
/*     */   }
/*     */ 
/*     */   public PrintableElementsBuilder startDocument(String name) {
/*  34 */     this.log.debug("inicia el documento: " + name);
/*  35 */     return this;
/*     */   }
/*     */ 
/*     */   public void endDocument() {
/*  39 */     this.log.debug("finalizo el documento");
/*     */   }
/*     */ 
/*     */   public PrintableElementsBuilder startGroup(AbstractGroup group) {
/*  43 */     this.log.debug("Se agrega el grupo: " + group.getName());
/*     */     try {
/*  45 */       if (group.isEnabled()) {
/*  46 */         addSimpleTitle(group.getName());
/*     */       }
/*  48 */       return this; } catch (BadLocationException e) {
	/*  50 */     throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addSimpleTitle(String text)
/*     */     throws BadLocationException
/*     */   {
/*  58 */     SimpleAttributeSet set = getTitleAttributeSet();
/*  59 */     if (this.indentCount == 0)
/*  60 */       this.panel.getDocument().insertString(this.panel.getDocument().getLength(), 
/*  61 */         "\n", null);
/*  62 */     StringBuffer stb = getPadding();
/*  63 */     this.panel.getDocument().insertString(this.panel.getDocument().getLength(), 
/*  64 */       text + "\n", set);
/*  65 */     this.indentCount += 1;
/*     */   }
/*     */ 
/*     */   public void endGroup(AbstractGroup group) {
/*  69 */     this.indentCount -= 1;
/*     */   }
/*     */ 
/*     */   public void addInputValue(String name, Object valor) {
/*  73 */     this.log.debug("Se agrega el input: " + name + " con el valor: " + 
/*  74 */       valor);
/*     */     try {
/*  76 */       StringBuffer stb = getPadding();
/*  77 */       SimpleAttributeSet set = getInputNameAttributeSet();
/*  78 */       if (name.trim().length() > 0)
/*  79 */         stb.append(name).append(": ");
/*  80 */       this.panel.getDocument().insertString(this.panel.getDocument().getLength(), 
/*  81 */         stb.toString(), set);
/*  82 */       SimpleAttributeSet set2 = getInputAttributeSet();
/*  83 */       StringBuffer valueText = new StringBuffer(valor.toString());
/*  84 */       this.panel.getDocument().insertString(this.panel.getDocument().getLength(), 
/*  85 */         "\n", set2);
/*     */     } catch (BadLocationException e) {
/*  87 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private StringBuffer getPadding()
/*     */   {
/*  93 */     StringBuffer stb = new StringBuffer("");
/*  94 */     return stb;
/*     */   }
/*     */ 
/*     */   private int getTitleSize() {
/*  98 */     switch (this.indentCount) {
/*     */     case 0:
/* 100 */       return 16;
/*     */     case 1:
/* 102 */       return 13;
/*     */     case 2:
/* 104 */       return 12;
/*     */     }
/* 106 */     return 11;
/*     */   }
/*     */ 
/*     */   private SimpleAttributeSet getTitleAttributeSet()
/*     */   {
/* 112 */     SimpleAttributeSet set = new SimpleAttributeSet();
/* 113 */     set.addAttribute(StyleConstants.Bold, Boolean.TRUE);
/* 114 */     set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
/* 115 */     set.addAttribute(StyleConstants.FontSize, 
/* 116 */       new Integer(getTitleSize()));
/* 117 */     return set;
/*     */   }
/*     */ 
/*     */   private SimpleAttributeSet getInputAttributeSet() {
/* 121 */     SimpleAttributeSet set = new SimpleAttributeSet();
/* 122 */     set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
/* 123 */     set
/* 124 */       .addAttribute(StyleConstants.LeftIndent, 
/* 125 */       new Float(this.indentCount));
/* 126 */     set.addAttribute(StyleConstants.FontSize, new Integer(12));
/* 127 */     return set;
/*     */   }
/*     */ 
/*     */   private SimpleAttributeSet getInputNameAttributeSet() {
/* 131 */     SimpleAttributeSet set = new SimpleAttributeSet();
/* 132 */     set.addAttribute(StyleConstants.FontFamily, "Bodoni Mt");
/* 133 */     set
/* 134 */       .addAttribute(StyleConstants.LeftIndent, 
/* 135 */       new Float(this.indentCount));
/* 136 */     set.addAttribute(StyleConstants.FontSize, new Integer(11));
/* 137 */     set.addAttribute(StyleConstants.Italic, Boolean.TRUE);
/* 138 */     set.addAttribute(StyleConstants.Bold, Boolean.TRUE);
/* 139 */     return set;
/*     */   }
/*     */ 
/*     */   public void print() {
/* 143 */     this.log.info("se lanza a imprimir el documento");
/* 144 */     Printer printer = new Printer();
/* 145 */     printer.setJTextPane(this.panel);
/* 146 */     printer.setLeftHeader(this.decorator.getDestinationName());
/* 147 */     printer.setCenterHeader(this.decorator.getName());
/* 148 */     printer.setRightHeader(" n°" + this.decorator.getNro());
/* 149 */     printer.setCenterFooter("C.E.N.S.");
/* 150 */     printer.setBottomMargin(0.3D);
/* 151 */     printer.setBookSize(Printer.A4_TYPE);
/* 152 */     printer.print();
/*     */   }
/*     */ 
/*     */   protected void finalize()
/*     */     throws Throwable
/*     */   {
/* 158 */     this.log.info("Se finalzo el impresor de documentos");
/* 159 */     super.finalize();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.integration.DocumentPrinter
 * JD-Core Version:    0.6.0
 */