/*    */ package com.framework.dynamicForms.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.entities.SimpleDynamicFormElement;
/*    */ import com.framework.dynamicForms.forms.SimpleDynamicFormElementPanelFactory;
/*    */ import java.awt.Dimension;
/*    */ 
/*    */ public class SimpleDynamicFormElementUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   public void registerFactorys(UseCaseBuilder builder)
/*    */   {
/* 20 */     builder.addPanel(new SimpleDynamicFormElementPanelFactory());
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel()
/*    */   {
/* 27 */     return SimpleDynamicFormElement.class;
/*    */   }
/*    */ 
/*    */   protected Dimension setUseCaseDimension()
/*    */   {
/* 32 */     return new Dimension(500, 200);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.SimpleDynamicFormElementUseCaseFactory
 * JD-Core Version:    0.6.0
 */