/*     */ package com.cyrius.turnos.gui.listas;
/*     */ 
/*     */ import com.cyrius.entities.Persona;
/*     */ import com.cyrius.entities.TipoDocumento;
/*     */ import com.cyrius.searchers.BuscadorPersona;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class JDialogTablaPersonas extends JDialog
/*     */ {
/*  24 */   public static short TRAER = 0;
/*     */ 
/*  26 */   public static short VER = 1;
/*     */ 
/*  28 */   private int lengthName = 0;
/*     */   private short estado;
/*     */   private JPanel PanelGral;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable jTable1;
/*     */   private TablaPersonasSelectionAction action;
/*     */ 
/*     */   public JDialogTablaPersonas(short estado, TablaPersonasSelectionAction action, String nombre, String apellido)
/*     */   {
/*  44 */     this.action = action;
/*  45 */     this.estado = estado;
/*  46 */     initComponents(nombre, apellido);
/*  47 */     initFrame();
/*     */   }
/*     */ 
/*     */   private void initFrame() {
/*  51 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  52 */     int resAncho = (int)screenSize.getWidth();
/*  53 */     int resAlto = (int)screenSize.getHeight();
/*  54 */     setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 765, 556);
/*  55 */     setTitle("Nuevo Turno");
/*     */   }
/*     */ 
/*     */   private Object[][] getMatrix(String nombre, String apellido) {
/*  59 */     Collection v = BuscadorPersona.getInstance().findByNombreApellido(
/*  60 */       nombre, apellido);
/*     */ 
/*  62 */     Object[][] mat = new Object[v.size()][6];
/*  63 */     Iterator it = v.iterator();
/*  64 */     int i = 0;
/*     */ 
/*  66 */     while (it.hasNext()) {
/*  67 */       Persona pac = (Persona)it.next();
/*  68 */       mat[i][0] = pac;
/*  69 */       mat[i][1] = 
/*  70 */         (pac.getTipoDocumento().getDescripcion() + ": " + 
/*  70 */         pac.getDocumento());
/*  71 */       mat[i][2] = pac.getCalle();
/*  72 */       mat[i][3] = pac.getNumero();
/*  73 */       mat[i][4] = pac.getCiudad();
/*  74 */       mat[i][5] = pac.getTelefono();
/*     */ 
/*  76 */       if (pac.toString().length() > this.lengthName) {
/*  77 */         this.lengthName = pac.toString().length();
/*     */       }
/*     */ 
/*  80 */       i++;
/*     */     }
/*     */ 
/*  83 */     return mat;
/*     */   }
/*     */ 
/*     */   private void initComponents(String nombre, String apellido) {
/*  87 */     this.PanelGral = new JPanel();
/*  88 */     this.jScrollPane1 = new JScrollPane();
/*  89 */     this.jTable1 = new JTable();
/*  90 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  92 */         JDialogTablaPersonas.this.exitForm(evt);
/*     */       }
/*     */     });
/*  95 */     this.PanelGral.setLayout(new BorderLayout());
/*  96 */     this.jTable1.setModel(
/*  98 */       new DefaultTableModel(getMatrix(nombre, apellido), new String[] { "Nombre", 
/*  98 */       "Documento", "Calle", "Numero", "Ciudad", "Tel." }) {
/*  99 */       boolean[] canEdit = new boolean[6];
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */       {
/* 103 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 106 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(this.lengthName * 15);
/* 107 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(this.lengthName * 8);
/* 108 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(this.lengthName * 7);
/* 109 */     this.jTable1.getColumnModel().setColumnMargin(10);
/* 110 */     this.jTable1.setLayout(null);
/* 111 */     this.jTable1.addMouseListener(new MouseListener() {
/*     */       public void mouseClicked(MouseEvent arg0) {
/* 113 */         JDialogTablaPersonas.this.mouseDoubleClick(arg0);
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseExited(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mousePressed(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseReleased(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 128 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 129 */     this.PanelGral.add(this.jScrollPane1);
/* 130 */     getContentPane().add(this.PanelGral);
/* 131 */     pack();
/*     */   }
/*     */ 
/*     */   private void mouseDoubleClick(MouseEvent arg0) {
/* 135 */     if ((this.estado == TRAER) && 
/* 136 */       (arg0.getClickCount() == 2)) {
/* 137 */       this.action.executeAction(
/* 138 */         (Persona)this.jTable1
/* 138 */         .getValueAt(this.jTable1.getSelectedRow(), 0));
/* 139 */       setVisible(false);
/* 140 */       this.jTable1.clearSelection();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void exitForm(WindowEvent evt)
/*     */   {
/* 146 */     setVisible(false);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.listas.JDialogTablaPersonas
 * JD-Core Version:    0.6.0
 */