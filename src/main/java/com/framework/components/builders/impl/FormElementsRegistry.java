/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.builders.interfaces.ElementsRegistry;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public class FormElementsRegistry
/*    */   implements ElementsRegistry
/*    */ {
/* 15 */   private Collection<FormComponentBuilder> elements = CollectionFactory.createCollection(FormComponentBuilder.class);
/*    */ 
/*    */   public Collection getSimpleElements() {
/* 18 */     return CollectionUtils.select(this.elements, new SimpleElementPredicate());
/*    */   }
/*    */ 
/*    */   public Collection getRowElements() {
/* 22 */     return CollectionUtils.select(this.elements, new RowElementPredicate());
/*    */   }
/*    */ 
/*    */   public void add(FormComponentBuilder builder) {
/* 26 */     this.elements.add(builder);
/*    */   }
/*    */ 
/*    */   public Collection getAllBuilders() {
/* 30 */     return this.elements;
/*    */   }
/*    */ 
/*    */   public void clear() {
/* 34 */     this.elements.clear();
/*    */   }
/*    */   private final class SimpleElementPredicate implements Predicate {
/*    */     private SimpleElementPredicate() {
/*    */     }
/* 39 */     public boolean evaluate(Object arg0) { FormComponentBuilder builder = (FormComponentBuilder)arg0;
/* 40 */       return !builder.isRowComponent(); }
/*    */   }
/*    */ 
/*    */   private final class RowElementPredicate implements Predicate
/*    */   {
/* 45 */     FormElementsRegistry.SimpleElementPredicate predicate = new FormElementsRegistry.SimpleElementPredicate();
/*    */ 
/*    */     private RowElementPredicate() {  }
/*    */ 
/* 48 */     public boolean evaluate(Object arg0) { return !this.predicate.evaluate(arg0);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormElementsRegistry
 * JD-Core Version:    0.6.0
 */