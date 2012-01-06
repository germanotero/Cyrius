/*    */ package com.framework.abstractfactorys;
/*    */ 
/*    */ import com.framework.print.builder.PrintableElementsBuilder;
/*    */ import org.apache.commons.collections.Closure;
/*    */ 
/*    */ public class DirectGroupsClosure
/*    */   implements Closure
/*    */ {
/*    */   private final PrintableElementsBuilder print;
/*    */ 
/*    */   public DirectGroupsClosure(PrintableElementsBuilder print)
/*    */   {
/* 12 */     this.print = print;
/*    */   }
/*    */ 
/*    */   public void execute(Object arg0) {
/* 16 */     AbstractGroup group = (AbstractGroup)arg0;
/* 17 */     group.direct(this.print);
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.DirectGroupsClosure
 * JD-Core Version:    0.6.0
 */