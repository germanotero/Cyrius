/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class ConfirmActionListener
/*    */   implements FrameworkActionListener
/*    */ {
/*    */   private FrameworkActionListener listener;
/*    */   private String messageKey;
/*    */ 
/*    */   public ConfirmActionListener(FrameworkActionListener strategy, String messageKey)
/*    */   {
/* 20 */     this.listener = strategy;
/* 21 */     this.messageKey = messageKey;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent e) {
/* 25 */     if (JOptionPane.showConfirmDialog(null, 
/* 26 */       StringProvider.getInstance().getValueOf(this.messageKey), "Confirmacion", 
/* 27 */       0) != 1)
/* 28 */       this.listener.actionPerformed(e);
/*    */   }
/*    */ 
/*    */   public void setAction(AbstractAction action)
/*    */   {
/* 33 */     this.listener.setAction(action);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.ConfirmActionListener
 * JD-Core Version:    0.6.0
 */