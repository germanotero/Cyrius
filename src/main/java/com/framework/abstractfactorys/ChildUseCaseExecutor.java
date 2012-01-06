/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.actions.SimpleModelTarget;
/*    */ import com.framework.components.wrappers.UseCaseImplementation;
/*    */ import com.framework.exceptions.ShowableExceptionImpl;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class ChildUseCaseExecutor
/*    */ {
/*    */   private SimpleModelTarget modelTargetDecorator;
/*    */   private Class useCaseToBeOpennedClass;
/*    */   private FormModel model;
/*    */   private AbstractUseCaseFactory useCaseToBeOpennedInstance;
/*    */ 
/*    */   public static ChildUseCaseExecutor newInstance()
/*    */   {
/* 28 */     return new ChildUseCaseExecutor();
/*    */   }
/*    */ 
/*    */   public void execute(UseCaseImplementation container)
/*    */   {
/*    */     try
/*    */     {
/* 38 */       AbstractUseCaseFactory useCaseToBeOpenned = 
/* 39 */         getChildUseCaseInstance(container);
/* 40 */       useCaseToBeOpenned.setModelo(
/* 41 */         this.modelTargetDecorator.getModel(this.model));
/* 42 */       useCaseToBeOpenned.setReturnTarget(this.modelTargetDecorator);
/* 43 */       useCaseToBeOpenned.startUseCase();
/*    */     } catch (ShowableExceptionImpl ex) {
/* 45 */       throw ex;
/*    */     } catch (Exception e) {
/* 47 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   private AbstractUseCaseFactory getChildUseCaseInstance(UseCaseImplementation container)
/*    */   {
/* 53 */     if (this.useCaseToBeOpennedClass != null)
/* 54 */       return FrameworkUseCaseFactory.createChildUseCase(
/* 55 */         this.useCaseToBeOpennedClass, container);
/* 56 */     return FrameworkUseCaseFactory.createChildUseCase(
/* 57 */       this.useCaseToBeOpennedInstance, container);
/*    */   }
/*    */ 
/*    */   public ChildUseCaseExecutor setModelo(FormModel model) {
/* 61 */     this.model = model;
/* 62 */     return this;
/*    */   }
/*    */ 
/*    */   public ChildUseCaseExecutor setModelTargetDecorator(SimpleModelTarget modelTargetDecorator)
/*    */   {
/* 67 */     this.modelTargetDecorator = modelTargetDecorator;
/* 68 */     return this;
/*    */   }
/*    */ 
/*    */   public ChildUseCaseExecutor setUseCaseToBeOpenned(Class useCaseToBeOpenned) {
/* 72 */     this.useCaseToBeOpennedClass = useCaseToBeOpenned;
/* 73 */     return this;
/*    */   }
/*    */ 
/*    */   public void setUseCaseToBeOpennedInstance(AbstractUseCaseFactory useCaseToBeOpennedInstance)
/*    */   {
/* 78 */     this.useCaseToBeOpennedInstance = useCaseToBeOpennedInstance;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.ChildUseCaseExecutor
 * JD-Core Version:    0.6.0
 */