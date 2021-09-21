package com.cyrius.turnos.gui.verTurno;

import com.cyrius.entities.Persona;
import com.cyrius.searchers.BuscadorPersona;
import com.cyrius.turnos.gui.listas.JDialogTablaPersonas;
import com.cyrius.turnos.gui.listas.JDialogTurnosPersona;
import com.cyrius.turnos.gui.listas.TablaPersonasSelectionAction;
import com.cyrius.turnos.gui.listas.TablaTurnosPersonaAction;
import com.cyrius.turnos.gui.verTurno.old.PanelNuevoTurnoImpl;
import com.framework.utils.KeyCodes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Collection;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class jDialogBuscarPersona extends JDialog {
    private JButton btnBuscar;
    private JLabel lblTitulo;
    private JLabel lblApellido;
    private JLabel lblNombre;
    private JLabel lblDni;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JTextField txtDni;
    private JFrame parent;

    public jDialogBuscarPersona(JFrame parent) {
        super(parent, true);
        this.parent = parent;
        initGUI();
    }

    public void initGUI() {
        try {
            preInitGUI();

            this.txtNombre = new JTextField();
            this.txtApellido = new JTextField();
            this.txtDni = new JTextField();
            this.lblNombre = new JLabel();
            this.lblApellido = new JLabel();
            this.lblTitulo = new JLabel();
            this.lblDni = new JLabel();
            this.btnBuscar = new JButton();

            GridBagLayout thisLayout = new GridBagLayout();
            getContentPane().setLayout(thisLayout);
            thisLayout.columnWidths = new int[]{1, 1, 1, 1, 1};
            thisLayout.rowHeights = new int[]{1, 1, 1, 1};
            thisLayout.columnWeights = new double[]{0.1D, 0.1D, 0.1D, 0.1D, 0.1D};
            thisLayout.rowWeights = new double[]{0.1D, 0.1D, 0.1D, 0.1D};
            setSize(new Dimension(338, 191));
            int y = 1;

            buildLabel(y, this.lblNombre, "Nombre:", this.txtNombre, new KeyAdapter() {
                public void keyReleased(KeyEvent evt) {
                    jDialogBuscarPersona.this.txtNombreKeyReleased(evt);
                }
            });
            y++;
            buildLabel(y, this.lblApellido, "Apellido:", this.txtApellido, new KeyAdapter() {
                public void keyReleased(KeyEvent evt) {
                    jDialogBuscarPersona.this.txtApellidoKeyReleased(evt);

                }
            });

            y++;
            buildLabel(y, this.lblDni, "Dni:", this.txtDni, new KeyAdapter() {
                public void keyReleased(KeyEvent evt) {
                    jDialogBuscarPersona.this.txtDniReleased(evt);

                }
            });

            this.lblTitulo.setText("Ingrese Nombre/Apellido");
            getContentPane().add(
                    this.lblTitulo,
                    new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 0,
                            new Insets(0, 0, 0, 0), 0, 0));

            this.btnBuscar.setText("Buscar");
            getContentPane().add(
                    this.btnBuscar,
                    new GridBagConstraints(1, 4, 1, 1, 0.0D, 0.0D, 10, 0,
                            new Insets(0, 0, 0, 0), 0, 0));
            this.btnBuscar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jDialogBuscarPersona.this.btnBuscarActionPerformed(evt);
                }
            });
            postInitGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildLabel(int y, JLabel label, String labelText, JTextField textField, KeyListener keyListener) {
        label.setText(labelText);
        getContentPane().add(
                label,
                new GridBagConstraints(0, y, 1, 1, 0.0D, 0.0D, 10, 0,
                        new Insets(0, 0, 0, 0), 0, 0));
        textField.setPreferredSize(new Dimension(100, 20));
        getContentPane().add(
                textField,
                new GridBagConstraints(1, y, 1, 1, 0.0D, 0.0D, 10, 0,
                        new Insets(0, 0, 0, 0), 0, 0));
        textField.addKeyListener(keyListener);
    }

    public void preInitGUI() {
    }

    public void postInitGUI() {
        initFrame();
    }

    private void initFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int resAncho = (int) screenSize.getWidth();
        int resAlto = (int) screenSize.getHeight();
        setBounds(resAncho / 2 - 165, resAlto / 2 - 82, 331, 164);
        setTitle("Nuevo Turno");
    }

    protected void btnBuscarActionPerformed(ActionEvent evt) {
        String nombre = this.txtNombre.getText().trim();
        String apellido = this.txtApellido.getText().trim();
        String dni = this.txtDni.getText().trim();
        final JFrame parent = this.parent;
        JDialogTablaPersonas dialog = new JDialogTablaPersonas((short) 0, new TablaPersonasSelectionAction(){
            public void executeAction(Persona paramPersona) {
                new JDialogTurnosPersona((short) 0, new TablaTurnosPersonaAction(){
                    public void executeAction(Persona paramPersona) {

                    }
                }, paramPersona, parent).setVisible(true);
            }
        }, nombre, apellido, dni, parent);

        dialog.setVisible(true);
        setVisible(false);

    }

    protected void txtApellidoKeyReleased(KeyEvent evt) {
        keyReleasedActionPerformed(evt, this.txtApellido);

        if (evt.getKeyCode() == KeyCodes.ENTER)
            this.txtApellido.transferFocus();
    }

    protected void txtDniReleased(KeyEvent evt) {
        keyReleasedActionPerformed(evt, this.txtDni);

        if (evt.getKeyCode() == KeyCodes.ENTER)
            this.txtDni.transferFocus();
    }

    protected void txtNombreKeyReleased(KeyEvent evt) {
        keyReleasedActionPerformed(evt, this.txtNombre);

        if (evt.getKeyCode() == KeyCodes.ENTER)
            this.txtNombre.transferFocus();
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
}