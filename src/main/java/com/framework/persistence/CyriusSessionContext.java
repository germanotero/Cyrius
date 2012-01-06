/*    */ package com.framework.persistence;
/*    */ 
/*    */ import org.hibernate.context.ThreadLocalSessionContext;
/*    */ import org.hibernate.engine.SessionFactoryImplementor;
/*    */ 
/*    */ public class CyriusSessionContext extends ThreadLocalSessionContext
/*    */ {
/*    */   public CyriusSessionContext(SessionFactoryImplementor factory)
/*    */   {
/*  9 */     super(factory);
/*    */   }
/*    */ 
/*    */   protected boolean isAutoCloseEnabled()
/*    */   {
/* 14 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.CyriusSessionContext
 * JD-Core Version:    0.6.0
 */