/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.components.Combo;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ModelUtils;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class BasicLoadModelTargetListener
/*    */   implements ModelTargetListener
/*    */ {
/* 11 */   private transient Log log = LogFactory.getLog(getClass());
/*    */   private String modelProperty;
/*    */   private Combo combo;
/*    */ 
/*    */   public BasicLoadModelTargetListener(String modelProperty, Combo combo)
/*    */   {
/* 23 */     this.modelProperty = modelProperty;
/* 24 */     this.combo = combo;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model)
/*    */   {
/* 32 */     FormModel nestedProperty = ModelUtils.getNestedProperty(model, 
/* 33 */       this.modelProperty);
/* 34 */     this.log.debug("cargamos la propiedad " + nestedProperty);
/* 35 */     if (nestedProperty != null)
/* 36 */       this.combo.setSelectedItem(nestedProperty.getValue());
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.BasicLoadModelTargetListener
 * JD-Core Version:    0.6.0
 */