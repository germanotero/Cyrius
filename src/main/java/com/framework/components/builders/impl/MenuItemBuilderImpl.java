/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.actions.AbstractFormAction;
/*    */ import com.framework.components.builders.interfaces.MenuItemBuilder;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JMenuItem;
/*    */ 
/*    */ public class MenuItemBuilderImpl
/*    */   implements MenuItemBuilder
/*    */ {
/*    */   private AbstractFormAction action;
/*    */   private Icon icon;
/*    */ 
/*    */   public void setAction(AbstractFormAction action)
/*    */   {
/* 27 */     this.action = action;
/*    */   }
/*    */ 
/*    */   public JMenuItem build() {
/* 31 */     this.action.initComponent();
/* 32 */     JMenuItem item = new JMenuItem();
/* 33 */     item.addActionListener(this.action.getActionListener());
/* 34 */     item.setText(this.action.getText());
/* 35 */     item.setIcon(this.icon);
/* 36 */     return item;
/*    */   }
/*    */ 
/*    */   public void setIcon(Icon icon) {
/* 40 */     this.icon = icon;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.MenuItemBuilderImpl
 * JD-Core Version:    0.6.0
 */