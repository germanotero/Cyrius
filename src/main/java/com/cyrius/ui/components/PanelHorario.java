/*     */ package com.cyrius.ui.components;
/*     */ 
/*     */ import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;

import org.apache.commons.collections.Predicate;

import com.cyrius.entities.HorarioSemanal;
import com.framework.components.FormComponent;
import com.framework.components.FormValueSelectionContainer;
import com.framework.components.listeners.ModelTargetListener;
import com.framework.print.builder.PrintableElementsBuilder;
/*     */ 
/*     */ public class PanelHorario extends JPanel
/*     */   implements FormValueSelectionContainer
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
/*     */   private Collection<ModelTargetListener> listeners;
/*     */   private Predicate disablePredicate;
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
/*  98 */     this.pnHorario.setLayout(null);
/*  99 */     this.pnHorario.setMinimumSize(new Dimension(200, 120));
/* 100 */     this.pnHorario.setPreferredSize(new Dimension(200, 120));
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
/* 155 */     add(new JScrollPane(this.pnHorario), "Center");
/*     */   }
/*     */ 
/*     */   public void agregarHora(HorarioSemanal hs)
/*     */   {
/* 161 */     if ((hs.getDia().intValue() == 1) && 
/* 162 */       (hs.getMomento().equalsIgnoreCase("m"))) {
/* 163 */       this.chbLunMan.setSelected(true);
/*     */     }
/*     */ 
/* 166 */     if ((hs.getDia().intValue() == 1) && 
/* 167 */       (hs.getMomento().equalsIgnoreCase("t"))) {
/* 168 */       this.chbLunTar.setSelected(true);
/*     */     }
/*     */ 
/* 171 */     if ((hs.getDia().intValue() == 2) && 
/* 172 */       (hs.getMomento().equalsIgnoreCase("m"))) {
/* 173 */       this.chbMarMan.setSelected(true);
/*     */     }
/*     */ 
/* 176 */     if ((hs.getDia().intValue() == 2) && 
/* 177 */       (hs.getMomento().equalsIgnoreCase("t"))) {
/* 178 */       this.chbMarTar.setSelected(true);
/*     */     }
/*     */ 
/* 181 */     if ((hs.getDia().intValue() == 3) && 
/* 182 */       (hs.getMomento().equalsIgnoreCase("m"))) {
/* 183 */       this.chbMierMan.setSelected(true);
/*     */     }
/*     */ 
/* 186 */     if ((hs.getDia().intValue() == 3) && 
/* 187 */       (hs.getMomento().equalsIgnoreCase("t"))) {
/* 188 */       this.chbMierTar.setSelected(true);
/*     */     }
/*     */ 
/* 191 */     if ((hs.getDia().intValue() == 4) && 
/* 192 */       (hs.getMomento().equalsIgnoreCase("m"))) {
/* 193 */       this.chbJueMan.setSelected(true);
/*     */     }
/*     */ 
/* 196 */     if ((hs.getDia().intValue() == 4) && 
/* 197 */       (hs.getMomento().equalsIgnoreCase("t"))) {
/* 198 */       this.chbJueTar.setSelected(true);
/*     */     }
/*     */ 
/* 201 */     if ((hs.getDia().intValue() == 5) && 
/* 202 */       (hs.getMomento().equalsIgnoreCase("m"))) {
/* 203 */       this.chbVierMan.setSelected(true);
/*     */     }
/*     */ 
/* 206 */     if ((hs.getDia().intValue() == 5) && 
/* 207 */       (hs.getMomento().equalsIgnoreCase("t")))
/* 208 */       this.chbVierTar.setSelected(true);
/*     */   }
/*     */ 
/*     */   public Collection<HorarioSemanal> getSelected()
/*     */   {
/* 216 */     Collection v = new ArrayList(0);
/*     */ 
/* 218 */     if (this.chbLunMan.isSelected()) {
/* 219 */       HorarioSemanal hs = new HorarioSemanal();
/* 220 */       hs.setDia(new Integer(1));
/* 221 */       hs.setMomento("m");
/* 222 */       v.add(hs);
/*     */     }
/*     */ 
/* 225 */     if (this.chbLunTar.isSelected()) {
/* 226 */       HorarioSemanal hs = new HorarioSemanal();
/* 227 */       hs.setDia(new Integer(1));
/* 228 */       hs.setMomento("t");
/* 229 */       v.add(hs);
/*     */     }
/*     */ 
/* 232 */     if (this.chbMarMan.isSelected()) {
/* 233 */       HorarioSemanal hs = new HorarioSemanal();
/* 234 */       hs.setDia(new Integer(2));
/* 235 */       hs.setMomento("m");
/* 236 */       v.add(hs);
/*     */     }
/*     */ 
/* 239 */     if (this.chbMarTar.isSelected()) {
/* 240 */       HorarioSemanal hs = new HorarioSemanal();
/* 241 */       hs.setDia(new Integer(2));
/* 242 */       hs.setMomento("t");
/* 243 */       v.add(hs);
/*     */     }
/*     */ 
/* 246 */     if (this.chbMierMan.isSelected()) {
/* 247 */       HorarioSemanal hs = new HorarioSemanal();
/* 248 */       hs.setDia(new Integer(3));
/* 249 */       hs.setMomento("m");
/* 250 */       v.add(hs);
/*     */     }
/*     */ 
/* 253 */     if (this.chbMierTar.isSelected()) {
/* 254 */       HorarioSemanal hs = new HorarioSemanal();
/* 255 */       hs.setDia(new Integer(3));
/* 256 */       hs.setMomento("t");
/* 257 */       v.add(hs);
/*     */     }
/*     */ 
/* 260 */     if (this.chbJueMan.isSelected()) {
/* 261 */       HorarioSemanal hs = new HorarioSemanal();
/* 262 */       hs.setDia(new Integer(4));
/* 263 */       hs.setMomento("m");
/* 264 */       v.add(hs);
/*     */     }
/*     */ 
/* 267 */     if (this.chbJueTar.isSelected()) {
/* 268 */       HorarioSemanal hs = new HorarioSemanal();
/* 269 */       hs.setDia(new Integer(4));
/* 270 */       hs.setMomento("t");
/* 271 */       v.add(hs);
/*     */     }
/*     */ 
/* 274 */     if (this.chbVierMan.isSelected()) {
/* 275 */       HorarioSemanal hs = new HorarioSemanal();
/* 276 */       hs.setDia(new Integer(5));
/* 277 */       hs.setMomento("m");
/* 278 */       v.add(hs);
/*     */     }
/*     */ 
/* 281 */     if (this.chbVierTar.isSelected()) {
/* 282 */       HorarioSemanal hs = new HorarioSemanal();
/* 283 */       hs.setDia(new Integer(5));
/* 284 */       hs.setMomento("t");
/* 285 */       v.add(hs);
/*     */     }
/*     */ 
/* 288 */     return v;
/*     */   }
/*     */ 
/*     */   public void setModificable(Boolean b) {
/* 292 */     this.chbLunMan.setEnabled(b.booleanValue());
/* 293 */     this.chbLunTar.setEnabled(b.booleanValue());
/* 294 */     this.chbMarMan.setEnabled(b.booleanValue());
/* 295 */     this.chbMarTar.setEnabled(b.booleanValue());
/* 296 */     this.chbMierMan.setEnabled(b.booleanValue());
/* 297 */     this.chbMierTar.setEnabled(b.booleanValue());
/* 298 */     this.chbJueMan.setEnabled(b.booleanValue());
/* 299 */     this.chbJueTar.setEnabled(b.booleanValue());
/* 300 */     this.chbVierMan.setEnabled(b.booleanValue());
/* 301 */     this.chbVierTar.setEnabled(b.booleanValue());
/*     */   }
/*     */ 
/*     */   public void setClear() {
/* 305 */     this.chbLunMan.setSelected(false);
/* 306 */     this.chbLunTar.setSelected(false);
/* 307 */     this.chbMarMan.setSelected(false);
/* 308 */     this.chbMarTar.setSelected(false);
/* 309 */     this.chbMierMan.setSelected(false);
/* 310 */     this.chbMierTar.setSelected(false);
/* 311 */     this.chbJueMan.setSelected(false);
/* 312 */     this.chbJueTar.setSelected(false);
/* 313 */     this.chbVierMan.setSelected(false);
/* 314 */     this.chbVierTar.setSelected(false);
/*     */   }
/*     */ 
/*     */   public Collection<HorarioSemanal> getValor() {
/* 318 */     return getSelected();
/*     */   }
/*     */ 
/*     */   public void setValue(Object value) {
/* 322 */     Collection<HorarioSemanal> horarios = (Collection)value;
/* 323 */     for (HorarioSemanal horario : horarios)
/* 324 */       agregarHora(horario);
/*     */   }
/*     */ 
/*     */   public void addModelTargetListener(ModelTargetListener listener) {
/* 328 */     if (this.listeners == null)
/* 329 */       this.listeners = new ArrayList();
/* 330 */     this.listeners.add(listener);
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate) {
/* 334 */     for (ModelTargetListener listener : this.listeners)
/* 335 */       listener.unLoad(null);
/*     */   }
/*     */ 
/*     */   public FormComponent setNotVisibleOn(Predicate condition)
/*     */   {
/* 340 */     return null;
/*     */   }
/*     */ 
/*     */   public void initComponent() {
/* 344 */     initComponents();
/* 345 */     refreshComponent();
/*     */   }
/*     */ 
/*     */   public void refreshComponent() {
/* 349 */     for (ModelTargetListener listener : this.listeners)
/* 350 */       listener.load(null);
/*     */   }
/*     */ 
/*     */   public void direct(PrintableElementsBuilder print) {
/* 354 */     throw new RuntimeException("Under Construction:" + getClass());
/*     */   }
/*     */ 
/*     */   public boolean isEmpty() {
/* 358 */     return getSelected().isEmpty();
/*     */   }
/*     */ 
/*     */   public FormComponent setDisableOn(Predicate condition) {
/* 362 */     this.disablePredicate = condition;
/* 363 */     return this;
/*     */   }
/*     */ 
/*     */   public void setFull()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setNotFull()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.ui.components.PanelHorario
 * JD-Core Version:    0.6.0
 */