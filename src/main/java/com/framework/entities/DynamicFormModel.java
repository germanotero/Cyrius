/*    */ package com.framework.entities;
/*    */ 
/*    */ import com.framework.models.FormModel;
/*    */ import com.framework.utils.MapFactory;
/*    */ import com.framework.utils.StringUtils;
/*    */ import com.thoughtworks.xstream.XStream;
/*    */ import com.thoughtworks.xstream.io.xml.DomDriver;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class DynamicFormModel
/*    */   implements FormModel
/*    */ {
/* 13 */   private Map values = MapFactory.createMap();
/*    */   private DynamicFormDecorator decorator;
/*    */ 
/*    */   public DynamicFormModel()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DynamicFormModel(DynamicFormDecorator decorator)
/*    */   {
/* 23 */     this.decorator = decorator;
/* 24 */     String xml = decorator.getDatosXML();
/* 25 */     if (!StringUtils.isNullOrEmpty(xml)) {
/* 26 */       XStream xstream = new XStream(new DomDriver());
/* 27 */       this.values = ((Map)xstream.fromXML(xml));
/*    */     }
/*    */   }
/*    */ 
/*    */   public DynamicFormDecorator getDecorator() {
/* 32 */     return this.decorator;
/*    */   }
/*    */ 
/*    */   public void save() {
/* 36 */     XStream xstream = new XStream(new DomDriver());
/* 37 */     String xml = xstream.toXML(this.values);
/* 38 */     this.decorator.finishForm(xml);
/*    */   }
/*    */ 
/*    */   public FormModel getProperty(String key) {
/* 42 */     return (FormModel)this.values.get(key);
/*    */   }
/*    */ 
/*    */   public void setProperty(String aspect, Object value) {
/* 46 */     this.values.put(aspect, FormModelUtils.wrap(value));
/*    */   }
/*    */ 
/*    */   public Object getValue() {
/* 50 */     return this;
/*    */   }
/*    */ 
/*    */   public void refresh()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Class getDecoratedClass() {
/* 58 */     return getClass();
/*    */   }
/*    */ 
/*    */   public boolean isPersisted()
/*    */   {
/* 65 */     return this.decorator.isPersisted();
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.DynamicFormModel
 * JD-Core Version:    0.6.0
 */