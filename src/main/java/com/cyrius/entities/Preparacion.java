/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ 
/*    */ public class Preparacion
/*    */   implements PersistibleObject
/*    */ {
/*    */   protected Long id;
/*    */   protected String nombre;
/*    */   protected String descripcion;
/*    */ 
/*    */   public String getDescripcion()
/*    */   {
/* 28 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public void setDescripcion(String descripcion)
/*    */   {
/* 36 */     this.descripcion = descripcion;
/*    */   }
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 43 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id)
/*    */   {
/* 51 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getNombre()
/*    */   {
/* 58 */     return this.nombre;
/*    */   }
/*    */ 
/*    */   public void setNombre(String nombre)
/*    */   {
/* 66 */     this.nombre = nombre;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 70 */     return getNombre();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 75 */     if (!(obj instanceof Preparacion)) {
/* 76 */       return false;
/*    */     }
/* 78 */     Preparacion that = (Preparacion)obj;
/* 79 */     return that.getId().equals(getId());
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Preparacion
 * JD-Core Version:    0.6.0
 */