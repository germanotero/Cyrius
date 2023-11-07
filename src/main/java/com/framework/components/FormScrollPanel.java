/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ public abstract class FormScrollPanel extends JScrollPane
/*     */   implements FormValueSelectionContainer
/*     */ {
/*     */   private ModelTargetListener modelTargetListener;
/*     */   private Object model;
/*     */   private Predicate visibleCondition;
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  39 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  47 */     if (hasModelTargetListener())
/*  48 */       this.modelTargetListener.unLoad(null);
/*     */   }
/*     */ 
/*     */   private boolean hasModelTargetListener()
/*     */   {
/*  53 */     return this.modelTargetListener != null;
/*     */   }
/*     */ 
/*     */   public void setValue(Object model)
/*     */   {
/*  61 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public Object getValor() {
/*  65 */     return this.model;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  73 */     if (hasModelTargetListener())
/*  74 */       this.modelTargetListener.load(null);
/*  75 */     if (hasVisibleCondition())
/*  76 */       this.visibleCondition.evaluate(this.model);
/*     */   }
/*     */ 
/*     */   public boolean hasVisibleCondition()
/*     */   {
/*  84 */     return this.visibleCondition != null;
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/*  92 */     this.visibleCondition = condition;
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   public void setFull()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setNotFull()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormScrollPanel
 * JD-Core Version:    0.6.0
 */