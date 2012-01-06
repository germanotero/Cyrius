/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.cyrius.utils.PracticaVisitor;
/*    */ 
/*    */ public class PracticaNomenclada extends Practica
/*    */ {
/*    */   private String codigo;
/*    */   private Double cantGalenosHonorario;
/*    */   private Double cantGalenosCosto;
/*    */ 
/*    */   public String getCodigo()
/*    */   {
/* 26 */     return this.codigo;
/*    */   }
/*    */ 
/*    */   public void setCodigo(String codigo) {
/* 30 */     this.codigo = codigo;
/*    */   }
/*    */ 
/*    */   public Double getCantGalenosCosto() {
/* 34 */     return this.cantGalenosCosto;
/*    */   }
/*    */ 
/*    */   public void setCantGalenosCosto(Double cantGalenosCosto) {
/* 38 */     this.cantGalenosCosto = cantGalenosCosto;
/*    */   }
/*    */ 
/*    */   public Double getCantGalenosHonorario() {
/* 42 */     return this.cantGalenosHonorario;
/*    */   }
/*    */ 
/*    */   public void setCantGalenosHonorario(Double cantGalenosHonorario) {
/* 46 */     this.cantGalenosHonorario = cantGalenosHonorario;
/*    */   }
/*    */ 
/*    */   public void accept(PracticaVisitor visitor)
/*    */   {
/* 51 */     visitor.visit(this);
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.PracticaNomenclada
 * JD-Core Version:    0.6.0
 */