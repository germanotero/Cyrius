/*    */ package com.cyrius.turnos.gui.abms;
/*    */ 
/*    */ import com.cyrius.entities.Preparacion;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class PreparacionABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 25 */     builder.setColumnsCount(1);
/* 26 */     builder.addStringField("nombre").required();
/* 27 */     builder.addStringField("descripcion").required();
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 32 */     return new Dimension(550, 250);
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/* 40 */     gridBuilder.addColumn("nombre");
/* 41 */     gridBuilder.addColumn("descripcion");
/*    */   }
/*    */ 
/*    */   public Class getAbmObject()
/*    */   {
/* 49 */     return Preparacion.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.abms.PreparacionABMFactory
 * JD-Core Version:    0.6.0
 */