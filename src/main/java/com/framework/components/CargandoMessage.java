/*    */ package com.framework.components;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.HeadlessException;
/*    */ import javax.swing.JDialog;
/*    */ 
/*    */ public class CargandoMessage extends JDialog
/*    */ {
/*    */   public CargandoMessage()
/*    */     throws HeadlessException
/*    */   {
/* 15 */     setModal(true);
/* 16 */     setLayout(new BorderLayout());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.CargandoMessage
 * JD-Core Version:    0.6.0
 */