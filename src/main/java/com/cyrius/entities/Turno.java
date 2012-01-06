/*     */ package com.cyrius.entities;
/*     */ 
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Turno
/*     */   implements PersistibleObject
/*     */ {
/*     */   private Long id;
/*     */   private Date hora;
/*     */   private Persona paciente;
/*     */   private Medico medico;
/*     */   private Practica practica;
/*     */   private ObraSocial obraSocial;
/*     */   private Integer consultorio;
/*     */   private String observaciones;
/*     */   private Double monto;
/*     */   private String nroAfiliado;
/*  41 */   private Boolean asistio = Boolean.FALSE;
/*     */ 
/*  43 */   private Boolean bono = Boolean.FALSE;
/*     */ 
/*  45 */   private Boolean arancelD = Boolean.FALSE;
/*     */ 
/*  47 */   private Boolean realizado = Boolean.FALSE;
/*     */ 
/*  49 */   private Boolean firmaPlanilla = Boolean.FALSE;
/*     */ 
/*     */   public Boolean getFirmaPlanilla() {
/*  52 */     return this.firmaPlanilla;
/*     */   }
/*     */ 
/*     */   public void setFirmaPlanilla(Boolean firmaPlanilla) {
/*  56 */     this.firmaPlanilla = firmaPlanilla;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  60 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  64 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  68 */     return this.paciente.getNombre() + " " + this.paciente.getApellido() + 
/*  69 */       " - Prac: " + this.practica;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  73 */     return toString();
/*     */   }
/*     */ 
/*     */   public void setDescription(String nul)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Boolean getArancelD() {
/*  81 */     return this.arancelD;
/*     */   }
/*     */ 
/*     */   public void setArancelD(Boolean arancelD) {
/*  85 */     this.arancelD = arancelD;
/*     */   }
/*     */ 
/*     */   public Boolean getAsistio() {
/*  89 */     return this.asistio;
/*     */   }
/*     */ 
/*     */   public void setAsistio(Boolean asistio) {
/*  93 */     this.asistio = asistio;
/*     */   }
/*     */ 
/*     */   public Boolean getBono() {
/*  97 */     return this.bono;
/*     */   }
/*     */ 
/*     */   public void setBono(Boolean bono) {
/* 101 */     this.bono = bono;
/*     */   }
/*     */ 
/*     */   public ObraSocial getObraSocial() {
/* 105 */     return this.obraSocial;
/*     */   }
/*     */ 
/*     */   public void setObraSocial(ObraSocial obraSocial) {
/* 109 */     this.obraSocial = obraSocial;
/*     */   }
/*     */ 
/*     */   public Integer getConsultorio() {
/* 113 */     return this.consultorio;
/*     */   }
/*     */ 
/*     */   public void setConsultorio(Integer consultorio) {
/* 117 */     this.consultorio = consultorio;
/*     */   }
/*     */ 
/*     */   public Date getHora() {
/* 121 */     return this.hora;
/*     */   }
/*     */ 
/*     */   public void setHora(Date hora) {
/* 125 */     this.hora = hora;
/*     */   }
/*     */ 
/*     */   public Medico getMedico() {
/* 129 */     return this.medico;
/*     */   }
/*     */ 
/*     */   public void setMedico(Medico medico) {
/* 133 */     this.medico = medico;
/*     */   }
/*     */ 
/*     */   public Double getMonto() {
/* 137 */     return this.monto;
/*     */   }
/*     */ 
/*     */   public void setMonto(Double monto) {
/* 141 */     this.monto = monto;
/*     */   }
/*     */ 
/*     */   public String getNroAfiliado() {
/* 145 */     return this.nroAfiliado;
/*     */   }
/*     */ 
/*     */   public void setNroAfiliado(String nroAfiliado) {
/* 149 */     this.nroAfiliado = nroAfiliado;
/*     */   }
/*     */ 
/*     */   public String getObservaciones() {
/* 153 */     return this.observaciones;
/*     */   }
/*     */ 
/*     */   public void setObservaciones(String observaciones) {
/* 157 */     this.observaciones = observaciones;
/*     */   }
/*     */ 
/*     */   public Persona getPaciente() {
/* 161 */     return this.paciente;
/*     */   }
/*     */ 
/*     */   public void setPaciente(Persona paciente) {
/* 165 */     this.paciente = paciente;
/*     */   }
/*     */ 
/*     */   public Practica getPractica() {
/* 169 */     return this.practica;
/*     */   }
/*     */ 
/*     */   public void setPractica(Practica practica) {
/* 173 */     this.practica = practica;
/*     */   }
/*     */ 
/*     */   public Boolean getRealizado() {
/* 177 */     return this.realizado;
/*     */   }
/*     */ 
/*     */   public void setRealizado(Boolean realizo) {
/* 181 */     this.realizado = realizo;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Turno
 * JD-Core Version:    0.6.0
 */