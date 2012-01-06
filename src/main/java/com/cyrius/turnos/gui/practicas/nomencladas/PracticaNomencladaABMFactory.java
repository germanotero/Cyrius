/*    */ package com.cyrius.turnos.gui.practicas.nomencladas;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.entities.PracticaNomenclada;
/*    */ import com.cyrius.entities.Preparacion;
/*    */ import com.cyrius.searchers.EstudiosSearcher;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class PracticaNomencladaABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 15 */     builder.addStringField("codigo").required();
/* 16 */     builder.addStringField("description").required();
/*    */ 
/* 18 */     builder.addDoubleField("cantGalenosHonorario").required();
/* 19 */     builder.addDoubleField("cantGalenosCosto").required();
/*    */ 
/* 21 */     FormGridBuilder grillaMedicos = builder.addGrid(Medico.class);
/* 22 */     grillaMedicos.addColumn("nombre");
/* 23 */     grillaMedicos.addColumn("apellido");
/* 24 */     grillaMedicos.addRowSelector("medicos");
/* 25 */     grillaMedicos.setOneColumnGrid();
/*    */ 
/* 27 */     FormGridBuilder grid = builder.addGrid(Preparacion.class);
/* 28 */     grid.addColumn("nombre");
/* 29 */     grid.addColumn("descripcion");
/* 30 */     grid.addSimpleRowSelectionMode("preparacion");
/* 31 */     grid.setOneColumnGrid();
/*    */ 
/* 33 */     FormGridBuilder estudiosGrid = builder.addGrid(
/* 34 */       EstudiosSearcher.getInstance(), "findAllSinPractica");
/* 35 */     estudiosGrid.addColumn("name");
/* 36 */     estudiosGrid.addColumn("description");
/* 37 */     estudiosGrid.addRowSelector("estudios");
/*    */   }
/*    */ 
/*    */   public Class getNewActionTargetDecorator()
/*    */   {
/* 42 */     return NuevaPracticaNomencladaTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   public Class getEditRowTargetDecorator()
/*    */   {
/* 47 */     return EditPracticaNomencladaTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/* 52 */     gridBuilder.addColumn("description");
/*    */   }
/*    */ 
/*    */   public Class getAbmObject()
/*    */   {
/* 58 */     return PracticaNomenclada.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.nomencladas.PracticaNomencladaABMFactory
 * JD-Core Version:    0.6.0
 */