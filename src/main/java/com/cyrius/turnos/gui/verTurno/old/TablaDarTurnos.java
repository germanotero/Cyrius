package com.cyrius.turnos.gui.verTurno.old;

import java.awt.Color;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.cyrius.entities.HoraMinuto;
import com.cyrius.entities.Medico;
import com.cyrius.entities.Turno;
import com.cyrius.searchers.BuscadorTurnos;
import com.cyrius.services.HorarioService;
import com.framework.entities.DateLapse;

public class TablaDarTurnos extends JTable {
	private static final int CANTTURNOSMANANA = 31;
	private static final int CANTTURNOSTARDE = 43;
	public static short TARDE = 2;

	public static short MANANA = 1;

	private static String libre = "                                           Libre";
	private GregorianCalendar fecha;
	private Medico medico;
	private short estado;

	public TablaDarTurnos(short estado) {
		this.estado = estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
		cargarMatrix();
		initComponents();
	}

	private Object[][] cargarMatrix() {
		Collection v = null;
		Object[][] mat = initMatrix();
		GregorianCalendar fechaFin = new GregorianCalendar();
		fechaFin.setTimeInMillis(this.fecha.getTimeInMillis());

		if (this.estado == MANANA) {
			HoraMinuto inicioTurnoManana = HorarioService.getHorarios().getInicioTurnoManana();
			this.fecha.set(11, inicioTurnoManana.getHora().intValue());
			this.fecha.set(12, inicioTurnoManana.getMinutos().intValue());
			HoraMinuto finTurnoManana = HorarioService.getHorarios().getFinTurnoManana();
			fechaFin.set(11, finTurnoManana.getHora().intValue());
			fechaFin.set(12, finTurnoManana.getMinutos().intValue());
		} else {
			HoraMinuto inicioTurnoTarde = HorarioService.getHorarios().getInicioTurnoTarde();
			this.fecha.set(11, inicioTurnoTarde.getHora().intValue());
			this.fecha.set(12, inicioTurnoTarde.getMinutos().intValue());
			HoraMinuto finTurnoTarde = HorarioService.getHorarios().getFinTurnoTarde();
			fechaFin.set(11, finTurnoTarde.getHora().intValue());
			fechaFin.set(12, finTurnoTarde.getMinutos().intValue());
		}

		v = BuscadorTurnos.getInstance().buscarTurnos(new DateLapse(this.fecha.getTime(), fechaFin.getTime()),
				this.medico);

		Iterator it = v.iterator();
		int max = 0;
		if (this.estado == MANANA)
			max = CANTTURNOSMANANA;
		else {
			max = CANTTURNOSTARDE;
		}

		while (it.hasNext()) {
			Turno tur = (Turno) it.next();
			int i = 0;

			while (i < max) {
				StringTokenizer stk = new StringTokenizer((String) mat[i][0], ":");
				Integer hora = new Integer(stk.nextToken());
				Integer mins = new Integer(stk.nextToken());

				if ((tur.getHora().getHours() == hora.intValue()) && (tur.getHora().getMinutes() == mins.intValue())) {
					mat[i][1] = tur;
				}

				i++;
			}
		}

		return mat;
	}

	private Object[][] initMatrix() {
		int i = 0;

		int max = 0;
		int hora;
		int mins;
		Object[][] mat;
		if (this.estado == MANANA) {
			HoraMinuto inicioTurnoManana = HorarioService.getHorarios().getInicioTurnoManana();
			hora = inicioTurnoManana.getHora();
			mins = inicioTurnoManana.getMinutos();
			mat = new Object[CANTTURNOSMANANA][3];
			max = CANTTURNOSMANANA;
		} else {
			HoraMinuto inicioTurnoTarde = HorarioService.getHorarios().getInicioTurnoTarde();
			hora = inicioTurnoTarde.getHora();
			mins = inicioTurnoTarde.getMinutos();
			mat = new Object[CANTTURNOSTARDE][3];
			max = CANTTURNOSTARDE;
		}
		while (i < max) {
			mat[i][0] = new String(hora + ":" + mins + "0");
			mat[i][1] = libre;
			i++;

			if (mins < 5) {
				mins++;
			} else {
				hora++;
				mins = 0;
			}
		}

		return mat;
	}

	private void initComponents() {
		setBackground(new Color(200, 200, 200));
		setSelectionBackground(new Color(200, 0, 150));
		setBackground(new Color(200, 200, 200));

		setModel(new DefaultTableModel(cargarMatrix(), new String[] { "Hora", "Tipo de Turno dado" }) {
			boolean[] canEdit = new boolean[2];

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return this.canEdit[columnIndex];
			}
		});
		setLayout(null);
		getColumnModel().getColumn(0).setMaxWidth(70);
		getColumnModel().getColumn(0).setPreferredWidth(50);
		getColumnModel().getColumn(0).setMinWidth(35);
		getColumnModel().setColumnMargin(10);
		setBorder(new SoftBevelBorder(0));
		setSelectionMode(0);
	}

	protected void setMedico(Medico idMedico) {
		this.medico = idMedico;
	}

	protected void setDay(GregorianCalendar fecha) {
		this.fecha = fecha;
		cargarMatrix();
		initComponents();
	}

	public GregorianCalendar getFecha() {
		return this.fecha;
	}

	protected Collection getSelectedHours() {
		Vector v = new Vector(0);
		int i = 0;
		int[] selected = getSelectedRows();

		while (i < getSelectedRowCount()) {
			GregorianCalendar hSelec = new GregorianCalendar();
			hSelec.setTimeInMillis(this.fecha.getTimeInMillis());

			StringTokenizer stk = new StringTokenizer((String) getValueAt(selected[i], 0), ":");
			String hora = stk.nextToken();
			String min = stk.nextToken();
			Integer g = new Integer(hora);
			hSelec.set(11, g.intValue());
			hSelec.set(12, new Integer(min).intValue());
			v.addElement(hSelec);
			i++;
		}

		return v;
	}

	public boolean isSelected() {
		return getSelectedRowCount() > 0;
	}

	protected boolean hayError() {
		boolean error = false;
		int i = 0;
		int[] selected = getSelectedRows();

		if (getSelectedRowCount() == 0) {
			return true;
		}

		while (i < getSelectedRowCount()) {
			if ((getValueAt(selected[i], 1) instanceof Turno)) {
				error = true;
			}
			i++;
		}

		return error;
	}

	protected GregorianCalendar getSelectedHour() {
		GregorianCalendar hSelec = new GregorianCalendar();
		hSelec.setTimeInMillis(this.fecha.getTimeInMillis());
		StringTokenizer stk = new StringTokenizer((String) getValueAt(getSelectedRow(), 0), ":");
		hSelec.set(11, new Integer(stk.nextToken()).intValue());
		hSelec.set(12, new Integer(stk.nextToken()).intValue());

		return hSelec;
	}
}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar Qualified Name:
 * com.cyrius.turnos.gui.verTurno.old.TablaDarTurnos JD-Core Version: 0.6.0
 */