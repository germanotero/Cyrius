/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ClassUtils;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class InvokeMethodWithArgumentModelTableListener extends AbstractGridModelTargetListener
/*    */ {
/*    */   private Object searcher;
/*    */   private String[] argumentProperty;
/*    */ 
/*    */   public InvokeMethodWithArgumentModelTableListener(Object searcher, String argumentProperty)
/*    */   {
/* 17 */     this(searcher, new String[] { argumentProperty });
/*    */   }
/*    */ 
/*    */   public InvokeMethodWithArgumentModelTableListener(Object searcher, String[] argumentProperty)
/*    */   {
/* 23 */     this.searcher = searcher;
/* 24 */     this.argumentProperty = argumentProperty;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model) {
/* 28 */     Object[] arguments = new Object[this.argumentProperty.length];
/* 29 */     boolean readyForSearch = false;
/* 30 */     for (int i = 0; i < this.argumentProperty.length; i++) {
/* 31 */       String propertyName = this.argumentProperty[i];
/* 32 */       FormModel value = model.getProperty(propertyName);
/* 33 */       if (value != null) {
/* 34 */         readyForSearch = true;
/* 35 */         arguments[i] = value.getValue();
/*    */       }
/*    */     }
/* 38 */     if (readyForSearch)
/* 39 */       getGridModel().setValues(
/* 40 */         (Collection)ClassUtils.invokeMethod(this.searcher, 
/* 41 */         getModelProperty(), arguments));
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.InvokeMethodWithArgumentModelTableListener
 * JD-Core Version:    0.6.0
 */