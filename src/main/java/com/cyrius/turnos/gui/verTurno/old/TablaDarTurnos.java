/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import com.cyrius.entities.HoraMinuto;
/*     */ import com.cyrius.entities.HorariosCens;
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.entities.Turno;
/*     */ import com.cyrius.searchers.BuscadorTurnos;
/*     */ import com.cyrius.services.HorarioService;
/*     */ import com.framework.entities.DateLapse;
/*     */ import java.awt.Color;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class TablaDarTurnos extends JTable
/*     */ {
/*     */   private static final int CANTTURNOSMANANA = 31;
/*     */   private static final int CANTTURNOSTARDE = 34;
/*  34 */   public static short TARDE = 2;
/*     */ 
/*  36 */   public static short MANANA = 1;
/*     */ 
/*  38 */   private static String libre = "                                           Libre";
/*     */   private GregorianCalendar fecha;
/*     */   private Medico medico;
/*     */   private short estado;
/*     */ 
/*     */   public TablaDarTurnos(short estado)
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
/*  61 */     fechaFin.setTimeInMillis(this.fecha.getTimeInMillis());
/*     */ 
/*  63 */     if (this.estado == MANANA) {
/*  64 */       HoraMinuto inicioTurnoManana = HorarioService.getHorarios()
/*  65 */         .getInicioTurnoManana();
/*  66 */       this.fecha.set(11, inicioTurnoManana.getHora().intValue());
/*  67 */       this.fecha.set(12, inicioTurnoManana.getMinutos().intValue());
/*  68 */       HoraMinuto finTurnoManana = HorarioService.getHorarios()
/*  69 */         .getFinTurnoManana();
/*  70 */       fechaFin.set(11, finTurnoManana.getHora().intValue());
/*  71 */       fechaFin.set(12, finTurnoManana.getMinutos().intValue());
/*     */     } else {
/*  73 */       HoraMinuto inicioTurnoTarde = HorarioService.getHorarios()
/*  74 */         .getInicioTurnoTarde();
/*  75 */       this.fecha.set(11, inicioTurnoTarde.getHora().intValue());
/*  76 */       this.fecha.set(12, inicioTurnoTarde.getMinutos().intValue());
/*  77 */       HoraMinuto finTurnoTarde = HorarioService.getHorarios()
/*  78 */         .getFinTurnoTarde();
/*  79 */       fechaFin.set(11, finTurnoTarde.getHora().intValue());
/*  80 */       fechaFin.set(12, finTurnoTarde.getMinutos().intValue());
/*     */     }
/*     */ 
/*  83 */     v = BuscadorTurnos.getInstance().buscarTurnos(
/*  84 */       new DateLapse(this.fecha.getTime(), fechaFin.getTime()), this.medico);
/*     */ 
/*  86 */     Iterator it = v.iterator();
/*  87 */     int max = 0;
/*  88 */     if (this.estado == MANANA)
/*  89 */       max = 31;
/*     */     else {
/*  91 */       max = 34;
/*     */     }
/*     */ 
/*  94 */     while (it.hasNext()) {
/*  95 */       Turno tur = (Turno)it.next();
/*  96 */       int i = 0;
/*     */ 
/*  98 */       while (i < max) {
/*  99 */         StringTokenizer stk = new StringTokenizer((String)mat[i][0], 
/* 100 */           ":");
/* 101 */         Integer hora = new Integer(stk.nextToken());
/* 102 */         Integer mins = new Integer(stk.nextToken());
/*     */ 
/* 104 */         if ((tur.getHora().getHours() == hora.intValue()) && 
/* 105 */           (tur.getHora().getMinutes() == mins.intValue())) {
/* 106 */           mat[i][1] = tur;
/*     */         }
/*     */ 
/* 109 */         i++;
/*     */       }
/*     */     }
/*     */ 
/* 113 */     return mat;
/*     */   }
/*     */ 
/*     */   private Object[][] initMatrix() {
/* 117 */     int i = 0;
/*     */ 
/* 120 */     int max = 0;
/*     */     int hora;
/*     */     int mins;
/*     */     Object[][] mat;
/* 123 */     if (this.estado == MANANA) {
/* 124 */        hora = 8;
/* 125 */        mins = 0;
/* 126 */        mat = new Object[31][2];
/* 127 */       max = 31;
/*     */     } else {
/* 129 */       hora = 14;
/* 130 */       mins = 0;
/* 131 */       mat = new Object[34][2];
/* 132 */       max = 34;
/*     */     }
/*     */ 
/* 135 */     while (i < max) {
/* 136 */       mat[i][0] = new String(hora + ":" + mins + "0");
/* 137 */       mat[i][1] = libre;
/* 138 */       i++;
/*     */ 
/* 140 */       if (mins < 5) {
/* 141 */         mins++;
/*     */       } else {
/* 143 */         hora++;
/* 144 */         mins = 0;
/*     */       }
/*     */     }
/*     */ 
/* 148 */     return mat;
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/* 152 */     setBackground(new Color(200, 200, 200));
/* 153 */     setSelectionBackground(new Color(200, 0, 150));
/* 154 */     setBackground(new Color(200, 200, 200));
/*     */ 
/* 156 */     setModel(new DefaultTableModel(
/* 157 */       cargarMatrix(), new String[] { "Hora", 
/* 158 */       "Tipo de Turno dado" }) {
/* 159 */       boolean[] canEdit = new boolean[2];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 162 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 165 */     setLayout(null);
/* 166 */     getColumnModel().getColumn(0).setMaxWidth(70);
/* 167 */     getColumnModel().getColumn(0).setPreferredWidth(50);
/* 168 */     getColumnModel().getColumn(0).setMinWidth(35);
/* 169 */     getColumnModel().setColumnMargin(10);
/* 170 */     setBorder(
/* 171 */       new SoftBevelBorder(0));
/* 172 */     setSelectionMode(0);
/*     */   }
/*     */ 
/*     */   protected void setMedico(Medico idMedico) {
/* 176 */     this.medico = idMedico;
/*     */   }
/*     */ 
/*     */   protected void setDay(GregorianCalendar fecha) {
/* 180 */     this.fecha = fecha;
/* 181 */     cargarMatrix();
/* 182 */     initComponents();
/*     */   }
/*     */ 
/*     */   public GregorianCalendar getFecha() {
/* 186 */     return this.fecha;
/*     */   }
/*     */ 
/*     */   protected Collection getSelectedHours() {
/* 190 */     Vector v = new Vector(0);
/* 191 */     int i = 0;
/* 192 */     int[] selected = getSelectedRows();
/*     */ 
/* 194 */     while (i < getSelectedRowCount()) {
/* 195 */       GregorianCalendar hSelec = new GregorianCalendar();
/* 196 */       hSelec.setTimeInMillis(this.fecha.getTimeInMillis());
/*     */ 
/* 198 */       StringTokenizer stk = new StringTokenizer(
/* 199 */         (String)getValueAt(selected[i], 0), ":");
/* 200 */       String hora = stk.nextToken();
/* 201 */       String min = stk.nextToken();
/* 202 */       Integer g = new Integer(hora);
/* 203 */       hSelec.set(11, g.intValue());
/* 204 */       hSelec.set(12, new Integer(min).intValue());
/* 205 */       v.addElement(hSelec);
/* 206 */       i++;
/*     */     }
/*     */ 
/* 209 */     return v;
/*     */   }
/*     */ 
/*     */   public boolean isSelected()
/*     */   {
/* 214 */     return getSelectedRowCount() > 0;
/*     */   }
/*     */ 
/*     */   protected boolean hayError()
/*     */   {
/* 221 */     boolean error = false;
/* 222 */     int i = 0;
/* 223 */     int[] selected = getSelectedRows();
/*     */ 
/* 225 */     if (getSelectedRowCount() == 0) {
/* 226 */       return true;
/*     */     }
/*     */ 
/* 229 */     while (i < getSelectedRowCount()) {
/* 230 */       if ((getValueAt(selected[i], 1) instanceof Turno)) {
/* 231 */         error = true;
/*     */       }
/* 233 */       i++;
/*     */     }
/*     */ 
/* 236 */     return error;
/*     */   }
/*     */ 
/*     */   protected GregorianCalendar getSelectedHour() {
/* 240 */     GregorianCalendar hSelec = new GregorianCalendar();
/* 241 */     hSelec.setTimeInMillis(this.fecha.getTimeInMillis());
/* 242 */     StringTokenizer stk = new StringTokenizer(
/* 243 */       (String)getValueAt(getSelectedRow(), 0), ":");
/* 244 */     hSelec.set(11, 
/* 245 */       new Integer(stk.nextToken()).intValue());
/* 246 */     hSelec.set(12, new Integer(stk.nextToken()).intValue());
/*     */ 
/* 248 */     return hSelec;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.TablaDarTurnos
 * JD-Core Version:    0.6.0
 */