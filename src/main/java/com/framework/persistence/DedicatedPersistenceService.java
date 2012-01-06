/*    */ package com.framework.persistence;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DedicatedPersistenceService
/*    */ {
/*    */   private Class clazz;
/*    */ 
/*    */   public DedicatedPersistenceService(Class clazz)
/*    */   {
/* 11 */     this.clazz = clazz;
/*    */   }
/*    */ 
/*    */   public Collection findAll() {
/* 15 */     return PersistenceService.getInstance().loadAll(this.clazz);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.DedicatedPersistenceService
 * JD-Core Version:    0.6.0
 */