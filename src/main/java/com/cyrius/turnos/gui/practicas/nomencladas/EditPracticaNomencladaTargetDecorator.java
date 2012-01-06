/*    */ package com.cyrius.turnos.gui.practicas.nomencladas;
/*    */ 
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class EditPracticaNomencladaTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public EditPracticaNomencladaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 17 */     return FormModelUtils.wrap(getSelectedValue().getValue());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.nomencladas.EditPracticaNomencladaTargetDecorator
 * JD-Core Version:    0.6.0
 */