/*    */ package com.cyrius.informes.models;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ 
/*    */ public class MainInformesModel
/*    */ {
/*    */   private String description;
/*    */   public Medico medicoSeleccionado;
/*    */ 
/*    */   public boolean isPersisted()
/*    */   {
/* 15 */     return false;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 19 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 23 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public Medico getMedicoSeleccionado() {
/* 27 */     return this.medicoSeleccionado;
/*    */   }
/*    */ 
/*    */   public void setMedicoSeleccionado(Medico medicoSeleccionado) {
/* 31 */     this.medicoSeleccionado = medicoSeleccionado;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.models.MainInformesModel
 * JD-Core Version:    0.6.0
 */