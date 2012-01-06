/*     */ package com.cyrius.entities;
/*     */ 
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class Medico extends Persona
/*     */ {
/*     */   private Integer matricula;
/*     */   private String telCel;
/*  28 */   private Collection<HorarioSemanal> horarios = CollectionFactory.createCollection(HorarioSemanal.class);
/*     */ 
/*  30 */   private Collection obrasSociales = CollectionFactory.createCollection();
/*     */ 
/*     */   public Collection getObrasSociales() {
/*  33 */     return this.obrasSociales;
/*     */   }
/*     */ 
/*     */   public void setObrasSociales(Collection obrasSociales) {
/*  37 */     this.obrasSociales = obrasSociales;
/*     */   }
/*     */ 
/*     */   public Collection<HorarioSemanal> getHorarios()
/*     */   {
/*  44 */     return this.horarios;
/*     */   }
/*     */ 
/*     */   public void setHorarios(Collection<HorarioSemanal> horarios)
/*     */   {
/*  52 */     this.horarios = horarios;
/*     */   }
/*     */ 
/*     */   public Integer getMatricula() {
/*  56 */     return this.matricula;
/*     */   }
/*     */ 
/*     */   public void setMatricula(Integer matricula) {
/*  60 */     this.matricula = matricula;
/*     */   }
/*     */ 
/*     */   public String getTelCel() {
/*  64 */     return this.telCel;
/*     */   }
/*     */ 
/*     */   public void setTelCel(String telCel) {
/*  68 */     this.telCel = telCel;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  72 */     return getNombre() + " " + getApellido();
/*     */   }
/*     */ 
/*     */   public boolean getAtiendeDeManana(Calendar dia)
/*     */   {
/*  77 */     Iterator it = this.horarios.iterator();
/*  78 */     boolean encontro = false;
/*  79 */     while ((it.hasNext()) && (!encontro)) {
/*  80 */       HorarioSemanal hs = (HorarioSemanal)it.next();
/*     */ 
/*  83 */       if ((dia.get(7) != hs.getDia().intValue() + 1) || 
/*  84 */         (!hs.getMomento().equalsIgnoreCase("m"))) continue;
/*  85 */       encontro = true;
/*     */     }
/*     */ 
/*  88 */     return encontro;
/*     */   }
/*     */ 
/*     */   public boolean getAtiendeDeTarde(Calendar dia)
/*     */   {
/*  93 */     Iterator it = this.horarios.iterator();
/*  94 */     boolean encontro = false;
/*  95 */     while ((it.hasNext()) && (!encontro)) {
/*  96 */       HorarioSemanal hs = (HorarioSemanal)it.next();
/*     */ 
/*  99 */       if ((dia.get(7) != hs.getDia().intValue() + 1) || 
/* 100 */         (!hs.getMomento().equalsIgnoreCase("t"))) continue;
/* 101 */       encontro = true;
/*     */     }
/*     */ 
/* 104 */     return encontro;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object o)
/*     */   {
/* 111 */     if (o == null)
/* 112 */       return false;
/* 113 */     if (!o.getClass().equals(getClass())) {
/* 114 */       return false;
/*     */     }
/* 116 */     if (o != null)
/* 117 */       return getMatricula().equals(((Medico)o).getMatricula());
/* 118 */     return false;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Medico
 * JD-Core Version:    0.6.0
 */