/*    */ package com.cyrius.turnos.gui.verTurno;
/*    */ 
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.cyrius.providers.Practicas4MedicosProvider;
/*    */ import com.cyrius.searchers.BuscadorMedicos;
/*    */ import com.cyrius.turnos.gui.persona.DatosPersonaGroup;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.builders.interfaces.CheckBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.models.FormModel;
/*    */ import org.apache.commons.collections4.functors.TruePredicate;
/*    */ 
/*    */ public class AsistioPanelFactory extends AbstractPanel
/*    */ {
/*    */   protected boolean withScrollPanel()
/*    */   {
/* 16 */     return true;
/*    */   }
/*    */ 
/*    */   public void registerElements(FormElementsBuilder builder) {
/* 20 */     builder.addCheckBox("asistio").setInitialState(Boolean.TRUE);
/* 21 */     builder.addCheckBox("arancelD");
/* 22 */     builder.addCheckBox("bono");
/* 23 */     builder.addCheckBox("firmaPlanilla");
/* 24 */     builder.addDoubleField("monto");
/* 25 */     builder.addCombo(
/* 26 */       new Practicas4MedicosProvider(((Turno)
/* 26 */       getModelo().getValue()).getMedico()), "practica");
/* 27 */     builder.addCombo(new BuscadorMedicos(), "findAll", "medico")
/* 28 */       .setDisableOn(TruePredicate.INSTANCE);
/* 29 */     builder.addCombo("medico.obrasSociales", "obraSocial");
/* 30 */     builder.addGroup(DatosPersonaGroup.class, "paciente");
/* 31 */     builder.addTextArea("observaciones");
/*    */   }
/*    */ 
/*    */   public final void registerActions(FormActionBuilder builder)
/*    */   {
/* 38 */     builder.addFinalizeUseCaseAction();
/* 39 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.AsistioPanelFactory
 * JD-Core Version:    0.6.0
 */