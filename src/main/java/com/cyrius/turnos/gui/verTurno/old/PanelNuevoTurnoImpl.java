/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.entities.Persona;
/*     */ import com.cyrius.entities.Practica;
/*     */ import com.cyrius.entities.Preparacion;
/*     */ import com.cyrius.entities.TipoDocumento;
/*     */ import com.cyrius.entities.Turno;
/*     */ import com.cyrius.searchers.BuscadorPersona;
/*     */ import com.cyrius.searchers.TipoDocumentoSearcher;
/*     */ import com.cyrius.turnos.gui.listas.JDialogTablaPersonas;
/*     */ import com.cyrius.turnos.gui.listas.TablaPersonasSelectionAction;
/*     */ import com.cyrius.turnos.gui.nuevoTurno.TurnoPreparacion;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import com.framework.exceptions.NotFullFormException;
/*     */ import com.framework.persistence.PersistenceService;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.util.Collection;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.BevelBorder;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.border.TitledBorder;
/*     */ 
/*     */ public class PanelNuevoTurnoImpl extends JPanel
/*     */   implements PanelNuevoTurno
/*     */ {
/*     */   private JButton btnAceptarTurnoNuevo;
/*     */   private JButton btnBuscar;
/*     */   private JButton btnCancelarTurnoNuevo;
/*     */   private JButton btnImprimirTurnoPrepa;
/*     */   private JComboBox cbConsultorio;
/*     */   private JEditorPane txtObservaciones;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jpObserbaciones;
/*     */   private JPanel jpConsultorio;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTabbedPane jTabbedPanelTurnos;
/*     */   private JPanel jpAux;
/*     */   private JPanel jpBuscar;
/*     */   private JPanel jpDatosOs;
/*     */   private JPanel jpDatosPaciente;
/*     */   private JPanel jpDatosPersona;
/*     */   private JLabel lblApellido;
/*     */   private JLabel lblCalle;
/*     */   private JLabel lblCiudad;
/*     */   private JLabel lblDireccion;
/*     */   private JLabel lblDocumento;
/*     */   private JLabel lblNombre;
/*     */   private JLabel lblNumero;
/*     */   private JLabel lblNumeroAfiliado;
/*     */   private JLabel lblTelefono;
/*     */   private JLabel lblTipo;
/*     */   private JLabel lblTitulo;
/*     */   private JLabel fotoCyrius;
/*     */   private JLabel lblObraSoc;
/*     */   private PanelPrimerPaso panelPrimerPaso;
/*     */   private JTextField txtApellido;
/*     */   private JTextField txtCalle;
/*     */   private JTextField txtCiudad;
/*     */   private JTextField txtDocumento;
/*     */   private JTextField txtNombre;
/*     */   private JTextField txtNumero;
/*     */   private JTextField txtNumeroAfiliado;
/*     */   private JTextField txtTelefono;
/*     */   private JComboBox cbTipo;
/*     */   private PanelNuevoTurnoHorarios panelHorarios;
/* 127 */   private boolean buscado = false;
/*     */   private FrameNuevoTurnoImpl parent;
/*     */   private Persona persona;
/*     */ 
/*     */   public PanelNuevoTurnoImpl(FrameNuevoTurnoImpl impl)
/*     */   {
/* 134 */     this.parent = impl;
/* 135 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/* 139 */     this.panelHorarios = new PanelNuevoTurnoHorarios(this);
/* 140 */     this.jTabbedPanelTurnos = new JTabbedPane();
/* 141 */     this.fotoCyrius = new JLabel();
/*     */ 
/* 143 */     this.panelPrimerPaso = new PanelPrimerPaso(this);
/* 144 */     this.jpDatosPaciente = new JPanel();
/* 145 */     this.jpDatosPersona = new JPanel();
/* 146 */     this.txtNombre = new JTextField();
/* 147 */     this.txtApellido = new JTextField();
/* 148 */     this.lblNombre = new JLabel();
/* 149 */     this.lblApellido = new JLabel();
/* 150 */     this.lblDocumento = new JLabel();
/* 151 */     this.txtDocumento = new JTextField();
/* 152 */     this.lblTipo = new JLabel();
/* 153 */     this.cbTipo = new JComboBox();
/* 154 */     this.lblTelefono = new JLabel();
/* 155 */     this.txtTelefono = new JTextField();
/* 156 */     this.lblCalle = new JLabel();
/* 157 */     this.lblNumero = new JLabel();
/* 158 */     this.lblCiudad = new JLabel();
/* 159 */     this.lblObraSoc = new JLabel();
/* 160 */     this.lblDireccion = new JLabel();
/* 161 */     this.txtCalle = new JTextField();
/* 162 */     this.txtNumero = new JTextField();
/* 163 */     this.txtCiudad = new JTextField();
/* 164 */     this.jpAux = new JPanel();
/* 165 */     this.jpDatosOs = new JPanel();
/* 166 */     this.lblTitulo = new JLabel();
/* 167 */     this.lblNumeroAfiliado = new JLabel();
/* 168 */     this.txtNumeroAfiliado = new JTextField();
/* 169 */     this.jpBuscar = new JPanel();
/* 170 */     this.btnBuscar = new JButton();
/* 171 */     this.jpObserbaciones = new JPanel();
/* 172 */     this.jScrollPane1 = new JScrollPane();
/* 173 */     this.txtObservaciones = new JEditorPane();
/* 174 */     this.jpConsultorio = new JPanel();
/* 175 */     this.jLabel1 = new JLabel();
/* 176 */     this.cbConsultorio = new JComboBox();
/* 177 */     this.btnAceptarTurnoNuevo = new JButton();
/* 178 */     this.btnImprimirTurnoPrepa = new JButton();
/* 179 */     this.btnCancelarTurnoNuevo = new JButton();
/* 180 */     setLayout(null);
/* 181 */     setMinimumSize(new Dimension(800, 600));
/* 182 */     setPreferredSize(new Dimension(800, 600));
/* 183 */     this.jTabbedPanelTurnos.setBorder(
/* 184 */       new BevelBorder(1));
/* 185 */     this.jTabbedPanelTurnos
/* 186 */       .setTabLayoutPolicy(1);
/* 187 */     this.fotoCyrius.setBounds(30, 200, 300, 330);
/*     */ 
/* 189 */     this.jTabbedPanelTurnos.addTab("1° paso", this.panelPrimerPaso);
/* 190 */     this.jTabbedPanelTurnos.addTab("Horario", this.panelHorarios);
/* 191 */     this.jpDatosPaciente.setLayout(null);
/* 192 */     this.jpDatosPaciente.setBorder(
/* 193 */       new SoftBevelBorder(0));
/* 194 */     this.jpDatosPersona.setLayout(null);
/* 195 */     this.jpDatosPersona.setBorder(
/* 196 */       new BevelBorder(0));
/* 197 */     this.jpDatosPersona.add(this.txtNombre);
/* 198 */     this.txtNombre.setBounds(90, 20, 270, 20);
/* 199 */     this.txtNombre.addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent arg0) {
/* 204 */         PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtNombre);
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 210 */     this.txtApellido.addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent arg0) {
/* 215 */         PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtApellido);
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 221 */     this.txtCalle.addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent arg0) {
/* 226 */         PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtCalle);
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 232 */     this.txtCiudad.addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent arg0) {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent arg0) {
/* 237 */         PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtCiudad);
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 243 */     this.jpDatosPersona.add(this.txtApellido);
/* 244 */     this.txtApellido.setBounds(90, 40, 270, 20);
/* 245 */     this.lblNombre.setText("Nombre");
/* 246 */     this.jpDatosPersona.add(this.lblNombre);
/* 247 */     this.lblNombre.setBounds(10, 20, 55, 16);
/* 248 */     this.lblApellido.setText("Apellido");
/* 249 */     this.jpDatosPersona.add(this.lblApellido);
/* 250 */     this.lblApellido.setBounds(10, 40, 55, 16);
/* 251 */     this.lblDocumento.setText("Documento");
/* 252 */     this.jpDatosPersona.add(this.lblDocumento);
/* 253 */     this.lblDocumento.setBounds(10, 70, 75, 16);
/* 254 */     this.jpDatosPersona.add(this.txtDocumento);
/* 255 */     this.txtDocumento.setBounds(90, 70, 80, 20);
/* 256 */     this.lblTipo.setText("Tipo");
/* 257 */     this.jpDatosPersona.add(this.lblTipo);
/* 258 */     this.lblTipo.setBounds(225, 70, 30, 16);
/* 259 */     this.jpDatosPersona.add(this.cbTipo);
/* 260 */     this.cbTipo.setBounds(260, 70, 100, 20);
/* 261 */     this.cbTipo.setModel(
/* 262 */       new DefaultComboBoxModel(TipoDocumentoSearcher.findAll().toArray()));
/* 263 */     this.lblTelefono.setText("Telefono");
/* 264 */     this.jpDatosPersona.add(this.lblTelefono);
/* 265 */     this.lblTelefono.setBounds(80, 130, 60, 16);
/* 266 */     this.jpDatosPersona.add(this.txtTelefono);
/* 267 */     this.txtTelefono.setBounds(160, 130, 120, 20);
/* 268 */     this.lblCalle.setText("Calle");
/* 269 */     this.jpDatosPersona.add(this.lblCalle);
/* 270 */     this.lblCalle.setBounds(10, 180, 50, 16);
/* 271 */     this.lblNumero.setText("Numero y piso");
/* 272 */     this.jpDatosPersona.add(this.lblNumero);
/* 273 */     this.lblNumero.setBounds(10, 200, 95, 16);
/* 274 */     this.lblCiudad.setText("Ciudad");
/* 275 */     this.jpDatosPersona.add(this.lblCiudad);
/* 276 */     this.lblCiudad.setBounds(10, 220, 50, 16);
/* 277 */     this.lblDireccion.setText("Direccion");
/* 278 */     this.jpDatosPersona.add(this.lblDireccion);
/* 279 */     this.lblDireccion.setBounds(130, 160, 80, 16);
/* 280 */     this.jpDatosPersona.add(this.txtCalle);
/* 281 */     this.txtCalle.setBounds(120, 180, 230, 20);
/* 282 */     this.jpDatosPersona.add(this.txtNumero);
/* 283 */     this.txtNumero.setBounds(120, 200, 230, 20);
/* 284 */     this.jpDatosPersona.add(this.txtCiudad);
/* 285 */     this.txtCiudad.setBounds(120, 220, 230, 20);
/* 286 */     this.jpDatosPaciente.add(this.jpDatosPersona);
/* 287 */     this.jpDatosPersona.setBounds(20, 90, 390, 280);
/* 288 */     this.jpAux.setLayout(null);
/* 289 */     this.jpAux.setBorder(
/* 290 */       new BevelBorder(0));
/*     */ 
/* 292 */     this.panelPrimerPaso.setBounds(450, 10, 140, 24);
/* 293 */     this.jpDatosPaciente.add(this.jpAux);
/* 294 */     this.jpAux.setBounds(10, 10, 730, 40);
/* 295 */     this.jpDatosOs.setLayout(null);
/* 296 */     this.jpDatosOs.setBorder(
/* 297 */       new BevelBorder(0));
/* 298 */     this.lblTitulo.setHorizontalAlignment(0);
/* 299 */     this.lblTitulo.setText("   Obra Social   ");
/* 300 */     this.lblTitulo.setBorder(
/* 301 */       new BevelBorder(0));
/* 302 */     this.jpDatosOs.add(this.lblTitulo);
/* 303 */     this.lblTitulo.setBounds(20, 10, 280, 20);
/* 304 */     this.lblNumeroAfiliado.setText("Numero de Afiliado");
/* 305 */     this.jpDatosOs.add(this.lblNumeroAfiliado);
/* 306 */     this.lblNumeroAfiliado.setBounds(10, 90, 135, 16);
/* 307 */     this.jpDatosOs.add(this.txtNumeroAfiliado);
/* 308 */     this.txtNumeroAfiliado.setBounds(140, 90, 150, 20);
/*     */ 
/* 311 */     this.jpDatosOs.add(this.lblObraSoc);
/* 312 */     this.lblObraSoc.setBounds(110, 50, 180, 20);
/* 313 */     this.jpDatosPaciente.add(this.jpDatosOs);
/* 314 */     this.jpDatosOs.setBounds(420, 70, 320, 140);
/* 315 */     this.btnBuscar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 317 */         PanelNuevoTurnoImpl.this.btnBuscarActionPerformed(arg0);
/*     */       }
/*     */     });
/* 320 */     this.btnBuscar.setText("Buscar");
/* 321 */     this.jpBuscar.add(this.btnBuscar);
/* 322 */     this.jpDatosPaciente.add(this.jpBuscar);
/* 323 */     this.jpBuscar.setBounds(150, 390, 130, 40);
/* 324 */     this.jpObserbaciones.setLayout(null);
/* 325 */     this.jpObserbaciones.setBorder(
/* 326 */       new BevelBorder(0));
/* 327 */     this.jScrollPane1.setBorder(
/* 328 */       new TitledBorder("Observaciones"));
/* 329 */     this.jScrollPane1.setViewportView(this.txtObservaciones);
/* 330 */     this.jpObserbaciones.add(this.jScrollPane1);
/* 331 */     this.jScrollPane1.setBounds(10, 10, 300, 140);
/* 332 */     this.jpDatosPaciente.add(this.jpObserbaciones);
/* 333 */     this.jpObserbaciones.setBounds(420, 290, 320, 160);
/* 334 */     this.jpConsultorio.setLayout(null);
/* 335 */     this.jpConsultorio.setBorder(
/* 336 */       new BevelBorder(0));
/* 337 */     this.jLabel1.setText("Consultorio");
/* 338 */     this.jpConsultorio.add(this.jLabel1);
/* 339 */     this.jLabel1.setBounds(10, 20, 75, 16);
/* 340 */     this.jpConsultorio.add(this.cbConsultorio);
/* 341 */     this.cbConsultorio.setBounds(90, 20, 210, 20);
/* 342 */     this.cbConsultorio.setModel(
/* 343 */       new DefaultComboBoxModel(new String[] { 
/* 343 */       "Consultorio 1", "Consultorio 2" }));
/* 344 */     this.jpDatosPaciente.add(this.jpConsultorio);
/* 345 */     this.jpConsultorio.setBounds(420, 220, 320, 60);
/* 346 */     this.jTabbedPanelTurnos.addTab("Datos del Paciente", this.jpDatosPaciente);
/* 347 */     add(this.jTabbedPanelTurnos);
/* 348 */     this.jTabbedPanelTurnos.setBounds(0, 0, 760, 490);
/* 349 */     this.btnAceptarTurnoNuevo.setText("Aceptar Turno");
/* 350 */     this.btnAceptarTurnoNuevo
/* 351 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 353 */         PanelNuevoTurnoImpl.this.btnAceptarTurnoNuevoActionPerformed(evt);
/*     */       }
/*     */     });
/* 356 */     add(this.btnAceptarTurnoNuevo);
/* 357 */     this.btnAceptarTurnoNuevo.setBounds(630, 490, 115, 26);
/* 358 */     this.btnImprimirTurnoPrepa.setText("Imprimir Turno y Preparación");
/* 359 */     this.btnImprimirTurnoPrepa
/* 360 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 362 */         PanelNuevoTurnoImpl.this.btnImprimirTurnoPrepaActionPerformed(evt);
/*     */       }
/*     */     });
/* 365 */     add(this.btnImprimirTurnoPrepa);
/* 366 */     this.btnImprimirTurnoPrepa.setBounds(100, 490, 220, 26);
/* 367 */     this.btnCancelarTurnoNuevo.setText("Cancelar");
/* 368 */     this.btnCancelarTurnoNuevo
/* 369 */       .addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 371 */         PanelNuevoTurnoImpl.this.btnCancelarTurnoNuevoActionPerformed(evt);
/*     */       }
/*     */     });
/* 374 */     add(this.btnCancelarTurnoNuevo);
/* 375 */     this.btnCancelarTurnoNuevo.setBounds(390, 490, 120, 26);
/* 376 */     this.jTabbedPanelTurnos.setEnabledAt(2, false);
/* 377 */     this.jTabbedPanelTurnos.setEnabledAt(1, false);
/*     */   }
/*     */ 
/*     */   private void btnBuscarActionPerformed(ActionEvent arg0) {
/* 381 */     buscar(this.txtNombre.getText().trim(), this.txtApellido.getText().trim());
/*     */   }
/*     */ 
/*     */   private void buscar(String nombre, String apellido) {
/* 385 */     new JDialogTablaPersonas((short) 0, new SelectPersonaAction(), nombre, 
/* 386 */       apellido, this.parent).setVisible(true);
/*     */   }
/*     */ 
/*     */   private void btnImprimirTurnoPrepaActionPerformed(ActionEvent evt)
/*     */   {
/* 392 */     if (this.panelHorarios.isSelected())
/*     */     {
/* 394 */       GregorianCalendar hora = this.panelHorarios.getSelectedHour();
/*     */ 
/* 396 */       TurnoPreparacion tp = null;
/* 397 */       Preparacion pre = this.panelPrimerPaso.getSelectedPractica()
/* 398 */         .getPreparacion();
/*     */ 
/* 400 */       if (pre == null) {
/* 401 */         pre = new Preparacion();
/* 402 */         pre.setDescripcion("Sin Preparacion..");
/*     */       }
/* 404 */       tp = new TurnoPreparacion(pre, hora, 
/* 405 */         this.panelPrimerPaso.getSelectedPractica().getDescription());
/*     */ 
/* 407 */       tp.setVisible(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnAceptarTurnoNuevoActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try {
/* 414 */       NotFullFormException.validateNotEmpty("falta.nombre", 
/* 415 */         this.txtNombre.getText());
/* 416 */       NotFullFormException.validateNotEmpty("falta.apellido", 
/* 417 */         this.txtApellido.getText());
/* 418 */       NotFullFormException.validateNotNull(
/* 419 */         "falta.obraSocial.primer.paso", 
/* 420 */         this.panelPrimerPaso.getSelectedObra());
/* 421 */       NotFullFormException.validateNotNull("falta.medico.primer.paso", 
/* 422 */         this.panelPrimerPaso.getSelectedMedico());
/* 423 */       NotFullFormException.validateNotNull("falta.practica.primer.paso", 
/* 424 */         this.panelPrimerPaso.getSelectedPractica());
/* 425 */       NotFullFormException.validateTrue("falta.horario", 
/* 426 */         this.panelHorarios.isSelected());
/* 427 */       validarNombre(this.txtNombre.getText().trim(), 
/* 428 */         this.txtApellido.getText().trim());
/*     */ 
/* 432 */       if (this.persona == null)
/* 433 */         this.persona = new Persona();
/* 434 */       this.persona.setNombre(this.txtNombre.getText().trim());
/* 435 */       this.persona.setApellido(this.txtApellido.getText().trim());
/*     */ 
/* 437 */       if (!this.txtDocumento.getText().trim().equals("")) {
/* 438 */         this.persona
/* 439 */           .setDocumento(new Integer(this.txtDocumento.getText().trim()));
/*     */       }
/*     */ 
/* 442 */       if (this.cbTipo.getSelectedIndex() >= 0) {
/* 443 */         this.persona.setTipoDocumento((TipoDocumento)
/* 444 */           this.cbTipo.getSelectedItem());
/*     */       }
/*     */ 
/* 447 */       if (!this.txtTelefono.getText().trim().equals("")) {
/* 448 */         this.persona.setTelefono(this.txtTelefono.getText().trim());
/*     */       }
/*     */ 
/* 451 */       if (!this.txtCalle.getText().trim().equals("")) {
/* 452 */         this.persona.setCalle(this.txtCalle.getText().trim());
/*     */       }
/*     */ 
/* 455 */       if (!this.txtNumero.getText().trim().equals("")) {
/* 456 */         this.persona.setNumero(this.txtNumero.getText().trim());
/*     */       }
/*     */ 
/* 459 */       if (!this.txtCiudad.getText().trim().equals("")) {
/* 460 */         this.persona.setCiudad(this.txtCiudad.getText().trim());
/*     */       }
/*     */ 
/* 463 */       if (BuscadorPersona.getInstance().existByDocumento(
/* 464 */         this.persona.getDocumento(), this.persona.getTipoDocumento()));
/* 462 */       NotFullFormException.validateTrue("documento.existente", 
/* 465 */         this.buscado);
/* 466 */       completeInsert(this.persona);
/* 467 */       getFrameParent().setVisible(false);
/* 468 */       setVisible(false);
/*     */     } catch (Exception e) {
/* 470 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void validarNombre(String nombre, String apellido)
/*     */   {
/* 476 */     if ((!this.buscado) && 
/* 477 */       (BuscadorPersona.getInstance().existsByNombreApellido(nombre, 
/* 478 */       apellido)))
/* 479 */       if (JOptionPane.showConfirmDialog(null, 
/* 480 */         "Existen personas con nombres similares, desea continuar", 
/* 481 */         "Validar nombres repetidos", 0) == 1)
/* 482 */         throw new NotFullFormException(
/* 483 */           "Se encontraron personas con nombres similares");
/*     */   }
/*     */ 
/*     */   private void completeInsert(Persona pa)
/*     */   {
/* 490 */     PersistenceService.getInstance().save(pa);
/*     */ 
/* 492 */     GregorianCalendar horario = this.panelHorarios.getSelectedHour();
/* 493 */     Turno turno = new Turno();
/* 494 */     turno.setHora(horario.getTime());
/* 495 */     turno.setPaciente(pa);
/* 496 */     turno.setMedico(this.panelPrimerPaso.getSelectedMedico());
/* 497 */     turno.setObservaciones(this.txtObservaciones.getText().trim());
/* 498 */     turno.setPractica(this.panelPrimerPaso.getSelectedPractica());
/* 499 */     turno.setRealizado(Boolean.FALSE);
/* 500 */     if (this.panelPrimerPaso.getSelectedOsindex() >= 0)
/* 501 */       turno.setObraSocial(this.panelPrimerPaso.getSelectedObra());
/*     */     else {
/* 503 */       turno.setObraSocial(null);
/*     */     }
/* 505 */     turno.setNroAfiliado(this.txtNumeroAfiliado.getText().trim());
/*     */     try {
/* 507 */       PersistenceService.getInstance().save(turno);
/*     */     } catch (Exception e) {
/* 509 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnCancelarTurnoNuevoActionPerformed(ActionEvent evt)
/*     */   {
/* 515 */     getFrameParent().setVisible(false);
/* 516 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void keyReleasedActionPerformed(KeyEvent ev, JTextField tf) {
/* 520 */     if (tf.getText().length() == 1) {
/* 521 */       tf.setText(tf.getText().substring(0, 1).toUpperCase());
/*     */     }
/*     */ 
/* 524 */     if ((tf.getText().length() > 1) && (ev.getKeyCode() != 32)) {
/* 525 */       StringTokenizer stk = new StringTokenizer(tf.getText(), " ");
/* 526 */       String text = "";
/*     */ 
/* 528 */       while (stk.hasMoreTokens()) {
/* 529 */         String tok = stk.nextToken();
/* 530 */         text = text + tok.substring(0, 1).toUpperCase() + 
/* 531 */           tok.substring(1);
/*     */ 
/* 533 */         if (stk.hasMoreTokens()) {
/* 534 */           text = text + " ";
/*     */         }
/*     */       }
/* 537 */       tf.setText(text);
/*     */     }
/*     */   }
/*     */ 
/*     */   public PanelNuevoTurno setSelectedIndex(int index)
/*     */   {
/* 549 */     this.jTabbedPanelTurnos.setSelectedIndex(index);
/*     */ 
/* 551 */     return this;
/*     */   }
/*     */ 
/*     */   public Medico getSelectedMedico() {
/* 555 */     return this.panelPrimerPaso.getSelectedMedico();
/*     */   }
/*     */ 
/*     */   public JFrame getFrameParent() {
/* 559 */     return this.parent;
/*     */   }
/*     */ 
/*     */   public PanelNuevoTurno setEnabledAt(int index, boolean value) {
/* 563 */     this.jTabbedPanelTurnos.setEnabledAt(index, value);
/*     */ 
/* 565 */     return this;
/*     */   }
/*     */ 
/*     */   public PanelNuevoTurno setMedico(Medico medico) {
/* 569 */     this.panelHorarios.setMedico(medico);
/* 570 */     return this;
/*     */   }
/*     */   private class SelectPersonaAction implements TablaPersonasSelectionAction {
/*     */     private SelectPersonaAction() {
/*     */     }
/* 575 */     public void executeAction(Persona personaSeleccionada) { PanelNuevoTurnoImpl.this.persona = personaSeleccionada;
/* 576 */       PanelNuevoTurnoImpl.this.txtNombre.setText(personaSeleccionada.getNombre());
/* 577 */       PanelNuevoTurnoImpl.this.txtApellido.setText(personaSeleccionada.getApellido());
/* 578 */       Integer documento = personaSeleccionada.getDocumento();
/* 579 */       PanelNuevoTurnoImpl.this.txtDocumento.setText(documento != null ? documento.toString() : "");
/* 580 */       PanelNuevoTurnoImpl.this.cbTipo.setSelectedItem(personaSeleccionada.getTipoDocumento());
/* 581 */       PanelNuevoTurnoImpl.this.txtTelefono.setText(personaSeleccionada.getTelefono());
/* 582 */       PanelNuevoTurnoImpl.this.txtCalle.setText(personaSeleccionada.getCalle());
/* 583 */       PanelNuevoTurnoImpl.this.txtNumero.setText(personaSeleccionada.getNumero());
/* 584 */       PanelNuevoTurnoImpl.this.txtCiudad.setText(personaSeleccionada.getCiudad());
/* 585 */       PanelNuevoTurnoImpl.this.buscado = true;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.PanelNuevoTurnoImpl
 * JD-Core Version:    0.6.0
 */