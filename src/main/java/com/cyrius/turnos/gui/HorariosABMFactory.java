/*    */ package com.cyrius.turnos.gui;
/*    */ 
/*    */ import com.cyrius.entities.RangoHorario;
/*    */ import com.framework.abstractfactorys.ABMUseCaseFactory;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class HorariosABMFactory extends ABMUseCaseFactory
/*    */ {
/*    */   public Class getAbmObject()
/*    */   {
/* 12 */     return RangoHorario.class;
/*    */   }
/*    */ 
/*    */   protected void addEditElements(FormElementsBuilder builder)
/*    */   {
/* 17 */     builder.setColumnsCount(1);
/* 18 */     builder.addCheckBox("manana");
/* 19 */     builder.addTimeBox("horaInicio");
/* 20 */     builder.addTimeBox("horaFin");
/* 21 */     builder.addCalendarBox("fechaInicio");
/* 22 */     builder.addCalendarBox("fechaFin");
/* 23 */     builder.addNumberField("minutos");
/*    */   }
/*    */ 
/*    */   protected void addGridColumns(FormGridBuilder gridBuilder)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.HorariosABMFactory
 * JD-Core Version:    0.6.0
 */