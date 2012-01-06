/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class DefaultGroup extends AbstractGroup
/*    */ {
/*    */   private Class modelClass;
/*    */ 
/*    */   public DefaultGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DefaultGroup(Class modelClass)
/*    */   {
/* 18 */     this.modelClass = modelClass;
/*    */   }
/*    */ 
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 27 */     return this.modelClass;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.DefaultGroup
 * JD-Core Version:    0.6.0
 */