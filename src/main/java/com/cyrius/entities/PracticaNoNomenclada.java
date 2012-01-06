/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.cyrius.utils.PracticaVisitor;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import com.framework.utils.CollectionUtils;
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.collections.Closure;
/*    */ import org.apache.commons.collections.Predicate;
/*    */ 
/*    */ public class PracticaNoNomenclada extends Practica
/*    */ {
/* 21 */   private Collection<ConfiguracionPracticaNoNomencladaObraSocial> configuracionesObraSocial = CollectionFactory.createCollection(ConfiguracionPracticaNoNomencladaObraSocial.class);
/*    */ 
/*    */   public Collection<ConfiguracionPracticaNoNomencladaObraSocial> getRelacionObraSocialCodigoCosto()
/*    */   {
/* 28 */     return this.configuracionesObraSocial;
/*    */   }
/*    */ 
/*    */   public void setRelacionObraSocialCodigoCosto(Collection<ConfiguracionPracticaNoNomencladaObraSocial> relacionesOsCodCost)
/*    */   {
/* 33 */     this.configuracionesObraSocial = relacionesOsCodCost;
/*    */   }
/*    */ 
/*    */   public void accept(PracticaVisitor visitor)
/*    */   {
/* 38 */     visitor.visit(this);
/*    */   }
/*    */ 
/*    */   public void validate() {
/* 42 */     CollectionUtils.filter(this.configuracionesObraSocial, new Predicate()
/*    */     {
/*    */       public boolean evaluate(Object arg0) {
/* 45 */         ConfiguracionPracticaNoNomencladaObraSocial relacion = (ConfiguracionPracticaNoNomencladaObraSocial)arg0;
/* 46 */         return relacion.getCodigo() != null;
/*    */       }
/*    */     });
/* 50 */     CollectionUtils.forAllDo(this.configuracionesObraSocial, new Closure()
/*    */     {
/*    */       public void execute(Object arg0) {
/* 53 */         ConfiguracionPracticaNoNomencladaObraSocial relacion = (ConfiguracionPracticaNoNomencladaObraSocial)arg0;
/* 54 */         relacion.validate();
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.PracticaNoNomenclada
 * JD-Core Version:    0.6.0
 */