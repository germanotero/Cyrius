package com.cyrius.turnos.gui.listas;

import com.cyrius.entities.Persona;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorPersona;
import com.cyrius.searchers.BuscadorTurnos;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class JDialogTurnosPersona extends JDialog {
    public static short TRAER = 0;

    public static short VER = 1;

    private int lengthName = 0;
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
        Collection v = BuscadorTurnos.getInstance().findByPaciente(pac);

        Object[][] mat = new Object[v.size()][6];
        Iterator it = v.iterator();
        int i = 0;

        while (it.hasNext()) {
            Turno turno = (Turno) it.next();
            mat[i][0] = pac;
            mat[i][1] = DateFormatUtils.format(turno.getHora(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());
            mat[i][2] = turno.getMedico();
            mat[i][3] = turno.getObraSocial().getCodigo();
            mat[i][4] = turno.getAsistio();
            mat[i][5] = turno.getObservaciones();

            if (pac.toString().length() > this.lengthName) {
                this.lengthName = pac.toString().length();
            }

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

        this.jTable1.setModel(
                new DefaultTableModel(getMatrix(persona), new String[]{"Nombre",
                        "fecha", "Medico", "Cod Obra", "Asistió?", "Observaciones"}) {
                    boolean[] canEdit = new boolean[6];

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return this.canEdit[columnIndex];
                    }
                });
        this.jTable1.getColumnModel().getColumn(0).setMaxWidth(this.lengthName * 15);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(this.lengthName * 8);
        this.jTable1.getColumnModel().getColumn(0).setMinWidth(this.lengthName * 7);
        this.jTable1.getColumnModel().setColumnMargin(10);
        this.jTable1.setLayout(null);
        this.jTable1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0) {
                JDialogTurnosPersona.this.mouseDoubleClick(arg0);
            }

            public void mouseEntered(MouseEvent arg0) {
            }

            public void mouseExited(MouseEvent arg0) {
            }

            public void mousePressed(MouseEvent arg0) {
            }

            public void mouseReleased(MouseEvent arg0) {
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




