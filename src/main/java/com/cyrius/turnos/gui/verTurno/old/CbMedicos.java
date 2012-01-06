/*    */ package com.cyrius.turnos.gui.verTurno.old;
/*    */ 
/*    */ import com.cyrius.entities.Medico;
/*    */ import com.cyrius.entities.Practica;
/*    */ import com.cyrius.searchers.BuscadorMedicos;
/*    */ import com.framework.components.JAutoComboBox;
/*    */ import java.io.IOException;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ 
/*    */ public class CbMedicos extends JAutoComboBox
/*    */ {
/*    */   private Object[] nombres;
/* 24 */   private Practica practica = null;
/*    */ 
/*    */   public void refresh()
/*    */     throws ClassNotFoundException, SQLException, IOException
/*    */   {
/* 32 */     if (this.practica != null) {
/* 33 */       BuscarMedicos();
/* 34 */       setModel(new DefaultComboBoxModel(this.nombres));
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setMedico(Practica pracId) throws ClassNotFoundException, SQLException, IOException
/*    */   {
/* 40 */     this.practica = pracId;
/* 41 */     BuscarMedicos();
/* 42 */     setModel(new DefaultComboBoxModel(this.nombres));
/* 43 */     setSelectedIndex(-1);
/*    */   }
/*    */ 
/*    */   public void setTodos() {
/* 47 */     buscarTodos();
/* 48 */     setModel(new DefaultComboBoxModel(this.nombres));
/*    */   }
/*    */ 
/*    */   private void BuscarMedicos() throws ClassNotFoundException, SQLException, IOException
/*    */   {
/* 53 */     Collection v = this.practica.getMedicos();
/*    */ 
/* 55 */     this.nombres = new Object[v.size()];
/*    */ 
/* 57 */     Iterator it = v.iterator();
/*    */ 
/* 59 */     int i = 0;
/* 60 */     while (it.hasNext()) {
/* 61 */       Medico me = (Medico)it.next();
/* 62 */       this.nombres[i] = me;
/* 63 */       i++;
/*    */     }
/*    */   }
/*    */ 
/*    */   private void buscarTodos() {
/* 68 */     Collection v = null;
/* 69 */     v = BuscadorMedicos.getInstance().findAll();
/* 70 */     this.nombres = new Object[v.size()];
/*    */ 
/* 72 */     Iterator it = v.iterator();
/*    */ 
/* 75 */     int i = 0;
/*    */ 
/* 77 */     while (it.hasNext()) {
/* 78 */       Medico me = (Medico)it.next();
/* 79 */       this.nombres[i] = me;
/* 80 */       i++;
/*    */     }
/*    */   }
/*    */ 
/*    */   public Medico getSelectedMe() {
/* 85 */     return (Medico)getItemAt(getSelectedIndex());
/*    */   }
/*    */ 
/*    */   public Long getSelectedMeId() {
/* 89 */     return ((Medico)getItemAt(getSelectedIndex())).getId();
/*    */   }
/*    */ 
/*    */   public int getIndexOf(Integer matricula) {
/* 93 */     for (int i = 1; i < getItemCount(); i++) {
/* 94 */       if (((Medico)this.nombres[i]).getMatricula().equals(matricula)) {
/* 95 */         return i;
/*    */       }
/*    */     }
/*    */ 
/* 99 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.CbMedicos
 * JD-Core Version:    0.6.0
 */