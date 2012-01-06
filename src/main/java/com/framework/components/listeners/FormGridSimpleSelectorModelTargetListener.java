/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ 
/*    */ public class FormGridSimpleSelectorModelTargetListener extends AbstractGridModelTargetListener
/*    */ {
/*    */   public void load(FormModel model)
/*    */   {
/* 19 */     FormModel value = model.getProperty(getModelProperty());
/* 20 */     if (value != null) {
/* 21 */       Collection selectedValue = (Collection)Collections.singletonList(value
/* 22 */         .getValue());
/* 23 */       getGridModel().setSelectedValues(selectedValue);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/* 32 */     Object selectedValue = getGridModel().getSelectedValue();
/* 33 */     if (selectedValue != null)
/* 34 */       formModel.setProperty(getModelProperty(), selectedValue);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.FormGridSimpleSelectorModelTargetListener
 * JD-Core Version:    0.6.0
 */