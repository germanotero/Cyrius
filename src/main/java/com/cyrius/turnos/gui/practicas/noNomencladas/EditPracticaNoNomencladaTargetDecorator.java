/*    */ package com.cyrius.turnos.gui.practicas.noNomencladas;
/*    */ 
/*    */ import com.cyrius.entities.PracticaNoNomenclada;
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class EditPracticaNoNomencladaTargetDecorator extends GridTargetDecorator
/*    */ {
/*    */   public EditPracticaNoNomencladaTargetDecorator(SimpleModelTarget target)
/*    */   {
/* 13 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 18 */     return FormModelUtils.wrap(new PracticaNoNomencladaModel(
/* 19 */       (PracticaNoNomenclada)getSelectedValue().getValue()));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.noNomencladas.EditPracticaNoNomencladaTargetDecorator
 * JD-Core Version:    0.6.0
 */