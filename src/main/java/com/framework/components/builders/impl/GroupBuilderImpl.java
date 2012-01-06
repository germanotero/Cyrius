/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractGroup;
/*     */ import com.framework.abstractfactorys.BorderFactory;
/*     */ import com.framework.components.DefaultGroup;
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.ModelEnableElementsContainer;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.components.builders.interfaces.GroupBuilder;
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.utils.ClassUtils;
/*     */ import com.framework.utils.StringProvider;
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public class GroupBuilderImpl extends FormElementsBuilderImpl
/*     */   implements GroupBuilder
/*     */ {
/*     */   protected AbstractGroup innerGroup;
/*     */   protected String modelProperty;
/*     */   private String name;
/*  31 */   private Class innerGroupClass = DefaultGroup.class;
/*     */   private Class modelClass;
/*  36 */   private boolean oneRowComponent = true;
/*     */ 
/*  38 */   private boolean withBorder = true;
/*     */ 
/*  40 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*     */   public GroupBuilderImpl() {
/*     */   }
/*     */ 
/*     */   public GroupBuilderImpl(ModelEnableElementsContainer container, String nameKey) {
/*  46 */     this(container);
/*  47 */     this.name = StringProvider.getInstance().getValueOf(nameKey);
/*     */   }
/*     */ 
/*     */   public GroupBuilderImpl(Class groupClass, String modelPropertyTarget, ModelEnableElementsContainer container)
/*     */   {
/*  58 */     super(container);
/*  59 */     this.innerGroupClass = groupClass;
/*  60 */     this.modelProperty = modelPropertyTarget;
/*     */   }
/*     */ 
/*     */   public GroupBuilderImpl(Class groupClass, ModelEnableElementsContainer container)
/*     */   {
/*  70 */     super(container);
/*  71 */     this.innerGroupClass = groupClass;
/*     */   }
/*     */ 
/*     */   public void initBuilder() {
/*  75 */     instanciateGroup(this.innerGroupClass);
/*     */   }
/*     */ 
/*     */   public void setInnerGroup(AbstractGroup innerGroup) {
/*  79 */     this.innerGroup = innerGroup;
/*     */   }
/*     */ 
/*     */   public GroupBuilderImpl(ModelEnableElementsContainer container)
/*     */   {
/*  88 */     super(container);
/*     */   }
/*     */ 
/*     */   public FormComponent build()
/*     */   {
/*  95 */     if (this.innerGroup == null) {
/*  96 */       this.innerGroup = new DefaultGroup(this.modelClass);
/*     */     }
/*     */ 
/*  99 */     this.innerGroup.addModelTargetListener(getModelTargetListener(this.innerGroup));
/* 100 */     String title = getGroupTitle(this.innerGroup);
/* 101 */     if (this.withBorder)
/* 102 */       this.innerGroup.setBorder(BorderFactory.createDefaultGroupBorder(title));
/* 103 */     FormActionBuilderImpl actionBuilder = new FormActionBuilderImpl(
/* 104 */       this.innerGroup);
/* 105 */     this.innerGroup.setUp();
/* 106 */     this.innerGroup.setName(this.name);
/* 107 */     this.innerGroup.setPadre(getContainer());
/* 108 */     this.innerGroup.registerElements(this);
/* 109 */     this.innerGroup.setDisableOn(this.disablePredicate);
/* 110 */     this.innerGroup.initComponent();
/* 111 */     super.build(this.innerGroup);
/* 112 */     this.innerGroup.registerActions(actionBuilder);
/* 113 */     actionBuilder.build();
/* 114 */     this.innerGroup.initComponent();
/*     */ 
/* 116 */     AbstractGroup answer = this.innerGroup;
/* 117 */     getElements().clear();
/*     */ 
/* 119 */     this.innerGroup = null;
/* 120 */     return answer;
/*     */   }
/*     */ 
/*     */   public void setNotOneColumnComponent() {
/* 124 */     this.oneRowComponent = false;
/*     */   }
/*     */ 
/*     */   protected final void instanciateGroup(Class innerGroupClass)
/*     */   {
/* 131 */     AbstractGroup group = getGroupInstance(innerGroupClass);
/* 132 */     group.addModelTargetListener(getModelTargetListener(group));
/* 133 */     this.innerGroup = group;
/*     */   }
/*     */ 
/*     */   protected AbstractGroup getGroupInstance(Class innerGroupClass)
/*     */   {
/* 141 */     return (AbstractGroup)ClassUtils.newInstance(innerGroupClass);
/*     */   }
/*     */ 
/*     */   protected String getGroupTitle(AbstractGroup group)
/*     */   {
/* 148 */     if (this.name == null)
/* 149 */       this.name = StringProvider.getInstance()
/* 150 */         .getValueOf(group.getClass().getName() + "." + this.modelProperty);
/* 151 */     return this.name;
/*     */   }
/*     */ 
/*     */   protected ModelTargetListener getModelTargetListener(AbstractGroup group)
/*     */   {
/* 158 */     if (this.modelProperty != null)
/* 159 */       return new GroupModelTargetListener(getContainer(), group, 
/* 160 */         this.modelProperty);
/* 161 */     return new GroupContainerModelTargetListener(group);
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withName(String name)
/*     */   {
/* 166 */     this.name = name;
/* 167 */     return this;
/*     */   }
/*     */ 
/*     */   public GroupBuilder withModelClass(Class modelClass) {
/* 171 */     this.modelClass = modelClass;
/* 172 */     return this;
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent() {
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*     */   {
/* 181 */     FormComponent group = build();
/* 182 */     if (!this.oneRowComponent) {
/* 183 */       formBuilder.addComponent(group, 
/* 184 */         constraintsProvider.getRowDiscriminator() + 
/* 185 */         " 2 2");
/*     */     } else {
/* 187 */       formBuilder.addComponent(group, "0 + " + maxColumns * 2 + " 6");
/* 188 */       constraintsProvider.rowElement();
/*     */     }
/*     */   }
/*     */ 
/*     */   public GroupBuilder withModelProperty(String modelProperty) {
/* 193 */     this.modelProperty = modelProperty;
/* 194 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withContainer(RefreshableComponent container) {
/* 198 */     super.withContainer((ModelEnableElementsContainer)container);
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */   public void withOutBorder() {
/* 203 */     this.withBorder = false;
/*     */   }
/*     */ 
/*     */   public void setDisableOn(Predicate predicate) {
/* 207 */     this.disablePredicate = predicate;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder required() {
/* 211 */     return this;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.GroupBuilderImpl
 * JD-Core Version:    0.6.0
 */