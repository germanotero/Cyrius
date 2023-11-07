/*     */
package com.cyrius.ui;

/*     */
/*     */ import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;


import org.apache.log4j.xml.DOMConfigurator;

import com.cyrius.informes.ui.uc.MainInformesUseCase;
import com.cyrius.turnos.gui.verTurno.TurnosFrame;
import com.cyrius.ui.errores.ErrorResolucion;
import com.framework.abstractfactorys.FrameworkUseCaseFactory;
import com.framework.exceptions.ExceptionHandler;
import com.framework.utils.Constants;
import com.incors.plaf.kunststoff.KunststoffLookAndFeel;

public class Gui extends JWindow {
  private JButton btnInformes;
  private JButton btnSalir;
  private JButton btnTurnos;
  private JButton btnOpciones;
  private boolean btnApretado;

  public Gui() {
    initComponents();
    applySkin();
  }

  private void applySkin() {
    try {
      UIManager.setLookAndFeel(new KunststoffLookAndFeel());
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
    SwingUtilities.updateComponentTreeUI(this);
    pack();
  }

  private void initComponents() {
    JLabel realizado = new JLabel();
    JLabel licencia = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLblTitle = new JLabel();
    JLabel jLabel1 = new JLabel();

    this.btnTurnos = new JButton();
    this.btnInformes = new JButton();
    this.btnSalir = new JButton();
    this.btnOpciones = new JButton("Opciones.");
    Container contentPane = getContentPane();
    contentPane.setLayout(null);

    this.btnTurnos.setFont(new Font("Times New Roman", 1, 12));
    this.btnTurnos.setText("Turnos");
    this.btnTurnos.setBorder(new BevelBorder(0));
    this.btnTurnos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Gui.this.btnTurnosActionPerformed(evt);
      }
    });
    contentPane.add(this.btnTurnos);
    this.btnTurnos.setBounds(320, 250, 90, 18);
    this.btnInformes.setFont(new Font("Times New Roman", 1, 12));
    this.btnInformes.setText("Informes");
    this.btnInformes.setBorder(new BevelBorder(0));
    contentPane.add(this.btnInformes);
    this.btnInformes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Gui.this.btnInformesActionPerformed(evt);
      }
    });
    this.btnInformes.setBounds(320, 230, 90, 18);
    this.btnSalir.setText("Salir");
    this.btnSalir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Gui.this.btnSalirActionPerformed(evt);
      }
    });
    contentPane.add(this.btnSalir);
    this.btnSalir.setBounds(360, 310, 80, 20);
    this.btnOpciones.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Gui.this.btnOpcionesActionPerformed(evt);
      }
    });
    contentPane.add(this.btnOpciones);
    this.btnOpciones.setBounds(3, 315, 75, 13);
    this.btnOpciones.setFont(Constants.FONTPRINT);
    this.btnOpciones.setVisible(false);
    realizado.setFont(new Font("Dialog", 1, 10));
    realizado.setForeground(new Color(255, 255, 255));
    realizado.setText("Realizado por German Otero.");
    contentPane.add(realizado);
    realizado.setBounds(70, 290, 150, 10);
    licencia.setFont(new Font("Dialog", 0, 10));
    licencia.setForeground(new Color(255, 255, 255));
    licencia.setText("Licenciado para Dra. Nilda Sanchez. C.E.N.S.");
    contentPane.add(licencia);
    licencia.setBounds(110, 310, 230, 20);
    jLabel2.setIcon(new ImageIcon("Img/java.gif"));
    contentPane.add(jLabel2);
    jLabel2.setBounds(20, 250, 50, 60);
    jLblTitle.setIcon(new ImageIcon("Img/cyrius.gif"));
    contentPane.add(jLblTitle);
    jLblTitle.setBounds(295, -20, 230, 100);
    jLabel1.setFont(new Font("Dialog", 1, 48));
    jLabel1.setIcon(new ImageIcon("Img/fondo5.gif"));
    contentPane.add(jLabel1);
    jLabel1.setBounds(0, -10, 450, 350);

    postInit();
    pack();
  }

  private void postInit() {
    this.btnOpciones.setVisible(true);
  }

  private void btnSalirActionPerformed(ActionEvent evt) {
    System.exit(0);
  }

  private void btnInformesActionPerformed(ActionEvent evt) {
    if (!this.btnApretado)
      try {
        setWaitState();
        MainInformesUseCase uc = (MainInformesUseCase) FrameworkUseCaseFactory.createUseCase(MainInformesUseCase.class);
        uc.getInternalWindow().setDefaultCloseOperation(3);
        FrameworkUseCaseFactory.launchUseCase(uc);
        setVisible(false);
      } catch (Throwable e) {
        ExceptionHandler.getInstance().handle(e);
      } finally {
        setDefaultState();
      }
  }

  private void btnTurnosActionPerformed(ActionEvent evt) {
    if (!this.btnApretado)
      try {
        setWaitState();

        TurnosFrame turnos = new TurnosFrame(this);
        turnos.setResizable(false);
        turnos.setVisible(true);
        setVisible(false);
      } catch (Throwable e) {
        ExceptionHandler.getInstance().handle(e);
      } finally {
        setDefaultState();
      }
  }

  private void setWaitState() {
    this.btnApretado = true;
    setCursor(new Cursor(3));
  }

  private void setDefaultState() {
    setCursor(new Cursor(0));
  }

  private void btnOpcionesActionPerformed(ActionEvent evt) {
    OpcionesJDialog opt = new OpcionesJDialog();
    opt.setVisible(true);
  }

  public static void main(String[] args) throws FileNotFoundException {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    DOMConfigurator.configure("config/log4j.xml");

    int resAncho = (int) screenSize.getWidth();
    int resAlto = (int) screenSize.getHeight();

    if ((resAncho < 800) && (resAlto < 600)) {
      ErrorResolucion noRes = new ErrorResolucion();
      noRes.setBounds(resAncho / 2 - 200, resAlto / 2 - 100, 400, 200);
      noRes.setVisible(true);
    } else {
      Gui pantallaInicio = new Gui();
      pantallaInicio.setBounds(resAncho / 2 - 220, resAlto / 2 - 166, 442, 332);
      pantallaInicio.setVisible(true);
    }
  }
}
