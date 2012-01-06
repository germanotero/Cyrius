/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.components.Combo;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ import java.awt.event.ItemEvent;
/*    */ 
/*    */ public class ComboListener extends AbstractItemListener
/*    */ {
/*    */   private Combo combo;
/*    */   private String modelProperty;
/*    */   private RefreshableComponent impl;
/*    */ 
/*    */   public ComboListener(RefreshableComponent component, Combo combo, String modelProperty)
/*    */   {
/* 18 */     this.impl = component;
/* 19 */     this.combo = combo;
/* 20 */     this.modelProperty = modelProperty;
/*    */   }
/*    */ 
/*    */   public ComboListener(RefreshableComponent component, Combo combo) {
/* 24 */     this.impl = component;
/* 25 */     this.combo = combo;
/*    */   }
/*    */ 
/*    */   public void itemStateChanged(ItemEvent e)
/*    */   {
/* 32 */     Object selectedItem = this.combo.getSelectedItem();
/* 33 */     if (this.modelProperty != null)
/* 34 */       this.impl.getModelo().setProperty(this.modelProperty, selectedItem);
/*    */     else {
/* 36 */       this.impl.setModelo(FormModelUtils.wrap(this.combo.getSelectedItem()));
/*    */     }
/* 38 */     super.itemStateChanged(e);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.ComboListener
 * JD-Core Version:    0.6.0
 */