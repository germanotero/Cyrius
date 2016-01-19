/*    */ package com.framework.models;
/*    */ 
/*    */ public class TipoMedida
/*    */ {
/*    */   private String descripcion;
/*    */   private String simbolo;
public TipoMedida() {
	// TODO Auto-generated constructor stub
}
/*    */ 
/*    */   public TipoMedida(String simbolo, String descripcion)
/*    */   {
/* 13 */     this.simbolo = simbolo;
/* 14 */     this.descripcion = descripcion;
/*    */   }
/*    */ 
/*    */   public static TipoMedida getMM() {
/* 18 */     return new TipoMedida("mm", "Milimetros");
/*    */   }
/*    */ 
/*    */   public static TipoMedida getCM() {
/* 22 */     return new TipoMedida("cm", "Centimetros");
/*    */   }
/*    */ 
/*    */   public String getDescripcion() {
/* 26 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public String getSimbolo() {
/* 30 */     return this.simbolo;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 37 */     return getSimbolo();
/*    */   }
/*    */ 
/*    */   public static TipoMedida getCM3()
/*    */   {
/* 42 */     return new TipoMedida("cm3", "Centimetros Cuadrados");
/*    */   }
/*    */ 
/*    */   public static TipoMedida getMM3()
/*    */   {
/* 47 */     return new TipoMedida("mm3", "Milimetros Cuadrados");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.TipoMedida
 * JD-Core Version:    0.6.0
 */