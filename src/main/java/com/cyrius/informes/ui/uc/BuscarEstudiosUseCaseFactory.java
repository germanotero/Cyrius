/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.informes.ui.targets.VerEstudiosTarget;
/*    */ import com.cyrius.searchers.BuscadorPersona;
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.impl.MessageBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ 
/*    */ public class BuscarEstudiosUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 24 */     builder.addPanel(new AbstractPanel()
/*    */     {
/*    */       public void registerElements(FormElementsBuilder builder) {
/* 27 */         builder.addGroup(BuscarEstudiosGroup.class);
/*    */ 
/* 29 */         FormGridBuilder grid = builder.addGrid(
/* 30 */           BuscadorPersona.getInstance(), "findByNombreApellido", new String[] { 
/* 31 */           "nombre", "apellido" });
/* 32 */         grid.addColumn("nombre");
/* 33 */         grid.addColumn("apellido");
/* 34 */         grid.addColumn("documento");
/* 35 */         grid.addRowAction(
/* 37 */           new OpenUseCaseAction(VerEstudiosPersonaUseCaseFactory.class, 
/* 37 */           VerEstudiosTarget.class));
/* 38 */         grid.setOnEmptyExceptionMessage("no.se.encontraron.personas")
/* 39 */           .addValue("nombre", "nombre").addValue("apellido", 
/* 40 */           "apellido");
/*    */       }
/*    */ 
/*    */       public void registerActions(FormActionBuilder builder) {
/* 44 */         builder.addCancelUseCaseAction();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 52 */     return BuscarEstudiosModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.BuscarEstudiosUseCaseFactory
 * JD-Core Version:    0.6.0
 */