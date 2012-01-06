/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import com.cyrius.entities.Practica;
/*     */ import com.cyrius.searchers.BuscadorPracticas;
/*     */ import com.framework.components.JAutoComboBox;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ 
/*     */ public class CbPracticas extends JAutoComboBox
/*     */ {
/*     */   private Integer medicoId;
/*     */ 
/*     */   public CbPracticas()
/*     */   {
/*  32 */     setModel(new DefaultComboBoxModel(getPracticas()));
/*     */   }
/*     */ 
/*     */   public CbPracticas(Integer medicoId)
/*     */   {
/*  37 */     this.medicoId = medicoId;
/*  38 */     setModel(new DefaultComboBoxModel(getPracticas()));
/*     */   }
/*     */ 
/*     */   private CbPracticas(Vector arg0)
/*     */   {
/*  45 */     super(arg0.toArray());
/*     */   }
/*     */ 
/*     */   public void refresh() throws ClassNotFoundException, SQLException, IOException
/*     */   {
/*  50 */     setModel(new DefaultComboBoxModel(getPracticas()));
/*     */   }
/*     */ 
/*     */   private void initCombo() {
/*  54 */     setEditable(true);
/*     */   }
/*     */ 
/*     */   private Object[] getPracticas() {
/*  58 */     Collection v = null;
/*     */     try
/*     */     {
/*  61 */       if (this.medicoId == null)
/*  62 */         v = BuscadorPracticas.findAll();
/*     */       else
/*  64 */         v = BuscadorPracticas.findByMedico(this.medicoId.intValue());
/*     */     }
/*     */     catch (Exception e) {
/*  67 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  70 */     Object[] practicas = new Object[v.size()];
/*  71 */     Iterator it = v.iterator();
/*  72 */     int i = 0;
/*     */ 
/*  74 */     while (it.hasNext()) {
/*  75 */       Practica p = (Practica)it.next();
/*  76 */       practicas[(i++)] = p;
/*     */     }
/*     */ 
/*  79 */     return practicas;
/*     */   }
/*     */ 
/*     */   public Practica getSelectedPra() {
/*  83 */     return (Practica)getItemAt(getSelectedIndex());
/*     */   }
/*     */ 
/*     */   public Long getSelectedPracId() {
/*  87 */     return ((Practica)getItemAt(getSelectedIndex())).getId();
/*     */   }
/*     */ 
/*     */   public void setSelectedPractica(Practica p) {
/*  91 */     boolean encontrado = false;
/*  92 */     int i = 0;
/*     */ 
/*  94 */     while ((i < getItemCount()) && (!encontrado)) {
/*  95 */       if (((Practica)getItemAt(i)).getId().intValue() == 
/*  96 */         p.getId().intValue())
/*  97 */         encontrado = true;
/*     */       else {
/*  99 */         i++;
/*     */       }
/*     */     }
/*     */ 
/* 103 */     if (encontrado)
/* 104 */       setSelectedIndex(i);
/*     */   }
/*     */ 
/*     */   public void setSelectedPractica(Integer id)
/*     */   {
/* 109 */     boolean encontrado = false;
/* 110 */     int i = 0;
/*     */ 
/* 112 */     while ((i < getItemCount()) && (!encontrado)) {
/* 113 */       if (((Practica)getItemAt(i)).getId().intValue() == 
/* 114 */         id.intValue())
/* 115 */         encontrado = true;
/*     */       else {
/* 117 */         i++;
/*     */       }
/*     */     }
/*     */ 
/* 121 */     if (encontrado)
/* 122 */       setSelectedIndex(i);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.CbPracticas
 * JD-Core Version:    0.6.0
 */