/*    */ package com.framework.dynamicForms.entities;
/*    */ 
/*    */ import com.framework.exceptions.ShowableExceptionImpl;
/*    */ import com.framework.persistence.PersistibleObject;
/*    */ import org.apache.commons.lang.ObjectUtils;
/*    */ 
/*    */ public class ComboItem
/*    */   implements PersistibleObject
/*    */ {
/*    */   private Long id;
/*    */   private String name;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 19 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 23 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 31 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 36 */     return getName();
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 41 */     if (!(obj instanceof ComboItem)) {
/* 42 */       return false;
/*    */     }
/* 44 */     ComboItem that = (ComboItem)obj;
/* 45 */     if ((getId() != null) && (that.getId() != null)) {
/* 46 */       return getId().equals(that.getId());
/*    */     }
/* 48 */     return ObjectUtils.equals(this, that);
/*    */   }
/*    */ 
/*    */   public void validate()
/*    */   {
/* 54 */     ShowableExceptionImpl.validateNotNull("combo.item.name", getName());
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.entities.ComboItem
 * JD-Core Version:    0.6.0
 */