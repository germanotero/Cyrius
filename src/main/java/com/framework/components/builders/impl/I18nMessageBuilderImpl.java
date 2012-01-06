/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.MapFactory;
/*    */ import com.framework.utils.StringProvider;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class I18nMessageBuilderImpl
/*    */   implements MessageBuilder
/*    */ {
/* 16 */   private Map values = MapFactory.createMap();
/*    */ 
/* 18 */   private Map modelValues = MapFactory.createMap();
/*    */ 
/* 20 */   private String messageKey = "";
/*    */   private FormModel model;
/*    */ 
/*    */   public I18nMessageBuilderImpl(String key)
/*    */   {
/* 25 */     this.messageKey = key;
/*    */   }
/*    */ 
/*    */   public void setModel(FormModel model) {
/* 29 */     this.model = model;
/*    */   }
/*    */ 
/*    */   public I18nMessageBuilderImpl addValue(String key, Object value) {
/* 33 */     this.values.put(key, value);
/* 34 */     return this;
/*    */   }
/*    */ 
/*    */   public I18nMessageBuilderImpl addValue(String key, String modelProperty) {
/* 38 */     this.modelValues.put(key, modelProperty);
/* 39 */     return this;
/*    */   }
/*    */ 
/*    */   public I18nMessage build()
/*    */   {
/* 46 */     for (Iterator iter = this.modelValues.keySet().iterator(); iter
/* 47 */       .hasNext(); )
/*    */     {
/* 48 */       String key = (String)iter.next();
/* 49 */       FormModel value = this.model.getProperty(
/* 50 */         this.modelValues.get(key).toString());
/* 51 */       String valueToString = value.getValue() != null ? 
/* 52 */         value.toString() : "";
/* 53 */       this.values.put(key, valueToString);
/*    */     }
/* 55 */     return new I18nMessage(StringProvider.getInstance()
/* 56 */       .getValueOf(this.messageKey), this.values);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.I18nMessageBuilderImpl
 * JD-Core Version:    0.6.0
 */