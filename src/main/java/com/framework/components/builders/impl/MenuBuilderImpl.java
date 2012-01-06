/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.actions.AbstractFormAction;
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.builders.interfaces.MenuBuilder;
/*    */ import com.framework.components.builders.interfaces.MenuItemBuilder;
/*    */ import com.framework.utils.StringProvider;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuItem;
/*    */ 
/*    */ public class MenuBuilderImpl
/*    */   implements MenuBuilder, MenuItemBuilder
/*    */ {
/* 22 */   private Collection menuItems = new ArrayList();
/*    */   private String menuname;
/*    */   private RefreshableComponent container;
/*    */ 
/*    */   public MenuBuilderImpl(RefreshableComponent container)
/*    */   {
/* 30 */     this.container = container;
/*    */   }
/*    */ 
/*    */   public void setMenuName(String menuName)
/*    */   {
/* 37 */     this.menuname = menuName;
/*    */   }
/*    */ 
/*    */   public MenuBuilder addSubMenu(String menuName) {
/* 41 */     MenuBuilderImpl builder = new MenuBuilderImpl(this.container);
/* 42 */     builder.setMenuName(menuName);
/* 43 */     this.menuItems.add(builder);
/* 44 */     return builder;
/*    */   }
/*    */ 
/*    */   public MenuBuilder addMenuItem(AbstractFormAction action)
/*    */   {
/* 51 */     MenuItemBuilderImpl builder = new MenuItemBuilderImpl();
/* 52 */     builder.setAction(action);
/* 53 */     action.setParent(this.container);
/* 54 */     this.menuItems.add(builder);
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */   public MenuBuilder addMenuItem(AbstractFormAction action, Icon icon)
/*    */   {
/* 62 */     MenuItemBuilderImpl builder = new MenuItemBuilderImpl();
/* 63 */     builder.setAction(action);
/* 64 */     builder.setIcon(icon);
/* 65 */     action.setParent(this.container);
/* 66 */     this.menuItems.add(builder);
/* 67 */     return this;
/*    */   }
/*    */ 
/*    */   public JMenuItem build() {
/* 71 */     JMenu menuItem = new JMenu(StringProvider.getInstance().getValueOf(this.menuname));
/* 72 */     for (Iterator iter = this.menuItems.iterator(); iter.hasNext(); ) {
/* 73 */       MenuItemBuilder builder = (MenuItemBuilder)iter.next();
/* 74 */       menuItem.add(builder.build());
/*    */     }
/* 76 */     return menuItem;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.MenuBuilderImpl
 * JD-Core Version:    0.6.0
 */