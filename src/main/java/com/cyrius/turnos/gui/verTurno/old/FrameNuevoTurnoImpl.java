/*    */ package com.cyrius.turnos.gui.verTurno.old;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class FrameNuevoTurnoImpl extends JFrame
/*    */ {
/* 21 */   private PanelNuevoTurnoImpl panel = null;
/*    */ 
/*    */   public FrameNuevoTurnoImpl() {
/* 24 */     initComponents();
/* 25 */     initFrame();
/*    */   }
/*    */ 
/*    */   private void initComponents() {
/* 29 */     setResizable(false);
/* 30 */     this.panel = new PanelNuevoTurnoImpl(this);
/* 31 */     getContentPane().add(this.panel);
/* 32 */     this.panel.setSize(795, 526);
/*    */   }
/*    */ 
/*    */   private void initFrame() {
/* 36 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 37 */     int resAncho = (int)screenSize.getWidth();
/* 38 */     int resAlto = (int)screenSize.getHeight();
/* 39 */     setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 765, 556);
/* 40 */     setTitle("Nuevo Turno");
/*    */   }
/*    */ 
/*    */   public FrameNuevoTurnoImpl close()
/*    */   {
/* 49 */     setVisible(false);
/* 50 */     dispose();
/* 51 */     return this;
/*    */   }
/*    */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.FrameNuevoTurnoImpl
 * JD-Core Version:    0.6.0
 */