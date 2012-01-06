/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.listeners.ModelTargetListener;
/*    */ import com.framework.utils.StringProvider;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ public abstract class AbstractAction extends JButton
/*    */   implements FormAction
/*    */ {
/* 16 */   private String text = getClass().getName();
/*    */ 
/* 18 */   private FrameworkActionListener actionStrategy = new DefaultActionListener();
/*    */ 
/*    */   public AbstractAction(Icon icon) {
/* 21 */     super(icon);
/*    */   }
/*    */ 
/*    */   public AbstractAction()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void initComponent() {
/* 29 */     setUpAction();
/* 30 */     super.setText(StringProvider.getInstance().getValueOf(getActionKey()));
/* 31 */     this.actionStrategy.setAction(this);
/* 32 */     addActionListener(this.actionStrategy);
/*    */   }
/*    */ 
/*    */   public void confirm(String messageKey) {
/* 36 */     this.actionStrategy = new ConfirmActionListener(this.actionStrategy, messageKey);
/*    */   }
/*    */ 
/*    */   public void withSimpleExecution() {
/* 40 */     this.actionStrategy = new SimpleActionListener();
/*    */   }
/*    */ 
/*    */   protected String getActionKey() {
/* 44 */     return this.text;
/*    */   }
/*    */ 
/*    */   public void setActionKey(String text) {
/* 48 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public void addModelTargetListener(ModelTargetListener listener)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void terminate()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void refreshComponent()
/*    */   {
/* 66 */     repaint();
/*    */   }
/*    */ 
/*    */   public boolean isColumnComponent()
/*    */   {
/* 73 */     return false;
/*    */   }
/*    */ 
/*    */   protected void postExecution()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void preExecution()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected void rearmOldState()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ActionListener getActionListener()
/*    */   {
/* 97 */     return this.actionListener;
/*    */   }
/*    */ 
/*    */   protected abstract void executeAction(Object paramObject)
/*    */     throws Exception;
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.AbstractAction
 * JD-Core Version:    0.6.0
 */