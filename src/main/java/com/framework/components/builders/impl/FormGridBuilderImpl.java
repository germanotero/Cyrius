/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.abstractfactorys.BorderFactory;
/*     */ import com.framework.actions.AbstractFormAction;
/*     */ import com.framework.components.FormGrid;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.components.builders.interfaces.FormComboBoxBuilder;
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.components.builders.interfaces.TableActionColumnBuilder;
/*     */ import com.framework.components.builders.interfaces.TableColumnBuilder;
/*     */ import com.framework.components.listeners.AbstractGridModelTargetListener;
/*     */ import com.framework.components.listeners.FormGridSimpleSelectorModelTargetListener;
/*     */ import com.framework.models.DefaultFormGridModel;
/*     */ import com.framework.models.FormGridModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.NullTransformer;
/*     */ import com.framework.utils.StringProvider;
/*     */ import com.framework.utils.StringUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.Transformer;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public class FormGridBuilderImpl
/*     */   implements FormGridBuilder, FormComponentBuilder
/*     */ {
/*  39 */   private Collection columns = CollectionFactory.createCollection();
/*     */ 
/*  42 */   private Collection<AbstractGridModelTargetListener> listeners = CollectionFactory.createCollection(AbstractGridModelTargetListener.class);
/*     */   protected RefreshableComponent container;
/*  46 */   protected TableActionColumnBuilderImpl actionColumnBuilder = NullTableActionColumnBuilder.INSTANCE;
/*     */   private String listProperty;
/*  50 */   private Collection gridDependencies = CollectionFactory.createCollection();
/*     */ 
/*  52 */   private boolean oneColumnGrid = false;
/*     */ 
/*  54 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  56 */   private boolean isRowSelectionAllowed = false;
/*     */   private GridRefreshRunnable refreshThread;
/*     */   private I18nMessageBuilderImpl exceptionMessageBuilder;
/*     */ 
/*     */   public FormGridBuilderImpl(RefreshableComponent container, String listProperty)
/*     */   {
/*  68 */     this.container = container;
/*  69 */     this.listProperty = listProperty;
/*     */   }
/*     */ 
/*     */   public TableColumnBuilder addColumn(String propertyName)
/*     */   {
/*  77 */     return addColumn(propertyName, Object.class);
/*     */   }
/*     */ 
/*     */   public TableColumnBuilder addDateColumn(String propertyName, String pattern) {
/*  81 */     TableDataColumnBuilderImpl columnBuilder = new TableDataColumnBuilderImpl(
/*  82 */       propertyName);
/*  83 */     columnBuilder.setColumnClass(Object.class);
/*  84 */     columnBuilder.setTransformer(NullTransformer.INSTANCE);
/*  85 */     columnBuilder.setDatePattern(pattern);
/*  86 */     this.columns.add(columnBuilder);
/*  87 */     return columnBuilder;
/*     */   }
/*     */ 
/*     */   public TableColumnBuilder addColumn(String propertyName, Class columnClass, Transformer transformer)
/*     */   {
/*  97 */     TableDataColumnBuilderImpl columnBuilder = new TableDataColumnBuilderImpl(
/*  98 */       propertyName);
/*  99 */     columnBuilder.setColumnClass(columnClass);
/* 100 */     columnBuilder.setTransformer(transformer);
/* 101 */     this.columns.add(columnBuilder);
/* 102 */     return columnBuilder;
/*     */   }
/*     */ 
/*     */   public TableColumnBuilder addColumn(String propertyName, Class columnClass)
/*     */   {
/* 110 */     return addColumn(propertyName, columnClass, NullTransformer.INSTANCE);
/*     */   }
/*     */ 
/*     */   public TableColumnBuilder addColumn(String propertyName, Transformer transformer)
/*     */   {
/* 119 */     return addColumn(propertyName, Object.class, transformer);
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addRowSelector(String selectedsProperty)
/*     */   {
/* 124 */     this.columns.add(new TableSelectionColumnBuilderImpl());
/* 125 */     this.listeners.add(
/* 126 */       new DefaultFormGridModelTargetListener(selectedsProperty));
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */   public TableActionColumnBuilder addRowAction(AbstractFormAction action)
/*     */   {
/* 136 */     this.actionColumnBuilder = new TableActionColumnBuilderImpl();
/* 137 */     this.actionColumnBuilder.setAction(action);
/* 138 */     return this.actionColumnBuilder;
/*     */   }
/*     */ 
/*     */   public FormGrid build()
/*     */   {
/* 145 */     FormGrid grid = internalBuild();
/* 146 */     grid.setListModelProperty(this.listProperty);
/* 147 */     return grid;
/*     */   }
/*     */ 
/*     */   protected FormGrid internalBuild()
/*     */   {
/* 154 */     DefaultFormGridModel tableModel = new DefaultFormGridModel();
/* 155 */     tableModel.setEmptyValuesMessage(this.exceptionMessageBuilder);
/* 156 */     buildColumns(tableModel);
/* 157 */     addActionColumn(tableModel);
/*     */ 
/* 159 */     FormGrid grid = new FormGrid(tableModel, this.listProperty);
/* 160 */     grid.setContainer(this.container);
/* 161 */     grid.setRowSelectionAllowed(this.isRowSelectionAllowed);
/* 162 */     grid.setSelectionMode(0);
/* 163 */     grid.setModelo(this.container.getModelo());
/* 164 */     grid.setDisableOn(this.disablePredicate);
/* 165 */     addDependencies(grid);
/* 166 */     addListeners(tableModel, grid);
/* 167 */     initGrid(grid);
/* 168 */     if (this.refreshThread != null) {
/* 169 */       this.refreshThread.setGrid(grid);
/* 170 */       new Thread(this.refreshThread).start();
/*     */     }
/* 172 */     return grid;
/*     */   }
/*     */ 
/*     */   protected void addDependencies(FormGrid grid) {
/* 176 */     for (Iterator iter = this.gridDependencies.iterator(); iter.hasNext(); ) {
/* 177 */       GridDependency dependency = (GridDependency)iter.next();
/* 178 */       dependency.setGrid(grid);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initGrid(FormGrid grid)
/*     */   {
/* 187 */     grid.initComponent();
/* 188 */     this.actionColumnBuilder.initColumns(grid);
/* 189 */     for (Iterator iter = this.columns.iterator(); iter.hasNext(); ) {
/* 190 */       TableColumnBuilderImpl colum = (TableColumnBuilderImpl)iter.next();
/* 191 */       colum.initColumns(grid);
/*     */     }
/* 193 */     grid.setBorder(BorderFactory.createDefaultGridBorder(
/* 194 */       StringProvider.getInstance().getValueOf(
/* 195 */       StringUtils.getI18NKey(this.container.getModelo(), 
/* 196 */       this.listProperty))));
/*     */   }
/*     */ 
/*     */   protected void addListeners(DefaultFormGridModel tableModel, FormGrid grid)
/*     */   {
/* 204 */     for (Iterator iter = this.listeners.iterator(); iter.hasNext(); ) {
/* 205 */       AbstractGridModelTargetListener mol = 
/* 206 */         (AbstractGridModelTargetListener)iter
/* 206 */         .next();
/* 207 */       mol.setBuilder(this);
/* 208 */       mol.setGridModel(tableModel);
/* 209 */       grid.addModelTargetListener(mol);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addActionColumn(FormGridModel gridModel) {
/* 214 */     this.actionColumnBuilder.build(gridModel);
/*     */   }
/*     */ 
/*     */   protected void buildColumns(FormGridModel tableModel)
/*     */   {
/* 223 */     for (Iterator iter = this.columns.iterator(); iter.hasNext(); )
/* 224 */       ((TableColumnBuilderImpl)iter.next()).build(tableModel);
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addSimpleRowSelectionMode(String propertyName)
/*     */   {
/* 233 */     AbstractGridModelTargetListener mol = new FormGridSimpleSelectorModelTargetListener();
/* 234 */     mol.setModelProperty(propertyName);
/* 235 */     this.isRowSelectionAllowed = true;
/* 236 */     this.listeners.add(mol);
/* 237 */     return this;
/*     */   }
/*     */ 
/*     */   public void addListener(AbstractGridModelTargetListener mol)
/*     */   {
/* 244 */     this.listeners.add(mol);
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent()
/*     */   {
/* 249 */     return !this.oneColumnGrid;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder setOneColumnGrid() {
/* 253 */     this.oneColumnGrid = true;
/* 254 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withContainer(RefreshableComponent container) {
/* 258 */     this.container = container;
/* 259 */     return this;
/*     */   }
/*     */ 
/*     */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*     */   {
/* 264 */     if (this.oneColumnGrid) {
/* 265 */       formBuilder.addComponent(build(), 
/* 266 */         constraintsProvider.getRowDiscriminator() + 
/* 267 */         " 2 2");
/*     */     } else {
/* 269 */       formBuilder.addComponent(build(), "0 + " + maxColumns * 2 + 
/* 270 */         " 2");
/* 271 */       constraintsProvider.rowElement();
/*     */     }
/*     */   }
/*     */ 
/*     */   public FormGridBuilderImpl withModelProperty(String modelProperty) {
/* 276 */     this.listProperty = modelProperty;
/* 277 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder withName(String name)
/*     */   {
/* 282 */     return this;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder addComponentDependency(FormComboBoxBuilder comboBuilder)
/*     */   {
/* 309 */     ComboSelectedGridDependency dependency = new ComboSelectedGridDependency();
/* 310 */     this.gridDependencies.add(dependency);
/* 311 */     comboBuilder.addItemListener(dependency);
/* 312 */     return this;
/*     */   }
/*     */ 
/*     */   public void setDisableOn(Predicate predicate) {
/* 316 */     this.disablePredicate = predicate;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder required()
/*     */   {
/* 321 */     return this;
/*     */   }
/*     */ 
/*     */   public FormGridBuilder setRefresh(long ms) {
/* 325 */     this.refreshThread = new GridRefreshRunnable(ms);
/* 326 */     return this;
/*     */   }
/*     */ 
/*     */   public MessageBuilder setOnEmptyExceptionMessage(String messageKey)
/*     */   {
/* 334 */     I18nMessageBuilderImpl builder = new I18nMessageBuilderImpl(messageKey);
/* 335 */     this.exceptionMessageBuilder = builder;
/* 336 */     return builder;
/*     */   }
/*     */ 
/*     */   private class DefaultFormGridModelTargetListener extends AbstractGridModelTargetListener
/*     */   {
/*     */     private final String property;
/*     */ 
/*     */     private DefaultFormGridModelTargetListener(String property)
/*     */     {
/* 291 */       this.property = property;
/*     */     }
/*     */ 
/*     */     public void unLoad(FormModel formModel) {
/* 295 */       formModel.setProperty(this.property, 
/* 296 */         getGridModel().getSelectedValues());
/*     */     }
/*     */ 
/*     */     public void load(FormModel model) {
/* 300 */       Collection seleccionados = (Collection)model.getProperty(this.property)
/* 301 */         .getValue();
/* 302 */       getGridModel().setSelectedValues(seleccionados);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormGridBuilderImpl
 * JD-Core Version:    0.6.0
 */