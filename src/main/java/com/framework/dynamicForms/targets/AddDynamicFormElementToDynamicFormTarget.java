/*    */ package com.framework.dynamicForms.targets;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.dynamicForms.AddElementsModel;
/*    */ import com.framework.dynamicForms.entities.DynamicForm;
/*    */ import com.framework.dynamicForms.entities.RelacionToGroupTransformer;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.exceptions.ExceptionFactory;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class AddDynamicFormElementToDynamicFormTarget extends SimpleModelTarget
/*    */ {
/*    */   public AddDynamicFormElementToDynamicFormTarget(SimpleModelTarget target)
/*    */   {
/* 20 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 27 */     return FormModelUtils.wrap(new AddElementsModel());
/*    */   }
/*    */ 
/*    */   protected final void returnAction(FormModel childModel)
/*    */   {
/* 34 */     DynamicForm form = (DynamicForm)getParentModel().getValue();
/* 35 */     Collection seleccionados = ((AddElementsModel)childModel.getValue())
/* 36 */       .getSelection();
/* 37 */     ExceptionFactory.validateFalse("Must.Select.One.Element", 
/* 38 */       seleccionados.isEmpty());
/* 39 */     ExceptionFactory.validateTrue("FormElementAllReadySelected", 
/* 40 */       CollectionUtils.containsAny(form.getSimpleElements(), 
/* 41 */       seleccionados));
/* 42 */     Collection transformedCollection = 
/* 43 */       CollectionUtils.transformedCollection(form.getGroupElements(), 
/* 44 */       new RelacionToGroupTransformer());
/* 45 */     ExceptionFactory.validateTrue("FormElementAllReadySelected", 
/* 46 */       CollectionUtils.containsAny(transformedCollection, 
/* 47 */       seleccionados));
/* 48 */     handleSelectedElements(form, seleccionados);
/*    */   }
/*    */ 
/*    */   protected void handleSelectedElements(DynamicForm form, Collection seleccionados)
/*    */   {
/* 53 */     form.addElements(seleccionados);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.targets.AddDynamicFormElementToDynamicFormTarget
 * JD-Core Version:    0.6.0
 */