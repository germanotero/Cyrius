/*    */ package com.cyrius.turnos.gui.verTurno;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.cyrius.searchers.TipoDocumentoSearcher;
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import org.apache.commons.collections4.functors.TruePredicate;
/*    */ 
/*    */ public class VerDatosPersonaGroup extends AbstractGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 14 */     builder.setColumnsCount(1);
/* 15 */     builder.addStringField("nombre").setDisableOn(TruePredicate.INSTANCE);
/* 16 */     builder.addStringField("apellido").setDisableOn(TruePredicate.INSTANCE);
/* 17 */     builder.addNumberField("documento")
/* 18 */       .setDisableOn(TruePredicate.INSTANCE);
/* 19 */     builder.addCombo(TipoDocumentoSearcher.getInstance(), "findAll", 
/* 20 */       "tipoDocumento").setDisableOn(TruePredicate.INSTANCE);
/* 21 */     builder.addStringField("telefono").setDisableOn(TruePredicate.INSTANCE);
/* 22 */     builder.addStringField("calle").setDisableOn(TruePredicate.INSTANCE);
/* 23 */     builder.addStringField("numero").setDisableOn(TruePredicate.INSTANCE);
/* 24 */     builder.addStringField("ciudad").setDisableOn(TruePredicate.INSTANCE);
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 29 */     return Persona.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.VerDatosPersonaGroup
 * JD-Core Version:    0.6.0
 */