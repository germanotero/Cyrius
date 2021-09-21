package com.cyrius.turnos.gui.listas;

import java.awt.Dimension;
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
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.cyrius.entities.Medico;
import com.cyrius.entities.ObraSocial;
import com.cyrius.searchers.BuscadorMedicos;
import com.cyrius.searchers.BuscadorObraSocial;
import com.cyrius.searchers.ReportesService;
import com.cyrius.utils.ExportExcel;
import com.cyrius.utils.prints.JPrintTable;
import com.framework.exceptions.ExceptionHandler;
import com.standbysoft.datepicker.JDatePicker;

public class JFrameListaFacturacion extends JFrame
{
  private JPanel panelGral;
  private JScrollPane jScrollPane1;
  private JPrintTable tabla;
  private JDatePicker desde;
  private JDatePicker hasta;
  private JList<Medico> listaMedicos;
  private JLabel lblDesde;
  private JLabel lblHasta;
  private JLabel lblMedico;
  private JButton btnHacerTabla;
  private JLabel lblOs;
  private JButton btnExcel;
  private JScrollPane spListaObras = new JScrollPane();
  private JList<ObraSocial> listaObras;

  public JFrameListaFacturacion()
    throws Exception
  {
    initComponents();
    initFrame();
  }

  private void initFrame() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int resAncho = (int)screenSize.getWidth();
    int resAlto = (int)screenSize.getHeight();
    setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 780, 540);
    setTitle("Lista de turnos");
  }

  private void initComponents() {
    this.panelGral = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.tabla = new JPrintTable();
    this.desde = new JDatePicker();
    this.hasta = new JDatePicker();
    this.lblDesde = new JLabel("Desde: ");
    this.lblHasta = new JLabel("Hasta: ");
    this.lblMedico = new JLabel("Medico: ");
    this.lblOs = new JLabel("Obra Social: ");
    this.btnExcel = new JButton("Grabar como archivo Excel");
    this.listaObras = new JList<ObraSocial>();
    this.listaMedicos = new JList<Medico>();
    this.btnExcel.setBounds(10, 80, 250, 20);
    this.btnExcel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JFrameListaFacturacion.this.btnExcelActionPerformed(arg0);
      }
    });
    this.panelGral.add(this.btnExcel);
    this.btnExcel.setVisible(false);

    this.tabla.clearSelection();

    this.spListaObras.setBounds(560, 130, 200, 200);
    this.spListaObras.setViewportView(this.listaObras);

    this.listaObras.setListData(BuscadorObraSocial.findAll().toArray(new ObraSocial[]{}));
    this.listaObras
      .setSelectionMode(2);

    this.listaMedicos.setBounds(560, 10, 200, 80);
    this.listaMedicos.setListData(BuscadorMedicos.getInstance().findAll().toArray(new Medico[]{}));
    this.listaMedicos
      .setSelectionMode(2);

    this.btnHacerTabla = new JButton("Hacer Tabla.");
    this.panelGral.setLayout(null);
    this.panelGral.add(this.desde);
    this.panelGral.add(this.hasta);
    this.panelGral.add(this.lblDesde);
    this.panelGral.add(this.lblHasta);
    this.panelGral.add(this.lblMedico);
    this.panelGral.add(this.listaMedicos);
    this.panelGral.add(this.btnHacerTabla);
    this.panelGral.add(this.lblOs);
    this.panelGral.add(this.spListaObras);

    this.lblDesde.setBounds(5, 10, 50, 20);
    this.desde.setBounds(55, 10, 150, 20);

    this.lblHasta.setBounds(230, 10, 40, 20);
    this.hasta.setBounds(270, 10, 150, 20);

    this.lblMedico.setBounds(500, 10, 60, 20);
    this.lblOs.setBounds(600, 100, 80, 20);

    this.btnHacerTabla.setBounds(300, 80, 150, 20);
    this.btnHacerTabla.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JFrameListaFacturacion.this.buildBillingTable();
      }
    });
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        JFrameListaFacturacion.this.exitForm(evt);
      }
    });
    setResizable(false);
    this.panelGral.add(this.jScrollPane1);
    this.jScrollPane1.setBounds(5, 120, 530, 380);
    this.jScrollPane1.setVisible(false);
    getContentPane().add(this.panelGral);
    pack();
  }

  private void btnExcelActionPerformed(ActionEvent arg0) {
    JFileChooser fc = new JFileChooser();
    fc.setAcceptAllFileFilterUsed(true);
    fc.setFileFilter(new FileFilter()
    {
      public boolean accept(File f)
      {
        return ((f.canWrite()) && (f.getName().length() > 4) &&
          (f.getName()
          .substring(f.getName().length() - 4,
          f.getName().length()).equalsIgnoreCase(".xls"))) ||
          (f.isDirectory());
      }

      public String getDescription()
      {
        return "Microsoft Excel (xls)";
      }
    });
    fc.showSaveDialog(this);

    if (fc.getSelectedFile() != null)
      try {
        ExportExcel exp = new ExportExcel(
          fc.getSelectedFile().getPath(), this.tabla);
        Thread t = new Thread(exp);
        t.start();
      } catch (Exception e) {
        ExceptionHandler.getInstance().handle(e);
      }
  }

  private void buildBillingTable()
  {
    this.btnExcel.setVisible(true);
    try {
        long since = this.desde.getDateSelectionModel().getLeadSelectionDate().getTime();
        long to = this.hasta.getDateSelectionModel().getLeadSelectionDate().getTime();

        List selectedDoctors = this.listaMedicos.getSelectedValuesList();
        List selectedOSs = this.listaObras.getSelectedValuesList();
        if (selectedDoctors == null || selectedDoctors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar doctores", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (selectedOSs == null || selectedOSs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta Obras Sociales", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        doTable(
                new Timestamp(since),
                new Timestamp(to),
                selectedDoctors,
                selectedOSs);

    } catch (Exception e) {
      ExceptionHandler.getInstance().handle(e);
    }
  }

  private void doTable(Timestamp desde, Timestamp hasta, Collection medicos, Collection obrasSociales)
  {
    Object[] columns = new Object[5];
    columns[0] = "Obra Social";
    columns[1] = "Codigo OS";
    columns[2] = "Practica";
    columns[3] = "Codigo Practica";
    columns[4] = "Cantidad";
    Object[][] dataVector = getDataVector(desde, hasta, medicos,
      obrasSociales);
    this.tabla.setModel(
      new DefaultTableModel(dataVector,
      columns) {
      boolean[] canEdit = new boolean[4];

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return this.canEdit[columnIndex];
      }
    });
    this.tabla.setLayout(null);
    this.tabla.getColumnModel().getColumn(1).setMaxWidth(100);
    this.tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
    this.tabla.getColumnModel().getColumn(1).setMinWidth(10);
    this.tabla.getColumnModel().getColumn(3).setMaxWidth(100);
    this.tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
    this.tabla.getColumnModel().getColumn(3).setMinWidth(10);
    this.tabla.getColumnModel().getColumn(4).setMaxWidth(100);
    this.tabla.getColumnModel().getColumn(4).setPreferredWidth(70);
    this.tabla.getColumnModel().getColumn(4).setMinWidth(10);
    this.jScrollPane1.setViewportView(this.tabla);
    this.jScrollPane1.setVisible(true);
  }

  private Object[][] getDataVector(Date desde, Date hasta, Collection medicos, Collection obrasSociales)
  {
    Collection col = ReportesService.getListaFacturacion(desde, hasta,
      medicos, obrasSociales);
    Object[][] dataMat = new Object[col.size()][5];
    int rowIndex = 0;
    Object[] rows = col.toArray();
    for (int i = 0; i < rows.length; i++) {
      Object[] row = (Object[])rows[i];
      dataMat[rowIndex][0] = row[0];
      dataMat[rowIndex][1] = row[1];
      dataMat[rowIndex][2] = row[2];
      dataMat[rowIndex][3] = (row[3] != null ? row[3] : row[4]);
      dataMat[(rowIndex++)][4] = row[5];
    }
    return dataMat;
  }

  private void exitForm(WindowEvent evt) {
    setVisible(false);
  }
}
