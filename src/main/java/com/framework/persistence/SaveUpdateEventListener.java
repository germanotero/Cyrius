/*    */ package com.framework.persistence;
/*    */ 
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.event.SaveOrUpdateEvent;
/*    */ import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;
/*    */ 
/*    */ public class SaveUpdateEventListener extends DefaultSaveOrUpdateEventListener
/*    */ {
/*    */   public void onSaveOrUpdate(SaveOrUpdateEvent arg0)
/*    */     throws HibernateException
/*    */   {
/* 16 */     PersistibleObject entity = (PersistibleObject)arg0.getObject();
/* 17 */     if (entity != null)
/* 18 */       entity.validate();
/* 19 */     super.onSaveOrUpdate(arg0);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.SaveUpdateEventListener
 * JD-Core Version:    0.6.0
 */