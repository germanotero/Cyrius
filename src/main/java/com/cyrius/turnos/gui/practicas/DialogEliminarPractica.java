/*     */ package com.cyrius.turnos.gui.practicas;
/*     */ 
/*     */ import com.cyrius.entities.Practica;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class DialogEliminarPractica extends JDialog
/*     */ {
/*     */   private JPanel panel;
/*     */   private JButton btnSi;
/*     */   private JButton btnNo;
/*     */   private JLabel lblSeguro;
/*     */   private String nombre;
/*     */   private Practica prac;
/*     */   private JFrame parent;
/*     */ 
/*     */   public DialogEliminarPractica(JFrame parent, Practica prac)
/*     */   {
/*  45 */     super(parent, true);
/*  46 */     this.parent = parent;
/*  47 */     this.prac = prac;
/*  48 */     initComponents();
/*  49 */     initDialog();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  53 */     this.panel = new JPanel();
/*  54 */     this.lblSeguro = 
/*  55 */       new JLabel("¿Esta Seguro de eliminar la practica " + 
/*  55 */       this.prac.getDescription() + "?");
/*  56 */     this.btnSi = new JButton("Si");
/*  57 */     this.btnNo = new JButton("No");
/*  58 */     this.lblSeguro.setBounds(10, 20, this.prac.getDescription().length() + 400, 20);
/*  59 */     this.btnSi.setBounds(100, 50, 80, 20);
/*  60 */     this.btnNo.setBounds(230, 50, 90, 20);
/*  61 */     this.panel.setLayout(null);
/*  62 */     this.panel.add(this.btnSi);
/*  63 */     this.panel.add(this.btnNo);
/*  64 */     this.panel.add(this.lblSeguro);
/*  65 */     this.btnSi.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  67 */         DialogEliminarPractica.this.btnAceptarActionPerformed(arg0);
/*     */       }
/*     */     });
/*  70 */     this.btnNo.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  72 */         DialogEliminarPractica.this.btnCerrarActionPerformed(arg0);
/*     */       }
/*     */     });
/*  75 */     getContentPane().add(this.panel);
/*  76 */     pack();
/*     */   }
/*     */ 
/*     */   private void btnCerrarActionPerformed(ActionEvent arg0) {
/*  80 */     dispose();
/*     */   }
/*     */ 
/*     */   private void initDialog() {
/*  84 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  85 */     int resAncho = (int)screenSize.getWidth();
/*  86 */     int resAlto = (int)screenSize.getHeight();
/*     */ 
/*  88 */     setBounds(
/*  89 */       resAncho / 2 - (this.prac.getDescription().length() + 400) / 2, 
/*  90 */       resAlto / 2 - 62, 
/*  91 */       this.prac.getDescription().length() + 400, 132);
/*     */   }
/*     */ 
/*     */   private void btnAceptarActionPerformed(ActionEvent arg0)
/*     */   {
/* 104 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.DialogEliminarPractica
 * JD-Core Version:    0.6.0
 */