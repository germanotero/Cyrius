/*    */ package com.framework.components;
/*    */ 
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.text.Document;
/*    */ 
/*    */ public class JIntegerField extends JTextField
/*    */ {
/*    */   public JIntegerField()
/*    */   {
/*    */   }
/*    */ 
/*    */   public JIntegerField(String arg0)
/*    */   {
/* 33 */     super(arg0);
/*    */   }
/*    */ 
/*    */   public JIntegerField(int arg0)
/*    */   {
/* 41 */     super(arg0);
/*    */   }
/*    */ 
/*    */   public JIntegerField(String arg0, int arg1)
/*    */   {
/* 50 */     super(arg0, arg1);
/*    */   }
/*    */ 
/*    */   public JIntegerField(Document arg0, String arg1, int arg2)
/*    */   {
/* 60 */     super(arg0, arg1, arg2);
/*    */   }
/*    */ 
/*    */   public Integer getValue()
/*    */   {
/*    */     try {
/* 66 */       return new Integer(super.getText().trim());
/*    */     } catch (NumberFormatException exception) {
/*    */     }
/* 69 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean isEmpty()
/*    */   {
/* 75 */     return super.getText().trim().length() == 0;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.JIntegerField
 * JD-Core Version:    0.6.0
 */