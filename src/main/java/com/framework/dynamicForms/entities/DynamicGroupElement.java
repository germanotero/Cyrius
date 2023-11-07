/*     */ package com.framework.dynamicForms.entities;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractMultiplicableGroup;
/*     */ import com.framework.components.builders.impl.GroupBuilderImpl;
/*     */ import com.framework.components.builders.impl.MultiplicableGroupElementBuilderImpl;
/*     */ import com.framework.components.builders.impl.MultliplicableGroupBuilderImpl;
/*     */ import com.framework.components.builders.interfaces.GroupBuilder;
/*     */ import com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher;
/*     */ import com.framework.entities.DynamicFormModel;
/*     */ import com.framework.utils.ExtraCollectionUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ public class DynamicGroupElement extends DynamicForm
/*     */ {
/*  24 */   private Boolean multiplicable = Boolean.FALSE;
/*     */ 
/*  26 */   private String emptyText = "";
/*     */ 
/*     */   public String getEmptyText()
/*     */   {
/*  33 */     return this.emptyText;
/*     */   }

@Override
	public String toString() {
		return this.getName() + " " + this.getDescription();
	}
/*     */ 
/*     */   public void setEmptyText(String emptyText) {
/*  37 */     this.emptyText = emptyText;
/*     */   }
/*     */ 
/*     */   public TipoFormElement getTipoDynamicFormElement()
/*     */   {
/*  42 */     return TipoFormElementSearcher.getGrupo();
/*     */   }
/*     */ 
/*     */   public Boolean getMultiplicable() {
/*  46 */     return this.multiplicable;
/*     */   }
/*     */ 
/*     */   public void setMultiplicable(Boolean multiplicable) {
/*  50 */     this.multiplicable = multiplicable;
/*     */   }
/*     */ 
/*     */   public GroupBuilder getBuilder()
/*     */   {
/*  57 */     GroupBuilderImpl builder = new GroupBuilderImpl();
/*  58 */     if (this.multiplicable.booleanValue()) {
/*  59 */       builder
/*  60 */         .setInnerGroup(new DynamicMultiplicableGroup(this.emptyText));
/*     */     } else {
/*  62 */       Collection collect = getAllBuilders();
/*  63 */       builder.addBuilders(collect);
/*     */     }
/*  65 */     builder.setColumnsCount(getCantidadColumnas().intValue());
/*  66 */     builder.withModelProperty(getElementID());
/*  67 */     builder.withModelClass(DynamicFormModel.class);
/*  68 */     builder.withName(getName());
/*  69 */     return builder;
/*     */   }
/*     */ 
/*     */   private Collection getAllBuilders() {
/*  73 */     Collection groups = ExtraCollectionUtils.transformedCollection(
/*  74 */       getGroupElements(), new RelacionToGroupTransformer());
/*  75 */     Collection builders = ExtraCollectionUtils.union(getSimpleElements(), 
/*  76 */       groups);
/*  77 */     Collection collect = CollectionUtils.collect(builders, 
/*  78 */       new DynamicFormElementToElementBuilderTransformer());
/*  79 */     return collect;
/*     */   }
/*     */ 
/*     */   public String getElementID()
/*     */   {
/*  84 */     return "Group" + getId().toString();
/*     */   }
/*     */   private class DynamicFormElementToElementBuilderTransformer implements Transformer {
/*     */     private DynamicFormElementToElementBuilderTransformer() {
/*     */     }
/*     */     public Object transform(Object arg0) {
/*  90 */       DynamicFormElement element = (DynamicFormElement)arg0;
/*  91 */       return element.getBuilder();
/*     */     }
/*     */   }
/*     */ 
/*     */   public class DynamicMultiplicableGroup extends AbstractMultiplicableGroup
/*     */   {
/*     */     public DynamicMultiplicableGroup(String emptyText) {
/*  98 */       setEmptyText(emptyText);
/*     */     }
/*     */ 
/*     */     protected Class getGroupToBeMultiplicated()
/*     */     {
/* 103 */       throw new RuntimeException("Under Construction:" + getClass());
/*     */     }
/*     */ 
/*     */     protected MultliplicableGroupBuilderImpl addTabDefaultStrategy(MultiplicableGroupElementBuilderImpl builder, int index)
/*     */     {
/* 108 */       return (MultliplicableGroupBuilderImpl)builder.addGroup(
/* 109 */         DynamicGroupElement.this.getAllBuilders(), index);
/*     */     }
/*     */ 
/*     */     protected Class getAsociatedModel()
/*     */     {
/* 114 */       return ArrayList.class;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.DynamicGroupElement
 * JD-Core Version:    0.6.0
 */