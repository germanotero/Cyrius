/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.actions.EditRowTargetDecorator;
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.OpenUseCaseAction;
/*     */ import com.framework.actions.RefreshAction;
/*     */ import com.framework.components.builders.impl.FormGridBuilder;
/*     */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*     */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*     */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*     */ import java.awt.Dimension;
import javax.swing.ImageIcon;
/*     */ 
/*     */ public abstract class ABMUseCaseFactory extends AbstractUseCaseFactory
/*     */ {
/*     */   private FormGridBuilder gridBuilder;
/*     */   private FormActionBuilder actionBuilder;
/*     */ 
/*     */   protected void initGui()
/*     */   {
/*  23 */     super.setName("crud/" + getAbmObject().getName());
/*  24 */     super.initGui();
/*     */   }
/*     */ 
/*     */   public void registerFactorys(UseCaseBuilder builder)
/*     */   {
/*  29 */     builder.addPanel(new ABMMainPanel());
/*     */   }
/*     */ 
/*     */   public Class getNewActionTargetDecorator()
/*     */   {
/*  34 */     return null;
/*     */   }
/*     */ 
/*     */   public Class getEditRowTargetDecorator() {
/*  38 */     return EditRowTargetDecorator.class;
/*     */   }
/*     */ 
/*     */   protected Class getGridClass()
/*     */   {
/*  45 */     return getAbmObject();
/*     */   }
/*     */ 
/*     */   protected abstract Class getAbmObject();
/*     */ 
/*     */   public final Class getAsociatedModel() {
/*  52 */     return ABMModel.class;
/*     */   }
/*     */ 
/*     */   protected abstract void addEditElements(FormElementsBuilder paramFormElementsBuilder);
/*     */ 
/*     */   protected abstract void addGridColumns(FormGridBuilder paramFormGridBuilder);
/*     */ 
/*     */   protected Dimension setUseCaseDimension()
/*     */   {
/* 128 */     return new Dimension(750, 600);
/*     */   }
/*     */ 
/*     */   protected Dimension setEditUseCaseDimension()
/*     */   {
/* 135 */     return setUseCaseDimension();
/*     */   }
/*     */ 
/*     */   private final class ABMMainPanel extends AbstractPanel
/*     */   {
/*  71 */     private AbstractUseCaseFactory newEditUseCase = new AbstractUseCaseFactory()
/*     */     {
/*     */       public void registerFactorys(UseCaseBuilder builder)
/*     */       {
/*  75 */         builder.addPanel(new ABMUseCaseFactory.ABMMainPanel.InnerClass1());
/*     */       }
/*     */ 
/*     */       public Class getAsociatedModel()
/*     */       {
/*  91 */         return ABMUseCaseFactory.this.getAbmObject();
/*     */       }
/*     */ 
/*     */       protected Dimension setUseCaseDimension()
/*     */       {
/*  96 */         return ABMUseCaseFactory.this.setEditUseCaseDimension();
/*     */       }
/*  71 */     };
/*     */ 
/*     */     public ABMMainPanel()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void registerElements(FormElementsBuilder builder)
/*     */     {
/* 103 */       ABMUseCaseFactory.this.gridBuilder = builder.addGrid(ABMUseCaseFactory.this.getGridClass());
/* 104 */       ABMUseCaseFactory.this.gridBuilder.addRowSelector("selection");
/* 105 */       ABMUseCaseFactory.this.addGridColumns(ABMUseCaseFactory.this.gridBuilder);
/* 106 */       ABMUseCaseFactory.this.gridBuilder.addRowAction(
/* 107 */         new OpenUseCaseAction(this.newEditUseCase, 
/* 107 */         ABMUseCaseFactory.this.getEditRowTargetDecorator(), new ImageIcon("Img/new.gif")));
/*     */     }
/*     */ 
/*     */     public void registerActions(FormActionBuilder builder) {
/* 111 */       ABMUseCaseFactory.this.actionBuilder = builder;
/* 112 */       builder.addAction(
/* 113 */         new RefreshAction("delete", new DeleteSelectedTargetDecorator(), new ImageIcon("Img/delete.gif")))
/* 114 */         .confirm("confirmar.abm.eliminar.seleccionados");
/* 115 */       ImageIcon icon = new ImageIcon("Img/new.gif");
/* 116 */       if (ABMUseCaseFactory.this.getNewActionTargetDecorator() == null)
/* 117 */         ABMUseCaseFactory.this.actionBuilder.addAction(new OpenUseCaseAction(this.newEditUseCase, icon));
/*     */       else
/* 119 */         ABMUseCaseFactory.this.actionBuilder.addAction(
/* 120 */           new OpenUseCaseAction(this.newEditUseCase, 
/* 120 */           ABMUseCaseFactory.this.getNewActionTargetDecorator(), icon));
/* 121 */       builder.addCancelUseCaseAction();
/*     */     }
			final class InnerClass1 extends AbstractPanel
/*    */   {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 78 */     addEditElements(builder);
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder) {
/* 82 */     builder.addFinalizeUseCaseAction();
/* 83 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }
/*     */   }

/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.ABMUseCaseFactory
 * JD-Core Version:    0.6.0
 */