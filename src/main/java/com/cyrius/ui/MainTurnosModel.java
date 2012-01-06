/*    */ package com.cyrius.ui;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class MainTurnosModel
/*    */ {
/*    */   private Medico medico;
/*    */ 
/*    */   public Medico getMedico()
/*    */   {
/* 18 */     return this.medico;
/*    */   }
/*    */ 
/*    */   public void setMedico(Medico medico) {
/* 22 */     this.medico = medico;
/*    */   }
/*    */ 
/*    */   public Collection getTurnos() {
/* 26 */     return CollectionFactory.createCollection();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.MainTurnosModel
 * JD-Core Version:    0.6.0
 */