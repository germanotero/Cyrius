/*     */ package com.framework.exceptions;
/*     */ 
/*     */ import com.framework.utils.StringUtils;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public class ShowableExceptionImpl extends RuntimeException
/*     */   implements ShowableException
/*     */ {
/*  11 */   private ShowMessageStrategy strategy = new I18nMessageStrategy();
/*     */   protected String fieldName;
/*  15 */   private int messageType = 0;
/*     */ 
/*     */   public ShowableExceptionImpl(String message, Throwable cause) {
/*  18 */     super(message, cause);
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(Throwable cause) {
/*  22 */     super(cause);
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl() {
/*  26 */     super("ERROR");
/*  27 */     this.fieldName = "";
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(String messageKey, String fieldName) {
/*  31 */     super(messageKey);
/*  32 */     this.fieldName = fieldName;
/*  33 */     this.strategy = new ConcatStringMessageStrategy(fieldName);
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(String message) {
/*  37 */     super(message);
/*  38 */     this.strategy = new ConcatStringMessageStrategy(this.fieldName);
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(String message, Throwable cause, ShowMessageStrategy strategy)
/*     */   {
/*  43 */     super(message, cause);
/*  44 */     this.strategy = strategy;
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(Throwable cause, ShowMessageStrategy strategy) {
/*  48 */     super(cause);
/*  49 */     this.strategy = strategy;
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(ShowMessageStrategy strategy) {
/*  53 */     super("ERROR");
/*  54 */     this.fieldName = "";
/*  55 */     this.strategy = strategy;
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(String messageKey, String fieldName, ShowMessageStrategy strategy)
/*     */   {
/*  60 */     super(messageKey);
/*  61 */     this.fieldName = fieldName;
/*  62 */     this.strategy = strategy;
/*  63 */     this.strategy = new ConcatStringMessageStrategy(fieldName);
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl(String message, ShowMessageStrategy strategy) {
/*  67 */     super(message);
/*  68 */     this.strategy = new ConcatStringMessageStrategy(this.fieldName);
/*  69 */     this.strategy = strategy;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/*  74 */     return this.strategy.transformMessage(super.getMessage());
/*     */   }
/*     */ 
/*     */   public static void validateTrue(String i18nkey, boolean value)
/*     */   {
/*  85 */     if (!value)
/*  86 */       throw new ShowableExceptionImpl(i18nkey, "");
/*     */   }
/*     */ 
/*     */   public static void validateTrue(String i18nkey, String data, boolean value)
/*     */   {
/*  97 */     if (!value)
/*  98 */       throw new ShowableExceptionImpl(i18nkey, data);
/*     */   }
/*     */ 
/*     */   public static void validateNotNull(String messageKey, Object object)
/*     */   {
/* 108 */     if (object == null)
/* 109 */       throw new ShowableExceptionImpl(messageKey);
/*     */   }
/*     */ 
/*     */   public static void validateNotNull(String messageKey, String data, Object object)
/*     */   {
/* 114 */     if (object == null)
/* 115 */       throw new ShowableExceptionImpl(messageKey, data);
/*     */   }
/*     */ 
/*     */   public static void validateNotEmptyCollection(String messajeKey, Collection col)
/*     */   {
/* 120 */     validateTrue(messajeKey, !col.isEmpty());
/*     */   }
/*     */ 
/*     */   public static void validateNotEmpty(String messajeKey, String string) {
/* 124 */     validateTrue(messajeKey, !StringUtils.isNullOrEmpty(string));
/*     */   }
/*     */ 
/*     */   public String getHelpMessage() {
/* 128 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl setStrategy(ShowMessageStrategy strategy) {
/* 132 */     this.strategy = strategy;
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */   public int getMessageType() {
/* 137 */     return this.messageType;
/*     */   }
/*     */ 
/*     */   public ShowableExceptionImpl setMessageType(int messageType) {
/* 141 */     this.messageType = messageType;
/* 142 */     return this;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.exceptions.ShowableExceptionImpl
 * JD-Core Version:    0.6.0
 */