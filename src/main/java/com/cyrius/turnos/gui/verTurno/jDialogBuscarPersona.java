/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import com.cyrius.entities.Persona;
/*     */ import com.framework.utils.KeyCodes;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class jDialogBuscarPersona extends JDialog
/*     */ {
/*     */   private JButton btnBuscar;
/*     */   private JLabel lblTitulo;
/*     */   private JLabel lblApellido;
/*     */   private JLabel lblNombre;
/*     */   private JTextField txtApellido;
/*     */   private JTextField txtNombre;
/*     */   private JFrame parent;
/*     */ 
/*     */   public jDialogBuscarPersona(JFrame parent)
/*     */   {
/*  45 */     super(parent, true);
/*  46 */     this.parent = parent;
/*  47 */     initGUI();
/*     */   }
/*     */ 
/*     */   public void initGUI()
/*     */   {
/*     */     try
/*     */     {
/*  56 */       preInitGUI();
/*     */ 
/*  58 */       this.txtNombre = new JTextField();
/*  59 */       this.txtApellido = new JTextField();
/*  60 */       this.lblNombre = new JLabel();
/*  61 */       this.lblApellido = new JLabel();
/*  62 */       this.lblTitulo = new JLabel();
/*  63 */       this.btnBuscar = new JButton();
/*     */ 
/*  65 */       GridBagLayout thisLayout = new GridBagLayout();
/*  66 */       getContentPane().setLayout(thisLayout);
/*  67 */       thisLayout.columnWidths = new int[] { 1, 1, 1, 1, 1 };
/*  68 */       thisLayout.rowHeights = new int[] { 1, 1, 1, 1 };
/*  69 */       thisLayout.columnWeights = new double[] { 0.1D, 0.1D, 0.1D, 0.1D, 0.1D };
/*  70 */       thisLayout.rowWeights = new double[] { 0.1D, 0.1D, 0.1D, 0.1D };
/*  71 */       setSize(new Dimension(338, 191));
/*     */ 
/*  73 */       this.txtNombre.setPreferredSize(new Dimension(100, 20));
/*  74 */       getContentPane().add(
/*  75 */         this.txtNombre, 
/*  76 */         new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 10, 0, 
/*  77 */         new Insets(0, 0, 0, 0), 0, 0));
/*  78 */       this.txtNombre.addKeyListener(new KeyAdapter() {
/*     */         public void keyReleased(KeyEvent evt) {
/*  80 */           jDialogBuscarPersona.this.txtNombreKeyReleased(evt);
/*     */         }
/*     */       });
/*  84 */       this.txtApellido.setPreferredSize(new Dimension(100, 20));
/*  85 */       getContentPane().add(
/*  86 */         this.txtApellido, 
/*  87 */         new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 10, 0, 
/*  88 */         new Insets(0, 0, 0, 0), 0, 0));
/*  89 */       this.txtApellido.addKeyListener(new KeyAdapter() {
/*     */         public void keyReleased(KeyEvent evt) {
/*  91 */           jDialogBuscarPersona.this.txtApellidoKeyReleased(evt);
/*     */         }
/*     */       });
/*  95 */       this.lblNombre.setText("Nombre:");
/*  96 */       getContentPane().add(
/*  97 */         this.lblNombre, 
/*  98 */         new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 0, 
/*  99 */         new Insets(0, 0, 0, 0), 0, 0));
/*     */ 
/* 101 */       this.lblApellido.setText("Apellido:");
/* 102 */       getContentPane().add(
/* 103 */         this.lblApellido, 
/* 104 */         new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 10, 0, 
/* 105 */         new Insets(0, 0, 0, 0), 0, 0));
/*     */ 
/* 107 */       this.lblTitulo.setText("Ingrese Nombre/Apellido");
/* 108 */       getContentPane().add(
/* 109 */         this.lblTitulo, 
/* 110 */         new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 0, 
/* 111 */         new Insets(0, 0, 0, 0), 0, 0));
/*     */ 
/* 113 */       this.btnBuscar.setText("Buscar");
/* 114 */       getContentPane().add(
/* 115 */         this.btnBuscar, 
/* 116 */         new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 10, 0, 
/* 117 */         new Insets(0, 0, 0, 0), 0, 0));
/* 118 */       this.btnBuscar.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 120 */           jDialogBuscarPersona.this.btnBuscarActionPerformed(evt);
/*     */         }
/*     */       });
/* 124 */       postInitGUI();
/*     */     } catch (Exception e) {
/* 126 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void preInitGUI()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void postInitGUI()
/*     */   {
/* 136 */     initFrame();
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/* 140 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 141 */     int resAncho = (int)screenSize.getWidth();
/* 142 */     int resAlto = (int)screenSize.getHeight();
/* 143 */     setBounds(resAncho / 2 - 165, resAlto / 2 - 82, 331, 164);
/* 144 */     setTitle("Nuevo Turno");
/*     */   }
/*     */ 
/*     */   protected void btnBuscarActionPerformed(ActionEvent evt)
/*     */   {
/* 149 */     Persona p = new Persona();
/* 150 */     p.setNombre(this.txtNombre.getText().trim());
/* 151 */     p.setApellido(this.txtApellido.getText().trim());
/*     */ 
/* 161 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   protected void txtApellidoKeyReleased(KeyEvent evt)
/*     */   {
/* 166 */     keyReleasedActionPerformed(evt, this.txtApellido);
/*     */ 
/* 168 */     if (evt.getKeyCode() == KeyCodes.ENTER)
/* 169 */       this.txtApellido.transferFocus();
/*     */   }
/*     */ 
/*     */   protected void txtNombreKeyReleased(KeyEvent evt)
/*     */   {
/* 175 */     keyReleasedActionPerformed(evt, this.txtNombre);
/*     */ 
/* 177 */     if (evt.getKeyCode() == KeyCodes.ENTER)
/* 178 */       this.txtNombre.transferFocus();
/*     */   }
/*     */ 
/*     */   private void keyReleasedActionPerformed(KeyEvent ev, JTextField tf)
/*     */   {
/* 183 */     if (tf.getText().length() == 1) {
/* 184 */       tf.setText(tf.getText().substring(0, 1).toUpperCase());
/*     */     }
/*     */ 
/* 187 */     if ((tf.getText().length() > 1) && (ev.getKeyCode() != 32)) {
/* 188 */       StringTokenizer stk = new StringTokenizer(tf.getText(), " ");
/* 189 */       String text = "";
/*     */ 
/* 191 */       while (stk.hasMoreTokens()) {
/* 192 */         String tok = stk.nextToken();
/* 193 */         text = text + tok.substring(0, 1).toUpperCase() + 
/* 194 */           tok.substring(1);
/*     */ 
/* 196 */         if (stk.hasMoreTokens()) {
/* 197 */           text = text + " ";
/*     */         }
/*     */       }
/*     */ 
/* 201 */       tf.setText(text);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.jDialogBuscarPersona
 * JD-Core Version:    0.6.0
 */