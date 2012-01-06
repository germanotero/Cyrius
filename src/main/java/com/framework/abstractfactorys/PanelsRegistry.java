/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class PanelsRegistry
/*    */ {
/* 18 */   private Collection<AbstractPanel> panels = CollectionFactory.createCollection(AbstractPanel.class);
/*    */ 
/*    */   public void addPanel(AbstractPanel panel) {
/* 21 */     this.panels.add(panel);
/*    */   }
/*    */ 
/*    */   public Collection getPanels() {
/* 25 */     return this.panels;
/*    */   }
/*    */ 
/*    */   public Iterator panelsIterator() {
/* 29 */     return this.panels.iterator();
/*    */   }
/*    */ 
/*    */   public boolean moreThanOnePanel() {
/* 33 */     return this.panels.size() > 1;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.PanelsRegistry
 * JD-Core Version:    0.6.0
 */