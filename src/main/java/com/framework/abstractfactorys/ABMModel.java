/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class ABMModel
/*    */ {
/*  8 */   public Collection selection = CollectionFactory.createCollection();
/*    */ 
/*    */   public Collection getSelection() {
/* 11 */     return this.selection;
/*    */   }
/*    */ 
/*    */   public void setSelection(Collection selecteds) {
/* 15 */     this.selection = selecteds;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.ABMModel
 * JD-Core Version:    0.6.0
 */