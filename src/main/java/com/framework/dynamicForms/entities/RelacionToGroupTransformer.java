/*    */ package com.framework.dynamicForms.entities;
/*    */ 
/*    */ import org.apache.commons.collections.Transformer;
/*    */ 
/*    */ public class RelacionToGroupTransformer
/*    */   implements Transformer
/*    */ {
/*    */   public Object transform(Object arg0)
/*    */   {
/*  7 */     RelacionGroup rel = (RelacionGroup)arg0;
/*  8 */     return rel.getGroup();
/*    */   }
/*    */ 
/*    */   public Transformer backWard() {
/* 12 */     return new Transformer()
/*    */     {
/*    */       public Object transform(Object arg0) {
/* 15 */         DynamicGroupElement group = (DynamicGroupElement)arg0;
/* 16 */         RelacionGroup rel = new RelacionGroup();
/* 17 */         rel.setGroup(group);
/* 18 */         return rel;
/*    */       }
/*    */     };
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.RelacionToGroupTransformer
 * JD-Core Version:    0.6.0
 */