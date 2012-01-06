/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.utils.TruePredicate;
/*    */ 
/*    */ public class MultiplesGroup extends AbstractGroup
/*    */ {
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 10 */     return MultiplesModel.class;
/*    */   }
/*    */ 
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 15 */     builder.addStringField("multiples")
/* 16 */       .setDisableOn(TruePredicate.INSTANCE);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.MultiplesGroup
 * JD-Core Version:    0.6.0
 */