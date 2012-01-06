/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.ModelEnableElementsContainer;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.listeners.ModelTargetListener;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ClassUtils;
/*    */ import java.util.List;
/*    */ 
/*    */ public class MultliplicableGroupBuilderImpl extends GroupBuilderImpl
/*    */ {
/*    */   private int listModelPosition;
/*    */ 
/*    */   public MultliplicableGroupBuilderImpl(Class<AbstractGroup> groupClass, ModelEnableElementsContainer container, int listModelPosition)
/*    */   {
/* 28 */     super(groupClass, "", container);
/* 29 */     this.listModelPosition = listModelPosition;
/*    */   }
/*    */ 
/*    */   public MultliplicableGroupBuilderImpl()
/*    */   {
/*    */   }
/*    */ 
/*    */   public MultliplicableGroupBuilderImpl withListModelIndex(int listModelPosition)
/*    */   {
/* 38 */     this.listModelPosition = listModelPosition;
/* 39 */     return this;
/*    */   }
/*    */ 
/*    */   protected AbstractGroup getGroupInstance(Class groupClass)
/*    */   {
/* 45 */     return (AbstractGroup)ClassUtils.newInstance(groupClass);
/*    */   }
/*    */ 
/*    */   protected ModelTargetListener getModelTargetListener(AbstractGroup group)
/*    */   {
/* 52 */     return new MultiplicableGroupModelTargetListener(group, 
/* 53 */       this.listModelPosition);
/*    */   }
/*    */ 
/*    */   private class MultiplicableGroupModelTargetListener
/*    */     implements ModelTargetListener
/*    */   {
/*    */     private AbstractGroup group;
/*    */     private int listModelPosition;
/*    */ 
/*    */     public MultiplicableGroupModelTargetListener(AbstractGroup group, int listModelPosition)
/*    */     {
/* 66 */       this.group = group;
/* 67 */       this.listModelPosition = listModelPosition;
/*    */     }
/*    */ 
/*    */     public void load(FormModel model)
/*    */     {
/* 74 */       List modelsList = (List)this.group.getContainer().getModelo()
/* 75 */         .getValue();
/* 76 */       if (modelsList.size() <= this.listModelPosition)
/* 77 */         this.group.setModelo(null);
/*    */       else
/* 79 */         this.group.setModelo((FormModel)modelsList.get(this.listModelPosition));
/*    */     }
/*    */ 
/*    */     public void unLoad(FormModel formModel)
/*    */     {
/* 87 */       List modelsList = (List)this.group.getContainer()
/* 88 */         .getModelo().getValue();
/* 89 */       if (modelsList.size() <= this.listModelPosition)
/* 90 */         modelsList.add(this.group.getModelo());
/*    */       else
/* 92 */         modelsList.set(this.listModelPosition, this.group.getModelo());
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.MultliplicableGroupBuilderImpl
 * JD-Core Version:    0.6.0
 */