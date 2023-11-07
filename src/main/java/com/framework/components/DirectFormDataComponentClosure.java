/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.actions.FormDataComponent;
/*    */ import com.framework.print.builder.PrintableElementsBuilder;
/*    */ import org.apache.commons.collections4.Closure;
/*    */ 
/*    */ public class DirectFormDataComponentClosure
/*    */   implements Closure
/*    */ {
/*    */   private final PrintableElementsBuilder print;
/*    */ 
/*    */   public DirectFormDataComponentClosure(PrintableElementsBuilder print)
/*    */   {
/* 13 */     this.print = print;
/*    */   }
/*    */ 
/*    */   public void execute(Object arg0) {
/* 17 */     FormDataComponent component = (FormDataComponent)arg0;
/* 18 */     component.direct(this.print);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.DirectFormDataComponentClosure
 * JD-Core Version:    0.6.0
 */