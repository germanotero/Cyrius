/*     */ package com.cyrius.ui.components;
/*     */ 
/*     */ import java.util.GregorianCalendar;

import org.apache.commons.collections.Predicate;

import com.framework.components.FormComponent;
import com.framework.components.FormValueSelectionContainer;
import com.framework.components.listeners.ModelTargetListener;
import com.framework.components.listeners.NullModelTargetListener;
import com.framework.print.builder.PrintableElementsBuilder;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.JMonthView;
/*     */ 
/*     */ public class CyriusCalendar extends JMonthView
/*     */   implements FormValueSelectionContainer
/*     */ {
/*     */   private DateSelectionModel dateSelectionModel;
/*     */   private Predicate visibleCondition;
/*  35 */   private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();
/*     */ 
/*     */   public CyriusCalendar()
/*     */   {
/*     */   }
/*     */ 
/*     */   public CyriusCalendar(DateSelectionModel dateSelectionModel)
/*     */   {
/*  46 */     this.dateSelectionModel = dateSelectionModel;
/*     */   }
/*     */ 
/*     */   public Object getValor()
/*     */   {
/*  54 */     GregorianCalendar gregorianCalendar = new GregorianCalendar();
/*  55 */     gregorianCalendar.setTime(
/*  56 */       getDateSelectionModel().getLeadSelectionDate());
/*  57 */     return gregorianCalendar;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/*  64 */     this.modelTargetListener.load(null);
/*     */   }
/*     */ 
/*     */   public boolean hasVisibleCondition()
/*     */   {
/*  71 */     return this.visibleCondition != null;
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/*  78 */     this.visibleCondition = condition;
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */   public void initComponent()
/*     */   {
/*  86 */     getDateSelectionModel().setSelectionMode(
/*  87 */       DateSelectionModel.SelectionMode.SINGLE);
/*  88 */     // setDisplayToday(false); TODO
/*  89 */     setWeekNumbersVisible(false);
/*  90 */     setDateSelectionModel(this.dateSelectionModel);
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener)
/*     */   {
/*  97 */     this.modelTargetListener = listener;
/*     */   }
/*     */ 
/*     */   public void setValue(Object model)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 112 */     return getValor() == null;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/* 119 */     this.modelTargetListener.unLoad(null);
/*     */   }
/*     */ 
/*     */   public boolean isColumnComponent()
/*     */   {
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print)
/*     */   {
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition)
/*     */   {
/* 135 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ 
/*     */   public void setFull()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setNotFull()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.CyriusCalendar
 * JD-Core Version:    0.6.0
 */