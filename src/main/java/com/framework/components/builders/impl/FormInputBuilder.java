/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.abstractfactorys.TipoFormInput;
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormInput;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.components.listeners.FormValueSelectionContainerListener;
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.utils.StringProvider;
/*     */ import com.framework.utils.StringUtils;
/*     */ import java.awt.Dimension;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.functors.FalsePredicate;
/*     */ 
/*     */ public class FormInputBuilder
/*     */   implements FormComponentBuilder, FormFieldBuilder
/*     */ {
/*     */   protected RefreshableComponent container;
/*     */   private String modelProperty;
/*  28 */   private Predicate notVisiblePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  30 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */   private TipoFormInput tipoInput;
/*     */   private String name;
/*  36 */   private boolean requerido = false;
/*     */ 
/*     */   public FormInputBuilder()
/*     */   {
/*     */   }
/*     */ 
/*     */   public FormInputBuilder(TipoFormInput tipo)
/*     */   {
/*  44 */     withTipo(tipo);
/*     */   }
/*     */ 
/*     */   public FormInputBuilder withTipo(TipoFormInput tipo) {
/*  48 */     this.tipoInput = tipo;
/*  49 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withContainer(RefreshableComponent container) {
/*  53 */     this.container = container;
/*  54 */     return this;
/*     */   }
/*     */ 
/*     */   public FormInputBuilder withModelProperty(String modelProperty) {
/*  58 */     this.modelProperty = modelProperty;
/*  59 */     return this;
/*     */   }
/*     */ 
/*     */   public void setDisableOn(Predicate condition) {
/*  63 */     this.disablePredicate = condition;
/*     */   }
/*     */ 
/*     */   public void setNotVisibleOn(Predicate notVisiblePredicate) {
/*  67 */     this.notVisiblePredicate = notVisiblePredicate;
/*     */   }
/*     */ 
/*     */   public final FormComponent build()
/*     */   {
/*  74 */     FormInput field = this.tipoInput.getInput(getLabelText());
/*  75 */     field.addModelTargetListener(getModelTargetLisetner(field));
/*  76 */     if (this.requerido) {
/*  77 */       field.setValidator(new DefaultFormValidator(getLabelText()));
/*     */     }
/*     */ 
/*  80 */     if (this.container != null) {
/*  81 */       field.setModel(this.container.getModelo());
/*     */     }
/*  83 */     field.setNotVisibleOn(this.notVisiblePredicate);
/*  84 */     field.setDisableOn(this.disablePredicate);
/*  85 */     field.initComponent();
/*  86 */     return field;
/*     */   }
/*     */ 
/*     */   protected String getLabelText() {
/*  90 */     if (this.name == null)
/*  91 */       this.name = StringProvider.getInstance()
/*  92 */         .getValueOf(StringUtils.getI18NKey(this.container.getModelo(), this.modelProperty));
/*  93 */     return this.name;
/*     */   }
/*     */ 
/*     */   protected ModelTargetListener getModelTargetLisetner(FormInput field) {
/*  97 */     return new FormValueSelectionContainerListener(this.container, this.modelProperty, field);
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withName(String name) {
/* 105 */     this.name = name;
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder required() {
/* 110 */     this.requerido = true;
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constantsProvider) {
/* 115 */     FormInput component = (FormInput)build();
/* 116 */     if (!component.isColumnComponent())
/* 117 */       component.setMaximumSize(new Dimension(2147483647, 19));
/* 118 */     component.setMinimumSize(new Dimension(50, 19));
/* 119 */     formBuilder.addJComponent(component.getLabel(), constantsProvider.getRowDiscriminator());
/* 120 */     formBuilder.addComponent(component, ".");
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormInputBuilder
 * JD-Core Version:    0.6.0
 */