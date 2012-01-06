/*    */ package com.cyrius.turnos.gui.abms;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.searchers.ObraSocialSearcher;
/*    */ import com.cyrius.turnos.gui.persona.DatosMedicoGroup;
/*    */ import com.cyrius.turnos.gui.persona.PanelHorarioGroup;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.GroupBuilder;
/*    */ 
/*    */ public class MedicoABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 15 */     builder.addGroup(DatosMedicoGroup.class).setNotOneColumnComponent();
/* 16 */     FormGridBuilder grid = builder.addGrid(new ObraSocialSearcher(), "findAll");
/* 17 */     grid.setOneColumnGrid();
/* 18 */     grid.addRowSelector("obrasSociales");
/* 19 */     grid.addColumn("descripcion");
/* 20 */     grid.addColumn("codigo");
/* 21 */     builder.addGroup(PanelHorarioGroup.class);
/*    */   }
/*    */ 
/*    */   public Class getNewActionTargetDecorator()
/*    */   {
/* 26 */     return NuevoMedicoTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   public Class getEditRowTargetDecorator()
/*    */   {
/* 31 */     return EditMedicoTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/* 36 */     gridBuilder.addColumn("nombre");
/* 37 */     gridBuilder.addColumn("apellido");
/*    */   }
/*    */ 
/*    */   protected Class getAbmObject()
/*    */   {
/* 42 */     return Medico.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.abms.MedicoABMFactory
 * JD-Core Version:    0.6.0
 */