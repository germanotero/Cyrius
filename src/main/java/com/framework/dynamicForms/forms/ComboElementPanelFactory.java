/*    */ package com.framework.dynamicForms.forms;
/*    */ 
/*    */ import com.framework.abstractfactorys.AbstractPanel;
/*    */ import com.framework.actions.DeleteRowAction;
/*    */ import com.framework.actions.RefreshAction;
/*    */ import com.framework.actions.SimpleAction;
/*    */ import com.framework.components.builders.impl.FormFieldBuilder;
/*    */ import com.framework.components.builders.impl.FormGridBuilder;
/*    */ import com.framework.components.builders.interfaces.FormActionBuilder;
/*    */ import com.framework.components.builders.interfaces.FormElementsBuilder;
/*    */ import com.framework.components.builders.interfaces.TableColumnBuilder;
/*    */ import com.framework.dynamicForms.entities.ComboElement;
/*    */ import com.framework.dynamicForms.entities.ComboItem;
/*    */ import com.framework.models.FormModel;
/*    */ 
/*    */ public class ComboElementPanelFactory extends AbstractPanel
/*    */ {
/*    */   public void registerElements(FormElementsBuilder builder)
/*    */   {
/* 17 */     builder.addStringField("name").required();
/* 18 */     builder.addStringField("description").required();
/* 19 */     FormGridBuilder grid = builder.addGrid("opciones");
/* 20 */     grid.addColumn("name").setEditable(true);
/* 21 */     grid.addRowAction(new DeleteRowAction("opciones"));
/*    */   }
/*    */ 
/*    */   public void registerActions(FormActionBuilder builder) {
/* 25 */     builder.addAction(new RefreshAction("agregar", new SimpleAction()
/*    */     {
/*    */       public void executeAction(FormModel model) {
/* 28 */         ComboElement element = (ComboElement)model.getValue();
/* 29 */         element.addOption(new ComboItem());
/*    */       }
/*    */     }));
/* 33 */     builder.addFinalizeUseCaseAction();
/* 34 */     builder.addCancelUseCaseAction();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.forms.ComboElementPanelFactory
 * JD-Core Version:    0.6.0
 */