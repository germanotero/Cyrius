/*     */ package com.framework.persistence;
/*     */ 
/*     */ import com.framework.entities.DateLapse;
/*     */ import com.framework.exceptions.ShowableExceptionImpl;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
import java.util.List;

/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.Transaction;
/*     */ import org.hibernate.classic.Session;
/*     */ import org.hibernate.criterion.Expression;
/*     */ import org.hibernate.criterion.MatchMode;
/*     */ import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/*     */ 
/*     */ public class CriteriaBuilder<T>
/*     */ {
/*     */   private Criteria criteria;
/*     */   private boolean multiple;
/*     */   private Session session;
/*  23 */   private boolean acceptNullValues = true;
/*     */ 
/*  25 */   private boolean hasRestrictions = false;
/*     */ 
/*     */   public CriteriaBuilder(Session session, Class<T> clazz, boolean multiple)
/*     */   {
/*  29 */     session.beginTransaction();
/*  30 */     this.criteria = session.createCriteria(clazz);
/*  31 */     this.multiple = multiple;
/*  32 */     this.session = session;
/*     */   }
/*     */ 
/*     */   public Criteria getCriteria() {
/*  36 */     this.hasRestrictions = true;
/*  37 */     return this.criteria;
/*     */   }
/*     */ 
/*     */   public T build()
/*     */   {
/*     */     try {
/*  43 */       this.session.beginTransaction();
/*  44 */       Object answer = null;
/*  45 */       if (this.multiple) {
/*  46 */         if (this.hasRestrictions)
/*  47 */           answer = this.criteria.list();
/*     */         else
/*  49 */           answer = Collections.EMPTY_LIST;
/*     */       }
/*  51 */       else if (this.hasRestrictions)
/*  52 */         answer = this.criteria.uniqueResult();
/*     */       else {
/*  54 */         answer = null;
/*     */       }
/*  56 */       this.session.getTransaction().commit();
/*  57 */       return (T) answer;
/*     */     } catch (ShowableExceptionImpl ex) {
/*  59 */       throw ex;
/*     */     } catch (RuntimeException ex) {
/*  61 */       this.session.getTransaction().rollback();
throw new RuntimeException(
/*  63 */       "Error al intentar buscar en la base de datos, Verifique el estado de la misma", 
/*  64 */       ex);
/*  62 */     }
/*     */   }
/*     */ 
/*     */   public CriteriaBuilder<T> addEquals(String attribute, Object value)
/*     */   {
/*  69 */     if ((this.acceptNullValues) || (value != null)) {
/*  70 */       this.hasRestrictions = true;
/*  71 */       this.criteria.add(Expression.eq(attribute, value));
/*     */     }
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   public CriteriaBuilder<T> addSql(String sql) {
/*  77 */     this.hasRestrictions = true;
/*  78 */     this.criteria.add(Restrictions.sqlRestriction(sql));
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */   public CriteriaBuilder<T> addNotEquals(String attribute, Object value) {
/*  83 */     if ((this.acceptNullValues) || (value != null)) {
/*  84 */       this.hasRestrictions = true;
/*  85 */       this.criteria.add(Expression.ne(attribute, value));
/*     */     }
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   public CriteriaBuilder<T> addBetween(String string, Calendar inicioTurno, Calendar finTurno)
/*     */   {
/*  92 */     this.hasRestrictions = true;
/*  93 */     this.criteria.add(
/*  94 */       Restrictions.between(string, inicioTurno.getTime(), 
/*  94 */       finTurno.getTime()));
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */   public CriteriaBuilder<T> addBetween(String string, DateLapse period) {
/*  99 */     if ((this.acceptNullValues) || (period != null)) {
/* 100 */       this.hasRestrictions = true;
/* 101 */       this.criteria.add(
/* 102 */         Restrictions.between(string, period.getMin(), 
/* 102 */         period.getMax()));
/*     */     }
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   public void addilike(String property, String string, MatchMode matchMode) {
/* 108 */     if ((this.acceptNullValues) || ((string != null) && (!"".equals(string)))) {
/* 109 */       this.hasRestrictions = true;
/* 110 */       this.criteria.add(Restrictions.ilike(property, string, matchMode));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dontAcceptNullValues()
/*     */   {
/* 116 */     this.acceptNullValues = false;
/*     */   }
/*     */ 
/*     */   public void addOrderBy(String string)
/*     */   {
/* 121 */     this.hasRestrictions = true;
/* 122 */     this.criteria.addOrder(Order.asc(string));
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.CriteriaBuilder
 * JD-Core Version:    0.6.0
 */