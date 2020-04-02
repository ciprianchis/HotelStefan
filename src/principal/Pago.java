package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Frame;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Pago extends JFrame {

	private JLabel lblReservar;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNombreApp;
	private JLabel lblCerrar;
	private JLabel lblMinimizar;
	private JLabel lblMaximizar;
        private boolean maximizado = false;
        private OperacionHabitacion operaciones = new OperacionHabitacion();
        private JTextArea textNom;
        private JTextArea textApe;
        private JTextArea textDireccion;
        private JTextArea textNum;
        private JTextField textFieldNom;
        private JTextField textFieldApe;
        private JTextField textFieldNum;
        private JTextArea textCVV;
        private JTextField textFieldCVV;
        private JButton btnNewButton;
        private JTextArea textArea;
        private String usuarioReserva;
        private Reserva reservaRealizada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pago frame = new Pago();
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
	public Pago() {
		initApp();
	}
	public Pago(String usuario, Reserva reserva) {
		initApp();
		usuarioReserva = usuario;
		reservaRealizada = reserva;
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
	}
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
                        maximizado=true;
                    } else {
                        setExtendedState(JFrame.NORMAL);
                        maximizado=false;
                    }
		}
	}
	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			new ReservasCliente(usuarioReserva,reservaRealizada).setVisible(true);
			dispose();
		}
	}
        private void initApp() {
            operaciones.cargarHabitaciones();
            setResizable(false);
    		setUndecorated(true);
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setBounds(100, 100, 1280, 750);
    		contentPane = new JPanel();
    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    		setContentPane(contentPane);
    		contentPane.setLayout(null);
    		
    		textArea = new JTextArea();
    		textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		textArea.setWrapStyleWord(true);
    		textArea.setRows(19);
    		textArea.setBounds(680, 239, 300, 120);
    		contentPane.add(textArea);
    		
    		btnNewButton = new JButton("Pagar");
    		btnNewButton.addMouseListener(new BtnNewButtonMouseListener());
    		btnNewButton.setBounds(550, 500, 150, 39);
    		contentPane.add(btnNewButton);
    		
    		textFieldCVV = new JTextField();
    		textFieldCVV.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		textFieldCVV.setColumns(10);
    		textFieldCVV.setBounds(840, 400, 140, 30);
    		contentPane.add(textFieldCVV);
    		
    		textCVV = new JTextArea();
    		textCVV.setForeground(Color.WHITE);
    		textCVV.setOpaque(false);
    		textCVV.setText("CVV:");
    		textCVV.setFont(new Font("Monospaced", Font.PLAIN, 18));
    		textCVV.setBounds(780, 400, 50, 30);
    		contentPane.add(textCVV);
    		
    		textFieldNum = new JTextField();
    		textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		textFieldNum.setColumns(10);
    		textFieldNum.setBounds(520, 400, 250, 30);
    		contentPane.add(textFieldNum);
    		
    		textFieldApe = new JTextField();
    		textFieldApe.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		textFieldApe.setColumns(10);
    		textFieldApe.setBounds(680, 198, 300, 30);
    		contentPane.add(textFieldApe);
    		
    		textFieldNom = new JTextField();
    		textFieldNom.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		textFieldNom.setBounds(680, 152, 300, 30);
    		contentPane.add(textFieldNom);
    		textFieldNom.setColumns(10);
    		
    		textNum = new JTextArea();
    		textNum.setForeground(Color.WHITE);
    		textNum.setOpaque(false);
    		textNum.setText("Numero Tarjeta:");
    		textNum.setFont(new Font("Monospaced", Font.PLAIN, 18));
    		textNum.setBounds(300, 400, 190, 30);
    		contentPane.add(textNum);
    		
    		textDireccion = new JTextArea();
    		textDireccion.setForeground(Color.WHITE);
    		textDireccion.setOpaque(false);
    		textDireccion.setText("Direccion Titular Tarjeta:");
    		textDireccion.setFont(new Font("Monospaced", Font.PLAIN, 18));
    		textDireccion.setBounds(300, 232, 300, 30);
    		contentPane.add(textDireccion);
    		
    		textApe = new JTextArea();
    		textApe.setForeground(Color.WHITE);
    		textApe.setOpaque(false);
    		textApe.setText("Apellido Titular Tarjeta:");
    		textApe.setFont(new Font("Monospaced", Font.PLAIN, 18));
    		textApe.setBounds(300, 191, 300, 30);
    		contentPane.add(textApe);
    		
    		textNom = new JTextArea();
    		textNom.setForeground(Color.WHITE);
    		textNom.setOpaque(false);
    		textNom.setFont(new Font("Monospaced", Font.PLAIN, 18));
    		textNom.setText("Nombre Titular Tarjeta:");
    		textNom.setBounds(300, 150, 300, 30);
    		contentPane.add(textNom);
    		
    		lblReservar = new JLabel("New label");
    		lblReservar.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
    		lblReservar.setBounds(0, 30, 1280, 720);
    		contentPane.add(lblReservar);
    		
    		panel = new JPanel();
    		panel.setBackground(Color.WHITE);
    		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
    		panel.setBounds(0, 0, 1280, 30);
    		contentPane.add(panel);
    		panel.setLayout(null);
    		
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
