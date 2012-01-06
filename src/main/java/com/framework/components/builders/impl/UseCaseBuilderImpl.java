/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*    */ import com.framework.abstractfactorys.PanelsRegistry;
/*    */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*    */ import com.framework.components.wrappers.UseCaseImplementation;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class UseCaseBuilderImpl
/*    */   implements UseCaseBuilder
/*    */ {
/*    */   private AbstractUseCaseFactory useCaseFactory;
/* 21 */   private PanelsRegistry contentRegistry = new PanelsRegistry();
/*    */ 
/*    */   public UseCaseBuilderImpl(AbstractUseCaseFactory abstractUseCaseFactory)
/*    */   {
/* 25 */     this.useCaseFactory = abstractUseCaseFactory;
/*    */   }
/*    */ 
/*    */   public void addPanel(AbstractPanel panel) {
/* 29 */     this.contentRegistry.addPanel(panel);
/*    */   }
/*    */ 
/*    */   public void build() {
/* 33 */     this.useCaseFactory.setMultiplePanels(
/* 34 */       this.contentRegistry.getPanels().size() > 1);
/* 35 */     for (Iterator iter = this.contentRegistry.getPanels().iterator(); iter
/* 36 */       .hasNext(); )
/*    */     {
/* 37 */       AbstractPanel panel = (AbstractPanel)iter.next();
/* 38 */       FormElementsBuilderImpl elementBuilder = new FormElementsBuilderImpl(
/* 39 */         panel);
/* 40 */       FormActionBuilderImpl actionBuilder = new FormActionBuilderImpl(
/* 41 */         panel);
/*    */ 
/* 43 */       panel.setPadre(this.useCaseFactory.getInternalWindow());
/* 44 */       panel
/* 45 */         .setPreferredSize(this.useCaseFactory.getInternalWindow()
/* 46 */         .getSize());
/* 47 */       panel.setUp();
/*    */ 
/* 49 */       panel.registerElements(elementBuilder);
/* 50 */       elementBuilder.build();
/*    */ 
/* 52 */       panel.registerActions(actionBuilder);
/* 53 */       actionBuilder.build();
/*    */ 
/* 55 */       this.useCaseFactory.addPanel(panel.getName(), panel);
/*    */ 
/* 57 */       panel.initComponent();
/*    */     }
/* 59 */     this.useCaseFactory.setPanelRegistry(this.contentRegistry);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.UseCaseBuilderImpl
 * JD-Core Version:    0.6.0
 */