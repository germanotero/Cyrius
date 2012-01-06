/*    */ package com.cyrius.turnos.gui.persona;
/*    */ 
/*    */ import com.cyrius.ui.components.PanelHorario;
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class PanelHorarioGroup extends AbstractGroup
/*    */ {
/*    */   public PanelHorarioGroup()
/*    */   {
/* 16 */     setMinimumSize(new Dimension(200, 130));
/*    */   }
/*    */ 
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 21 */     builder.addComponent(new PanelHorario(), "horarios", "0 + 4 2");
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 26 */     throw new UnsupportedOperationException(
/* 27 */       "Revisarme, tiene que tener un modelo este grupo?");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.persona.PanelHorarioGroup
 * JD-Core Version:    0.6.0
 */