/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.components.models.PrintTabsModel;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class PanelsTabsTarget extends SimpleModelTarget
/*    */ {
/*    */   public PanelsTabsTarget(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     return FormModelUtils.wrap(new PrintTabsModel());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.PanelsTabsTarget
 * JD-Core Version:    0.6.0
 */