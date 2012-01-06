/*    */ package com.framework.components;
/*    */ 
/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.text.SimpleDateFormat;
/*    */ 
/*    */ public class TimeBox extends AbstractFormInput
/*    */ {
/*  9 */   private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm");
/*    */ 
/*    */   public TimeBox(String name)
/*    */   {
/* 15 */     super(FORMAT, name);
/*    */   }
/*    */ 
/*    */   protected void initSubComponent()
/*    */   {
/* 22 */     addKeyListener(new KeyAdapter()
/*    */     {
/*    */       public void keyPressed(KeyEvent e)
/*    */       {
/* 26 */         if ((TimeBox.this.getCaretPosition() > 9) && (e.getKeyCode() != 8))
/* 27 */           TimeBox.this.setText(TimeBox.this.getText().substring(0, 9));
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 38 */     return textToTransform;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.TimeBox
 * JD-Core Version:    0.6.0
 */