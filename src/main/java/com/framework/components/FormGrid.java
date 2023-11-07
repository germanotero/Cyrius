/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.GridTargetDecorator;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.sorter.TableSorter;
/*     */ import com.framework.components.wrappers.UseCaseImplementation;
/*     */ import com.framework.components.wrappers.UseCaseImplementationWrapper;
/*     */ import com.framework.entities.FormModelUtils;
/*     */ import com.framework.models.FormGridColumn;
/*     */ import com.framework.models.FormGridModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.ListSelectionModel;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.functors.FalsePredicate;
/*     */ 
/*     */ public class FormGrid extends FormScrollPanel
/*     */   implements RefreshableComponent
/*     */ {
/*  34 */   private Collection<ModelTargetListener> modelTargetListener = new ArrayList();
/*     */   private JTable tabla;
/*  38 */   private Predicate notVisibleCondition = FalsePredicate.INSTANCE;
/*     */   private TableSorter sorter;
/*     */   private String listModelProperty;
/*     */   private FormModel model;
/*     */   private String listProperty;
/*     */   private ModelTargetEnableContainer container;
/*     */ 
/*     */   public FormGrid(FormGridModel model, String modelProperty)
/*     */   {
/*  55 */     this.listProperty = modelProperty;
/*  56 */     this.tabla = new JTable();
/*  57 */     setViewportView(this.tabla);
/*  58 */     model.setGrid(this);
/*  59 */     this.sorter = new TableSorter(model);
/*  60 */     this.tabla.setModel(this.sorter);
/*  61 */     this.sorter.setTableHeader(this.tabla.getTableHeader());
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*  66 */     loadFromModel();
/*  67 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   public TableColumn getActionsColumn() {
/*  71 */     return this.tabla.getColumn("Accion");
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  78 */     this.modelTargetListener.add(listener);
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  86 */     if (this.tabla.getCellEditor() != null) {
/*  87 */       this.tabla.getCellEditor().stopCellEditing();
/*     */     }
/*  89 */     for (Iterator iter = this.modelTargetListener.iterator(); iter.hasNext(); ) {
/*  90 */       ModelTargetListener listener = (ModelTargetListener)iter.next();
/*  91 */       listener.unLoad(this.model);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setValue(Object model)
/*     */   {
/* 100 */     this.model = FormModelUtils.wrap(model);
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 108 */     loadFromModel();
/* 109 */     ((FormGridModel)this.sorter.getTableModel()).refresh();
/* 110 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   private void checkVisivility()
/*     */   {
/* 117 */     setVisible(!this.notVisibleCondition.evaluate(this.model));
/*     */   }
/*     */ 
/*     */   private void loadFromModel()
/*     */   {
/* 124 */     for (Iterator iter = this.modelTargetListener.iterator(); iter.hasNext(); ) {
/* 125 */       ModelTargetListener listener = (ModelTargetListener)iter.next();
/* 126 */       listener.load(this.model);
/*     */     }
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/* 135 */     this.notVisibleCondition = condition;
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */   public TableColumnModel getColumnModel() {
/* 140 */     return this.tabla.getColumnModel();
/*     */   }
/*     */ 
/*     */   public void setSelectionMode(int selectionModel)
/*     */   {
/* 145 */     this.tabla.setSelectionMode(selectionModel);
/*     */   }
/*     */ 
/*     */   public FormGridModel getTableModel() {
/* 149 */     return (FormGridModel)this.sorter.getTableModel();
/*     */   }
/*     */ 
/*     */   public int getSelectedRowIndex()
/*     */   {
/* 156 */     if (this.tabla.getSelectedRow() < 0)
/* 157 */       return this.tabla.getSelectedRow();
/* 158 */     return this.sorter.modelIndex(this.tabla.getSelectedRow());
/*     */   }
/*     */ 
/*     */   public void setSelectedIndex(int index) {
/* 162 */     this.tabla.getSelectionModel().setSelectionInterval(index, index);
/*     */   }
/*     */ 
/*     */   public void addColumn(FormGridColumn column) {
/* 166 */     this.tabla.addColumn((TableColumn)column);
/*     */   }
/*     */ 
/*     */   public void turnOff()
/*     */   {
/* 174 */     throw new RuntimeException(
/* 175 */       "Hay un error, como van a intentar apagar una grilla?");
/*     */   }
/*     */ 
/*     */   public FormModel getModelo()
/*     */   {
/* 183 */     return this.model;
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model)
/*     */   {
/* 190 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public String getListModelProperty() {
/* 194 */     return this.listModelProperty;
/*     */   }
/*     */ 
/*     */   public void setListModelProperty(String listModelProperty) {
/* 198 */     this.listModelProperty = listModelProperty;
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getOpenTarget()
/*     */   {
/* 206 */     return getGridTarget(null);
/*     */   }
/*     */ 
/*     */   private SimpleModelTarget getGridTarget(SimpleModelTarget target)
/*     */   {
/* 211 */     GridTargetDecorator gridTargetDecorator = new GridTargetDecorator(
/* 212 */       target)
/*     */     {
/*     */       protected FormModel initModel(FormModel parentModel) {
/* 215 */         if (getSelectedValue() != null)
/* 216 */           return FormModelUtils.wrap(getSelectedValue());
/* 217 */         return super.initModel(parentModel);
/*     */       }
/*     */ 
/*     */       protected void returnAction(FormModel childModel)
/*     */       {
/* 223 */         FormGrid.this.refreshComponent();
/*     */       }
/*     */     };
/* 226 */     if (getListModelProperty() != null)
/* 227 */       gridTargetDecorator.setRowCollection((Collection)
/* 228 */         this.model.getProperty(getListModelProperty()).getValue());
/* 229 */     gridTargetDecorator.setContainerValue(this.model);
/* 230 */     gridTargetDecorator.setPropertyValue(this.listProperty);
/* 231 */     gridTargetDecorator.setSelectedValue(
/* 232 */       getTableModel().getSelectedValue());
/* 233 */     return gridTargetDecorator;
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getReturnTarget()
/*     */   {
/* 241 */     throw new RuntimeException(
/* 242 */       "Se supone que la grilla es un caso especial de contenedor y nunca va a tener un Return Target");
/*     */   }
/*     */ 
/*     */   public void fireTableDataChange()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setContainer(ModelTargetEnableContainer container)
/*     */   {
/* 251 */     this.container = container;
/*     */   }
/*     */ 
/*     */   public ModelTargetEnableContainer getContainer() {
/* 255 */     UseCaseImplementationWrapper wrapper = new UseCaseImplementationWrapper(
/* 256 */       (UseCaseImplementation)this.container.getContainer());
/*     */ 
/* 259 */     wrapper.setOpenTarget(getGridTarget(wrapper.getOpenTarget()));
/* 260 */     return wrapper;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 264 */     throw new UnsupportedOperationException(
/* 265 */       "En esta version, no se pueden imprimir los datos de una grilla");
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 269 */     setNotVisibleOn(condition);
/* 270 */     return this;
/*     */   }
/*     */ 
/*     */   public void setRowSelectionAllowed(boolean value) {
/* 274 */     this.tabla.setRowSelectionAllowed(value);
/*     */   }
/*     */ 
/*     */   public void setFull()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setNotFull()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setCloseAction(FormAction action) {
/* 286 */     throw new RuntimeException(
/* 287 */       "Hay un error, como van a intentar apagar una grilla?");
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormGrid
 * JD-Core Version:    0.6.0
 */