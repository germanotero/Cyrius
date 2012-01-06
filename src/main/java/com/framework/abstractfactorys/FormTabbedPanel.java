/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormContainer;
/*     */ import com.framework.components.RowComponent;
/*     */ import com.framework.components.builders.impl.FormActionBuilderImpl;
/*     */ import com.framework.components.builders.impl.FormElementsBuilderImpl;
/*     */ import com.framework.exceptions.NotFullFormException;
/*     */ import com.framework.exceptions.NotFullFormExceptionBuilder;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.ArrayIterator;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import com.framework.utils.StringProvider;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JTabbedPane;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ import org.apache.commons.collections.functors.FalsePredicate;
/*     */ 
/*     */ public class FormTabbedPanel extends JTabbedPane
/*     */   implements FormContainer, RowComponent
/*     */ {
/*     */   private Predicate visibleCondition;
/*     */   private AbstractPanel parent;
/*  33 */   private Predicate disablePredicate = FalsePredicate.INSTANCE;
/*     */ 
/*     */   public FormTabbedPanel(AbstractPanel parent)
/*     */   {
/*  37 */     this.parent = parent;
/*  38 */     setTabLayoutPolicy(1);
/*  39 */     setTabPlacement(3);
/*     */   }
/*     */ 
/*     */   public final void initComponent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public final boolean hasVisibleCondition()
/*     */   {
/*  49 */     return this.visibleCondition != null;
/*     */   }
/*     */ 
/*     */   public final FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/*  56 */     this.visibleCondition = condition;
/*  57 */     return this;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/*  64 */     NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
/*  65 */     for (Iterator iter = getGroups(); iter.hasNext(); ) {
/*     */       try {
/*  67 */         AbstractGroup grupo = (AbstractGroup)iter.next();
/*  68 */         grupo.impactModel(validate);
/*     */       } catch (NotFullFormException nffe) {
/*  70 */         builder.add(nffe);
/*     */       }
/*     */     }
/*  73 */     if (builder.hasException())
/*  74 */       throw builder.build();
/*     */   }
/*     */ 
/*     */   private Iterator getGroups() {
/*  78 */     return new ArrayIterator(getComponents(), 
/*  79 */       new InstanceOfAbstractGroupPredicate());
/*     */   }
/*     */ 
/*     */   public boolean isRowComponent()
/*     */   {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  91 */     for (Iterator iter = getGroups(); iter.hasNext(); ) {
/*  92 */       AbstractGroup grupo = (AbstractGroup)iter.next();
/*  93 */       grupo.refreshComponent();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void initGroups()
/*     */   {
/*  99 */     for (Iterator iter = getGroups(); iter.hasNext(); ) {
/* 100 */       AbstractGroup grupo = (AbstractGroup)iter.next();
/* 101 */       grupo.setPadre(this.parent);
/* 102 */       initGroup(grupo);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void setUpGroup(AbstractGroup group) {
/* 107 */     FormElementsBuilderImpl elementBuilder = new FormElementsBuilderImpl(
/* 108 */       group);
/* 109 */     FormActionBuilderImpl actionBuilder = new FormActionBuilderImpl(group);
/* 110 */     group.setUp();
/* 111 */     group.registerElements(elementBuilder);
/* 112 */     elementBuilder.build();
/* 113 */     group.registerActions(actionBuilder);
/* 114 */     actionBuilder.build();
/* 115 */     group.initComponent();
/*     */   }
/*     */ 
/*     */   protected void initGroup(AbstractGroup group) {
/* 119 */     setUpGroup(group);
/* 120 */     String title = StringProvider.getInstance().getValueOf(
/* 121 */       group.getClass().getName());
/* 122 */     group.setBorder(BorderFactory.createDefaultGroupBorder(title));
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 129 */     return false;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 133 */     CollectionUtils.forAllDo(getGroups(), 
/* 134 */       new DirectGroupsClosure(print));
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition)
/*     */   {
/* 145 */     this.disablePredicate = condition;
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */   private class InstanceOfAbstractGroupPredicate
/*     */     implements Predicate
/*     */   {
/*     */     private InstanceOfAbstractGroupPredicate()
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean evaluate(Object arg0)
/*     */     {
/* 139 */       return arg0 instanceof AbstractGroup;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FormTabbedPanel
 * JD-Core Version:    0.6.0
 */