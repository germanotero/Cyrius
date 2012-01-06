/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.entities.ComboElement;
/*    */ import com.framework.dynamicForms.forms.ComboElementPanelFactory;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class ComboElementUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 14 */     builder.addPanel(new ComboElementPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel() {
/* 18 */     return ComboElement.class;
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 23 */     return new Dimension(500, 300);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.ComboElementUseCaseFactory
 * JD-Core Version:    0.6.0
 */