/*     */ package com.framework.entities;
/*     */ 
/*     */ import com.framework.models.DelegatingModel;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ import com.framework.utils.ClassUtils;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import com.framework.utils.MapFactory;
/*     */ import com.framework.utils.PropertyUtils;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections.Closure;
/*     */ 
/*     */ public class FormModelDecorator
/*     */   implements FormModel
/*     */ {
/*     */   private Object wrapped;
/*  31 */   private Map<String, FormModel> values = (Map)MapFactory.createMap(String.class, 
/*  31 */     FormModel.class);
/*     */ 
/*     */   public FormModelDecorator(Object wraped)
/*     */   {
/*  35 */     if (wraped == null)
/*  36 */       throw new RuntimeException("no se puede wrapear un modelo nulo.");
/*  37 */     if ((wraped instanceof FormModelDecorator))
/*  38 */       this.wrapped = ((FormModelDecorator)wraped).wrapped;
/*     */     else
/*  40 */       this.wrapped = wraped;
/*     */   }
/*     */ 
/*     */   public Map<String, FormModel> getValues() {
/*  44 */     return this.values;
/*     */   }
/*     */ 
/*     */   public FormModel getProperty(String aspect)
/*     */   {
/*  52 */     int pointIndex = aspect.indexOf('.');
/*  53 */     if (pointIndex != -1) {
/*  54 */       String simpleProperty = aspect.substring(0, pointIndex);
/*  55 */       FormModel firstProperty = getSimpleAspect(simpleProperty);
/*  56 */       if (firstProperty == null)
/*  57 */         return null;
/*  58 */       return firstProperty.getProperty(aspect.substring(pointIndex + 1));
/*     */     }
/*  60 */     return getSimpleAspect(aspect);
/*     */   }
/*     */ 
/*     */   public FormModel getSimpleAspect(String aspect)
/*     */   {
/*  69 */     if (this.values.containsKey(aspect))
/*  70 */       return (FormModel)this.values.get(aspect);
/*     */     try {
/*  72 */       FormModel answer = null;
/*     */       try {
/*  74 */         Object property = PropertyUtils.getNestedProperty(this.wrapped, 
/*  75 */           aspect);
/*  76 */         if (property != null)
/*  77 */           answer = FormModelUtils.wrap(property);
/*     */       }
/*     */       catch (IllegalAccessException e) {
/*  80 */         throw new RuntimeException("Error al invocar el mensaje" + 
/*  81 */           aspect);
/*     */       } catch (InvocationTargetException e) {
/*  83 */         if ((e.getCause() instanceof RuntimeException)) {
/*  84 */           throw ((RuntimeException)e.getCause());
/*     */         }
/*  86 */         throw new RuntimeException(e.getCause());
/*     */       }
/*  88 */       if (answer == null) {
/*  89 */         return null;
/*     */       }
/*     */ 
/*  93 */       if (!(answer.getValue() instanceof Collection))
/*  94 */         this.values.put(aspect, answer);
/*  95 */       return answer;
/*     */     } catch (NoSuchMethodException e) {
/*  97 */       if ((this.wrapped instanceof DelegatingModel)) {
/*  98 */         DelegatingModel model = (DelegatingModel)this.wrapped;
/*  99 */         return FormModelUtils.wrap(model.getDelegatee()).getProperty(
/* 100 */           aspect);
/*     */       }
/* 102 */     throw new RuntimeException("Error al obtener la propiedad: " + 
/* 103 */       ClassUtils.getShortName(this.wrapped.getClass()) + 
/* 104 */       " no tiene la propiedad: " + aspect, e);
/*     */     }

/*     */   }
/*     */ 
/*     */   public void setProperty(String aspect, Object value)
/*     */   {
/* 115 */     if ((value instanceof Collection))
/* 116 */       inpactProperty(aspect, value);
/*     */     else
/* 118 */       this.values.put(aspect, FormModelUtils.wrap(value));
/*     */   }
/*     */ 
/*     */   public Object getValue()
/*     */   {
/* 125 */     impactInternValues();
/* 126 */     this.values.clear();
/* 127 */     return this.wrapped;
/*     */   }
/*     */ 
/*     */   public final void save() {
/* 131 */     impactInternValues();
/* 132 */     this.values.clear();
/*     */   }
/*     */ 
/*     */   private void impactInternValues()
/*     */   {
/* 139 */     CollectionUtils.forAllDo((Collection)this.values.keySet(), new Closure() {
/*     */       public void execute(Object arg0) {
/* 141 */         String property = (String)arg0;
/* 142 */         FormModel formModel = (FormModel)FormModelDecorator.this.values.get(property);
/* 143 */         FormModelDecorator.this.inpactProperty(property, formModel.getValue());
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void inpactProperty(String property, Object value)
/*     */   {
/*     */     try
/*     */     {
/* 156 */       PropertyUtils.setNestedProperty(this.wrapped, property, value);
/*     */     } catch (IllegalArgumentException e) {
/* 158 */       throw new RuntimeException(
/* 159 */         "Cuidado, se intento setear la propiedad: " + 
/* 160 */         property + 
/* 161 */         " y se encontro que el objeto a setear es de otra clase, objecto a setear: " + 
/* 162 */         value + " de la clase: " + 
/* 163 */         ClassUtils.getShortName(value.getClass()));
/*     */     } catch (NoSuchMethodException e) {
/* 165 */       if ((this.wrapped instanceof DelegatingModel)) {
/* 166 */         DelegatingModel model = (DelegatingModel)this.wrapped;
/*     */         try {
/* 168 */           PropertyUtils.setNestedProperty(model.getDelegatee(), 
/* 169 */             property, value);
/*     */         } catch (Exception e1) {
/* 171 */           throw new RuntimeException(e1);
/*     */         }
/*     */       } else {
/* 174 */         throw new RuntimeException(e);
/*     */       }
/*     */     } catch (IllegalAccessException e) {
/* 176 */       throw new RuntimeException(e);
/*     */     } catch (InvocationTargetException e) {
/* 178 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refresh() {
/* 183 */     this.values.clear();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 188 */     return this.wrapped.toString();
/*     */   }
/*     */ 
/*     */   public Class getDecoratedClass() {
/* 192 */     return this.wrapped.getClass();
/*     */   }
/*     */ 
/*     */   public boolean isPersisted() {
/* 196 */     if ((this.wrapped instanceof PersistibleObject)) {
/* 197 */       return ((PersistibleObject)this.wrapped).getId() != null;
/*     */     }
/* 199 */     return false;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.FormModelDecorator
 * JD-Core Version:    0.6.0
 */