/*    */ package com.cyrius.informes.models;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class VerEstudiosPersonaModel
/*    */ {
/*    */   private Collection informes;
/*    */   private Persona persona;
/*    */ 
/*    */   public VerEstudiosPersonaModel(Persona persona, Collection informes)
/*    */   {
/* 13 */     this.informes = informes;
/* 14 */     this.persona = persona;
/*    */   }
/*    */ 
/*    */   public Collection getInformes() {
/* 18 */     return this.informes;
/*    */   }
/*    */ 
/*    */   public void setInformes(Collection informes) {
/* 22 */     this.informes = informes;
/*    */   }
/*    */ 
/*    */   public Persona getPersona() {
/* 26 */     return this.persona;
/*    */   }
/*    */ 
/*    */   public void setPersona(Persona persona) {
/* 30 */     this.persona = persona;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.models.VerEstudiosPersonaModel
 * JD-Core Version:    0.6.0
 */