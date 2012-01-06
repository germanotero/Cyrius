/*    */ package com.cyrius.informes.ui.targets;
/*    */ 
/*    */ import com.cyrius.entities.Persona;
/*    */ import com.cyrius.informes.models.VerEstudiosPersonaModel;
/*    */ import com.cyrius.searchers.InformeSearcher;
/*    */ import com.framework.actions.GridTargetDecorator;
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class VerEstudiosTarget extends GridTargetDecorator
/*    */ {
/*    */   public VerEstudiosTarget(SimpleModelTarget target)
/*    */   {
/* 16 */     super(target);
/*    */   }
/*    */ 
/*    */   protected FormModel initModel(FormModel parentModel)
/*    */   {
/* 21 */     Persona paciente = (Persona)getSelectedValue().getValue();
/* 22 */     Collection informes = InformeSearcher.getInstance()
/* 23 */       .findInformesByPerson(paciente);
/* 24 */     return FormModelUtils.wrap(new VerEstudiosPersonaModel(paciente, 
/* 25 */       informes));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.targets.VerEstudiosTarget
 * JD-Core Version:    0.6.0
 */