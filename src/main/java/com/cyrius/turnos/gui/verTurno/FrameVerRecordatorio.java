/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import com.cyrius.entities.Recordatorio;
/*     */ import java.awt.Container;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.Timestamp;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.border.BevelBorder;
/*     */ 
/*     */ public class FrameVerRecordatorio extends JFrame
/*     */ {
/*     */   private FrameBuscarRecs parent;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JEditorPane jEditRecordatorio;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JLabel lblDia;
/*     */   private JLabel lblRecDia;
/*     */ 
/*     */   public FrameVerRecordatorio(Recordatorio rec, FrameBuscarRecs parent)
/*     */   {
/*  40 */     initComponents(rec);
/*  41 */     setTitle("Ver recordatorio prara el dia: " + rec.getFecha());
/*  42 */     this.jEditRecordatorio.setEditable(false);
/*  43 */     this.parent = parent;
/*     */   }
/*     */ 
/*     */   private void initComponents(Recordatorio rec)
/*     */   {
/*  52 */     this.jPanel1 = new JPanel();
/*  53 */     this.lblRecDia = new JLabel();
/*  54 */     this.lblDia = new JLabel();
/*  55 */     this.jScrollPane1 = new JScrollPane();
/*  56 */     this.jEditRecordatorio = new JEditorPane();
/*  57 */     this.jButton1 = new JButton();
/*  58 */     this.jButton2 = new JButton();
/*     */ 
/*  60 */     setResizable(false);
/*  61 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  63 */         FrameVerRecordatorio.this.exitForm(evt);
/*     */       }
/*     */     });
/*  67 */     this.jPanel1.setLayout(null);
/*     */ 
/*  69 */     this.jPanel1.setBorder(
/*  70 */       new BevelBorder(0));
/*  71 */     this.lblRecDia.setText("Recordatorio del dia: ");
/*  72 */     this.jPanel1.add(this.lblRecDia);
/*  73 */     this.lblRecDia.setBounds(60, 20, 120, 16);
/*     */ 
/*  75 */     this.lblDia.setText(rec.getFecha().toString());
/*  76 */     this.jPanel1.add(this.lblDia);
/*  77 */     this.lblDia.setBounds(180, 20, 470, 16);
/*     */ 
/*  79 */     this.jScrollPane1.setViewportView(this.jEditRecordatorio);
/*     */ 
/*  81 */     this.jPanel1.add(this.jScrollPane1);
/*  82 */     this.jScrollPane1.setBounds(10, 50, 680, 170);
/*     */ 
/*  84 */     this.jButton1.setText("Volver");
/*  85 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  87 */         FrameVerRecordatorio.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  91 */     this.jPanel1.add(this.jButton1);
/*  92 */     this.jButton1.setBounds(620, 250, 70, 20);
/*     */ 
/*  94 */     this.jButton2.setText("Eliminar");
/*  95 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         FrameVerRecordatorio.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 101 */     this.jPanel1.add(this.jButton2);
/* 102 */     this.jButton2.setBounds(300, 230, 80, 26);
/*     */ 
/* 104 */     getContentPane().add(this.jPanel1, "Center");
/* 105 */     this.jEditRecordatorio.setText(rec.getMensaje());
/* 106 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 114 */     this.parent.btnBorrarActionPerformed(evt);
/* 115 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 121 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void exitForm(WindowEvent evt)
/*     */   {
/* 126 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.FrameVerRecordatorio
 * JD-Core Version:    0.6.0
 */