/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RangoHorario
/*    */ {
/*  7 */   private Boolean manana = Boolean.valueOf(false);
/*    */   private String horaInicio;
/*    */   private String horaFin;
/*    */   private Date fechaInicio;
/*    */   private Date fechaFin;
/*    */   private Integer minutos;
/*    */ 
/*    */   public Boolean getManana()
/*    */   {
/* 20 */     return this.manana;
/*    */   }
/*    */ 
/*    */   public void setManana(Boolean manana) {
/* 24 */     this.manana = manana;
/*    */   }
/*    */ 
/*    */   public Date getFechaFin() {
/* 28 */     return this.fechaFin;
/*    */   }
/*    */ 
/*    */   public void setFechaFin(Date fechaFin) {
/* 32 */     this.fechaFin = fechaFin;
/*    */   }
/*    */ 
/*    */   public Date getFechaInicio() {
/* 36 */     return this.fechaInicio;
/*    */   }
/*    */ 
/*    */   public void setFechaInicio(Date fechaInicio) {
/* 40 */     this.fechaInicio = fechaInicio;
/*    */   }
/*    */ 
/*    */   public String getHoraFin() {
/* 44 */     return this.horaFin;
/*    */   }
/*    */ 
/*    */   public void setHoraFin(String horaFin) {
/* 48 */     this.horaFin = horaFin;
/*    */   }
/*    */ 
/*    */   public String getHoraInicio() {
/* 52 */     return this.horaInicio;
/*    */   }
/*    */ 
/*    */   public void setHoraInicio(String horaInicio) {
/* 56 */     this.horaInicio = horaInicio;
/*    */   }
/*    */ 
/*    */   public Integer getMinutos() {
/* 60 */     return this.minutos;
/*    */   }
/*    */ 
/*    */   public void setMinutos(Integer minutos) {
/* 64 */     this.minutos = minutos;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.RangoHorario
 * JD-Core Version:    0.6.0
 */