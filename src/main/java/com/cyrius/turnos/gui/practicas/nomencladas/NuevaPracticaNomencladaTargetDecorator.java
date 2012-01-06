/*    */ package com.cyrius.turnos.gui.practicas.nomencladas;
/*    */ 
/*    */ import com.cyrius.entities.PracticaNomenclada;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NuevaPracticaNomencladaTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public NuevaPracticaNomencladaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     return FormModelUtils.wrap(new PracticaNomenclada());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.nomencladas.NuevaPracticaNomencladaTargetDecorator
 * JD-Core Version:    0.6.0
 */