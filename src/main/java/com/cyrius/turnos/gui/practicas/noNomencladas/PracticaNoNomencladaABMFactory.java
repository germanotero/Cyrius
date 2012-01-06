/*    */ package com.cyrius.turnos.gui.practicas.noNomencladas;
/*    */ 
/*    */ import com.cyrius.entities.PracticaNoNomenclada;
/*    */ import com.cyrius.entities.Preparacion;
/*    */ import com.cyrius.searchers.EstudiosSearcher;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.GroupBuilder;
/*    */ 
/*    */ public class PracticaNoNomencladaABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 15 */     builder.addStringField("description").required();
/*    */ 
/* 17 */     builder.addGroup(GrilllasPracticasGroup.class).withOutBorder();
/* 18 */     GroupBuilder grupoAbajo = builder.addGroup("NoBorder");
/* 19 */     grupoAbajo.withOutBorder();
/*    */ 
/* 21 */     FormGridBuilder grid = builder.addGrid(Preparacion.class);
/* 22 */     grid.addColumn("nombre");
/* 23 */     grid.addColumn("descripcion");
/* 24 */     grid.addSimpleRowSelectionMode("preparacion");
/*    */ 
/* 26 */     FormGridBuilder estudiosGrid = grupoAbajo.addGrid(
/* 27 */       EstudiosSearcher.getInstance(), "findAllSinPractica");
/* 28 */     estudiosGrid.addColumn("name");
/* 29 */     estudiosGrid.addColumn("description");
/* 30 */     estudiosGrid.addRowSelector("estudios");
/*    */   }
/*    */ 
/*    */   public Class getNewActionTargetDecorator()
/*    */   {
/* 36 */     return NuevaPracticaNoNomencladaTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   public Class getEditRowTargetDecorator()
/*    */   {
/* 41 */     return EditPracticaNoNomencladaTargetDecorator.class;
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/* 46 */     gridBuilder.addColumn("description");
/*    */   }
/*    */ 
/*    */   public Class getAbmObject()
/*    */   {
/* 52 */     return PracticaNoNomenclada.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.noNomencladas.PracticaNoNomencladaABMFactory
 * JD-Core Version:    0.6.0
 */