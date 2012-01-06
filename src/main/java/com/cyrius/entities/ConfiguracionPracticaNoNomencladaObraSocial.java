/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.framework.exceptions.ShowableExceptionImpl;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ 
/*    */ public class ConfiguracionPracticaNoNomencladaObraSocial
/*    */   implements PersistibleObject
/*    */ {
/*    */   private Long id;
/*    */   private ObraSocial obraSocial;
/*    */   private String codigo;
/*    */ 
/*    */   public String getCodigo()
/*    */   {
/* 22 */     return this.codigo;
/*    */   }
/*    */ 
/*    */   public void setCodigo(String codigo) {
/* 26 */     this.codigo = codigo;
/*    */   }
/*    */ 
/*    */   public ObraSocial getObraSocial() {
/* 30 */     return this.obraSocial;
/*    */   }
/*    */ 
/*    */   public void setObraSocial(ObraSocial obraSocial) {
/* 34 */     this.obraSocial = obraSocial;
/*    */   }
/*    */ 
/*    */   public Long getId() {
/* 38 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 42 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public void validate() {
/* 46 */     ShowableExceptionImpl.validateNotNull("practica.no.nomenclada.codigo", 
/* 47 */       getObraSocial().getDescripcion(), getCodigo());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.ConfiguracionPracticaNoNomencladaObraSocial
 * JD-Core Version:    0.6.0
 */