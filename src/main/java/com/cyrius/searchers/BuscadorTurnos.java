/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.HoraMinuto;
/*    */ import com.cyrius.entities.HorariosCens;
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.entities.ObraSocial;
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.cyrius.services.HorarioService;
/*    */ import com.framework.entities.DateLapse;
/*    */ import com.framework.persistence.CriteriaBuilder;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Calendar;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorTurnos
/*    */ {
/*    */   private static BuscadorTurnos instance;
/*    */ 
/*    */   public static synchronized BuscadorTurnos getInstance()
/*    */   {
/* 26 */     if (instance == null)
/* 27 */       instance = new BuscadorTurnos();
/* 28 */     return instance;
/*    */   }
/*    */ 
/*    */   public Collection findByMedicoForInformes(Medico medico) {
/* 32 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
/* 33 */     builder.addEquals("medico", medico);
/* 34 */     HoraMinuto inicioTurnoManana = HorarioService.getHorarios().getInicioTurnoManana();
/* 35 */     Calendar inicioTurno = Calendar.getInstance();
/* 36 */     inicioTurno.set(9, 0);
/* 37 */     inicioTurno.set(10, inicioTurnoManana.getHora().intValue());
/* 38 */     inicioTurno.set(12, inicioTurnoManana.getMinutos().intValue());
/* 39 */     inicioTurno.set(13, 0);
/* 40 */     inicioTurno.set(14, 0);
/*    */ 
/* 42 */     Calendar finTurno = Calendar.getInstance();
/* 43 */     HoraMinuto finTurnoTarde = HorarioService.getHorarios().getFinTurnoTarde();
/* 44 */     finTurno.set(9, 1);
/* 45 */     finTurno.set(10, finTurnoTarde.getHora().intValue());
/* 46 */     finTurno.set(12, finTurnoTarde.getMinutos().intValue());
/* 47 */     finTurno.set(13, 59);
/* 48 */     finTurno.set(14, 59);
/* 49 */     builder.addBetween("hora", inicioTurno, finTurno);
/*    */ 
/* 51 */     builder.addSql("NOT EXISTS (SELECT * FROM CYRIUS.INFORME WHERE ID_TURNO = THIS_.ID_TURNO)");
/* 52 */     builder.addEquals("asistio", Boolean.TRUE);
/* 53 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public Collection buscarTurnos(DateLapse period, Medico medico) {
/* 57 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
/* 58 */     builder.addEquals("medico", medico);
/* 59 */     builder.addBetween("hora", period);
/* 60 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public static Collection getTurnosControl(DateLapse period) {
/* 64 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
/* 65 */     builder.addBetween("hora", period);
/* 66 */     builder.addEquals("asistio", Boolean.valueOf(true));
/* 67 */     builder.addOrderBy("hora");
/*    */ 
/* 69 */     return (Collection)builder.build();
/*    */   }
/*    */ 
/*    */   public Collection buscarTurnosSinPlanilla(DateLapse period, Medico medico, ObraSocial obraSocial) {
/* 73 */     CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Turno.class);
/* 74 */     builder.addEquals("medico", medico);
/* 75 */     builder.addBetween("hora", period);
/* 76 */     builder.addEquals("obraSocial", obraSocial);
/* 77 */     builder.addEquals("firmaPlanilla", Boolean.FALSE);
/* 78 */     builder.addOrderBy("practica");
/* 79 */     return (Collection)builder.build();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorTurnos
 * JD-Core Version:    0.6.0
 */