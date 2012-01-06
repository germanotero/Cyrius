/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class HorarioMedicoTachado
/*    */ {
/*    */   private Integer id;
/*    */   private Integer idMedico;
/*    */   private Calendar dia;
/*    */   private String turno;
/*    */ 
/*    */   public Calendar getDia()
/*    */   {
/* 26 */     return this.dia;
/*    */   }
/*    */ 
/*    */   public void setDia(Calendar dia)
/*    */   {
/* 34 */     this.dia = dia;
/*    */   }
/*    */ 
/*    */   public Integer getIdMedico()
/*    */   {
/* 41 */     return this.idMedico;
/*    */   }
/*    */ 
/*    */   public void setIdMedico(Integer idMedico)
/*    */   {
/* 49 */     this.idMedico = idMedico;
/*    */   }
/*    */ 
/*    */   public String getTurno()
/*    */   {
/* 56 */     return this.turno;
/*    */   }
/*    */ 
/*    */   public void setTurno(String turno)
/*    */   {
/* 64 */     this.turno = turno;
/*    */   }
/*    */ 
/*    */   protected Integer getId() {
/* 68 */     return this.id;
/*    */   }
/*    */ 
/*    */   protected void setId(Integer id) {
/* 72 */     this.id = id;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.HorarioMedicoTachado
 * JD-Core Version:    0.6.0
 */