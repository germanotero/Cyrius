/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.abstractfactorys.TipoCalendarFormInput;
/*     */ import com.framework.abstractfactorys.TipoDoubleFormInput;
/*     */ import com.framework.abstractfactorys.TipoFloatNumberFormInput;
/*     */ import com.framework.abstractfactorys.TipoMedidaFormInput;
/*     */ import com.framework.abstractfactorys.TipoNumberFormInput;
/*     */ import com.framework.abstractfactorys.TipoStringFormInput;
/*     */ import com.framework.abstractfactorys.TipoTextAreaFormInput;
/*     */ import com.framework.abstractfactorys.TipoTimeFormInput;
/*     */ import com.framework.components.Component;
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormValueSelectionContainer;
/*     */ import com.framework.components.FormWellKnownIntancesGridBuilder;
/*     */ import com.framework.components.ModelEnableElementsContainer;
/*     */ import com.framework.components.TextBanner;
/*     */ import com.framework.components.builders.interfaces.CheckBoxBuilder;
/*     */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*     */ import com.framework.components.builders.interfaces.GroupBuilder;
/*     */ import com.framework.components.builders.interfaces.TreeBuilder;
/*     */ import com.framework.components.builders.interfaces.ValueProvider;
/*     */ import com.framework.components.listeners.AbstractGridModelTargetListener;
/*     */ import com.framework.components.listeners.FormGridFindAllModelTableListener;
/*     */ import com.framework.components.listeners.FormGridModelTableListener;
/*     */ import com.framework.components.listeners.FormValueSelectionContainerListener;
/*     */ import com.framework.components.listeners.InvokeMethodModelTableListener;
/*     */ import com.framework.components.listeners.InvokeMethodWithArgumentModelTableListener;
/*     */ import com.framework.exceptions.IllegalArgumentExceptionBuilder;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.persistence.DedicatedPersistenceService;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.ModelUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class FormElementsBuilderImpl
/*     */   implements FormElementsBuilder
/*     */ {
/*     */   private ModelEnableElementsContainer container;
/*  47 */   private Collection<FormComponentBuilder> elements = CollectionFactory.createCollection(FormComponentBuilder.class);
/*     */ 
/*  49 */   private int columns = 2;
/*     */ 
/*     */   protected FormElementsBuilderImpl()
/*     */   {
/*     */   }
/*     */ 
/*     */   public FormElementsBuilderImpl(ModelEnableElementsContainer container)
/*     */   {
/*  57 */     withContainer(container);
/*     */   }
/*     */ 
/*     */   public ModelEnableElementsContainer getContainer()
/*     */   {
/*  62 */     return this.container;
/*     */   }
/*     */ 
/*     */   public int getColumns() {
/*  66 */     return this.columns;
/*     */   }
/*     */ 
/*     */   public Collection<FormComponentBuilder> getElements() {
/*  70 */     return this.elements;
/*     */   }
/*     */ 
/*     */   public FormElementsBuilderImpl withContainer(ModelEnableElementsContainer container)
/*     */   {
/*  81 */     this.container = container;
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addCombo(Class comboItemsClass, String modelTargetProperty)
/*     */   {
/*  91 */     FormComboBoxBuilderImpl formComboBoxBuilder = new FormComboBoxBuilderImpl();
/*  92 */     formComboBoxBuilder.withContainer(this.container);
/*  93 */     formComboBoxBuilder.withTargetProperty(modelTargetProperty);
/*  94 */     formComboBoxBuilder.setAbstractSearcherMethod(
/*  95 */       new DedicatedPersistenceService(comboItemsClass), "findAll");
/*  96 */     this.elements.add(formComboBoxBuilder);
/*  97 */     return formComboBoxBuilder;
/*     */   }
/*     */ 
/*     */   public final FormComboBoxBuilder addCombo(String listProperty, String modelTargetProperty)
/*     */   {
/* 103 */     FormComboBoxBuilderImpl formComboBoxBuilder = new FormComboBoxBuilderImpl();
/* 104 */     formComboBoxBuilder.withContainer(this.container);
/* 105 */     formComboBoxBuilder.withTargetProperty(modelTargetProperty);
/* 106 */     formComboBoxBuilder.withListProperty(listProperty);
/* 107 */     this.elements.add(formComboBoxBuilder);
/* 108 */     return formComboBoxBuilder;
/*     */   }
/*     */ 
/*     */   public final FormComboBoxBuilder addCombo(Object searcher, String method, String modelTargetProperty)
/*     */   {
/* 113 */     FormComboBoxBuilderImpl formComboBoxBuilder = new FormComboBoxBuilderImpl();
/* 114 */     formComboBoxBuilder.withContainer(this.container);
/* 115 */     formComboBoxBuilder.withTargetProperty(modelTargetProperty);
/* 116 */     formComboBoxBuilder.setAbstractSearcherMethod(searcher, method);
/* 117 */     this.elements.add(formComboBoxBuilder);
/* 118 */     return formComboBoxBuilder;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addCombo(Object instance, String string) {
/* 122 */     FormComboBoxBuilderImpl formComboBoxBuilder = new FormComboBoxBuilderImpl();
/* 123 */     formComboBoxBuilder.withContainer(this.container);
/* 124 */     formComboBoxBuilder.setModelChangeCombo();
/* 125 */     this.elements.add(formComboBoxBuilder);
/* 126 */     return formComboBoxBuilder;
/*     */   }
/*     */ 
/*     */   public FormComboBoxBuilder addCombo(ValueProvider cProvider, String modelTargetProperty)
/*     */   {
/* 131 */     FormComboBoxBuilderImpl formComboBoxBuilder = new FormComboBoxBuilderImpl();
/* 132 */     formComboBoxBuilder.withContainer(this.container);
/* 133 */     formComboBoxBuilder.withTargetProperty(modelTargetProperty);
/* 134 */     formComboBoxBuilder.withProvider(cProvider);
/* 135 */     this.elements.add(formComboBoxBuilder);
/* 136 */     return formComboBoxBuilder;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder addBuilder(FormComponentBuilder compoenentBuilder)
/*     */   {
/* 141 */     this.elements.add(compoenentBuilder);
/* 142 */     return compoenentBuilder;
/*     */   }
/*     */ 
/*     */   public void addBuilders(Collection compoenentBuilders) {
/* 146 */     for (Iterator iter = compoenentBuilders.iterator(); iter.hasNext(); ) {
/* 147 */       FormComponentBuilder componentBuilder = 
/* 148 */         (FormComponentBuilder)iter
/* 148 */         .next();
/* 149 */       addBuilder(componentBuilder);
/*     */     }
/*     */   }
/*     */ 
/*     */   public FormComponent addComponent(FormValueSelectionContainer component, String property, String constraints)
/*     */   {
/* 156 */     component
/* 157 */       .addModelTargetListener(new FormValueSelectionContainerListener(
/* 158 */       this.container, property, component));
/* 159 */     this.elements.add(
/* 160 */       new DefaultFormComponentBuilder(component, 
/* 160 */       constraints));
/* 161 */     return component;
/*     */   }
/*     */ 
/*     */   public FormComponent addComponent(FormComponent component, String constraints)
/*     */   {
/* 166 */     this.elements.add(
/* 167 */       new DefaultFormComponentBuilder(component, 
/* 167 */       constraints));
/* 168 */     return component;
/*     */   }
/*     */ 
/*     */   public final TextBanner addBanner(String modelProperty)
/*     */   {
/* 178 */     TextBanner texto = new TextBanner();
/* 179 */     texto.setEditable(false);
/* 180 */     texto.setText((String)ModelUtils.getNestedProperty(
/* 181 */       this.container.getModelo(), modelProperty).getValue());
/* 182 */     this.elements.add(new DefaultFormComponentBuilder(texto));
/* 183 */     return texto;
/*     */   }
/*     */ 
/*     */   public final FormFieldBuilder addStringField(String modelProperty)
/*     */   {
/* 190 */     FormInputBuilder builder = new FormInputBuilder();
/* 191 */     builder.withModelProperty(modelProperty).withTipo(
/* 192 */       TipoStringFormInput.INSTANCE).withContainer(this.container);
/* 193 */     this.elements.add(builder);
/* 194 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormFieldBuilder addTextArea(String modelProperty)
/*     */   {
/* 201 */     FormInputBuilder builder = new FormInputBuilder();
/* 202 */     builder.withModelProperty(modelProperty).withTipo(
/* 203 */       TipoTextAreaFormInput.INSTANCE).withContainer(this.container);
/* 204 */     this.elements.add(builder);
/* 205 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormFieldBuilder addDoubleField(String modelProperty)
/*     */   {
/* 213 */     FormInputBuilder builder = new FormInputBuilder();
/* 214 */     builder.withModelProperty(modelProperty).withTipo(
/* 215 */       TipoDoubleFormInput.INSTANCE).withContainer(this.container);
/* 216 */     this.elements.add(builder);
/* 217 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormFieldBuilder addFloatField(String modelProperty) {
/* 221 */     FormInputBuilder builder = new FormInputBuilder();
/* 222 */     builder.withModelProperty(modelProperty).withTipo(
/* 223 */       new TipoFloatNumberFormInput()).withContainer(this.container);
/* 224 */     this.elements.add(builder);
/* 225 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormFieldBuilder addNumberField(String modelProperty) {
/* 229 */     FormInputBuilder builder = new FormInputBuilder();
/* 230 */     builder.withModelProperty(modelProperty).withTipo(
/* 231 */       TipoNumberFormInput.INSTANCE).withContainer(this.container);
/* 232 */     this.elements.add(builder);
/* 233 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormInputBuilder addMedidaField(String modelProperty)
/*     */   {
/* 238 */     FormInputBuilder builder = new FormInputBuilder();
/* 239 */     builder.withModelProperty(modelProperty).withTipo(
/* 240 */       TipoMedidaFormInput.INSTANCE).withContainer(this.container);
/* 241 */     this.elements.add(builder);
/* 242 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormInputBuilder addCalendarBox(String modelProperty)
/*     */   {
/* 249 */     FormInputBuilder builder = new FormInputBuilder();
/* 250 */     builder.withModelProperty(modelProperty).withTipo(
/* 251 */       TipoCalendarFormInput.INSTANCE).withContainer(this.container);
/* 252 */     this.elements.add(builder);
/* 253 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormInputBuilder addTimeBox(String modelProperty)
/*     */   {
/* 258 */     FormInputBuilder builder = new FormInputBuilder();
/* 259 */     builder.withModelProperty(modelProperty).withTipo(
/* 260 */       TipoTimeFormInput.INSTANCE).withContainer(this.container);
/* 261 */     this.elements.add(builder);
/* 262 */     return builder;
/*     */   }
/*     */ 
/*     */   public final GroupBuilder addGroup(Class group, String modelPropertyTarget)
/*     */   {
/* 267 */     GroupBuilderImpl builder = new GroupBuilderImpl(group, 
/* 268 */       modelPropertyTarget, this.container);
/* 269 */     this.elements.add(builder);
/* 270 */     builder.initBuilder();
/* 271 */     return builder;
/*     */   }
/*     */ 
/*     */   public final GroupBuilder addGroup(Class group) {
/* 275 */     GroupBuilderImpl builder = new GroupBuilderImpl(group, this.container);
/* 276 */     builder.initBuilder();
/* 277 */     this.elements.add(builder);
/* 278 */     return builder;
/*     */   }
/*     */ 
/*     */   public final GroupBuilder addGroup(String nameKey) {
/* 282 */     GroupBuilderImpl builder = new GroupBuilderImpl(this.container, nameKey);
/* 283 */     builder.initBuilder();
/* 284 */     this.elements.add(builder);
/* 285 */     return builder;
/*     */   }
/*     */ 
/*     */   public final FormGridBuilder addGrid(String listProperty) {
/* 289 */     FormGridBuilderImpl builder = new FormGridBuilderImpl(this.container, 
/* 290 */       listProperty);
/* 291 */     FormGridModelTableListener mol = new FormGridModelTableListener();
/* 292 */     mol.setModelProperty(listProperty);
/* 293 */     builder.addListener(mol);
/* 294 */     this.elements.add(builder);
/* 295 */     return builder;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addGrid(Object searcher, String listMethod) {
/* 299 */     FormGridBuilderImpl builder = new FormWellKnownIntancesGridBuilder(
/* 300 */       this.container, listMethod);
/* 301 */     AbstractGridModelTargetListener mol = new InvokeMethodModelTableListener(
/* 302 */       searcher);
/* 303 */     mol.setModelProperty(listMethod);
/* 304 */     builder.addListener(mol);
/* 305 */     this.elements.add(builder);
/* 306 */     return builder;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addGrid(Object searcher, String listMethod, String modelPropertyAsArgument)
/*     */   {
/* 311 */     FormGridBuilderImpl builder = new FormWellKnownIntancesGridBuilder(
/* 312 */       this.container, listMethod);
/* 313 */     AbstractGridModelTargetListener mol = new InvokeMethodWithArgumentModelTableListener(
/* 314 */       searcher, modelPropertyAsArgument);
/* 315 */     mol.setModelProperty(listMethod);
/* 316 */     builder.addListener(mol);
/* 317 */     this.elements.add(builder);
/* 318 */     return builder;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addGrid(Object instance, String method, String[] argumentProperties)
/*     */   {
/* 328 */     FormGridBuilderImpl builder = new FormWellKnownIntancesGridBuilder(
/* 329 */       this.container, method);
/* 330 */     AbstractGridModelTargetListener mol = new InvokeMethodWithArgumentModelTableListener(
/* 331 */       instance, argumentProperties);
/* 332 */     mol.setModelProperty(method);
/* 333 */     builder.addListener(mol);
/* 334 */     this.elements.add(builder);
/* 335 */     return builder;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addGrid(Class entityClass) {
/* 339 */     FormGridBuilderImpl builder = new FormWellKnownIntancesGridBuilder(
/* 340 */       this.container, entityClass.getName());
/* 341 */     FormGridFindAllModelTableListener mol = new FormGridFindAllModelTableListener(
/* 342 */       entityClass);
/*     */ 
/* 344 */     builder.addListener(mol);
/* 345 */     this.elements.add(builder);
/* 346 */     return builder;
/*     */   }
/*     */ 
/*     */   public CheckBoxBuilder addCheckBox(String property)
/*     */   {
/* 353 */     CheckBoxBuilder builder = new CheckBoxBuilderImpl(property, this.container);
/* 354 */     this.elements.add(builder);
/* 355 */     return builder;
/*     */   }
/*     */ 
/*     */   public TreeBuilder addTree(String listProperty, String childrenProperty)
/*     */   {
/* 364 */     TreeBuilder treeBuilder = new TreeBuilderImpl(listProperty, 
/* 365 */       childrenProperty, this.container);
/* 366 */     this.elements.add(treeBuilder);
/* 367 */     return treeBuilder;
/*     */   }
/*     */ 
/*     */   public final void setColumnsCount(int columns)
/*     */   {
/* 373 */     IllegalArgumentExceptionBuilder.validateTrue(
/* 374 */       "Error: No puede setearle menos de una columna a un form builder", 
/* 375 */       columns > 0);
/* 376 */     this.columns = columns;
/*     */   }
/*     */ 
/*     */   public Component build() {
/* 380 */     return build(this.container);
/*     */   }
/*     */ 
/*     */   public Collection<FormComponentBuilder> getFormComponentsBuilders() {
/* 384 */     return this.elements;
/*     */   }
/*     */ 
/*     */   protected Component build(ModelEnableElementsContainer contenedor) {
/* 388 */     FormBuilder formBuilder = new FormBuilder(contenedor);
/* 389 */     ConstraintsProvider provider = new ConstraintsProvider(this.columns);
/* 390 */     for (Iterator iter = this.elements.iterator(); iter.hasNext(); ) {
/* 391 */       FormComponentBuilder builder = (FormComponentBuilder)iter.next();
/* 392 */       builder.withContainer(contenedor);
/* 393 */       builder.addTo(formBuilder, this.columns, provider);
/*     */     }
/* 395 */     return (Component)formBuilder.build();
/*     */   }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormElementsBuilderImpl
 * JD-Core Version:    0.6.0
 */