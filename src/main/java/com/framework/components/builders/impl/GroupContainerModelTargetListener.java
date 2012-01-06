/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.listeners.ModelTargetListener;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ class GroupContainerModelTargetListener
/*    */   implements ModelTargetListener
/*    */ {
/*    */   private AbstractGroup group;
/*    */ 
/*    */   public GroupContainerModelTargetListener(AbstractGroup group)
/*    */   {
/* 12 */     this.group = group;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model) {
/* 16 */     this.group.setModelo(this.group.getContainer().getModelo());
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.GroupContainerModelTargetListener
 * JD-Core Version:    0.6.0
 */