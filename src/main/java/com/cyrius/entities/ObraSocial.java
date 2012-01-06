/*     */ package com.cyrius.entities;
/*     */ 
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class ObraSocial
/*     */   implements Serializable, PersistibleObject
/*     */ {
/*     */   private Long id;
/*  15 */   private String codigo = null;
/*     */ 
/*  17 */   private String descripcion = null;
/*     */ 
/*  19 */   private Double galCosto = null;
/*     */ 
/*  21 */   private Double galHono = null;
/*     */ 
/*  23 */   private Double arancel = null;
/*     */ 
/*     */   public void setCodigo(String codigo)
/*     */   {
/*  30 */     this.codigo = codigo;
/*     */   }
/*     */ 
/*     */   public String getCodigo() {
/*  34 */     return this.codigo;
/*     */   }
/*     */ 
/*     */   public void setDescripcion(String descripcion) {
/*  38 */     this.descripcion = descripcion;
/*     */   }
/*     */ 
/*     */   public String getDescripcion() {
/*  42 */     return this.descripcion;
/*     */   }
/*     */ 
/*     */   public Double getGalCosto()
/*     */   {
/*  49 */     return this.galCosto;
/*     */   }
/*     */ 
/*     */   public void setGalCosto(Double galCosto)
/*     */   {
/*  57 */     this.galCosto = galCosto;
/*     */   }
/*     */ 
/*     */   public Double getGalHono()
/*     */   {
/*  64 */     return this.galHono;
/*     */   }
/*     */ 
/*     */   public void setGalHono(Double galHono)
/*     */   {
/*  72 */     this.galHono = galHono;
/*     */   }
/*     */ 
/*     */   public Double getArancel()
/*     */   {
/*  79 */     return this.arancel;
/*     */   }
/*     */ 
/*     */   public void setArancel(Double arancel)
/*     */   {
/*  87 */     this.arancel = arancel;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  91 */     if (getCodigo() != null) {
/*  92 */       return getCodigo() + " - " + getDescripcion();
/*     */     }
/*  94 */     return getDescripcion();
/*     */   }
/*     */ 
/*     */   public boolean equals(Object os) {
/*  98 */     if ((os != null) && ((os instanceof ObraSocial))) {
/*  99 */       if (((ObraSocial)os).codigo == null)
/* 100 */         return super.equals(os);
/* 101 */       return ((ObraSocial)os).codigo.equalsIgnoreCase(this.codigo);
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 107 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 111 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.ObraSocial
 * JD-Core Version:    0.6.0
 */