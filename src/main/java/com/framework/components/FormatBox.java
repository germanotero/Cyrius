/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.utils.AbstractTransformer;
/*    */ import java.text.Format;
/*    */ 
/*    */ public class FormatBox extends AbstractFormInput
/*    */ {
/*    */   private AbstractTransformer<String> transformer;
/*    */ 
/*    */   public FormatBox(AbstractTransformer<String> valueTransformer, Format format, String name)
/*    */   {
/* 13 */     super(format, name);
/* 14 */     this.transformer = valueTransformer;
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 19 */     return this.transformer.transform(textToTransform.toString());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.FormatBox
 * JD-Core Version:    0.6.0
 */