package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JLabel lblFondo;
	private JPanel panel;
	private JLabel lblNombreApp;
	private JLabel lblCerrar;
	private JLabel lblMinimizar;
	private JLabel lblMaximizar;
	private JTextField textFieldUser;
	private JPasswordField passwordFieldPass;
	private JLabel lblLogin;
	private JButton btnEntrar;
	private JButton btnSignup;
	//private ArrayList<Usuario> vUsuarios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 0, 1280, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombreApp = new JLabel("Hotel Stefan *****");
		lblNombreApp.setBounds(538, 0, 212, 30);
		lblNombreApp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreApp.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		lblNombreApp.setForeground(new Color(184, 134, 11));
		panel.add(lblNombreApp);
		
		lblCerrar = new JLabel("");
		lblCerrar.setBounds(22, 9, 14, 14);
		lblCerrar.addMouseListener(new LblCerrarMouseListener());
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrar.setToolTipText("Cerrar");
		lblCerrar.setIcon(new ImageIcon(".\\recursos\\close.png"));
		panel.add(lblCerrar);
		
		lblMinimizar = new JLabel("");
		lblMinimizar.setBounds(46, 9, 14, 14);
		lblMinimizar.addMouseListener(new LblMinimizarMouseListener());
		lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setToolTipText("Minimizar");
		lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimize.png"));
		panel.add(lblMinimizar);
		
		lblMaximizar = new JLabel("");
		lblMaximizar.setBounds(70, 9, 14, 14);
		lblMaximizar.addMouseListener(new LblMaximizarMouseListener());
		lblMaximizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaximizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximizar.setToolTipText("Maximizar");
		lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximize.png"));
		panel.add(lblMaximizar);
		
		textFieldUser = new JTextField();
		textFieldUser.addFocusListener(new TextFieldUserFocusListener());
		textFieldUser.setText("USUARIO");
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUser.setBounds(460, 189, 368, 40);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.addFocusListener(new PasswordFieldFocusListener());
		passwordFieldPass.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldPass.setEchoChar('•');
		passwordFieldPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordFieldPass.setBounds(460, 240, 368, 40);
		contentPane.add(passwordFieldPass);
		passwordFieldPass.setText("CONTRASEÑA");
		
		lblLogin = new JLabel("SIGN IN");
		lblLogin.setForeground(new Color(184, 134, 11));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(460, 76, 368, 70);
		contentPane.add(lblLogin);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEntrar.setBounds(460, 344, 368, 50);
		contentPane.add(btnEntrar);
		
		
		btnSignup = new JButton("REGISTRO");
		btnSignup.addActionListener(new BtnSignupActionListener());
		btnSignup.addMouseListener(new BtnSignupMouseListener());
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignup.setBounds(650, 511, 368, 50);
		contentPane.add(btnSignup);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
		lblFondo.setBounds(0, 30, 1280, 720);
		contentPane.add(lblFondo);
		lblFondo.setFocusable(true);
		lblFondo.requestFocus();
		//vUsuarios = IoDatos.leerDatos();
		
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
	}
	private class TextFieldUserFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			textFieldUser.setText("");
			lblFondo.setFocusable(false);
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			if (textFieldUser.getText().equals("")) {
				textFieldUser.setText("USUARIO");
			}
		}
	}
	private class BtnSignupMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}
	}
	private class BtnSignupActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Registro reg = new Registro();
			reg.setVisible(true);
			dispose();
		}
	}
	private class PasswordFieldFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			passwordFieldPass.setText("");
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			
			if (String.copyValueOf(passwordFieldPass.getPassword()).equals("")) {
				passwordFieldPass.setText("contraseña");
			}
			
			if ((passwordFieldPass.getPassword().toString().equals("")) && (passwordFieldPass.getPassword().toString().equals("contraseña"))) {
				passwordFieldPass.setText(passwordFieldPass.getPassword().toString());
			}
			
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if((textFieldUser.getText().equals("")||passwordFieldPass.getPassword().equals(""))||(textFieldUser.getText().equals("USUARIO")||passwordFieldPass.getPassword().equals("CONTRASEÑA"))) { 
				JOptionPane.showMessageDialog(null,"Valores no introducidos" );
			}
			ArrayList<Usuario> vUsuarios = IoDatos.leerDatos();
			
			if (IoDatos.comprobarUser(textFieldUser.getText(), String.valueOf(passwordFieldPass.getPassword()))) {
				for (Usuario user : vUsuarios) {
					if (user.getNombreUsuario().equals(textFieldUser.getText())) {
						/*if (user.isEsAdmin()) {
							Registro reg = new Registro();
							reg.setVisible(true);
							dispose();
							break;
						}
						mostrar la ventana del Administrador
						*/
						if (!user.isEsAdmin()) {
							ReservasCliente cliente = new ReservasCliente();
							cliente.setVisible(true);
							dispose();
							break;
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Los datos del usuario introducidos no coinciden o este no está registrado");
				
			}
			
			
		}
	}

}