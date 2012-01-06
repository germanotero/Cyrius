/*    */ package com.framework.components;
/*    */ 
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.text.Document;
/*    */ 
/*    */ public class JDoubleField extends JTextField
/*    */ {
/*    */   public JDoubleField()
/*    */   {
/*    */   }
/*    */ 
/*    */   public JDoubleField(int columns)
/*    */   {
/* 29 */     super(columns);
/*    */   }
/*    */ 
/*    */   public JDoubleField(String text)
/*    */   {
/* 37 */     super(text);
/*    */   }
/*    */ 
/*    */   public JDoubleField(String text, int columns)
/*    */   {
/* 46 */     super(text, columns);
/*    */   }
/*    */ 
/*    */   public JDoubleField(Document doc, String text, int columns)
/*    */   {
/* 56 */     super(doc, text, columns);
/*    */   }
/*    */ 
/*    */   public Double getValue()
/*    */   {
/*    */     try {
/* 62 */       return new Double(super.getText().trim());
/*    */     }
/*    */     catch (NumberFormatException exception)
/*    */     {
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.JDoubleField
 * JD-Core Version:    0.6.0
 */