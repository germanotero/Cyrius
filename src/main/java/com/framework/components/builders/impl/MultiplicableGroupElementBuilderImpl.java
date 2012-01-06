/*    */ package com.framework.components.builders.impl;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.components.RowComponent;
/*    */ import com.framework.components.builders.interfaces.GroupBuilder;
/*    */ import com.framework.components.builders.interfaces.MultiplicableGroupElementBuilder;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class MultiplicableGroupElementBuilderImpl extends FormElementsBuilderImpl
/*    */   implements MultiplicableGroupElementBuilder
/*    */ {
/*    */   public MultiplicableGroupElementBuilderImpl(AbstractPanel container)
/*    */   {
/* 20 */     super(container);
/*    */   }
/*    */ 
/*    */   public final GroupBuilder addGroup(Class group, int modelPosition) {
/* 24 */     MultliplicableGroupBuilderImpl builder = new MultliplicableGroupBuilderImpl(
/* 25 */       group, getContainer(), modelPosition);
/* 26 */     builder.initBuilder();
/* 27 */     getElements().add(builder);
/* 28 */     return builder;
/*    */   }
/*    */ 
/*    */   public final GroupBuilder addGroup(Collection builders, int modelIndex) {
/* 32 */     MultliplicableGroupBuilderImpl builder = new MultliplicableGroupBuilderImpl();
/* 33 */     builder.withContainer(getContainer());
/* 34 */     builder.withListModelIndex(modelIndex);
/* 35 */     builder.addBuilders(builders);
/* 36 */     addBuilder(builder);
/* 37 */     return builder;
/*    */   }
/*    */ 
/*    */   public final RowComponent addRowComponent(RowComponent rowComponent) {
/* 41 */     getElements().add(new DefaultFormComponentBuilder(rowComponent));
/* 42 */     return rowComponent;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.MultiplicableGroupElementBuilderImpl
 * JD-Core Version:    0.6.0
 */