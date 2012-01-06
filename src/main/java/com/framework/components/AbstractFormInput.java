/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.validators.FormValueSelectionContainerValidator;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import java.awt.Color;
/*     */ import java.text.Format;
/*     */ import java.text.ParseException;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JFormattedTextField.AbstractFormatter;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public abstract class AbstractFormInput extends JFormattedTextField
/*     */   implements FormInput
/*     */ {
/*     */   private ModelTargetListener modelTargetListener;
/*  31 */   private FormValueSelectionContainerValidator validator = FormValueSelectionContainerValidator.DUMMY_INSTANCE;
/*     */ 
/*  33 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */   private JComponent label;
/*     */   private FormModel model;
/*  39 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*     */   public AbstractFormInput(String name)
/*     */   {
/*  43 */     setName(name);
/*  44 */     addLabel(name);
/*     */   }
/*     */ 
/*     */   public AbstractFormInput(Format format, String name)
/*     */   {
/*  51 */     super(format);
/*  52 */     setName(name);
/*  53 */     addLabel(name);
/*     */   }
/*     */ 
/*     */   private void addLabel(String name)
/*     */   {
/*  60 */     JLabel label = new JLabel(name);
/*  61 */     label.setFocusable(false);
/*  62 */     this.label = label;
/*     */   }
/*     */ 
/*     */   public final void initComponent()
/*     */   {
/*  69 */     initSubComponent();
/*  70 */     refreshComponent();
/*     */   }
/*     */ 
/*     */   public final void setValidator(FormValueSelectionContainerValidator validator)
/*     */   {
/*  78 */     this.validator = validator;
/*     */   }
/*     */ 
/*     */   public void setModel(FormModel model)
/*     */   {
/*  85 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  92 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  99 */     if (validate)
/* 100 */       this.validator.validate(this);
/* 101 */     if (hasModelTargetListener())
/* 102 */       this.modelTargetListener.unLoad(this.model);
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 109 */     if (hasModelTargetListener())
/* 110 */       this.modelTargetListener.load(this.model);
/* 111 */     boolean evaluation = this.invisibleCondition.evaluate(this.model);
/* 112 */     setVisible(!evaluation);
/* 113 */     this.label.setVisible(!evaluation);
/* 114 */     setEnabled(!this.disablePredicate.evaluate(this.model.getValue()));
/*     */   }
/*     */ 
/*     */   private boolean hasModelTargetListener() {
/* 118 */     return this.modelTargetListener != null;
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/* 125 */     this.invisibleCondition = condition;
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate disablePredicate) {
/* 130 */     this.disablePredicate = disablePredicate;
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   public void setValue(Object text)
/*     */   {
/* 138 */     if (text != null) {
/* 139 */       if (getFormatter() == null)
/* 140 */         setText(text.toString());
/*     */       else
/*     */         try {
/* 143 */           setText(getFormatter().valueToString(text));
/*     */         } catch (ParseException e) {
/* 145 */           throw new RuntimeException(
/* 146 */             "Error al intentar setear el valor en el input.");
/*     */         }
/*     */     }
/*     */     else
/* 150 */       setText("");
/*     */   }
/*     */ 
/*     */   public Object getValor()
/*     */   {
/* 157 */     if (("".equals(getText().trim())) || (super.getText() == null))
/* 158 */       return getNullValue();
/*     */     try {
/* 160 */       if (getFormatter() != null)
/* 161 */         return transformResult(getFormatter()
/* 162 */           .stringToValue(getText()));
/*     */     } catch (ParseException e) {
/* 164 */       throw new RuntimeException("Dato erroneo en el campo " + 
/* 165 */         getName(), e);
/*     */     }
/* 167 */     return transformResult(super.getValue());
/*     */   }
/*     */ 
/*     */   protected Object getNullValue()
/*     */   {
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 181 */     return getValor() == null;
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */   protected abstract Object transformResult(Object paramObject);
/*     */ 
/*     */   protected void initSubComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print)
/*     */   {
/* 204 */     print.addInputValue(getName(), getValor());
/*     */   }
/*     */ 
/*     */   public JComponent getLabel() {
/* 208 */     return this.label;
/*     */   }
/*     */ 
/*     */   public void setFull() {
/* 212 */     getLabel().setForeground(Color.BLACK);
/*     */   }
/*     */ 
/*     */   public void setNotFull() {
/* 216 */     getLabel().setForeground(Color.RED);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.AbstractFormInput
 * JD-Core Version:    0.6.0
 */