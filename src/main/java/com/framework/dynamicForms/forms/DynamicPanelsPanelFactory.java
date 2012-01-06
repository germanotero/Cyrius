/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.DeleteRowAction;
/*    */ import com.framework.actions.OpenUseCaseAction;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.TableColumnBuilder;
/*    */ import com.framework.dynamicForms.integration.OpenDynamicFormAction;
/*    */ import com.framework.dynamicForms.targets.AddDynamicFormElementToDynamicFormTarget;
/*    */ import com.framework.dynamicForms.targets.AddDynamicFormGroupToDynamicFormTarget;
/*    */ import com.framework.dynamicForms.uc.AddElementsUseCaseFactory;
/*    */ import com.framework.dynamicForms.uc.AddGroupsUseCaseFactory;
/*    */ 
/*    */ public class DynamicPanelsPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 25 */     builder.setColumnsCount(4);
/* 26 */     builder.addStringField("name").required();
/* 27 */     builder.addStringField("description").required();
/* 28 */     builder.addNumberField("cantidadColumnas").required();
/*    */ 
/* 30 */     addElements(builder);
/* 31 */     FormGridBuilder simpleElementsGridBuilder = builder
/* 32 */       .addGrid("simpleElements");
/* 33 */     simpleElementsGridBuilder.addColumn("name");
/* 34 */     simpleElementsGridBuilder.addColumn("description");
/* 35 */     simpleElementsGridBuilder.addColumn("tipoDynamicFormElement");
/* 36 */     simpleElementsGridBuilder.addRowAction(
/* 37 */       new DeleteRowAction("simpleElements"));
/*    */ 
/* 39 */     FormGridBuilder groupElementsGridBuilder = builder
/* 40 */       .addGrid("groupElements");
/* 41 */     groupElementsGridBuilder.addColumn("group.name");
/* 42 */     groupElementsGridBuilder.addColumn("group.description");
/* 43 */     groupElementsGridBuilder.addColumn("group.tipoDynamicFormElement");
/* 44 */     groupElementsGridBuilder.addColumn("order", 
/* 45 */       new StringToIntegerTransformer()).setEditable(true);
/* 46 */     groupElementsGridBuilder.addColumn("imprimeReducido", Boolean.class)
/* 47 */       .setEditable(true);
/* 48 */     groupElementsGridBuilder.addRowAction(
/* 49 */       new DeleteRowAction("groupElements"));
/*    */   }
/*    */ 
/*    */   public final void registerActions(FormActionBuilder builder)
/*    */   {
/* 56 */     builder.addAction(
/* 58 */       new OpenUseCaseAction(AddElementsUseCaseFactory.class, 
/* 58 */       AddDynamicFormElementToDynamicFormTarget.class));
/* 59 */     builder.addAction(
/* 60 */       new OpenUseCaseAction(AddGroupsUseCaseFactory.class, 
/* 60 */       AddDynamicFormGroupToDynamicFormTarget.class));
/* 61 */     builder.addAction(new OpenDynamicFormAction());
/* 62 */     builder.addFinalizeUseCaseAction();
/* 63 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ 
/*    */   protected void addElements(FormElementsBuilder builder)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicPanelsPanelFactory
 * JD-Core Version:    0.6.0
 */