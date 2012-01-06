/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class FormGridModelTableListener extends AbstractGridModelTargetListener
/*    */ {
/*    */   public void load(FormModel model)
/*    */   {
/* 20 */     getGridModel().setValues(
/* 21 */       (Collection)model.getProperty(getModelProperty())
/* 22 */       .getValue());
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.FormGridModelTableListener
 * JD-Core Version:    0.6.0
 */