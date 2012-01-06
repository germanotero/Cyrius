/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.cyrius.entities.Medico;
import com.cyrius.ui.components.CyriusCalendar;
import com.cyrius.ui.components.NoAtiendeSelectionMode;
import com.standbysoft.datepicker.event.DateSelectionEvent;
import com.standbysoft.datepicker.event.DateSelectionListener;
/*     */ 
/*     */ public class PanelNuevoTurnoHorarios extends JPanel
/*     */ {
/*     */   private ButtonGroup buttonGroup1;
/*     */   private JButton btnSiguienteHorario;
/*     */   private CyriusCalendar calendar;
/*     */   private JScrollPane jScrollPaneHorarios;
/*     */   private JPanel jpSeparador;
/*     */   private JPanel panelCalendaio;
/*     */   private JRadioButton rbtManana;
/*     */   private JRadioButton rbtTarde;
/*     */   private TablaDarTurnos horarios;
/*     */   private PanelNuevoTurno parent;
/*     */ 
/*     */   public PanelNuevoTurnoHorarios(PanelNuevoTurno parent)
/*     */   {
/*  45 */     this.parent = parent;
/*  46 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  50 */     this.buttonGroup1 = new ButtonGroup();
/*     */ 
/*  52 */     this.panelCalendaio = new JPanel();
/*  53 */     this.calendar = new CyriusCalendar();
/*  54 */     this.jScrollPaneHorarios = new JScrollPane();
/*  55 */     this.rbtTarde = new JRadioButton();
/*  56 */     this.rbtManana = new JRadioButton();
/*  57 */     this.btnSiguienteHorario = new JButton();
/*  58 */     this.jpSeparador = new JPanel();
/*  59 */     this.jpSeparador.setBorder(
/*  60 */       new BevelBorder(0));
/*  61 */     setLayout(null);
/*  62 */     setBorder(
/*  63 */       new BevelBorder(0));
/*     */ 
/*  65 */     this.panelCalendaio.setBorder(new EtchedBorder());
/*  66 */     this.calendar
/*  67 */       .addDateSelectionListener(new DateSelectionListener()
/*     */     {
/*     */       public void disabledDatesChanged(DateSelectionEvent evt)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void dateSelectionChanged(DateSelectionEvent evt) {
/*  74 */         PanelNuevoTurnoHorarios.this.calendarioDateSelectionChanged(evt);
/*     */       }
/*     */ 
/*     */       public void selectionModeChanged(DateSelectionEvent evt)
/*     */       {
/*     */       }
/*     */
    });
/*  81 */     this.panelCalendaio.add(this.calendar);
/*  82 */     add(this.panelCalendaio);
/*  83 */     this.panelCalendaio.setBounds(480, 180, 250, 180);
/*  84 */     add(this.jScrollPaneHorarios);
/*  85 */     this.jScrollPaneHorarios.setBounds(0, 0, 460, 460);
/*  86 */     this.rbtTarde.setText("Turnos de Tarde");
/*  87 */     this.buttonGroup1.add(this.rbtTarde);
/*  88 */     this.rbtTarde.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  90 */         PanelNuevoTurnoHorarios.this.rbtTardeActionPerformed(evt);
/*     */       }
/*     */     });
/*  93 */     add(this.rbtTarde);
/*  94 */     this.rbtTarde.setBounds(540, 120, 130, 24);
/*  95 */     this.rbtManana.setText("Turnos de Mañana");
/*  96 */     this.buttonGroup1.add(this.rbtManana);
/*  97 */     this.rbtManana.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         PanelNuevoTurnoHorarios.this.rbtMananaActionPerformed(evt);
/*     */       }
/*     */     });
/* 102 */     add(this.rbtManana);
/* 103 */     this.rbtManana.setBounds(540, 50, 140, 24);
/* 104 */     this.btnSiguienteHorario.setText("Siguiente >");
/* 105 */     this.btnSiguienteHorario.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 107 */         PanelNuevoTurnoHorarios.this.btnSiguienteHorarioActionPerformed(evt);
/*     */       }
/*     */     });
/* 110 */     add(this.btnSiguienteHorario);
/* 111 */     this.btnSiguienteHorario.setBounds(550, 386, 120, 40);
/*     */ 
/* 113 */     this.rbtManana.setEnabled(false);
/* 114 */     this.rbtTarde.setEnabled(false);
/* 115 */     this.jScrollPaneHorarios.setVisible(false);
/*     */   }
/*     */ 
/*     */   private void rbtMananaActionPerformed(ActionEvent evt) {
/* 119 */     if (this.horarios == null)
/* 120 */       this.horarios = new TablaDarTurnos(TablaDarTurnos.MANANA);
/* 121 */     else if (this.horarios.getFocusCycleRootAncestor() != null)
/* 122 */       this.horarios.setEstado(TablaDarTurnos.MANANA);
/*     */   }
/*     */ 
/*     */   private void rbtTardeActionPerformed(ActionEvent evt)
/*     */   {
/* 127 */     if (this.horarios == null)
/* 128 */       this.horarios = new TablaDarTurnos(TablaDarTurnos.TARDE);
/* 129 */     else if (this.horarios.getFocusCycleRootAncestor() != null)
/* 130 */       this.horarios.setEstado(TablaDarTurnos.TARDE);
/*     */   }
/*     */ 
/*     */   private void calendarioDateSelectionChanged(DateSelectionEvent evt)
/*     */   {
/* 135 */     NoAtiendeSelectionMode selectionModel = (NoAtiendeSelectionMode)this.calendar
/* 136 */       .getDateSelectionModel();
/* 137 */     Date dateSelected = this.calendar.getDateSelectionModel()
/* 138 */       .getLeadSelectionDate();
/* 139 */     this.rbtTarde.setEnabled(selectionModel.atiendeTarde(dateSelected));
/* 140 */     this.rbtManana.setEnabled(selectionModel.atiendeManana(dateSelected));
/* 141 */     if (this.rbtManana.isEnabled())
/* 142 */       this.rbtManana.doClick();
/* 143 */     else if (this.rbtTarde.isEnabled()) {
/* 144 */       this.rbtTarde.doClick();
/*     */     }
/* 146 */     GregorianCalendar fecha = new GregorianCalendar();
/* 147 */     fecha.setTime(dateSelected);
/* 148 */     this.horarios.setMedico(this.parent.getSelectedMedico());
/* 149 */     this.jScrollPaneHorarios.setViewportView(this.horarios);
/* 150 */     this.jScrollPaneHorarios.setVisible(true);
/* 151 */     this.horarios.setDay(fecha);
/*     */   }
/*     */ 
/*     */   private void btnSiguienteHorarioActionPerformed(ActionEvent evt) {
/* 155 */     this.parent.setSelectedIndex(2);
/*     */   }
/*     */ 
/*     */   public GregorianCalendar getSelectedHour() {
/* 159 */     return this.horarios.getSelectedHour();
/*     */   }
/*     */ 
/*     */   public PanelNuevoTurnoHorarios setMedico(Medico medico) {
/* 163 */     NoAtiendeSelectionMode noAtiendeSelectionMode = new NoAtiendeSelectionMode(
/* 164 */       medico);
/* 165 */     noAtiendeSelectionMode.setCancelSelectionOnNotAviableDays4Medic(true);
/* 166 */     noAtiendeSelectionMode.setNotOldDays(true);
/* 167 */     this.calendar.setDateSelectionModel(noAtiendeSelectionMode);
/* 168 */     return this;
/*     */   }
/*     */ 
/*     */   public boolean isSelected() {
/* 172 */     if (this.horarios == null)
/* 173 */       return false;
/* 174 */     return this.horarios.isSelected();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.PanelNuevoTurnoHorarios
 * JD-Core Version:    0.6.0
 */