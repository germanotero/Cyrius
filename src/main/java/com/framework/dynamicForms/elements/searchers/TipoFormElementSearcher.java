/*     */ package com.framework.dynamicForms.elements.searchers;
/*     */ 
/*     */ import com.framework.abstractfactorys.TipoCalendarFormInput;
/*     */ import com.framework.abstractfactorys.TipoFloatNumberFormInput;
/*     */ import com.framework.abstractfactorys.TipoFormInput;
/*     */ import com.framework.abstractfactorys.TipoMedidaFormInput;
/*     */ import com.framework.abstractfactorys.TipoStringFormInput;
/*     */ import com.framework.abstractfactorys.TipoTextAreaFormInput;
/*     */ import com.framework.components.builders.impl.DynamicFormComboBoxBuilderImpl;
/*     */ import com.framework.components.builders.impl.FormInputBuilder;
/*     */ import com.framework.components.builders.impl.GroupBuilderImpl;
/*     */ import com.framework.dynamicForms.entities.TipoFormElement;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.collections.Predicate;
/*     */ 
/*     */ public class TipoFormElementSearcher extends WellKnownInstancesSearcher<TipoFormElement>
/*     */ {
/*     */   private static TipoFormElementSearcher instance;
/*     */ 
/*     */   public static synchronized TipoFormElementSearcher getInstance()
/*     */   {
/*  29 */     if (instance == null)
/*  30 */       instance = new TipoFormElementSearcher();
/*  31 */     return instance;
/*     */   }
/*     */ 
/*     */   public Collection<TipoFormElement> createWellKnownInstances()
/*     */   {
/*  40 */     Collection instances = CollectionFactory.createCollection(TipoFormElement.class);
/*  41 */     instances.add(new TipoFormElement("Grupo de elementos", "Grupo"));
/*  42 */     instances.add(new TipoFormElement("Formulario de elementos", "Form"));
/*  43 */     instances.add(new TipoFormElement("Combo de Opciones", "ComboElement"));
/*  44 */     instances.add(new TipoFormElement("Campo de texto", "TextField"));
/*  45 */     instances.add(new TipoFormElement("Campo de numeros", "NumberField"));
/*  46 */     instances.add(new TipoFormElement("Fecha dd/mm/yyyy", "CalendarField"));
/*  47 */     instances.add(new TipoFormElement("Area de texto", "TextArea"));
/*  48 */     instances.add(new TipoFormElement("Campo de medida", "MedidaElement"));
/*  49 */     return instances;
/*     */   }
/*     */ 
/*     */   public TipoFormElement findByName(String name)
/*     */   {
/*  55 */     if ("Grupo".equals(name))
/*  56 */       return getGrupo();
/*  57 */     if ("Form".equals(name))
/*  58 */       return getForm();
/*  59 */     if ("ComboElement".equals(name))
/*  60 */       return getComboElement();
/*  61 */     if ("TextField".equals(name))
/*  62 */       return getTextField();
/*  63 */     if ("NumberField".equals(name))
/*  64 */       return getNumberField();
/*  65 */     if ("TextArea".equals(name))
/*  66 */       return getTextArea();
/*  67 */     if ("MedidaElement".equals(name))
/*  68 */       return getMedidaElement();
/*  69 */     if ("CalendarField".equals(name))
/*  70 */       return getCalendarField();
/*  71 */     throw new UnsupportedOperationException("No se encontro el tipo de elemento para el nombre: " + name);
/*     */   }
/*     */ 
/*     */   private static TipoFormElement getFormInputByName(String name, TipoFormInput tipoFormInput)
/*     */   {
/*  76 */     TipoFormElement formElement = (TipoFormElement)getInstance().findByName2(name);
/*  77 */     formElement.setFormComponentBuilderClass(FormInputBuilder.class);
/*  78 */     formElement.setTipoFormInput(tipoFormInput);
/*  79 */     return formElement;
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getGrupo()
/*     */   {
/*  86 */     TipoFormElement tipoFormElement = (TipoFormElement)getInstance().findByName2("Grupo");
/*  87 */     tipoFormElement.setFormComponentBuilderClass(GroupBuilderImpl.class);
/*  88 */     return tipoFormElement;
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getForm()
/*     */   {
/*  95 */     return (TipoFormElement)getInstance().findByName2("Form");
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getTextField()
/*     */   {
/* 102 */     return getFormInputByName("TextField", TipoStringFormInput.INSTANCE);
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getNumberField()
/*     */   {
/* 109 */     return getFormInputByName("NumberField", new TipoFloatNumberFormInput());
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getTextArea()
/*     */   {
/* 116 */     return getFormInputByName("TextArea", TipoTextAreaFormInput.INSTANCE);
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getMedidaElement()
/*     */   {
/* 123 */     return getFormInputByName("MedidaElement", TipoMedidaFormInput.INSTANCE);
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getCalendarField()
/*     */   {
/* 130 */     return getFormInputByName("CalendarField", TipoCalendarFormInput.INSTANCE);
/*     */   }
/*     */ 
/*     */   public static TipoFormElement getComboElement()
/*     */   {
/* 137 */     TipoFormElement tipoFormElement = (TipoFormElement)getInstance().findByName2(
/* 138 */       "ComboElement");
/* 139 */     tipoFormElement.setFormComponentBuilderClass(DynamicFormComboBoxBuilderImpl.class);
/* 140 */     return tipoFormElement;
/*     */   }
/*     */ 
/*     */   public Collection findSimpleTypes() {
/* 144 */     return CollectionUtils.select(findAll(), new Predicate() {
/*     */       public boolean evaluate(Object arg0) {
/* 146 */         TipoFormElement tipo = (TipoFormElement)arg0;
/* 147 */         return (!tipo.equals(TipoFormElementSearcher.getForm())) && (!tipo.equals(TipoFormElementSearcher.getGrupo())) && (!tipo.equals(TipoFormElementSearcher.getComboElement()));
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.elements.searchers.TipoFormElementSearcher
 * JD-Core Version:    0.6.0
 */