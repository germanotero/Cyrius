/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.validators.FormValueSelectionContainerValidator;
/*     */ import com.framework.models.DefaultComboModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import java.awt.Color;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.Transformer;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class DefaultComboBox extends JAutoComboBox
/*     */   implements Combo
/*     */ {
/*  34 */   private transient Log log = LogFactory.getLog(getClass());
/*     */ 
/*  36 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */ 
/*  38 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */   private FormModel model;
/*     */   private Collection values;
/*  45 */   private Collection<ModelTargetListener> modelTargetListeners = CollectionFactory.createCollection(ModelTargetListener.class);
/*     */ 
/*  47 */   private FormValueSelectionContainerValidator validator = FormValueSelectionContainerValidator.DUMMY_INSTANCE;
/*     */ 
/*  49 */   private boolean withNullElement = true;
/*     */   private JLabel label;
/*  53 */   private boolean doRefresh = true;
/*     */ 
/*  55 */   private Transformer onCommitAction = new Transformer()
/*     */   {
/*     */     public Object transform(Object arg0) {
/*  58 */       return arg0.equals("") ? null : arg0;
/*     */     }
/*  55 */   };
/*     */ 
/*     */   public DefaultComboBox()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DefaultComboBox(String name)
/*     */   {
/*  68 */     this();
/*  69 */     createLabel(name);
/*     */   }
/*     */ 
/*     */   private void createLabel(String name)
/*     */   {
/*  76 */     this.label = new JLabel();
/*  77 */     this.label.setBackground(getBackground());
/*  78 */     this.label.setText(name);
/*  79 */     this.label.setFocusable(false);
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*  87 */     setAutocomplete(true);
/*  88 */     setEditable(true);
/*  89 */     fireModelChange();
/*     */   }
/*     */ 
/*     */   public void setValues(Collection values) {
/*  93 */     this.values = values;
/*  94 */     if (this.withNullElement) {
/*  95 */       this.values = CollectionUtils.union(CollectionFactory.createCollectionWith(""), values);
/*     */     }
/*  97 */     if (values != null)
/*  98 */       super.setModel(new DefaultComboBoxModel(this.values.toArray()));
/*     */   }
/*     */ 
/*     */   public DefaultComboModel getValues()
/*     */   {
/* 106 */     return new DefaultComboModel(this.values);
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 116 */     if (this.doRefresh) {
/* 117 */       Object itemReminder = getSelectedItem();
/* 118 */       checkVisivility();
/* 119 */       fireModelChange();
/* 120 */       setSelectedItem(itemReminder);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void fireModelChange() {
/* 125 */     for (Iterator iter = this.modelTargetListeners.iterator(); iter.hasNext(); ) {
/* 126 */       ModelTargetListener element = (ModelTargetListener)iter.next();
/* 127 */       element.load(this.model);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSelectedItem(Object anObject)
/*     */   {
/* 133 */     super.setSelectedItem(anObject);
/*     */   }
/*     */ 
/*     */   private void checkVisivility() {
/* 137 */     setVisible(!this.invisibleCondition.evaluate(this.model));
/* 138 */     setEnabled(!this.disablePredicate.evaluate(this.model));
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition) {
/* 142 */     this.invisibleCondition = condition;
/* 143 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 147 */     this.disablePredicate = condition;
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   public void setModel(FormModel model)
/*     */   {
/* 156 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener) {
/* 167 */     this.modelTargetListeners.add(listener);
/*     */   }
/*     */ 
/*     */   public void addComboRestriction(Combo combo, String propertyList) {
/* 171 */     throw new RuntimeException("Analizar esto");
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 175 */     if (getSelectedItem() != null) {
/* 176 */       this.log.debug("Se va a imprimir el valor del combo: " + getName());
/* 177 */       print.addInputValue(getName(), getSelectedItem());
/*     */     } else {
/* 179 */       this.log.debug(
/* 180 */         "Se salteo el valor del combo: " + getName() + " por no estar seleccionado.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setValidator(FormValueSelectionContainerValidator validator) {
/* 185 */     this.validator = validator;
/*     */   }
/*     */ 
/*     */   public Object getValor() {
/* 189 */     return getSelectedItem();
/*     */   }
/*     */ 
/*     */   public void setValue(Object value) {
/* 193 */     setSelectedItem(value);
/*     */   }
/*     */ 
/*     */   public boolean isEmpty() {
/* 197 */     return getSelectedItem() == null;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate) {
/* 201 */     this.validator.validate(this);
/*     */   }
/*     */ 
	/*     */public Object getSelectedItem()
/*     */   {
/* 206 */     if (isAutoComplete())
/* 207 */       return getOnCommitAction().transform(
/* 208 */         super.getSelectedItem() == null ? super.getComboText() : super.getSelectedItem());
/* 209 */     return getOnCommitAction().transform(super.getSelectedItem());
/*     */   }
/*     */ 
/*     */   public void withOutNullElement() {
/* 213 */     this.withNullElement = false;
/*     */   }
/*     */ 
/*     */   public void setFull() {
/* 217 */     getLabel().setForeground(Color.BLACK);
/*     */   }
/*     */ 
/*     */   public void setNotFull() {
/* 221 */     getLabel().setForeground(Color.RED);
/*     */   }
/*     */ 
/*     */   public JComponent getLabel() {
/* 225 */     return this.label;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 230 */     super.setName(name);
/* 231 */     createLabel(name);
/*     */   }
/*     */ 
/*     */   public void setOnCommitAction(Transformer onCommitAction) {
/* 235 */     this.onCommitAction = onCommitAction;
/*     */   }
/*     */ 
/*     */   public Transformer getOnCommitAction() {
/* 239 */     return this.onCommitAction;
/*     */   }
/*     */ 
/*     */   public void doRefresh() {
/* 243 */     this.doRefresh = true;
/*     */   }
/*     */ 
/*     */   public void dontRefresh() {
/* 247 */     this.doRefresh = false;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.DefaultComboBox
 * JD-Core Version:    0.6.0
 */