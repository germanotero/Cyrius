/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormValueSelectionContainer;
/*    */ import com.framework.components.validators.FormValueSelectionContainerValidator;
/*    */ import com.framework.exceptions.NotFullFormException;
/*    */ 
/*    */ public class DefaultFormValidator extends FormValueSelectionContainerValidator
/*    */ {
/*    */   private String componentName;
/*    */ 
/*    */   public DefaultFormValidator(String componentName)
/*    */   {
/* 11 */     this.componentName = componentName;
/*    */   }
/*    */ 
/*    */   public void validate(FormValueSelectionContainer element)
/*    */   {
/* 16 */     if ((element.isEmpty()) && (element.isVisible())) {
/* 17 */       element.setNotFull();
/* 18 */       throw new NotFullFormException(this.componentName);
/*    */     }
/* 20 */     element.setFull();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.DefaultFormValidator
 * JD-Core Version:    0.6.0
 */