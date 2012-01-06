/*    */ package com.cyrius.turnos.gui.abms;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NuevoMedicoTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public NuevoMedicoTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     return FormModelUtils.wrap(new Medico());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.abms.NuevoMedicoTargetDecorator
 * JD-Core Version:    0.6.0
 */