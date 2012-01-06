/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.entities.ObraSocial;
/*     */ import com.cyrius.entities.Practica;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class PanelPrimerPaso extends JPanel
/*     */ {
/*     */   private JButton btnSiguientePrimerPanel;
/*     */   private CbPracticas cbPracticas;
/*     */   private CbMedicos cbMedicos;
/*     */   private CbObrasSociales cbObras;
/*     */   private JLabel lbTipoPractica;
/*     */   private JLabel lbTurnoPara;
/*     */   private JLabel lblObraSocial;
/*     */   private JLabel foto3d;
/*     */   private JLabel fotoCyrius;
/*     */   private boolean practica;
/*     */   private boolean medico;
/*     */   private boolean obra;
/*     */   private PanelNuevoTurno parent;
/*     */ 
/*     */   public PanelPrimerPaso(PanelNuevoTurno parent)
/*     */   {
/*  51 */     this.parent = parent;
/*  52 */     initComponents();
/*  53 */     this.cbPracticas.setSelectedIndex(-1);
/*  54 */     this.cbMedicos.setEnabled(false);
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  58 */     this.lbTipoPractica = new JLabel();
/*  59 */     this.lbTurnoPara = new JLabel();
/*  60 */     this.fotoCyrius = new JLabel();
/*  61 */     this.cbPracticas = new CbPracticas();
/*  62 */     this.cbMedicos = new CbMedicos();
/*  63 */     this.cbObras = new CbObrasSociales();
/*  64 */     this.btnSiguientePrimerPanel = new JButton();
/*  65 */     this.foto3d = new JLabel();
/*  66 */     this.lblObraSocial = new JLabel();
/*  67 */     setMinimumSize(new Dimension(800, 600));
/*  68 */     setPreferredSize(new Dimension(800, 600));
/*  69 */     setLayout(null);
/*  70 */     setBorder(
/*  71 */       new SoftBevelBorder(0));
/*  72 */     this.lbTipoPractica.setText("Medico:");
/*  73 */     add(this.lbTipoPractica);
/*  74 */     this.lbTipoPractica.setBounds(20, 75, 90, 16);
/*  75 */     this.cbPracticas.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  77 */         PanelPrimerPaso.this.cbPracticasActionPerformed(evt);
/*     */       }
/*     */     });
/*  80 */     this.cbPracticas.setMaximumRowCount(17);
/*  81 */     add(this.cbPracticas);
/*  82 */     this.cbPracticas.setBounds(105, 30, 240, 20);
/*  83 */     this.cbPracticas.setEditable(true);
/*  84 */     this.lbTurnoPara.setText("Practica:");
/*  85 */     add(this.lbTurnoPara);
/*  86 */     this.lbTurnoPara.setBounds(20, 30, 80, 16);
/*  87 */     this.cbMedicos.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  89 */         PanelPrimerPaso.this.cbMedicosActionPerformed(evt);
/*     */       }
/*     */     });
/*  92 */     this.cbMedicos.setEditable(true);
/*  93 */     add(this.cbMedicos);
/*  94 */     this.cbMedicos.setBounds(105, 75, 240, 20);
/*  95 */     this.cbObras.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         PanelPrimerPaso.this.cbObrasParaActionPerformed(evt);
/*     */       }
/*     */     });
/* 100 */     add(this.cbObras);
/* 101 */     this.cbObras.setBounds(470, 75, 240, 20);
/* 102 */     this.lblObraSocial.setText("Obra Social:");
/* 103 */     add(this.lblObraSocial);
/* 104 */     this.lblObraSocial.setBounds(380, 75, 90, 16);
/* 105 */     this.btnSiguientePrimerPanel.setText("Siguiente >");
/* 106 */     this.btnSiguientePrimerPanel
/* 107 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 109 */         PanelPrimerPaso.this.btnSiguienteActionPerformed(evt);
/*     */       }
/*     */     });
/* 112 */     add(this.btnSiguientePrimerPanel);
/* 113 */     this.btnSiguientePrimerPanel.setBounds(550, 390, 120, 40);
/* 114 */     this.foto3d.setIcon(new ImageIcon("./Img/Eco3d.jpg"));
/* 115 */     add(this.foto3d);
/* 116 */     this.foto3d.setBounds(550, 100, 300, 330);
/* 117 */     this.fotoCyrius.setIcon(new ImageIcon("./Img/cyrius.gif"));
/* 118 */     add(this.fotoCyrius);
/* 119 */     this.fotoCyrius.setBounds(30, 200, 300, 330);
/* 120 */     this.cbObras.setEnabled(false);
/* 121 */     setBounds(450, 10, 140, 24);
/* 122 */     this.btnSiguientePrimerPanel.setEnabled(false);
/*     */   }
/*     */ 
/*     */   private void btnSiguienteActionPerformed(ActionEvent evt) {
/* 126 */     if ((this.medico) && (this.practica))
/* 127 */       this.parent.setSelectedIndex(1);
/*     */   }
/*     */ 
/*     */   private void cbPracticasActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try {
/* 133 */       if (this.cbPracticas.getSelectedIndex() > -1) {
/* 134 */         this.practica = true;
/* 135 */         this.cbMedicos.setEnabled(true);
/* 136 */         this.cbMedicos.setMedico(this.cbPracticas.getSelectedPra());
/*     */       }
/*     */ 
/* 139 */       if ((this.medico) && (this.obra)) {
/* 140 */         this.btnSiguientePrimerPanel.setEnabled(true);
/*     */ 
/* 142 */         this.parent.setEnabledAt(2, true);
/* 143 */         this.parent.setEnabledAt(1, true);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 147 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void cbMedicosActionPerformed(ActionEvent evt) {
/*     */     try {
/* 153 */       if (this.cbMedicos.getSelectedIndex() > -1) {
/* 154 */         this.parent.setMedico(this.cbMedicos.getSelectedMe());
/* 155 */         this.medico = true;
/* 156 */         this.cbObras.setEnabled(true);
/* 157 */         this.cbObras.setObras(this.cbMedicos.getSelectedMe());
/*     */       }
/*     */ 
/* 160 */       if ((this.practica) && (this.obra)) {
/* 161 */         this.btnSiguientePrimerPanel.setEnabled(true);
/* 162 */         this.parent.setEnabledAt(2, true);
/* 163 */         this.parent.setEnabledAt(1, true);
/*     */       }
/*     */     } catch (Exception e) {
/* 166 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void cbObrasParaActionPerformed(ActionEvent evt) {
/* 171 */     if (this.cbObras.getSelectedIndex() > -1) {
/* 172 */       this.obra = true;
/*     */     }
/*     */ 
/* 175 */     if ((this.medico) && (this.practica) && (this.obra)) {
/* 176 */       this.btnSiguientePrimerPanel.setEnabled(true);
/* 177 */       this.parent.setEnabledAt(2, true);
/* 178 */       this.parent.setEnabledAt(1, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Practica getSelectedPractica() {
/* 183 */     return this.cbPracticas.getSelectedPra();
/*     */   }
/*     */ 
/*     */   public Medico getSelectedMedico() {
/* 187 */     return this.cbMedicos.getSelectedMe();
/*     */   }
/*     */ 
/*     */   public ObraSocial getSelectedObra() {
/* 191 */     return this.cbObras.getSelectedOS();
/*     */   }
/*     */ 
/*     */   public int getSelectedOsindex() {
/* 195 */     return this.cbObras.getSelectedIndex();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.PanelPrimerPaso
 * JD-Core Version:    0.6.0
 */