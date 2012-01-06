/*    */ package com.cyrius.turnos.gui.abms;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class EditMedicoTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public EditMedicoTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 12 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 17 */     return FormModelUtils.wrap((Medico)getSelectedValue().getValue());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.abms.EditMedicoTargetDecorator
 * JD-Core Version:    0.6.0
 */