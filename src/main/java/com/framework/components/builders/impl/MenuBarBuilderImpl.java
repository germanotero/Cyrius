/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.RefreshableComponent;
/*    */ import com.framework.components.builders.interfaces.MenuBarBuilder;
/*    */ import com.framework.components.builders.interfaces.MenuBuilder;
/*    */ import com.framework.utils.Constants;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import javax.swing.JMenuBar;
/*    */ 
/*    */ public class MenuBarBuilderImpl
/*    */   implements MenuBarBuilder
/*    */ {
/* 18 */   private Collection menus = new ArrayList();
/*    */   private RefreshableComponent container;
/*    */ 
/*    */   public MenuBarBuilderImpl(RefreshableComponent container)
/*    */   {
/* 24 */     this.container = container;
/*    */   }
/*    */ 
/*    */   public MenuBuilder addMenu(String menuName) {
/* 28 */     MenuBuilderImpl builder = new MenuBuilderImpl(this.container);
/* 29 */     builder.setMenuName(menuName);
/* 30 */     this.menus.add(builder);
/* 31 */     return builder;
/*    */   }
/*    */ 
/*    */   public JMenuBar build() {
/* 35 */     JMenuBar menuBar = new JMenuBar();
/* 36 */     menuBar.setBackground(Constants.BACK_MENU_BAR);
/* 37 */     for (Iterator iter = this.menus.iterator(); iter.hasNext(); ) {
/* 38 */       MenuBuilderImpl builder = (MenuBuilderImpl)iter.next();
/* 39 */       menuBar.add(builder.build());
/*    */     }
/* 41 */     return menuBar;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.MenuBarBuilderImpl
 * JD-Core Version:    0.6.0
 */