/*    */ package com.cyrius.entities;
/*    */ 
/*    */ public class HorariosCens
/*    */ {
/*  4 */   private HoraMinuto inicioTurnoManana = new HoraMinuto(Integer.valueOf(8), Integer.valueOf(0));
/*    */ 
/*  6 */   private HoraMinuto finTurnoManana = new HoraMinuto(Integer.valueOf(13), Integer.valueOf(0));
/*    */ 
/*  8 */   private HoraMinuto inicioTurnoTarde = new HoraMinuto(Integer.valueOf(14), Integer.valueOf(0));
/*    */ 
/* 10 */   private HoraMinuto finTurnoTarde = new HoraMinuto(Integer.valueOf(19), Integer.valueOf(30));
/*    */ 
/* 12 */   private Integer diferenciaEntreTurnos = Integer.valueOf(10);
/*    */ 
/*    */   public HoraMinuto getFinTurnoManana()
/*    */   {
/* 19 */     return this.finTurnoManana;
/*    */   }
/*    */ 
/*    */   public void setFinTurnoManana(HoraMinuto finTurnoManana) {
/* 23 */     this.finTurnoManana = finTurnoManana;
/*    */   }
/*    */ 
/*    */   public HoraMinuto getFinTurnoTarde() {
/* 27 */     return this.finTurnoTarde;
/*    */   }
/*    */ 
/*    */   public void setFinTurnoTarde(HoraMinuto finTurnoTarde) {
/* 31 */     this.finTurnoTarde = finTurnoTarde;
/*    */   }
/*    */ 
/*    */   public HoraMinuto getInicioTurnoManana() {
/* 35 */     return this.inicioTurnoManana;
/*    */   }
/*    */ 
/*    */   public void setInicioTurnoManana(HoraMinuto inicioTurnoManana) {
/* 39 */     this.inicioTurnoManana = inicioTurnoManana;
/*    */   }
/*    */ 
/*    */   public HoraMinuto getInicioTurnoTarde() {
/* 43 */     return this.inicioTurnoTarde;
/*    */   }
/*    */ 
/*    */   public void setInicioTurnoTarde(HoraMinuto initioTurnoTarde) {
/* 47 */     this.inicioTurnoTarde = initioTurnoTarde;
/*    */   }
/*    */ 
/*    */   public Integer getDiferenciaEntreTurnos() {
/* 51 */     return this.diferenciaEntreTurnos;
/*    */   }
/*    */ 
/*    */   public void setDiferenciaEntreTurnos(Integer diferenciaEntreTurnos) {
/* 55 */     this.diferenciaEntreTurnos = diferenciaEntreTurnos;
/*    */   }
/*    */ 
/*    */   public Integer getCantidadTurnosManana() {
/* 59 */     return new Integer(20);
/*    */   }
/*    */ 
/*    */   public Integer getCantidadTurnosTade() {
/* 63 */     return new Integer(20);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.HorariosCens
 * JD-Core Version:    0.6.0
 */