/*    */ package com.cyrius.turnos.gui.persona;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class DatosMedicoGroup extends DatosPersonaGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 10 */     super.registerGroupElements(builder);
/* 11 */     builder.addNumberField("matricula").required();
/* 12 */     builder.addStringField("telCel");
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 17 */     return Medico.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.persona.DatosMedicoGroup
 * JD-Core Version:    0.6.0
 */