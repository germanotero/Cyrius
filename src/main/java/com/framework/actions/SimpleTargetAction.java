/*    */ package com.framework.actions;
/*    */ 
/*    */ import com.framework.components.ModelTargetEnableContainer;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ClassUtils;
/*    */ import javax.swing.Icon;
/*    */ 
/*    */ public class SimpleTargetAction extends AbstractFormAction
/*    */ {
/*    */   private Class target;
/*    */ 
/*    */   public Class getTarget()
/*    */   {
/* 13 */     return this.target;
/*    */   }
/*    */ 
/*    */   protected SimpleTargetAction()
/*    */   {
/*    */   }
/*    */ 
/*    */   public SimpleTargetAction(Class target) {
/* 21 */     this(target, null);
/*    */   }
/*    */ 
/*    */   public SimpleTargetAction(Icon icon) {
/* 25 */     this(null, icon);
/*    */   }
/*    */ 
/*    */   public SimpleTargetAction(Class target, Icon icon) {
/* 29 */     super(icon);
/* 30 */     this.target = target;
/*    */   }
/*    */ 
/*    */   protected boolean isImpactableModelAction()
/*    */   {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   protected void executeFormAction(FormModel model) throws Exception
/*    */   {
/* 40 */     ModelTargetDecorator target = (ModelTargetDecorator)ClassUtils.newInstance(this.target, 
/* 41 */       new Class[] { SimpleModelTarget.class }, new Object[] { getPadre().getOpenTarget() });
/* 42 */     target.returning(model);
/*    */   }
/*    */ 
/*    */   protected void setUpAction()
/*    */   {
/* 47 */     if (this.target != null)
/* 48 */       setActionKey(getClass().getName() + "." + this.target.getName());
/*    */     else
/* 50 */       setActionKey(getClass().getName());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.SimpleTargetAction
 * JD-Core Version:    0.6.0
 */