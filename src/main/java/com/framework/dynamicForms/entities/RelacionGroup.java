/*    */ package com.framework.dynamicForms.entities;
/*    */ 
/*    */ public class RelacionGroup
/*    */   implements Comparable
/*    */ {
/*    */   private DynamicGroupElement group;
/*  6 */   private Integer order = new Integer(0);
/*    */ 
/*  8 */   private Boolean imprimeReducido = Boolean.FALSE;
/*    */ 
/*    */   public DynamicGroupElement getGroup()
/*    */   {
/* 15 */     return this.group;
/*    */   }
/*    */ 
/*    */   public void setGroup(DynamicGroupElement group) {
/* 19 */     this.group = group;
/*    */   }
/*    */ 
/*    */   public Integer getOrder() {
/* 23 */     return this.order;
/*    */   }
/*    */ 
/*    */   public void setOrder(Integer order) {
/* 27 */     this.order = order;
/*    */   }
/*    */ 
/*    */   public int compareTo(Object o) {
/* 31 */     if ((o instanceof RelacionGroup)) {
/* 32 */       RelacionGroup rel = (RelacionGroup)o;
/* 33 */       return this.order.compareTo(rel.order);
/*    */     }
/* 35 */     return 0;
/*    */   }
/*    */ 
/*    */   public Boolean getImprimeReducido() {
/* 39 */     return this.imprimeReducido;
/*    */   }
/*    */ 
/*    */   public void setImprimeReducido(Boolean imprimeReducido) {
/* 43 */     this.imprimeReducido = imprimeReducido;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.RelacionGroup
 * JD-Core Version:    0.6.0
 */