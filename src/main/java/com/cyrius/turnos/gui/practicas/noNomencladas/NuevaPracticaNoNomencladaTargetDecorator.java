/*    */ package com.cyrius.turnos.gui.practicas.noNomencladas;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NuevaPracticaNoNomencladaTargetDecorator extends SimpleModelTarget
/*    */ {
/*    */   public NuevaPracticaNoNomencladaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 11 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 16 */     return FormModelUtils.wrap(new PracticaNoNomencladaModel());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.noNomencladas.NuevaPracticaNoNomencladaTargetDecorator
 * JD-Core Version:    0.6.0
 */