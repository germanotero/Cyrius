/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import javax.swing.JDialog;
import javax.swing.JFrame;

import com.framework.components.wrappers.JDialogWrapper;
import com.framework.components.wrappers.JFrameWrapper;
import com.framework.components.wrappers.UseCaseImplementation;
import com.framework.exceptions.ExceptionHandler;
import com.framework.models.FormModel;
import com.framework.utils.ClassUtils;
/*    */ 
/*    */ public abstract class FrameworkUseCaseFactory
/*    */ {
/*    */   public static <T> AbstractUseCaseFactory createUseCase(Class<T> useCaseToCreate)
/*    */   {
/* 19 */     JFrameWrapper frame = new JFrameWrapper(new JFrame());
/* 20 */     AbstractUseCaseFactory factory = (AbstractUseCaseFactory)ClassUtils.newInstance(useCaseToCreate);
/* 21 */     factory.setInternalWindow(frame);
/* 22 */     return factory;
/*    */   }
/*    */ 
/*    */   public static <T> AbstractUseCaseFactory createUseCase(AbstractUseCaseFactory factory) {
/* 26 */     JFrameWrapper frame = new JFrameWrapper(new JFrame());
/* 27 */     factory.setInternalWindow(frame);
/* 28 */     return factory;
/*    */   }
/*    */ 
/*    */   public static <T> AbstractUseCaseFactory createChildUseCase(Class<T> useCaseToCreate) {
/* 32 */     JDialogWrapper dialog = new JDialogWrapper();
/* 33 */     AbstractUseCaseFactory factory = (AbstractUseCaseFactory)ClassUtils.newInstance(useCaseToCreate);
/* 34 */     factory.setInternalWindow(dialog);
/* 35 */     return factory;
/*    */   }
/*    */ 
/*    */   public static AbstractUseCaseFactory createChildUseCase(Class useCaseToCreate, UseCaseImplementation parent)
/*    */   {
/*    */     JDialogWrapper dialog;
/* 41 */     if ((parent.getWraped() instanceof JFrame))
/* 42 */       dialog = new JDialogWrapper((JFrame)parent.getWraped());
/*    */     else {
/* 44 */       dialog = new JDialogWrapper((JDialog)parent.getWraped());
/*    */     }
/* 46 */     AbstractUseCaseFactory factory = (AbstractUseCaseFactory)ClassUtils.newInstance(useCaseToCreate);
/* 47 */     factory.setInternalWindow(dialog);
/* 48 */     return factory;
/*    */   }
/*    */ 
/*    */   public static AbstractUseCaseFactory createChildUseCase(AbstractUseCaseFactory factory, UseCaseImplementation parent)
/*    */   {
/* 53 */     return createChildUseCase(factory, parent, null);
/*    */   }
/*    */ 
/*    */   public static AbstractUseCaseFactory createChildUseCase(AbstractUseCaseFactory factory, UseCaseImplementation parent, FormModel model)
/*    */   {
/*    */     JDialogWrapper dialog;
/* 60 */     if ((parent instanceof JFrameWrapper))
/* 61 */       dialog = new JDialogWrapper((JFrame)parent.getWraped());
/*    */     else
/* 63 */       dialog = new JDialogWrapper((JDialog)parent.getWraped());
/* 64 */     dialog.setModelo(model);
/* 65 */     factory.setInternalWindow(dialog);
/* 66 */     return factory;
/*    */   }
/*    */ 
/*    */   public static <T> AbstractUseCaseFactory createChildUseCase(Class<T> useCaseToCreate, JFrame parent)
/*    */   {
/* 71 */     JDialogWrapper dialog = new JDialogWrapper(parent);
/* 72 */     AbstractUseCaseFactory factory = (AbstractUseCaseFactory)ClassUtils.newInstance(useCaseToCreate);
/* 73 */     factory.setInternalWindow(dialog);
/* 74 */     return factory;
/*    */   }
/*    */ 
/*    */   public static void launchUseCase(AbstractUseCaseFactory useCase)
/*    */   {
/*    */     try {
/* 80 */       useCase.startUseCase();
/*    */     } catch (Exception e) {
/* 82 */       ExceptionHandler.getInstance().handle(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FrameworkUseCaseFactory
 * JD-Core Version:    0.6.0
 */