/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ 
/*    */ public class TipoDocumento
/*    */   implements PersistibleObject
/*    */ {
/*    */   private Long id;
/*    */   private String descripcion;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 18 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 22 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getDescripcion() {
/* 26 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public void setDescripcion(String nombre) {
/* 30 */     this.descripcion = nombre;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 35 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 40 */     if (!(obj instanceof TipoDocumento))
/* 41 */       return false;
/* 42 */     TipoDocumento that = (TipoDocumento)obj;
/* 43 */     if (getId() == null)
/* 44 */       return super.equals(that);
/* 45 */     return getId().equals(that.getId());
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.TipoDocumento
 * JD-Core Version:    0.6.0
 */