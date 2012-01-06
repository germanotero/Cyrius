/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscarEstudiosModel
/*    */ {
/*  9 */   private String nombre = "";
/*    */ 
/* 11 */   private String apellido = "";
/*    */   private Persona persona;
/* 15 */   private Collection informes = CollectionFactory.createCollection();
/*    */ 
/*    */   public String getApellido()
/*    */   {
/* 22 */     return this.apellido;
/*    */   }
/*    */ 
/*    */   public void setApellido(String apellido) {
/* 26 */     this.apellido = apellido;
/*    */   }
/*    */ 
/*    */   public String getNombre() {
/* 30 */     return this.nombre;
/*    */   }
/*    */ 
/*    */   public void setNombre(String nombre) {
/* 34 */     this.nombre = nombre;
/*    */   }
/*    */ 
/*    */   public Collection getInformes() {
/* 38 */     return this.informes;
/*    */   }
/*    */ 
/*    */   public void setInformes(Collection informes) {
/* 42 */     this.informes = informes;
/*    */   }
/*    */ 
/*    */   public Persona getPersona() {
/* 46 */     return this.persona;
/*    */   }
/*    */ 
/*    */   public void setPersona(Persona persona) {
/* 50 */     this.persona = persona;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.BuscarEstudiosModel
 * JD-Core Version:    0.6.0
 */