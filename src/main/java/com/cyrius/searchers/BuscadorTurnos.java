package com.cyrius.searchers;

import com.cyrius.entities.*;




import com.cyrius.services.HorarioService;
import com.framework.entities.DateLapse;
import com.framework.persistence.CriteriaBuilder;
import com.framework.persistence.PersistenceService;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class BuscadorTurnos
{
  private static BuscadorTurnos instance;

  public static synchronized BuscadorTurnos getInstance()
  {
    if (instance == null)
      instance = new BuscadorTurnos();
    return instance;
  }

  public Collection findByMedicoForInformes(Medico medico) {
    CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
    builder.addEquals("medico", medico);
    HoraMinuto inicioTurnoManana = HorarioService.getHorarios().getInicioTurnoManana();
    Calendar inicioTurno = Calendar.getInstance();
    inicioTurno.set(9, 0);
    inicioTurno.set(10, inicioTurnoManana.getHora().intValue());
    inicioTurno.set(12, inicioTurnoManana.getMinutos().intValue());
    inicioTurno.set(13, 0);
    inicioTurno.set(14, 0);

    Calendar finTurno = Calendar.getInstance();
    HoraMinuto finTurnoTarde = HorarioService.getHorarios().getFinTurnoTarde();
    finTurno.set(9, 1);
    finTurno.set(10, finTurnoTarde.getHora().intValue());
    finTurno.set(12, finTurnoTarde.getMinutos().intValue());
    finTurno.set(13, 59);
    finTurno.set(14, 59);
    builder.addBetween("hora", inicioTurno, finTurno);

    builder.addSql("NOT EXISTS (SELECT * FROM CYRIUS.INFORME WHERE ID_TURNO = THIS_.ID_TURNO)");
    builder.addEquals("asistio", Boolean.TRUE);
    return (Collection)builder.build();
  }

  public Collection buscarTurnos(DateLapse period, Medico medico) {
    CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
    builder.addEquals("medico", medico);
    builder.addBetween("hora", period);
    return (Collection)builder.build();
  }

  public static Collection getTurnosControl(DateLapse period) {
    CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
    builder.addBetween("hora", period);
    builder.addEquals("asistio", Boolean.valueOf(true));
    builder.addOrderBy("hora");

    return (Collection)builder.build();
  }

  public Collection buscarTurnosSinPlanilla(DateLapse period, Medico medico, ObraSocial obraSocial) {
    CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
    builder.addEquals("medico", medico);
    builder.addBetween("hora", period);
    builder.addEquals("obraSocial", obraSocial);
    builder.addEquals("firmaPlanilla", Boolean.FALSE);
    builder.addOrderBy("practica");
    return (Collection)builder.build();
  }

   public Collection<Turno> findByPaciente(Persona pac) {
       CriteriaBuilder<Collection<Turno>> builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
       builder.addEquals("paciente", pac);
       return builder.build();
   }
}
