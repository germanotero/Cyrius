/*    */ package com.framework.components;
/*    */ 
/*    */ import com.framework.exceptions.NotFullFormException;
/*    */ import com.framework.models.Medida;
/*    */ import com.framework.models.TipoMedida;
/*    */ import com.framework.print.builder.PrintableElementsBuilder;
/*    */ import com.framework.utils.CollectionFactory;
/*    */ import java.text.NumberFormat;
/*    */ import java.util.Collection;
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ public class MedidaBox extends PanelContainedFormInput
/*    */ {
/* 19 */   private DefaultComboBox tiposMedidas = new DefaultComboBox();
/*    */ 
/*    */   public MedidaBox(String name)
/*    */   {
/* 25 */     super(NumberFormat.getNumberInstance(), name);
/* 26 */     this.tiposMedidas.withOutNullElement();
/*    */   }
/*    */ 
/*    */   public void setValue(Object text)
/*    */   {
/* 33 */     if (text != null) {
/* 34 */       Medida medida = (Medida)text;
/* 35 */       super.setValue(medida.getValor());
/* 36 */       this.tiposMedidas.setSelectedItem(medida.getTipoMedida());
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void initSubComponent()
/*    */   {
/* 44 */     Collection col = CollectionFactory.createCollection();
/* 45 */     TipoMedida mm = TipoMedida.getMM();
/* 46 */     col.add(TipoMedida.getMM());
/* 47 */     col.add(TipoMedida.getCM());
/* 48 */     col.add(TipoMedida.getCM3());
/* 49 */     col.add(TipoMedida.getMM3());
/* 50 */     this.tiposMedidas.setValues(col);
/* 51 */     add(this.tiposMedidas, "East");
/* 52 */     this.tiposMedidas.setSelectedItem(mm);
/*    */   }
/*    */ 
/*    */   protected Object transformResult(Object textToTransform)
/*    */   {
/* 59 */     Object selectedItem = this.tiposMedidas.getSelectedItem();
/* 60 */     if (selectedItem == null)
/* 61 */       throw new NotFullFormException(getName());
/* 62 */     return new Medida(""+textToTransform, (TipoMedida)selectedItem);
/*    */   }
/*    */ 
/*    */   public void direct(PrintableElementsBuilder print) {
/* 66 */     print.addInputValue(getName(), getValor());
/*    */   }
/*    */ 
/*    */   public void withLabel(JComponent label)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.MedidaBox
 * JD-Core Version:    0.6.0
 */