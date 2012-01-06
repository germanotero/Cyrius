/*     */ package com.cyrius.ui.components;
/*     */ 
/*     */ import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.collections.Predicate;

import com.cyrius.entities.HorarioSemanal;
import com.cyrius.entities.Medico;
import com.framework.utils.CollectionUtils;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.DefaultDateSelectionModel;
import com.standbysoft.datepicker.event.DateSelectionListener;
/*     */ 
/*     */ public class NoAtiendeSelectionMode
/*     */   implements DateSelectionModel
/*     */ {
/*  60 */   private static Calendar cal = Calendar.getInstance();
/*     */ 
/*  62 */   private boolean notOldDays = false;
/*     */   private boolean cancelSelectionOnNotAviableDays4Medic;
/*     */   private Collection horarios;
/*     */   private DefaultDateSelectionModel defaultDateSelectionModel;
/*     */ 
/*     */   public NoAtiendeSelectionMode(Medico m)
/*     */   {
/*  77 */     this.defaultDateSelectionModel = new DefaultDateSelectionModel();
/*  78 */     this.horarios = m.getHorarios();
/*     */   }
/*     */ 
/*     */   public boolean isDisabled(Date date)
/*     */   {
/*  90 */     cal.setTime(date);
/*  91 */     if (this.notOldDays)
/*     */     {
/*  94 */       return (cal.get(7) == 7) || 
/*  93 */         (cal.get(7) == 1) || 
/*  94 */         (!isAviable(date)) || (esAnterior(date));
/*     */     }
/*     */ 
/*  98 */     return (cal.get(7) == 7) || 
/*  97 */       (cal.get(7) == 1) || 
/*  98 */       (!isAviable(date));
/*     */   }
/*     */ 
/*     */   public void setNotOldDays(boolean value)
/*     */   {
/* 108 */     this.notOldDays = value;
/*     */   }
/*     */ 
/*     */   private boolean esAnterior(Date date)
/*     */   {
/* 120 */     GregorianCalendar fecha = new GregorianCalendar();
/* 121 */     fecha.setTimeInMillis(date.getTime());
/* 122 */     GregorianCalendar hoy = new GregorianCalendar();
/*     */ 
/* 126 */     return (!hoy.before(fecha)) && 
/* 124 */       (hoy.get(6) != 
/* 125 */       fecha.get(6));
/*     */   }
/*     */ 
/*     */   private boolean isAviable(Date date)
/*     */   {
/* 140 */     return CollectionUtils.exists(this.horarios, 
/* 141 */       new HorarioSemanalDatePredicate(date));
/*     */   }
/*     */ 
/*     */   public void setSelectionMode(DateSelectionModel.SelectionMode arg0)
/*     */   {
/* 151 */     this.defaultDateSelectionModel.setSelectionMode(arg0);
/*     */   }
/*     */ 
/*     */   public DateSelectionModel.SelectionMode getSelectionMode()
/*     */   {
/* 160 */     return this.defaultDateSelectionModel.getSelectionMode();
/*     */   }
/*     */ 
/*     */   public boolean isDateSelected(Date arg0)
/*     */   {
/* 169 */     return this.defaultDateSelectionModel.isDateSelected(arg0);
/*     */   }
/*     */ 
/*     */   public Date[] getSelectedDates()
/*     */   {
/* 178 */     return this.defaultDateSelectionModel.getSelectedDates();
/*     */   }
/*     */ 
/*     */   public Date getAnchorSelectionDate()
/*     */   {
/* 187 */     return this.defaultDateSelectionModel.getAnchorSelectionDate();
/*     */   }
/*     */ 
/*     */   public void setAnchorSelectionDate(Date arg0)
/*     */   {
/* 196 */     this.defaultDateSelectionModel.setAnchorSelectionDate(arg0);
/*     */   }
/*     */ 
/*     */   public Date getLeadSelectionDate()
/*     */   {
/* 205 */     return this.defaultDateSelectionModel.getLeadSelectionDate();
/*     */   }
/*     */ 
/*     */   public void setLeadSelectionDate(Date arg0)
/*     */   {
/* 214 */     this.defaultDateSelectionModel.setLeadSelectionDate(arg0);
/*     */   }
/*     */ 
/*     */   public void setDateSelectionIterval(Date arg0, Date arg1)
/*     */   {
/* 224 */     this.defaultDateSelectionModel.setDateSelectionIterval(arg0, arg1);
/*     */   }
/*     */ 
/*     */   public void addDateSelectionInterval(Date arg0, Date arg1)
/*     */   {
/* 234 */     this.defaultDateSelectionModel.setDateSelectionIterval(arg0, arg1);
/*     */   }
/*     */ 
/*     */   public void removeDateSelectionInterval(Date arg0, Date arg1)
/*     */   {
/* 244 */     this.defaultDateSelectionModel.removeDateSelectionInterval(arg0, arg1);
/*     */   }
/*     */ 
/*     */   public void addDateSelectionListener(DateSelectionListener arg0)
/*     */   {
/* 253 */     this.defaultDateSelectionModel.addDateSelectionListener(arg0);
/*     */   }
/*     */ 
/*     */   public void removeDateSelectionListener(DateSelectionListener arg0)
/*     */   {
/* 262 */     this.defaultDateSelectionModel.removeDateSelectionListener(arg0);
/*     */   }
/*     */ 
/*     */   public boolean isCancelSelectionOnNotAviableDays4Medic()
/*     */   {
/* 269 */     return this.cancelSelectionOnNotAviableDays4Medic;
/*     */   }
/*     */ 
/*     */   public void setCancelSelectionOnNotAviableDays4Medic(boolean cancelSelectionOnNotAviableDays4Medic)
/*     */   {
/* 278 */     this.cancelSelectionOnNotAviableDays4Medic = cancelSelectionOnNotAviableDays4Medic;
/*     */   }
/*     */ 
/*     */   public boolean atiendeTarde(Date fecha) {
/* 282 */     Collection hs = CollectionUtils.select(this.horarios, 
/* 283 */       new HorarioSemanalDatePredicate(fecha));
/* 284 */     return CollectionUtils.exists(hs, 
/* 285 */       new DiaPredicate("t"));
/*     */   }
/*     */ 
/*     */   public boolean atiendeManana(Date fecha) {
/* 289 */     Collection hs = CollectionUtils.select(this.horarios, 
/* 290 */       new HorarioSemanalDatePredicate(fecha));
/* 291 */     return CollectionUtils.exists(hs, 
/* 292 */       new DiaPredicate("m"));
/*     */   }
/*     */ 
/*     */   private class DiaPredicate
/*     */     implements Predicate
/*     */   {
/*     */     private String dia;
/*     */ 
/*     */     public DiaPredicate(String dia)
/*     */     {
/*  30 */       this.dia = dia;
/*     */     }
/*     */ 
/*     */     public boolean evaluate(Object arg0) {
/*  34 */       HorarioSemanal hs = (HorarioSemanal)arg0;
/*  35 */       return hs.getMomento().equals(this.dia);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class HorarioSemanalDatePredicate implements Predicate
/*     */   {
/*     */     private final Date date;
/*     */ 
/*     */     private HorarioSemanalDatePredicate(Date date) {
/*  45 */       this.date = date;
/*     */     }
/*     */ 
/*     */     public boolean evaluate(Object arg0) {
/*  49 */       HorarioSemanal hs = (HorarioSemanal)arg0;
/*  50 */       GregorianCalendar hoy = new GregorianCalendar();
/*  51 */       hoy.setTime(this.date);
/*  52 */       return hoy.get(7) == hs.getDia().intValue() + 1;
/*     */     }
/*     */   }
/*     */
 }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.NoAtiendeSelectionMode
 * JD-Core Version:    0.6.0
 */