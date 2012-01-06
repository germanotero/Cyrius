/*    */ package com.cyrius.informes.ui.panels;
/*    */ 
/*    */ import com.cyrius.informes.StartInformeTargetDecorator;
/*    */ import com.cyrius.informes.ui.StartInformeUseCase;
/*    */ import com.cyrius.searchers.BuscadorMedicos;
/*    */ import com.cyrius.searchers.BuscadorTurnos;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.impl.MessageBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class MainInformesPanel extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 23 */     FormComboBoxBuilder comboBoxBuilder = builder.addCombo(
/* 24 */       BuscadorMedicos.getInstance(), "findAll", "medicoSeleccionado");
/*    */ 
/* 26 */     FormGridBuilder gridBuilder = builder
/* 27 */       .addGrid(BuscadorTurnos.getInstance(), 
/* 28 */       "findByMedicoForInformes", "medicoSeleccionado");
/* 29 */     gridBuilder.setRefresh(10000L);
/* 30 */     gridBuilder.addDateColumn("hora", "HH:mm");
/* 31 */     gridBuilder.addColumn("description");
/* 32 */     gridBuilder.addColumn("obraSocial");
/* 33 */     gridBuilder.addComponentDependency(comboBoxBuilder);
/* 34 */     gridBuilder.setOnEmptyExceptionMessage("no.turnos.para.medico")
/* 35 */       .addValue("medico", "medicoSeleccionado");
/* 36 */     OpenUseCaseAction openUseCaseAction = new OpenUseCaseAction(
/* 37 */       StartInformeUseCase.class, StartInformeTargetDecorator.class);
/* 38 */     gridBuilder.addRowAction(openUseCaseAction);
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.panels.MainInformesPanel
 * JD-Core Version:    0.6.0
 */