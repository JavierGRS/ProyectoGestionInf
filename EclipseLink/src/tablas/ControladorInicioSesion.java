package tablas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

public class ControladorInicioSesion implements ActionListener {

	private VistaInicio vista;

	public ControladorInicioSesion(VistaInicio vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ENTRAR")) {
			try {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
				EntityManager manager = factory.createEntityManager();

				String usuario = vista.getFieldUsuario();

				tUsuario tu = manager
						.createQuery("Select a from tUsuario a where a.nif like '" + usuario + "'", tUsuario.class)
						.getResultList().get(0);
				// tUsuario tu = (tUsuario) EM.select("Select a from tUsuario a where a.nif like
				// '" + usuario + "'", tUsuario.class).getResultList().get(0);
				String contrasenaBBDD = tu.getPassword();

				TypedQuery<tPermiso> q = manager.createQuery(
						"Select a from tPermiso a where a.pantalla = 'Muestras' and a.rolName.rolName = '"+tu.getRolName().getRolName()+"'" , tPermiso.class);
				tPermiso p = q.getResultList().get(0);
				boolean acceso = p.getAcceso();

				if (contrasenaBBDD.equals(vista.getFieldContrasena())) {

					if (acceso) {
						DefaultTableModel modeloTabla = new DefaultTableModel();
						List<Muestra> resultList = manager.createQuery("SELECT A FROM  Muestra A", Muestra.class)
								.getResultList();
						manager.close();
						factory.close();
						// System.out.println("num of muestra:" + resultList.size());

						Object[][] data = new String[resultList.size() + 1][4];

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

						vista.frame.setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									VistaPrincipal window = new VistaPrincipal();
									ControladorPrincipal cp = new ControladorPrincipal(window);
									window.activarBotones(p.getInsertar(),p.getModificar(),p.getBorrar());
									window.controllerClick(cp);
									window.controllerButton(cp);

									window.setModeloTabla(modeloTabla);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

					} else {
						vista.mostrarError("El usuario no tiene acceso a la pantalla");
					}
				} else {
					vista.mostrarError("Contraseña incorrecta");
				}
			} catch (Exception e4) {
				vista.mostrarError("Usuario y contraseña incorrectos");
				e4.printStackTrace(); /// DELETE THISSSSSSSSSSSSSSSSSSSSSSS PLEASEE
			}

		}

	}
}