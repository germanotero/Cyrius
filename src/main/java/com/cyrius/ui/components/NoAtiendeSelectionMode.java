/*     */ package com.cyrius.ui.components;
/*     */ 
/*     */ import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.cyrius.entities.HorarioSemanal;
import com.cyrius.entities.Medico;
import com.framework.utils.ExtraCollectionUtils;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.DefaultDateSelectionModel;
import com.standbysoft.datepicker.event.DateSelectionListener;

public class NoAtiendeSelectionMode
  implements DateSelectionModel
{
  private static Calendar cal = Calendar.getInstance();

  private boolean notOldDays = false;
  private boolean cancelSelectionOnNotAviableDays4Medic;
  private Collection horarios;
  private DefaultDateSelectionModel defaultDateSelectionModel;

  public NoAtiendeSelectionMode(Medico m)
  {
    this.defaultDateSelectionModel = new DefaultDateSelectionModel();
    this.horarios = m.getHorarios();
  }

  public boolean isDisabled(Date date)
  {
    cal.setTime(date);
    if (this.notOldDays)
    {
      return (cal.get(7) == 7) || 
        (cal.get(7) == 1) || 
        (!isAviable(date)) || (esAnterior(date));
    }

    return (cal.get(7) == 7) || 
      (cal.get(7) == 1) || 
      (!isAviable(date));
  }

  public void setNotOldDays(boolean value)
  {
    this.notOldDays = value;
  }

  private boolean esAnterior(Date date)
  {
    GregorianCalendar fecha = new GregorianCalendar();
    fecha.setTimeInMillis(date.getTime());
    GregorianCalendar hoy = new GregorianCalendar();

    return (!hoy.before(fecha)) && 
      (hoy.get(6) != 
      fecha.get(6));
  }

  private boolean isAviable(Date date)
  {
    return CollectionUtils.exists(this.horarios, 
      new HorarioSemanalDatePredicate(date));
  }

  public void setSelectionMode(DateSelectionModel.SelectionMode arg0)
  {
    this.defaultDateSelectionModel.setSelectionMode(arg0);
  }

  public DateSelectionModel.SelectionMode getSelectionMode()
  {
    return this.defaultDateSelectionModel.getSelectionMode();
  }

  public boolean isDateSelected(Date arg0)
  {
    return this.defaultDateSelectionModel.isDateSelected(arg0);
  }

  public Date[] getSelectedDates()
  {
    return this.defaultDateSelectionModel.getSelectedDates();
  }

  public Date getAnchorSelectionDate()
  {
    return this.defaultDateSelectionModel.getAnchorSelectionDate();
  }

  public void setAnchorSelectionDate(Date arg0)
  {
    this.defaultDateSelectionModel.setAnchorSelectionDate(arg0);
  }

  public Date getLeadSelectionDate()
  {
    return this.defaultDateSelectionModel.getLeadSelectionDate();
  }

  public void setLeadSelectionDate(Date arg0)
  {
    this.defaultDateSelectionModel.setLeadSelectionDate(arg0);
  }

  public void setDateSelectionIterval(Date arg0, Date arg1)
  {
    this.defaultDateSelectionModel.setDateSelectionIterval(arg0, arg1);
  }

  public void addDateSelectionInterval(Date arg0, Date arg1)
  {
    this.defaultDateSelectionModel.setDateSelectionIterval(arg0, arg1);
  }

  public void removeDateSelectionInterval(Date arg0, Date arg1)
  {
    this.defaultDateSelectionModel.removeDateSelectionInterval(arg0, arg1);
  }

  public void addDateSelectionListener(DateSelectionListener arg0)
  {
    this.defaultDateSelectionModel.addDateSelectionListener(arg0);
  }

  public void removeDateSelectionListener(DateSelectionListener arg0)
  {
    this.defaultDateSelectionModel.removeDateSelectionListener(arg0);
  }

  public boolean isCancelSelectionOnNotAviableDays4Medic()
  {
    return this.cancelSelectionOnNotAviableDays4Medic;
  }

  public void setCancelSelectionOnNotAviableDays4Medic(boolean cancelSelectionOnNotAviableDays4Medic)
  {
    this.cancelSelectionOnNotAviableDays4Medic = cancelSelectionOnNotAviableDays4Medic;
  }

  public boolean atiendeTarde(Date fecha) {
    Collection hs = CollectionUtils.select(this.horarios, 
      new HorarioSemanalDatePredicate(fecha));
    return CollectionUtils.exists(hs, 
      new DiaPredicate("t"));
  }

  public boolean atiendeManana(Date fecha) {
    Collection hs = CollectionUtils.select(this.horarios, 
      new HorarioSemanalDatePredicate(fecha));
    return CollectionUtils.exists(hs, 
      new DiaPredicate("m"));
  }

  private class DiaPredicate
    implements Predicate
  {
    private String dia;

    public DiaPredicate(String dia)
    {
      this.dia = dia;
    }

    public boolean evaluate(Object arg0) {
      HorarioSemanal hs = (HorarioSemanal)arg0;
      return hs.getMomento().equals(this.dia);
    }
  }

  private class HorarioSemanalDatePredicate implements Predicate
  {
    private final Date date;

    private HorarioSemanalDatePredicate(Date date) {
      this.date = date;
    }

    public boolean evaluate(Object arg0) {
      HorarioSemanal hs = (HorarioSemanal)arg0;
      GregorianCalendar hoy = new GregorianCalendar();
      hoy.setTime(this.date);
      return hoy.get(7) == hs.getDia().intValue() + 1;
    }
  }

 }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.NoAtiendeSelectionMode
 * JD-Core Version:    0.6.0
 */