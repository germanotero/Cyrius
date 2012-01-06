/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import com.cyrius.entities.Recordatorio;
/*     */ import com.cyrius.searchers.BuscadorRecordatorio;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.border.BevelBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class FrameBuscarRecs extends JFrame
/*     */ {
/*     */   private JButton btnBorrar;
/*     */   private JButton btnCancelar;
/*     */   private JButton btnVerRec;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable jTable1;
/*     */   private Long[] vec;
/*     */   private Object[][] mat;
/*  46 */   private VerTurnosJPanel parent = null;
/*     */ 
/*     */   public FrameBuscarRecs(VerTurnosJPanel parent)
/*     */   {
/*     */     try {
/*  51 */       preinitTable();
/*     */     } catch (Exception e) {
/*  53 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*     */ 
/*  56 */     this.parent = parent;
/*  57 */     initComponents();
/*  58 */     setTitle("Recordatorios");
/*  59 */     setResizable(false);
/*     */   }
/*     */ 
/*     */   private void preinitTable()
/*     */   {
/*     */     try
/*     */     {
/*  67 */       Collection col = new BuscadorRecordatorio().findAll();
/*  68 */       this.mat = new Object[col.size()][3];
/*  69 */       this.vec = new Long[col.size()];
/*     */ 
/*  71 */       Iterator it = col.iterator();
/*  72 */       int i = 0;
/*     */ 
/*  74 */       while (it.hasNext()) {
/*  75 */         Recordatorio r = (Recordatorio)it.next();
/*  76 */         this.vec[i] = r.getId();
/*  77 */         this.mat[i][0] = r.getFecha();
/*  78 */         this.mat[i][1] = r.getMensaje();
/*  79 */         i++;
/*     */       }
/*     */     } catch (Exception ex) {
/*  82 */       ExceptionHandler.getInstance().handle(this, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  87 */     this.jPanel1 = new JPanel();
/*  88 */     this.jScrollPane1 = new JScrollPane();
/*  89 */     this.jTable1 = new JTable();
/*  90 */     this.jLabel1 = new JLabel();
/*  91 */     this.btnVerRec = new JButton();
/*  92 */     this.btnCancelar = new JButton();
/*  93 */     this.btnBorrar = new JButton();
/*  94 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  96 */         FrameBuscarRecs.this.exitForm(evt);
/*     */       }
/*     */     });
/*  99 */     this.jPanel1.setLayout(null);
/* 100 */     this.jPanel1.setBorder(
/* 101 */       new BevelBorder(0));
/* 102 */     this.jTable1.setModel(
/* 103 */       new DefaultTableModel(this.mat, 
/* 103 */       new String[] { "Fecha", "Mensaje" }) {
/* 104 */       boolean[] canEdit = new boolean[2];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 107 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 110 */     this.jTable1.setSelectionMode(0);
/* 111 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 112 */     this.jPanel1.add(this.jScrollPane1);
/* 113 */     this.jScrollPane1.setBounds(10, 60, 390, 100);
/* 114 */     this.jLabel1.setFont(new Font("Times New Roman", 1, 18));
/* 115 */     this.jLabel1.setText("Recordatorios");
/* 116 */     this.jPanel1.add(this.jLabel1);
/* 117 */     this.jLabel1.setBounds(140, 20, 120, 30);
/* 118 */     this.btnVerRec.setText("Ver");
/* 119 */     this.btnVerRec.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 121 */         FrameBuscarRecs.this.btnVerRecActionPerformed(evt);
/*     */       }
/*     */     });
/* 124 */     this.jPanel1.add(this.btnVerRec);
/* 125 */     this.btnVerRec.setBounds(30, 170, 90, 26);
/* 126 */     this.btnCancelar.setText("Cancelar");
/* 127 */     this.btnCancelar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 129 */         FrameBuscarRecs.this.btnCancelarActionPerformed(evt);
/*     */       }
/*     */     });
/* 132 */     this.jPanel1.add(this.btnCancelar);
/* 133 */     this.btnCancelar.setBounds(300, 170, 90, 26);
/* 134 */     this.btnBorrar.setText("Borrar");
/* 135 */     this.btnBorrar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 137 */         FrameBuscarRecs.this.btnBorrarActionPerformed(evt);
/*     */       }
/*     */     });
/* 140 */     this.jPanel1.add(this.btnBorrar);
/* 141 */     this.btnBorrar.setBounds(170, 170, 80, 26);
/* 142 */     getContentPane().add(this.jPanel1, "Center");
/* 143 */     pack();
/*     */   }
/*     */ 
/*     */   public void btnBorrarActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try {
/* 149 */       Recordatorio rec = new Recordatorio();
/* 150 */       rec.setId(this.vec[this.jTable1.getSelectedRow()]);
/*     */ 
/* 154 */       this.parent.checkRecordatorio();
/* 155 */       preinitTable();
/* 156 */       this.jTable1.setModel(
/* 157 */         new DefaultTableModel(this.mat, 
/* 157 */         new String[] { "Fecha", "Mensaje" }) {
/* 158 */         boolean[] canEdit = new boolean[2];
/*     */ 
/*     */         public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 161 */           return this.canEdit[columnIndex];
/*     */         }
/*     */       });
/* 164 */       this.jTable1.setSelectionMode(0);
/* 165 */       this.jTable1.repaint();
/*     */     } catch (Exception e) {
/* 167 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnCancelarActionPerformed(ActionEvent evt) {
/*     */     try {
/* 173 */       setVisible(false);
/* 174 */       this.parent.checkRecordatorio();
/* 175 */       this.parent.checkRecordatorio();
/*     */     } catch (Exception ex) {
/* 177 */       ExceptionHandler.getInstance().handle(this, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnVerRecActionPerformed(ActionEvent evt) {
/* 182 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 183 */     int resAncho = (int)screenSize.getWidth();
/* 184 */     int resAlto = (int)screenSize.getHeight();
/* 185 */     Recordatorio rec = new Recordatorio();
/* 186 */     rec.setId(this.vec[this.jTable1.getSelectedRow()]);
/* 187 */     rec.setFecha((Timestamp)this.mat[this.jTable1.getSelectedRow()][0]);
/* 188 */     rec.setMensaje((String)this.mat[this.jTable1.getSelectedRow()][1]);
/*     */ 
/* 190 */     FrameVerRecordatorio showRec = new FrameVerRecordatorio(rec, this);
/* 191 */     showRec.setBounds(resAncho / 2 - 350, resAlto / 2 - 150, 700, 
/* 192 */       300);
/* 193 */     showRec.show();
/*     */   }
/*     */ 
/*     */   private void exitForm(WindowEvent evt)
/*     */   {
/* 200 */     setVisible(false);
/* 201 */     dispose();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.FrameBuscarRecs
 * JD-Core Version:    0.6.0
 */