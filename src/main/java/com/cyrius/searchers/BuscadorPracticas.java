/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class BuscadorPracticas
/*    */ {
/*    */   public static Collection findAll()
/*    */   {
/* 23 */     Collection col = BuscadorPracticasNomencladas.findAll();
/* 24 */     col.addAll(BuscadorPracticasNoNomencladas.findAll());
/* 25 */     return col;
/*    */   }
/*    */ 
/*    */   public static Collection findByMedico(int i) {
/* 29 */     return findAll();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.BuscadorPracticas
 * JD-Core Version:    0.6.0
 */