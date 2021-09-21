package com.cyrius.entities;

import com.framework.utils.CollectionFactory;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

public class Medico extends Persona
{
  private Integer matricula;
  private String telCel;
  private Collection<HorarioSemanal> horarios = CollectionFactory.createCollection(HorarioSemanal.class);

  private Collection obrasSociales = CollectionFactory.createCollection();

  public Collection getObrasSociales() {
    return this.obrasSociales;
  }

  public void setObrasSociales(Collection obrasSociales) {
    this.obrasSociales = obrasSociales;
  }

  public Collection<HorarioSemanal> getHorarios()
  {
    return this.horarios;
  }

  public void setHorarios(Collection<HorarioSemanal> horarios)
  {
    this.horarios = horarios;
  }

  public Integer getMatricula() {
    return this.matricula;
  }

  public void setMatricula(Integer matricula) {
    this.matricula = matricula;
  }

  public String getTelCel() {
    return this.telCel;
  }

  public void setTelCel(String telCel) {
    this.telCel = telCel;
  }

  public String toString() {
    return getNombre() + " " + getApellido();
  }

  public boolean getAtiendeDeManana(Calendar dia)
  {
    Iterator it = this.horarios.iterator();
    boolean encontro = false;
    while ((it.hasNext()) && (!encontro)) {
      HorarioSemanal hs = (HorarioSemanal)it.next();

      if ((dia.get(7) != hs.getDia().intValue() + 1) ||
        (!hs.getMomento().equalsIgnoreCase("m"))) continue;
      encontro = true;
    }

    return encontro;
  }

  public boolean getAtiendeDeTarde(Calendar dia)
  {
    Iterator it = this.horarios.iterator();
    boolean encontro = false;
    while ((it.hasNext()) && (!encontro)) {
      HorarioSemanal hs = (HorarioSemanal)it.next();

      if ((dia.get(7) != hs.getDia().intValue() + 1) ||
        (!hs.getMomento().equalsIgnoreCase("t"))) continue;
      encontro = true;
    }

    return encontro;
  }

  public boolean equals(Object o)
  {
    if (o == null)
      return false;
    if (!o.getClass().equals(getClass())) {
      return false;
    }
    if (o != null)
      return getMatricula().equals(((Medico)o).getMatricula());
    return false;
  }
}
