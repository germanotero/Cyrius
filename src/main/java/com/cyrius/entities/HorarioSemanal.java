/*    */ package com.cyrius.entities;
/*    */ 
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ 
/*    */ public class HorarioSemanal
/*    */   implements PersistibleObject
/*    */ {
/*    */   public static final String TARDE = "t";
/*    */   public static final String MANANA = "m";
/*    */   private Long id;
/*    */   private Integer dia;
/*    */   private String momento;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 23 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 27 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Integer getDia()
/*    */   {
/* 34 */     return this.dia;
/*    */   }
/*    */ 
/*    */   public void setDia(Integer dia)
/*    */   {
/* 42 */     this.dia = dia;
/*    */   }
/*    */ 
/*    */   public String getMomento()
/*    */   {
/* 49 */     return this.momento;
/*    */   }
/*    */ 
/*    */   public void setMomento(String momento)
/*    */   {
/* 57 */     this.momento = momento;
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.entities.HorarioSemanal
 * JD-Core Version:    0.6.0
 */