/*    */ package com.framework.dynamicForms.entities;
/*    */ 
/*    */ import com.framework.components.builders.impl.DynamicFormComboBoxBuilderImpl;
/*    */ import com.framework.components.builders.interfaces.FormComponentBuilder;
/*    */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class ComboElement extends SimpleDynamicFormElement
/*    */ {
/* 16 */   private static String COMBO_KEY = "Combo";
/*    */ 
/* 19 */   private Collection opciones = CollectionFactory.createCollection();
/*    */ 
/*    */   public Collection getOpciones() {
/* 22 */     return this.opciones;
/*    */   }
/*    */ 
/*    */   public void setOpciones(Collection options) {
/* 26 */     this.opciones = options;
/*    */   }
/*    */ 
/*    */   public void addOption(ComboItem option) {
/* 30 */     this.opciones.add(option);
/*    */   }
/*    */ 
/*    */   public void removeOption(ComboItem optionToRemove) {
/* 34 */     this.opciones.remove(optionToRemove);
/*    */   }
/*    */ 
/*    */   public TipoFormElement getTipoDynamicFormElement()
/*    */   {
/* 39 */     return TipoFormElementSearcher.getComboElement();
/*    */   }
/*    */ 
/*    */   public String getElementID()
/*    */   {
/* 44 */     return COMBO_KEY + getId().toString();
/*    */   }
/*    */ 
/*    */   public FormComponentBuilder getBuilder()
/*    */   {
/* 49 */     DynamicFormComboBoxBuilderImpl builder = (DynamicFormComboBoxBuilderImpl)super
/* 50 */       .getBuilder();
/* 51 */     builder.withElements(this.opciones);
/* 52 */     builder.withModelProperty(COMBO_KEY + getId().toString());
/* 53 */     return builder;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.ComboElement
 * JD-Core Version:    0.6.0
 */