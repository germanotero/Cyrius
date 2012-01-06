/*    */ package com.cyrius.components;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.searchers.BuscadorMedicos;
/*    */ import com.framework.abstractfactorys.BorderFactory;
/*    */ import com.framework.components.DefaultComboBox;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ 
/*    */ public class CyriusComboMedicos<T> extends DefaultComboBox
/*    */ {
/*    */   public CyriusComboMedicos()
/*    */   {
/* 22 */     setValues(CollectionFactory.createVector(
/* 23 */       BuscadorMedicos.getInstance().findAll()));
/*    */   }
/*    */ 
/*    */   public Object getSelectedItem()
/*    */   {
/* 28 */     return super.getSelectedItem();
/*    */   }
/*    */ 
/*    */   public void initComponent()
/*    */   {
/* 36 */     setBorder(BorderFactory.createDefaultComboBorder());
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public void setTodos()
/*    */   {
/* 44 */     setValues(CollectionFactory.createVector(
/* 45 */       BuscadorMedicos.getInstance().findAll()));
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public Medico getSelectedMedico()
/*    */   {
/* 53 */     return (Medico)getItemAt(getSelectedIndex());
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public Number getSelectedMedicoId()
/*    */   {
/* 62 */     return ((Medico)getItemAt(getSelectedIndex())).getId();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.components.CyriusComboMedicos
 * JD-Core Version:    0.6.0
 */