/*     */ package com.framework.utils;
/*     */ 
/*     */ import com.framework.entities.NullObjectEnable;
/*     */ import com.framework.exceptions.ShowableExceptionImpl;
/*     */ import com.framework.persistence.ApplicationException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ public class ClassUtils
/*     */ {
/*     */   public static String getGetter(String getterName)
/*     */   {
/*  24 */     if (getterName.startsWith("find"))
/*  25 */       return getterName;
/*  26 */     return "get" + getterName.substring(0, 1).toUpperCase() + 
/*  27 */       getterName.substring(1);
/*     */   }
/*     */ 
/*     */   public static String getSetter(String setterName) {
/*  31 */     return "set" + setterName.substring(0, 1).toUpperCase() + 
/*  32 */       setterName.substring(1);
/*     */   }
/*     */ 
/*     */   public static Class[] toClassArray(Object clazz) {
/*  36 */     if (clazz == null)
/*  37 */       return new Class[0];
/*  38 */     Class[] arr = new Class[1];
/*  39 */     arr[0] = clazz.getClass();
/*  40 */     return arr;
/*     */   }
/*     */ 
/*     */   public static Class[] ClassToClassArray(Class clazz)
/*     */   {
/*  45 */     Class[] arr = new Class[1];
/*  46 */     arr[0] = clazz;
/*     */ 
/*  48 */     return arr;
/*     */   }
/*     */ 
/*     */   public static Object[] toArray(Object argument) {
/*  52 */     Object[] arr = new Object[1];
/*  53 */     arr[0] = argument;
/*  54 */     return arr;
/*     */   }
/*     */ 
/*     */   public static Object invokeMethod(Object methodParent, String method, Object argument)
/*     */     throws NoSuchMethodException
/*     */   {
/*  72 */     Class[] argumentsClazz = toClassArray(argument);
/*  73 */     Object[] arguments = toArray(argument);
/*  74 */     return invokeMethod(methodParent, method, arguments, argumentsClazz);
/*     */   }
/*     */ 
/*     */   public static Object invokeMethod(Object methodParent, String method, Object argument, Class argumentsClass) throws NoSuchMethodException
/*     */   {
/*  79 */     Class[] argumentsClazz = ClassToClassArray(argumentsClass);
/*  80 */     Object[] arguments = toArray(argument);
/*  81 */     return invokeMethod(methodParent, method, arguments, argumentsClazz);
/*     */   }
/*     */ 
/*     */   public static Object invokeMethod(Object methodParent, String method, Object[] arguments)
/*     */   {
/*  86 */     Class[] clazz = new Class[arguments.length];
/*  87 */     ArrayIterator iterator = new ArrayIterator(arguments);
/*     */ 
/*  89 */     for (int i = 0; iterator.hasNext(); i++) {
/*  90 */       Object element = iterator.next();
/*  91 */       if (element != null)
/*  92 */         clazz[i] = element.getClass();
/*     */     }
/*     */     try {
/*  95 */       return invokeMethod(methodParent, method, arguments, clazz);
/*     */     } catch (ShowableExceptionImpl ex) {
/*  97 */       throw ex; } catch (NoSuchMethodException e) {
	/*  99 */     throw new RuntimeException("Erro al obtener la propiedad " + method + 
			/* 100 */       " del modelo " + methodParent, e);
/*     */     }

/*     */   }
/*     */ 
/*     */   private static Object invokeMethod(Object methodParent, String method, Object[] arguments, Class[] argumentsClazz)
/*     */     throws NoSuchMethodException
/*     */   {
/* 107 */     Object result = null;
/* 108 */     Method metodo = null;
/*     */     try {
/* 110 */       if (methodParent != null)
/* 111 */         metodo = methodParent.getClass().getDeclaredMethod(method, 
/* 112 */           argumentsClazz);
/*     */     }
/*     */     catch (ShowableExceptionImpl ex)
/*     */     {
/* 116 */       throw ex;
/*     */     } catch (SecurityException e) {
/* 118 */       e.printStackTrace();
/*     */     } catch (NoSuchMethodException e) {
/* 120 */       metodo = findMethodByNameOnly(methodParent, method);
/*     */     } catch (IllegalArgumentException e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 125 */       result = metodo.invoke(methodParent, arguments);
/*     */     } catch (Exception e) {
/* 127 */       if ((e.getCause() instanceof ApplicationException))
/* 128 */         throw ((ApplicationException)e.getCause());
/* 129 */       throw new RuntimeException(e);
/*     */     }
/* 131 */     return result;
/*     */   }
/*     */ 
/*     */   private static Method findMethodByNameOnly(Object methodParent, String method)
/*     */     throws NoSuchMethodException
/*     */   {
/* 141 */     Method[] metodos = methodParent.getClass().getMethods();
/* 142 */     for (int i = 0; i < metodos.length; i++) {
/* 143 */       Method metodo = metodos[i];
/* 144 */       if (metodo.getName().equals(method))
/* 145 */         return metodo;
/*     */     }
/* 147 */     throw new NoSuchMethodException(
/* 148 */       "There is no method with the gibben name: " + 
/* 149 */       methodParent.getClass().getName() + "  " + method);
/*     */   }
/*     */ 
/*     */   public static Object invokeMethod(Object methodParent, String method) {
/* 153 */     Object result = null;
/*     */     try {
/* 155 */       result = methodParent.getClass().getMethod(method, null).invoke(
/* 156 */         methodParent, null);
/*     */     } catch (ShowableExceptionImpl ex) {
/* 158 */       throw ex;
/*     */     } catch (Exception e) {
/* 160 */       if ((e.getCause() instanceof ShowableExceptionImpl))
/* 161 */         throw ((ShowableExceptionImpl)e.getCause());
/* 162 */       throw new RuntimeException(e);
/*     */     }
/*     */ 
/* 165 */     return result;
/*     */   }
/*     */ 
/*     */   public static Object[] transformToObjectArray(Object argument) {
/* 169 */     Object[] result = new Object[1];
/* 170 */     result[0] = argument;
/* 171 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getShortName(Class clazz) {
/* 175 */     StringTokenizer tok = new StringTokenizer(clazz.getName(), ".");
/* 176 */     String lastToken = "";
/* 177 */     while (tok.hasMoreTokens()) {
/* 178 */       lastToken = tok.nextToken();
/*     */     }
/* 180 */     return lastToken;
/*     */   }
/*     */ 
/*     */   public static Object getNestedProperty(Object parent, String propertyName)
/*     */     throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
/*     */   {
/* 207 */     Object model = parent;
/* 208 */     Object invokedObject = null;
/* 209 */     String key = propertyName;
/* 210 */     StringTokenizer stk = new StringTokenizer(key, ".");
/* 211 */     if (stk.hasMoreTokens()) {
/* 212 */       String token = stk.nextToken();
/*     */ 
/* 214 */       invokedObject = model.getClass().getMethod(
/* 215 */         getGetter(token.trim()), new Class[0]).invoke(
/* 216 */         model, new Object[0]);
/* 217 */       while ((stk.hasMoreTokens()) && (invokedObject != null)) {
/* 218 */         token = stk.nextToken();
/* 219 */         invokedObject = invokedObject.getClass().getMethod(
/* 220 */           getGetter(token), new Class[0]).invoke(
/* 221 */           invokedObject, new Object[0]);
/*     */       }
/*     */     }
/* 224 */     return invokedObject;
/*     */   }
/*     */ 
/*     */   public static void setNestedProperty(Object parent, String hierarchiMethod, Object argument)
/*     */     throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
/*     */   {
/* 248 */     if (!(argument instanceof NullObjectEnable)) {
/* 249 */       Object invokedObject = parent;
/* 250 */       String key = hierarchiMethod;
/* 251 */       StringTokenizer stk = new StringTokenizer(key, ".");
/* 252 */       int tokensCount = stk.countTokens();
/* 253 */       int actualToken = 0;
/* 254 */       String token = stk.nextToken();
/* 255 */       while ((actualToken < tokensCount - 1) && (invokedObject != null)) {
/* 256 */         actualToken++;
/* 257 */         invokedObject = invokedObject.getClass().getMethod(
/* 258 */           getGetter(token), new Class[0]).invoke(
/* 259 */           invokedObject, new Object[0]);
/* 260 */         token = stk.nextToken();
/*     */       }
/*     */ 
/* 263 */       invokeMethod(invokedObject, getSetter(token), 
/* 264 */         argument);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static <T> Object newInstance(Class<T> clazz) {
/*     */     try {
/* 270 */       return clazz.newInstance(); } catch (Exception e) {
	/* 272 */     throw new RuntimeException(e);
/*     */     }

/*     */   }
/*     */ 
/*     */   public static Object newInstance(Class clazz, Class[] params, Object[] args)
/*     */   {
/*     */     try {
/* 278 */       Constructor constructor = clazz.getConstructor(params);
/* 279 */       return constructor.newInstance(args);
/*     */     } catch (Exception e) {
/* 281 */       if ((e.getCause() instanceof ApplicationException))
/* 282 */         throw ((ApplicationException)e.getCause());
/* 283 */     throw new RuntimeException(e);
/*     */     }

/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.ClassUtils
 * JD-Core Version:    0.6.0
 */