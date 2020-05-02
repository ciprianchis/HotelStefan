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
import java.util.Scanner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JLabel lblInicio;
	private JLabel lblFinal;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JButton btnBuscar;
	private JButton btnBorrarBusqueda;
	private JList list;
	private JButton btnAsignar;
	private JButton btnSalir;
	private boolean maximizado = false;

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
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(722, 690, 225, 23);
		contentPane.add(btnSalir);
		btnAsignar.setBounds(407, 690, 257, 23);
		contentPane.add(btnAsignar);

		lblFinal = new JLabel("Fecha de salida:");
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblFinal.setFocusable(false);
		lblFinal.setForeground(Color.WHITE);
		lblFinal.setBounds(744, 228, 160, 18);
		contentPane.add(lblFinal);

		list = new JList();
		list.setFocusable(false);
		list.setBounds(358, 407, 646, 255);
		contentPane.add(list);

		lblInicio = new JLabel("Fecha de entrada:");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblInicio.setFocusable(false);
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setBounds(744, 149, 170, 18);
		contentPane.add(lblInicio);

		lblReserva = new JLabel("Reserva:");
		lblReserva.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblReserva.setFocusable(false);
		lblReserva.setForeground(Color.WHITE);
		lblReserva.setBounds(326, 120, 81, 22);
		contentPane.add(lblReserva);

		lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblNombre.setFocusable(false);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(326, 183, 81, 23);
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
		txtNombre.setText("NOMBRE");
		txtNombre.setColumns(10);
		txtNombre.setBounds(430, 186, 86, 20);
		contentPane.add(txtNombre);

		txtApellidos = new JTextField();
		txtApellidos.addFocusListener(new TxtApellidosFocusListener());
		txtApellidos.setForeground(Color.GRAY);
		txtApellidos.setText("APELLIDOS");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(430, 255, 86, 20);
		contentPane.add(txtApellidos);

		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(new TxtCodigoFocusListener());
		txtCodigo.setForeground(Color.GRAY);
		txtCodigo.setText("CODIGO");
		txtCodigo.setBounds(430, 123, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setFocusable(false);
		btnBuscar.addMouseListener(new BtnBuscarMouseListener());
		btnBuscar.setBounds(513, 356, 89, 23);
		contentPane.add(btnBuscar);

		txtInicio = new JTextField();
		txtInicio.addFocusListener(new TxtInicioFocusListener());
		txtInicio.setForeground(Color.GRAY);
		txtInicio.setText("INICIO");
		txtInicio.setColumns(10);
		txtInicio.setBounds(924, 150, 86, 20);
		contentPane.add(txtInicio);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblApellidos.setFocusable(false);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(315, 252, 117, 23);
		contentPane.add(lblApellidos);

		txtFinal = new JTextField();
		txtFinal.addFocusListener(new TxtFinalFocusListener());
		txtFinal.setForeground(Color.GRAY);
		txtFinal.setText("FINAL");
		txtFinal.setColumns(10);
		txtFinal.setBounds(918, 229, 86, 20);
		contentPane.add(txtFinal);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
		lblNewLabel.setBounds(10, 30, 1280, 720);
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
			txtCodigo.setText("CODIGO");
			txtNombre.setText("NOMBRE");
			;
			txtApellidos.setText("APELLIDOS");
			;
			txtInicio.setText("INICIO");
			;
			txtFinal.setText("FINAL");
			;

			JOptionPane.showMessageDialog(null, "Busqueda borrada");
		}
	}

	private class BtnAsignarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Habitacion asignada");
		}
	}
	
	private String[] lista() {
		
		ArrayList<String> listText = new ArrayList<String>();
		
		try {
			FileInputStream fis = new FileInputStream("recursos/reservas.dat");
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			
			String linea = br.readLine();
			
			while(linea!=null) {
				listText.add(linea);
				linea = br.readLine();
			}
			
			br.close();
		} 
		
		catch(IOException ioe) {
			
		}
		
		String[] array= new String[listText.size()];
		array = listText.toArray(array);
		
		return array;
	}

	private class BtnBuscarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String[] vLista = new String[100];
			File fichero = new File("reservas.dat");
			if (!fichero.exists()) {
				try {
					fichero.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else {
				try {
					FileInputStream fi = new FileInputStream(fichero);
					InputStreamReader is = new InputStreamReader(fi, "UTF8");
					BufferedReader br = new BufferedReader(is);

					String linea = br.readLine();

					while (linea != null) {

					}

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
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
			if(texto.equals("CODIGO")) {
				txtCodigo.setText("");
				txtCodigo.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtCodigo.getText();
			if(texto.equals("")) {
				txtCodigo.setForeground(Color.gray);
				txtCodigo.setText("CODIGO");
			}
		}
	}
	private class TxtNombreFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtNombre.getText();
			if(texto.equals("NOMBRE")) {
				txtNombre.setText("");
				txtNombre.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtNombre.getText();
			if(texto.equals("")) {
				txtNombre.setForeground(Color.gray);
				txtNombre.setText("NOMBRE");
			}
		}
	}
	private class TxtApellidosFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtApellidos.getText();
			if(texto.equals("APELLIDOS")) {
				txtApellidos.setText("");
				txtApellidos.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtApellidos.getText();
			if(texto.equals("")) {
				txtApellidos.setForeground(Color.gray);	
				txtApellidos.setText("APELLIDOS");
			}
		}
	}
	private class TxtInicioFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtInicio.getText();
			if(texto.equals("INICIO")) {
				txtInicio.setText("");
				txtInicio.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtInicio.getText();
			if(texto.equals("")) {
				txtInicio.setForeground(Color.gray);	
				txtInicio.setText("INICIO");
			}
		}
	}
	private class TxtFinalFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			String texto = txtFinal.getText();
			if(texto.equals("FINAL")) {
				txtFinal.setText("");
				txtFinal.setForeground(Color.black);
			} 
		}
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtFinal.getText();
			if(texto.equals("")) {
				txtFinal.setForeground(Color.gray);	
				txtFinal.setText("FINAL");
			}
		}
	}
}
