/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.validators.FormValueSelectionContainerValidator;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import java.awt.Color;
/*     */ import java.awt.HeadlessException;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.functors.FalsePredicate;
/*     */ 
/*     */ public class TextArea extends JEditorPane
/*     */   implements FormInput
/*     */ {
/*     */   private ModelTargetListener modelTargetListener;
/*  22 */   private FormValueSelectionContainerValidator validator = FormValueSelectionContainerValidator.DUMMY_INSTANCE;
/*     */ 
/*  24 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */ 
/*  26 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */   private FormModel model;
/*     */   private JComponent label;
/*     */ 
/*     */   public TextArea(String name)
/*     */     throws HeadlessException
/*     */   {
/*  34 */     setName(name);
/*  35 */     this.label = new JLabel(name);
/*  36 */     this.label.setFocusable(false);
/*     */   }
/*     */ 
/*     */   public final void initComponent()
/*     */   {
/*  43 */     setBorder(BorderFactory.createLineBorder(Color.BLACK));
/*  44 */     refreshComponent();
/*     */   }
/*     */ 
/*     */   public final void setValidator(FormValueSelectionContainerValidator validator)
/*     */   {
/*  52 */     this.validator = validator;
/*     */   }
/*     */ 
/*     */   public void setModel(FormModel model)
/*     */   {
/*  59 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  66 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  73 */     if (validate)
/*  74 */       this.validator.validate(this);
/*  75 */     if (hasModelTargetListener())
/*  76 */       this.modelTargetListener.unLoad(this.model);
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  83 */     if (hasModelTargetListener())
/*  84 */       this.modelTargetListener.load(this.model);
/*  85 */     setVisible(!this.invisibleCondition.evaluate(this.model));
/*     */   }
/*     */ 
/*     */   private boolean hasModelTargetListener() {
/*  89 */     return this.modelTargetListener != null;
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/*  96 */     this.invisibleCondition = condition;
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 101 */     this.disablePredicate = condition;
/* 102 */     return this;
/*     */   }
/*     */ 
/*     */   public Object getValor()
/*     */   {
/* 109 */     if ("".equals(getText().trim()))
/* 110 */       return null;
/* 111 */     return getText();
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 118 */     return getValor() == null;
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 129 */     print.addInputValue(getName(), getValor());
/*     */   }
/*     */ 
/*     */   public void setValue(Object text) {
/* 133 */     setText(text.toString());
/*     */   }
/*     */ 
/*     */   public void withLabel(JComponent label) {
/* 137 */     this.label = label;
/*     */   }
/*     */ 
/*     */   public JComponent getLabel() {
/* 141 */     return this.label;
/*     */   }
/*     */ 
/*     */   public void setFull() {
/* 145 */     getLabel().setForeground(Color.BLACK);
/*     */   }
/*     */ 
/*     */   public void setNotFull() {
/* 149 */     getLabel().setForeground(Color.RED);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.TextArea
 * JD-Core Version:    0.6.0
 */