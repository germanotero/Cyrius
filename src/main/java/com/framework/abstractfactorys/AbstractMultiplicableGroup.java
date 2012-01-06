/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.actions.AbstractFormAction;
/*     */ import com.framework.components.FormModelContainer;
/*     */ import com.framework.components.FormValueSelectionContainer;
/*     */ import com.framework.components.RowComponent;
/*     */ import com.framework.components.builders.impl.DefaultFormComponentBuilder;
/*     */ import com.framework.components.builders.impl.FormElementsBuilderImpl;
/*     */ import com.framework.components.builders.impl.MultiplicableGroupElementBuilderImpl;
/*     */ import com.framework.components.builders.impl.MultliplicableGroupBuilderImpl;
/*     */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*     */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*     */ import com.framework.entities.DynamicFormModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.ArrayIterator;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ public abstract class AbstractMultiplicableGroup extends AbstractGroup
/*     */   implements FormModelContainer, RowComponent
/*     */ {
/*     */   private FormTabbedPanel tabbedPanel;
/*  33 */   private int i = 0;
/*     */   private MultiplicableGroupElementBuilderImpl builder;
/*  37 */   private String emptyText = "";
/*     */ 
/*  39 */   private boolean multplesEnable = false;
/*     */ 
/*  41 */   private boolean initialized = false;
/*     */ 
/*     */   protected void setEmptyText(String emptyText) {
/*  44 */     this.emptyText = emptyText;
/*     */   }
/*     */ 
/*     */   protected final void registerGroupElements(FormElementsBuilder elementBuilder)
/*     */   {
/*  53 */     ((FormElementsBuilderImpl)elementBuilder).setColumnsCount(1);
/*  54 */     this.tabbedPanel = new FormTabbedPanel(this);
/*  55 */     elementBuilder.addBuilder(new DefaultFormComponentBuilder(this.tabbedPanel));
/*  56 */     this.builder = new MultiplicableGroupElementBuilderImpl(this);
/*  57 */     this.builder.setColumnsCount(1);
/*  58 */     this.builder.build();
/*     */   }
/*     */ 
/*     */   public final void registerActions(FormActionBuilder builder)
/*     */   {
/*  65 */     builder.addAction(new AbstractFormAction() {
/*     */       protected boolean isImpactableModelAction() {
/*  67 */         return false;
/*     */       }
/*     */ 
/*     */       protected void setUpAction() {
/*  71 */         setActionKey("newTab");
/*     */       }
/*     */ 
/*     */       protected void executeFormAction(FormModel model) throws Exception
/*     */       {
/*  76 */         if (AbstractMultiplicableGroup.this.multplesEnable) {
/*  77 */           AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
/*  78 */           AbstractMultiplicableGroup.this.multplesEnable = false;
/*     */         }
/*  80 */         AbstractMultiplicableGroup.this.addTab();
/*     */       }
/*     */     });
/*  84 */     builder.addAction(new AbstractFormAction() {
/*     */       protected boolean isImpactableModelAction() {
/*  86 */         return false;
/*     */       }
/*     */ 
/*     */       protected void setUpAction() {
/*  90 */         setActionKey("removeTab");
/*     */       }
/*     */ 
/*     */       protected void executeFormAction(FormModel model) throws Exception {
/*  94 */         if (AbstractMultiplicableGroup.this.multplesEnable) {
/*  95 */           AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
/*  96 */           AbstractMultiplicableGroup.this.multplesEnable = false;
/*     */         } else {
/*  98 */           AbstractMultiplicableGroup.this.removeTab();
/*     */         }
/*     */       }
/*     */     });
/* 101 */     builder.addAction(new AbstractFormAction()
/*     */     {
/*     */       protected boolean isImpactableModelAction()
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */ 
/*     */       protected void executeFormAction(FormModel model)
/*     */         throws Exception
/*     */       {
/* 111 */         AbstractMultiplicableGroup.this.i = 0;
/* 112 */         AbstractMultiplicableGroup.this.tabbedPanel.removeAll();
/* 113 */         AbstractMultiplicableGroup.this.addMultipleTab();
/* 114 */         AbstractMultiplicableGroup.this.refreshComponent();
/*     */       }
/*     */ 
/*     */       protected void setUpAction()
/*     */       {
/* 119 */         setActionKey("multiplesAction");
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   protected final void initSubComponent()
/*     */   {
/* 130 */     if (this.initialized) {
/* 131 */       return;
/*     */     }
/* 133 */     this.initialized = true;
/* 134 */     List realModel = (List)getModelo().getValue();
/* 135 */     for (ListIterator iter = realModel.listIterator(); iter.hasNext(); ) {
/* 136 */       FormModel model = (FormModel)iter.next();
/*     */ 
/* 138 */       if ((model.getValue() instanceof MultiplesModel))
/* 139 */         addMultipleTab();
/*     */       else
/* 141 */         addTab();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected Class getAsociatedModel()
/*     */   {
/* 151 */     return List.class;
/*     */   }
/*     */ 
/*     */   private synchronized void addTab() {
/* 155 */     MultliplicableGroupBuilderImpl multiplicableGroupBuilder = addTabDefaultStrategy(
/* 156 */       this.builder, this.i);
/* 157 */     multiplicableGroupBuilder.withModelClass(DynamicFormModel.class);
/* 158 */     multiplicableGroupBuilder.withName(
/* 159 */       getName() + " N°" + (this.i + 1));
/* 160 */     multiplicableGroupBuilder.withOutBorder();
/* 161 */     AbstractGroup group = (AbstractGroup)multiplicableGroupBuilder.build();
/* 162 */     group.setPadre(this);
/* 163 */     this.tabbedPanel.addTab(group.getName(), group);
/* 164 */     this.i += 1;
/*     */   }
/*     */ 
/*     */   private synchronized void addMultipleTab() {
/* 168 */     this.multplesEnable = true;
/* 169 */     MultliplicableGroupBuilderImpl multiplicableGroupBuilder = (MultliplicableGroupBuilderImpl)this.builder
/* 170 */       .addGroup(MultiplesGroup.class, this.i);
/* 171 */     multiplicableGroupBuilder.withModelClass(DynamicFormModel.class);
/* 172 */     multiplicableGroupBuilder.withName("");
/* 173 */     multiplicableGroupBuilder.withOutBorder();
/* 174 */     AbstractGroup group = (AbstractGroup)multiplicableGroupBuilder.build();
/* 175 */     group.setPadre(this);
/* 176 */     this.tabbedPanel.addTab(group.getName(), group);
/*     */   }
/*     */ 
/*     */   protected MultliplicableGroupBuilderImpl addTabDefaultStrategy(MultiplicableGroupElementBuilderImpl builder, int index)
/*     */   {
/* 181 */     MultliplicableGroupBuilderImpl multiplicableGroupBuilder = (MultliplicableGroupBuilderImpl)builder
/* 182 */       .addGroup(getGroupToBeMultiplicated(), index);
/* 183 */     return multiplicableGroupBuilder;
/*     */   }
/*     */ 
/*     */   private synchronized void removeTab()
/*     */   {
/* 188 */     if (this.tabbedPanel.getTabCount() > 0) {
/* 189 */       this.tabbedPanel.remove(this.tabbedPanel.getTabCount() - 1);
/* 190 */       this.i -= 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected Color getBackgroundColor() {
/* 195 */     return ColorFactory.createMultiplicableGroupColor();
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print)
/*     */   {
/* 200 */     print.startGroup(this);
/* 201 */     if (this.tabbedPanel.getTabCount() < 1) {
/* 202 */       print.addInputValue("", this.emptyText);
/* 203 */       print.endGroup(this);
/* 204 */       return;
/*     */     }
/* 206 */     if (!this.multplesEnable)
/* 207 */       print.addInputValue("Cantidad", new Integer(this.i));
/* 208 */     Iterator groupsIterator = new ArrayIterator(
/* 209 */       this.tabbedPanel.getComponents());
/* 210 */     while (groupsIterator.hasNext()) {
/* 211 */       Object next = groupsIterator.next();
/* 212 */       if ((next instanceof AbstractPanel)) {
/* 213 */         AbstractPanel element = (AbstractPanel)next;
/* 214 */         if (element.isEnabled())
/* 215 */           element.direct(print);
/*     */       }
/*     */     }
/* 218 */     print.endGroup(this);
/*     */   }
/*     */ 
/*     */   public Collection getAllValueSelectionComponents() {
/* 222 */     Collection col = CollectionFactory.createCollection();
/* 223 */     ArrayIterator iter = new ArrayIterator(this.tabbedPanel.getComponents());
/* 224 */     while (iter.hasNext()) {
/* 225 */       Component componente = (Component)iter.next();
/* 226 */       if ((componente instanceof AbstractPanel))
/* 227 */         col.addAll(getAllElements((AbstractPanel)componente));
/* 228 */       if ((componente instanceof FormValueSelectionContainer))
/* 229 */         col.add(componente);
/*     */     }
/* 231 */     return col;
/*     */   }
/*     */ 
/*     */   protected abstract Class getGroupToBeMultiplicated();
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.AbstractMultiplicableGroup
 * JD-Core Version:    0.6.0
 */