/*    */ package com.cyrius.informes;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ 
/*    */ public class StartInformesModel
/*    */ {
/*    */   private Turno turno;
/*    */   private DynamicForm estudioSeleccionado;
/*    */   private Medico medicoRealizante;
/*    */ 
/*    */   public StartInformesModel(Turno turno)
/*    */   {
/* 22 */     this.turno = turno;
/* 23 */     this.medicoRealizante = turno.getMedico();
/*    */   }
/*    */ 
/*    */   public DynamicForm getEstudioSeleccionado() {
/* 27 */     return this.estudioSeleccionado;
/*    */   }
/*    */ 
/*    */   public void setEstudioSeleccionado(DynamicForm estudioSeleccionado) {
/* 31 */     this.estudioSeleccionado = estudioSeleccionado;
/*    */   }
/*    */ 
/*    */   public Turno getTurno() {
/* 35 */     return this.turno;
/*    */   }
/*    */ 
/*    */   public void setTurno(Turno turno) {
/* 39 */     this.turno = turno;
/*    */   }
/*    */ 
/*    */   public Medico getMedicoRealizante() {
/* 43 */     return this.medicoRealizante;
/*    */   }
/*    */ 
/*    */   public void setMedicoRealizante(Medico medicoSeleccionado) {
/* 47 */     this.medicoRealizante = medicoSeleccionado;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.StartInformesModel
 * JD-Core Version:    0.6.0
 */