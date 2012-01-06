/*    */ package com.cyrius.informes;
/*    */ 
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class StartInformeTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public StartInformeTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 17 */     return FormModelUtils.wrap(new StartInformesModel((Turno)
/* 18 */       getSelectedValue().getValue()));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.StartInformeTargetDecorator
 * JD-Core Version:    0.6.0
 */