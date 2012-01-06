/*     */ package com.framework.components;
/*     */ 
/*     */ import com.framework.utils.KeyCodes;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.swing.ComboBoxEditor;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.plaf.basic.BasicComboBoxEditor;
/*     */ 
/*     */ public class JAutoComboBox extends JComboBox
/*     */ {
/*  27 */   private int caretPos = 0;
/*     */ 
/*  29 */   private JTextField tf = null;
/*     */ 
/*  31 */   private boolean autoComplete = true;
/*     */ 
/*  33 */   private boolean autoSelect = true;
/*     */ 
/*     */   public JAutoComboBox()
/*     */   {
/*  37 */     setEditor(new BasicComboBoxEditor());
/*     */ 
/*  40 */     setEditable(false);
/*     */   }
/*     */ 
/*     */   public JAutoComboBox(Object[] items) {
/*  44 */     super(items);
/*  45 */     setEditor(new BasicComboBoxEditor());
/*  46 */     setEditable(true);
/*     */   }
/*     */ 
/*     */   public void setSelectedIndex(int ind) {
/*  50 */     super.setSelectedIndex(ind);
/*  51 */     if (super.getSelectedItem() != null) {
/*  52 */       this.tf.setText(getItemAt(ind).toString());
/*  53 */       this.tf.setSelectionEnd(this.caretPos + this.tf.getText().length());
/*  54 */       this.tf.moveCaretPosition(this.caretPos);
/*     */     } else {
/*  56 */       StringBuffer srb = new StringBuffer("Seleccione ");
/*  57 */       this.tf.setText(srb.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setBackground(Color color) {
/*  62 */     super.setBackground(color);
/*  63 */     if (this.tf != null)
/*  64 */       this.tf.setBackground(color);
/*     */   }
/*     */ 
/*     */   public void setForeground(Color color)
/*     */   {
/*  69 */     super.setForeground(color);
/*  70 */     if (this.tf != null)
/*  71 */       this.tf.setForeground(color);
/*     */   }
/*     */ 
/*     */   public void setCarretColor(Color color)
/*     */   {
/*  76 */     this.tf.setCaretColor(color);
/*     */   }
/*     */ 
/*     */   public void setEditor(ComboBoxEditor anEditor) {
/*  80 */     super.setEditor(anEditor);
/*  81 */     if ((anEditor.getEditorComponent() instanceof JTextField)) {
/*  82 */       this.tf = ((JTextField)anEditor.getEditorComponent());
/*  83 */       this.tf.setCaretColor(Color.WHITE);
/*  84 */       this.tf.setEditable(true);
/*  85 */       this.tf.setEnabled(true);
/*  86 */       this.tf.addKeyListener(new KeyAdapter() {
/*     */         public void keyReleased(KeyEvent arg0) {
/*  88 */           JAutoComboBox.this.keyReleasedActionPerformed(arg0);
/*     */         }
/*     */ 
/*     */         public void keyPressed(KeyEvent e)
/*     */         {
/*  93 */           JAutoComboBox.this.setPopupVisible(false);
/*     */         } } );
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setAutocomplete(boolean autoComplete) {
/* 100 */     this.autoComplete = autoComplete;
/*     */   }
/*     */ 
/*     */   public void setComboText(String text) {
/* 104 */     this.tf.setText(text);
/*     */   }
/*     */ 
/*     */   public String getComboText() {
/* 108 */     return this.tf.getText();
/*     */   }
/*     */ 
/*     */   public void setAutoselect(boolean autoSelect) {
/* 112 */     this.autoSelect = autoSelect;
/*     */   }
/*     */ 
/*     */   public boolean isAutoComplete() {
/* 116 */     return this.autoComplete;
/*     */   }
/*     */ 
/*     */   public boolean isAutoSelect() {
/* 120 */     return this.autoSelect;
/*     */   }
/*     */ 
/*     */   public void keyReleasedActionPerformed(KeyEvent ev) {
/* 124 */     if (!this.autoComplete) {
/* 125 */       if (this.tf.getText().length() == 1) {
/* 126 */         this.tf.setText(this.tf.getText().substring(0, 1).toUpperCase());
/*     */       }
/* 128 */       if ((this.tf.getText().length() > 1) && (ev.getKeyCode() != 32)) {
/* 129 */         StringTokenizer stk = new StringTokenizer(this.tf.getText(), " ");
/* 130 */         String text = "";
/* 131 */         while (stk.hasMoreTokens()) {
/* 132 */           String tok = stk.nextToken();
/* 133 */           text = text + tok.substring(0, 1).toUpperCase() + tok.substring(1);
/* 134 */           if (stk.hasMoreTokens()) {
/* 135 */             text = text + " ";
/*     */           }
/*     */         }
/* 138 */         this.tf.setText(text);
/*     */       }
/*     */     } else {
/* 141 */       setPopupVisible(true);
/* 142 */       if (ev.getKeyCode() == KeyCodes.ESC) {
/* 143 */         setPopupVisible(false);
/*     */       }
/* 145 */       if (ev.getKeyCode() == KeyCodes.ENTER) {
/* 146 */         setPopupVisible(false);
/*     */       }
/* 148 */       char key = ev.getKeyChar();
/* 149 */       if ((!Character.isLetterOrDigit(key)) && (!Character.isSpaceChar(key))) {
/* 150 */         return;
/*     */       }
/* 152 */       this.caretPos = this.tf.getCaretPosition();
/* 153 */       String text = "";
/*     */       try {
/* 155 */         text = this.tf.getText(0, this.caretPos);
/*     */       } catch (Exception ex) {
/* 157 */         ex.printStackTrace();
/*     */       }
/* 159 */       int n = getItemCount();
/* 160 */       int max = n;
/*     */ 
/* 162 */       for (int i = 0; i < n; i++) {
/* 163 */         int ind = getItemAt(i).toString().toUpperCase().indexOf(text.toUpperCase());
/* 164 */         if (ind == 0) {
/* 165 */           if (this.autoSelect) {
/* 166 */             setSelectedIndex(i);
/*     */           }
/* 168 */           return;
/*     */         }
/* 170 */         max--;
/*     */       }
/* 173 */         this.tf.setText(text.substring(0, this.caretPos - 1));
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.JAutoComboBox
 * JD-Core Version:    0.6.0
 */