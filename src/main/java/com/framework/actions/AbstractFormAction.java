/*     */ package com.framework.actions;
/*     */ 
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.StringUtils;
/*     */ import java.awt.Cursor;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public abstract class AbstractFormAction extends AbstractAction
/*     */   implements FormAction
/*     */ {
/*     */   private ModelTargetEnableContainer padre;
/*  28 */   private Predicate invisibleCondition = FalsePredicate.INSTANCE;
/*     */   private FormModel modelo;
/*  32 */   private boolean refreshAfterExecute = false;
/*     */ 
/*  34 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*  36 */   private boolean validate = true;
/*     */ 
/*     */   public void setRefreshAfterExecute(boolean refreshAfterExecute) {
/*  39 */     this.refreshAfterExecute = refreshAfterExecute;
/*     */   }
/*     */ 
/*     */   public void dontValidate() {
/*  43 */     this.validate = false;
/*     */   }
/*     */ 
/*     */   public AbstractFormAction()
/*     */   {
/*     */   }
/*     */ 
/*     */   public AbstractFormAction(ModelTargetEnableContainer frameFactory) {
/*  51 */     this(frameFactory, null);
/*     */   }
/*     */ 
/*     */   public AbstractFormAction(Icon icon) {
/*  55 */     super(icon);
/*     */   }
/*     */ 
/*     */   public AbstractFormAction(ModelTargetEnableContainer container, ImageIcon icon)
/*     */   {
/*  60 */     this(icon);
/*  61 */     this.padre = container;
/*     */   }
/*     */ 
/*     */   protected String getActionKey()
/*     */   {
/*  73 */     Object modelo = this.padre != null ? this.padre.getModelo() : "";
/*  74 */     return StringUtils.getI18NKey(modelo, super.getActionKey());
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel modelo) {
/*  78 */     this.modelo = modelo;
/*     */   }
/*     */ 
/*     */   public void setParent(ModelTargetEnableContainer model) {
/*  82 */     this.padre = model;
/*     */   }
/*     */ 
/*     */   public Object getModelo() {
/*  86 */     return this.modelo;
/*     */   }
/*     */ 
/*     */   protected ModelTargetEnableContainer getPadre()
/*     */   {
/*  93 */     return this.padre.getContainer();
/*     */   }
/*     */ 
/*     */   protected ModelTargetEnableContainer getPanelParent() {
/*  97 */     return this.padre;
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/* 102 */     super.initComponent();
/* 103 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 112 */     checkVisivility();
/*     */   }
/*     */ 
/*     */   private void checkVisivility()
/*     */   {
/* 119 */     setVisible(!this.invisibleCondition.evaluate(this.modelo));
/* 120 */     setEnabled(!this.disablePredicate.evaluate(this.modelo));
/*     */   }
/*     */ 
/*     */   protected final void executeAction(Object model)
/*     */     throws Exception
/*     */   {
/* 127 */     if (isImpactableModelAction())
/* 128 */       getPadre().impactModel(this.validate);
/* 129 */     executeFormAction(getPadre().getOpenTarget()
/* 130 */       .getModel(this.modelo));
/* 131 */     if (this.refreshAfterExecute)
/* 132 */       this.padre.refreshComponent();
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/* 139 */     this.invisibleCondition = condition;
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 144 */     this.disablePredicate = condition;
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */   protected void preExecution()
/*     */   {
/* 150 */     getPadre().setCursor(new Cursor(3));
/*     */   }
/*     */ 
/*     */   protected void rearmOldState()
/*     */   {
/* 155 */     getPadre().setCursor(new Cursor(0));
/*     */   }
/*     */ 
/*     */   protected abstract boolean isImpactableModelAction();
/*     */ 
/*     */   protected abstract void executeFormAction(FormModel paramFormModel)
/*     */     throws Exception;
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.AbstractFormAction
 * JD-Core Version:    0.6.0
 */