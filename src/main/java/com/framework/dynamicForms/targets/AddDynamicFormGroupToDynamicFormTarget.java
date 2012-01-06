/*    */ package com.framework.dynamicForms.targets;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class AddDynamicFormGroupToDynamicFormTarget extends AddDynamicFormElementToDynamicFormTarget
/*    */ {
/*    */   public AddDynamicFormGroupToDynamicFormTarget(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected void handleSelectedElements(DynamicForm form, Collection seleccionados)
/*    */   {
/* 18 */     form.addGroupElements(seleccionados);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.targets.AddDynamicFormGroupToDynamicFormTarget
 * JD-Core Version:    0.6.0
 */