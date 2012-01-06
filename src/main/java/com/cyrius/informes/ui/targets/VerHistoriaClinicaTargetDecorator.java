/*    */ package com.cyrius.informes.ui.targets;
/*    */ 
/*    */ import com.cyrius.informes.models.VerEstudiosPersonaModel;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class VerHistoriaClinicaTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public VerHistoriaClinicaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     VerEstudiosPersonaModel model = (VerEstudiosPersonaModel)parentModel
/* 17 */       .getValue();
/* 18 */     return FormModelUtils.wrap(model.getPersona());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.targets.VerHistoriaClinicaTargetDecorator
 * JD-Core Version:    0.6.0
 */