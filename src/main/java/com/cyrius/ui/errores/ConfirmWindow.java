/*    */ package com.cyrius.ui.errores;
/*    */ 
/*    */ import com.framework.actions.ActionSupporterCyriusForm;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ConfirmWindow extends JDialog
/*    */ {
/*    */   private JPanel panel;
/*    */   private JButton btnSi;
/*    */   private JButton btnNo;
/*    */   private JLabel lblSeguro;
/*    */   private String message;
/*    */   private ActionSupporterCyriusForm parent;
/*    */ 
/*    */   public ConfirmWindow(ActionSupporterCyriusForm padre, String message)
/*    */   {
/* 46 */     setModal(true);
/* 47 */     this.parent = padre;
/* 48 */     this.message = message;
/* 49 */     initComponents();
/* 50 */     initDialog();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 55 */     this.panel = new JPanel();
/* 56 */     this.lblSeguro = new JLabel("Error: " + this.message);
/* 57 */     this.btnSi = new JButton("Si");
/* 58 */     this.btnNo = new JButton("No");
/* 59 */     this.lblSeguro.setBounds(10, 20, 250, 20);
/* 60 */     JLabel lblPregunta = new JLabel("EstÃ¡ seguro de continuar?");
/* 61 */     lblPregunta.setBounds(10, 40, 250, 20);
/* 62 */     this.btnSi.setBounds(50, 60, 80, 20);
/* 63 */     this.btnNo.setBounds(150, 60, 90, 20);
/* 64 */     this.panel.setLayout(null);
/* 65 */     this.panel.add(this.btnSi);
/* 66 */     this.panel.add(this.btnNo);
/* 67 */     this.panel.add(lblPregunta);
/* 68 */     this.btnSi.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 70 */         ConfirmWindow.this.parent.acceptAction();
/* 71 */         ConfirmWindow.this.setVisible(false);
/*    */       }
/*    */     });
/* 75 */     this.btnNo.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 77 */         ConfirmWindow.this.parent.cancelAction();
/* 78 */         ConfirmWindow.this.setVisible(false);
/*    */       }
/*    */     });
/* 81 */     this.panel.add(this.lblSeguro);
/* 82 */     getContentPane().add(this.panel);
/* 83 */     pack();
/*    */   }
/*    */ 
/*    */   private void initDialog() {
/* 87 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 88 */     int resAncho = (int)screenSize.getWidth();
/* 89 */     int resAlto = (int)screenSize.getHeight();
/* 90 */     setBounds(resAncho / 2 - 200, resAlto / 2 - 66, 300, 132);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.errores.ConfirmWindow
 * JD-Core Version:    0.6.0
 */