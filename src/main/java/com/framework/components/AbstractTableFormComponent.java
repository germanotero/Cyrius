/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.components.listeners.ModelTargetListener;
/*    */ import com.framework.components.listeners.NullModelTargetListener;
/*    */ import javax.swing.JTable;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public abstract class AbstractTableFormComponent extends JTable
/*    */   implements FormValueSelectionContainer
/*    */ {
/*    */   private Predicate notVisiblePredicate;
/* 20 */   private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();
/*    */ 
/*    */   public void initComponent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void addModelTargetListener(ModelTargetListener listener)
/*    */   {
/* 32 */     this.modelTargetListener = listener;
/*    */   }
/*    */ 
/*    */   public void impactModel(boolean validate)
/*    */   {
/* 39 */     this.modelTargetListener.unLoad(null);
/*    */   }
/*    */ 
/*    */   public void setValue(Object model)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void refreshComponent()
/*    */   {
/* 53 */     this.modelTargetListener.load(null);
/*    */   }
/*    */ 
/*    */   public FormComponent setNotVisibleOn(Predicate condition)
/*    */   {
/* 60 */     this.notVisiblePredicate = condition;
/* 61 */     return this;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.AbstractTableFormComponent
 * JD-Core Version:    0.6.0
 */