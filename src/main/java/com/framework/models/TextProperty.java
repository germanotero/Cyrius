/*    */ package com.framework.models;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ import com.framework.utils.StringUtils;
/*    */ 
/*    */ public final class TextProperty
/*    */ {
/*    */   private String description;
/*    */   private String key;
/*    */ 
/*    */   public TextProperty(Object model, String key)
/*    */   {
/* 16 */     this.description = StringProvider.getInstance()
/* 17 */       .getValueOf(StringUtils.getI18NKey(model, key));
/* 18 */     this.key = key;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 22 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 26 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getKey() {
/* 30 */     return this.key;
/*    */   }
/*    */ 
/*    */   public void setKey(String key) {
/* 34 */     this.key = key;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.models.TextProperty
 * JD-Core Version:    0.6.0
 */