/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.FormInput;
/*    */ import com.framework.components.FormatBox;
/*    */ import com.framework.utils.AbstractTransformer;
/*    */ import java.text.DecimalFormat;
/*    */ 
/*    */ public class TipoDoubleFormInput
/*    */   implements TipoFormInput
/*    */ {
/* 11 */   public static final TipoFormInput INSTANCE = new TipoDoubleFormInput();
/*    */ 
/*    */   public FormInput getInput(String name)
/*    */   {
/* 18 */     return new FormatBox(new StringToDoubleTransformer(), 
/* 19 */       DecimalFormat.getNumberInstance(), name);
/*    */   }
/*    */   private class StringToDoubleTransformer extends AbstractTransformer<String> {
/*    */     private StringToDoubleTransformer() {
/*    */     }
/*    */ 
/*    */     public Object transformValue(String c) {
/* 26 */       return new Double(c);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.TipoDoubleFormInput
 * JD-Core Version:    0.6.0
 */