/*    */ package com.framework.models;
/*    */ 
/*    */ public class Medida
/*    */ {
/*    */   private Double valor;
/*    */   private TipoMedida tipoMedida;
/*    */ 
/*    */   public Medida(String valor, TipoMedida tipoMedida)
/*    */   {
/* 13 */     this.valor = Double.valueOf(Double.parseDouble(valor));
/* 14 */     this.tipoMedida = tipoMedida;
/*    */   }
/*    */ 
/*    */   public TipoMedida getTipoMedida() {
/* 18 */     return this.tipoMedida;
/*    */   }
/*    */ 
/*    */   public Double getValor()
/*    */   {
/* 25 */     return this.valor;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 29 */     return toString();
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 36 */     return this.valor.toString() + "-" + getTipoMedida().getSimbolo();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.Medida
 * JD-Core Version:    0.6.0
 */