/*    */ package com.framework.components;
/*    */ 
/*    */ import java.text.NumberFormat;
/*    */ import java.util.Locale;
/*    */ 
/*    */ public class FloatBox extends AbstractFormInput
/*    */ {
/*    */   public FloatBox(String name)
/*    */   {
/* 15 */     super(NumberFormat.getNumberInstance(Locale.US), name);
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 23 */     return textToTransform;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FloatBox
 * JD-Core Version:    0.6.0
 */