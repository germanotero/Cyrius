/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.actions.SimpleAction;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class DeleteSelectedTargetDecorator
/*    */   implements SimpleAction
/*    */ {
/*    */   public void executeAction(FormModel model)
/*    */   {
/* 14 */     Collection seleccionados = (Collection)model.getProperty("selection").getValue();
/* 15 */     for (Iterator iter = seleccionados.iterator(); iter.hasNext(); ) {
/* 16 */       PersistibleObject persistible = (PersistibleObject)iter.next();
/* 17 */       PersistenceService.getInstance().delete(persistible);
/*    */     }
/* 19 */     seleccionados.clear();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.DeleteSelectedTargetDecorator
 * JD-Core Version:    0.6.0
 */