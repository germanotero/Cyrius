/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormComponent;
/*    */ 
/*    */ public class DefaultRowFormComponentBuilder extends DefaultFormComponentBuilder
/*    */ {
/*    */   public DefaultRowFormComponentBuilder(FormComponent component)
/*    */   {
/*  9 */     super(component);
/*    */   }
/*    */ 
/*    */   public void addTo(FormBuilder formBuilder, int maxColumns, ConstraintsProvider constraintsProvider)
/*    */   {
/* 14 */     formBuilder.addComponent(build(), "+ " + maxColumns + " 1");
/* 15 */     constraintsProvider.rowElement();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.DefaultRowFormComponentBuilder
 * JD-Core Version:    0.6.0
 */