/*    */ package com.cyrius.config;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CyriusBusinessConfig
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Medico medico;
/*    */ 
/*    */   CyriusBusinessConfig()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CyriusBusinessConfig(Medico medico)
/*    */   {
/* 36 */     this.medico = medico;
/*    */   }
/*    */ 
/*    */   public Medico getDefaultMedic() {
/* 40 */     return this.medico;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.config.CyriusBusinessConfig
 * JD-Core Version:    0.6.0
 */