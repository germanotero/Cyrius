/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.cyrius.entities.Medico;
import com.cyrius.entities.Turno;
import com.cyrius.ui.components.CyriusCalendar;
import com.cyrius.ui.components.NoAtiendeSelectionMode;
import com.cyrius.ui.components.TablaVerTurnos;
import com.framework.exceptions.ExceptionHandler;
import com.framework.persistence.PersistenceService;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.event.DateSelectionEvent;
import com.standbysoft.datepicker.event.DateSelectionListener;
 
 public class FrameCambiarHorario extends JFrame
 {
   private ButtonGroup buttonGroup1;
   private CyriusCalendar calendario;
   private JPanel jPanel1;
   private JRadioButton rbtManana;
   private JRadioButton rbtTarde;
   private TablaVerTurnos horarios;
   private JScrollPane jScrollPaneHorarios;
   private Turno turno;
   private JButton btnCambiar;
   private VerTurnosJPanel parent;
   private Medico medico;
 
   public FrameCambiarHorario(Turno turno, VerTurnosJPanel parent)
   {
     this.parent = parent;
     this.turno = turno;
     initComponents();
     initFrame();
     try
     {
       this.medico = turno.getMedico();
     } catch (Exception e) {
       ExceptionHandler.getInstance().handle(e);
     }
   }
 
   private void initFrame() {
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     int resAncho = (int)screenSize.getWidth();
     int resAlto = (int)screenSize.getHeight();
     setBounds(resAncho / 2 - 350, resAlto / 2 - 250, 700, 500);
   }
 
   private void initComponents() {
     this.buttonGroup1 = new ButtonGroup();
     this.jPanel1 = new JPanel();
     this.rbtManana = new JRadioButton();
     this.rbtTarde = new JRadioButton();
     try {
       this.calendario = new CyriusCalendar();
       NoAtiendeSelectionMode noAtiendeSelectionMode = new NoAtiendeSelectionMode(
         this.turno.getMedico());
       this.calendario.setDateSelectionModel(noAtiendeSelectionMode);
     } catch (Exception e) {
       ExceptionHandler.getInstance().handle(this, e);
     }
     this.horarios = new TablaVerTurnos(TablaVerTurnos.MANANA);
     this.btnCambiar = new JButton();
     this.jScrollPaneHorarios = new JScrollPane();
     addWindowListener(new WindowAdapter() {
       public void windowClosing(WindowEvent evt) {
         FrameCambiarHorario.this.exitForm();
       }
     });
     this.rbtTarde.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         FrameCambiarHorario.this.jrbTTardeActionPerformed(evt);
       }
     });
     this.rbtManana.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         FrameCambiarHorario.this.jrbTMananaActionPerformed(evt);
       }
     });
     this.rbtManana.setEnabled(false);
     this.rbtTarde.setEnabled(false);
     this.jPanel1.setLayout(null);
     this.rbtManana.setText("Turno Mañana");
     this.jPanel1.add(this.rbtManana);
     this.rbtManana.setBounds(510, 110, 100, 23);
     this.rbtTarde.setText("Turno Tarde");
     this.jPanel1.add(this.rbtTarde);
     this.rbtTarde.setBounds(510, 150, 85, 23);
     //TODO: this.calendario.setDisplayToday(false);
     this.calendario.setWeekNumbersVisible(false);
     this.jPanel1.add(this.calendario);
     this.calendario.setBounds(470, 220, 200, 148);
     this.jScrollPaneHorarios.setVisible(false);
     this.jPanel1.add(this.jScrollPaneHorarios);
     this.jScrollPaneHorarios.setBounds(0, 0, 460, 460);
     getContentPane().add(this.jPanel1, "Center");
     this.buttonGroup1.add(this.rbtManana);
     this.buttonGroup1.add(this.rbtTarde);
     this.calendario
       .addDateSelectionListener(new DateSelectionListener()
     {
       public void disabledDatesChanged(DateSelectionEvent evt)
       {
       }
       public void dateSelectionChanged(DateSelectionEvent evt) {
         try {
           FrameCambiarHorario.this.calendarioDateSelectionChanged(evt);
         } catch (Exception e) {
           ExceptionHandler.getInstance().handle(e);
         }
       }
 
       public void selectionModeChanged(DateSelectionEvent evt)
       {
       }

    });
    this.calendario.getDateSelectionModel().setSelectionMode(
      DateSelectionModel.SelectionMode.SINGLE);
    this.btnCambiar.setText("Cambiar");
    this.btnCambiar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        FrameCambiarHorario.this.btnCambiarActionPerformed();
      }
    });
    //TODO this.calendario.setDisplayToday(false);
    this.calendario.setWeekNumbersVisible(false);
    this.jPanel1.add(this.btnCambiar);
    this.btnCambiar.setBounds(520, 400, 90, 35);
    this.horarios.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent arg0) {
        if (arg0.getClickCount() == 2)
          FrameCambiarHorario.this.btnCambiarActionPerformed();
      }

      public void mouseEntered(MouseEvent arg0)
      {
      }

      public void mouseExited(MouseEvent arg0)
      {
      }

      public void mousePressed(MouseEvent arg0)
      {
      }

      public void mouseReleased(MouseEvent arg0)
      {
      }
    });
    setResizable(false);
    pack();
  }

  private void jrbTTardeActionPerformed(ActionEvent evt) {
    try {
      this.jScrollPaneHorarios.setVisible(true);
      GregorianCalendar fecha = new GregorianCalendar();
      fecha.setTimeInMillis(
        this.calendario.getDateSelectionModel().getLeadSelectionDate().getTime());
      this.horarios.setMedico(this.turno.getMedico());
      fecha.set(11, 15);
      this.horarios.setDay(fecha);
      this.horarios.setEstado(TablaVerTurnos.TARDE);
      this.jScrollPaneHorarios.setViewportView(this.horarios);
    } catch (Exception e) {
      ExceptionHandler.getInstance().handle(this, e);
    }
  }

  private void jrbTMananaActionPerformed(ActionEvent evt) {
    try {
      this.jScrollPaneHorarios.setVisible(true);
      GregorianCalendar fecha = new GregorianCalendar();
      fecha.setTime(
        this.calendario.getDateSelectionModel().getLeadSelectionDate());
      this.horarios.setMedico(this.turno.getMedico());
      fecha.set(11, 8);
      this.horarios.setDay(fecha);
      this.horarios.setEstado(TablaVerTurnos.MANANA);
      this.jScrollPaneHorarios.setViewportView(this.horarios);
    } catch (Exception e) {
      ExceptionHandler.getInstance().handle(this, e);
    }
  }

  private void calendarioDateSelectionChanged(DateSelectionEvent evt) throws SQLException
  {
    this.horarios.setDay((Calendar)this.calendario.getValor());
    if (this.medico.getAtiendeDeManana((Calendar)this.calendario.getValor())) {
      this.rbtManana.setEnabled(true);
      this.rbtManana.doClick();
    } else {
      this.rbtManana.setEnabled(false);
    }
    if (this.medico.getAtiendeDeTarde((Calendar)this.calendario.getValor())) {
      this.horarios.setDay((Calendar)this.calendario.getValor());
      this.rbtTarde.setEnabled(true);
      if (!this.medico.getAtiendeDeManana((Calendar)this.calendario.getValor()))
        this.rbtTarde.doClick();
    } else {
      this.rbtTarde.setEnabled(false);
    }
  }

  private void btnCambiarActionPerformed()
  {
    Vector v = (Vector)this.horarios.getSelectedHours();
    Iterator it = v.iterator();

    while (it.hasNext()) {
      this.turno.setHora(((Calendar)it.next()).getTime());
      try {
        PersistenceService.getInstance().save(this.turno);
      } catch (Exception e) {
        ExceptionHandler.getInstance().handle(e);
      }
    }
    exitForm();
  }

  private void exitForm() {
    this.parent.refresh();

    setVisible(false);
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.FrameCambiarHorario
 * JD-Core Version:    0.6.0
 */