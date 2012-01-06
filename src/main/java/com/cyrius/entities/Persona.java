/*     */ package com.cyrius.entities;
/*     */ 
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Persona
/*     */   implements Serializable, PersistibleObject
/*     */ {
/*     */   private Long id;
/*     */   private Integer documento;
/*     */   private String telefono;
/*     */   private String nombre;
/*     */   private String apellido;
/*     */   private String calle;
/*     */   private String numero;
/*     */   private String ciudad;
/*     */   private String historiaClinica;
/*     */   private TipoDocumento tipoDocumento;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  35 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  39 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public void setDocumento(Integer doc) {
/*  43 */     this.documento = doc;
/*     */   }
/*     */ 
/*     */   public Integer getDocumento() {
/*  47 */     return this.documento;
/*     */   }
/*     */ 
/*     */   public void setTelefono(String tel) {
/*  51 */     this.telefono = tel;
/*     */   }
/*     */ 
/*     */   public String getTelefono() {
/*  55 */     return this.telefono;
/*     */   }
/*     */ 
/*     */   public void setNombre(String nombre) {
/*  59 */     this.nombre = nombre;
/*     */   }
/*     */ 
/*     */   public String getNombre() {
/*  63 */     return this.nombre;
/*     */   }
/*     */ 
/*     */   public void setApellido(String apellido) {
/*  67 */     this.apellido = apellido;
/*     */   }
/*     */ 
/*     */   public String getApellido() {
/*  71 */     return this.apellido;
/*     */   }
/*     */ 
/*     */   public void setCalle(String calle) {
/*  75 */     this.calle = calle;
/*     */   }
/*     */ 
/*     */   public String getCalle() {
/*  79 */     return this.calle;
/*     */   }
/*     */ 
/*     */   public void setNumero(String numero) {
/*  83 */     this.numero = numero;
/*     */   }
/*     */ 
/*     */   public String getNumero() {
/*  87 */     return this.numero;
/*     */   }
/*     */ 
/*     */   public void setTipoDocumento(TipoDocumento tipo) {
/*  91 */     this.tipoDocumento = tipo;
/*     */   }
/*     */ 
/*     */   public TipoDocumento getTipoDocumento() {
/*  95 */     return this.tipoDocumento;
/*     */   }
/*     */ 
/*     */   public void setCiudad(String ciudad) {
/*  99 */     this.ciudad = ciudad;
/*     */   }
/*     */ 
/*     */   public String getCiudad() {
/* 103 */     return this.ciudad;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 107 */     return getApellido() + " " + getNombre();
/*     */   }
/*     */ 
/*     */   public String getHistoriaClinica() {
/* 111 */     return this.historiaClinica;
/*     */   }
/*     */ 
/*     */   public void setHistoriaClinica(String historiaClinica) {
/* 115 */     this.historiaClinica = historiaClinica;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Persona
 * JD-Core Version:    0.6.0
 */