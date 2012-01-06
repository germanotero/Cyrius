/*    */ package com.cyrius.turnos.gui.verTurno;
/*    */ 
/*    */ import com.cyrius.searchers.BuscadorPracticas;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.CheckBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import org.apache.commons.collections.functors.TruePredicate;
/*    */ 
/*    */ public class VerAsistioPanelFactory extends AbstractPanel
/*    */ {
/*    */   protected boolean withScrollPanel()
/*    */   {
/* 13 */     return true;
/*    */   }
/*    */ 
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 18 */     builder.addCheckBox("asistio").setDisableOn(TruePredicate.INSTANCE);
/* 19 */     builder.addCombo(new BuscadorPracticas(), "findAll", "practica")
/* 20 */       .setDisableOn(TruePredicate.INSTANCE);
/* 21 */     builder.addGroup(VerDatosMedicoGroup.class, "medico");
/* 22 */     builder.addGroup(VerDatosPersonaGroup.class, "paciente");
/* 23 */     builder.addTextArea("observaciones").setDisableOn(
/* 24 */       TruePredicate.INSTANCE);
/*    */   }
/*    */ 
/*    */   public final void registerActions(FormActionBuilder builder)
/*    */   {
/* 32 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.VerAsistioPanelFactory
 * JD-Core Version:    0.6.0
 */