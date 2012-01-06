/*     */ package com.cyrius.ui;
/*     */ 
/*     */ import com.cyrius.components.CyriusComboMedicos;
/*     */ import com.cyrius.config.CyriusBusinessConfig;
/*     */ import com.cyrius.config.CyriusBusinessConfigSaver;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class OpcionesJDialog extends JDialog
/*     */ {
/*     */   private JLabel lblMedico;
/*     */   private CyriusComboMedicos cbMedicos;
/*     */   private JButton btnCancelar;
/*     */   private JButton btnAceptar;
/*     */ 
/*     */   public OpcionesJDialog()
/*     */   {
/*  37 */     setModal(true);
/*  38 */     setTitle("Opciones");
/*  39 */     initGUI();
/*     */   }
/*     */ 
/*     */   public void initGUI() {
/*     */     try {
/*  44 */       this.btnAceptar = new JButton();
/*  45 */       this.btnAceptar.setPreferredSize(new Dimension(70, 20));
/*  46 */       this.btnCancelar = new JButton();
/*  47 */       this.btnCancelar.setPreferredSize(new Dimension(70, 20));
/*  48 */       this.lblMedico = new JLabel();
/*  49 */       this.cbMedicos = new CyriusComboMedicos();
/*  50 */       this.cbMedicos.setPreferredSize(new Dimension(220, 20));
/*  51 */       GridBagLayout layout = new GridBagLayout();
/*  52 */       layout.columnWeights = new double[] { 0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 
/*  53 */         0.1D };
/*  54 */       layout.columnWidths = new int[] { 7, 7, 7, 7, 7, 7, 7 };
/*  55 */       layout.rowWeights = new double[] { 0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 
/*  56 */         0.1D, 0.1D, 0.1D, 0.1D };
/*  57 */       layout.rowHeights = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
/*  58 */       getContentPane().setLayout(layout);
/*  59 */       setSize(new Dimension(400, 300));
/*  60 */       getContentPane().add(
/*  61 */         this.btnAceptar, 
/*  62 */         new GridBagConstraints(1, 9, 1, 1, 0.0D, 0.0D, 
/*  63 */         10, 0, 
/*  64 */         new Insets(0, 0, 0, 0), 0, 0));
/*  65 */       getContentPane().add(
/*  66 */         this.btnCancelar, 
/*  67 */         new GridBagConstraints(5, 9, 1, 1, 0.0D, 0.0D, 
/*  68 */         10, 0, 
/*  69 */         new Insets(0, 0, 0, 0), 0, 0));
/*  70 */       getContentPane().add(
/*  71 */         this.lblMedico, 
/*  72 */         new GridBagConstraints(1, 7, 1, 1, 0.0D, 0.0D, 
/*  73 */         22, 
/*  74 */         0, new Insets(0, 0, 0, 0), 0, 
/*  75 */         0));
/*  76 */       getContentPane().add(
/*  77 */         this.cbMedicos, 
/*  78 */         new GridBagConstraints(2, 7, 4, 1, 0.0D, 0.0D, 
/*  79 */         10, 0, 
/*  80 */         new Insets(0, 0, 0, 0), 0, 0));
/*  81 */       this.lblMedico.setText("Medico por Defecto:");
/*     */       try {
/*  83 */         this.cbMedicos.setTodos();
/*  84 */         this.cbMedicos.refreshComponent();
/*     */       }
/*     */       catch (Exception e) {
/*  87 */         ExceptionHandler.getInstance().handle(this, e);
/*     */       }
/*  89 */       this.btnAceptar.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/*  91 */           OpcionesJDialog.this.btnAceptarActionPerforned(evt);
/*     */         }
/*     */       });
/*  94 */       this.btnAceptar
/*  95 */         .setBorder(BorderFactory.createCompoundBorder(null, null));
/*  96 */       this.btnAceptar.setText("Aceptar");
/*  97 */       this.btnCancelar.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/*  99 */           OpcionesJDialog.this.btnCancelarActionPerformed(evt);
/*     */         }
/*     */       });
/* 102 */       this.btnCancelar.setBorder(
/* 103 */         BorderFactory.createCompoundBorder(null, null));
/* 104 */       this.btnCancelar.setText("Cancelar");
/* 105 */       postInit();
/*     */     } catch (Exception e) {
/* 107 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void postInit() {
/* 112 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 113 */     int resAncho = (int)screenSize.getWidth();
/* 114 */     int resAlto = (int)screenSize.getHeight();
/* 115 */     setBounds(resAncho / 2 - 200, resAlto / 2 - 150, 400, 300);
/*     */   }
/*     */ 
/*     */   private void btnCancelarActionPerformed(ActionEvent evt) {
/* 119 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void btnAceptarActionPerforned(ActionEvent evt) {
/*     */     try {
/* 124 */       if (obligatorios())
/*     */       {
/* 126 */         CyriusBusinessConfigSaver.writeConfiguration(new CyriusBusinessConfig(
/* 127 */           this.cbMedicos.getSelectedMedico()));
/* 128 */         setVisible(false);
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean obligatorios() {
/* 136 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.OpcionesJDialog
 * JD-Core Version:    0.6.0
 */