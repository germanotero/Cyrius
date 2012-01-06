/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.informes.ui.panels.TextoInformesPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ 
/*    */ public class TextoInformesUseCase extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 16 */     builder.addPanel(new TextoInformesPanel());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.TextoInformesUseCase
 * JD-Core Version:    0.6.0
 */