/*     */ package com.framework.dynamicForms.entities;
/*     */ 
/*     */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*     */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ 
/*     */ public class SimpleDynamicFormElement
/*     */   implements DynamicFormElement, PersistibleObject
/*     */ {
/*     */   private Long id;
/*     */   private String name;
/*     */   private String description;
/*     */   private String tipoFormElementName;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  28 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  32 */     this.id = id;
/*     */   }
/*     */ 
/*     */   protected String getTipoFormElementName() {
/*  36 */     return this.tipoFormElementName;
/*     */   }
/*     */ 
/*     */   protected void setTipoFormElementName(String tipoFormElementName) {
/*  40 */     this.tipoFormElementName = tipoFormElementName;
/*     */   }
/*     */ 
/*     */   public TipoFormElement getTipoDynamicFormElement() {
/*  44 */     if (this.tipoFormElementName == null) {
/*  45 */       return null;
/*     */     }
/*  47 */     return TipoFormElementSearcher.getInstance()
/*  48 */       .findByName(this.tipoFormElementName);
/*     */   }
/*     */ 
/*     */   public void setTipoDynamicFormElement(TipoFormElement element) {
/*  52 */     this.tipoFormElementName = element.getName();
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  56 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  60 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  64 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  68 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public FormComponentBuilder getBuilder()
/*     */   {
/*  75 */     FormComponentBuilder builder = 
/*  76 */       getTipoDynamicFormElement().getElementBuilder();
/*  77 */     builder.withName(getName());
/*  78 */     builder.withModelProperty(getElementID());
/*  79 */     builder.required();
/*  80 */     return builder;
/*     */   }
/*     */ 
/*     */   public String getElementID() {
/*  84 */     return "Element" + getId().toString();
/*     */   }
/*     */ 
/*     */   public boolean equals(Object arg0)
/*     */   {
/*  89 */     if (!(arg0 instanceof SimpleDynamicFormElement))
/*  90 */       return false;
/*  91 */     SimpleDynamicFormElement that = (SimpleDynamicFormElement)arg0;
/*  92 */     if ((that.getId() == null) && (getId() == null))
/*  93 */       return false;
/*  94 */     return that.getId().equals(getId());
/*     */   }
/*     */ 
/*     */   public int compareTo(Object o) {
/*  98 */     if ((o instanceof SimpleDynamicFormElement)) {
/*  99 */       SimpleDynamicFormElement that = (SimpleDynamicFormElement)o;
/* 100 */       return this.id.compareTo(that.id);
/*     */     }
/* 102 */     return 0;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.SimpleDynamicFormElement
 * JD-Core Version:    0.6.0
 */