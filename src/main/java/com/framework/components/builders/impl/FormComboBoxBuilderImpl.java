/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

import com.framework.components.Combo;
import com.framework.components.DefaultComboBox;
import com.framework.components.FormComponent;
import com.framework.components.RefreshableComponent;
import com.framework.components.builders.interfaces.FormComboBoxBuilder;
import com.framework.components.builders.interfaces.FormComponentBuilder;
import com.framework.components.builders.interfaces.ValueProvider;
import com.framework.components.listeners.BasicLoadModelTargetListener;
import com.framework.components.listeners.ComboListener;
import com.framework.components.listeners.ModelTargetListener;
import com.framework.models.FormModel;
import com.framework.utils.ClassUtils;
import com.framework.utils.ModelUtils;
import com.framework.utils.StringProvider;
import com.framework.utils.StringUtils;
/*     */ 
/*     */ public class FormComboBoxBuilderImpl
/*     */   implements FormComboBoxBuilder
/*     */ {
/*     */   private Combo combo;
/*     */   protected RefreshableComponent container;
/*     */   private String name;
/*     */   private String targetProperty;
/*  41 */   private boolean requerido = false;
/*     */ 
/*  43 */   private Transformer onCommitAction = new Transformer()
/*     */   {
/*     */     public Object transform(Object arg0) {
/*  46 */       return arg0;
/*     */     }
/*  43 */   };
/*     */ 
/*     */   public FormComboBoxBuilderImpl()
/*     */   {
/*  53 */     this.combo = new DefaultComboBox();
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addComboRestriction(Combo combo2,final String propertyList)
/*     */   {
/*  63 */     this.combo.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent e) {
/*  65 */         Object selected = FormComboBoxBuilderImpl.this.combo.getSelectedItem();
/*  66 */         if (selected != null) {
/*  67 */           FormComboBoxBuilderImpl.this.combo.setValues((Collection)ModelUtils.getNestedProperty(
/*  68 */             selected, propertyList));
/*  69 */           FormComboBoxBuilderImpl.this.combo.refreshComponent();
/*     */         }
/*     */       }
/*     */     });
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addComboRefresh(FormComboBoxBuilder practicaComboBuilder)
/*     */   {
/*  78 */     practicaComboBuilder.addItemListener(new ItemListener()
/*     */     {
/*     */       public void itemStateChanged(ItemEvent e) {
/*  81 */         FormComboBoxBuilderImpl.this.combo.refreshComponent();
/*     */       }
/*     */     });
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder setAbstractSearcherMethod(final Object searcher,final String listProperty)
/*     */   {
/*  91 */     this.combo.addModelTargetListener(new ModelTargetListener()
/*     */     {
/*     */       public void unLoad(FormModel formModel)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void load(FormModel model) {
/*  98 */         FormComboBoxBuilderImpl.this.combo.setValues(
/*  99 */           (Collection)ClassUtils.invokeMethod(searcher, 
/*  99 */           listProperty));
/*     */       }
/*     */     });
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder withTargetProperty(String targetProperty) {
/* 107 */     this.targetProperty = targetProperty;
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder withOutNullElement() {
/* 112 */     this.combo.withOutNullElement();
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder withListProperty(final String listProperty) {
/* 117 */     this.combo.addModelTargetListener(new ModelTargetListener()
/*     */     {
/*     */       public void unLoad(FormModel formModel)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void load(FormModel model) {
/* 124 */         FormModel values = ModelUtils.getNestedProperty(model, 
/* 125 */           listProperty);
/* 126 */         if (values != null)
/* 127 */           FormComboBoxBuilderImpl.this.combo.setValues((Collection)values.getValue());
/*     */       }
/*     */     });
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder setModelChangeCombo()
/*     */   {
/* 138 */     this.combo.addItemListener(new ComboListener(this.container, this.combo));
/* 139 */     this.combo.setName(
/* 140 */       this.container.getModelo().getValue().getClass().getName());
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addItemListener(ItemListener comboListener) {
/* 145 */     this.combo.addItemListener(comboListener);
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent build()
/*     */   {
/* 153 */     this.combo.setName(this.targetProperty);
/* 154 */     this.combo.addModelTargetListener(
/* 155 */       new BasicLoadModelTargetListener(this.targetProperty, this.combo));
/* 156 */     ComboListener comboListener = new ComboListener(this.container, 
/* 157 */       this.combo, this.targetProperty);
/* 158 */     this.combo.addItemListener(comboListener);
/* 159 */     this.combo.initComponent();
/* 160 */     this.combo.setName(getLabelText());
/* 161 */     this.combo.setOnCommitAction(this.onCommitAction);
/* 162 */     if (this.requerido) {
/* 163 */       this.combo.setValidator(new DefaultFormValidator(getLabelText()));
/*     */     }
/* 165 */     return this.combo;
/*     */   }
/*     */ 
/*     */   protected String getLabelText() {
/* 169 */     if (this.name == null)
/* 170 */       this.name = StringProvider.getInstance()
/* 171 */         .getValueOf(StringUtils.getI18NKey(this.container.getModelo(), 
/* 172 */         this.combo.getName()));
/* 173 */     return this.name;
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent()
/*     */   {
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withName(String name) {
/* 184 */     this.name = name;
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withContainer(RefreshableComponent container) {
/* 189 */     this.container = container;
/* 190 */     this.combo.setModel(container.getModelo());
/* 191 */     return this;
/*     */   }
/*     */ 
/*     */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*     */   {
/* 196 */     Combo component = (Combo)build();
/* 197 */     component.setPreferredSize(new Dimension(150, 20));
/* 198 */     component.setMaximumSize(new Dimension(2147483647, 20));
/* 199 */     formBuilder.addJComponent(component.getLabel(), 
/* 200 */       constraintsProvider.getRowDiscriminator());
/* 201 */     formBuilder.addComponent(component, "+ .");
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder withModelProperty(String modelProperty) {
/* 205 */     withTargetProperty(modelProperty);
/* 206 */     return this;
/*     */   }
/*     */ 
/*     */   public void setDisableOn(Predicate predicate) {
/* 210 */     this.combo.setDisableOn(predicate);
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder required() {
/* 214 */     this.requerido = true;
/* 215 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilderImpl withProvider(final ValueProvider provider) {
/* 219 */     this.combo.addModelTargetListener(new ModelTargetListener()
/*     */     {
/*     */       public void unLoad(FormModel formModel) {
/*     */       }
/*     */ 
/*     */       public void load(FormModel model) {
/* 225 */         FormComboBoxBuilderImpl.this.combo.setValues(provider.getValues());
/*     */       }
/*     */     });
/* 228 */     return this;
/*     */   }
/*     */ 
/*     */   public void setOnCommitAction(Transformer action) {
/* 232 */     this.onCommitAction = action;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder refreshOnChange()
/*     */   {
/* 239 */     addItemListener(new ItemListener()
/*     */     {
/*     */       public void itemStateChanged(ItemEvent e) {
/* 242 */         FormComboBoxBuilderImpl.this.combo.dontRefresh();
/* 243 */         FormComboBoxBuilderImpl.this.container.refreshComponent();
/* 244 */         FormComboBoxBuilderImpl.this.combo.doRefresh();
/*     */       }
/*     */     });
/* 248 */     return this;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormComboBoxBuilderImpl
 * JD-Core Version:    0.6.0
 */