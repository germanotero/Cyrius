/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.informes.models.MainInformesModel;
/*    */ import com.cyrius.informes.ui.panels.MainInformesPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.interfaces.MenuBarBuilder;
/*    */ import com.framework.components.builders.interfaces.MenuBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.uc.DynamicFormComboUseCaseFactory;
/*    */ import com.framework.dynamicForms.uc.DynamicFormElementsUseCaseFactory;
/*    */ import com.framework.dynamicForms.uc.DynamicFormsUseCaseFactory;
/*    */ import com.framework.dynamicForms.uc.DynamicGroupsUseCaseFactory;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class MainInformesUseCase extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 28 */     builder.addPanel(new MainInformesPanel());
/*    */   }
/*    */ 
/*    */   protected void addMenuBar(MenuBarBuilder builder)
/*    */   {
/* 35 */     MenuBuilder menuFormularios = builder.addMenu("ABM_Informes");
/* 36 */     menuFormularios.addMenuItem(
/* 37 */       new OpenUseCaseAction(DynamicFormsUseCaseFactory.class));
/* 38 */     MenuBuilder administradores = menuFormularios
/* 39 */       .addSubMenu("administradores");
/* 40 */     administradores.addMenuItem(
/* 41 */       new OpenUseCaseAction(DynamicFormElementsUseCaseFactory.class));
/* 42 */     administradores.addMenuItem(
/* 43 */       new OpenUseCaseAction(DynamicGroupsUseCaseFactory.class));
/* 44 */     administradores.addMenuItem(
/* 45 */       new OpenUseCaseAction(DynamicFormComboUseCaseFactory.class));
/* 46 */     MenuBuilder menuEstudios = builder.addMenu("EstudiosRealizados");
/* 47 */     menuEstudios.addMenuItem(
/* 48 */       new OpenUseCaseAction(BuscarEstudiosUseCaseFactory.class));
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 55 */     return new Dimension(800, 600);
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 62 */     return MainInformesModel.class;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.MainInformesUseCase
 * JD-Core Version:    0.6.0
 */