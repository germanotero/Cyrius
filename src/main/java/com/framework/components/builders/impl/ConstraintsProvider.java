package com.framework.components.builders.impl;

/*     */ 
/*     */   public class ConstraintsProvider {
/*     */     private int maxColumns;
/*     */     private int actualColumn;
/*     */ 
/*     */     public ConstraintsProvider(int maxColumns) {
/* 405 */       this.maxColumns = maxColumns;
/* 406 */       this.actualColumn = 0;
/*     */     }
/*     */ 
/*     */     public String getRowDiscriminator() {
/* 410 */       if (this.actualColumn < this.maxColumns) {
/* 411 */         this.actualColumn += 1;
/* 412 */         return ".";
/*     */       }
/* 414 */       this.actualColumn = 1;
/* 415 */       return "+";
/*     */     }
/*     */ 
/*     */     public void rowElement()
/*     */     {
/* 423 */       this.actualColumn = this.maxColumns;
/*     */     }
/*     */   }
/*     */