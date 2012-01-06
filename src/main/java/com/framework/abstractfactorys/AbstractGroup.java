/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormModelContainer;
/*     */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*     */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.components.listeners.NullModelTargetListener;
/*     */ import com.framework.entities.FormModelUtils;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.ClassUtils;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import org.apache.commons.collections.Closure;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public abstract class AbstractGroup extends AbstractPanel
/*     */   implements FormModelContainer
/*     */ {
/*  30 */   private Predicate invisiblePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  32 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */   private FormModel model;
/*  36 */   private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();
/*     */ 
/*     */   public final void initComponent() {
/*  39 */     this.modelTargetListener.load(this.model);
/*  40 */     initSubComponent();
/*  41 */     CollectionUtils.forAllDo(getAllComponents(), new CheckEnabilityClosure());
/*  42 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print)
/*     */   {
/*  47 */     print.startGroup(this);
/*  48 */     super.direct(print);
/*  49 */     print.endGroup(this);
/*     */   }
/*     */ 
/*     */   protected void initSubComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void registerElements(FormElementsBuilder builder) {
/*  57 */     registerGroupElements(builder);
/*     */   }
/*     */ 
/*     */   public void registerActions(FormActionBuilder builder) {
/*  61 */     registerGroupActions(builder);
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  66 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model) {
/*  70 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public FormModel getModelo()
/*     */   {
/*  75 */     if (this.model != null)
/*  76 */       return this.model;
/*  77 */     Class asociatedModelClass = getAsociatedModel();
/*  78 */     if (asociatedModelClass == null)
/*  79 */       return super.getModelo();
/*  80 */     this.model = FormModelUtils.wrap(ClassUtils.newInstance(asociatedModelClass));
/*  81 */     return this.model;
/*     */   }
/*     */ 
/*     */   public final FormComponent setNotVisibleOn(Predicate predicate) {
/*  85 */     this.invisiblePredicate = predicate;
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate predicate) {
/*  90 */     this.disablePredicate = predicate;
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  96 */     CollectionUtils.forAllDo(getAllComponents(), new RefreshClosure());
/*  97 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   private void checkVisivility()
/*     */   {
/* 102 */     setVisible(!this.invisiblePredicate.evaluate(getModelo()));
/*     */   }
/*     */ 
/*     */   public final void setVisible(boolean b) {
/* 106 */     super.setVisible(b);
/* 107 */     if (b)
/* 108 */       this.modelTargetListener.load(null);
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate) {
/* 112 */     super.impactModel(validate);
/* 113 */     this.modelTargetListener.unLoad(this.model);
/*     */   }
/*     */ 
/*     */   protected void registerGroupActions(FormActionBuilder builder)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 129 */     return false; } 
/*     */   protected abstract Class getAsociatedModel();
/*     */ 
/*     */   protected abstract void registerGroupElements(FormElementsBuilder paramFormElementsBuilder);
/*     */ 
/* 134 */   private class RefreshClosure implements Closure { private AbstractGroup.CheckEnabilityClosure enableClosure = new AbstractGroup.CheckEnabilityClosure();
/*     */ 
/*     */     private RefreshClosure() {  }
/*     */ 
/* 137 */     public void execute(Object arg0) { FormComponent element = (FormComponent)arg0;
/* 138 */       element.refreshComponent();
/* 139 */       this.enableClosure.execute(arg0); } }
/*     */ 
/*     */   private class CheckEnabilityClosure implements Closure {
/*     */     private CheckEnabilityClosure() {
/*     */     }
/*     */ 
/*     */     public void execute(Object object) {
/* 146 */       FormComponent element = (FormComponent)object;
/* 147 */       if (!AbstractGroup.this.disablePredicate.equals(FalsePredicate.INSTANCE)) {
/* 148 */         boolean result = AbstractGroup.this.disablePredicate.evaluate(AbstractGroup.this.getModelo().getValue());
/* 149 */         element.setEnabled(!result);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.AbstractGroup
 * JD-Core Version:    0.6.0
 */