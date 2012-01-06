/*    */ package com.cyrius.informes.ui;
/*    */ 
/*    */ import com.cyrius.entities.Turno;
/*    */ import com.cyrius.informes.StartInformesModel;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class HistoriaClinicaTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public HistoriaClinicaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     StartInformesModel model = (StartInformesModel)parentModel.getValue();
/* 17 */     return FormModelUtils.wrap(model.getTurno().getPaciente());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.HistoriaClinicaTargetDecorator
 * JD-Core Version:    0.6.0
 */