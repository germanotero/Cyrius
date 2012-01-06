/*     */ package com.framework.dynamicForms.integration;
/*     */ 
/*     */ import com.framework.actions.AbstractFormAction;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.dynamicForms.entities.DynamicForm;
/*     */ import com.framework.dynamicForms.forms.DynamicUseCaseBuilder;
/*     */ import com.framework.dynamicForms.forms.DynamicUseCaseFactory;
/*     */ import com.framework.entities.DynamicFormDecorator;
/*     */ import com.framework.entities.DynamicFormModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.ClassUtils;
/*     */ import com.framework.utils.ModelUtils;
/*     */ import java.math.BigInteger;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.commons.collections.Transformer;
/*     */ import org.apache.commons.collections.functors.ConstantTransformer;
/*     */ 
/*     */ public class OpenDynamicFormAction extends AbstractFormAction
/*     */ {
/*     */   private String formProperty;
/*     */   private Transformer transformer;
/*     */   private Class target;
/*     */ 
/*     */   public OpenDynamicFormAction(String formProperty, Transformer decorator)
/*     */   {
/*  33 */     this.formProperty = formProperty;
/*  34 */     this.transformer = decorator;
/*     */   }
/*     */ 
/*     */   public OpenDynamicFormAction(String formProperty) {
/*  38 */     this(formProperty, new ConstantTransformer(new DefaultDecorator()));
/*  39 */     this.formProperty = formProperty;
/*     */   }
/*     */ 
/*     */   public OpenDynamicFormAction(String formProperty, Class target) {
/*  43 */     this(formProperty, new ConstantTransformer(new DefaultDecorator()));
/*  44 */     this.formProperty = formProperty;
/*  45 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public OpenDynamicFormAction() {
/*  49 */     super();
/*     */   }
/*     */ 
/*     */   public OpenDynamicFormAction(Class target) {
/*  53 */     super();
/*  54 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public OpenDynamicFormAction(Transformer decorator) {
/*  58 */     this(null, decorator);
/*     */   }
/*     */ 
/*     */   private SimpleModelTarget getTarget() {
/*  62 */     if (this.target == null) {
/*  63 */       return new DefaultTarget(getPadre().getOpenTarget());
/*     */     }
/*  65 */     return (SimpleModelTarget)ClassUtils.newInstance(this.target, 
/*  66 */       new Class[] { SimpleModelTarget.class }, new Object[] { 
/*  67 */       getPadre().getOpenTarget() });
/*     */   }
/*     */ 
/*     */   protected void executeFormAction(FormModel model)
/*     */     throws Exception
/*     */   {
/*     */     DynamicForm form;
/*  75 */     if (this.formProperty != null)
/*  76 */       form = (DynamicForm)ModelUtils.getNestedProperty(model, 
/*  77 */         this.formProperty).getValue();
/*     */     else {
/*  79 */       form = (DynamicForm)model.getValue();
/*     */     }
/*  81 */     DynamicUseCaseFactory formBuilded = DynamicUseCaseBuilder.build(form);
/*  82 */     SimpleModelTarget target = getTarget();
/*  83 */     formBuilded.setModelo(target.getModel(model));
/*  84 */     formBuilded.setReturnTarget(target);
/*  85 */     formBuilded.startUseCase();
/*     */   }
/*     */ 
/*     */   protected boolean isImpactableModelAction()
/*     */   {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   protected void setUpAction()
/*     */   {
/* 100 */     setActionKey("openDynamicForm");
/*     */   }
/*     */ 
/*     */   private static class DefaultDecorator implements DynamicFormDecorator {
/*     */     public void finishForm(String xmlData) {
/* 105 */       JOptionPane.showMessageDialog(null, "Finalizacion exitosa");
/*     */     }
/*     */ 
/*     */     public String getName() {
/* 109 */       return "";
/*     */     }
/*     */ 
/*     */     public String getDestinationName()
/*     */     {
/* 114 */       return "";
/*     */     }
/*     */ 
/*     */     public BigInteger getNro()
/*     */     {
/* 119 */       return null;
/*     */     }
/*     */ 
/*     */     public String getDatosXML()
/*     */     {
/* 124 */       return "";
/*     */     }
/*     */ 
/*     */     public boolean isPersisted() {
/* 128 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public class DefaultTarget extends SimpleModelTarget
/*     */   {
/*     */     public DefaultTarget(SimpleModelTarget target)
/*     */     {
/* 136 */       super(target);
/*     */     }
/*     */ 
/*     */     protected FormModel initModel(FormModel model)
/*     */     {
/* 141 */       return new DynamicFormModel((DynamicFormDecorator)
/* 142 */         OpenDynamicFormAction.this.transformer.transform(model.getValue()));
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.integration.OpenDynamicFormAction
 * JD-Core Version:    0.6.0
 */