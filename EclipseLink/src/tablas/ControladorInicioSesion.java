package tablas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

public class ControladorInicioSesion implements ActionListener {

	private VistaInicio vista;

	public ControladorInicioSesion(VistaInicio vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ENTRAR")) {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
			EntityManager manager = factory.createEntityManager();

			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				String usuario = vista.getFieldUsuario();
				Query query = manager.createQuery("Select  b.password from tUsuario b  where b.nif like  "+usuario);
				String contrasena = (String) query.getSingleResult();
				if (contrasena.equals(vista.getFieldContrasena())) {

					DefaultTableModel modeloTabla = new DefaultTableModel();

					tx = manager.getTransaction();
					tx.begin();

					List<Muestra> resultList = manager.createQuery("SELECT A FROM  Muestra A", Muestra.class)
							.getResultList();
					System.out.println("num of muestra:" + resultList.size());

					Object[][] data = new String[resultList.size() + 1][4];
					try {
						// realizamos la consulta sql y llenamos los datos en la matriz "Object[][]
						// data"
						String[] columnas = { "ID", "NIF_PACIENTE", "CULTIVO", "SOLUCION" };
						data[0] = columnas;
						int i = 1;
						for (Muestra m : resultList) {
							data[i][0] = Integer.toString(m.getID());
							data[i][1] = m.getNIF_Paciente();
							data[i][2] = m.getCultivo();
							data[i][3] = Integer.toString(m.getSolucion().getID());
							i++;
						}

						modeloTabla.setDataVector(data, columnas);
						tx.commit();
					} catch (Exception ee) {
						ee.printStackTrace();
						tx.rollback();
					}
					manager.close();
					factory.close();

					vista.frame.setVisible(false);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								VistaPrincipal window = new VistaPrincipal();
								window.setModeloTabla(modeloTabla);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					System.exit(-1);
				}
				tx.commit();
			} catch (Exception eee) {
				eee.printStackTrace();
				tx.rollback();
			}

		}

	}
}