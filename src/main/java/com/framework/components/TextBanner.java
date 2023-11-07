/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.actions.FormDataComponent;
/*    */ import com.framework.print.builder.PrintableElementsBuilder;
/*    */ import javax.swing.JTextPane;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class TextBanner extends JTextPane
/*    */   implements FormDataComponent
/*    */ {
/*    */   public void initComponent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void refreshComponent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean hasVisibleCondition()
/*    */   {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   public FormComponent setNotVisibleOn(Predicate condition)
/*    */   {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean isColumnComponent()
/*    */   {
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   public void direct(PrintableElementsBuilder print) {
/* 53 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ 
/*    */   public FormComponent setDisableOn(Predicate condition)
/*    */   {
/* 58 */     throw new RuntimeException("Under Construction:" + getClass());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.TextBanner
 * JD-Core Version:    0.6.0
 */