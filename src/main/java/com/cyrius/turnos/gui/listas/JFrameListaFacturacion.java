/*     */ package com.cyrius.turnos.gui.listas;
/*     */ 
/*     */ import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.cyrius.searchers.BuscadorMedicos;
import com.cyrius.searchers.BuscadorObraSocial;
import com.cyrius.searchers.ReportesService;
import com.cyrius.utils.ExportExcel;
import com.cyrius.utils.prints.JPrintTable;
import com.framework.exceptions.ExceptionHandler;
import com.standbysoft.datepicker.JDatePicker;
/*     */ 
/*     */ public class JFrameListaFacturacion extends JFrame
/*     */ {
/*     */   private JPanel panelGral;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JPrintTable tabla;
/*     */   private JDatePicker desde;
/*     */   private JDatePicker hasta;
/*     */   private JList listaMedicos;
/*     */   private JLabel lblDesde;
/*     */   private JLabel lblHasta;
/*     */   private JLabel lblMedico;
/*     */   private JButton btnHacerTabla;
/*     */   private JLabel lblOs;
/*     */   private JButton btnExcel;
/*  63 */   private JScrollPane spListaObras = new JScrollPane();
/*     */   private JList listaObras;
/*     */ 
/*     */   public JFrameListaFacturacion()
/*     */     throws Exception
/*     */   {
/*  69 */     initComponents();
/*  70 */     initFrame();
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/*  74 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  75 */     int resAncho = (int)screenSize.getWidth();
/*  76 */     int resAlto = (int)screenSize.getHeight();
/*  77 */     setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 780, 540);
/*  78 */     setTitle("Lista de turnos");
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  82 */     this.panelGral = new JPanel();
/*  83 */     this.jScrollPane1 = new JScrollPane();
/*  84 */     this.tabla = new JPrintTable();
/*  85 */     this.desde = new JDatePicker();
/*  86 */     this.hasta = new JDatePicker();
/*  87 */     this.lblDesde = new JLabel("Desde: ");
/*  88 */     this.lblHasta = new JLabel("Hasta: ");
/*  89 */     this.lblMedico = new JLabel("Medico: ");
/*  90 */     this.lblOs = new JLabel("Obra Social: ");
/*  91 */     this.btnExcel = new JButton("Grabar como archivo Excel");
/*  92 */     this.listaObras = new JList();
/*  93 */     this.listaMedicos = new JList();
/*  94 */     this.btnExcel.setBounds(10, 80, 250, 20);
/*  95 */     this.btnExcel.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  97 */         JFrameListaFacturacion.this.btnExcelActionPerformed(arg0);
/*     */       }
/*     */     });
/* 100 */     this.panelGral.add(this.btnExcel);
/* 101 */     this.btnExcel.setVisible(false);
/*     */ 
/* 103 */     this.tabla.clearSelection();
/*     */ 
/* 106 */     this.spListaObras.setBounds(560, 130, 200, 200);
/* 107 */     this.spListaObras.setViewportView(this.listaObras);
/*     */ 
/* 109 */     this.listaObras.setListData(BuscadorObraSocial.findAll().toArray());
/* 110 */     this.listaObras
/* 111 */       .setSelectionMode(2);
/*     */ 
/* 113 */     this.listaMedicos.setBounds(560, 10, 200, 80);
/* 114 */     this.listaMedicos.setListData(
/* 115 */       BuscadorMedicos.getInstance().findAll().toArray());
/* 116 */     this.listaMedicos
/* 117 */       .setSelectionMode(2);
/*     */ 
/* 119 */     this.btnHacerTabla = new JButton("Hacer Tabla.");
/* 120 */     this.panelGral.setLayout(null);
/* 121 */     this.panelGral.add(this.desde);
/* 122 */     this.panelGral.add(this.hasta);
/* 123 */     this.panelGral.add(this.lblDesde);
/* 124 */     this.panelGral.add(this.lblHasta);
/* 125 */     this.panelGral.add(this.lblMedico);
/* 126 */     this.panelGral.add(this.listaMedicos);
/* 127 */     this.panelGral.add(this.btnHacerTabla);
/* 128 */     this.panelGral.add(this.lblOs);
/* 129 */     this.panelGral.add(this.spListaObras);
/*     */ 
/* 131 */     this.lblDesde.setBounds(5, 10, 50, 20);
/* 132 */     this.desde.setBounds(55, 10, 150, 20);
/*     */ 
/* 134 */     this.lblHasta.setBounds(230, 10, 40, 20);
/* 135 */     this.hasta.setBounds(270, 10, 150, 20);
/*     */ 
/* 138 */     this.lblMedico.setBounds(500, 10, 60, 20);
/* 139 */     this.lblOs.setBounds(600, 100, 80, 20);
/*     */ 
/* 142 */     this.btnHacerTabla.setBounds(300, 80, 150, 20);
/* 143 */     this.btnHacerTabla.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 145 */         JFrameListaFacturacion.this.btnActionPerformed(arg0);
/*     */       }
/*     */     });
/* 148 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/* 150 */         JFrameListaFacturacion.this.exitForm(evt);
/*     */       }
/*     */     });
/* 153 */     setResizable(false);
/* 154 */     this.panelGral.add(this.jScrollPane1);
/* 155 */     this.jScrollPane1.setBounds(5, 120, 530, 380);
/* 156 */     this.jScrollPane1.setVisible(false);
/* 157 */     getContentPane().add(this.panelGral);
/* 158 */     pack();
/*     */   }
/*     */ 
/*     */   private void btnExcelActionPerformed(ActionEvent arg0) {
/* 162 */     JFileChooser fc = new JFileChooser();
/* 163 */     fc.setAcceptAllFileFilterUsed(true);
/* 164 */     fc.setFileFilter(new FileFilter()
/*     */     {
/*     */       public boolean accept(File f)
/*     */       {
/* 170 */         return ((f.canWrite()) && (f.getName().length() > 4) && 
/* 168 */           (f.getName()
/* 168 */           .substring(f.getName().length() - 4, 
/* 168 */           f.getName().length()).equalsIgnoreCase(".xls"))) || 
/* 169 */           (f.isDirectory());
/*     */       }
/*     */ 
/*     */       public String getDescription()
/*     */       {
/* 177 */         return "Microsoft Excel (xls)";
/*     */       }
/*     */     });
/* 180 */     fc.showSaveDialog(this);
/*     */ 
/* 182 */     if (fc.getSelectedFile() != null)
/*     */       try {
/* 184 */         ExportExcel exp = new ExportExcel(
/* 185 */           fc.getSelectedFile().getPath(), this.tabla);
/* 186 */         Thread t = new Thread(exp);
/* 187 */         t.start();
/*     */       } catch (Exception e) {
/* 189 */         ExceptionHandler.getInstance().handle(e);
/*     */       }
/*     */   }
/*     */ 
/*     */   private void btnActionPerformed(ActionEvent arg0)
/*     */   {
/* 195 */     this.btnExcel.setVisible(true);
/*     */     try {
/* 197 */       doTable(
/* 198 */         new Timestamp(this.desde.getDateSelectionModel().getLeadSelectionDate().getTime()), 
/* 199 */         new Timestamp(this.hasta.getDateSelectionModel().getLeadSelectionDate().getTime()), 
/* 200 */         (Collection)Arrays.asList(this.listaMedicos.getSelectedValues()), 
/* 201 */         (Collection)Arrays.asList(this.listaObras.getSelectedValues()));
/*     */     } catch (Exception e) {
/* 203 */       ExceptionHandler.getInstance().handle(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void doTable(Timestamp desde, Timestamp hasta, Collection medicos, Collection obrasSociales)
/*     */   {
/* 209 */     Object[] columns = new Object[5];
/* 210 */     columns[0] = "Obra Social";
/* 211 */     columns[1] = "Codigo OS";
/* 212 */     columns[2] = "Practica";
/* 213 */     columns[3] = "Codigo Practica";
/* 214 */     columns[4] = "Cantidad";
/* 215 */     Object[][] dataVector = getDataVector(desde, hasta, medicos, 
/* 216 */       obrasSociales);
/* 217 */     this.tabla.setModel(
/* 218 */       new DefaultTableModel(dataVector, 
/* 218 */       columns) {
/* 219 */       boolean[] canEdit = new boolean[4];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 222 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 225 */     this.tabla.setLayout(null);
/* 226 */     this.tabla.getColumnModel().getColumn(1).setMaxWidth(100);
/* 227 */     this.tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 228 */     this.tabla.getColumnModel().getColumn(1).setMinWidth(10);
/* 229 */     this.tabla.getColumnModel().getColumn(3).setMaxWidth(100);
/* 230 */     this.tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 231 */     this.tabla.getColumnModel().getColumn(3).setMinWidth(10);
/* 232 */     this.tabla.getColumnModel().getColumn(4).setMaxWidth(100);
/* 233 */     this.tabla.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 234 */     this.tabla.getColumnModel().getColumn(4).setMinWidth(10);
/* 235 */     this.jScrollPane1.setViewportView(this.tabla);
/* 236 */     this.jScrollPane1.setVisible(true);
/*     */   }
/*     */ 
/*     */   private Object[][] getDataVector(Date desde, Date hasta, Collection medicos, Collection obrasSociales)
/*     */   {
/* 242 */     Collection col = ReportesService.getListaFacturacion(desde, hasta, 
/* 243 */       medicos, obrasSociales);
/* 244 */     Object[][] dataMat = new Object[col.size()][5];
/* 245 */     int rowIndex = 0;
/* 246 */     Object[] rows = col.toArray();
/* 247 */     for (int i = 0; i < rows.length; i++) {
/* 248 */       Object[] row = (Object[])rows[i];
/* 249 */       dataMat[rowIndex][0] = row[0];
/* 250 */       dataMat[rowIndex][1] = row[1];
/* 251 */       dataMat[rowIndex][2] = row[2];
/* 252 */       dataMat[rowIndex][3] = (row[3] != null ? row[3] : row[4]);
/* 253 */       dataMat[(rowIndex++)][4] = row[5];
/*     */     }
/* 255 */     return dataMat;
/*     */   }
/*     */ 
/*     */   private void exitForm(WindowEvent evt) {
/* 259 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.listas.JFrameListaFacturacion
 * JD-Core Version:    0.6.0
 */