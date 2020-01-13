package com.cyrius.turnos.gui.verTurno.old;

import com.cyrius.entities.Medico;
import com.cyrius.entities.Persona;
import com.cyrius.entities.Preparacion;
import com.cyrius.entities.TipoDocumento;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorPersona;
import com.cyrius.searchers.TipoDocumentoSearcher;
import com.cyrius.turnos.gui.listas.JDialogTablaPersonas;
import com.cyrius.turnos.gui.listas.TablaPersonasSelectionAction;
import com.cyrius.turnos.gui.nuevoTurno.TurnoPreparacion;
import com.framework.exceptions.ExceptionHandler;
import com.framework.exceptions.NotFullFormException;
import com.framework.persistence.PersistenceService;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class PanelNuevoTurnoImpl extends JPanel
        implements PanelNuevoTurno {
    private JButton btnAceptarTurnoNuevo;
    private JButton btnBuscar;
    private JButton btnCancelarTurnoNuevo;
    private JButton btnImprimirTurnoPrepa;
    private JComboBox cbConsultorio;
    private JEditorPane txtObservaciones;
    private JLabel jLabel1;
    private JPanel jpObserbaciones;
    private JPanel jpConsultorio;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPanelTurnos;
    private JPanel jpAux;
    private JPanel jpBuscar;
    private JPanel jpDatosOs;
    private JPanel jpDatosPaciente;
    private JPanel jpDatosPersona;
    private JLabel lblApellido;
    private JLabel lblCalle;
    private JLabel lblCiudad;
    private JLabel lblDireccion;
    private JLabel lblDocumento;
    private JLabel lblNombre;
    private JLabel lblNumero;
    private JLabel lblNumeroAfiliado;
    private JLabel lblTelefono;
    private JLabel lblTipo;
    private JLabel lblTitulo;
    private JLabel fotoCyrius;
    private JLabel lblObraSoc;
    private PanelPrimerPaso panelPrimerPaso;
    private JTextField txtApellido;
    private JTextField txtCalle;
    private JTextField txtCiudad;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JTextField txtNumeroAfiliado;
    private JTextField txtTelefono;
    private JComboBox cbTipo;
    private PanelNuevoTurnoHorarios panelHorarios;
    private boolean buscado = false;
    private FrameNuevoTurnoImpl parent;
    private Persona persona;

    public PanelNuevoTurnoImpl(FrameNuevoTurnoImpl impl) {
        this.parent = impl;
        initComponents();
    }

    private void initComponents() {
        this.panelHorarios = new PanelNuevoTurnoHorarios(this);
        this.jTabbedPanelTurnos = new JTabbedPane();
        this.fotoCyrius = new JLabel();

        this.panelPrimerPaso = new PanelPrimerPaso(this);
        this.jpDatosPaciente = new JPanel();
        this.jpDatosPersona = new JPanel();
        this.txtNombre = new JTextField();
        this.txtApellido = new JTextField();
        this.lblNombre = new JLabel();
        this.lblApellido = new JLabel();
        this.lblDocumento = new JLabel();
        this.txtDocumento = new JTextField();
        this.lblTipo = new JLabel();
        this.cbTipo = new JComboBox();
        this.lblTelefono = new JLabel();
        this.txtTelefono = new JTextField();
        this.lblCalle = new JLabel();
        this.lblNumero = new JLabel();
        this.lblCiudad = new JLabel();
        this.lblObraSoc = new JLabel();
        this.lblDireccion = new JLabel();
        this.txtCalle = new JTextField();
        this.txtNumero = new JTextField();
        this.txtCiudad = new JTextField();
        this.jpAux = new JPanel();
        this.jpDatosOs = new JPanel();
        this.lblTitulo = new JLabel();
        this.lblNumeroAfiliado = new JLabel();
        this.txtNumeroAfiliado = new JTextField();
        this.jpBuscar = new JPanel();
        this.btnBuscar = new JButton();
        this.jpObserbaciones = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.jpConsultorio = new JPanel();
        this.jLabel1 = new JLabel();
        this.cbConsultorio = new JComboBox();
        this.btnAceptarTurnoNuevo = new JButton();
        this.btnImprimirTurnoPrepa = new JButton();
        this.btnCancelarTurnoNuevo = new JButton();
        setLayout(null);
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        this.jTabbedPanelTurnos.setBorder(
                new BevelBorder(1));
        this.jTabbedPanelTurnos
                .setTabLayoutPolicy(1);
        this.fotoCyrius.setBounds(30, 200, 300, 330);

        this.jTabbedPanelTurnos.addTab("1° paso", this.panelPrimerPaso);
        this.jTabbedPanelTurnos.addTab("Horario", this.panelHorarios);
        this.jpDatosPaciente.setLayout(null);
        this.jpDatosPaciente.setBorder(
                new SoftBevelBorder(0));
        this.jpDatosPersona.setLayout(null);
        this.jpDatosPersona.setBorder(
                new BevelBorder(0));
        this.jpDatosPersona.add(this.txtNombre);
        this.txtNombre.setBounds(90, 20, 270, 20);
        this.txtNombre.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
                PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtNombre);
            }

            public void keyTyped(KeyEvent arg0) {
            }
        });
        this.txtApellido.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
                PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtApellido);
            }

            public void keyTyped(KeyEvent arg0) {
            }
        });
        this.txtCalle.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
                PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtCalle);
            }

            public void keyTyped(KeyEvent arg0) {
            }
        });
        this.txtCiudad.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
                PanelNuevoTurnoImpl.this.keyReleasedActionPerformed(arg0, PanelNuevoTurnoImpl.this.txtCiudad);
            }

            public void keyTyped(KeyEvent arg0) {
            }
        });
        this.jpDatosPersona.add(this.txtApellido);
        this.txtApellido.setBounds(90, 40, 270, 20);
        this.lblNombre.setText("Nombre");
        this.jpDatosPersona.add(this.lblNombre);
        this.lblNombre.setBounds(10, 20, 55, 16);
        this.lblApellido.setText("Apellido");
        this.jpDatosPersona.add(this.lblApellido);
        this.lblApellido.setBounds(10, 40, 55, 16);
        this.lblDocumento.setText("Documento");
        this.jpDatosPersona.add(this.lblDocumento);
        this.lblDocumento.setBounds(10, 70, 75, 16);
        this.jpDatosPersona.add(this.txtDocumento);
        this.txtDocumento.setBounds(90, 70, 80, 20);
        this.lblTipo.setText("Tipo");
        this.jpDatosPersona.add(this.lblTipo);
        this.lblTipo.setBounds(225, 70, 30, 16);
        this.jpDatosPersona.add(this.cbTipo);
        this.cbTipo.setBounds(260, 70, 100, 20);
        this.cbTipo.setModel(
                new DefaultComboBoxModel(TipoDocumentoSearcher.findAll().toArray()));
        this.lblTelefono.setText("Telefono");
        this.jpDatosPersona.add(this.lblTelefono);
        this.lblTelefono.setBounds(80, 130, 60, 16);
        this.jpDatosPersona.add(this.txtTelefono);
        this.txtTelefono.setBounds(160, 130, 120, 20);
        this.lblCalle.setText("Calle");
        this.jpDatosPersona.add(this.lblCalle);
        this.lblCalle.setBounds(10, 180, 50, 16);
        this.lblNumero.setText("Numero y piso");
        this.jpDatosPersona.add(this.lblNumero);
        this.lblNumero.setBounds(10, 200, 95, 16);
        this.lblCiudad.setText("Ciudad");
        this.jpDatosPersona.add(this.lblCiudad);
        this.lblCiudad.setBounds(10, 220, 50, 16);
        this.lblDireccion.setText("Direccion");
        this.jpDatosPersona.add(this.lblDireccion);
        this.lblDireccion.setBounds(130, 160, 80, 16);
        this.jpDatosPersona.add(this.txtCalle);
        this.txtCalle.setBounds(120, 180, 230, 20);
        this.jpDatosPersona.add(this.txtNumero);
        this.txtNumero.setBounds(120, 200, 230, 20);
        this.jpDatosPersona.add(this.txtCiudad);
        this.txtCiudad.setBounds(120, 220, 230, 20);
        this.jpDatosPaciente.add(this.jpDatosPersona);
        this.jpDatosPersona.setBounds(20, 90, 390, 280);
        this.jpAux.setLayout(null);
        this.jpAux.setBorder(
                new BevelBorder(0));

        this.panelPrimerPaso.setBounds(450, 10, 140, 24);
        this.jpDatosPaciente.add(this.jpAux);
        this.jpAux.setBounds(10, 10, 730, 40);
        this.jpDatosOs.setLayout(null);
        this.jpDatosOs.setBorder(
                new BevelBorder(0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("   Obra Social   ");
        this.lblTitulo.setBorder(
                new BevelBorder(0));
        this.jpDatosOs.add(this.lblTitulo);
        this.lblTitulo.setBounds(20, 10, 280, 20);
        this.lblNumeroAfiliado.setText("Numero de Afiliado");
        this.jpDatosOs.add(this.lblNumeroAfiliado);
        this.lblNumeroAfiliado.setBounds(10, 90, 135, 16);
        this.jpDatosOs.add(this.txtNumeroAfiliado);
        this.txtNumeroAfiliado.setBounds(140, 90, 150, 20);

        this.jpDatosOs.add(this.lblObraSoc);
        this.lblObraSoc.setBounds(110, 50, 180, 20);
        this.jpDatosPaciente.add(this.jpDatosOs);
        this.jpDatosOs.setBounds(420, 70, 320, 140);
        this.btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PanelNuevoTurnoImpl.this.btnBuscarActionPerformed(arg0);
            }
        });
        this.btnBuscar.setText("Buscar");
        this.jpBuscar.add(this.btnBuscar);
        this.jpDatosPaciente.add(this.jpBuscar);
        this.jpBuscar.setBounds(150, 390, 130, 40);
        this.jpObserbaciones.setLayout(null);
        this.jpObserbaciones.setBorder(
                new BevelBorder(0));
        this.jScrollPane1.setBorder(
                new TitledBorder("Observaciones"));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.jpObserbaciones.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 10, 300, 140);
        this.jpDatosPaciente.add(this.jpObserbaciones);
        this.jpObserbaciones.setBounds(420, 290, 320, 160);
        this.jpConsultorio.setLayout(null);
        this.jpConsultorio.setBorder(
                new BevelBorder(0));
        this.jLabel1.setText("Consultorio");
        this.jpConsultorio.add(this.jLabel1);
        this.jLabel1.setBounds(10, 20, 75, 16);
        this.jpConsultorio.add(this.cbConsultorio);
        this.cbConsultorio.setBounds(90, 20, 210, 20);
        this.cbConsultorio.setModel(
                new DefaultComboBoxModel(new String[]{
                        "Consultorio 1", "Consultorio 2"}));
        this.jpDatosPaciente.add(this.jpConsultorio);
        this.jpConsultorio.setBounds(420, 220, 320, 60);
        this.jTabbedPanelTurnos.addTab("Datos del Paciente", this.jpDatosPaciente);
        add(this.jTabbedPanelTurnos);
        this.jTabbedPanelTurnos.setBounds(0, 0, 760, 490);
        this.btnAceptarTurnoNuevo.setText("Aceptar Turno");
        this.btnAceptarTurnoNuevo
                .addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        PanelNuevoTurnoImpl.this.btnAceptarTurnoNuevoActionPerformed(evt);
                    }
                });
        add(this.btnAceptarTurnoNuevo);
        this.btnAceptarTurnoNuevo.setBounds(630, 490, 115, 26);
        this.btnImprimirTurnoPrepa.setText("Imprimir Turno y Preparación");
        this.btnImprimirTurnoPrepa
                .addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        PanelNuevoTurnoImpl.this.btnImprimirTurnoPrepaActionPerformed(evt);
                    }
                });
        add(this.btnImprimirTurnoPrepa);
        this.btnImprimirTurnoPrepa.setBounds(100, 490, 220, 26);
        this.btnCancelarTurnoNuevo.setText("Cancelar");
        this.btnCancelarTurnoNuevo
                .addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        PanelNuevoTurnoImpl.this.btnCancelarTurnoNuevoActionPerformed(evt);
                    }
                });
        add(this.btnCancelarTurnoNuevo);
        this.btnCancelarTurnoNuevo.setBounds(390, 490, 120, 26);
        this.jTabbedPanelTurnos.setEnabledAt(2, false);
        this.jTabbedPanelTurnos.setEnabledAt(1, false);
    }

    private void btnBuscarActionPerformed(ActionEvent arg0) {
        buscar(this.txtNombre.getText().trim(), this.txtApellido.getText().trim(), this.txtDocumento.getText().trim());
    }

    private void buscar(String nombre, String apellido, String dni) {
        new JDialogTablaPersonas((short) 0, new SelectPersonaAction(), nombre,
                apellido, dni, this.parent).setVisible(true);
    }

    private void btnImprimirTurnoPrepaActionPerformed(ActionEvent evt) {
        if (this.panelHorarios.isSelected() && this.panelPrimerPaso != null && this.panelPrimerPaso.getSelectedMedico() != null) {
            GregorianCalendar hora = this.panelHorarios.getSelectedHour();

            TurnoPreparacion tp = null;
            Preparacion pre = this.panelPrimerPaso.getSelectedPractica()
                    .getPreparacion();

            if (pre == null) {
                pre = new Preparacion();
                pre.setDescripcion("Sin Preparacion..");
            }
            tp = new TurnoPreparacion(pre, hora,
                    this.panelPrimerPaso.getSelectedPractica().getDescription(),
                    this.panelPrimerPaso.getSelectedMedico().toString());

            tp.setVisible(true);
        }
    }

    private void btnAceptarTurnoNuevoActionPerformed(ActionEvent evt) {
        try {
            NotFullFormException.validateNotEmpty("falta.nombre",
                    this.txtNombre.getText());
            NotFullFormException.validateNotEmpty("falta.apellido",
                    this.txtApellido.getText());
            NotFullFormException.validateNotNull(
                    "falta.obraSocial.primer.paso",
                    this.panelPrimerPaso.getSelectedObra());
            NotFullFormException.validateNotNull("falta.medico.primer.paso",
                    this.panelPrimerPaso.getSelectedMedico());
            NotFullFormException.validateNotNull("falta.practica.primer.paso",
                    this.panelPrimerPaso.getSelectedPractica());
            NotFullFormException.validateTrue("falta.horario",
                    this.panelHorarios.isSelected());
            validarNombre(this.txtNombre.getText().trim(),
                    this.txtApellido.getText().trim());

            if (this.persona == null)
                this.persona = new Persona();
            this.persona.setNombre(this.txtNombre.getText().trim());
            this.persona.setApellido(this.txtApellido.getText().trim());

            if (!this.txtDocumento.getText().trim().equals("")) {
                this.persona
                        .setDocumento(new Integer(this.txtDocumento.getText().trim()));
            }

            if (this.cbTipo.getSelectedIndex() >= 0) {
                this.persona.setTipoDocumento((TipoDocumento)
                        this.cbTipo.getSelectedItem());
            }

            if (!this.txtTelefono.getText().trim().equals("")) {
                this.persona.setTelefono(this.txtTelefono.getText().trim());
            }

            if (!this.txtCalle.getText().trim().equals("")) {
                this.persona.setCalle(this.txtCalle.getText().trim());
            }

            if (!this.txtNumero.getText().trim().equals("")) {
                this.persona.setNumero(this.txtNumero.getText().trim());
            }

            if (!this.txtCiudad.getText().trim().equals("")) {
                this.persona.setCiudad(this.txtCiudad.getText().trim());
            }

            if (BuscadorPersona.getInstance().existByDocumento(
                    this.persona.getDocumento(), this.persona.getTipoDocumento())) ;
            NotFullFormException.validateTrue("documento.existente",
                    this.buscado);
            completeInsert(this.persona);
            getFrameParent().setVisible(false);
            setVisible(false);
        } catch (Exception e) {
            ExceptionHandler.getInstance().handle(e);
        }
    }

    private void validarNombre(String nombre, String apellido) {
        if ((!this.buscado) &&
                (BuscadorPersona.getInstance().existsByNombreApellido(nombre,
                        apellido)))
            if (JOptionPane.showConfirmDialog(null,
                    "Existen personas con nombres similares, desea continuar",
                    "Validar nombres repetidos", 0) == 1)
                throw new NotFullFormException(
                        "Se encontraron personas con nombres similares");
    }

    private void completeInsert(Persona pa) {
        PersistenceService.getInstance().save(pa);

        GregorianCalendar horario = this.panelHorarios.getSelectedHour();
        Turno turno = new Turno();
        turno.setHora(horario.getTime());
        turno.setPaciente(pa);
        turno.setMedico(this.panelPrimerPaso.getSelectedMedico());
        turno.setObservaciones(this.txtObservaciones.getText().trim());
        turno.setPractica(this.panelPrimerPaso.getSelectedPractica());
        turno.setRealizado(Boolean.FALSE);
        if (this.panelPrimerPaso.getSelectedOsindex() >= 0)
            turno.setObraSocial(this.panelPrimerPaso.getSelectedObra());
        else {
            turno.setObraSocial(null);
        }
        turno.setNroAfiliado(this.txtNumeroAfiliado.getText().trim());
        try {
            PersistenceService.getInstance().save(turno);
        } catch (Exception e) {
            ExceptionHandler.getInstance().handle(e);
        }
    }

    private void btnCancelarTurnoNuevoActionPerformed(ActionEvent evt) {
        getFrameParent().setVisible(false);
        setVisible(false);
    }

    private void keyReleasedActionPerformed(KeyEvent ev, JTextField tf) {
        if (tf.getText().length() == 1) {
            tf.setText(tf.getText().substring(0, 1).toUpperCase());
        }

        if ((tf.getText().length() > 1) && (ev.getKeyCode() != 32)) {
            StringTokenizer stk = new StringTokenizer(tf.getText(), " ");
            String text = "";

            while (stk.hasMoreTokens()) {
                String tok = stk.nextToken();
                text = text + tok.substring(0, 1).toUpperCase() +
                        tok.substring(1);

                if (stk.hasMoreTokens()) {
                    text = text + " ";
                }
            }
            tf.setText(text);
        }
    }

    public PanelNuevoTurno setSelectedIndex(int index) {
        this.jTabbedPanelTurnos.setSelectedIndex(index);

        return this;
    }

    public Medico getSelectedMedico() {
        return this.panelPrimerPaso.getSelectedMedico();
    }

    public JFrame getFrameParent() {
        return this.parent;
    }

    public PanelNuevoTurno setEnabledAt(int index, boolean value) {
        this.jTabbedPanelTurnos.setEnabledAt(index, value);

        return this;
    }

    public PanelNuevoTurno setMedico(Medico medico) {
        this.panelHorarios.setMedico(medico);
        return this;
    }

    private class SelectPersonaAction implements TablaPersonasSelectionAction {
        private SelectPersonaAction() {
        }

        public void executeAction(Persona personaSeleccionada) {
            PanelNuevoTurnoImpl.this.persona = personaSeleccionada;
            PanelNuevoTurnoImpl.this.txtNombre.setText(personaSeleccionada.getNombre());
            PanelNuevoTurnoImpl.this.txtApellido.setText(personaSeleccionada.getApellido());
            Integer documento = personaSeleccionada.getDocumento();
            PanelNuevoTurnoImpl.this.txtDocumento.setText(documento != null ? documento.toString() : "");
            PanelNuevoTurnoImpl.this.cbTipo.setSelectedItem(personaSeleccionada.getTipoDocumento());
            PanelNuevoTurnoImpl.this.txtTelefono.setText(personaSeleccionada.getTelefono());
            PanelNuevoTurnoImpl.this.txtCalle.setText(personaSeleccionada.getCalle());
            PanelNuevoTurnoImpl.this.txtNumero.setText(personaSeleccionada.getNumero());
            PanelNuevoTurnoImpl.this.txtCiudad.setText(personaSeleccionada.getCiudad());
            PanelNuevoTurnoImpl.this.buscado = true;
        }
    }
}
