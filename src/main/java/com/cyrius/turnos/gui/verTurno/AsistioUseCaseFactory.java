/*    */ package com.cyrius.turnos.gui.verTurno;
/*    */ 
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class AsistioUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 13 */     return new Dimension(750, 500);
/*    */   }
/*    */ 
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 18 */     builder.addPanel(new AsistioPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 23 */     return Turno.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.AsistioUseCaseFactory
 * JD-Core Version:    0.6.0
 */