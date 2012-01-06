/*    */ package com.framework.dynamicForms.entities;
/*    */ 
/*    */ import com.framework.abstractfactorys.TipoFormInput;
/*    */ import com.framework.components.builders.impl.FormInputBuilder;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.WellKnownInstance;
/*    */ import com.framework.utils.ClassUtils;
/*    */ 
/*    */ public class TipoFormElement
/*    */   implements WellKnownInstance
/*    */ {
/*    */   private String name;
/*    */   private String description;
/*    */   private Class formComponentBuilderClass;
/*    */   private transient TipoFormInput tipoFormInput;
/*    */ 
/*    */   public TipoFormElement()
/*    */   {
/*    */   }
/*    */ 
/*    */   public TipoFormElement(String description, String name)
/*    */   {
/* 27 */     this.description = description;
/* 28 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 32 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 36 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 40 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 44 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder getElementBuilder()
/*    */   {
/* 52 */     FormComponentBuilder builder = (FormComponentBuilder)
/* 53 */       ClassUtils.newInstance(this.formComponentBuilderClass);
/*    */ 
/* 55 */     if (this.tipoFormInput != null) {
/* 56 */       ((FormInputBuilder)builder).withTipo(this.tipoFormInput);
/*    */     }
/* 58 */     return builder;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 63 */     return this.description;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 68 */     if (!(obj instanceof TipoFormElement))
/* 69 */       return false;
/* 70 */     TipoFormElement tipo = (TipoFormElement)obj;
/* 71 */     return getName().equals(tipo.getName());
/*    */   }
/*    */ 
/*    */   public Class getFormComponentBuilderClass() {
/* 75 */     return this.formComponentBuilderClass;
/*    */   }
/*    */ 
/*    */   public void setFormComponentBuilderClass(Class formComponentBuilderClass) {
/* 79 */     this.formComponentBuilderClass = formComponentBuilderClass;
/*    */   }
/*    */ 
/*    */   public void setTipoFormInput(TipoFormInput tipoFormInput) {
/* 83 */     this.tipoFormInput = tipoFormInput;
/*    */   }
/*    */ 
/*    */   public TipoFormInput getTipoFormInput() {
/* 87 */     return this.tipoFormInput;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.TipoFormElement
 * JD-Core Version:    0.6.0
 */