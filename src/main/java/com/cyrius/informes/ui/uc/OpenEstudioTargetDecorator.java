/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.cyrius.informes.Informe;
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.DynamicFormModel;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class OpenEstudioTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public OpenEstudioTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 17 */     Informe informe = (Informe)getSelectedValue().getValue();
/* 18 */     return new DynamicFormModel(informe);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.OpenEstudioTargetDecorator
 * JD-Core Version:    0.6.0
 */