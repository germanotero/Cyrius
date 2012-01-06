/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.listeners.NullModelTargetListener;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.StringProvider;
/*     */ import javax.swing.JCheckBox;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public class FormCheckBox extends JCheckBox
/*     */   implements FormModelContainer
/*     */ {
/*  18 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */ 
/*  20 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  23 */   private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();
/*     */   private String text;
/*     */   private Boolean initialState;
/*     */ 
/*     */   public FormCheckBox(String text)
/*     */   {
/*  37 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  44 */     this.modelTargetListener.load(null);
/*  45 */     setVisible(!this.invisibleCondition.evaluate(getModel()));
/*  46 */     setEnabled(!this.disablePredicate.evaluate(getModel()));
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/*  54 */     this.invisibleCondition = condition;
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/*  59 */     this.disablePredicate = condition;
/*  60 */     return this;
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*  68 */     this.text = StringProvider.getInstance().getValueOf(this.text);
/*  69 */     refreshComponent();
/*  70 */     if (this.initialState != null)
/*  71 */       setSelected(this.initialState);
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  78 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  85 */     this.modelTargetListener.unLoad(null);
/*     */   }
/*     */ 
/*     */   public void setSelected(Boolean bol) {
/*  89 */     super.setSelected(bol == null ? false : bol.booleanValue());
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print)
/*     */   {
/* 101 */     print.addInputValue(getName(), isSelected() ? "Verdadero" : 
/* 102 */       "Falso");
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 106 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setInitialState(Boolean initialState) {
/* 110 */     this.initialState = initialState;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormCheckBox
 * JD-Core Version:    0.6.0
 */