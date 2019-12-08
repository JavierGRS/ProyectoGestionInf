import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VistaInicio {

	private JFrame frame;
	private JTextField fieldUsuario;
	private JTextField fieldContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicio window = new VistaInicio();
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
		
		fieldContrasena = new JTextField();
		fieldContrasena.setBounds(158, 158, 134, 20);
		frame.getContentPane().add(fieldContrasena);
		fieldContrasena.setColumns(10);
	}
}
