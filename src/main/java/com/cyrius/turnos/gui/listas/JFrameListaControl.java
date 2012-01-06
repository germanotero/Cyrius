/*     */ package com.cyrius.turnos.gui.listas;
/*     */ 
/*     */ import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.cyrius.entities.Persona;
import com.cyrius.entities.Practica;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorTurnos;
import com.cyrius.ui.errores.ErrorGeneral;
import com.cyrius.utils.ExportExcel;
import com.framework.entities.DateLapse;
import com.framework.exceptions.ExceptionHandler;
import com.standbysoft.datepicker.JDatePicker;
/*     */ 
/*     */ public class JFrameListaControl extends JFrame
/*     */ {
/*     */   private JPanel panelGral;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable jTable1;
/*     */   private JDatePicker desde;
/*     */   private JDatePicker hasta;
/*     */   private JButton btnExcel;
/*     */   private JLabel lblDesde;
/*     */   private JLabel lblHasta;
/*     */   private JButton btnHacerTabla;
/*     */ 
/*     */   public JFrameListaControl()
/*     */     throws Exception
/*     */   {
/*  59 */     initComponents();
/*  60 */     initFrame();
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/*  64 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  65 */     int resAncho = (int)screenSize.getWidth();
/*  66 */     int resAlto = (int)screenSize.getHeight();
/*  67 */     setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 780, 540);
/*  68 */     setTitle("Lista");
/*     */   }
/*     */ 
/*     */   private Object[][] getMatrix(Timestamp desde, Timestamp hasta) throws Exception {
/*  72 */     DateLapse dp = new DateLapse(desde, hasta);
/*  73 */     Collection v = BuscadorTurnos.getTurnosControl(dp);
/*  74 */     Iterator it = v.iterator();
/*  75 */     Object[][] mat = new Object[v.size()][9];
/*  76 */     int i = 0;
/*     */ 
/*  78 */     while (it.hasNext()) {
/*  79 */       Turno e = (Turno)it.next();
/*  80 */       Practica prac = e.getPractica();
/*     */ 
/*  87 */       Persona p = e.getPaciente();
/*  88 */       mat[i][0] = new SimpleDateFormat("M/d/yy h:mm a").format(e.getHora());
/*  89 */       mat[i][1] = (p.getNombre() + " " + p.getApellido());
/*  90 */       mat[i][2] = e.getMedico();
/*  91 */       mat[i][3] = e.getObraSocial().getCodigo();
/*  92 */       mat[i][4] = prac.getDescription();
/*  93 */       mat[i][5] = e.getMonto();
/*  94 */       mat[i][6] = e.getBono();
/*  95 */       mat[i][7] = e.getArancelD();
/*  96 */       mat[(i++)][8] = e.getObservaciones();
/*     */     }
/*     */ 
/* 100 */     return mat;
/*     */   }
/*     */ 
/*     */   private void initComponents() throws Exception {
/* 104 */     this.panelGral = new JPanel();
/* 105 */     this.jScrollPane1 = new JScrollPane();
/* 106 */     this.jTable1 = new JTable();
/* 107 */     this.desde = new JDatePicker();
/* 108 */     this.hasta = new JDatePicker();
/* 109 */     this.lblDesde = new JLabel("Desde: ");
/* 110 */     this.lblHasta = new JLabel("Hasta: ");
/* 111 */     this.btnExcel = new JButton("Grabar como archivo Excel");
/* 112 */     this.btnHacerTabla = new JButton("Hacer Tabla.");
/* 113 */     this.panelGral.setLayout(null);
/* 114 */     this.panelGral.add(this.desde);
/* 115 */     this.panelGral.add(this.hasta);
/* 116 */     this.panelGral.add(this.lblDesde);
/* 117 */     this.panelGral.add(this.lblHasta);
/* 118 */     this.panelGral.add(this.btnHacerTabla);
/* 119 */     this.lblDesde.setBounds(5, 10, 50, 20);
/* 120 */     this.desde.setBounds(55, 10, 150, 20);
/* 121 */     this.lblHasta.setBounds(230, 10, 40, 20);
/* 122 */     this.hasta.setBounds(270, 10, 150, 20);
/* 123 */     this.btnHacerTabla.setBounds(320, 80, 150, 20);
/* 124 */     this.btnHacerTabla.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 126 */         JFrameListaControl.this.btnActionPerformed(arg0);
/*     */       }
/*     */     });
/* 129 */     this.btnExcel.setBounds(10, 80, 250, 20);
/* 130 */     this.btnExcel.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 132 */         JFrameListaControl.this.btnExcelActionPerformed(arg0);
/*     */       }
/*     */     });
/* 135 */     this.panelGral.add(this.btnExcel);
/* 136 */     this.btnExcel.setVisible(false);
/* 137 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/* 139 */         JFrameListaControl.this.exitForm(evt);
/*     */       }
/*     */     });
/* 142 */     setResizable(false);
/* 143 */     this.panelGral.add(this.jScrollPane1);
/* 144 */     this.jScrollPane1.setBounds(5, 120, 765, 380);
/* 145 */     this.jScrollPane1.setVisible(false);
/* 146 */     getContentPane().add(this.panelGral);
/* 147 */     pack();
/*     */   }
/*     */ 
/*     */   private void btnActionPerformed(ActionEvent arg0) {
/*     */     try {
/* 152 */       doTable(new Timestamp(this.desde.getDateSelectionModel().getLeadSelectionDate().getTime()), 
/* 153 */         new Timestamp(this.hasta.getDateSelectionModel().getLeadSelectionDate().getTime()));
/* 154 */       this.btnExcel.setVisible(true);
/*     */     } catch (Exception e) {
/* 156 */       e.printStackTrace();
/* 157 */       new ErrorGeneral(this, "Faltan completar Datos").show();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void btnExcelActionPerformed(ActionEvent arg0) {
/* 162 */     JFileChooser fc = new JFileChooser();
/* 163 */     fc.setAcceptAllFileFilterUsed(true);
/* 164 */     fc.setFileFilter(new FileFilter()
/*     */     {
/*     */       public boolean accept(File f)
/*     */       {
/* 169 */         return ((f.canWrite()) && (f.getName().length() > 4) && 
/* 167 */           (f.getName().substring(f.getName().length() - 4, f.getName().length()).equalsIgnoreCase(".xls"))) || 
/* 168 */           (f.isDirectory());
/*     */       }
/*     */ 
/*     */       public String getDescription()
/*     */       {
/* 176 */         return "Microsoft Excel (xls)";
/*     */       }
/*     */     });
/* 179 */     fc.showSaveDialog(this);
/*     */ 
/* 181 */     if (fc.getSelectedFile() != null)
/*     */       try {
/* 183 */         ExportExcel exp = new ExportExcel(fc.getSelectedFile().getPath(), this.jTable1);
/* 184 */         Thread t = new Thread(exp);
/* 185 */         t.start();
/*     */       } catch (Exception e) {
/* 187 */         ExceptionHandler.getInstance().handle(e);
/*     */       }
/*     */   }
/*     */ 
/*     */   private void doTable(Timestamp desde, Timestamp hasta) throws Exception
/*     */   {
/* 193 */     this.jTable1.setModel(
/* 194 */       new DefaultTableModel(getMatrix(desde, hasta), new String[] { "Fecha", 
/* 194 */       "Paciente", "Medico", "ObraSocial", "Practica", "Dep.", "Bono", "Ar.Dif.", "Obs." }) {
/* 195 */       Class[] types = { String.class, String.class, String.class, Float.class, String.class, 
/* 196 */         Boolean.class, Boolean.class };
/*     */ 
/* 198 */       boolean[] canEdit = new boolean[8];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 201 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 204 */     this.jTable1.setLayout(null);
/*     */ 
/* 218 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(110);
/* 219 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 220 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(10);
/* 221 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
/* 222 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 223 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(10);
/* 224 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(200);
/* 225 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(180);
/* 226 */     this.jTable1.getColumnModel().getColumn(4).setMinWidth(10);
/* 227 */     this.jTable1.getColumnModel().getColumn(6).setMaxWidth(60);
/* 228 */     this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
/* 229 */     this.jTable1.getColumnModel().getColumn(6).setMinWidth(10);
/* 230 */     this.jTable1.getColumnModel().getColumn(7).setMaxWidth(60);
/* 231 */     this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
/* 232 */     this.jTable1.getColumnModel().getColumn(7).setMinWidth(10);
/* 233 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
/* 234 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
/* 235 */     this.jTable1.getColumnModel().getColumn(5).setMinWidth(10);
/* 236 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
/* 237 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
/* 238 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(100);
/* 239 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
/* 240 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 241 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(80);
/* 242 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 243 */     this.jScrollPane1.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void mouseDoubleClick(MouseEvent arg0) {
/* 247 */     arg0.getClickCount();
/*     */   }
/*     */ 
/*     */   private void exitForm(WindowEvent evt)
/*     */   {
/* 255 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.listas.JFrameListaControl
 * JD-Core Version:    0.6.0
 */