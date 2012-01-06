/*     */ package com.cyrius.turnos.gui.verTurno;
/*     */ 
/*     */ import com.cyrius.entities.HorarioSemanal;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class HorarioSemanalMedicoJPanel extends JPanel
/*     */ {
/*     */   private JCheckBox chbJueMan;
/*     */   private JCheckBox chbJueTar;
/*     */   private JCheckBox chbLunMan;
/*     */   private JCheckBox chbLunTar;
/*     */   private JCheckBox chbMarMan;
/*     */   private JCheckBox chbMarTar;
/*     */   private JCheckBox chbMierMan;
/*     */   private JCheckBox chbMierTar;
/*     */   private JCheckBox chbVierMan;
/*     */   private JCheckBox chbVierTar;
/*     */   private JLabel lblJueves;
/*     */   private JLabel lblLunes;
/*     */   private JLabel lblMartes;
/*     */   private JLabel lblManana;
/*     */   private JLabel lblMiercoles;
/*     */   private JLabel lblTarde;
/*     */   private JLabel lblViernes;
/*     */   private JPanel pnHorario;
/*     */ 
/*     */   public HorarioSemanalMedicoJPanel()
/*     */   {
/*  70 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  79 */     this.pnHorario = new JPanel();
/*  80 */     this.lblLunes = new JLabel();
/*  81 */     this.lblMartes = new JLabel();
/*  82 */     this.lblMiercoles = new JLabel();
/*  83 */     this.lblJueves = new JLabel();
/*  84 */     this.lblViernes = new JLabel();
/*  85 */     this.lblManana = new JLabel();
/*  86 */     this.lblTarde = new JLabel();
/*  87 */     this.chbLunMan = new JCheckBox();
/*  88 */     this.chbLunTar = new JCheckBox();
/*  89 */     this.chbMarMan = new JCheckBox();
/*  90 */     this.chbMarTar = new JCheckBox();
/*  91 */     this.chbMierMan = new JCheckBox();
/*  92 */     this.chbMierTar = new JCheckBox();
/*  93 */     this.chbJueMan = new JCheckBox();
/*  94 */     this.chbJueTar = new JCheckBox();
/*  95 */     this.chbVierMan = new JCheckBox();
/*  96 */     this.chbVierTar = new JCheckBox();
/*  97 */     setLayout(new BorderLayout());
/*  98 */     setMinimumSize(new Dimension(357, 80));
/*  99 */     setPreferredSize(new Dimension(357, 80));
/* 100 */     this.pnHorario.setLayout(null);
/* 101 */     this.pnHorario.setBackground(new Color(255, 255, 255));
/* 102 */     this.pnHorario.setBorder(
/* 103 */       new SoftBevelBorder(0));
/* 104 */     this.lblLunes.setText("Lun");
/* 105 */     this.pnHorario.add(this.lblLunes);
/* 106 */     this.lblLunes.setBounds(70, 0, 35, 16);
/* 107 */     this.lblMartes.setText("Mar");
/* 108 */     this.pnHorario.add(this.lblMartes);
/* 109 */     this.lblMartes.setBounds(120, 0, 40, 16);
/* 110 */     this.lblMiercoles.setText("Mie");
/* 111 */     this.pnHorario.add(this.lblMiercoles);
/* 112 */     this.lblMiercoles.setBounds(180, 0, 56, 16);
/* 113 */     this.lblJueves.setText("Jue");
/* 114 */     this.pnHorario.add(this.lblJueves);
/* 115 */     this.lblJueves.setBounds(250, 0, 41, 16);
/* 116 */     this.lblViernes.setText("Vier");
/* 117 */     this.pnHorario.add(this.lblViernes);
/* 118 */     this.lblViernes.setBounds(310, 0, 50, 16);
/* 119 */     this.lblManana.setText("Mañana");
/* 120 */     this.pnHorario.add(this.lblManana);
/* 121 */     this.lblManana.setBounds(10, 20, 50, 16);
/* 122 */     this.lblTarde.setText("Tarde");
/* 123 */     this.pnHorario.add(this.lblTarde);
/* 124 */     this.lblTarde.setBounds(10, 50, 50, 16);
/* 125 */     this.chbLunMan.setBackground(new Color(255, 255, 255));
/* 126 */     this.pnHorario.add(this.chbLunMan);
/* 127 */     this.chbLunMan.setBounds(80, 20, 21, 21);
/* 128 */     this.chbLunTar.setBackground(new Color(255, 255, 255));
/* 129 */     this.pnHorario.add(this.chbLunTar);
/* 130 */     this.chbLunTar.setBounds(80, 50, 20, 21);
/* 131 */     this.chbMarMan.setBackground(new Color(255, 255, 255));
/* 132 */     this.pnHorario.add(this.chbMarMan);
/* 133 */     this.chbMarMan.setBounds(130, 20, 20, 21);
/* 134 */     this.chbMarTar.setBackground(new Color(255, 255, 255));
/* 135 */     this.pnHorario.add(this.chbMarTar);
/* 136 */     this.chbMarTar.setBounds(130, 50, 21, 21);
/* 137 */     this.chbMierMan.setBackground(new Color(255, 255, 255));
/* 138 */     this.pnHorario.add(this.chbMierMan);
/* 139 */     this.chbMierMan.setBounds(190, 20, 21, 21);
/* 140 */     this.chbMierTar.setBackground(new Color(255, 255, 255));
/* 141 */     this.pnHorario.add(this.chbMierTar);
/* 142 */     this.chbMierTar.setBounds(190, 50, 20, 21);
/* 143 */     this.chbJueMan.setBackground(new Color(255, 255, 255));
/* 144 */     this.pnHorario.add(this.chbJueMan);
/* 145 */     this.chbJueMan.setBounds(260, 20, 21, 21);
/* 146 */     this.chbJueTar.setBackground(new Color(255, 255, 255));
/* 147 */     this.pnHorario.add(this.chbJueTar);
/* 148 */     this.chbJueTar.setBounds(260, 50, 21, 21);
/* 149 */     this.chbVierMan.setBackground(new Color(255, 255, 255));
/* 150 */     this.pnHorario.add(this.chbVierMan);
/* 151 */     this.chbVierMan.setBounds(320, 20, 21, 21);
/* 152 */     this.chbVierTar.setBackground(new Color(255, 255, 255));
/* 153 */     this.pnHorario.add(this.chbVierTar);
/* 154 */     this.chbVierTar.setBounds(320, 50, 21, 21);
/* 155 */     add(this.pnHorario, "Center");
/*     */   }
/*     */ 
/*     */   public void agregarHorarios(Collection horarios)
/*     */   {
/* 161 */     for (Iterator it = horarios.iterator(); it.hasNext(); ) {
/* 162 */       HorarioSemanal hs = (HorarioSemanal)it.next();
/* 163 */       if ((hs.getDia().intValue() == 1) && 
/* 164 */         (hs.getMomento().equalsIgnoreCase("m"))) {
/* 165 */         this.chbLunMan.setSelected(true);
/*     */       }
/* 167 */       if ((hs.getDia().intValue() == 1) && 
/* 168 */         (hs.getMomento().equalsIgnoreCase("t"))) {
/* 169 */         this.chbLunTar.setSelected(true);
/*     */       }
/* 171 */       if ((hs.getDia().intValue() == 2) && 
/* 172 */         (hs.getMomento().equalsIgnoreCase("m"))) {
/* 173 */         this.chbMarMan.setSelected(true);
/*     */       }
/* 175 */       if ((hs.getDia().intValue() == 2) && 
/* 176 */         (hs.getMomento().equalsIgnoreCase("t"))) {
/* 177 */         this.chbMarTar.setSelected(true);
/*     */       }
/* 179 */       if ((hs.getDia().intValue() == 3) && 
/* 180 */         (hs.getMomento().equalsIgnoreCase("m"))) {
/* 181 */         this.chbMierMan.setSelected(true);
/*     */       }
/* 183 */       if ((hs.getDia().intValue() == 3) && 
/* 184 */         (hs.getMomento().equalsIgnoreCase("t"))) {
/* 185 */         this.chbMierTar.setSelected(true);
/*     */       }
/* 187 */       if ((hs.getDia().intValue() == 4) && 
/* 188 */         (hs.getMomento().equalsIgnoreCase("m"))) {
/* 189 */         this.chbJueMan.setSelected(true);
/*     */       }
/* 191 */       if ((hs.getDia().intValue() == 4) && 
/* 192 */         (hs.getMomento().equalsIgnoreCase("t"))) {
/* 193 */         this.chbJueTar.setSelected(true);
/*     */       }
/* 195 */       if ((hs.getDia().intValue() == 5) && 
/* 196 */         (hs.getMomento().equalsIgnoreCase("m"))) {
/* 197 */         this.chbVierMan.setSelected(true);
/*     */       }
/* 199 */       if ((hs.getDia().intValue() != 5) || 
/* 200 */         (!hs.getMomento().equalsIgnoreCase("t"))) continue;
/* 201 */       this.chbVierTar.setSelected(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Vector getSelected()
/*     */   {
/* 213 */     Vector v = new Vector(0);
/* 214 */     if (this.chbLunMan.isSelected()) {
/* 215 */       HorarioSemanal hs = new HorarioSemanal();
/* 216 */       hs.setDia(new Integer(1));
/* 217 */       hs.setMomento("m");
/* 218 */       v.add(hs);
/*     */     }
/* 220 */     if (this.chbLunTar.isSelected()) {
/* 221 */       HorarioSemanal hs = new HorarioSemanal();
/* 222 */       hs.setDia(new Integer(1));
/* 223 */       hs.setMomento("t");
/* 224 */       v.add(hs);
/*     */     }
/* 226 */     if (this.chbMarMan.isSelected()) {
/* 227 */       HorarioSemanal hs = new HorarioSemanal();
/* 228 */       hs.setDia(new Integer(2));
/* 229 */       hs.setMomento("m");
/* 230 */       v.add(hs);
/*     */     }
/* 232 */     if (this.chbMarTar.isSelected()) {
/* 233 */       HorarioSemanal hs = new HorarioSemanal();
/* 234 */       hs.setDia(new Integer(2));
/* 235 */       hs.setMomento("t");
/* 236 */       v.add(hs);
/*     */     }
/* 238 */     if (this.chbMierMan.isSelected()) {
/* 239 */       HorarioSemanal hs = new HorarioSemanal();
/* 240 */       hs.setDia(new Integer(3));
/* 241 */       hs.setMomento("m");
/* 242 */       v.add(hs);
/*     */     }
/* 244 */     if (this.chbMierTar.isSelected()) {
/* 245 */       HorarioSemanal hs = new HorarioSemanal();
/* 246 */       hs.setDia(new Integer(3));
/* 247 */       hs.setMomento("t");
/* 248 */       v.add(hs);
/*     */     }
/* 250 */     if (this.chbJueMan.isSelected()) {
/* 251 */       HorarioSemanal hs = new HorarioSemanal();
/* 252 */       hs.setDia(new Integer(4));
/* 253 */       hs.setMomento("m");
/* 254 */       v.add(hs);
/*     */     }
/* 256 */     if (this.chbJueTar.isSelected()) {
/* 257 */       HorarioSemanal hs = new HorarioSemanal();
/* 258 */       hs.setDia(new Integer(4));
/* 259 */       hs.setMomento("t");
/* 260 */       v.add(hs);
/*     */     }
/* 262 */     if (this.chbVierMan.isSelected()) {
/* 263 */       HorarioSemanal hs = new HorarioSemanal();
/* 264 */       hs.setDia(new Integer(5));
/* 265 */       hs.setMomento("m");
/* 266 */       v.add(hs);
/*     */     }
/* 268 */     if (this.chbVierTar.isSelected()) {
/* 269 */       HorarioSemanal hs = new HorarioSemanal();
/* 270 */       hs.setDia(new Integer(5));
/* 271 */       hs.setMomento("t");
/* 272 */       v.add(hs);
/*     */     }
/* 274 */     return v;
/*     */   }
/*     */ 
/*     */   public void setModificable(Boolean b) {
/* 278 */     this.chbLunMan.setEnabled(b.booleanValue());
/* 279 */     this.chbLunTar.setEnabled(b.booleanValue());
/* 280 */     this.chbMarMan.setEnabled(b.booleanValue());
/* 281 */     this.chbMarTar.setEnabled(b.booleanValue());
/* 282 */     this.chbMierMan.setEnabled(b.booleanValue());
/* 283 */     this.chbMierTar.setEnabled(b.booleanValue());
/* 284 */     this.chbJueMan.setEnabled(b.booleanValue());
/* 285 */     this.chbJueTar.setEnabled(b.booleanValue());
/* 286 */     this.chbVierMan.setEnabled(b.booleanValue());
/* 287 */     this.chbVierTar.setEnabled(b.booleanValue());
/*     */   }
/*     */ 
/*     */   public void setClear() {
/* 291 */     this.chbLunMan.setSelected(false);
/* 292 */     this.chbLunTar.setSelected(false);
/* 293 */     this.chbMarMan.setSelected(false);
/* 294 */     this.chbMarTar.setSelected(false);
/* 295 */     this.chbMierMan.setSelected(false);
/* 296 */     this.chbMierTar.setSelected(false);
/* 297 */     this.chbJueMan.setSelected(false);
/* 298 */     this.chbJueTar.setSelected(false);
/* 299 */     this.chbVierMan.setSelected(false);
/* 300 */     this.chbVierTar.setSelected(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.HorarioSemanalMedicoJPanel
 * JD-Core Version:    0.6.0
 */