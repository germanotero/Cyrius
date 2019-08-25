package com.cyrius.turnos.gui.verTurno;

import com.cyrius.turnos.gui.HorariosABMFactory;
import com.cyrius.turnos.gui.abms.MedicoABMFactory;
import com.cyrius.turnos.gui.abms.ObraSocialABMFactory;
import com.cyrius.turnos.gui.abms.PreparacionABMFactory;
import com.cyrius.turnos.gui.listas.JFrameListaControl;
import com.cyrius.turnos.gui.listas.JFrameListaFacturacion;
import com.cyrius.turnos.gui.practicas.noNomencladas.PracticaNoNomencladaABMFactory;
import com.cyrius.turnos.gui.practicas.nomencladas.PracticaNomencladaABMFactory;
import com.framework.abstractfactorys.AbstractUseCaseFactory;
import com.framework.abstractfactorys.FrameworkUseCaseFactory;
import com.framework.exceptions.ExceptionHandler;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;

public class TurnosFrame extends JFrame {
	private VerTurnosJPanel verTurnos;
	private JMenuBar jMenuBar1;
	private JMenuItem miListaFac;
	private JMenuItem miListaControl;
	private JMenu menuListas;
	private JMenu administradores;
	private JMenu menuPracticas;
	private JMenuItem miListaPacientes;
	private JMenuItem miPracNoNom;
	private JMenuItem miPracNom;
	private JMenuItem administrarMedicos;
	private JMenuItem miModificarOs;
	private JMenuItem miBorrarTurnos;
	private Container parent;
	private AbstractButton administrarHorarios;

	public TurnosFrame(Container parent) {
		this.parent = parent;
		initComponents();
		this.verTurnos.setBounds(0, 0, 750, 670);
		getContentPane().add(this.verTurnos);
		initFrame();
		setVisible(true);
		this.parent.setVisible(false);
	}

	private void initFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int resAncho = (int) screenSize.getWidth();
		int resAlto = (int) screenSize.getHeight();
		setBounds(resAncho / 2 - 400, resAlto / 2 - 285, 750, 580);
	}

	private void initComponents() {
		this.verTurnos = new VerTurnosJPanel(this);
		this.jMenuBar1 = new JMenuBar();
		this.administradores = new JMenu();
		this.administrarMedicos = new JMenuItem();
		this.administrarHorarios = new JMenuItem();
		this.menuListas = new JMenu();
		this.miListaFac = new JMenuItem();
		this.miListaControl = new JMenuItem();
		this.menuPracticas = new JMenu();
		this.miPracNoNom = new JMenuItem();
		this.miPracNom = new JMenuItem();
		this.miModificarOs = new JMenuItem();

		this.miBorrarTurnos = new JMenuItem("Borrar Turnos Pasados");
		this.miListaPacientes = new JMenuItem("Listado de Pacientes");
		this.miBorrarTurnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TurnosFrame.this.miBorrarTurnosActionPerformed(arg0);
			}
		});
		this.miListaPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TurnosFrame.this.miListaPacientesActionPerformed(arg0);
			}
		});
		getContentPane().setLayout(null);
		setDefaultCloseOperation(0);
		setTitle("Turnos");
		setResizable(false);
		this.administradores.setText("Administradores");
		this.administrarMedicos.setText("Medicos");
		this.administrarMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TurnosFrame.this.miModificarMedicoActionPerformed(evt);
			}
		});
		this.administradores.add(this.administrarMedicos);

		this.administrarHorarios.setText("Horarios");
		this.administrarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TurnosFrame.this.miModificarHorariosPerformed(evt);
			}
		});
		this.administradores.add(this.administrarHorarios);
		this.jMenuBar1.add(this.administradores);
		this.jMenuBar1.setPreferredSize(new Dimension(631, 22));
		this.menuListas.setText("Listados");
		this.menuListas.add(this.miListaFac);
		this.menuListas.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
				TurnosFrame.this.mouseEnter(TurnosFrame.this.menuListas);
			}

			public void mouseExited(MouseEvent arg0) {
				TurnosFrame.this.mouseExit(TurnosFrame.this.menuListas);
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
		this.miListaFac.setText("Lista de Facturación");
		this.miListaFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TurnosFrame.this.miListaFacActionPerformed(arg0);
			}
		});
		this.jMenuBar1.add(this.menuListas);
		this.miListaControl.setText("Lista de Control");
		this.miListaControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TurnosFrame.this.miListaControlActionPerformed(arg0);
			}
		});
		this.menuListas.add(this.miListaControl);
		this.menuPracticas.setText("Prácticas");
		this.menuPracticas.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
				TurnosFrame.this.mouseEnter(TurnosFrame.this.menuPracticas);
			}

			public void mouseExited(MouseEvent arg0) {
				TurnosFrame.this.mouseExit(TurnosFrame.this.menuPracticas);
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
		this.miPracNoNom.setText("Prácticas no Nomencladas");
		this.miPracNoNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TurnosFrame.this.miPracNoNomActionPerformed(evt);
			}
		});
		this.menuPracticas.add(this.miPracNoNom);
		this.miPracNom.setText("Prácticas Nomencladas");
		this.miPracNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TurnosFrame.this.miPracNomActionPerformed(evt);
			}
		});
		this.menuPracticas.add(this.miPracNom);
		this.administradores.add(this.menuPracticas);
		this.miModificarOs.setText("Obras Sociales");
		this.administradores.add(this.miModificarOs);
		this.miModificarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TurnosFrame.this.miMordificarOsActionPerformed(evt);
			}
		});
		JMenuItem preparaciones = new JMenuItem("Preparaciones");
		this.administradores.add(preparaciones);
		preparaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TurnosFrame.this.launchUseCase(PreparacionABMFactory.class);
			}
		});
		setJMenuBar(this.jMenuBar1);
		setDefaultCloseOperation(3);
		pack();
	}

	protected void miModificarHorariosPerformed(ActionEvent evt) {
		launchUseCase(HorariosABMFactory.class);
	}

	private void miListaControlActionPerformed(ActionEvent arg0) {
		JFrameListaControl list = null;
		try {
			list = new JFrameListaControl();
		} catch (Exception e) {
			ExceptionHandler.getInstance().handle(e);
			return;
		}
		list.setVisible(true);
	}

	private void miListaFacActionPerformed(ActionEvent arg0) {
		JFrameListaFacturacion list = null;
		try {
			list = new JFrameListaFacturacion();
		} catch (Exception e) {
			ExceptionHandler.getInstance().handle(e);
			return;
		}
		list.setVisible(true);
	}

	private void mouseEnter(JMenu menu) {
		menu.setBorder(new BevelBorder(0));
	}

	private void mouseExit(JMenu menu) {
		menu.setBorder(null);
	}

	private void miMordificarOsActionPerformed(ActionEvent evt) {
		launchUseCase(ObraSocialABMFactory.class);
	}

	private void launchUseCase(Class<? extends AbstractUseCaseFactory> useCase) {
		try {
			setCursor(new Cursor(3));
			FrameworkUseCaseFactory
					.launchUseCase((AbstractUseCaseFactory) FrameworkUseCaseFactory.createChildUseCase(useCase, this));
		} catch (Throwable e) {
			ExceptionHandler.getInstance().handle(e);
		} finally {
			setCursor(new Cursor(0));
		}
	}

	private void miPracNoNomActionPerformed(ActionEvent evt) {
		launchUseCase(PracticaNoNomencladaABMFactory.class);
	}

	private void miPracNomActionPerformed(ActionEvent evt) {
		launchUseCase(PracticaNomencladaABMFactory.class);
	}

	private void miModificarMedicoActionPerformed(ActionEvent evt) {
		try {
			FrameworkUseCaseFactory.launchUseCase(
					(AbstractUseCaseFactory) FrameworkUseCaseFactory.createChildUseCase(MedicoABMFactory.class, this));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void miListaPacientesActionPerformed(ActionEvent arg0) {
		jDialogBuscarPersona inst = new jDialogBuscarPersona(this);
		inst.setVisible(true);
	}

	private void miRecordatorioActionPerformed(ActionEvent evt) {
	}

	private void miBorrarTurnosActionPerformed(ActionEvent arg0) {
		DialogBorrarTurnos conf = new DialogBorrarTurnos(this);
		Thread borrarTurnos = new Thread(conf);
		borrarTurnos.run();
		conf.setVisible(true);
	}
}
