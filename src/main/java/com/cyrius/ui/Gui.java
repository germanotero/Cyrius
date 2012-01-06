/*     */ package com.cyrius.ui;
/*     */ 
/*     */ import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import org.apache.log4j.xml.DOMConfigurator;

import com.cyrius.informes.ui.uc.MainInformesUseCase;
import com.cyrius.turnos.gui.verTurno.TurnosFrame;
import com.cyrius.ui.errores.ErrorResolucion;
import com.framework.abstractfactorys.FrameworkUseCaseFactory;
import com.framework.exceptions.ExceptionHandler;
import com.framework.utils.Constants;
import com.incors.plaf.kunststoff.KunststoffLookAndFeel;
/*     */ 
/*     */ public class Gui extends JWindow
/*     */ {
/*     */   private JButton btnInformes;
/*     */   private JButton btnSalir;
/*     */   private JButton btnTurnos;
/*     */   private JButton btnOpciones;
/*     */   private boolean btnApretado;
/*     */ 
/*     */   public Gui()
/*     */   {
/*  51 */     initComponents();
/*  52 */     applySkin();
/*     */   }
/*     */ 
/*     */   private void applySkin()
/*     */   {
/*     */     try {
/*  58 */       UIManager.setLookAndFeel(new KunststoffLookAndFeel());
/*     */     }
/*     */     catch (UnsupportedLookAndFeelException e)
/*     */     {
/*  62 */       e.printStackTrace();
/*     */     }
/*  64 */     SwingUtilities.updateComponentTreeUI(this);
/*  65 */     pack();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  69 */     JLabel realizado = new JLabel();
/*  70 */     JLabel licencia = new JLabel();
/*  71 */     JLabel jLabel2 = new JLabel();
/*  72 */     JLabel jLblTitle = new JLabel();
/*  73 */     JLabel jLabel1 = new JLabel();
/*     */ 
/*  75 */     this.btnTurnos = new JButton();
/*  76 */     this.btnInformes = new JButton();
/*  77 */     this.btnSalir = new JButton();
/*  78 */     this.btnOpciones = new JButton("Opciones.");
/*  79 */     Container contentPane = getContentPane();
/*  80 */     contentPane.setLayout(null);
/*     */ 
/*  84 */     this.btnTurnos.setFont(new Font("Times New Roman", 1, 12));
/*  85 */     this.btnTurnos.setText("Turnos");
/*  86 */     this.btnTurnos.setBorder(
/*  87 */       new BevelBorder(0));
/*  88 */     this.btnTurnos.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  90 */         Gui.this.btnTurnosActionPerformed(evt);
/*     */       }
/*     */     });
/*  93 */     contentPane.add(this.btnTurnos);
/*  94 */     this.btnTurnos.setBounds(320, 250, 90, 18);
/*  95 */     this.btnInformes.setFont(new Font("Times New Roman", 1, 12));
/*  96 */     this.btnInformes.setText("Informes");
/*  97 */     this.btnInformes.setBorder(
/*  98 */       new BevelBorder(0));
/*  99 */     contentPane.add(this.btnInformes);
/* 100 */     this.btnInformes.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 102 */         Gui.this.btnInformesActionPerformed(evt);
/*     */       }
/*     */     });
/* 106 */     this.btnInformes.setBounds(320, 230, 90, 18);
/* 107 */     this.btnSalir.setText("Salir");
/* 108 */     this.btnSalir.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 110 */         Gui.this.btnSalirActionPerformed(evt);
/*     */       }
/*     */     });
/* 113 */     contentPane.add(this.btnSalir);
/* 114 */     this.btnSalir.setBounds(360, 310, 80, 20);
/* 115 */     this.btnOpciones.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 117 */         Gui.this.btnOpcionesActionPerformed(evt);
/*     */       }
/*     */     });
/* 120 */     contentPane.add(this.btnOpciones);
/* 121 */     this.btnOpciones.setBounds(3, 315, 75, 13);
/* 122 */     this.btnOpciones.setFont(Constants.FONTPRINT);
/* 123 */     this.btnOpciones.setVisible(false);
/* 124 */     realizado.setFont(new Font("Dialog", 1, 10));
/* 125 */     realizado.setForeground(new Color(255, 255, 255));
/* 126 */     realizado.setText("Realizado por German Otero.");
/* 127 */     contentPane.add(realizado);
/* 128 */     realizado.setBounds(70, 290, 150, 10);
/* 129 */     licencia.setFont(new Font("Dialog", 0, 10));
/* 130 */     licencia.setForeground(new Color(255, 255, 255));
/* 131 */     licencia.setText("Licenciado para Dra. Nilda Sanchez. C.E.N.S.");
/* 132 */     contentPane.add(licencia);
/* 133 */     licencia.setBounds(110, 310, 230, 20);
/* 134 */     jLabel2.setIcon(new ImageIcon("Img/java.gif"));
/* 135 */     contentPane.add(jLabel2);
/* 136 */     jLabel2.setBounds(20, 250, 50, 60);
/* 137 */     jLblTitle.setIcon(new ImageIcon("Img/cyrius.gif"));
/* 138 */     contentPane.add(jLblTitle);
/* 139 */     jLblTitle.setBounds(295, -20, 230, 100);
/* 140 */     jLabel1.setFont(new Font("Dialog", 1, 48));
/* 141 */     jLabel1.setIcon(new ImageIcon("Img/fondo5.gif"));
/* 142 */     contentPane.add(jLabel1);
/* 143 */     jLabel1.setBounds(0, -10, 450, 350);
/*     */ 
/* 145 */     postInit();
/* 146 */     pack();
/*     */   }
/*     */ 
/*     */   private void postInit()
/*     */   {
/* 153 */     this.btnOpciones.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void btnSalirActionPerformed(ActionEvent evt)
/*     */   {
/* 158 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   private void btnInformesActionPerformed(ActionEvent evt) {
/* 162 */     if (!this.btnApretado)
/*     */       try {
/* 164 */         setWaitState();
/* 165 */         MainInformesUseCase uc = 
/* 166 */           (MainInformesUseCase)FrameworkUseCaseFactory.createUseCase(MainInformesUseCase.class);
/* 167 */         uc.getInternalWindow().setDefaultCloseOperation(
/* 168 */           3);
/* 169 */         FrameworkUseCaseFactory.launchUseCase(uc);
/* 170 */         setVisible(false);
/*     */       } catch (Throwable e) {
/* 172 */         ExceptionHandler.getInstance().handle(e);
/*     */       } finally {
/* 174 */         setDefaultState();
/*     */       }
/*     */   }
/*     */ 
/*     */   private void btnTurnosActionPerformed(ActionEvent evt)
/*     */   {
/* 181 */     if (!this.btnApretado)
/*     */       try {
/* 183 */         setWaitState();
/*     */ 
/* 185 */         TurnosFrame turnos = new TurnosFrame(this);
/* 186 */         turnos.setResizable(false);
/* 187 */         turnos.setVisible(true);
/* 188 */         setVisible(false);
/*     */       } catch (Throwable e) {
/* 190 */         ExceptionHandler.getInstance().handle(e);
/*     */       } finally {
/* 192 */         setDefaultState();
/*     */       }
/*     */   }
/*     */ 
/*     */   private void setWaitState()
/*     */   {
/* 202 */     this.btnApretado = true;
/* 203 */     setCursor(new Cursor(3));
/*     */   }
/*     */ 
/*     */   private void setDefaultState()
/*     */   {
/* 210 */     setCursor(new Cursor(0));
/*     */   }
/*     */ 
/*     */   private void btnOpcionesActionPerformed(ActionEvent evt)
/*     */   {
/* 215 */     OpcionesJDialog opt = new OpcionesJDialog();
/* 216 */     opt.setVisible(true);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws FileNotFoundException
/*     */   {
/* 225 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 226 */     DOMConfigurator.configure("config/log4j.xml");
/*     */ 
/* 228 */     int resAncho = (int)screenSize.getWidth();
/* 229 */     int resAlto = (int)screenSize.getHeight();
/*     */ 
/* 233 */     if ((resAncho < 800) && (resAlto < 600)) {
/* 234 */       ErrorResolucion noRes = new ErrorResolucion();
/* 235 */       noRes.setBounds(resAncho / 2 - 200, resAlto / 2 - 100, 400, 
/* 236 */         200);
/* 237 */       noRes.setVisible(true);
/*     */     } else {
/* 239 */       Gui pantallaInicio = new Gui();
/* 240 */       pantallaInicio.setBounds(resAncho / 2 - 220, 
/* 241 */         resAlto / 2 - 166, 442, 332);
/* 242 */       pantallaInicio.setVisible(true);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.Gui
 * JD-Core Version:    0.6.0
 */