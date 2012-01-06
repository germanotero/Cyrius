/*    */ package com.framework.components;
/*    */ 
/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.text.SimpleDateFormat;
/*    */ 
/*    */ public class CalendarBox extends AbstractFormInput
/*    */ {
/* 11 */   private static final SimpleDateFormat FORMAT = new SimpleDateFormat(
/* 12 */     "dd/MM/yyyy");
/*    */ 
/*    */   public CalendarBox(String name)
/*    */   {
/* 18 */     super(FORMAT, name);
/*    */   }
/*    */ 
/*    */   protected void initSubComponent()
/*    */   {
/* 25 */     addKeyListener(new KeyAdapter()
/*    */     {
/*    */       public void keyPressed(KeyEvent e)
/*    */       {
/* 29 */         if ((CalendarBox.this.getCaretPosition() > 9) && (e.getKeyCode() != 8))
/* 30 */           CalendarBox.this.setText(CalendarBox.this.getText().substring(0, 9));
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 41 */     return textToTransform;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.CalendarBox
 * JD-Core Version:    0.6.0
 */