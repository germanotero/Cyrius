/*    */ package com.framework.utils;
/*    */ 
/*    */ public class StringUtils extends org.apache.commons.lang.StringUtils
/*    */ {
/*    */   public static String getI18NKey(Object model, String property)
/*    */   {
/* 13 */     String modelValue = ClassUtils.getShortName(model.getClass());
/* 14 */     modelValue = modelValue.substring(0, 1).toLowerCase() + 
/* 15 */       modelValue.substring(1);
/* 16 */     return modelValue + "." + property;
/*    */   }
/*    */ 
/*    */   public static boolean isNullOrEmpty(String string) {
/* 20 */     return (string == null) || ("".equals(string));
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.StringUtils
 * JD-Core Version:    0.6.0
 */