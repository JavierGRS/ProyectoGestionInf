package tablas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class VistaInicio {

	public JFrame frame;
	private JTextField fieldUsuario;
	private JTextField fieldContrasena;
	private JButton submit;
	private JLabel error;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicio window = new VistaInicio();
					window.controller(new ControladorInicioSesion(window));
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblBienvenido.setBounds(158, 29, 170, 62);
		frame.getContentPane().add(lblBienvenido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(83, 115, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContraseña.setBounds(83, 160, 71, 14);
		frame.getContentPane().add(lblContraseña);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(158, 113, 134, 20);
		frame.getContentPane().add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		fieldUsuario.setText("111111111A");
		
		fieldContrasena = new JTextField();
		fieldContrasena.setBounds(158, 158, 134, 20);
		frame.getContentPane().add(fieldContrasena);
		fieldContrasena.setColumns(10);
		
		fieldContrasena.setText("admin");
		
		submit = new JButton("Entrar");
		submit.setBounds(158, 188, 134, 40);
		frame.getContentPane().add(submit);
		
		error = new JLabel();
		error.setBounds(158,80,300,25);
		frame.getContentPane().add(error);
		error.setVisible(false);
		
	}

	
	public String getFieldUsuario() {
		return fieldUsuario.getText();
	}

	public String getFieldContrasena() {
		return fieldContrasena.getText();
	}

	private void controller(ActionListener ac) {
		submit.addActionListener(ac);
		submit.setActionCommand("ENTRAR");
	}

	public void mostrarError(String s) {
		error.setText("<html><font color='red'>"+s+"</font></html>");
		error.setVisible(true);
	}

}


