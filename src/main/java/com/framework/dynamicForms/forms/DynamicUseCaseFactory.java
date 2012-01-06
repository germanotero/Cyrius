/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.components.builders.impl.GroupBuilderImpl;
/*    */ import com.framework.components.builders.interfaces.MenuBarBuilder;
/*    */ import com.framework.components.builders.interfaces.MenuBuilder;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.entities.DynamicGroupElement;
/*    */ import com.framework.dynamicForms.entities.RelacionGroup;
/*    */ import com.framework.entities.DynamicFormModel;
/*    */ import com.framework.integration.PrintFormAction;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public final class DynamicUseCaseFactory extends AbstractUseCaseFactory
/*    */ {
/*    */   private DynamicForm form;
/*    */ 
/*    */   DynamicUseCaseFactory(DynamicForm form)
/*    */   {
/* 37 */     setTabPopUp(true);
/* 38 */     this.form = form;
/* 39 */     setName(form.getName());
/*    */   }
/*    */ 
/*    */   protected void addMenuBar(MenuBarBuilder menuBuilder)
/*    */   {
/* 44 */     menuBuilder.addMenu("Impresion").addMenuItem(new PrintFormAction())
/* 45 */       .addMenuItem(new PrintFormAction(new ImprimirReducido()));
/*    */   }
/*    */ 
/*    */   public void registerFactorys(UseCaseBuilder builder) {
/* 49 */     Collection groupElements = this.form.getGroupElements();
/* 50 */     Collections.sort(CollectionFactory.createList(groupElements));
/* 51 */     for (Iterator iter = groupElements.iterator(); iter.hasNext(); ) {
/* 52 */       RelacionGroup relacion = (RelacionGroup)iter.next();
/* 53 */       DynamicGroupElement element = relacion.getGroup();
/* 54 */       GroupBuilderImpl groupBuilder = (GroupBuilderImpl)element
/* 55 */         .getBuilder();
/* 56 */       AbstractPanel panel = new DefaultTab(groupBuilder, element);
/* 57 */       panel.setImprimeReducido(relacion.getImprimeReducido());
/* 58 */       builder.addPanel(panel);
/*    */     }
/* 60 */     if (!this.form.getSimpleElements().isEmpty())
/* 61 */       builder.addPanel(new MainDynamicPanel(this.form));
/*    */   }
/*    */ 
/*    */   public Class getAsociatedModel() {
/* 65 */     return DynamicFormModel.class;
/*    */   }
/*    */ 
/*    */   private class ImprimirReducido
/*    */     implements Predicate
/*    */   {
/*    */     private ImprimirReducido()
/*    */     {
/*    */     }
/*    */ 
/*    */     public boolean evaluate(Object arg0)
/*    */     {
/* 28 */       AbstractPanel panel = (AbstractPanel)arg0;
/* 29 */       return panel.isImprimeReducido().booleanValue();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicUseCaseFactory
 * JD-Core Version:    0.6.0
 */