/*     */ package com.cyrius.turnos.gui.verTurno;

/*     */
/*     */ import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.cyrius.components.CyriusComboMedicos;
import com.cyrius.entities.Medico;
import com.cyrius.entities.Turno;
import com.cyrius.exceptions.ConfigFileException;
import com.cyrius.turnos.gui.verTurno.old.FrameNuevoTurnoImpl;
import com.cyrius.ui.components.CyriusCalendar;
import com.cyrius.ui.components.NoAtiendeSelectionMode;
import com.cyrius.ui.components.TablaVerTurnos;
import com.cyrius.utils.prints.JTablePrintUtil;
import com.framework.abstractfactorys.FrameworkUseCaseFactory;
import com.framework.entities.FormModelUtils;
import com.framework.exceptions.ExceptionHandler;
import com.framework.persistence.PersistenceService;
import com.framework.utils.StringProvider;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.event.DateSelectionEvent;
import com.standbysoft.datepicker.event.DateSelectionListener;

/*     */
/*     */ public class VerTurnosJPanel extends JPanel
/*     */ {
	/*     */ private static JPanel panelVerTurnos;
	/*     */ protected static JPanel pnTurnosCalendario;
	/*     */ private ButtonGroup buttonGroup1;
	/*     */ private CyriusComboMedicos<Medico> cbMedicos;
	/*     */ private JButton btnNuevoTurno;
	/*     */ private JLabel jLabel1;
	/*     */ private CyriusCalendar calendario;
	/*     */ private JLabel lblMedico;
	/*     */ private JRadioButton rbtnTManana;
	/*     */ private JRadioButton rbtnTTarde;
	/*     */ private JScrollPane scrolPanelTurnos;
	/*     */ private TablaVerTurnos tablaTurnos;
	/*     */ private JPopupMenu popUp;
	/*     */ private JMenuItem miAsistio;
	/*     */ private JMenuItem miCamiar;
	/*     */ private JSeparator miSep;
	/*     */ private JMenuItem miBorrar;
	/*     */ private JMenuItem miVer;
	/*     */ protected TurnosFrame parent;
	/*     */ private JTextPane txtHelp;
	/*     */ private JButton btnImprimir;

	/*     */
	/*     */ public VerTurnosJPanel(TurnosFrame parent)/*     */ throws ConfigFileException
	/*     */ {
		/* 102 */ this.parent = parent;
		/* 103 */ initComponents();
		/* 104 */ checkRecordatorio();
		/* 105 */ this.calendario.getDateSelectionModel()
				.setSelectionMode(/* 106 */ DateSelectionModel.SelectionMode.SINGLE);
		/*     */ }

	/*     */
	/*     */ protected void checkRecordatorio() {
		/* 110 */ new Thread(new Runnable()
		/*     */ {
			/*     */ public void run()
			/*     */ {
				/* 114 */ VerTurnosJPanel.this.refresh();
				/*     */ }
			/*     */ }).start();
		/*     */ }

	/*     */
	/*     */ private void initComponents() throws ConfigFileException {
		/* 121 */ this.btnImprimir = new JButton("Imprimir tabla de turnos.");
		/* 122 */ this.buttonGroup1 = new ButtonGroup();
		/* 123 */ panelVerTurnos = new JPanel();
		/* 124 */ this.scrolPanelTurnos = new JScrollPane();
		/* 125 */ this.rbtnTTarde = new JRadioButton();
		/* 126 */ this.rbtnTManana = new JRadioButton();
		/* 127 */ pnTurnosCalendario = new JPanel();
		/* 128 */ this.calendario = new CyriusCalendar();
		/* 129 */ this.lblMedico = new JLabel();
		/* 130 */ this.cbMedicos = new CyriusComboMedicos();
		/* 131 */ this.btnNuevoTurno = new JButton();
		/*     */
		/* 133 */ this.jLabel1 = new JLabel();
		/* 134 */ this.tablaTurnos = new TablaVerTurnos(TablaVerTurnos.MANANA);
		/* 135 */ setLayout(new BorderLayout());
		/* 136 */ this.txtHelp = new JTextPane();
		/* 137 */ this.btnImprimir.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent e) {
				/* 139 */ VerTurnosJPanel.this.btnImprimirActionPerformed(e);
				/*     */ }
			/*     */ });
		/* 142 */ this.btnImprimir.setBounds(490, 415, 180, 26);
		/* 143 */ this.btnImprimir.setVisible(false);
		/* 144 */ panelVerTurnos.add(this.btnImprimir);
		/* 145 */ panelVerTurnos.setLayout(null);
		/* 146 */ panelVerTurnos.setFont(new Font("Dialog", 0, 10));
		/* 147 */ this.scrolPanelTurnos.setBorder(/* 148 */ new BevelBorder(0));
		/* 149 */ this.scrolPanelTurnos/* 150 */ .setViewportBorder(new EtchedBorder());
		/* 151 */ this.scrolPanelTurnos.setMaximumSize(new Dimension(50, 50));
		/* 152 */ this.scrolPanelTurnos.setMinimumSize(new Dimension(0, 0));
		/* 153 */ this.scrolPanelTurnos.setPreferredSize(new Dimension(656, 656));
		/* 154 */ this.scrolPanelTurnos.setAutoscrolls(true);
		/* 155 */ this.scrolPanelTurnos.setVisible(false);
		/* 156 */ panelVerTurnos.add(this.scrolPanelTurnos);
		/* 157 */ this.scrolPanelTurnos.setBounds(0, 0, 450, 523);
		/* 158 */ this.txtHelp.setOpaque(false);
		/* 159 */ this.txtHelp.setEditable(false);
		/* 160 */ this.txtHelp.setBorder(new TitledBorder("Instrucciones: "));
		/* 161 */ this.txtHelp.setToolTipText("Instrucciones para el uso del Programa.");
		/* 162 */ this.txtHelp/* 163 */ .setText(
				"Para comenzar el uso, usted tiene que seleccionar un medico, y luego le aparecera un calendario, en el cual usted debe seleccionar la fecha a ver los turnos de dicho medico.");
		/*     */
		/* 166 */ panelVerTurnos.add(this.txtHelp);
		/* 167 */ this.txtHelp.setBounds(10, 220, 400, 90);
		/* 168 */ this.rbtnTTarde.setEnabled(false);
		/* 169 */ this.rbtnTTarde.setText("Turnos de la Tarde");
		/* 170 */ this.buttonGroup1.add(this.rbtnTTarde);
		/* 171 */ this.rbtnTTarde.setBorder(/* 172 */ new EmptyBorder(new Insets(1, 1, 1, 1)));
		/* 173 */ this.rbtnTTarde.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent evt) {
				/* 175 */ VerTurnosJPanel.this.rbtnTTardeActionPerformed(evt);
				/*     */ }
			/*     */ });
		/* 178 */ panelVerTurnos.add(this.rbtnTTarde);
		/* 179 */ this.rbtnTTarde.setBounds(510, 330, 140, 18);
		/* 180 */ this.rbtnTManana.setText("Turnos de la Mañana");
		/* 181 */ this.rbtnTManana.setEnabled(false);
		/* 182 */ this.buttonGroup1.add(this.rbtnTManana);
		/* 183 */ this.rbtnTManana.setBorder(/* 184 */ new EmptyBorder(new Insets(1, 1, 1, 1)));
		/* 185 */ this.rbtnTManana.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent evt) {
				/* 187 */ VerTurnosJPanel.this.rbtnTMananaActionPerformed(evt);
				/*     */ }
			/*     */ });
		/* 190 */ panelVerTurnos.add(this.rbtnTManana);
		/* 191 */ this.rbtnTManana.setBounds(510, 310, 150, 18);
		/* 192 */ pnTurnosCalendario.setLayout(null);
		/* 193 */ pnTurnosCalendario.setBorder(/* 194 */ new BevelBorder(0));
		/* 195 */ // TODO this.calendario.setDisplayToday(false);
		/* 196 */ this.calendario.setWeekNumbersVisible(false);
		/* 197 */ pnTurnosCalendario.add(this.calendario);
		/* 198 */ this.calendario.setBounds(10, 5, 202, 165);
		/* 199 */ this.calendario/* 200 */ .addDateSelectionListener(new DateSelectionListener()
		/*     */ {
			/*     */ public void disabledDatesChanged(DateSelectionEvent evt)
			/*     */ {
				/*     */ }

			/*     */
			/*     */ public void dateSelectionChanged(DateSelectionEvent evt) {
				/*     */ try {
					/* 208 */ VerTurnosJPanel.this.calendarioDateSelectionChanged(evt);
					/*     */ } catch (Exception ex) {
					/* 210 */ ExceptionHandler.getInstance().handle(ex);
					/*     */ }
				/*     */ }

			/*     */
			/*     */ public void selectionModeChanged(DateSelectionEvent evt)
			/*     */ {
				/*     */ }
			/*     */
		});
		/* 218 */ this.calendario.setFocusable(true);
		/* 219 */ panelVerTurnos.add(pnTurnosCalendario);
		/* 220 */ pnTurnosCalendario.setBounds(470, 50, 223, 175);
		/* 221 */ this.lblMedico.setText("Médico");
		/* 222 */ panelVerTurnos.add(this.lblMedico);
		/* 223 */ this.lblMedico.setBounds(560, 240, 50, 16);
		/* 224 */ this.cbMedicos.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent arg0) {
				/*     */ try {
					/* 227 */ VerTurnosJPanel.this.cbMedicossActionPerformed(arg0);
					/*     */ } catch (Exception ex) {
					/* 229 */ ExceptionHandler.getInstance().handle(ex);
					/*     */ }
				/*     */ }
			/*     */ });
		/* 233 */ this.cbMedicos.setTodos();
		/* 234 */ this.cbMedicos.withOutNullElement();
		/* 235 */ panelVerTurnos.add(this.cbMedicos);
		/* 236 */ this.cbMedicos.setBounds(460, 270, 250, 31);
		/* 237 */ this.cbMedicos.refreshComponent();
		/* 238 */ this.btnNuevoTurno.setText("Nuevo Turno");
		/* 239 */ this.btnNuevoTurno.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent evt) {
				/* 241 */ VerTurnosJPanel.this.btnNuevoTurnoActionPerformed(evt);
				/*     */ }
			/*     */ });
		/* 244 */ panelVerTurnos.add(this.btnNuevoTurno);
		/* 245 */ this.btnNuevoTurno.setBounds(520, 360, 130, 19);
		/* 246 */ this.jLabel1.setIcon(new ImageIcon("./Img/cyrius.gif"));
		/* 247 */ panelVerTurnos.add(this.jLabel1);
		/* 248 */ this.jLabel1.setBounds(500, 450, 160, 70);
		/* 249 */ add(panelVerTurnos, "Center");
		/* 250 */ makePopUp();
		/* 251 */ this.calendario.setVisible(false);
		/* 252 */ postInit();
		/*     */ }

	/*     */
	/*     */ private void postInit()/*     */ throws ConfigFileException
	/*     */ {
		/* 261 */ GregorianCalendar date = (GregorianCalendar)
		/* 262 */ GregorianCalendar.getInstance();
		/* 263 */ this.calendario.getDateSelectionModel().setDateSelectionIterval(/* 264 */ date.getTime(),
				date.getTime());
		/*     */ }

	/*     */
	/*     */ private void btnImprimirActionPerformed(ActionEvent e) {
		/* 268 */ JTablePrintUtil ut = new JTablePrintUtil(this.tablaTurnos);
		/* 269 */ Thread t = new Thread(ut);
		/* 270 */ t.start();
		/*     */ }

	/*     */
	/*     */ private void btnRecordatorioActionPerformed(ActionEvent evt) {
		/* 274 */ Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/* 275 */ int resAncho = (int) screenSize.getWidth();
		/* 276 */ int resAlto = (int) screenSize.getHeight();
		/* 277 */ FrameBuscarRecs recs = new FrameBuscarRecs(this);
		/* 278 */ recs.setBounds(resAncho / 2 - 205, resAlto / 2 - 120, 409, 239);
		/* 279 */ recs.setVisible(true);
		/*     */ }

	/*     */
	/*     */ private void rbtnTTardeActionPerformed(ActionEvent evt) {
		/*     */ try {
			/* 284 */ this.scrolPanelTurnos.setVisible(true);
			/* 285 */ GregorianCalendar fecha = new GregorianCalendar();
			/* 286 */ fecha.setTime(/* 287 */ this.calendario.getDateSelectionModel().getLeadSelectionDate());
			/* 288 */ this.tablaTurnos.setMedico((Medico) this.cbMedicos.getSelectedItem());
			/* 289 */ fecha.set(11, 15);
			/* 290 */ this.tablaTurnos.setDay(fecha);
			/* 291 */ this.tablaTurnos.setEstado(TablaVerTurnos.TARDE);
			/* 292 */ this.scrolPanelTurnos.setViewportView(this.tablaTurnos);
			/*     */ } catch (Exception e) {
			/* 294 */ ExceptionHandler.getInstance().handle(e);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void rbtnTMananaActionPerformed(ActionEvent evt) {
		/*     */ try {
			/* 300 */ this.scrolPanelTurnos.setVisible(true);
			/* 301 */ GregorianCalendar fecha = new GregorianCalendar();
			/* 302 */ fecha.setTime(/* 303 */ this.calendario.getDateSelectionModel().getLeadSelectionDate());
			/* 304 */ this.tablaTurnos.setMedico((Medico) this.cbMedicos.getSelectedItem());
			/* 305 */ fecha.set(11, 8);
			/* 306 */ this.tablaTurnos.setDay(fecha);
			/* 307 */ this.tablaTurnos.setEstado(TablaVerTurnos.MANANA);
			/* 308 */ this.scrolPanelTurnos.setViewportView(this.tablaTurnos);
			/*     */ } catch (Exception e) {
			/* 310 */ ExceptionHandler.getInstance().handle(e);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void btnNuevoTurnoActionPerformed(ActionEvent evt)
	/*     */ {
		/*     */ try
		/*     */ {
			/* 319 */ FrameNuevoTurnoImpl panel = new FrameNuevoTurnoImpl();
			/* 320 */ panel.setVisible(true);
			/* 321 */ panel/* 322 */ .addComponentListener(new RefreshTablaTurnosPrincipalListener());
			/*     */ } catch (Throwable e) {
			/* 324 */ ExceptionHandler.getInstance().handle(e);
			/*     */ }
		/* 326 */ setCursor(new Cursor(0));
		/*     */ }

	/*     */
	/*     */ private void calendarioDateSelectionChanged(DateSelectionEvent evt)
	/*     */ {
		/* 331 */ if (this.cbMedicos.getSelectedItem() == null) /* 332 */ return;
		/* 333 */ this.btnImprimir.setVisible(true);
		/* 334 */ if ((this.cbMedicos.getSelectedItem() != null) &&
				/* 335 */ (((Medico) this.cbMedicos.getSelectedItem())
						/* 335 */ .getAtiendeDeManana((Calendar) this.calendario.getValor()))) {
			/* 336 */ this.rbtnTManana.setEnabled(true);
			/* 337 */ this.rbtnTManana.doClick();
			/*     */ } else {
			/* 339 */ this.rbtnTManana.setEnabled(false);
			/*     */ }
		/* 341 */ if (((Medico) this.cbMedicos.getSelectedItem())
				.getAtiendeDeTarde(/* 342 */ (Calendar) this.calendario.getValor())) {
			/* 343 */ this.rbtnTTarde.setEnabled(true);
			/* 344 */ if (!this.rbtnTManana.isEnabled()) /* 345 */ this.rbtnTTarde.doClick();
			/*     */ }
			/*     */ else {
			/* 348 */ this.rbtnTTarde.setEnabled(false);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void cbMedicossActionPerformed(ActionEvent evt) {
		/* 353 */ if (this.cbMedicos.getSelectedIndex() > -1) {
			/* 354 */ this.calendario.setVisible(true);
			/* 355 */ this.calendario
					/* 356 */ .setToolTipText("Calendario para seleccionar el dia, para ver los turnos del medioco " +
							/* 357 */ ((Medico) this.cbMedicos.getSelectedItem()).getApellido() +
							/* 358 */ " " +
							/* 359 */ ((Medico) this.cbMedicos.getSelectedItem()).getNombre());
			/*     */
			/* 361 */ GregorianCalendar fecha = new GregorianCalendar();
			/* 362 */ if (this.calendario.getDateSelectionModel().getSelectedDates().length > 0) {
				/* 363 */ fecha.setTime(/* 364 */ this.calendario.getDateSelectionModel().getLeadSelectionDate());
				/* 365 */ if (((Medico) this.cbMedicos.getSelectedItem())
						.getAtiendeDeManana(/* 366 */ (Calendar) this.calendario.getValor())) {
					/* 367 */ this.rbtnTManana.setEnabled(true);
					/*     */ }
				/* 369 */ if (((Medico) this.cbMedicos.getSelectedItem())
						.getAtiendeDeTarde(/* 370 */ (Calendar) this.calendario.getValor())) {
					/* 371 */ this.rbtnTTarde.setEnabled(true);
					/*     */ }
				/*     */ }
			/* 374 */ Medico medico = (Medico) this.cbMedicos.getSelectedItem();
			/* 375 */ NoAtiendeSelectionMode noAtiendeSelectionMode = new NoAtiendeSelectionMode(/* 376 */ medico);
			/* 377 */ noAtiendeSelectionMode/* 378 */ .setCancelSelectionOnNotAviableDays4Medic(true);
			/* 379 */ noAtiendeSelectionMode.setNotOldDays(false);
			/* 380 */ this.calendario.setDateSelectionModel(noAtiendeSelectionMode);
			/* 381 */ if (this.tablaTurnos != null) {
				/* 382 */ fecha = new GregorianCalendar();
				/* 383 */ this.tablaTurnos.setMedico((Medico) this.cbMedicos.getSelectedItem());
				/* 384 */ this.tablaTurnos.setDay(fecha);
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void makePopUp()
	/*     */ {
		/* 391 */ this.popUp = new JPopupMenu();
		/* 392 */ this.miVer = new JMenuItem("Ver Turno");
		/* 393 */ this.miAsistio = new JMenuItem("Asistio y Completar Datos");
		/* 394 */ this.miCamiar = new JMenuItem("Cambiar de Horario");
		/* 395 */ this.miSep = new JSeparator();
		/* 396 */ this.miBorrar = new JMenuItem("Borrar Turno");
		/* 397 */ this.popUp.add(this.miAsistio);
		/* 398 */ this.popUp.add(this.miVer);
		/* 399 */ this.popUp.add(this.miCamiar);
		/* 400 */ this.popUp.add(this.miSep);
		/* 401 */ this.popUp.add(this.miBorrar);
		/* 402 */ this.tablaTurnos.add(this.popUp);
		/* 403 */ this.miVer.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent arg0) {
				/*     */ try {
					/* 406 */ VerTurnosJPanel.this.miVerAciotnPerformed(arg0);
					/*     */ } catch (Exception ex) {
					/* 408 */ ExceptionHandler.getInstance().handle(ex);
					/*     */ }
				/*     */ }
			/*     */ });
		/* 412 */ this.miAsistio.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent arg0) {
				/*     */ try {
					/* 415 */ VerTurnosJPanel.this.miAsistioAciotnPerformed(arg0);
					/*     */ } catch (Exception ex) {
					/* 417 */ ExceptionHandler.getInstance().handle(ex);
					/*     */ }
				/*     */ }
			/*     */ });
		/* 421 */ this.miCamiar.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent arg0) {
				/* 423 */ VerTurnosJPanel.this.miCambiarAciotnPerformed(arg0);
				/*     */ }
			/*     */ });
		/* 426 */ this.miBorrar.addActionListener(new ActionListener() {
			/*     */ public void actionPerformed(ActionEvent arg0) {
				/* 428 */ VerTurnosJPanel.this.miBorrarAciotnPerformed(arg0);
				/*     */ }
			/*     */ });
		/* 431 */ this.tablaTurnos.addMouseListener(new MouseAdapter()
		/*     */ {
			@Override
			public void mousePressed(MouseEvent e) {
				VerTurnosJPanel.this.tablaTurnos.setRowSelectionInterval(
						VerTurnosJPanel.this.tablaTurnos.rowAtPoint(e.getPoint()),
						VerTurnosJPanel.this.tablaTurnos.rowAtPoint(e.getPoint()));
				if ((e.isPopupTrigger()) && (VerTurnosJPanel.this.tablaTurnos.getSelectedRowCount() > 0)
						&& (VerTurnosJPanel.this.tablaTurnos
								.hasTurno(VerTurnosJPanel.this.tablaTurnos.getSelectedRow())))
					VerTurnosJPanel.this.maybeShowPopup(e);
			}

			/*     */ public void mouseReleased(MouseEvent e) {
				/* 434 */ VerTurnosJPanel.this.tablaTurnos.setRowSelectionInterval(
						VerTurnosJPanel.this.tablaTurnos/* 435 */ .rowAtPoint(e.getPoint()),
						VerTurnosJPanel.this.tablaTurnos.rowAtPoint(e.getPoint()));
				/* 436 */ if ((e.isPopupTrigger()) &&
						/* 437 */ (VerTurnosJPanel.this.tablaTurnos.getSelectedRowCount() > 0) &&
						/* 438 */ (VerTurnosJPanel.this.tablaTurnos
								.hasTurno(VerTurnosJPanel.this.tablaTurnos.getSelectedRow())))
					/* 439 */ VerTurnosJPanel.this.maybeShowPopup(e);
				/*     */ }
			/*     */ });
		/*     */ }

	/*     */
	/*     */ private void maybeShowPopup(MouseEvent e)
	/*     */ {
		/* 447 */ this.popUp.show(e.getComponent(), e.getX(), e.getY());
		/*     */ }

	/*     */
	/*     */ private void miVerAciotnPerformed(ActionEvent arg0) {
		/* 451 */ VerAsistioUseCaseFactory uc =
		/* 452 */ (VerAsistioUseCaseFactory) FrameworkUseCaseFactory.createChildUseCase(VerAsistioUseCaseFactory.class);
		/*     */ try {
			/* 454 */ uc.setModelo(FormModelUtils.wrap(this.tablaTurnos.getSelectedTurno()));
			/* 455 */ FrameworkUseCaseFactory.launchUseCase(uc);
			/* 456 */ uc.getInternalWindow().setDefaultCloseOperation(/* 457 */ 3);
			/*     */ } catch (Exception e) {
			/* 459 */ ExceptionHandler.getInstance().handle(e);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void miCambiarAciotnPerformed(ActionEvent arg0)
	/*     */ {
		/* 465 */ FrameCambiarHorario cambiar = new FrameCambiarHorario(this.tablaTurnos.getSelectedTurno(), this);
		/*     */ try {
			/* 467 */ refresh();
			/*     */ } catch (Exception ex) {
			/* 469 */ ExceptionHandler.getInstance().handle(ex);
			/*     */ }
		/* 471 */ cambiar.setVisible(true);
		/*     */ }

	/*     */
	/*     */ private void miAsistioAciotnPerformed(ActionEvent arg0) {
		/* 475 */ AsistioUseCaseFactory uc =
		/* 476 */ (AsistioUseCaseFactory) FrameworkUseCaseFactory.createChildUseCase(AsistioUseCaseFactory.class);
		/*     */ try {
			/* 478 */ Turno selectedTurno = this.tablaTurnos.getSelectedTurno();
			/* 479 */ uc.setModelo(FormModelUtils.wrap(selectedTurno));
			/* 480 */ uc.getInternalWindow().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			/* 482 */ uc.getInternalWindow().getWraped()
					.addComponentListener(new RefreshTablaTurnosPrincipalListener());
			/* 484 */ FrameworkUseCaseFactory.launchUseCase(uc);
			/*     */ } catch (Exception e) {
			/* 486 */ ExceptionHandler.getInstance().handle(e);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ private void miBorrarAciotnPerformed(ActionEvent arg0) {
		/* 491 */ int resp = JOptionPane.showConfirmDialog(this,
				/* 492 */ StringProvider.getInstance().getValueOf("ConfirmarBorradoTurno"),
				/* 493 */ StringProvider.getInstance().getValueOf("TituloBorradoTurno"), /* 494 */ 2);
		/* 495 */ if (resp == 0) {
			/* 496 */ Turno t = this.tablaTurnos.getSelectedTurno();
			/* 497 */ if (t.getRealizado().booleanValue()) {
				/* 498 */ JOptionPane.showMessageDialog(this,
						/* 499 */ StringProvider.getInstance().getValueOf("ImposibleBorrarTurno"),
						/* 500 */ StringProvider.getInstance().getValueOf(/* 501 */ "ImposibleBorrarTurnoTitulo"),
						/* 502 */ 0);
				/*     */ } else {
				/* 504 */ PersistenceService.getInstance().delete(t);
				/* 505 */ this.tablaTurnos.reload();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ public void refresh() {
		/* 511 */ if (this.rbtnTManana.isSelected()) /* 512 */ this.rbtnTManana.doClick();
		/*     */ else/* 514 */ this.rbtnTTarde.doClick();
		/*     */ }

	/*     */
	/*     */ private class RefreshTablaTurnosPrincipalListener extends ComponentAdapter
	/*     */ {
		/*     */ private RefreshTablaTurnosPrincipalListener()
		/*     */ {
			/*     */ }

		/*     */
		/*     */ public void componentHidden(ComponentEvent e)
		/*     */ {
			/* 53 */ VerTurnosJPanel.this.tablaTurnos.reload();
			/*     */ }
		/*     */ }
	/*     */ }

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar Qualified Name:
 * com.cyrius.turnos.gui.verTurno.VerTurnosJPanel JD-Core Version: 0.6.0
 */