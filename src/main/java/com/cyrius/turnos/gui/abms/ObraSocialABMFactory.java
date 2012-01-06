/*    */ package com.cyrius.turnos.gui.abms;
/*    */ 
/*    */ import com.cyrius.entities.ObraSocial;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class ObraSocialABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 14 */     builder.addStringField("codigo");
/* 15 */     builder.addStringField("descripcion");
/* 16 */     builder.addDoubleField("galCosto");
/* 17 */     builder.addDoubleField("galHono");
/* 18 */     builder.addDoubleField("arancel");
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/* 23 */     gridBuilder.addColumn("codigo");
/* 24 */     gridBuilder.addColumn("descripcion");
/* 25 */     gridBuilder.addColumn("galCosto");
/* 26 */     gridBuilder.addColumn("galHono");
/* 27 */     gridBuilder.addColumn("arancel");
/*    */   }
/*    */ 
/*    */   protected Dimension setEditUseCaseDimension()
/*    */   {
/* 32 */     return new Dimension(600, 200);
/*    */   }
/*    */ 
/*    */   public Class getAbmObject()
/*    */   {
/* 37 */     return ObraSocial.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.abms.ObraSocialABMFactory
 * JD-Core Version:    0.6.0
 */