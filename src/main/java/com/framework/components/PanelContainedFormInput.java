/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.validators.FormValueSelectionContainerValidator;
/*     */ import com.framework.models.FormModel;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.text.Format;
/*     */ import java.text.ParseException;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JFormattedTextField.AbstractFormatter;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public abstract class PanelContainedFormInput extends JPanel
/*     */   implements FormValueSelectionContainer, FormInput
/*     */ {
/*     */   private ModelTargetListener modelTargetListener;
/*  30 */   private FormValueSelectionContainerValidator validator = FormValueSelectionContainerValidator.DUMMY_INSTANCE;
/*     */ 
/*  32 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */ 
/*  34 */   private JFormattedTextField textField = null;
/*     */   private FormModel model;
/*     */   private Predicate disablePredicate;
/*     */   private JLabel label;
/*     */ 
/*     */   public PanelContainedFormInput(String name)
/*     */   {
/*  43 */     this(null, name);
/*     */   }
/*     */ 
/*     */   public PanelContainedFormInput(Format format, String name) {
/*  47 */     super(new BorderLayout());
/*  48 */     setName(name);
/*     */ 
/*  50 */     this.textField = new JFormattedTextField(format);
/*  51 */     add(this.textField, "Center");
/*  52 */     this.label = new JLabel(name);
/*  53 */     add(this.label, "East");
/*     */   }
/*     */ 
/*     */   public final void initComponent() {
/*  57 */     initSubComponent();
/*  58 */     refreshComponent();
/*     */   }
/*     */ 
/*     */   public final void setValidator(FormValueSelectionContainerValidator validator)
/*     */   {
/*  63 */     this.validator = validator;
/*     */   }
/*     */ 
/*     */   public void setModel(FormModel model)
/*     */   {
/*  71 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  79 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  86 */     if (validate)
/*  87 */       this.validator.validate(this);
/*  88 */     if (hasModelTargetListener())
/*  89 */       this.modelTargetListener.unLoad(this.model);
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  97 */     if (hasModelTargetListener())
/*  98 */       this.modelTargetListener.load(this.model);
/*  99 */     setVisible(!this.invisibleCondition.evaluate(this.model));
/* 100 */     setEnabled(!this.disablePredicate.evaluate(this.model));
/*     */   }
/*     */ 
/*     */   private boolean hasModelTargetListener() {
/* 104 */     return this.modelTargetListener != null;
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/* 111 */     this.invisibleCondition = condition;
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 116 */     this.disablePredicate = condition;
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */   public void setValue(Object text) {
/* 121 */     this.textField.setValue(text);
/*     */   }
/*     */ 
/*     */   public Object getValor()
/*     */   {
/* 129 */     if ("".equals(this.textField.getText().trim()))
/* 130 */       return null;
/*     */     try
/*     */     {
/* 133 */       if (this.textField.getFormatter() != null)
/* 134 */         return transformResult(
/* 135 */           this.textField.getFormatter().stringToValue(this.textField.getText()));
/*     */     } catch (ParseException e) {
/* 137 */       throw new RuntimeException("Dato erroneo en el campo " + 
/* 138 */         getName(), e);
/*     */     }
/* 140 */     return transformResult(this.textField.getValue());
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 147 */     return getValor() == null;
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   protected abstract Object transformResult(Object paramObject);
/*     */ 
/*     */   protected void initSubComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public JComponent getLabel()
/*     */   {
/* 170 */     return this.label;
/*     */   }
/*     */ 
/*     */   public void setFull() {
/* 174 */     getLabel().setForeground(Color.BLACK);
/*     */   }
/*     */ 
/*     */   public void setNotFull() {
/* 178 */     getLabel().setForeground(Color.RED);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.PanelContainedFormInput
 * JD-Core Version:    0.6.0
 */