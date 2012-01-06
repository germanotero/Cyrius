/*     */ package com.cyrius.ui.errores;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.text.JTextComponent;
/*     */ 
/*     */ public class ErrorGeneral extends JDialog
/*     */ {
/*     */   public static final byte ASK4CONFIGFILE = 1;
/*     */   private JButton btnAceptar;
/*     */   private JButton btnDetails;
/*     */   private JScrollPane scroll;
/*     */   private JTextComponent txt;
/*  33 */   private int limite = 0;
/*     */   private String texto;
/*     */   private String mensaje;
/*  39 */   private byte state = 0;
/*     */ 
/*     */   public ErrorGeneral(JFrame padre, String texto)
/*     */   {
/*  43 */     super(padre, true);
/*  44 */     this.texto = texto;
/*  45 */     initComponents();
/*  46 */     initDialog();
/*  47 */     this.btnDetails.setVisible(false);
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(JFrame padre, String texto, String mensaje, byte state) {
/*  51 */     super(padre, true);
/*  52 */     this.texto = texto;
/*  53 */     this.mensaje = mensaje;
/*  54 */     this.state = state;
/*  55 */     initComponents();
/*  56 */     initDialog();
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(JDialog padre, String texto, String mensaje, byte state) {
/*  60 */     super(padre, true);
/*  61 */     this.texto = texto;
/*  62 */     this.mensaje = mensaje;
/*  63 */     this.state = state;
/*  64 */     initComponents();
/*  65 */     initDialog();
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(JFrame padre, String texto, String mensaje) {
/*  69 */     super(padre, true);
/*  70 */     this.texto = texto;
/*  71 */     this.mensaje = mensaje;
/*  72 */     initComponents();
/*  73 */     initDialog();
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(String texto, String mensaje)
/*     */   {
/*  78 */     this.texto = texto;
/*  79 */     this.mensaje = mensaje;
/*  80 */     initComponents();
/*  81 */     initDialog();
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(JDialog padre, String texto) {
/*  85 */     super(padre, true);
/*  86 */     this.texto = texto;
/*  87 */     initComponents();
/*  88 */     initDialog();
/*  89 */     this.btnDetails.setVisible(false);
/*     */   }
/*     */ 
/*     */   public ErrorGeneral(JDialog padre, String texto, String mensaje) {
/*  93 */     super(padre, true);
/*  94 */     this.texto = texto;
/*  95 */     this.mensaje = mensaje;
/*  96 */     initComponents();
/*  97 */     initDialog();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/* 101 */     this.btnAceptar = new JButton();
/* 102 */     this.btnDetails = new JButton();
/* 103 */     this.scroll = new JScrollPane();
/* 104 */     this.txt = new JTextArea();
/* 105 */     this.txt.setText(this.texto);
/* 106 */     getContentPane().setLayout(null);
/* 107 */     this.txt.setOpaque(false);
/* 108 */     this.txt.setBorder(null);
/* 109 */     this.btnAceptar.setText("Aceptar");
/* 110 */     this.btnAceptar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 112 */         ErrorGeneral.this.btnAceptarActionPerformed(evt);
/*     */       }
/*     */     });
/* 115 */     getContentPane().add(this.btnAceptar);
/* 116 */     this.btnAceptar.setBounds(270, 210, 100, 26);
/* 117 */     this.btnDetails.setText("Detalles");
/* 118 */     this.btnDetails.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 120 */         ErrorGeneral.this.btnDetailsActionPerformed(evt);
/*     */       }
/*     */     });
/* 123 */     this.btnDetails.setVisible(false);
/* 124 */     getContentPane().add(this.btnDetails);
/* 125 */     this.btnDetails.setBounds(390, 210, 100, 26);
/* 126 */     this.txt.setBackground(new Color(204, 204, 204));
/* 127 */     this.txt.setEditable(false);
/* 128 */     this.txt.setBorder(null);
/* 129 */     this.scroll.setViewportView(this.txt);
/* 130 */     getContentPane().add(this.scroll);
/* 131 */     this.scroll.setBounds(10, 10, 630, 200);
/* 132 */     setResizable(false);
/* 133 */     pack();
/*     */   }
/*     */ 
/*     */   private void initDialog()
/*     */   {
/* 140 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 141 */     int resAncho = (int)screenSize.getWidth();
/* 142 */     int resAlto = (int)screenSize.getHeight();
/* 143 */     setBounds(resAncho / 2 - 300, resAlto / 2 - 125, 650, 270);
/* 144 */     this.btnDetails.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void btnAceptarActionPerformed(ActionEvent evt) {
/* 148 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void btnDetailsActionPerformed(ActionEvent evt)
/*     */   {
/* 158 */     this.txt.setText(this.mensaje);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.errores.ErrorGeneral
 * JD-Core Version:    0.6.0
 */