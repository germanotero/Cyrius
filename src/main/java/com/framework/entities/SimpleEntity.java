/*    */ package com.framework.entities;
/*    */ 
/*    */ public abstract class SimpleEntity
/*    */ {
/*    */   private String name;
/*    */   private String description;
/*    */ 
/*    */   public SimpleEntity()
/*    */   {
/* 12 */     this(null, null);
/*    */   }
/*    */ 
/*    */   public SimpleEntity(String name, String description)
/*    */   {
/* 17 */     this.name = name;
/* 18 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 22 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 26 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 36 */     return this.name;
/*    */   }
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 43 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description)
/*    */   {
/* 51 */     this.description = description;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.entities.SimpleEntity
 * JD-Core Version:    0.6.0
 */