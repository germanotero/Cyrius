/*    */ package com.framework.components;
/*    */ 
/*    */ public class TextBox extends AbstractFormInput
/*    */ {
/*    */   public TextBox(String name)
/*    */   {
/* 14 */     super(name);
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 22 */     return super.getText();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.TextBox
 * JD-Core Version:    0.6.0
 */