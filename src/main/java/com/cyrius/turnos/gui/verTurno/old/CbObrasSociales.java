/*     */ package com.cyrius.turnos.gui.verTurno.old;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.entities.ObraSocial;
/*     */ import com.cyrius.searchers.BuscadorObraSocial;
/*     */ import com.framework.components.JAutoComboBox;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ 
/*     */ public class CbObrasSociales extends JAutoComboBox
/*     */ {
/*     */   private static String[] nombres;
/*  30 */   private static short TODAS = 1;
/*     */ 
/*  32 */   private static short MEDICO = 0;
/*     */   private Medico medico;
/*     */   private short estado;
/*  38 */   private Collection v = null;
/*     */ 
/*     */   public void refresh()
/*     */     throws ClassNotFoundException, SQLException, IOException
/*     */   {
/*  46 */     if (this.medico != null) {
/*  47 */       buscarObras();
/*  48 */       setModel(new DefaultComboBoxModel(nombres));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setObras(Medico medico) throws ClassNotFoundException, SQLException, IOException
/*     */   {
/*  54 */     this.medico = medico;
/*  55 */     this.estado = MEDICO;
/*  56 */     buscarObras();
/*  57 */     setModel(new DefaultComboBoxModel(nombres));
/*  58 */     setSelectedIndex(-1);
/*     */   }
/*     */ 
/*     */   public void setAll() {
/*  62 */     this.estado = TODAS;
/*  63 */     buscarObras();
/*  64 */     setModel(new DefaultComboBoxModel(nombres));
/*  65 */     setSelectedIndex(-1);
/*     */   }
/*     */ 
/*     */   private void buscarObras() {
/*     */     try {
/*  70 */       if (this.estado == MEDICO)
/*  71 */         this.v = this.medico.getObrasSociales();
/*     */       else
/*  73 */         this.v = BuscadorObraSocial.findAll();
/*     */     }
/*     */     catch (Exception e) {
/*  76 */       System.err.println("Ocurrio un Error al buscar las practicas ");
/*     */     }
/*     */ 
/*  79 */     nombres = new String[this.v.size()];
/*     */ 
/*  81 */     Iterator it = this.v.iterator();
/*  82 */     int i = 0;
/*     */ 
/*  84 */     while (it.hasNext()) {
/*  85 */       ObraSocial os = (ObraSocial)it.next();
/*  86 */       nombres[i] = os.toString();
/*  87 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ObraSocial getSelectedOS() {
/*  92 */     return (ObraSocial)this.v.toArray()[getSelectedIndex()];
/*     */   }
/*     */ 
/*     */   public Long getSelectedOsId() {
/*  96 */     return ((ObraSocial)this.v.toArray()[getSelectedIndex()]).getId();
/*     */   }
/*     */ 
/*     */   public void setSelectedObraId(Long cod) throws ClassNotFoundException, SQLException, IOException
/*     */   {
/* 101 */     ObraSocial obra = BuscadorObraSocial.findById(cod);
/* 102 */     Iterator it = this.v.iterator();
/* 103 */     int i = 0;
/* 104 */     boolean encontrado = false;
/*     */ 
/* 106 */     while ((it.hasNext()) && (!encontrado)) {
/* 107 */       ObraSocial o2 = (ObraSocial)it.next();
/*     */ 
/* 109 */       if (o2.getId().equals(obra.getId())) {
/* 110 */         setSelectedIndex(i);
/* 111 */         encontrado = true;
/*     */       }
/*     */ 
/* 114 */       i++;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.CbObrasSociales
 * JD-Core Version:    0.6.0
 */