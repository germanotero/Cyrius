/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.components.FormValueSelectionContainer;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class FormValueSelectionContainerListener
/*    */   implements ModelTargetListener
/*    */ {
/*    */   private FormValueSelectionContainer field;
/*    */   private String modelProperty;
/*    */   private RefreshableComponent modelEnable;
/*    */ 
/*    */   public FormValueSelectionContainerListener(RefreshableComponent modelEnable, String modelProperty, FormValueSelectionContainer field)
/*    */   {
/* 17 */     this.modelEnable = modelEnable;
/* 18 */     this.modelProperty = modelProperty;
/* 19 */     this.field = field;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model)
/*    */   {
/* 27 */     FormModel property = this.modelEnable.getModelo().getProperty(this.modelProperty);
/* 28 */     if (property != null)
/* 29 */       this.field.setValue(property.getValue());
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/* 37 */     Object valor = this.field.getValor();
/* 38 */     this.modelEnable.getModelo().setProperty(this.modelProperty, valor);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.FormValueSelectionContainerListener
 * JD-Core Version:    0.6.0
 */