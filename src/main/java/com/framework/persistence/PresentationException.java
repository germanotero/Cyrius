/*    */ package com.framework.persistence;
/*    */ 
/*    */ import com.framework.components.builders.impl.I18nMessage;
/*    */ import com.framework.components.builders.impl.I18nMessageBuilderImpl;
/*    */ import com.framework.exceptions.NoopMessageStrategy;
/*    */ 
/*    */ public class PresentationException extends ApplicationException
/*    */ {
/*    */   public PresentationException()
/*    */   {
/* 10 */     setStrategy(NoopMessageStrategy.INSTANCE);
/*    */   }
/*    */ 
/*    */   public PresentationException(String message, Throwable cause) {
/* 14 */     super(message, cause);
/* 15 */     setStrategy(NoopMessageStrategy.INSTANCE);
/*    */   }
/*    */ 
/*    */   public PresentationException(String message) {
/* 19 */     super(message);
/* 20 */     setStrategy(NoopMessageStrategy.INSTANCE);
/*    */   }
/*    */ 
/*    */   public PresentationException(Throwable cause) {
/* 24 */     super(cause);
/* 25 */     setStrategy(NoopMessageStrategy.INSTANCE);
/*    */   }
/*    */ 
/*    */   public PresentationException(I18nMessageBuilderImpl exceptionMessageBuilder) {
/* 29 */     super(exceptionMessageBuilder.build().toString());
/* 30 */     setStrategy(NoopMessageStrategy.INSTANCE);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.PresentationException
 * JD-Core Version:    0.6.0
 */