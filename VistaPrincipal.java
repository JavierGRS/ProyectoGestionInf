import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
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
	public VistaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 757, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMuestras = new JLabel("MUESTRAS");
		lblMuestras.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblMuestras.setBounds(272, 0, 377, 82);
		frame.getContentPane().add(lblMuestras);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 218, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNIF = new JLabel("NIF");
		lblNIF.setBounds(27, 263, 46, 14);
		frame.getContentPane().add(lblNIF);
		
		JLabel lblCultivo = new JLabel("Cultivo");
		lblCultivo.setBounds(27, 307, 46, 14);
		frame.getContentPane().add(lblCultivo);
		
		JLabel lblSolucion = new JLabel("Solucion");
		lblSolucion.setBounds(27, 348, 46, 14);
		frame.getContentPane().add(lblSolucion);
		
		textField = new JTextField();
		textField.setBounds(105, 215, 506, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 260, 506, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 304, 506, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(105, 444, 89, 23);
		frame.getContentPane().add(btnInsertar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(241, 444, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(373, 444, 89, 23);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(499, 444, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 345, 506, 75);
		frame.getContentPane().add(comboBox);
		
		tabla = new JTable();
		tabla.setBounds(27, 72, 584, 130);
		frame.getContentPane().add(tabla);
		
	}
}
