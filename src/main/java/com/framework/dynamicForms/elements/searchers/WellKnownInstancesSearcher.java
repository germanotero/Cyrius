/*    */ package com.framework.dynamicForms.elements.searchers;
/*    */ 
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public abstract class WellKnownInstancesSearcher<T>
/*    */ {
/*    */   private Collection<T> instances;
/*    */ 
/*    */   public <T> T findByName(String name)
/*    */   {
/* 20 */     return (T)findByName2(name);
/*    */   }
/*    */ 
/*    */   protected final <T> Object findByName2(final String name)
/*    */   {
/* 25 */     return CollectionUtils.find(getInstances(), new Predicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 28 */         WellKnownInstance instance = (WellKnownInstance)arg0;
/* 29 */         return instance.getName().equals(name);
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   private Collection<T> getInstances() {
/* 36 */     if (this.instances == null) {
/* 37 */       this.instances = createWellKnownInstances();
/*    */     }
/* 39 */     return this.instances;
/*    */   }
/*    */ 
/*    */   public final Collection<T> findAll()
/*    */   {
/* 44 */     return getInstances();
/*    */   }
/*    */ 
/*    */   public abstract Collection<T> createWellKnownInstances();
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.WellKnownInstancesSearcher
 * JD-Core Version:    0.6.0
 */