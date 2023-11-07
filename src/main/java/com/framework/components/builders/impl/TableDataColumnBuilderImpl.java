/*     */ package com.framework.components.builders.impl;
/*     */ 
/*     */ import com.framework.components.FormGrid;
/*     */ import com.framework.components.builders.interfaces.TableDataColumnBuilder;
/*     */ import com.framework.models.FormGridDataColumn;
/*     */ import com.framework.models.FormGridDateDataColumn;
/*     */ import com.framework.models.FormGridModel;
/*     */ import com.framework.utils.StringProvider;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ public class TableDataColumnBuilderImpl
/*     */   implements TableDataColumnBuilder, TableColumnBuilderImpl
/*     */ {
/*     */   private String propertyName;
/*     */   private boolean editable;
/*  21 */   private int preferedSize = 0;
/*     */   private Transformer transformer;
/*     */   private Class columnClass;
/*     */   private String datePattern;
/*     */ 
/*     */   public TableDataColumnBuilderImpl(String propertyName2)
/*     */   {
/*  31 */     this.propertyName = propertyName2;
/*     */   }
/*     */ 
/*     */   public void setTransformer(Transformer transformer) {
/*  35 */     this.transformer = transformer;
/*     */   }
/*     */ 
/*     */   public String getPropertyName()
/*     */   {
/*  42 */     return this.propertyName;
/*     */   }
/*     */ 
/*     */   public void setEditable(boolean editable)
/*     */   {
/*  50 */     this.editable = editable;
/*     */   }
/*     */ 
/*     */   public boolean isEditable()
/*     */   {
/*  57 */     return this.editable;
/*     */   }
/*     */ 
/*     */   public void setPreferedSize(int prefered) {
/*  61 */     this.preferedSize = prefered;
/*     */   }
/*     */ 
/*     */   public void setColumnClass(Class columnClass) {
/*  65 */     this.columnClass = columnClass;
/*     */   }
/*     */ 
/*     */   public int getPreferedSize()
/*     */   {
/*  72 */     return this.preferedSize;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  79 */     return StringProvider.getInstance().getValueOf(this.propertyName);
/*     */   }
/*     */ 
/*     */   public void build(FormGridModel grid)
/*     */   {
/*     */     FormGridDataColumn column;
/*  84 */     if (this.datePattern == null)
/*  85 */       column = new FormGridDataColumn(this.propertyName, this.transformer, 
/*  86 */         this.editable, this.columnClass);
/*     */     else
/*  88 */       column = new FormGridDateDataColumn(this.propertyName, this.transformer, 
/*  89 */         this.editable, this.columnClass, this.datePattern);
/*  90 */     column.setIdentifier(this.propertyName);
/*  91 */     grid.addColumn(column);
/*     */   }
/*     */ 
/*     */   public void initColumns(FormGrid column)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setDatePattern(String pattern)
/*     */   {
/* 100 */     this.datePattern = pattern;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.TableDataColumnBuilderImpl
 * JD-Core Version:    0.6.0
 */