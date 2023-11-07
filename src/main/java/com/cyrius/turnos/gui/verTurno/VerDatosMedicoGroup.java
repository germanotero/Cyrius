/*    */ package com.cyrius.turnos.gui.verTurno;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import org.apache.commons.collections4.functors.TruePredicate;
/*    */ 
/*    */ public class VerDatosMedicoGroup extends VerDatosPersonaGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 12 */     super.registerGroupElements(builder);
/* 13 */     builder.addNumberField("matricula")
/* 14 */       .setDisableOn(TruePredicate.INSTANCE);
/* 15 */     builder.addStringField("telCel").setDisableOn(TruePredicate.INSTANCE);
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 20 */     return Medico.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.VerDatosMedicoGroup
 * JD-Core Version:    0.6.0
 */