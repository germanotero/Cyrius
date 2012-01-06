/*     */ package com.cyrius.turnos.gui.nuevoTurno;
/*     */ 
/*     */ import com.cyrius.entities.Preparacion;
/*     */ import com.cyrius.utils.prints.PrintUtilities;
/*     */ import com.framework.utils.Constants;
/*     */ import com.framework.utils.KeyCodes;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.util.GregorianCalendar;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.border.TitledBorder;
/*     */ 
/*     */ public class TurnoPreparacion extends JFrame
/*     */ {
/*     */   private JPanel panel;
/*     */   private JTextPane jtMensaje;
/*     */   private JButton btnPrint;
/*     */   private JLabel maxCaracter;
/*  42 */   private int i = 700;
/*     */   private JScrollPane jScroll;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel4;
/*     */   private Preparacion preparacion;
/*     */   private String nombre;
/*     */   private GregorianCalendar hora;
/*     */ 
/*     */   public TurnoPreparacion(Preparacion preparacion, GregorianCalendar hora, String nombre)
/*     */   {
/*  59 */     this.nombre = nombre;
/*  60 */     this.preparacion = preparacion;
/*  61 */     this.hora = new GregorianCalendar();
/*  62 */     this.hora.setTimeInMillis(hora.getTimeInMillis());
/*  63 */     initComponents();
/*  64 */     initFrame();
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/*  68 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  69 */     int resAncho = (int)screenSize.getWidth();
/*  70 */     int resAlto = (int)screenSize.getHeight();
/*  71 */     setBounds(resAncho / 2 - 225, resAlto / 2 - 135, 450, 270);
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  75 */     this.jtMensaje = new JTextPane();
/*  76 */     this.maxCaracter = new JLabel("");
/*  77 */     this.jScroll = new JScrollPane();
/*  78 */     this.jScroll.setViewportView(this.jtMensaje);
/*  79 */     this.panel = new JPanel();
/*  80 */     this.jLabel2 = new JLabel();
/*  81 */     this.jLabel4 = new JLabel();
/*  82 */     this.btnPrint = new JButton("Imprimir.");
/*  83 */     this.panel.setLayout(null);
/*  84 */     this.panel.add(this.btnPrint);
/*  85 */     this.panel.add(this.maxCaracter);
/*  86 */     this.maxCaracter.setBounds(250, 135, 200, 16);
/*  87 */     this.jtMensaje.addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent e) {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent e) {
/*  92 */         TurnoPreparacion.this.jtMensajeKeyReleased(e);
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent e) {
/*  96 */         TurnoPreparacion.this.jtMensajekeyTyped(e);
/*     */       }
/*     */     });
/*  99 */     this.btnPrint.setBounds(80, 200, 100, 20);
/* 100 */     this.btnPrint.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 102 */         TurnoPreparacion.this.jtMensaje.setCaretPosition(0);
/* 103 */         TurnoPreparacion.this.btnPrint(arg0);
/*     */       }
/*     */     });
/* 106 */     this.jLabel2.setFont(Constants.FONTPRINT);
/* 107 */     this.jLabel4.setFont(Constants.FONTLEYENDA);
/* 108 */     this.panel.setBackground(new Color(255, 255, 255));
/* 109 */     this.jScroll.setBorder(
/* 110 */       new TitledBorder("Preparacion para: " + this.nombre));
/* 111 */     this.jtMensaje.setText(this.preparacion.getDescripcion());
/* 112 */     this.panel.add(this.jScroll);
/* 113 */     this.jScroll
/* 114 */       .setVerticalScrollBarPolicy(21);
/* 115 */     this.jScroll.setBounds(26, 20, 400, 110);
/* 116 */     this.jtMensaje.setText(this.preparacion.getDescripcion());
/* 117 */     String minutos = ""+this.hora.get(12);
/* 118 */     if (this.hora.get(12) == 0) {
/* 119 */       minutos = minutos + "0";
/*     */     }
/* 121 */     String dia = null;
/*     */ 
/* 123 */     switch (this.hora.get(7)) {
/*     */     case 2:
/* 125 */       dia = "Lunes";
/* 126 */       break;
/*     */     case 3:
/* 128 */       dia = "Martes";
/* 129 */       break;
/*     */     case 4:
/* 131 */       dia = "Miercoles";
/* 132 */       break;
/*     */     case 5:
/* 134 */       dia = "Jueves";
/* 135 */       break;
/*     */     case 6:
/* 137 */       dia = "Viernes";
/* 138 */       break;
/*     */     default:
/* 140 */       dia = "";
/*     */     }
/* 142 */     this.jLabel2.setText("Turno Para el " + dia + " " + this.hora.get(5) + 
/* 143 */       "/" + (this.hora.get(2) + 1) + " a las " + 
/* 144 */       this.hora.get(11) + ":" + minutos);
/* 145 */     this.panel.add(this.jLabel2);
/* 146 */     this.jLabel2.setBounds(30, 135, 180, 16);
/* 147 */     this.jLabel4
/* 148 */       .setText("C.E.N.S. Consultorio de Ecografías de alta Complejidad.Lavalle 1032 - Quilmes - 1878 - Tel/Fax: 4224-7953 / 4253-4687");
/* 149 */     this.panel.add(this.jLabel4);
/* 150 */     this.jLabel4.setBounds(30, 150, 360, 10);
/* 151 */     getContentPane().add(this.panel);
/* 152 */     this.panel.doLayout();
/* 153 */     pack();
/*     */   }
/*     */ 
/*     */   private void jtMensajeKeyReleased(KeyEvent e) {
/* 157 */     String text = this.jtMensaje.getText().trim();
/* 158 */     if (e.getKeyCode() == KeyCodes.ENTER) {
/* 159 */       this.jtMensaje.setText(text.substring(0, text.length()));
/*     */     }
/* 161 */     this.i = (700 - text.length());
/* 162 */     if (this.i == 0) {
/* 163 */       this.jtMensaje.setText(text);
/*     */     }
/* 165 */     this.maxCaracter.setText("Caracteres Restantes: " + this.i);
/*     */   }
/*     */ 
/*     */   private void jtMensajekeyTyped(KeyEvent e) {
/* 169 */     String text = this.jtMensaje.getText().trim();
/* 170 */     if (e.getKeyCode() == KeyCodes.ENTER)
/* 171 */       this.jtMensaje.setText(text.substring(0, text.length()));
/*     */   }
/*     */ 
/*     */   private void btnPrint(ActionEvent arg0)
/*     */   {
/* 176 */     this.maxCaracter.setVisible(false);
/* 177 */     this.jtMensaje.setFont(Constants.FONTPRINTTEXT);
/* 178 */     this.btnPrint.setVisible(false);
/* 179 */     print(this.panel);
/* 180 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void print(Component comp) {
/* 184 */     PrintUtilities.printComponent(comp);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.nuevoTurno.TurnoPreparacion
 * JD-Core Version:    0.6.0
 */