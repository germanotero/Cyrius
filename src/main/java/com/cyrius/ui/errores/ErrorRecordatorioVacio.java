/*    */ package com.cyrius.ui.errores;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class ErrorRecordatorioVacio extends JFrame
/*    */ {
/*    */   private JButton jButton1;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   private JLabel jLabel4;
/*    */ 
/*    */   public ErrorRecordatorioVacio()
/*    */   {
/* 25 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 34 */     this.jButton1 = new JButton();
/* 35 */     this.jLabel2 = new JLabel();
/* 36 */     this.jLabel3 = new JLabel();
/* 37 */     this.jLabel1 = new JLabel();
/* 38 */     this.jLabel4 = new JLabel();
/* 39 */     getContentPane().setLayout(null);
/* 40 */     addWindowListener(new WindowAdapter() {
/*    */       public void windowClosing(WindowEvent evt) {
/* 42 */         ErrorRecordatorioVacio.this.exitForm(evt);
/*    */       }
/*    */     });
/* 45 */     this.jButton1.setText("Aceptar");
/* 46 */     this.jButton1.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 48 */         ErrorRecordatorioVacio.this.jButton1ActionPerformed(evt);
/*    */       }
/*    */     });
/* 51 */     getContentPane().add(this.jButton1);
/* 52 */     this.jButton1.setBounds(150, 120, 100, 26);
/* 53 */     this.jLabel2.setText("Faltan datos");
/* 54 */     getContentPane().add(this.jLabel2);
/* 55 */     this.jLabel2.setBounds(160, 20, 70, 16);
/* 56 */     this.jLabel3.setText("Para realizar un Recordatorio,");
/* 57 */     getContentPane().add(this.jLabel3);
/* 58 */     this.jLabel3.setBounds(110, 40, 180, 16);
/* 59 */     this.jLabel1.setText("tiene que seleccionar un dia(posterior al actual),");
/* 60 */     getContentPane().add(this.jLabel1);
/* 61 */     this.jLabel1.setBounds(70, 60, 280, 16);
/* 62 */     this.jLabel4.setText(" un turno(mañana o tarde),y escribir texto.");
/* 63 */     getContentPane().add(this.jLabel4);
/* 64 */     this.jLabel4.setBounds(90, 80, 250, 16);
/* 65 */     pack();
/*    */   }
/*    */ 
/*    */   private void jButton1ActionPerformed(ActionEvent evt)
/*    */   {
/* 71 */     setVisible(false);
/*    */   }
/*    */ 
/*    */   private void exitForm(WindowEvent evt)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.errores.ErrorRecordatorioVacio
 * JD-Core Version:    0.6.0
 */