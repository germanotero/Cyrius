/*    */ package com.cyrius.turnos.gui.practicas.nomencladas;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractGroup;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ 
/*    */ public class HonorariosNomencladasGroup extends AbstractGroup
/*    */ {
/*    */   protected void registerGroupElements(FormElementsBuilder builder)
/*    */   {
/* 11 */     builder.addDoubleField("cantGalenosHonorario").required();
/* 12 */     builder.addDoubleField("cantGalenosCosto").required();
/*    */   }
/*    */ 
/*    */   protected Class getAsociatedModel()
/*    */   {
/* 18 */     throw new UnsupportedOperationException(
/* 19 */       "Revisarme, tiene que tener un modelo este grupo?");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.nomencladas.HonorariosNomencladasGroup
 * JD-Core Version:    0.6.0
 */