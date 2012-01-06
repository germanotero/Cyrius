/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ import java.sql.Timestamp;
/*    */ 
/*    */ public class Recordatorio
/*    */   implements PersistibleObject
/*    */ {
/*    */   private Long id;
/*    */   private Timestamp fecha;
/*    */   private String mensaje;
/*    */ 
/*    */   public Timestamp getFecha()
/*    */   {
/* 26 */     return this.fecha;
/*    */   }
/*    */ 
/*    */   public void setFecha(Timestamp fecha) {
/* 30 */     this.fecha = fecha;
/*    */   }
/*    */ 
/*    */   public Long getId() {
/* 34 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 38 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getMensaje() {
/* 42 */     return this.mensaje;
/*    */   }
/*    */ 
/*    */   public void setMensaje(String mensaje) {
/* 46 */     this.mensaje = mensaje;
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.Recordatorio
 * JD-Core Version:    0.6.0
 */