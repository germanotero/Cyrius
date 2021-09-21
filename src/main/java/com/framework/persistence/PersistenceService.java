/*     */ package com.framework.persistence;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ import org.hibernate.cfg.Configuration;
/*     */ import org.hibernate.classic.Session;
/*     */ 
/*     */ public class PersistenceService
/*     */ {
/*     */   private static PersistenceService instance;
/*  23 */   private static transient Log log = LogFactory.getLog(PersistenceService.class);
/*     */   private Session session;
/*     */   private SessionFactory sessionFactory;
/*     */ 
/*     */   protected PersistenceService()
/*     */   {
/*     */     try
/*     */     {
/*  33 */       Configuration configuration = new Configuration();
/*  34 */       configuration.configure(new File("config/hibernate.cfg.xml"));
/*  35 */       this.sessionFactory = configuration.buildSessionFactory();
/*  36 */       this.session = this.sessionFactory.openSession();
/*     */     }
/*     */     catch (Throwable ex) {
/*  39 */       log.error("Initial SessionFactory creation failed.", ex);
/*  40 */       throw new ExceptionInInitializerError(ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public SessionFactory getSessionFactory() {
/*  44 */     return this.sessionFactory;
/*     */   }
/*     */ 
/*     */   public static final synchronized PersistenceService getInstance() {
/*  48 */     if (instance == null) {
/*  49 */       instance = new PersistenceService();
/*     */     }
/*  51 */     return instance;
/*     */   }
/*     */ 
/*     */   public <T> Collection<T> loadAll(Class<T> classToLoad)
/*     */   {
/*  56 */     Session session = getCurrentSession();
/*  57 */     Collection answer = null;
/*     */     try {
/*  59 */       session.beginTransaction();
/*  60 */       answer = session.createCriteria(classToLoad).list();
/*     */     } catch (RuntimeException ex) {
/*  62 */       if (session.getTransaction().isActive())
/*  63 */         session.getTransaction().rollback();
/*  64 */       throw new PersistenceException(
/*  65 */         "Error al intentar buscar en la base de datos, Verifique el estado de la misma", ex);
/*     */     }
/*  67 */     session.getTransaction().commit();
/*  68 */     return answer;
/*     */   }
/*     */ 
/*     */   public <T> Object load(Class<T> classToLoad, Serializable pk)
/*     */   {
/*  73 */     Session session = getCurrentSession();
/*  74 */     Object answer = null;
/*     */     try {
/*  76 */       session.beginTransaction();
/*  77 */       answer = session.load(classToLoad, pk);
/*     */     } catch (RuntimeException ex) {
/*  79 */       if (session.getTransaction().isActive())
/*  80 */         session.getTransaction().rollback();
/*  81 */       throw new PersistenceException(
/*  82 */         "Error al intentar buscar en la base de datos, Verifique el estado de la misma", ex);
/*     */     }
/*  84 */     session.getTransaction().commit();
/*  85 */     return answer;
/*     */   }
/*     */ 
/*     */   public boolean save(PersistibleObject object) {
/*  89 */     object.validate();
/*  90 */     Session session = getCurrentSession();
/*     */     try {
/*  92 */       session.beginTransaction();
/*  93 */       session.saveOrUpdate(object);
/*  94 */       session.getTransaction().commit();
/*     */     } catch (RuntimeException ex) {
/*  96 */       if (session.getTransaction().isActive())
/*  97 */         session.getTransaction().rollback();
/*  98 */       throw new PersistenceException(
/*  99 */         "Error al intentar grabar en la base de datos, Verifique el estado de la misma", ex);
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   public Session getCurrentSession() {
/* 105 */     return this.session;
/*     */   }
/*     */ 
/*     */   protected void finalize() throws Throwable
/*     */   {
/* 110 */     getCurrentSession().flush();
/* 111 */     getCurrentSession().close();
/* 112 */     super.finalize();
/*     */   }
/*     */ 
/*     */   public <T> CriteriaBuilder<Collection<T>> criteriaBuilder(Class<T> criteriaClass) {
/* 116 */     return new CriteriaBuilder(getCurrentSession(), criteriaClass, true);
/*     */   }
/*     */ 
/*     */   public <T> CriteriaBuilder<T> uniqueCriteriaBuilder(Class<T> T) {
/* 120 */     return new CriteriaBuilder(getCurrentSession(), T, false);
/*     */   }
/*     */ 
/*     */   public BigInteger getSequenceVelue(String string) {
/* 124 */     Session session = getCurrentSession();
/*     */     try {
/* 126 */       session.beginTransaction();
/* 127 */       BigInteger bigInteger = new BigInteger(session.getNamedQuery(string).uniqueResult().toString());
/* 128 */       session.getTransaction().commit();
/* 129 */       return bigInteger;
/*     */     } catch (Exception ex) {
/* 131 */       if (session.getTransaction().isActive())
/* 132 */         session.getTransaction().rollback();
/* 133 */     throw new PersistenceException(
/* 134 */       "Error al intentar aumentar una secuencia en la base de datos, Verifique el estado de la misma", ex);
/*     */     }

/*     */   }
/*     */ 
/*     */   public void delete(Object object)
/*     */   {
/* 140 */     Session session = getCurrentSession();
/*     */     try {
/* 142 */       session.beginTransaction();
/* 143 */       session.delete(object);
/* 144 */       session.getTransaction().commit();
/*     */     } catch (RuntimeException ex) {
/* 146 */       if (session.getTransaction().isActive())
/* 147 */         session.getTransaction().rollback();
/* 148 */       throw new PersistenceException(
/* 149 */         "Error al intentar borrar en la base de datos, Verifique el estado de la misma", ex);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.persistence.PersistenceService
 * JD-Core Version:    0.6.0
 */