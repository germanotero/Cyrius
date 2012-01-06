/*    */ package com.cyrius.utils;
/*    */ 
/*    */ import com.cyrius.entities.Practica;
/*    */ import com.cyrius.entities.PracticaNoNomenclada;
/*    */ import com.cyrius.entities.PracticaNomenclada;
/*    */ 
/*    */ public abstract class PracticaVisitor
/*    */ {
/*    */   public final void visit(Practica p)
/*    */   {
/* 10 */     p.accept(this);
/*    */   }
/*    */ 
/*    */   public abstract void visit(PracticaNoNomenclada paramPracticaNoNomenclada);
/*    */ 
/*    */   public abstract void visit(PracticaNomenclada paramPracticaNomenclada);
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.utils.PracticaVisitor
 * JD-Core Version:    0.6.0
 */