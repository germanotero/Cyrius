/*     */ package com.cyrius.ui.components;
/*     */ 
/*     */ import java.awt.Color;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.cyrius.entities.HoraMinuto;
import com.cyrius.entities.Medico;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorTurnos;
import com.cyrius.services.HorarioService;
import com.cyrius.utils.prints.JPrintTable;
import com.framework.entities.DateLapse;
/*     */ 
/*     */ public class TablaVerTurnos extends JPrintTable
/*     */ {
/*     */   private static final int CANTTURNOSMANANA = 31;
/*     */   private static final int CANTTURNOSTARDE = 34;
/*  34 */   public static short TARDE = 2;
/*     */ 
/*  36 */   public static short MANANA = 1;
/*     */ 
/*  38 */   private static String libre = "                                           Libre";
/*     */   private Calendar fecha;
/*     */   private Medico medico;
/*     */   private short estado;
/*     */ 
/*     */   public TablaVerTurnos(short estado)
/*     */   {
/*  48 */     this.estado = estado;
/*     */   }
/*     */ 
/*     */   public void setEstado(short estado) {
/*  52 */     this.estado = estado;
/*  53 */     cargarMatrix();
/*  54 */     initComponents();
/*     */   }
/*     */ 
/*     */   private Object[][] cargarMatrix() {
/*  58 */     Collection v = null;
/*  59 */     Object[][] mat = initMatrix();
/*  60 */     GregorianCalendar fechaFin = new GregorianCalendar();
/*  61 */     if (this.fecha == null) {
/*  62 */       return mat;
/*     */     }
/*  64 */     fechaFin.setTimeInMillis(this.fecha.getTimeInMillis());
/*     */ 
/*  66 */     if (this.estado == MANANA) {
/*  67 */       HoraMinuto inicioTurnoManana = HorarioService.getHorarios()
/*  68 */         .getInicioTurnoManana();
/*  69 */       this.fecha.set(11, inicioTurnoManana.getHora().intValue());
/*  70 */       this.fecha.set(12, inicioTurnoManana.getMinutos().intValue());
/*  71 */       HoraMinuto finTurnoManana = HorarioService.getHorarios()
/*  72 */         .getFinTurnoManana();
/*  73 */       fechaFin.set(11, finTurnoManana.getHora().intValue());
/*  74 */       fechaFin.set(12, finTurnoManana.getMinutos().intValue());
/*     */     } else {
/*  76 */       HoraMinuto inicioTurnoTarde = HorarioService.getHorarios()
/*  77 */         .getInicioTurnoTarde();
/*  78 */       this.fecha.set(11, inicioTurnoTarde.getHora().intValue());
/*  79 */       this.fecha.set(12, inicioTurnoTarde.getMinutos().intValue());
/*  80 */       HoraMinuto finTurnoTarde = HorarioService.getHorarios()
/*  81 */         .getFinTurnoTarde();
/*  82 */       fechaFin.set(11, finTurnoTarde.getHora().intValue());
/*  83 */       fechaFin.set(12, finTurnoTarde.getMinutos().intValue());
/*     */     }
/*     */ 
/*  86 */     v = BuscadorTurnos.getInstance().buscarTurnos(
/*  87 */       new DateLapse(this.fecha.getTime(), fechaFin.getTime()), this.medico);
/*     */ 
/*  89 */     Iterator it = v.iterator();
/*  90 */     int max = 0;
/*     */ 
/*  92 */     if (this.estado == MANANA)
/*  93 */       max = 31;
/*     */     else {
/*  95 */       max = 34;
/*     */     }
/*     */ 
/*  98 */     while (it.hasNext()) {
/*  99 */       Turno tur = (Turno)it.next();
/* 100 */       int i = 0;
/*     */ 
/* 102 */       while (i < max) {
/* 103 */         StringTokenizer stk = new StringTokenizer((String)mat[i][0], 
/* 104 */           ":");
/* 105 */         Integer hora = new Integer(stk.nextToken());
/* 106 */         Integer mins = new Integer(stk.nextToken());
/*     */ 
/* 108 */         if ((tur.getHora().getHours() == hora.intValue()) && 
/* 109 */           (tur.getHora().getMinutes() == mins.intValue())) {
/* 110 */           mat[i][1] = tur;
/* 111 */           mat[i][2] = 
/* 112 */             Boolean.valueOf(tur.getAsistio() == null ? false : 
/* 112 */             tur.getAsistio().booleanValue());
/*     */         }
/*     */ 
/* 115 */         i++;
/*     */       }
/*     */     }
/*     */ 
/* 119 */     return mat;
/*     */   }
/*     */ 
/*     */   private Object[][] initMatrix() {
/* 123 */     int i = 0;
/*     */ 
/* 126 */     int max = 0;
/*     */     int hora;
/*     */     int mins;
/*     */     Object[][] mat;
/* 129 */     if (this.estado == MANANA) {
/* 130 */       hora = 8;
/* 131 */       mins = 0;
/* 132 */       mat = new Object[31][3];
/* 133 */       max = 31;
/*     */     } else {
/* 135 */       hora = 14;
/* 136 */       mins = 0;
/* 137 */       mat = new Object[34][3];
/* 138 */       max = 34;
/*     */     }
/*     */ 
/* 141 */     while (i < max) {
/* 142 */       mat[i][0] = new String(hora + ":" + mins + "0");
/* 143 */       mat[i][1] = libre;
/* 144 */       mat[i][2] = Boolean.valueOf(false);
/* 145 */       i++;
/*     */ 
/* 147 */       if (mins < 5) {
/* 148 */         mins++;
/*     */       } else {
/* 150 */         hora++;
/* 151 */         mins = 0;
/*     */       }
/*     */     }
/*     */ 
/* 155 */     return mat;
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/* 159 */     setBackground(new Color(200, 200, 200));
/* 160 */     setSelectionBackground(new Color(200, 0, 150));
/* 161 */     setBackground(new Color(200, 200, 200));
/* 162 */     setModel(
/* 164 */       new DefaultTableModel(cargarMatrix(), new String[] { "Hora", "Tipo de Turno dado", 
/* 164 */       "Asistio" }) {
/* 165 */       boolean[] canEdit = new boolean[3];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 168 */         return this.canEdit[columnIndex];
/*     */       }
/*     */ 
/*     */       public Class<?> getColumnClass(int columnIndex)
/*     */       {
/* 173 */         return columnIndex == 2 ? Boolean.class : Object.class;
/*     */       }
/*     */     });
/* 176 */     setLayout(null);
/* 177 */     getColumnModel().getColumn(0).setMaxWidth(70);
/* 178 */     getColumnModel().getColumn(0).setPreferredWidth(50);
/* 179 */     getColumnModel().getColumn(0).setMinWidth(35);
/* 180 */     getColumnModel().getColumn(2).setMinWidth(35);
/* 181 */     getColumnModel().getColumn(2).setMaxWidth(70);
/* 182 */     getColumnModel().getColumn(2).setPreferredWidth(50);
/* 183 */     getColumnModel().setColumnMargin(10);
/* 184 */     setBorder(
/* 185 */       new SoftBevelBorder(0));
/*     */   }
/*     */ 
/*     */   public void setMedico(Medico idMedico) {
/* 189 */     this.medico = idMedico;
/*     */   }
/*     */ 
/*     */   public void setDay(Calendar fecha) {
/* 193 */     this.fecha = fecha;
/* 194 */     cargarMatrix();
/* 195 */     initComponents();
/*     */   }
/*     */ 
/*     */   public Calendar getFecha() {
/* 199 */     return this.fecha;
/*     */   }
/*     */ 
/*     */   public Collection getSelectedHours() {
/* 203 */     Vector v = new Vector(0);
/* 204 */     int i = 0;
/* 205 */     int[] selected = getSelectedRows();
/*     */ 
/* 207 */     while (i < getSelectedRowCount()) {
/* 208 */       GregorianCalendar hSelec = new GregorianCalendar();
/* 209 */       hSelec.setTimeInMillis(this.fecha.getTimeInMillis());
/*     */ 
/* 211 */       StringTokenizer stk = new StringTokenizer(
/* 212 */         (String)getValueAt(selected[i], 0), ":");
/* 213 */       String hora = stk.nextToken();
/* 214 */       String min = stk.nextToken();
/* 215 */       Integer g = new Integer(hora);
/* 216 */       hSelec.set(11, g.intValue());
/* 217 */       hSelec.set(12, new Integer(min).intValue());
/* 218 */       v.addElement(hSelec);
/* 219 */       i++;
/*     */     }
/*     */ 
/* 222 */     return v;
/*     */   }
/*     */ 
/*     */   public boolean isSelected()
/*     */   {
/* 227 */     return getSelectedRowCount() > 0;
/*     */   }
/*     */ 
/*     */   protected boolean hayError()
/*     */   {
/* 234 */     boolean error = false;
/* 235 */     int i = 0;
/* 236 */     int[] selected = getSelectedRows();
/*     */ 
/* 238 */     if (getSelectedRowCount() == 0) {
/* 239 */       return true;
/*     */     }
/*     */ 
/* 242 */     while (i < getSelectedRowCount()) {
/* 243 */       if ((getValueAt(selected[i], 1) instanceof Turno)) {
/* 244 */         error = true;
/*     */       }
/*     */ 
/* 247 */       i++;
/*     */     }
/*     */ 
/* 250 */     return error;
/*     */   }
/*     */ 
/*     */   protected GregorianCalendar getSelectedHour() {
/* 254 */     GregorianCalendar hSelec = new GregorianCalendar();
/* 255 */     hSelec.setTimeInMillis(this.fecha.getTimeInMillis());
/* 256 */     StringTokenizer stk = new StringTokenizer(
/* 257 */       (String)getValueAt(getSelectedRow(), 0), ":");
/* 258 */     hSelec.set(11, 
/* 259 */       new Integer(stk.nextToken()).intValue());
/* 260 */     hSelec.set(12, new Integer(stk.nextToken()).intValue());
/*     */ 
/* 262 */     return hSelec;
/*     */   }
/*     */ 
/*     */   public boolean hasTurno(int row) {
/* 266 */     boolean esta = false;
/* 267 */     if ((getValueAt(row, 1) instanceof Turno)) {
/* 268 */       esta = true;
/*     */     }
/* 270 */     return esta;
/*     */   }
/*     */ 
/*     */   public Turno getSelectedTurno() {
/* 274 */     return (Turno)getValueAt(getSelectedRow(), 1);
/*     */   }
/*     */ 
/*     */   public void reload() {
/* 278 */     cargarMatrix();
/* 279 */     initComponents();
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.TablaVerTurnos
 * JD-Core Version:    0.6.0
 */