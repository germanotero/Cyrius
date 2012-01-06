/*    */ package com.framework.dynamicForms;
/*    */ 
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class AddElementsModel
/*    */ {
/* 13 */   private Collection selection = CollectionFactory.createCollection();
/*    */ 
/*    */   public Collection getSelection() {
/* 16 */     return this.selection;
/*    */   }
/*    */ 
/*    */   public void setSelection(Collection selecteds) {
/* 20 */     this.selection = selecteds;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.AddElementsModel
 * JD-Core Version:    0.6.0
 */