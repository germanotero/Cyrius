/*     */ package com.cyrius.informes.xml;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.io.File;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class XMLInformePanel extends JFrame
/*     */ {
/*     */   public XMLInformePanel()
/*     */   {
/*  30 */     getContentPane().setLayout(null);
/*     */   }
/*     */ 
/*     */   public void loadXml(File f)
/*     */     throws Exception
/*     */   {
/*  38 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  39 */     DocumentBuilder builder = factory.newDocumentBuilder();
/*  40 */     Document doc = builder.parse(f);
/*     */ 
/*  42 */     Element root = doc.getDocumentElement();
/*  43 */     setTitle(root.getAttribute("name"));
/*  44 */     setSize(
/*  46 */       new Dimension(Integer.valueOf(
/*  45 */       root.getAttribute("pageWidth")).intValue(), Integer.valueOf(
/*  46 */       root.getAttribute("pageHeight")).intValue()));
/*     */ 
/*  48 */     NodeList nl = root.getChildNodes();
/*  49 */     for (int x = 0; x < nl.getLength(); x++)
/*  50 */       if (nl.item(x).getNodeName().equals("title"))
/*  51 */         processTitle(nl.item(x));
/*     */   }
/*     */ 
/*     */   private void processTitle(Node node)
/*     */   {
/*  62 */     NodeList nl = node.getChildNodes();
/*  63 */     for (int x = 0; x < nl.getLength(); x++) {
/*  64 */       if (nl.item(x).getChildNodes().getLength() > 0) {
/*  65 */         processTitle(nl.item(x));
/*     */       }
/*  67 */       if (nl.item(x).getNodeName().equals("textField")) {
/*  68 */         addElement(nl.item(x));
/*  69 */       } else if (nl.item(x).getNodeName().equals("staticText")) {
/*  70 */         addLabel(nl.item(x));
/*     */       }
/*     */       else
/*     */       {
/*     */         Element el;
/*  71 */         if (nl.item(x).getNodeName().equals("reportElement")) {
/*  72 */           el = (Element)nl.item(x);
/*  73 */           JLabel textField = new JLabel();
/*  74 */           Rectangle location = new Rectangle();
/*  75 */           location.height = 
/*  76 */             Integer.valueOf(el.getAttribute("height")).intValue();
/*  77 */           location.width = 
/*  78 */             Integer.valueOf(el.getAttribute("width")).intValue();
/*  79 */           location.x = Integer.valueOf(el.getAttribute("x")).intValue();
/*  80 */           location.y = Integer.valueOf(el.getAttribute("y")).intValue();
/*  81 */           getContentPane().add(textField);
/*  82 */         } else if (nl.item(x).getNodeName().equals("text")) {
/*  83 */           el = (Element)nl.item(x);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addLabel(Node node)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void addElement(Node node)
/*     */   {
/* 100 */     NodeList nl = node.getChildNodes();
/* 101 */     for (int i = 0; i < nl.getLength(); i++)
/* 102 */       if (nl.item(i).getNodeName().equals("reportElement")) {
/* 103 */         Element el = (Element)nl.item(i);
/* 104 */         JTextField textField = new JTextField();
/* 105 */         Rectangle location = new Rectangle();
/* 106 */         location.height = 
/* 107 */           Integer.valueOf(el.getAttribute("height")).intValue();
/* 108 */         location.width = 
/* 109 */           Integer.valueOf(el.getAttribute("width")).intValue();
/* 110 */         location.x = Integer.valueOf(el.getAttribute("x")).intValue();
/* 111 */         location.y = Integer.valueOf(el.getAttribute("y")).intValue();
/* 112 */         getContentPane().add(textField);
/*     */       }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.xml.XMLInformePanel
 * JD-Core Version:    0.6.0
 */