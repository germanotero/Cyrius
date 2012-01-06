/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.cyrius.utils.PracticaVisitor;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public abstract class Practica
/*    */   implements PersistibleObject
/*    */ {
/*    */   private Long id;
/* 25 */   private Collection<Medico> medicos = CollectionFactory.createCollection(Medico.class);
/*    */   private String description;
/*    */   private Preparacion preparacion;
/* 31 */   private Collection estudios = CollectionFactory.createCollection();
/*    */ 
/*    */   public String getDescription() {
/* 34 */     return this.description;
/*    */   }
/*    */ 
/*    */   public Long getId() {
/* 38 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 42 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public Preparacion getPreparacion() {
/* 46 */     return this.preparacion;
/*    */   }
/*    */ 
/*    */   public void setPreparacion(Preparacion preparacion) {
/* 50 */     this.preparacion = preparacion;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 54 */     if (this.description != null)
/* 55 */       return getDescription();
/* 56 */     return super.toString();
/*    */   }
/*    */ 
/*    */   public Collection getEstudios() {
/* 60 */     return this.estudios;
/*    */   }
/*    */ 
/*    */   public Collection<Medico> getMedicos() {
/* 64 */     return this.medicos;
/*    */   }
/*    */ 
/*    */   public void setMedicos(Collection<Medico> medicos) {
/* 68 */     this.medicos = medicos;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 72 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public void setEstudios(Collection estudios) {
/* 76 */     this.estudios = estudios;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 81 */     if (this.id == null)
/* 82 */       return this == obj;
/* 83 */     if ((obj instanceof Practica)) {
/* 84 */       Practica pr = (Practica)obj;
/* 85 */       return (getId().equals(pr.getId())) && (
/* 86 */         getDescription() != null ? 
/* 86 */         getDescription().equals(
/* 87 */         pr.getDescription()) : 
/* 87 */         pr.getDescription() == null);
/*    */     }
/*    */ 
/* 94 */     return false;
/*    */   }
/*    */ 
/*    */   public abstract void accept(PracticaVisitor paramPracticaVisitor);
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Practica
 * JD-Core Version:    0.6.0
 */