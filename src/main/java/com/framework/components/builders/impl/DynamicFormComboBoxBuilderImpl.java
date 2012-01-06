/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.DefaultComboBox;
/*    */ import com.framework.components.FormComponent;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DynamicFormComboBoxBuilderImpl extends FormComboBoxBuilderImpl
/*    */ {
/*    */   private Collection elements;
/*    */ 
/*    */   public void withElements(Collection options)
/*    */   {
/* 12 */     this.elements = options;
/*    */   }
/*    */ 
/*    */   public FormComponent build()
/*    */   {
/* 17 */     DefaultComboBox formComponent = (DefaultComboBox)super.build();
/* 18 */     formComponent.setValues(this.elements);
/* 19 */     formComponent.initComponent();
/* 20 */     return formComponent;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.DynamicFormComboBoxBuilderImpl
 * JD-Core Version:    0.6.0
 */