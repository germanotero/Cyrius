/*    */ package com.cyrius.turnos.gui.practicas.noNomencladas;
/*    */ 
/*    */ import com.cyrius.entities.ConfiguracionPracticaNoNomencladaObraSocial;
/*    */ import com.cyrius.entities.ObraSocial;
/*    */ import com.cyrius.entities.PracticaNoNomenclada;
/*    */ import com.cyrius.searchers.BuscadorObraSocial;
/*    */ import com.framework.models.DelegatingModel;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections4.Closure;
/*    */ import org.apache.commons.collections4.CollectionUtils;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ public class PracticaNoNomencladaModel
/*    */   implements DelegatingModel
/*    */ {
/*    */   private PracticaNoNomenclada practicaNoNomenclada;
/*    */ 
/*    */   public PracticaNoNomencladaModel()
/*    */   {
/* 20 */     this(new PracticaNoNomenclada());
/*    */   }
/*    */ 
/*    */   public PracticaNoNomencladaModel(PracticaNoNomenclada practicaToEdit) {
/* 24 */     this.practicaNoNomenclada = practicaToEdit;
/*    */   }
/*    */ 
/*    */   public Object getDelegatee()
/*    */   {
/* 31 */     return this.practicaNoNomenclada;
/*    */   }
/*    */ 
/*    */   public Collection getRelacionObraSocialCodigoCosto() {
/* 35 */     Collection relaciones = this.practicaNoNomenclada
/* 36 */       .getRelacionObraSocialCodigoCosto();
/* 37 */     Collection obras = BuscadorObraSocial.findAll();
/* 38 */     CollectionUtils.forAllDo(obras, new CrearRelacionesClosure(relaciones));
/* 39 */     return relaciones;
/*    */   }
/*    */ 
/*    */   private class CrearRelacionesClosure implements Closure
/*    */   {
/*    */     private final Collection<ConfiguracionPracticaNoNomencladaObraSocial> relaciones;
/*    */ 
/*    */     private CrearRelacionesClosure(Collection<ConfiguracionPracticaNoNomencladaObraSocial> relaciones) {
/* 48 */       this.relaciones = relaciones;
/*    */     }
/*    */ 
/*    */     public void execute(Object arg0) {
/* 52 */       ObraSocial os = (ObraSocial)arg0;
/* 53 */       if (CollectionUtils.find(this.relaciones, 
/* 54 */         new PracticaNoNomencladaModel.RelacionPerteneceAObraSocialPredicate( os)) == null) {
/* 55 */         ConfiguracionPracticaNoNomencladaObraSocial relacion = new ConfiguracionPracticaNoNomencladaObraSocial();
/* 56 */         relacion.setObraSocial(os);
/* 57 */         this.relaciones.add(relacion);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   private final class RelacionPerteneceAObraSocialPredicate implements Predicate
/*    */   {
/*    */     private ObraSocial os;
/*    */ 
/*    */     private RelacionPerteneceAObraSocialPredicate(ObraSocial os)
/*    */     {
/* 69 */       this.os = os;
/*    */     }
/*    */ 
/*    */     public boolean evaluate(Object arg0) {
/* 73 */       ConfiguracionPracticaNoNomencladaObraSocial relacion = (ConfiguracionPracticaNoNomencladaObraSocial)arg0;
/* 74 */       return relacion.getObraSocial().equals(this.os);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.noNomencladas.PracticaNoNomencladaModel
 * JD-Core Version:    0.6.0
 */