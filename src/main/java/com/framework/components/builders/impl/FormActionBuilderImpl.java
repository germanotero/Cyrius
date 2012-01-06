/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractPanel;
/*     */ import com.framework.actions.CancelUseCaseAction;
/*     */ import com.framework.actions.FinalizeUseCaseAction;
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.NavigateBackAction;
/*     */ import com.framework.actions.NavigateForwardAction;
/*     */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class FormActionBuilderImpl
/*     */   implements FormActionBuilder
/*     */ {
/*     */   private AbstractPanel container;
/*  26 */   private Collection<FormAction> actions = new ArrayList();
/*     */ 
/*     */   public FormActionBuilderImpl(AbstractPanel container)
/*     */   {
/*  33 */     this.container = container;
/*     */   }
/*     */ 
/*     */   public FormAction addNavigateForwardAction()
/*     */   {
/*  42 */     FormAction action = new NavigateForwardAction();
/*  43 */     this.actions.add(action);
/*  44 */     return action;
/*     */   }
/*     */ 
/*     */   public FormAction addNavigateForwardAction(String i18key)
/*     */   {
/*  52 */     FormAction action = new NavigateForwardAction();
/*  53 */     this.actions.add(action);
/*  54 */     return action;
/*     */   }
/*     */ 
/*     */   public FinalizeUseCaseAction addFinalizeUseCaseAction()
/*     */   {
/*  62 */     FinalizeUseCaseAction action = new FinalizeUseCaseAction();
/*  63 */     this.actions.add(action);
/*  64 */     return action;
/*     */   }
/*     */ 
/*     */   public FormAction addNavigateBackAction()
/*     */   {
/*  71 */     FormAction action = new NavigateBackAction();
/*  72 */     this.actions.add(action);
/*  73 */     return action;
/*     */   }
/*     */ 
/*     */   public FormAction addNavigateBackAction(String key)
/*     */   {
/*  80 */     FormAction action = new NavigateBackAction(key);
/*  81 */     this.actions.add(action);
/*  82 */     return action;
/*     */   }
/*     */ 
/*     */   public FormAction addAction(FormAction action)
/*     */   {
/*  90 */     this.actions.add(action);
/*  91 */     return action;
/*     */   }
/*     */ 
/*     */   public FormAction addCancelUseCaseAction()
/*     */   {
/*  98 */     FormAction action = new CancelUseCaseAction(this.container);
/*  99 */     this.actions.add(action);
/* 100 */     this.container.setCloseAction(action);
/* 101 */     return action;
/*     */   }
/*     */ 
/*     */   public void build() {
/* 105 */     for (Iterator iter = this.actions.iterator(); iter.hasNext(); ) {
/* 106 */       FormAction componente = (FormAction)iter.next();
/* 107 */       componente.setModelo(this.container.getModelo());
/* 108 */       componente.setParent(this.container);
/* 109 */       componente.initComponent();
/* 110 */       this.container.addAction(componente);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormActionBuilderImpl
 * JD-Core Version:    0.6.0
 */