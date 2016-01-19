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
/*     */ 
/*     */ public class FrameCambiarHorario extends JFrame
/*     */ {
/*     */   private ButtonGroup buttonGroup1;
/*     */   private CyriusCalendar calendario;
/*     */   private JPanel jPanel1;
/*     */   private JRadioButton rbtManana;
/*     */   private JRadioButton rbtTarde;
/*     */   private TablaVerTurnos horarios;
/*     */   private JScrollPane jScrollPaneHorarios;
/*     */   private Turno turno;
/*     */   private JButton btnCambiar;
/*     */   private VerTurnosJPanel parent;
/*     */   private Medico medico;
/*     */ 
/*     */   public FrameCambiarHorario(Turno turno, VerTurnosJPanel parent)
/*     */   {
/*  60 */     this.parent = parent;
/*  61 */     this.turno = turno;
/*  62 */     initComponents();
/*  63 */     initFrame();
/*     */     try
/*     */     {
/*  67 */       this.medico = turno.getMedico();
/*     */     } catch (Exception e) {
/*  69 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/*  74 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  75 */     int resAncho = (int)screenSize.getWidth();
/*  76 */     int resAlto = (int)screenSize.getHeight();
/*  77 */     setBounds(resAncho / 2 - 350, resAlto / 2 - 250, 700, 500);
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  81 */     this.buttonGroup1 = new ButtonGroup();
/*  82 */     this.jPanel1 = new JPanel();
/*  83 */     this.rbtManana = new JRadioButton();
/*  84 */     this.rbtTarde = new JRadioButton();
/*     */     try {
/*  86 */       this.calendario = new CyriusCalendar();
/*  87 */       NoAtiendeSelectionMode noAtiendeSelectionMode = new NoAtiendeSelectionMode(
/*  88 */         this.turno.getMedico());
/*  89 */       this.calendario.setDateSelectionModel(noAtiendeSelectionMode);
/*     */     } catch (Exception e) {
/*  91 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*  93 */     this.horarios = new TablaVerTurnos(TablaVerTurnos.MANANA);
/*  94 */     this.btnCambiar = new JButton();
/*  95 */     this.jScrollPaneHorarios = new JScrollPane();
/*  96 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  98 */         FrameCambiarHorario.this.exitForm();
/*     */       }
/*     */     });
/* 101 */     this.rbtTarde.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 103 */         FrameCambiarHorario.this.jrbTTardeActionPerformed(evt);
/*     */       }
/*     */     });
/* 106 */     this.rbtManana.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 108 */         FrameCambiarHorario.this.jrbTMananaActionPerformed(evt);
/*     */       }
/*     */     });
/* 111 */     this.rbtManana.setEnabled(false);
/* 112 */     this.rbtTarde.setEnabled(false);
/* 113 */     this.jPanel1.setLayout(null);
/* 114 */     this.rbtManana.setText("Turno Mañana");
/* 115 */     this.jPanel1.add(this.rbtManana);
/* 116 */     this.rbtManana.setBounds(510, 110, 100, 23);
/* 117 */     this.rbtTarde.setText("Turno Tarde");
/* 118 */     this.jPanel1.add(this.rbtTarde);
/* 119 */     this.rbtTarde.setBounds(510, 150, 85, 23);
/* 120 */     //TODO: this.calendario.setDisplayToday(false);
/* 121 */     this.calendario.setWeekNumbersVisible(false);
/* 122 */     this.jPanel1.add(this.calendario);
/* 123 */     this.calendario.setBounds(470, 220, 200, 148);
/* 124 */     this.jScrollPaneHorarios.setVisible(false);
/* 125 */     this.jPanel1.add(this.jScrollPaneHorarios);
/* 126 */     this.jScrollPaneHorarios.setBounds(0, 0, 460, 460);
/* 127 */     getContentPane().add(this.jPanel1, "Center");
/* 128 */     this.buttonGroup1.add(this.rbtManana);
/* 129 */     this.buttonGroup1.add(this.rbtTarde);
/* 130 */     this.calendario
/* 131 */       .addDateSelectionListener(new DateSelectionListener()
/*     */     {
/*     */       public void disabledDatesChanged(DateSelectionEvent evt)
/*     */       {
/*     */       }


/*     */       public void dateSelectionChanged(DateSelectionEvent evt) {
/*     */         try {
/* 139 */           FrameCambiarHorario.this.calendarioDateSelectionChanged(evt);
/*     */         } catch (Exception e) {
/* 141 */           ExceptionHandler.getInstance().handle(e);
/*     */         }
/*     */       }
/*     */ 
/*     */       public void selectionModeChanged(DateSelectionEvent evt)
/*     */       {
/*     */       }
/*     */
    });
/* 149 */     this.calendario.getDateSelectionModel().setSelectionMode(
/* 150 */       DateSelectionModel.SelectionMode.SINGLE);
/* 151 */     this.btnCambiar.setText("Cambiar");
/* 152 */     this.btnCambiar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 154 */         FrameCambiarHorario.this.btnCambiarActionPerformed();
/*     */       }
/*     */     });
/* 157 */     //TODO this.calendario.setDisplayToday(false);
/* 158 */     this.calendario.setWeekNumbersVisible(false);
/* 159 */     this.jPanel1.add(this.btnCambiar);
/* 160 */     this.btnCambiar.setBounds(520, 400, 90, 35);
/* 161 */     this.horarios.addMouseListener(new MouseListener() {
/*     */       public void mouseClicked(MouseEvent arg0) {
/* 163 */         if (arg0.getClickCount() == 2)
/* 164 */           FrameCambiarHorario.this.btnCambiarActionPerformed();
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseExited(MouseEvent arg0)
/*     */       {
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
/* 180 */     setResizable(false);
/* 181 */     pack();
/*     */   }
/*     */ 
/*     */   private void jrbTTardeActionPerformed(ActionEvent evt) {
/*     */     try {
/* 186 */       this.jScrollPaneHorarios.setVisible(true);
/* 187 */       GregorianCalendar fecha = new GregorianCalendar();
/* 188 */       fecha.setTimeInMillis(
/* 189 */         this.calendario.getDateSelectionModel().getLeadSelectionDate().getTime());
/* 190 */       this.horarios.setMedico(this.turno.getMedico());
/* 191 */       fecha.set(11, 15);
/* 192 */       this.horarios.setDay(fecha);
/* 193 */       this.horarios.setEstado(TablaVerTurnos.TARDE);
/* 194 */       this.jScrollPaneHorarios.setViewportView(this.horarios);
/*     */     } catch (Exception e) {
/* 196 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jrbTMananaActionPerformed(ActionEvent evt) {
/*     */     try {
/* 202 */       this.jScrollPaneHorarios.setVisible(true);
/* 203 */       GregorianCalendar fecha = new GregorianCalendar();
/* 204 */       fecha.setTime(
/* 205 */         this.calendario.getDateSelectionModel().getLeadSelectionDate());
/* 206 */       this.horarios.setMedico(this.turno.getMedico());
/* 207 */       fecha.set(11, 8);
/* 208 */       this.horarios.setDay(fecha);
/* 209 */       this.horarios.setEstado(TablaVerTurnos.MANANA);
/* 210 */       this.jScrollPaneHorarios.setViewportView(this.horarios);
/*     */     } catch (Exception e) {
/* 212 */       ExceptionHandler.getInstance().handle(this, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void calendarioDateSelectionChanged(DateSelectionEvent evt) throws SQLException
/*     */   {
/* 218 */     this.horarios.setDay((Calendar)this.calendario.getValor());
/* 219 */     if (this.medico.getAtiendeDeManana((Calendar)this.calendario.getValor())) {
/* 220 */       this.rbtManana.setEnabled(true);
/* 221 */       this.rbtManana.doClick();
/*     */     } else {
/* 223 */       this.rbtManana.setEnabled(false);
/*     */     }
/* 225 */     if (this.medico.getAtiendeDeTarde((Calendar)this.calendario.getValor())) {
/* 226 */       this.horarios.setDay((Calendar)this.calendario.getValor());
/* 227 */       this.rbtTarde.setEnabled(true);
/* 228 */       if (!this.medico.getAtiendeDeManana((Calendar)this.calendario.getValor()))
/* 229 */         this.rbtTarde.doClick();
/*     */     } else {
/* 231 */       this.rbtTarde.setEnabled(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnCambiarActionPerformed()
/*     */   {
/* 237 */     Vector v = (Vector)this.horarios.getSelectedHours();
/* 238 */     Iterator it = v.iterator();
/*     */ 
/* 240 */     while (it.hasNext()) {
/* 241 */       this.turno.setHora(((Calendar)it.next()).getTime());
/*     */       try {
/* 243 */         PersistenceService.getInstance().save(this.turno);
/*     */       } catch (Exception e) {
/* 245 */         ExceptionHandler.getInstance().handle(e);
/*     */       }
/*     */     }
/* 248 */     exitForm();
/*     */   }
/*     */ 
/*     */   private void exitForm() {
/* 252 */     this.parent.refresh();
/*     */ 
/* 254 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.FrameCambiarHorario
 * JD-Core Version:    0.6.0
 */