/*    */ package com.cyrius.turnos.gui.persona;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.cyrius.searchers.TipoDocumentoSearcher;
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class DatosPersonaGroup extends AbstractGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 12 */     builder.setColumnsCount(1);
/* 13 */     builder.addStringField("nombre").required();
/* 14 */     builder.addStringField("apellido").required();
/* 15 */     builder.addNumberField("documento");
/* 16 */     builder.addCombo(TipoDocumentoSearcher.getInstance(), "findAll", 
/* 17 */       "tipoDocumento");
/* 18 */     builder.addStringField("telefono");
/* 19 */     builder.addStringField("calle");
/* 20 */     builder.addStringField("numero");
/* 21 */     builder.addStringField("ciudad");
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 26 */     return Persona.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.persona.DatosPersonaGroup
 * JD-Core Version:    0.6.0
 */