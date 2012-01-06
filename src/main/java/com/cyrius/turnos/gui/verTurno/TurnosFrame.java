/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import com.cyrius.turnos.gui.HorariosABMFactory;
/*     */ import com.cyrius.turnos.gui.abms.MedicoABMFactory;
/*     */ import com.cyrius.turnos.gui.abms.ObraSocialABMFactory;
/*     */ import com.cyrius.turnos.gui.abms.PreparacionABMFactory;
/*     */ import com.cyrius.turnos.gui.listas.JFrameListaControl;
/*     */ import com.cyrius.turnos.gui.listas.JFrameListaFacturacion;
/*     */ import com.cyrius.turnos.gui.practicas.noNomencladas.PracticaNoNomencladaABMFactory;
/*     */ import com.cyrius.turnos.gui.practicas.nomencladas.PracticaNomencladaABMFactory;
/*     */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*     */ import com.framework.abstractfactorys.FrameworkUseCaseFactory;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.border.BevelBorder;
/*     */ 
/*     */ public class TurnosFrame extends JFrame
/*     */ {
/*     */   private VerTurnosJPanel verTurnos;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JMenuItem miListaFac;
/*     */   private JMenuItem miListaControl;
/*     */   private JMenu menuListas;
/*     */   private JMenu administradores;
/*     */   private JMenu menuPracticas;
/*     */   private JMenuItem miListaPacientes;
/*     */   private JMenuItem miPracNoNom;
/*     */   private JMenuItem miPracNom;
/*     */   private JMenuItem administrarMedicos;
/*     */   private JMenuItem miModificarOs;
/*     */   private JMenuItem miBorrarTurnos;
/*     */   private Container parent;
/*     */   private AbstractButton administrarHorarios;
/*     */ 
/*     */   public TurnosFrame(Container parent)
/*     */   {
/*  78 */     this.parent = parent;
/*  79 */     initComponents();
/*  80 */     this.verTurnos.setBounds(0, 0, 750, 670);
/*  81 */     getContentPane().add(this.verTurnos);
/*  82 */     initFrame();
/*  83 */     setVisible(true);
/*  84 */     this.parent.setVisible(false);
/*     */   }
/*     */ 
/*     */   private void initFrame()
/*     */   {
/*  89 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  90 */     int resAncho = (int)screenSize.getWidth();
/*  91 */     int resAlto = (int)screenSize.getHeight();
/*  92 */     setBounds(resAncho / 2 - 400, resAlto / 2 - 285, 750, 580);
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  96 */     this.verTurnos = new VerTurnosJPanel(this);
/*  97 */     this.jMenuBar1 = new JMenuBar();
/*  98 */     this.administradores = new JMenu();
/*  99 */     this.administrarMedicos = new JMenuItem();
/* 100 */     this.administrarHorarios = new JMenuItem();
/* 101 */     this.menuListas = new JMenu();
/* 102 */     this.miListaFac = new JMenuItem();
/* 103 */     this.miListaControl = new JMenuItem();
/* 104 */     this.menuPracticas = new JMenu();
/* 105 */     this.miPracNoNom = new JMenuItem();
/* 106 */     this.miPracNom = new JMenuItem();
/* 107 */     this.miModificarOs = new JMenuItem();
/*     */ 
/* 110 */     this.miBorrarTurnos = new JMenuItem("Borrar Turnos Pasados");
/* 111 */     this.miListaPacientes = new JMenuItem("Listado de Pacientes");
/* 112 */     this.miBorrarTurnos.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 114 */         TurnosFrame.this.miBorrarTurnosActionPerformed(arg0);
/*     */       }
/*     */     });
/* 117 */     this.miListaPacientes.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 119 */         TurnosFrame.this.miListaPacientesActionPerformed(arg0);
/*     */       }
/*     */     });
/* 124 */     getContentPane().setLayout(null);
/* 125 */     setDefaultCloseOperation(0);
/* 126 */     setTitle("Turnos");
/* 127 */     setResizable(false);
/* 128 */     this.administradores.setText("Administradores");
/* 129 */     this.administrarMedicos.setText("Medicos");
/* 130 */     this.administrarMedicos
/* 131 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 133 */         TurnosFrame.this.miModificarMedicoActionPerformed(evt);
/*     */       }
/*     */     });
/* 136 */     this.administradores.add(this.administrarMedicos);
/*     */ 
/* 138 */     this.administrarHorarios.setText("Horarios");
/* 139 */     this.administrarHorarios
/* 140 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 142 */         TurnosFrame.this.miModificarHorariosPerformed(evt);
/*     */       }
/*     */     });
/* 146 */     this.administradores.add(this.administrarHorarios);
/* 147 */     this.jMenuBar1.add(this.administradores);
/* 148 */     this.jMenuBar1.setPreferredSize(new Dimension(631, 22));
/* 149 */     this.menuListas.setText("Listados");
/* 150 */     this.menuListas.add(this.miListaFac);
/* 151 */     this.menuListas.addMouseListener(new MouseListener() {
/*     */       public void mouseClicked(MouseEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent arg0) {
/* 156 */         TurnosFrame.this.mouseEnter(TurnosFrame.this.menuListas);
/*     */       }
/*     */ 
/*     */       public void mouseExited(MouseEvent arg0) {
/* 160 */         TurnosFrame.this.mouseExit(TurnosFrame.this.menuListas);
/*     */       }
/*     */ 
/*     */       public void mousePressed(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseReleased(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 169 */     this.miListaFac.setText("Lista de Facturación");
/* 170 */     this.miListaFac.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 172 */         TurnosFrame.this.miListaFacActionPerformed(arg0);
/*     */       }
/*     */     });
/* 175 */     this.jMenuBar1.add(this.menuListas);
/* 176 */     this.miListaControl.setText("Lista de Control");
/* 177 */     this.miListaControl.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 179 */         TurnosFrame.this.miListaControlActionPerformed(arg0);
/*     */       }
/*     */     });
/* 182 */     this.menuListas.add(this.miListaControl);
/* 183 */     this.menuPracticas.setText("Prácticas");
/* 184 */     this.menuPracticas.addMouseListener(new MouseListener() {
/*     */       public void mouseClicked(MouseEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent arg0) {
/* 189 */         TurnosFrame.this.mouseEnter(TurnosFrame.this.menuPracticas);
/*     */       }
/*     */ 
/*     */       public void mouseExited(MouseEvent arg0) {
/* 193 */         TurnosFrame.this.mouseExit(TurnosFrame.this.menuPracticas);
/*     */       }
/*     */ 
/*     */       public void mousePressed(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseReleased(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 202 */     this.miPracNoNom.setText("Prácticas no Nomencladas");
/* 203 */     this.miPracNoNom.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 205 */         TurnosFrame.this.miPracNoNomActionPerformed(evt);
/*     */       }
/*     */     });
/* 208 */     this.menuPracticas.add(this.miPracNoNom);
/* 209 */     this.miPracNom.setText("Prácticas Nomencladas");
/* 210 */     this.miPracNom.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 212 */         TurnosFrame.this.miPracNomActionPerformed(evt);
/*     */       }
/*     */     });
/* 215 */     this.menuPracticas.add(this.miPracNom);
/* 216 */     this.administradores.add(this.menuPracticas);
/* 217 */     this.miModificarOs.setText("Obras Sociales");
/* 218 */     this.administradores.add(this.miModificarOs);
/* 219 */     this.miModificarOs.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 221 */         TurnosFrame.this.miMordificarOsActionPerformed(evt);
/*     */       }
/*     */     });
/* 250 */     JMenuItem preparaciones = new JMenuItem("Preparaciones");
/* 251 */     this.administradores.add(preparaciones);
/* 252 */     preparaciones.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 255 */         TurnosFrame.this.launchUseCase(PreparacionABMFactory.class);
/*     */       }
/*     */     });
/* 268 */     setJMenuBar(this.jMenuBar1);
/* 269 */     setDefaultCloseOperation(3);
/* 270 */     pack();
/*     */   }
/*     */ 
/*     */   protected void miModificarHorariosPerformed(ActionEvent evt) {
/* 274 */     launchUseCase(HorariosABMFactory.class);
/*     */   }
/*     */ 
/*     */   private void miListaControlActionPerformed(ActionEvent arg0) {
/* 278 */     JFrameListaControl list = null;
/*     */     try {
/* 280 */       list = new JFrameListaControl();
/*     */     } catch (Exception e) {
/* 282 */       ExceptionHandler.getInstance().handle(e);
/* 283 */       return;
/*     */     }
/* 285 */     list.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void miListaFacActionPerformed(ActionEvent arg0) {
/* 289 */     JFrameListaFacturacion list = null;
/*     */     try {
/* 291 */       list = new JFrameListaFacturacion();
/*     */     } catch (Exception e) {
/* 293 */       ExceptionHandler.getInstance().handle(e);
/* 294 */       return;
/*     */     }
/* 296 */     list.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void mouseEnter(JMenu menu) {
/* 300 */     menu.setBorder(new BevelBorder(0));
/*     */   }
/*     */ 
/*     */   private void mouseExit(JMenu menu) {
/* 304 */     menu.setBorder(null);
/*     */   }
/*     */ 
/*     */   private void miMordificarOsActionPerformed(ActionEvent evt)
/*     */   {
/* 309 */     launchUseCase(ObraSocialABMFactory.class);
/*     */   }
/*     */ 
/*     */   private void launchUseCase(Class<? extends AbstractUseCaseFactory> useCase)
/*     */   {
/*     */     try {
/* 315 */       setCursor(new Cursor(3));
/* 316 */       FrameworkUseCaseFactory.launchUseCase(
/* 317 */         (AbstractUseCaseFactory)FrameworkUseCaseFactory.createChildUseCase(useCase, this));
/*     */     } catch (Throwable e) {
/* 319 */       ExceptionHandler.getInstance().handle(e);
/*     */     } finally {
/* 321 */       setCursor(new Cursor(0));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void miPracNoNomActionPerformed(ActionEvent evt) {
/* 326 */     launchUseCase(PracticaNoNomencladaABMFactory.class);
/*     */   }
/*     */ 
/*     */   private void miPracNomActionPerformed(ActionEvent evt)
/*     */   {
/* 343 */     launchUseCase(PracticaNomencladaABMFactory.class);
/*     */   }
/*     */ 
/*     */   private void miModificarMedicoActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 355 */       FrameworkUseCaseFactory.launchUseCase(
/* 356 */         (AbstractUseCaseFactory)FrameworkUseCaseFactory.createChildUseCase(MedicoABMFactory.class, this));
/*     */     } catch (Exception e1) {
/* 358 */       e1.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void miListaPacientesActionPerformed(ActionEvent arg0)
/*     */   {
/* 382 */     jDialogBuscarPersona inst = new jDialogBuscarPersona(this);
/* 383 */     inst.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void miRecordatorioActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void miBorrarTurnosActionPerformed(ActionEvent arg0)
/*     */   {
/* 397 */     DialogBorrarTurnos conf = new DialogBorrarTurnos(this);
/* 398 */     Thread borrarTurnos = new Thread(conf);
/* 399 */     borrarTurnos.run();
/* 400 */     conf.setVisible(true);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.TurnosFrame
 * JD-Core Version:    0.6.0
 */