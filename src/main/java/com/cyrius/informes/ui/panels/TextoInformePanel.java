/*     */ package com.cyrius.informes.ui.panels;
/*     */ 
/*     */ import com.cyrius.informes.models.TextoInforme;
/*     */ import com.framework.models.TextProperty;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.awt.TextArea;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JToolBar;
/*     */ 
/*     */ public final class TextoInformePanel extends JPanel
/*     */ {
/*     */   private JToolBar toolbar;
/*     */   private InformeDetailTextArea textArea;
/*     */ 
/*     */   private void initialize()
/*     */   {
/* 105 */     setLayout(new BorderLayout());
/* 106 */     add(getTextInformePanel(), "Center");
/* 107 */     add(getTextoInformeToolbar(), "North");
/*     */   }
/*     */ 
/*     */   private Component getTextInformePanel()
/*     */   {
/* 114 */     JScrollPane js = new JScrollPane();
/* 115 */     js.setViewportView(getTextArea());
/* 116 */     return js;
/*     */   }
/*     */ 
/*     */   private InformeDetailTextArea getTextArea()
/*     */   {
/* 123 */     if (this.textArea == null) {
/* 124 */       this.textArea = new InformeDetailTextArea();
/*     */     }
/* 126 */     return this.textArea;
/*     */   }
/*     */ 
/*     */   private JToolBar getTextoInformeToolbar()
/*     */   {
/* 133 */     if (this.toolbar == null) {
/* 134 */       this.toolbar = new TextoInformeToolbar();
/*     */     }
/* 136 */     return this.toolbar;
/*     */   }
/*     */ 
/*     */   public TextoInforme getTextoInforme() {
/* 140 */     return new TextoInforme(this.textArea.getText());
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ 
/*     */   private final class InformeDetailTextArea extends TextArea
/*     */     implements ActionListener
/*     */   {
/*     */     private InformeDetailTextArea()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/*  32 */       if ((e.getSource() instanceof TextoInformePanel.InformeTextoPropertyButton)) {
/*  33 */         TextProperty info = ((TextoInformePanel.InformeTextoPropertyButton)e.getSource())
/*  34 */           .getInfo();
/*  35 */         insert(info.getKey(), getCaretPosition());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class InformeTextoPropertyButton extends JButton
/*     */   {
/*     */     private TextProperty info;
/*     */ 
/*     */     public InformeTextoPropertyButton(TextProperty info)
/*     */     {
/*  52 */       super();
/*  53 */       this.info = info;
/*  54 */       addActionListener(TextoInformePanel.this.textArea);
/*     */     }
/*     */ 
/*     */     public TextProperty getInfo() {
/*  58 */       return this.info;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class TextoInformeToolbar extends JToolBar
/*     */   {
/*     */     public TextoInformeToolbar()
/*     */     {
/*  69 */       initialize();
/*     */     }
/*     */ 
/*     */     private void initialize()
/*     */     {
/*  76 */       addButtons();
/*     */     }
/*     */ 
/*     */     private void addButtons()
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.ui.panels.TextoInformePanel
 * JD-Core Version:    0.6.0
 */