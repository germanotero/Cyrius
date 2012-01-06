/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.standbysoft.datepicker.JDatePicker;
/*     */ 
/*     */ public class DialogBorrarTurnos extends JDialog
/*     */   implements Runnable
/*     */ {
/*     */   private JPanel panel;
/*     */   private JButton btnAceptar;
/*     */   private JDatePicker desde;
/*     */   private JDatePicker hasta;
/*     */   private JLabel ingPass;
/*     */   private JPasswordField pass;
/*     */ 
/*     */   public DialogBorrarTurnos(JFrame parent)
/*     */   {
/*  46 */     super(parent, "Borrar Turnos", true);
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  50 */     this.desde = new JDatePicker();
/*  51 */     this.hasta = new JDatePicker();
/*  52 */     this.panel = new JPanel();
/*  53 */     this.btnAceptar = new JButton("Aceptar");
/*  54 */     this.ingPass = new JLabel();
/*  55 */     this.pass = new JPasswordField();
/*  56 */     this.panel.setLayout(null);
/*  57 */     this.ingPass.setText("Ingrese la Clave: ");
/*  58 */     this.ingPass.setBounds(30, 70, 130, 20);
/*  59 */     this.pass.setBounds(145, 70, 100, 20);
/*  60 */     this.panel.add(this.ingPass);
/*  61 */     this.btnAceptar.setBounds(110, 100, 130, 30);
/*  62 */     this.panel.add(this.pass);
/*  63 */     this.desde.setBounds(10, 5, 150, 20);
/*  64 */     this.desde
/*  65 */       .setToolTipText("Fecha desde la cual se desean borrar los Turnos.");
/*  66 */     this.panel.add(this.desde);
/*  67 */     this.hasta.setBounds(190, 5, 150, 20);
/*  68 */     this.hasta
/*  69 */       .setToolTipText("Fecha hasta la cual se desean borrar los Turnos.");
/*  70 */     this.panel.add(this.hasta);
/*  71 */     this.panel.add(this.btnAceptar);
/*  72 */     this.btnAceptar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  74 */         DialogBorrarTurnos.this.btnAceptarActionPerformed(arg0);
/*     */       }
/*     */     });
/*  77 */     getContentPane().add(this.panel);
/*  78 */     pack();
/*     */   }
/*     */ 
/*     */   private void initDialog() {
/*  82 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  83 */     int resAncho = (int)screenSize.getWidth();
/*  84 */     int resAlto = (int)screenSize.getHeight();
/*  85 */     setBounds(resAncho / 2 - 220, resAlto / 2 - 166, 350, 210);
/*     */   }
/*     */ 
/*     */   private void btnAceptarActionPerformed(ActionEvent arg0) {
/*  89 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  90 */     int resAncho = (int)screenSize.getWidth();
/*  91 */     int resAlto = (int)screenSize.getHeight();
/*  92 */     GregorianCalendar to = new GregorianCalendar();
/*  93 */     to.setTime(this.hasta.getDateSelectionModel().getLeadSelectionDate());
/*  94 */     to.set(11, 24);
/*  95 */     if (new String(this.pass.getPassword()).equals("2530"))
/*     */     {
/* 100 */       setVisible(false);
/*     */     } else {
/* 102 */       int j = resAncho / 2 - 220;
/* 103 */       for (int i = 0; i < 20; i++) {
/* 104 */         if (i % 2 == 0)
/* 105 */           setLocation(j + 10, resAlto / 2 - 166);
/*     */         else
/* 107 */           setLocation(j - 10, resAlto / 2 - 166);
/*     */         try
/*     */         {
/* 110 */           Thread.sleep(10L);
/*     */         } catch (InterruptedException e) {
/* 112 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 124 */     initComponents();
/* 125 */     initDialog();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.DialogBorrarTurnos
 * JD-Core Version:    0.6.0
 */