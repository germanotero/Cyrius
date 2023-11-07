/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.CheckBoxBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.dynamicForms.entities.DynamicGroupElement;
/*    */ import com.framework.models.FormModel;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class DynamicGroupPanelFactory extends DynamicPanelsPanelFactory
/*    */ {
/*    */   protected void addElements(FormElementsBuilder builder)
/*    */   {
/* 13 */     builder.addCheckBox("multiplicable").setRefreshableOnChange();
/* 14 */     FormFieldBuilder textoEnVacio = builder.addStringField("emptyText");
/* 15 */     textoEnVacio.required();
/* 16 */     textoEnVacio.setNotVisibleOn(new Predicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 19 */         DynamicGroupElement group = (DynamicGroupElement)((FormModel)arg0)
/* 20 */           .getValue();
/* 21 */         return !group.getMultiplicable().booleanValue();
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.DynamicGroupPanelFactory
 * JD-Core Version:    0.6.0
 */