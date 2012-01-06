/*    */ package com.framework.exceptions;
/*    */ 
/*    */ import com.framework.utils.StringProvider;
/*    */ import com.framework.utils.StringUtils;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class NotFullFormException extends ShowableExceptionImpl
/*    */ {
/*    */   private String fieldName;
/*    */ 
/*    */   public NotFullFormException()
/*    */   {
/* 20 */     super(StringProvider.getInstance().getValueOf("notFullFormException"), 
/* 20 */       NoopMessageStrategy.INSTANCE);
/* 21 */     this.fieldName = "";
/*    */   }
/*    */ 
/*    */   public NotFullFormException(String messageKey, String fieldName)
/*    */   {
/* 26 */     super(StringProvider.getInstance().getValueOf(messageKey) + ": " + 
/* 26 */       fieldName, NoopMessageStrategy.INSTANCE);
/* 27 */     this.fieldName = fieldName;
/*    */   }
/*    */ 
/*    */   public NotFullFormException(String fieldName)
/*    */   {
/* 32 */     super(StringProvider.getInstance().getValueOf("notFullFormException") + 
/* 32 */       ": " + fieldName, NoopMessageStrategy.INSTANCE);
/* 33 */     this.fieldName = fieldName;
/*    */   }
/*    */ 
/*    */   public String getFieldName() {
/* 37 */     return this.fieldName.trim();
/*    */   }
/*    */ 
/*    */   public static void validateTrue(String i18nkey, boolean value)
/*    */   {
/* 48 */     if (!value)
/* 49 */       throw new NotFullFormException(i18nkey, "");
/*    */   }
/*    */ 
/*    */   public static void validateNotNull(String messageKey, Object object)
/*    */   {
/* 59 */     if (object == null)
/* 60 */       throw new NotFullFormException(messageKey, "");
/*    */   }
/*    */ 
/*    */   public static void validateNotEmptyCollection(String messajeKey, Collection col)
/*    */   {
/* 65 */     validateTrue(messajeKey, !col.isEmpty());
/*    */   }
/*    */ 
/*    */   public static void validateNotEmpty(String messajeKey, String string) {
/* 69 */     validateTrue(messajeKey, !StringUtils.isNullOrEmpty(string));
/*    */   }
/*    */ 
/*    */   public String getHelpMessage() {
/* 73 */     return "Under Construction";
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.NotFullFormException
 * JD-Core Version:    0.6.0
 */