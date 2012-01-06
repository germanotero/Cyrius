/*    */ package com.framework.components.validators;
/*    */ 
/*    */ import com.framework.components.FormValueSelectionContainer;
/*    */ 
/*    */ public abstract class FormValueSelectionContainerValidator
/*    */ {
/* 15 */   public static final FormValueSelectionContainerValidator DUMMY_INSTANCE = new FormValueSelectionContainerValidator() {
/*    */     public void validate(FormValueSelectionContainer element) {  } } ;
/*    */ 
/*    */   public abstract void validate(FormValueSelectionContainer paramFormValueSelectionContainer);
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.validators.FormValueSelectionContainerValidator
 * JD-Core Version:    0.6.0
 */