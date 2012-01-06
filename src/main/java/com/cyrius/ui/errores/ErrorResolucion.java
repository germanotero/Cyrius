/*    */ package com.cyrius.ui.errores;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class ErrorResolucion extends JFrame
/*    */ {
/*    */   private JButton jButton1;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   private JLabel jLabel4;
/*    */ 
/*    */   public ErrorResolucion()
/*    */   {
/* 29 */     initComponents();
/*    */ 
/* 31 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 32 */     int resAncho = (int)screenSize.getWidth();
/* 33 */     int resAlto = (int)screenSize.getHeight();
/* 34 */     this.jLabel4.setText(new String(resAncho + "x" + resAlto));
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 43 */     this.jLabel1 = new JLabel();
/* 44 */     this.jLabel2 = new JLabel();
/* 45 */     this.jButton1 = new JButton();
/* 46 */     this.jLabel3 = new JLabel();
/* 47 */     this.jLabel4 = new JLabel();
/*    */ 
/* 49 */     getContentPane().setLayout(null);
/*    */ 
/* 51 */     addWindowListener(new WindowAdapter() {
/*    */       public void windowClosing(WindowEvent evt) {
/* 53 */         ErrorResolucion.this.exitForm(evt);
/*    */       }
/*    */     });
/* 57 */     this.jLabel1
/* 58 */       .setText("La pantalla tiene que tener como minimo una resolucion");
/* 59 */     getContentPane().add(this.jLabel1);
/* 60 */     this.jLabel1.setBounds(50, 40, 320, 20);
/*    */ 
/* 62 */     this.jLabel2.setText("de 800X600");
/* 63 */     getContentPane().add(this.jLabel2);
/* 64 */     this.jLabel2.setBounds(170, 70, 70, 16);
/*    */ 
/* 66 */     this.jButton1.setText("Salir");
/* 67 */     this.jButton1.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 69 */         ErrorResolucion.this.jButton1ActionPerformed(evt);
/*    */       }
/*    */     });
/* 73 */     getContentPane().add(this.jButton1);
/* 74 */     this.jButton1.setBounds(180, 120, 60, 26);
/*    */ 
/* 76 */     this.jLabel3.setText("Usted tiene una resolucion de");
/* 77 */     getContentPane().add(this.jLabel3);
/* 78 */     this.jLabel3.setBounds(90, 90, 170, 16);
/*    */ 
/* 80 */     this.jLabel4.setText("jLabel4");
/* 81 */     getContentPane().add(this.jLabel4);
/* 82 */     this.jLabel4.setBounds(271, 90, 120, 16);
/*    */ 
/* 84 */     pack();
/*    */   }
/*    */ 
/*    */   private void jButton1ActionPerformed(ActionEvent evt)
/*    */   {
/* 90 */     setVisible(false);
/* 91 */     setVisible(false);
/*    */   }
/*    */ 
/*    */   private void exitForm(WindowEvent evt)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.errores.ErrorResolucion
 * JD-Core Version:    0.6.0
 */