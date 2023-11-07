/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.FormDataComponent;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.DirectFormDataComponentClosure;
/*     */ import com.framework.components.FormCheckBox;
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormContainer;
/*     */ import com.framework.components.FormValueSelectionContainer;
/*     */ import com.framework.components.ModelEnableElementsContainer;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.exceptions.NotFullFormException;
/*     */ import com.framework.exceptions.NotFullFormExceptionBuilder;
/*     */ import com.framework.factorys.CyriusForm;
/*     */ import com.framework.factorys.RefreshableContainer;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.FormattedPrintDirector;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.ArrayIterator;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.ExtraCollectionUtils;
/*     */ import com.framework.utils.StringProvider;
/*     */ import com.framework.utils.StringUtils;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.LayoutManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public abstract class AbstractPanel extends JPanel
/*     */   implements CyriusForm, ModelEnableElementsContainer, RefreshableContainer, FormattedPrintDirector
/*     */ {
/*  56 */   protected transient Log log = LogFactory.getLog(getClass());
/*     */   private RefreshableComponent padre;
/*     */   private JScrollPane elementsScrollPanel;
/*     */   private JPanel actionsPanel;
/*     */   protected JPanel elementsPanel;
/*     */   private Boolean imprimeReducido;
/*     */ 
/*     */   public AbstractPanel()
/*     */   {
/*  71 */     super.setLayout(new BorderLayout());
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  76 */     if (super.getName() == null)
/*  77 */       super.setName(StringProvider.getInstance()
/*  78 */         .getValueOf(StringUtils.getI18NKey(this, 
/*  79 */         getModelo().getDecoratedClass().getName())));
/*  80 */     return super.getName();
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setPadre(RefreshableComponent parent) {
/*  88 */     this.padre = parent;
/*     */   }
/*     */ 
/*     */   public RefreshableComponent getContainer() {
/*  92 */     return this.padre;
/*     */   }
/*     */ 
/*     */   public FormModel getModelo() {
/*  96 */     return this.padre.getModelo();
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 103 */     Collection components = getAllComponents();
/* 104 */     for (Iterator iter = components.iterator(); iter.hasNext(); ) {
/* 105 */       Object next = iter.next();
/* 106 */       ((FormComponent)next).refreshComponent();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/* 118 */     if (isEnabled()) {
/* 119 */       Collection components = getAllModelableComponents();
/* 120 */       NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
/* 121 */       for (Iterator iter = components.iterator(); iter.hasNext(); ) {
/*     */         try {
/* 123 */           ((FormContainer)iter.next()).impactModel(validate);
/*     */         } catch (NotFullFormException nffe) {
/* 125 */           builder.add(nffe);
/*     */         }
/*     */       }
/* 128 */       if (builder.hasException())
/* 129 */         throw builder.build();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Collection getAllComponents()
/*     */   {
/* 135 */     Collection components = new ArrayList();
/* 136 */     components.addAll(ExtraCollectionUtils.arrayToCollection(
/* 137 */       this.elementsPanel.getComponents()));
/* 138 */     components.addAll(ExtraCollectionUtils.arrayToCollection(
/* 139 */       this.actionsPanel.getComponents()));
/*     */ 
/* 145 */     return ExtraCollectionUtils.select(components, new Predicate()
/*     */     {
/*     */       public boolean evaluate(Object arg0) {
/* 148 */         return arg0 instanceof FormComponent;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   protected Collection getAllModelableComponents()
/*     */   {
/* 156 */     return ExtraCollectionUtils.select(getAllComponents(), new Predicate() {
/*     */       public boolean evaluate(Object model) {
/* 158 */         return model instanceof FormContainer;
/*     */       } } );
/*     */   }
/*     */ 
/*     */   public Collection getAllValueSelectionComponents() {
/* 164 */     Collection col = CollectionFactory.createCollection();
/* 165 */     for (Iterator iter = getAllComponents().iterator(); iter.hasNext(); ) {
/* 166 */       Component componente = (Component)iter.next();
/* 167 */       if ((componente instanceof AbstractPanel))
/* 168 */         col.addAll(getAllElements((AbstractPanel)componente));
/* 169 */       if ((componente instanceof FormValueSelectionContainer))
/* 170 */         col.add(componente);
/*     */     }
/* 172 */     return col;
/*     */   }
/*     */ 
/*     */   protected Collection getAllElements(AbstractPanel panel) {
/* 176 */     Collection col = CollectionFactory.createCollection();
/* 177 */     col.addAll(panel.getAllValueSelectionComponents());
/* 178 */     return col;
/*     */   }
/*     */ 
/*     */   public void restart()
/*     */   {
/* 185 */     Collection components = getAllComponents();
/* 186 */     for (Iterator iter = components.iterator(); iter.hasNext(); )
/* 187 */       ((FormComponent)iter.next()).refreshComponent();
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model)
/*     */   {
/* 195 */     this.padre.setModelo(model);
/*     */   }
/*     */ 
/*     */   public void addAction(FormAction action) {
/* 199 */     this.actionsPanel.add((Component)action);
/*     */   }
/*     */ 
/*     */   public void addElement(FormComponent formComponent, Object constraints) {
/* 203 */     Component component = (Component)formComponent;
/* 204 */     this.elementsPanel.add(component, constraints);
/*     */   }
/*     */ 
/*     */   public void addElement(Component comp, Object gbc) {
/* 208 */     this.elementsPanel.add(comp, gbc);
/*     */   }
/*     */ 
/*     */   public void setLayout(LayoutManager mgr)
/*     */   {
/* 215 */     if (this.elementsPanel != null)
/* 216 */       this.elementsPanel.setLayout(mgr);
/*     */   }
/*     */ 
/*     */   protected boolean withScrollPanel() {
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */   public void setUp()
/*     */   {
/* 225 */     this.elementsPanel = new JPanel();
/* 226 */     if (withScrollPanel()) {
/* 227 */       this.elementsScrollPanel = new JScrollPane();
/* 228 */       add(this.elementsScrollPanel, "Center");
/* 229 */       this.elementsScrollPanel.setViewportView(this.elementsPanel);
/* 230 */       this.elementsScrollPanel.setWheelScrollingEnabled(true);
/*     */     }
/*     */     else {
/* 233 */       add(this.elementsPanel, "Center");
/*     */     }
/*     */ 
/* 236 */     this.actionsPanel = new JPanel(new FlowLayout(1, 30, 6));
/* 237 */     add(this.actionsPanel, "South");
/*     */   }
/*     */ 
/*     */   public void setEnabled(boolean enabled)
/*     */   {
/* 244 */     super.setEnabled(enabled);
/* 245 */     for (Iterator iter = getAllComponents().iterator(); iter.hasNext(); ) {
/* 246 */       JComponent component = (JComponent)iter.next();
/* 247 */       component.setEnabled(enabled);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void changeVisibilityOfOthersComponents(FormCheckBox check, boolean visibleValue)
/*     */   {
/* 261 */     for (Iterator iter = getAllComponents().iterator(); iter.hasNext(); ) {
/* 262 */       FormComponent componente = (FormComponent)iter.next();
/* 263 */       if (!componente.equals(check))
/* 264 */         componente.setVisible(visibleValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void turnOff()
/*     */   {
/* 274 */     this.padre.turnOff();
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getOpenTarget()
/*     */   {
/* 282 */     return this.padre.getOpenTarget();
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getReturnTarget()
/*     */   {
/* 290 */     return this.padre.getReturnTarget();
/*     */   }
/*     */ 
/*     */   public void addElement(FormComponent component) {
/* 294 */     this.elementsPanel.add((Component)component);
/*     */   }
/*     */ 
/*     */   public Iterator dataComponentsIterator()
/*     */   {
/* 299 */     return new ArrayIterator(this.elementsPanel.getComponents(), 
/* 300 */       new Predicate()
/*     */     {
/*     */       public boolean evaluate(Object arg0) {
/* 303 */         return arg0 instanceof FormDataComponent;
/*     */       } } );
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 309 */     if (isEnabled())
/* 310 */       ExtraCollectionUtils.forAllDo(dataComponentsIterator(), 
/* 311 */         new DirectFormDataComponentClosure(print));
/*     */   }
/*     */ 
/*     */   public boolean isCompleted() {
/* 315 */     return ExtraCollectionUtils.and(getAllElements(this), new Predicate()
/*     */     {
/*     */       public boolean evaluate(Object arg0) {
/* 318 */         FormValueSelectionContainer element = (FormValueSelectionContainer)arg0;
/* 319 */         return !element.isEmpty();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public Boolean isImprimeReducido()
/*     */   {
/* 327 */     return this.imprimeReducido;
/*     */   }
/*     */ 
/*     */   public void setImprimeReducido(Boolean imprimeReducido) {
/* 331 */     this.imprimeReducido = imprimeReducido;
/*     */   }
/*     */ 
/*     */   public void setCloseAction(FormAction action) {
/* 335 */     getContainer().setCloseAction(action);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.AbstractPanel
 * JD-Core Version:    0.6.0
 */