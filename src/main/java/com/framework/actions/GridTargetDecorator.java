/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class GridTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   private Collection rowCollection;
/*    */   private FormModel containerValue;
/*    */   private FormModel selectedValue;
/*    */   private String propertyValue;
/*    */ 
/*    */   public GridTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 17 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel getContainerValue() {
/* 21 */     if (this.containerValue == null)
/* 22 */       return getTarget().containerValue;
/* 23 */     return this.containerValue;
/*    */   }
/*    */ 
/*    */   public String getPropertyValue() {
/* 27 */     return this.propertyValue;
/*    */   }
/*    */ 
/*    */   public void setPropertyValue(String propertyValue) {
/* 31 */     this.propertyValue = propertyValue;
/*    */   }
/*    */ 
/*    */   public void setContainerValue(FormModel containerValue) {
/* 35 */     this.containerValue = containerValue;
/*    */   }
/*    */ 
/*    */   public FormModel getSelectedValue() {
/* 39 */     if (this.selectedValue == null)
/* 40 */       return getTarget().selectedValue;
/* 41 */     return this.selectedValue;
/*    */   }
/*    */ 
/*    */   public void setSelectedValue(FormModel selectedValue) {
/* 45 */     this.selectedValue = selectedValue;
/*    */   }
/*    */ 
/*    */   public Collection getRowCollection() {
/* 49 */     if (this.rowCollection == null)
/* 50 */       return getTarget().rowCollection;
/* 51 */     return this.rowCollection;
/*    */   }
/*    */ 
/*    */   public void setRowCollection(Collection rowCollection) {
/* 55 */     this.rowCollection = rowCollection;
/*    */   }
/*    */ 
/*    */   protected GridTargetDecorator getTarget() {
/* 59 */     return (GridTargetDecorator)super.getTarget();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.GridTargetDecorator
 * JD-Core Version:    0.6.0
 */