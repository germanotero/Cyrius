/*     */ package com.framework.dynamicForms.entities;
/*     */ 
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public class DynamicForm
/*     */   implements DynamicFormElement
/*     */ {
/*     */   private Long id;
/*  17 */   private Integer cantidadColumnas = new Integer(2);
/*     */ 
/*  19 */   private Collection simpleElements = CollectionFactory.createCollection();
/*     */ 
/*  21 */   private Collection groupElements = CollectionFactory.createCollection();
/*     */   private String name;
/*     */   private String description;
/*     */ 
/*     */   public Collection getGroupElements()
/*     */   {
/*  28 */     return this.groupElements;
/*     */   }
/*     */ 
/*     */   public void setGroupElements(Collection groupElements) {
/*  32 */     this.groupElements = groupElements;
/*     */   }
/*     */ 
/*     */   public Collection getSimpleElements() {
/*  36 */     return this.simpleElements;
/*     */   }
/*     */ 
/*     */   public void setSimpleElements(Collection simpleElements) {
/*  40 */     this.simpleElements = simpleElements;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  44 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  48 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getCantidadColumnas() {
/*  52 */     return this.cantidadColumnas;
/*     */   }
/*     */ 
/*     */   public void setCantidadColumnas(Integer cantidadColumnas) {
/*  56 */     if (cantidadColumnas != null)
/*  57 */       this.cantidadColumnas = cantidadColumnas;
/*     */   }
/*     */ 
/*     */   public void addElements(Collection elements) {
/*  61 */     this.simpleElements.addAll(elements);
/*     */   }
/*     */ 
/*     */   public void addGroupElements(Collection elements) {
/*  65 */     this.groupElements.addAll(CollectionUtils.transformedCollection(
/*  66 */       elements, new RelacionToGroupTransformer().backWard()));
/*     */   }
/*     */ 
/*     */   public TipoFormElement getTipoDynamicFormElement() {
/*  70 */     return TipoFormElementSearcher.getForm();
/*     */   }
/*     */ 
/*     */   public void setTipoDynamicFormElement(TipoFormElement nulla)
/*     */   {
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder getBuilder()
/*     */   {
/*  80 */     throw new RuntimeException(
/*  81 */       "No se deberia pedir un builder a un dynamic form");
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  85 */     return this.name;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  89 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  93 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  97 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 102 */     if (!(obj instanceof DynamicForm))
/* 103 */       return false;
/* 104 */     DynamicForm that = (DynamicForm)obj;
/* 105 */     if (getId() == null)
/* 106 */       return super.equals(that);
/* 107 */     return getId().equals(that.getId());
/*     */   }
/*     */ 
/*     */   public String getElementID()
/*     */   {
/* 112 */     throw new RuntimeException(
/* 113 */       "No se deberia pedir un builder a un dynamic form");
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 118 */     return getName() + " - " + 
/* 119 */       getDescription();
/*     */   }
/*     */ 
/*     */   public int compareTo(Object o) {
/* 123 */     if ((o instanceof DynamicForm)) {
/* 124 */       DynamicForm that = (DynamicForm)o;
/* 125 */       return this.id.compareTo(that.id);
/*     */     }
/* 127 */     return 0;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.DynamicForm
 * JD-Core Version:    0.6.0
 */