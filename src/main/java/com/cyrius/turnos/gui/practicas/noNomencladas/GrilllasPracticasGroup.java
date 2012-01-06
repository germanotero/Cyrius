/*    */ package com.cyrius.turnos.gui.practicas.noNomencladas;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.TableColumnBuilder;
/*    */ 
/*    */ public class GrilllasPracticasGroup extends AbstractGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 18 */     FormGridBuilder grillaMedicos = builder.addGrid(Medico.class);
/* 19 */     grillaMedicos.addColumn("nombre");
/* 20 */     grillaMedicos.addColumn("apellido");
/* 21 */     grillaMedicos.addRowSelector("medicos");
/* 22 */     grillaMedicos.setOneColumnGrid();
/*    */ 
/* 24 */     FormGridBuilder grillaObras = builder
/* 25 */       .addGrid("relacionObraSocialCodigoCosto");
/* 26 */     grillaObras.addColumn("obraSocial");
/* 27 */     grillaObras.addColumn("codigo").setEditable(true);
/* 28 */     grillaObras.setOneColumnGrid();
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 34 */     throw new UnsupportedOperationException(
/* 35 */       "Revisarme, tiene que tener un modelo este grupo?");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.noNomencladas.GrilllasPracticasGroup
 * JD-Core Version:    0.6.0
 */