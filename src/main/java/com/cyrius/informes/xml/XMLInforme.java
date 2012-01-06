/*     */ package com.cyrius.informes.xml;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class XMLInforme
/*     */ {
/*     */   String titulo;
/*     */   int id;
/*     */   Collection<XMLComponentBuilder> components;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  39 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id)
/*     */   {
/*  47 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitulo()
/*     */   {
/*  54 */     return this.titulo;
/*     */   }
/*     */ 
/*     */   public void setTitulo(String titulo)
/*     */   {
/*  62 */     this.titulo = titulo;
/*     */   }
/*     */ 
/*     */   public void loadXml(File f)
/*     */     throws Exception
/*     */   {
/*  75 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  76 */     DocumentBuilder builder = factory.newDocumentBuilder();
/*  77 */     Document doc = builder.parse(f);
/*     */ 
/*  79 */     Element root = doc.getDocumentElement();
/*  80 */     setTitulo(root.getAttribute("titulo"));
/*  81 */     setId(Integer.parseInt(root.getAttribute("id")));
/*  82 */     this.components = new Vector();
/*     */ 
/*  84 */     NodeList nl = root.getChildNodes();
/*  85 */     for (int x = 0; x < nl.getLength(); x++)
/*  86 */       if (nl.item(x).getNodeName().toLowerCase().equals("combo")) {
/*  87 */         this.components.add(Combo.getInstance((Element)nl.item(x)));
/*  88 */       } else if (nl.item(x).getNodeName().toLowerCase().equals("campo")) {
/*  89 */         this.components.add(Campo.getInstance((Element)nl.item(x))); } else {
/*  90 */         if (nl.item(x).getNodeName().toLowerCase().equals("boolean"))
/*     */           continue;
/*  92 */         nl.item(x).getNodeName().toLowerCase().equals("lista");
/*     */       }
/*     */   }
/*     */ 
/*     */   public Collection<Component> getComponents()
/*     */   {
/*  99 */     Vector ret = new Vector(0);
/* 100 */     for (Iterator iter = this.components.iterator(); iter
/* 101 */       .hasNext(); )
/*     */     {
/* 102 */       ret.add(((XMLComponentBuilder)iter.next()).buildComponent());
/* 103 */     }return ret;
/*     */   }
/*     */ 
/*     */   public String toXml()
/*     */     throws Exception
/*     */   {
/* 113 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 114 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 115 */     Document doc = builder.newDocument();
/*     */ 
/* 117 */     Element root = doc.createElement("INFORME");
/* 118 */     root.setAttribute("titulo", getTitulo());
/* 119 */     root.setAttribute("id", ""+getId());
/* 120 */     Iterator it = this.components.iterator();
/* 121 */     while (it.hasNext()) {
/* 122 */       Object elem = it.next();
/* 123 */       if ((elem instanceof Combo)) {
/* 124 */         ((Combo)elem).toXml(root);
/*     */       }
/* 126 */       if ((elem instanceof Campo)) {
/* 127 */         ((Campo)elem).toXml(root);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 132 */     doc.appendChild(root);
/*     */ 
/* 134 */     TransformerFactory tFactory = TransformerFactory.newInstance();
/* 135 */     Transformer transformer = tFactory.newTransformer();
/*     */ 
/* 137 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 138 */     DOMSource source = new DOMSource(doc);
/* 139 */     StreamResult result = new StreamResult(out);
/* 140 */     transformer.transform(source, result);
/* 141 */     return out.toString();
/*     */   }
/*     */ 
/*     */   private static class Campo
/*     */     implements XMLInforme.XMLComponentBuilder
/*     */   {
/*     */     String name;
/*     */     int tipo;
/*     */ 
/*     */     public String getName()
/*     */     {
/* 157 */       return this.name;
/*     */     }
/*     */ 
/*     */     public void setName(String name)
/*     */     {
/* 165 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public Campo(String name, int tipo) {
/* 169 */       setName(name);
/* 170 */       setTipo(tipo);
/*     */     }
/*     */ 
/*     */     public static Campo getInstance(Element el) {
/* 174 */       String name = el.getAttribute("nombre");
/* 175 */       int tipo = Integer.parseInt(el.getAttribute("tipo"));
/* 176 */       return new Campo(name, tipo);
/*     */     }
/*     */ 
/*     */     public int getTipo()
/*     */     {
/* 183 */       return this.tipo;
/*     */     }
/*     */ 
/*     */     public void setTipo(int tipo)
/*     */     {
/* 191 */       this.tipo = tipo;
/*     */     }
/*     */ 
/*     */     public void toXml(Element root) throws Exception {
/* 195 */       Element n = root.getOwnerDocument().createElement("Campo");
/* 196 */       n.setAttribute("nombre", getName());
/* 197 */       n.setAttribute("tipo", ""+ getTipo());
/* 198 */       root.appendChild(n);
/*     */     }
/*     */ 
/*     */     public Component buildComponent()
/*     */     {
/* 205 */       throw new RuntimeException("Under Construction");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class Combo
/*     */     implements XMLInforme.XMLComponentBuilder
/*     */   {
/*     */     String name;
/*     */     Collection options;
/*     */ 
/*     */     public String getName()
/*     */     {
/* 223 */       return this.name;
/*     */     }
/*     */ 
/*     */     public void setName(String name)
/*     */     {
/* 231 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public Collection getOptions()
/*     */     {
/* 238 */       return this.options;
/*     */     }
/*     */ 
/*     */     public void setOptions(Collection options)
/*     */     {
/* 246 */       this.options = options;
/*     */     }
/*     */ 
/*     */     public Combo(String name, Vector options) {
/* 250 */       setName(name);
/* 251 */       setOptions(options);
/*     */     }
/*     */ 
/*     */     public static Combo getInstance(Element el) {
/* 255 */       String name = el.getAttribute("nombre");
/* 256 */       Vector opts = new Vector(0);
/* 257 */       NodeList ndl = el.getChildNodes();
/* 258 */       for (int x = 0; x < ndl.getLength(); x++) {
/* 259 */         System.out.println("->" + ndl.item(x).getClass());
/* 260 */         if ((ndl.item(x) instanceof Element)) {
/* 261 */           Element elem = (Element)ndl.item(x);
/* 262 */           if (elem.getNodeName().toLowerCase().equals("option"))
/* 263 */             opts.addElement(XMLInforme.Option.getInstance(elem));
/*     */           else {
/* 265 */             throw new RuntimeException(
/* 266 */               "Los combos deben tener opciones");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 272 */       return new Combo(name, opts);
/*     */     }
/*     */ 
/*     */     public void toXml(Element root) throws Exception {
/* 276 */       Element n = root.getOwnerDocument().createElement("combo");
/* 277 */       n.setAttribute("nombre", getName());
/* 278 */       Iterator it = getOptions().iterator();
/* 279 */       while (it.hasNext()) {
/* 280 */         XMLInforme.Option opt = (XMLInforme.Option)it.next();
/* 281 */         System.out.println(opt.createNode(root.getOwnerDocument()));
/* 282 */         System.out.println(n.getChildNodes());
/* 283 */         n.appendChild(opt.createNode(root.getOwnerDocument()));
/*     */       }
/*     */ 
/* 286 */       root.appendChild(n);
/*     */     }
/*     */ 
/*     */     public Component buildComponent()
/*     */     {
/* 293 */       throw new RuntimeException("Under Construction");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class Option
/*     */     implements XMLInforme.XMLComponentBuilder
/*     */   {
/*     */     String value;
/*     */     String description;
/*     */ 
/*     */     public Option(String v, String d)
/*     */     {
/* 309 */       this.value = v;
/* 310 */       this.description = d;
/*     */     }
/*     */ 
/*     */     public Node createNode(Document doc)
/*     */     {
/* 318 */       Element opt = doc.createElement("OPTION");
/* 319 */       opt.setAttribute("value", getValue());
/* 320 */       opt.setAttribute("desc", getDescription());
/* 321 */       return opt;
/*     */     }
/*     */ 
/*     */     public String getDescription()
/*     */     {
/* 328 */       return this.description;
/*     */     }
/*     */ 
/*     */     public void setDescription(String description)
/*     */     {
/* 336 */       this.description = description;
/*     */     }
/*     */ 
/*     */     public String getValue()
/*     */     {
/* 343 */       return this.value;
/*     */     }
/*     */ 
/*     */     public void setValue(String value)
/*     */     {
/* 351 */       this.value = value;
/*     */     }
/*     */ 
/*     */     public static Option getInstance(Element elem) {
/* 355 */       return new Option(elem.getAttribute("value"), 
/* 356 */         elem.getAttribute("desc"));
/*     */     }
/*     */ 
/*     */     public Component buildComponent()
/*     */     {
/* 363 */       throw new RuntimeException("Under Construction");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static abstract interface XMLComponentBuilder
/*     */   {
/*     */     public abstract Component buildComponent();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.xml.XMLInforme
 * JD-Core Version:    0.6.0
 */