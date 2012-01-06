/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.ModelEnableComponent;
/*    */ import com.framework.components.listeners.ModelTargetListener;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ModelUtils;
/*    */ 
/*    */ class GroupModelTargetListener
/*    */   implements ModelTargetListener
/*    */ {
/*    */   private AbstractGroup group;
/*    */   private String targetProperty;
/*    */   private ModelEnableComponent parent;
/*    */ 
/*    */   public GroupModelTargetListener(ModelEnableComponent parent, AbstractGroup group, String targetProperty)
/*    */   {
/* 24 */     this.group = group;
/* 25 */     this.targetProperty = targetProperty;
/* 26 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model)
/*    */   {
/* 34 */     FormModel nestedProperty = ModelUtils.getNestedProperty(this.parent
/* 35 */       .getModelo(), this.targetProperty);
/* 36 */     this.group.setModelo(nestedProperty);
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/* 44 */     ModelUtils.setNestedProperty(this.parent.getModelo(), this.targetProperty, 
/* 45 */       this.group.getModelo());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.GroupModelTargetListener
 * JD-Core Version:    0.6.0
 */