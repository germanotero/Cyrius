/*    */ package com.framework.utils;
/*    */ 
/*    */ import com.framework.entities.FormModelUtils;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class ModelUtils
/*    */ {
/*    */   public static FormModel getNestedProperty(FormModel parent, String propertyName)
/*    */   {
/* 13 */     return parent.getProperty(propertyName);
/*    */   }
/*    */ 
/*    */   public static FormModel getNestedProperty(Object parent, String propertyName) {
/* 17 */     return FormModelUtils.wrap(parent).getProperty(propertyName);
/*    */   }
/*    */ 
/*    */   public static void setNestedProperty(FormModel parent, String hierarchiMethod, Object argument)
/*    */   {
/* 22 */     parent.setProperty(hierarchiMethod, argument);
/*    */   }
/*    */ 
/*    */   public static void setNestedProperty(Object parent, String hierarchiMethod, Object argument)
/*    */   {
/* 27 */     FormModelUtils.wrap(parent).setProperty(hierarchiMethod, argument);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.ModelUtils
 * JD-Core Version:    0.6.0
 */