/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.components.FormComponent;
/*    */ import com.framework.components.ModelEnableElementsContainer;
/*    */ import com.framework.components.builders.interfaces.Builder;
/*    */ import com.xduke.xlayouts.XTableLayout;
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ public class FormBuilder
/*    */   implements Builder
/*    */ {
/*    */   private ModelEnableElementsContainer container;
/*    */ 
/*    */   public FormBuilder(ModelEnableElementsContainer container)
/*    */   {
/* 15 */     this.container = container;
/* 16 */     addLayout();
/*    */   }
/*    */ 
/*    */   public FormBuilder addComponent(FormComponent componentBuilder, String constraints)
/*    */   {
/* 21 */     this.container.addElement(componentBuilder, constraints);
/* 22 */     return this;
/*    */   }
/*    */ 
/*    */   public FormBuilder addJComponent(JComponent componentBuilder, String constraints)
/*    */   {
/* 27 */     this.container.addElement(componentBuilder, constraints);
/* 28 */     return this;
/*    */   }
/*    */ 
/*    */   public Object build() {
/* 32 */     return this.container;
/*    */   }
/*    */ 
/*    */   private void addLayout() {
/* 36 */     XTableLayout tableLayout = new XTableLayout(4, 5);
/* 37 */     this.container.setLayout(tableLayout);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.FormBuilder
 * JD-Core Version:    0.6.0
 */