package com.cyrius.turnos.gui.listas;

import com.cyrius.entities.Persona;
import com.cyrius.entities.TipoDocumento;
import com.cyrius.searchers.BuscadorPersona;
import com.framework.utils.StringUtils;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.*;



import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class JDialogTablaPersonas extends JDialog
{
  public static short TRAER = 0;

  public static short VER = 1;

  private int lengthName = 0;
  private short estado;
  private JPanel PanelGral;
  private JScrollPane jScrollPane1;
  private JTable jTable1;
  private TablaPersonasSelectionAction action;

  public JDialogTablaPersonas(short estado, TablaPersonasSelectionAction action,
                              String nombre, String apellido, String dni,
                              JFrame frame)
  {
    super(frame);
    this.action = action;
    this.estado = estado;
    initComponents(nombre, apellido, dni);
    initFrame();
  }

  private void initFrame() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int resAncho = (int)screenSize.getWidth();
    int resAlto = (int)screenSize.getHeight();
    setBounds(resAncho / 2 - 398, resAlto / 2 - 278, 765, 556);
    setTitle("Nuevo Turno");
  }

  private Object[][] getMatrix(String nombre, String apellido, String dni) {
    Collection v;
      if(StringUtils.isNotEmpty(dni)) {
          v = BuscadorPersona.getInstance().findByDni(dni);
      } else {
          v = BuscadorPersona.getInstance().findByNombreApellido(
              nombre, apellido);
      }

    Object[][] mat = new Object[v.size()][6];
    Iterator it = v.iterator();
    int i = 0;

    while (it.hasNext()) {
      Persona pac = (Persona)it.next();
      mat[i][0] = pac;
      if (pac.getTipoDocumento() != null && pac.getDocumento() != null) {
          mat[i][1] =
              (pac.getTipoDocumento().getDescripcion() + ": " +
              pac.getDocumento());
      }
      mat[i][2] = pac.getCalle();
      mat[i][3] = pac.getNumero();
      mat[i][4] = pac.getCiudad();
      mat[i][5] = pac.getTelefono();

      if (pac.toString().length() > this.lengthName) {
        this.lengthName = pac.toString().length();
      }

      i++;
    }

    return mat;
  }

  private void initComponents(String nombre, String apellido, String dni) {
    this.PanelGral = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.jTable1 = new JTable();
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        JDialogTablaPersonas.this.exitForm(evt);
      }
    });
    this.PanelGral.setLayout(new BorderLayout());
    this.jTable1.setModel(
      new DefaultTableModel(getMatrix(nombre, apellido, dni), new String[] { "Nombre",
      "Documento", "Calle", "Numero", "Ciudad", "Tel." }) {
      boolean[] canEdit = new boolean[6];

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.jTable1.getColumnModel().getColumn(0).setMaxWidth(this.lengthName * 15);
    this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(this.lengthName * 8);
    this.jTable1.getColumnModel().getColumn(0).setMinWidth(this.lengthName * 7);
    this.jTable1.getColumnModel().setColumnMargin(10);
    this.jTable1.setLayout(null);
    this.jTable1.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent arg0) {
        JDialogTablaPersonas.this.mouseDoubleClick(arg0);
      }

      public void mouseEntered(MouseEvent arg0)
      {
      }

      public void mouseExited(MouseEvent arg0)
      {
      }

      public void mousePressed(MouseEvent arg0)
      {
      }

      public void mouseReleased(MouseEvent arg0)
      {
      }
    });
    this.jScrollPane1.setViewportView(this.jTable1);
    this.PanelGral.add(this.jScrollPane1);
    getContentPane().add(this.PanelGral);
    pack();
  }

  private void mouseDoubleClick(MouseEvent arg0) {
    if ((this.estado == TRAER) && 
      (arg0.getClickCount() == 2)) {
      this.action.executeAction(
        (Persona)this.jTable1
        .getValueAt(this.jTable1.getSelectedRow(), 0));
      setVisible(false);
      this.jTable1.clearSelection();
    }
  }

  private void exitForm(WindowEvent evt)
  {
    setVisible(false);
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.listas.JDialogTablaPersonas
 * JD-Core Version:    0.6.0
 */