/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.FalsePredicate;


import com.framework.components.FormCheckBox;
import com.framework.components.FormComponent;
import com.framework.components.RefreshableComponent;
import com.framework.components.builders.interfaces.CheckBoxBuilder;
import com.framework.components.builders.interfaces.FormComponentBuilder;
import com.framework.components.listeners.ModelTargetListener;
import com.framework.models.FormModel;
import com.framework.utils.ModelUtils;
import com.framework.utils.StringUtils;
/*     */ 
/*     */ public class CheckBoxBuilderImpl
/*     */   implements FormComponentBuilder, CheckBoxBuilder
/*     */ {
/*     */   private String modelProperty;
/*     */   private RefreshableComponent container;
/*  31 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  33 */   private ChangeListener changeListener = new ChangeListener() {
/*     */     public void stateChanged(ChangeEvent e) {  } } ;
/*     */   private Boolean initialState;
/*     */ 
/*     */   public CheckBoxBuilderImpl(String property, RefreshableComponent container)
/*     */   {
/*  48 */     this.modelProperty = property;
/*  49 */     this.container = container;
/*     */   }
/*     */ 
/*     */   public void setRefreshableOnChange() {
/*  53 */     this.changeListener = new ChangeListener()
/*     */     {
/*     */       public void stateChanged(ChangeEvent e) {
/*  56 */         CheckBoxBuilderImpl.this.container.impactModel(false);
/*  57 */         CheckBoxBuilderImpl.this.container.refreshComponent();
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */   public FormComponent build()
/*     */   {
/*  68 */     FormCheckBox check = new FormCheckBox(
/*  69 */       StringUtils.getI18NKey(this.container, 
/*  69 */       this.modelProperty));
/*  70 */     check
/*  71 */       .addModelTargetListener(new FormCheckBoxModelTargetListener(
/*  72 */       check));
/*     */ 
/*  73 */     check.addChangeListener(this.changeListener);
/*  74 */     check.setDisableOn(this.disablePredicate);
/*  75 */     check.setInitialState(this.initialState);
/*  76 */     check.initComponent();
/*  77 */     return check;
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withName(String name)
/*     */   {
/* 110 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withContainer(RefreshableComponent container)
/*     */   {
/* 115 */     this.container = container;
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*     */   {
/* 121 */     FormCheckBox build = (FormCheckBox)build();
/* 122 */     formBuilder.addComponent(build, 
/* 123 */       constraintsProvider.getRowDiscriminator());
/* 124 */     formBuilder.addJComponent(new JLabel(build.getDescription()), ".");
/*     */   }
/*     */ 
/*     */   public CheckBoxBuilder withModelProperty(String modelProperty) {
/* 128 */     this.modelProperty = modelProperty;
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */   public void setDisableOn(Predicate predicate) {
/* 133 */     this.disablePredicate = predicate;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder required()
/*     */   {
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   public void setInitialState(Boolean value) {
/* 142 */     this.initialState = value;
/*     */   }
/*     */ 
/*     */   public class FormCheckBoxModelTargetListener
/*     */     implements ModelTargetListener
/*     */   {
/*     */     private final FormCheckBox check;
/*     */ 
/*     */     private FormCheckBoxModelTargetListener(FormCheckBox check)
/*     */     {
/*  89 */       this.check = check;
/*     */     }
/*     */ 
/*     */     public void load(FormModel model)
/*     */     {
/*  96 */       this.check.setSelected((Boolean)ModelUtils.getNestedProperty(
/*  97 */         CheckBoxBuilderImpl.this.container.getModelo(), CheckBoxBuilderImpl.this.modelProperty).getValue());
/*     */     }
/*     */ 
/*     */     public void unLoad(FormModel formModel)
/*     */     {
/* 104 */       ModelUtils.setNestedProperty(CheckBoxBuilderImpl.this.container.getModelo(), CheckBoxBuilderImpl.this.modelProperty, 
/* 105 */         new Boolean(this.check.isSelected()));
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.CheckBoxBuilderImpl
 * JD-Core Version:    0.6.0
 */