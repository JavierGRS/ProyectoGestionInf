package tablas;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipal {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable tabla;
	private DefaultListModel<String> modeloSol;
	private	JList<String> listaSol;
	private JButton bLimpiar;
	private JButton bInsertar;
	private JButton bActualizar;
	private JButton bSalir;
	private JButton bBorrar;
	
	
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
		
		bInsertar = new JButton("Insertar");
		bInsertar.setBounds(105, 444, 89, 23);
		frame.getContentPane().add(bInsertar);
		
		bBorrar = new JButton("Borrar");
		bBorrar.setBounds(241, 444, 89, 23);
		frame.getContentPane().add(bBorrar);
		
		bActualizar = new JButton("Actualizar");
		bActualizar.setBounds(373, 444, 89, 23);
		frame.getContentPane().add(bActualizar);
		
		bSalir = new JButton("Salir");
		bSalir.setBounds(600, 444, 89, 23);
		frame.getContentPane().add(bSalir);
		
		bLimpiar = new JButton("Limpiar");
		bLimpiar.setBounds(487, 444, 89, 23);
		frame.getContentPane().add(bLimpiar);
		
		
		listaSol = new JList<String>();
		modeloSol = new DefaultListModel<String>();
		listaSol.setModel(modeloSol);
		
		cargarSoluciones();
		
		
		listaSol.setBounds(105, 345, 506, 75);
		frame.getContentPane().add(listaSol);
		
		 
		tabla = new JTable();
		tabla.setBounds(27, 72, 584, 130);
		frame.getContentPane().add(tabla);
		
	}		
	
	private void cargarSoluciones() {
		for(Solucion s:Solucion.ListaSolucion()) {
			modeloSol.addElement(s.getSolución());
		}
	}

	public void setTextField(String t) {
		this.textField.setText(t);
	}

	public void setTextField_1(String t) {
		this.textField_1.setText(t);
	}

	public void setTextField_2(String t) {
		this.textField_2.setText(t);
	}
	
	public void setModeloTabla(DefaultTableModel modeloTabla) {
		tabla.setModel(modeloTabla);
	}
	
	public JTable getTabla() {
		return tabla;
	}
	
	public JList<String> getListaSol () {
		return listaSol;
	}

	public void seleccionarSolucion(String solucion) {
		listaSol.setSelectedIndex(this.modeloSol.indexOf(solucion));
	}
	
	public void controller(ActionListener ac) {
		this.bActualizar.addActionListener(ac);
		this.bBorrar.addActionListener(ac);
		this.bInsertar.addActionListener(ac);
		this.bLimpiar.addActionListener(ac);
		this.bSalir.addActionListener(ac);
		
		this.bActualizar.setActionCommand("ACTUALIZAR");
		this.bBorrar.setActionCommand("BORRAR");
		this.bInsertar.setActionCommand("INSERTAR");
		this.bLimpiar.setActionCommand("LIMPIAR");
		this.bSalir.setActionCommand("SALIR");
	}

	public void controllerClick(MouseListener cp) {
			tabla.addMouseListener(cp);
	}

	public String getTextField() {
		return textField.getText();
	}

	public String getTextField_1() {
		return textField_1.getText();
	}

	public String getTextField_2() {
		return textField_2.getText();
	}

	public void controllerButton(ActionListener ac) {
		this.bActualizar.addActionListener(ac);
		this.bBorrar.addActionListener(ac);
		this.bInsertar.addActionListener(ac);
		this.bLimpiar.addActionListener(ac);
		this.bSalir.addActionListener(ac);
		
		this.bActualizar.setActionCommand("ACTUALIZAR");
		this.bBorrar.setActionCommand("BORRAR");
		this.bInsertar.setActionCommand("INSERTAR");
		this.bLimpiar.setActionCommand("LIMPIAR");
		this.bSalir.setActionCommand("SALIR");
		
	}

	public void limpiar() {
		 this.getTabla().clearSelection();
		 this.setTextField("");
		 this.setTextField_1("");
		 this.setTextField_2("");
		 this.getListaSol().clearSelection();		
	}

	public void activarBotones(boolean insertar, boolean modificar, boolean borrar) {
		bInsertar.setVisible(insertar);
		bActualizar.setVisible(modificar);
		bBorrar.setVisible(borrar);
	}
	
}
