/*    */ package com.framework.components.listeners;
/*    */ 
/*    */ import com.framework.exceptions.ShowableExceptionImpl;
/*    */ import com.framework.models.FormGridModel;
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.ClassUtils;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class InvokeMethodModelTableListener extends AbstractGridModelTargetListener
/*    */ {
/*    */   private Object searcher;
/*    */ 
/*    */   public InvokeMethodModelTableListener(Object searcher)
/*    */   {
/* 16 */     this.searcher = searcher;
/*    */   }
/*    */ 
/*    */   public void load(FormModel model) {
/*    */     try {
/* 21 */       getGridModel().setValues(
/* 22 */         (Collection)ClassUtils.invokeMethod(this.searcher, 
/* 23 */         getModelProperty()));
/*    */     } catch (ShowableExceptionImpl ex) {
/* 25 */       throw ex;
/*    */     } catch (Exception e) {
/* 27 */       if ((e.getCause() instanceof ShowableExceptionImpl)) {
/* 28 */         throw ((ShowableExceptionImpl)e.getCause());
/*    */       }
/* 30 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void unLoad(FormModel formModel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.listeners.InvokeMethodModelTableListener
 * JD-Core Version:    0.6.0
 */