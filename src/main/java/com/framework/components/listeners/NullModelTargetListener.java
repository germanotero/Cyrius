/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class NullModelTargetListener
/*    */   implements ModelTargetListener
/*    */ {
/*  9 */   private static NullModelTargetListener instance = new NullModelTargetListener();
/*    */ 
/*    */   public static NullModelTargetListener getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.NullModelTargetListener
 * JD-Core Version:    0.6.0
 */