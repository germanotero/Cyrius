/*    */ package com.cyrius.searchers;
/*    */ 
/*    */ import com.cyrius.entities.TipoDocumento;
/*    */ import com.framework.persistence.PersistenceService;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class TipoDocumentoSearcher
/*    */ {
/*    */   private static TipoDocumentoSearcher instance;
/*    */ 
/*    */   public static synchronized TipoDocumentoSearcher getInstance()
/*    */   {
/* 16 */     if (instance == null) {
/* 17 */       instance = new TipoDocumentoSearcher();
/*    */     }
/* 19 */     return instance;
/*    */   }
/*    */ 
/*    */   public static Collection findAll() {
/* 23 */     return PersistenceService.getInstance().loadAll(TipoDocumento.class);
/*    */   }
/*    */ 
/*    */   public static TipoDocumento getDNI() {
/* 27 */     return (TipoDocumento)PersistenceService.getInstance().load(TipoDocumento.class, "DNI");
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.searchers.TipoDocumentoSearcher
 * JD-Core Version:    0.6.0
 */