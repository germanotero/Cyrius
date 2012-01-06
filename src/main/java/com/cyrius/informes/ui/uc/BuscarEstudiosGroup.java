/*    */ package com.cyrius.informes.ui.uc;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.actions.RefreshParentAction;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class BuscarEstudiosGroup extends AbstractGroup
/*    */ {
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 13 */     return BuscarEstudiosModel.class;
/*    */   }
/*    */ 
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 18 */     builder.addStringField("nombre");
/* 19 */     builder.addStringField("apellido");
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder)
/*    */   {
/* 24 */     builder.addAction(new RefreshParentAction("buscar"));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.uc.BuscarEstudiosGroup
 * JD-Core Version:    0.6.0
 */