/*    */ package com.framework.components.nullComponents;
/*    */ 
/*    */ import com.framework.entities.NullObjectEnable;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class NullLabel extends JLabel
/*    */   implements NullObjectEnable
/*    */ {
/*    */   public void setText(String text)
/*    */   {
/* 15 */     throw new RuntimeException(
/* 16 */       "ERROR no se le puede setear un valor a una instancia de un label NULL");
/*    */   }
/*    */ 
/*    */   public boolean isNull()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.nullComponents.NullLabel
 * JD-Core Version:    0.6.0
 */