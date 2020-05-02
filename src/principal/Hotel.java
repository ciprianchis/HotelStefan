package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Frame;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class Hotel extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNombreApp;
	private JLabel lblCerrar;
	private JLabel lblMinimizar;
	private JLabel lblMaximizar;
	private JLabel lblReserva;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JButton btnBuscar;
	private JButton btnBorrarBusqueda;
	private JButton btnAsignar;
	private JButton btnSalir;
	private boolean maximizado = false;
	private JTextArea txtrFechaEntrada;
	private JTextField textFieldDiaEntrada;
	private JTextArea textAreaDiaMesEntrada;
	private JTextField textFieldMesEntrada;
	private JTextArea textAreaMesAnoEntrada;
	private JTextField textFieldAnoEntrada;
	private JTextArea txtrFechaSalida;
	private JTextField textFieldDiaSalida;
	private JTextArea textAreaDiaMesSalida;
	private JTextField textFieldMesSalida;
	private JTextArea textAreaMesAnoSalida;
	private JTextField textFieldAnoSalida;
	private OperacionReserva operacion = new OperacionReserva();
	private JTextArea txtAreaReservas;
	private boolean fecha = false;
	private boolean fechaEntr = false;
	private boolean fechaSalid = false;
	private ArrayList<Reserva> listaReservas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hotel() {
		initApp();
		operacion.cargarReservas();
		cargarReservas(operacion.cargarArrayHotel());
	}
	
	public void cargarReservas(String reservas) {
		txtAreaReservas.setText(reservas);
	}

	private class LblCerrarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblCerrar.setIcon(new ImageIcon(".\\recursos\\closeSelected.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblCerrar.setIcon(new ImageIcon(".\\recursos\\close.png"));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	} //

	private class LblMinimizarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimizeSelected.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimize.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			setState(JFrame.ICONIFIED);
		}
	}

	private class LblMaximizarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximizeSelected.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximize.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if (!maximizado) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				maximizado = true;
			} else {
				setExtendedState(JFrame.NORMAL);
				maximizado = false;
			}

		}
	}

	private class BtnBorrarBusquedaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtCodigo.setText("Codigo");
			txtNombre.setText("Nombre");
			txtApellidos.setText("Apellidos");
			txtAreaReservas.setText("");
		}
	}

	private class BtnAsignarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Habitacion asignada");
		}
	}
	
	private class BtnBuscarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			conseguirTexto();
		}
	}
	
	/** Método para filtrar el fichero en busca de variables */
	
	private void conseguirTexto() {
		boolean porNombre, porApellido;
		comprobarFecha();
		int n = 0;
		listaReservas = operacion.devolverArray();
		ArrayList<Reserva> dumpArray = new ArrayList<Reserva>();
		String nombre = txtNombre.getText();
		String apellido = txtApellidos.getText();
		String contenido = "";
		
		if (nombre.equals("") || nombre.equals("Nombre")) {
			porNombre = false;
		} else {
			porNombre = true;
		}
		if (apellido.equals("") || apellido.equals("Apellidos")) {
			porApellido = false;
		} else {
			porApellido = true;
		}
		
		if (porNombre) {
			for (Reserva res : listaReservas) {
				if (res.getNombreReserva().equals(nombre))
					dumpArray.add(res);
			}
			listaReservas = new ArrayList<Reserva>();
			listaReservas = dumpArray;
			dumpArray = new ArrayList<Reserva>();
		}
		if (porApellido) {
			for (Reserva res : listaReservas) {
				if (res.getApellidosReserva().equals(apellido))
					dumpArray.add(res);
			}
			listaReservas = new ArrayList<Reserva>();
			listaReservas = dumpArray;
			dumpArray = new ArrayList<Reserva>();
		}
		if (fecha) {
			System.out.println("jestem w fch");
			String fechaEntrString = (textFieldDiaEntrada.getText()+"/"+textFieldMesEntrada.getText()+"/"+textFieldAnoEntrada.getText());
			String fechaSalidString = (textFieldDiaSalida.getText()+"/"+textFieldMesSalida.getText()+"/"+textFieldAnoSalida.getText());
			for (Reserva res : listaReservas) {
				if (res.getFechaEntrada().equals(fechaEntrString) && res.getFechaSalida().equals(fechaSalidString))
					dumpArray.add(res);
			}
			listaReservas = new ArrayList<Reserva>();
			listaReservas = dumpArray;
			dumpArray = new ArrayList<Reserva>();
		} else {
			comprobarFechaEntrSalid();
			if (fechaEntr) {
				System.out.println("jestem w fch entr");
				String fechaEntrString = (textFieldDiaEntrada.getText()+"/"+textFieldMesEntrada.getText()+"/"+textFieldAnoEntrada.getText());
				for (Reserva res : listaReservas) {
					if (res.getFechaEntrada().equals(fechaEntrString))
						dumpArray.add(res);
				}
				listaReservas = new ArrayList<Reserva>();
				listaReservas = dumpArray;
				dumpArray = new ArrayList<Reserva>();
			}
			if (fechaSalid) {
				System.out.println("jestem w fch salid");
				String fechaSalidString = (textFieldDiaSalida.getText()+"/"+textFieldMesSalida.getText()+"/"+textFieldAnoSalida.getText());
				for (Reserva res : listaReservas) {
					if (res.getFechaSalida().equals(fechaSalidString))
						dumpArray.add(res);
				}
				listaReservas = new ArrayList<Reserva>();
				listaReservas = dumpArray;
				dumpArray = new ArrayList<Reserva>();
			}
		}
		Iterator it = listaReservas.iterator();
		while (it.hasNext()) {
			contenido += it.next() + "\n";
		}
		txtAreaReservas.setText(contenido);
	}
	
	/** Método para comprobar la fecha sí los dos campos no están rellenos */
	
	private void comprobarFechaEntrSalid() {
		int diaSalida = 0, mesSalida = 0, anoSalida = 0, diaEntrada = 0, mesEntrada = 0, anoEntrada = 0;
		try {
			diaSalida = Integer.parseInt(textFieldDiaSalida.getText());
			diaEntrada = Integer.parseInt(textFieldDiaEntrada.getText());
			mesSalida = Integer.parseInt(textFieldMesSalida.getText());
			mesEntrada = Integer.parseInt(textFieldMesEntrada.getText());
			anoSalida = Integer.parseInt(textFieldAnoSalida.getText());
			anoEntrada = Integer.parseInt(textFieldAnoEntrada.getText());
		} catch (Exception e) {
		}
		if (comprobarMes(anoSalida, mesSalida, diaSalida)) {
			fechaSalid = true;
		} else {
			fechaSalid = false;
		}
		if (comprobarMes(anoEntrada, mesEntrada, diaEntrada)) {
			fechaEntr = true;
		} else {
			fechaEntr = false;
		}
	}
	
	/** Método para comprobar la fecha sí los dos campos están rellenos */
	
	private void comprobarFecha() {
		int diaSalida = 0, mesSalida = 0, anoSalida = 0, diaEntrada = 0, mesEntrada = 0, anoEntrada = 0;
		try {
			diaSalida = Integer.parseInt(textFieldDiaSalida.getText());
			diaEntrada = Integer.parseInt(textFieldDiaEntrada.getText());
			mesSalida = Integer.parseInt(textFieldMesSalida.getText());
			mesEntrada = Integer.parseInt(textFieldMesEntrada.getText());
			anoSalida = Integer.parseInt(textFieldAnoSalida.getText());
			anoEntrada = Integer.parseInt(textFieldAnoEntrada.getText());
		} catch (Exception e) {
		}
		if (comprobarMes(anoSalida, mesSalida, diaSalida) && comprobarMes(anoEntrada, mesEntrada, diaEntrada)) {
			int mesDiferencia = mesSalida - mesEntrada;
			switch (mesDiferencia) {
			case -11:
				if (anoEntrada == (anoSalida - 1)) {
					int diasDiferencia = 31 - diaEntrada + diaSalida;
					if (diasDiferencia < 32) {
						fecha = true;
					} else {
						fecha = false;
					}
				} else {
					fecha = false;
				}
			case 0:
				if (diaSalida > diaEntrada && anoEntrada == anoSalida) {
					fecha = true;
				} else {
					fecha = false;
				}
				break;
			case 1:
				int diasDiferencia = 0;
				switch (mesEntrada) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					diasDiferencia = 31 - diaEntrada + diaSalida;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					diasDiferencia = 30 - diaEntrada + diaSalida;
					break;
				case 2:
					if (((anoSalida % 4 == 0) && !(anoSalida % 100 == 0)) || (anoSalida % 400 == 0)) {
						diasDiferencia = 29 - diaEntrada + diaSalida;
					} else {
						diasDiferencia = 28 - diaEntrada + diaSalida;
					}
					break;
				}
				if (diasDiferencia < 32 && anoEntrada == anoSalida) {
					fecha = true;
				} else {
					fecha = false;
				}
				break;
			default:
				fecha = false;
				break;
			}
		} else {
			fecha = false;
		}

	}
	
	/** Método para comprobar el mes de las fechas*/
	
	private boolean comprobarMes(int ano, int mes, int dia) {
		if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano != 0) {
			switch (mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return true;
			case 4:
			case 6:
			case 9:
			case 11:
				if (dia < 31) {
					return true;
				}
				break;
			case 2:
				if (dia < 29 || ((((ano % 4 == 0) && !(ano % 100 == 0)) || (ano % 400 == 0)) && dia < 30)) {
					return true;
				}
				break;
			}
		}
		return false;

	}

	private class BtnSalirMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			LogIn log = new LogIn();
			log.setVisible(true);
			dispose();
		}
	}
	private class TxtCodigoFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtCodigo.getText();
			if(texto.equals("Codigo")) {
				txtCodigo.setText("");
				txtCodigo.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtCodigo.getText();
			if(texto.equals("")) {
				txtCodigo.setForeground(Color.gray);
				txtCodigo.setText("Codigo");
			}
		}
	}
	private class TxtNombreFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtNombre.getText();
			if(texto.equals("Nombre")) {
				txtNombre.setText("");
				txtNombre.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtNombre.getText();
			if(texto.equals("")) {
				txtNombre.setForeground(Color.gray);
				txtNombre.setText("Nombre");
			}
		}
	}
	private class TxtApellidosFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtApellidos.getText();
			if(texto.equals("Apellidos")) {
				txtApellidos.setText("");
				txtApellidos.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtApellidos.getText();
			if(texto.equals("")) {
				txtApellidos.setForeground(Color.gray);	
				txtApellidos.setText("Apellidos");
			}
		}
	}
	
	/** Método para iniciar todas las variables de la app */
	
	public void initApp() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAsignar = new JButton("Asignar habitacion");
		btnAsignar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAsignar.setFocusable(false);
		btnAsignar.addMouseListener(new BtnAsignarMouseListener());

		btnSalir = new JButton("Salir");
		btnSalir.setFocusable(false);
		btnSalir.addMouseListener(new BtnSalirMouseListener());
		
		txtAreaReservas = new JTextArea();
		txtAreaReservas.setBounds(326, 422, 793, 228);
		contentPane.add(txtAreaReservas);
		
		textFieldDiaSalida = new JTextField();
		textFieldDiaSalida.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldDiaSalida.setColumns(10);
		textFieldDiaSalida.setBackground(Color.WHITE);
		textFieldDiaSalida.setBounds(931, 245, 40, 30);
		contentPane.add(textFieldDiaSalida);
		
		txtrFechaSalida = new JTextArea();
		txtrFechaSalida.setText("Fecha Salida:");
		txtrFechaSalida.setOpaque(false);
		txtrFechaSalida.setForeground(Color.WHITE);
		txtrFechaSalida.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrFechaSalida.setFocusable(false);
		txtrFechaSalida.setEditable(false);
		txtrFechaSalida.setBounds(722, 245, 180, 30);
		contentPane.add(txtrFechaSalida);
		
		textFieldMesSalida = new JTextField();
		textFieldMesSalida.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldMesSalida.setColumns(10);
		textFieldMesSalida.setBackground(Color.WHITE);
		textFieldMesSalida.setBounds(1006, 245, 40, 30);
		contentPane.add(textFieldMesSalida);
		
		textFieldAnoSalida = new JTextField();
		textFieldAnoSalida.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldAnoSalida.setColumns(10);
		textFieldAnoSalida.setBackground(Color.WHITE);
		textFieldAnoSalida.setBounds(1079, 245, 40, 30);
		contentPane.add(textFieldAnoSalida);
		
		textAreaDiaMesSalida = new JTextArea();
		textAreaDiaMesSalida.setText("/");
		textAreaDiaMesSalida.setOpaque(false);
		textAreaDiaMesSalida.setForeground(Color.WHITE);
		textAreaDiaMesSalida.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textAreaDiaMesSalida.setFocusable(false);
		textAreaDiaMesSalida.setEditable(false);
		textAreaDiaMesSalida.setBounds(981, 245, 13, 30);
		contentPane.add(textAreaDiaMesSalida);
		
		textAreaMesAnoSalida = new JTextArea();
		textAreaMesAnoSalida.setText("/");
		textAreaMesAnoSalida.setOpaque(false);
		textAreaMesAnoSalida.setForeground(Color.WHITE);
		textAreaMesAnoSalida.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textAreaMesAnoSalida.setFocusable(false);
		textAreaMesAnoSalida.setEditable(false);
		textAreaMesAnoSalida.setBounds(1056, 245, 13, 30);
		contentPane.add(textAreaMesAnoSalida);
		
		textFieldDiaEntrada = new JTextField();
		textFieldDiaEntrada.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldDiaEntrada.setColumns(10);
		textFieldDiaEntrada.setBackground(Color.WHITE);
		textFieldDiaEntrada.setBounds(931, 176, 40, 30);
		contentPane.add(textFieldDiaEntrada);
		
		textFieldMesEntrada = new JTextField();
		textFieldMesEntrada.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldMesEntrada.setColumns(10);
		textFieldMesEntrada.setBackground(Color.WHITE);
		textFieldMesEntrada.setBounds(1006, 176, 40, 30);
		contentPane.add(textFieldMesEntrada);
		
		textAreaMesAnoEntrada = new JTextArea();
		textAreaMesAnoEntrada.setText("/");
		textAreaMesAnoEntrada.setOpaque(false);
		textAreaMesAnoEntrada.setForeground(Color.WHITE);
		textAreaMesAnoEntrada.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textAreaMesAnoEntrada.setFocusable(false);
		textAreaMesAnoEntrada.setEditable(false);
		textAreaMesAnoEntrada.setBounds(1056, 176, 13, 30);
		contentPane.add(textAreaMesAnoEntrada);
		
		textFieldAnoEntrada = new JTextField();
		textFieldAnoEntrada.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textFieldAnoEntrada.setColumns(10);
		textFieldAnoEntrada.setBackground(Color.WHITE);
		textFieldAnoEntrada.setBounds(1079, 176, 40, 30);
		contentPane.add(textFieldAnoEntrada);
		
		txtrFechaEntrada = new JTextArea();
		txtrFechaEntrada.setText("Fecha Entrada:");
		txtrFechaEntrada.setOpaque(false);
		txtrFechaEntrada.setForeground(Color.WHITE);
		txtrFechaEntrada.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrFechaEntrada.setFocusable(false);
		txtrFechaEntrada.setEditable(false);
		txtrFechaEntrada.setBounds(722, 176, 180, 30);
		contentPane.add(txtrFechaEntrada);
		
		textAreaDiaMesEntrada = new JTextArea();
		textAreaDiaMesEntrada.setText("/");
		textAreaDiaMesEntrada.setOpaque(false);
		textAreaDiaMesEntrada.setForeground(Color.WHITE);
		textAreaDiaMesEntrada.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textAreaDiaMesEntrada.setFocusable(false);
		textAreaDiaMesEntrada.setEditable(false);
		textAreaDiaMesEntrada.setBounds(981, 176, 13, 30);
		contentPane.add(textAreaDiaMesEntrada);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(722, 690, 225, 23);
		contentPane.add(btnSalir);
		btnAsignar.setBounds(407, 690, 257, 23);
		contentPane.add(btnAsignar);

		lblReserva = new JLabel("Reserva:");
		lblReserva.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblReserva.setFocusable(false);
		lblReserva.setForeground(Color.WHITE);
		lblReserva.setBounds(326, 113, 81, 29);
		contentPane.add(lblReserva);

		lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblNombre.setFocusable(false);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(326, 176, 81, 30);
		contentPane.add(lblNombre);

		btnBorrarBusqueda = new JButton("Borrar busqueda");
		btnBorrarBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBorrarBusqueda.setFocusable(false);
		btnBorrarBusqueda.addMouseListener(new BtnBorrarBusquedaMouseListener());
		btnBorrarBusqueda.setBounds(696, 356, 205, 23);
		contentPane.add(btnBorrarBusqueda);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new TxtNombreFocusListener());
		txtNombre.setForeground(Color.GRAY);
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(430, 176, 150, 30);
		contentPane.add(txtNombre);

		txtApellidos = new JTextField();
		txtApellidos.addFocusListener(new TxtApellidosFocusListener());
		txtApellidos.setForeground(Color.GRAY);
		txtApellidos.setText("Apellidos");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(430, 245, 150, 30);
		contentPane.add(txtApellidos);

		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(new TxtCodigoFocusListener());
		txtCodigo.setForeground(Color.GRAY);
		txtCodigo.setText("Codigo");
		txtCodigo.setBounds(430, 113, 150, 30);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setFocusable(false);
		btnBuscar.addMouseListener(new BtnBuscarMouseListener());
		btnBuscar.setBounds(513, 356, 89, 23);
		contentPane.add(btnBuscar);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblApellidos.setFocusable(false);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(315, 245, 117, 30);
		contentPane.add(lblApellidos);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
		lblNewLabel.setBounds(0, 30, 1280, 720);
		contentPane.add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 0, 1280, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		///
		lblNombreApp = new JLabel("Hotel Stefan *****");
		lblNombreApp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreApp.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		lblNombreApp.setForeground(new Color(184, 134, 11));
		lblNombreApp.setBounds(538, 0, 212, 30);
		panel.add(lblNombreApp);

		lblCerrar = new JLabel("");
		lblCerrar.addMouseListener(new LblCerrarMouseListener());
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrar.setToolTipText("Cerrar");
		lblCerrar.setIcon(new ImageIcon(".\\recursos\\close.png"));
		lblCerrar.setBounds(22, 9, 14, 14);
		panel.add(lblCerrar);

		lblMinimizar = new JLabel("");
		lblMinimizar.addMouseListener(new LblMinimizarMouseListener());
		lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setToolTipText("Minimizar");
		lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimize.png"));
		lblMinimizar.setBounds(46, 9, 14, 14);
		panel.add(lblMinimizar);

		lblMaximizar = new JLabel("");
		lblMaximizar.addMouseListener(new LblMaximizarMouseListener());
		lblMaximizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaximizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximizar.setToolTipText("Maximizar");
		lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximize.png"));
		lblMaximizar.setBounds(70, 9, 14, 14);
		panel.add(lblMaximizar);
	}
}
