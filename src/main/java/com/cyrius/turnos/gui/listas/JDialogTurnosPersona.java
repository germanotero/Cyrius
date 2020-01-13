package com.cyrius.turnos.gui.listas;

import com.cyrius.entities.Persona;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorPersona;
import com.cyrius.searchers.BuscadorTurnos;
import com.google.api.client.util.Lists;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class JDialogTurnosPersona extends JDialog {
    private static final String[] COLUMNS = new String[]{ "Fecha", "Médico", "O.S.", "Asistió?", "Observaciones"};
    private static final String DATE_PATTERN = "dd-MM-yyyy HH:mm";
    public static short TRAER = 0;
    public static short VER = 1;
    private short estado;
    private JPanel PanelGral;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private TablaTurnosPersonaAction action;

    public JDialogTurnosPersona(short estado, TablaTurnosPersonaAction action, Persona persona,
                                JFrame frame) {
        super(frame);
        this.action = action;
        this.estado = estado;
        initComponents(persona);
        initFrame(persona);
    }

    private void initFrame(Persona persona) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int resAncho = (int) screenSize.getWidth();
        int resAlto = (int) screenSize.getHeight();
        setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 765, 556);
        setTitle(String.format("Turnos De %s %s", persona.getNombre(), persona.getApellido()));
    }

    private Object[][] getMatrix(Persona pac) {
        Collection<Turno> v = BuscadorTurnos.getInstance().findByPaciente(pac);

        Object[][] mat = new Object[v.size()][COLUMNS.length + 1];
        int i = 0;

        for (Turno turno: v) {
            mat[i][0] = DateFormatUtils.format(turno.getHora(), DATE_PATTERN);
            mat[i][1] = turno.getMedico();
            mat[i][2] = turno.getObraSocial().getCodigo();
            mat[i][3] = turno.getAsistio();
            mat[i][4] = turno.getObservaciones();
            i++;
        }

        return mat;
    }

    private void initComponents(Persona persona) {
        this.PanelGral = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                JDialogTurnosPersona.this.exitForm(evt);
            }
        });
        this.PanelGral.setLayout(new BorderLayout());
        this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.jTable1.setModel(
                new DefaultTableModel(getMatrix(persona), COLUMNS) {
                    boolean[] canEdit = new boolean[6];
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return this.canEdit[columnIndex];
                    }
                });
        this.jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
        this.jTable1.getColumnModel().getColumn(3).setMaxWidth(45);
        this.jTable1.getColumnModel().setColumnMargin(10);
        this.jTable1.setLayout(null);
        this.jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                JDialogTurnosPersona.this.mouseDoubleClick(arg0);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        this.PanelGral.add(this.jScrollPane1);
        getContentPane().add(this.PanelGral);
        pack();
    }

    private void mouseDoubleClick(MouseEvent arg0) {
        if ((this.estado == TRAER) &&
                (arg0.getClickCount() == 2)) {
            this.action.executeAction(
                    (Persona) this.jTable1
                            .getValueAt(this.jTable1.getSelectedRow(), 0));
            setVisible(false);
            this.jTable1.clearSelection();
        }
    }

    private void exitForm(WindowEvent evt) {
        setVisible(false);
    }
}




