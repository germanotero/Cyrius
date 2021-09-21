package com.cyrius.turnos.gui.nuevoTurno;

import com.cyrius.entities.Preparacion;
import com.cyrius.utils.prints.PrintUtilities;
import com.framework.utils.Constants;
import com.framework.utils.KeyCodes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class TurnoPreparacion extends JFrame {
    private JPanel panel;
    private JTextPane jtMensaje;
    private JButton btnPrint;
    private JLabel maxCaracter;
    private int i = 700;
    private JScrollPane jScroll;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel labelMedico;
    private JLabel labelDescripcionLinea2;
    private JLabel labelDescripcionLinea3;

    private final Preparacion preparacion;
    private final String nombre;
    private final GregorianCalendar hora;
    private final String medico;

    public TurnoPreparacion(Preparacion preparacion, GregorianCalendar hora, String nombrePractica, String medico) {
        this.nombre = nombrePractica;
        this.medico = medico;
        this.preparacion = preparacion;
        this.hora = new GregorianCalendar();
        this.hora.setTimeInMillis(hora.getTimeInMillis());
        initComponents();
        initFrame();
    }

    private void initFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int resAncho = (int) screenSize.getWidth();
        int resAlto = (int) screenSize.getHeight();
        setBounds(resAncho / 2 - 225, resAlto / 2 - 135, 500, 320);
    }

    private void initComponents() {
        this.jtMensaje = new JTextPane();
        this.maxCaracter = new JLabel("");
        this.jScroll = new JScrollPane();
        this.jScroll.setViewportView(this.jtMensaje);
        this.panel = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel4 = new JLabel();
        this.labelMedico = new JLabel();
        this.labelDescripcionLinea2 = new JLabel();
        this.labelDescripcionLinea3 = new JLabel();
        this.btnPrint = new JButton("Imprimir.");
        this.panel.setLayout(null);
        this.panel.add(this.btnPrint);
        this.panel.add(this.maxCaracter);
        this.maxCaracter.setBounds(250, 135, 200, 16);
        this.jtMensaje.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                TurnoPreparacion.this.jtMensajeKeyReleased(e);
            }

            public void keyTyped(KeyEvent e) {
                TurnoPreparacion.this.jtMensajekeyTyped(e);
            }
        });
        this.btnPrint.setBounds(80, 250, 100, 20);
        this.btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TurnoPreparacion.this.jtMensaje.setCaretPosition(0);
                TurnoPreparacion.this.btnPrint(arg0);
            }
        });
        this.jLabel2.setFont(Constants.FONTPRINT);
        this.jLabel4.setFont(Constants.FONTLEYENDA);
        this.labelMedico.setFont(Constants.FONTPRINT);
        this.labelDescripcionLinea2.setFont(Constants.FONTLEYENDA);
        this.labelDescripcionLinea3.setFont(Constants.FONTLEYENDA);

        this.panel.setBackground(new Color(255, 255, 255));
        this.jScroll.setBorder(
                new TitledBorder("Preparacion para: " + this.nombre));
        this.jtMensaje.setText(this.preparacion.getDescripcion());
        this.panel.add(this.jScroll);
        this.jScroll
                .setVerticalScrollBarPolicy(21);
        this.jScroll.setBounds(26, 20, 400, 110);
        this.jtMensaje.setText(this.preparacion.getDescripcion());
        String minutos = "" + this.hora.get(12);
        if (this.hora.get(12) == 0) {
            minutos = minutos + "0";
        }
        String dia = null;

        switch (this.hora.get(7)) {
            case 2:
                dia = "Lunes";
                break;
            case 3:
                dia = "Martes";
                break;
            case 4:
                dia = "Miercoles";
                break;
            case 5:
                dia = "Jueves";
                break;
            case 6:
                dia = "Viernes";
                break;
            default:
                dia = "";
        }
        this.jLabel2.setText("Turno Para el " + dia + " " + this.hora.get(5) +
                "/" + (this.hora.get(2) + 1) + " a las " +
                this.hora.get(11) + ":" + minutos);
        this.panel.add(this.jLabel2);
        this.jLabel2.setBounds(30, 135, 360, 16);
        this.labelMedico.setText("Su doctora: " + this.medico);
        this.panel.add(this.labelMedico);
        this.labelMedico.setBounds(30, 150, 360, 16);
        this.jLabel4.setText("C.E.N.S. Consultorio de Ecografías de alta Complejidad. ");
        this.panel.add(this.jLabel4);
        this.jLabel4.setBounds(30, 180, 360, 10);
        this.labelDescripcionLinea2.setText("Lavalle 1032 - Quilmes - 1878 - Tel: 4253-4687");
        this.panel.add(this.labelDescripcionLinea2);
        this.labelDescripcionLinea2.setBounds(30, 195, 360, 10);
        this.labelDescripcionLinea3.setText("Whatsapp: 15 2 570 7596 - email: censquilmes@gmail.com");
        this.panel.add(this.labelDescripcionLinea3);
        this.labelDescripcionLinea3.setBounds(30, 210, 360, 10);
        getContentPane().add(this.panel);
        this.panel.doLayout();
        pack();
    }

    private void jtMensajeKeyReleased(KeyEvent e) {
        String text = this.jtMensaje.getText().trim();
        if (e.getKeyCode() == KeyCodes.ENTER) {
            this.jtMensaje.setText(text.substring(0, text.length()));
        }
        this.i = (700 - text.length());
        if (this.i == 0) {
            this.jtMensaje.setText(text);
        }
        this.maxCaracter.setText("Caracteres Restantes: " + this.i);
    }

    private void jtMensajekeyTyped(KeyEvent e) {
        String text = this.jtMensaje.getText().trim();
        if (e.getKeyCode() == KeyCodes.ENTER)
            this.jtMensaje.setText(text.substring(0, text.length()));
    }

    private void btnPrint(ActionEvent arg0) {
        this.maxCaracter.setVisible(false);
        this.jtMensaje.setFont(Constants.FONTPRINTTEXT);
        this.btnPrint.setVisible(false);
        print(this.panel);
        setVisible(false);
    }

    private void print(Component comp) {
        PrintUtilities.printComponent(comp);
    }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.nuevoTurno.TurnoPreparacion
 * JD-Core Version:    0.6.0
 */