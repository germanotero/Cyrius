/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.exceptions.ProgramException;
/*    */ import com.framework.utils.MapFactory;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class I18nMessage
/*    */ {
/*    */   private String i18nValue;
/* 18 */   private Map values = MapFactory.createMap();
/*    */ 
/*    */   public I18nMessage(String i18nValue, Map valueMap)
/*    */   {
/* 22 */     this.i18nValue = i18nValue;
/* 23 */     this.values = valueMap;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 31 */     int startIndex = this.i18nValue.indexOf("${");
/* 32 */     while (startIndex != -1) {
/* 33 */       int endIndex = this.i18nValue.indexOf("}");
/* 34 */       String keyToChange = this.i18nValue.substring(startIndex + 2, endIndex);
/* 35 */       Object valor = this.values.get(keyToChange);
/* 36 */       ProgramException.validateNotNull(
/* 37 */         "Error no se encontro el valor para la key " + keyToChange, 
/* 38 */         valor);
/* 39 */       String value = valor.toString();
/* 40 */       this.i18nValue = 
/* 41 */         StringUtils.replace(this.i18nValue, this.i18nValue
/* 41 */         .substring(startIndex, endIndex + 1), value);
/* 42 */       startIndex = this.i18nValue.indexOf("${");
/*    */     }
/* 44 */     return this.i18nValue;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.I18nMessage
 * JD-Core Version:    0.6.0
 */