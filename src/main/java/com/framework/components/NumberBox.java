/*    */ package com.framework.components;
/*    */ 
/*    */ import java.text.NumberFormat;
/*    */ 
/*    */ public class NumberBox extends AbstractFormInput
/*    */ {
/*    */   public NumberBox(String name)
/*    */   {
/* 19 */     super(NumberFormat.getIntegerInstance(), name);
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 27 */     return new Integer(textToTransform.toString());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.NumberBox
 * JD-Core Version:    0.6.0
 */