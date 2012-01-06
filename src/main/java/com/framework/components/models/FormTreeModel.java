/*    */ package com.framework.components.models;
/*    */ 
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ import javax.swing.tree.DefaultTreeModel;
/*    */ import javax.swing.tree.TreeNode;
/*    */ 
/*    */ public class FormTreeModel extends DefaultTreeModel
/*    */ {
/*    */   public DefaultMutableTreeNode root;
/*    */ 
/*    */   public FormTreeModel(TreeNode root)
/*    */   {
/* 18 */     super(root);
/*    */   }
/*    */ 
/*    */   public FormTreeModel(TreeNode root, boolean asksAllowsChildren)
/*    */   {
/* 26 */     super(root, asksAllowsChildren);
/*    */   }
/*    */ 
/*    */   public void setValues() {
/* 30 */     DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)getRoot();
/*    */   }
/*    */ 
/*    */   public Object getValues()
/*    */   {
/* 38 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.models.FormTreeModel
 * JD-Core Version:    0.6.0
 */