/*     */ package com.cyrius.turnos.gui.practicas;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.searchers.BuscadorMedicos;
/*     */ import com.cyrius.utils.JTableUtils;
/*     */ import com.framework.components.FormComponent;
/*     */ import com.framework.components.FormScrollPanel;
/*     */ import com.framework.components.listeners.ModelTargetListener;
/*     */ import com.framework.print.builder.PrintableElementsBuilder;
/*     */ import com.framework.utils.StringProvider;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ public class ScrollPanelTablaMedicos extends FormScrollPanel
/*     */ {
/*     */   private JTable tablaMedicos;
/*     */   private ModelTargetListener modelTargetListener;
/*     */ 
/*     */   public ScrollPanelTablaMedicos()
/*     */   {
/*  39 */     initComponents();
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public ScrollPanelTablaMedicos(Collection medicos)
/*     */   {
/*  48 */     initComponents();
/*  49 */     makeDataModel(medicos);
/*     */   }
/*     */ 
/*     */   public void setMedicos(Collection medicos) {
/*  53 */     clear();
/*  54 */     makeDataModel(medicos);
/*     */   }
/*     */ 
/*     */   private Object[][] getSimplyDataModel() {
/*  58 */     Collection medicos = BuscadorMedicos.getInstance().findAll();
/*  59 */     Object[][] data = new Object[medicos.size()][2];
/*  60 */     int i = 0;
/*  61 */     for (Iterator itMe = medicos.iterator(); itMe.hasNext(); ) {
/*  62 */       Medico medico = (Medico)itMe.next();
/*  63 */       data[i][0] = medico;
/*  64 */       data[(i++)][1] = Boolean.FALSE;
/*     */     }
/*  66 */     return data;
/*     */   }
/*     */ 
/*     */   private void makeDataModel(Collection medicos) {
/*  70 */     for (Iterator ite = medicos.iterator(); ite.hasNext(); ) {
/*  71 */       Medico medico = (Medico)ite.next();
/*  72 */       this.tablaMedicos.setValueAt(Boolean.TRUE, JTableUtils.getRowOf(
/*  73 */         this.tablaMedicos, medico), 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  79 */     this.tablaMedicos = new JTable();
/*  80 */     setBorder(
/*  83 */       new TitledBorder(null, "", 
/*  81 */       0, 
/*  82 */       0, new Font("Dialog", 0, 11), 
/*  83 */       new Color(255, 255, 255)));
/*  84 */     setForeground(new Color(0, 51, 204));
/*  85 */     this.tablaMedicos.setBackground(new Color(204, 204, 255));
/*  86 */     this.tablaMedicos.setModel(
/*  89 */       new DefaultTableModel(getSimplyDataModel(), 
/*  87 */       new String[] { 
/*  88 */       StringProvider.getInstance().getValueOf("medico"), 
/*  89 */       StringProvider.getInstance().getValueOf("realiza") }) {
/*  90 */       Class[] types = { String.class, Boolean.class };
/*     */ 
/*  92 */       boolean[] canEdit = { false, true };
/*     */ 
/*     */       public Class getColumnClass(int columnIndex) {
/*  95 */         return this.types[columnIndex];
/*     */       }
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  99 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 102 */     this.tablaMedicos.getColumnModel().getColumn(1).setMaxWidth(80);
/* 103 */     this.tablaMedicos.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 104 */     this.tablaMedicos.getColumnModel().getColumn(1).setMinWidth(40);
/* 105 */     setViewportView(this.tablaMedicos);
/*     */   }
/*     */ 
/*     */   public Vector getMedicos()
/*     */   {
/* 110 */     Vector medicoAtiende = new Vector(0);
/*     */ 
/* 112 */     for (int i = 0; i < this.tablaMedicos.getRowCount(); i++) {
/* 113 */       if (((Boolean)this.tablaMedicos.getValueAt(i, 1)).booleanValue()) {
/* 114 */         medicoAtiende.addElement(this.tablaMedicos.getValueAt(i, 0));
/*     */       }
/*     */     }
/* 117 */     return medicoAtiende;
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public void clear()
/*     */   {
/* 126 */     for (int i = 0; i < this.tablaMedicos.getRowCount(); i++)
/* 127 */       this.tablaMedicos.setValueAt(new Boolean(false), i, 1);
/*     */   }
/*     */ 
/*     */   public void unselectAll()
/*     */   {
/* 132 */     this.tablaMedicos.editCellAt(-1, -1);
/*     */   }
/*     */ 
/*     */   public boolean hayMedicos()
/*     */   {
/*     */     try
/*     */     {
/* 140 */       for (int i = 0; i < this.tablaMedicos.getRowCount(); i++) {
/* 141 */         if (((Boolean)this.tablaMedicos.getValueAt(i, 1)).booleanValue())
/* 142 */           return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   public JTable getTablaMedicos() {
/* 152 */     return this.tablaMedicos;
/*     */   }
/*     */ 
/*     */   public void setTablaMedicos(JTable tablaMedicos) {
/* 156 */     this.tablaMedicos = tablaMedicos;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 160 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition)
/*     */   {
/* 165 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.practicas.ScrollPanelTablaMedicos
 * JD-Core Version:    0.6.0
 */