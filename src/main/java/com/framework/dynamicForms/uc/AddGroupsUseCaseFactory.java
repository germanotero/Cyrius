/*   */ package com.framework.dynamicForms.uc;
/*   */ 
/*   */ import com.framework.dynamicForms.elements.searchers.DynamicGroupElementSearcher;
/*   */ 
/*   */ public class AddGroupsUseCaseFactory extends AddElementsUseCaseFactory
/*   */ {
/*   */   protected Object getElementsSearcher()
/*   */   {
/* 8 */     return DynamicGroupElementSearcher.getInstance();
/*   */   }
/*   */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.dynamicForms.uc.AddGroupsUseCaseFactory
 * JD-Core Version:    0.6.0
 */