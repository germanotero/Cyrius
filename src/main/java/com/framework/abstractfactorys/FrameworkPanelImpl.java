/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ public class FrameworkPanelImpl extends JScrollPane
/*    */   implements FrameworkPanel
/*    */ {
/* 10 */   private JPanel panel = new JPanel();
/*    */ 
/*    */   public FrameworkPanelImpl()
/*    */   {
/* 14 */     this.panel.setLayout(new BorderLayout());
/* 15 */     setViewportView(this.panel);
/*    */   }
/*    */ 
/*    */   public void setDisableEnable(boolean b)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void initComponent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void addTab(String title, Container component) {
/* 27 */     this.panel.add(component, "Center");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FrameworkPanelImpl
 * JD-Core Version:    0.6.0
 */