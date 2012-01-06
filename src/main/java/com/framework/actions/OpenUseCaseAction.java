/*     */ package com.framework.actions;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractUseCaseFactory;
/*     */ import com.framework.abstractfactorys.ChildUseCaseExecutor;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.components.wrappers.UseCaseImplementation;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.ClassUtils;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ public class OpenUseCaseAction extends AbstractFormAction
/*     */ {
/*     */   private Class useCaseToBeOpenned;
/*     */   private AbstractUseCaseFactory useCaseToBeOpennedInstance;
/*     */   private Class target;
/*     */ 
/*     */   protected void setUpAction()
/*     */   {
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(Class childUseCase)
/*     */   {
/*  42 */     this.useCaseToBeOpenned = childUseCase;
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(Class childUseCase, ImageIcon icon)
/*     */   {
/*  53 */     super(icon);
/*  54 */     this.useCaseToBeOpenned = childUseCase;
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(AbstractUseCaseFactory childUseCase)
/*     */   {
/*  66 */     this(childUseCase, null, null);
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, ImageIcon icon)
/*     */   {
/*  77 */     this(childUseCase, null, icon);
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, Class target)
/*     */   {
/*  88 */     this(childUseCase);
/*  89 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(AbstractUseCaseFactory childUseCase, Class target, ImageIcon icon)
/*     */   {
/* 100 */     super(icon);
/* 101 */     this.useCaseToBeOpennedInstance = childUseCase;
/* 102 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public OpenUseCaseAction(Class childUseCase, Class target)
/*     */   {
/* 113 */     this(childUseCase);
/* 114 */     this.target = target;
/*     */   }
/*     */ 
/*     */   protected void executeFormAction(FormModel model)
/*     */     throws Exception
/*     */   {
/* 121 */     ChildUseCaseExecutor executor = ChildUseCaseExecutor.newInstance();
/* 122 */     executor.setModelTargetDecorator(getTarget()).setModelo(getPadre().getModelo());
/* 123 */     if (this.useCaseToBeOpenned != null)
/* 124 */       executor.setUseCaseToBeOpenned(this.useCaseToBeOpenned);
/*     */     else
/* 126 */       executor.setUseCaseToBeOpennedInstance(this.useCaseToBeOpennedInstance);
/* 127 */     executor.execute((UseCaseImplementation)getPadre());
/*     */   }
/*     */ 
/*     */   private SimpleModelTarget getTarget() {
/* 131 */     if (this.target == null)
/* 132 */       return new SimpleTargetDecorator(getPadre().getOpenTarget());
/* 133 */     return (SimpleModelTarget)ClassUtils.newInstance(this.target, new Class[] { SimpleModelTarget.class }, 
/* 134 */       new Object[] { getPadre().getOpenTarget() });
/*     */   }
/*     */ 
/*     */   protected String getActionKey()
/*     */   {
/* 139 */     if (this.useCaseToBeOpenned != null)
/* 140 */       return getTargetName() + this.useCaseToBeOpenned.getName();
/* 141 */     return getTargetName() + this.useCaseToBeOpennedInstance.getClass().getName();
/*     */   }
/*     */ 
/*     */   private String getTargetName() {
/* 145 */     return this.target != null ? this.target.getName() + "." : "";
/*     */   }
/*     */ 
/*     */   protected boolean isImpactableModelAction()
/*     */   {
/* 153 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.OpenUseCaseAction
 * JD-Core Version:    0.6.0
 */