package tablas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

public class ControladorPrincipal extends MouseAdapter  implements MouseListener, ActionListener{
	
	private VistaPrincipal vista;
	
	public ControladorPrincipal (VistaPrincipal vista) {
		this.vista = vista;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
			
		int fila = vista.getTabla().rowAtPoint(e.getPoint());
		int ID = Integer.parseInt((String)vista.getTabla().getValueAt(fila, 0));
		
		Muestra mu = manager.createQuery("Select a from Muestra a where a.ID = " +ID , Muestra.class).getResultList().get(0);
		vista.setTextField(mu.getID()+"");
		vista.setTextField_1(mu.getNIF_Paciente());
		vista.setTextField_2(mu.getCultivo());
		vista.seleccionarSolucion(mu.getSolucion().getSolución());
		
		manager.close();
		factory.close();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx;
		String ac=e.getActionCommand();
		switch (ac) {
		case "ACTUALIZAR":
			tx = manager.getTransaction();
			tx.begin();

			try {
			   int idMuestra= Integer.parseInt((String)vista.getTabla().getValueAt(vista.getTabla().getSelectedRow(), 0));
			   Muestra m = manager.find(Muestra.class,idMuestra);
			   if(!vista.getTextField_1().equals(m.getNIF_Paciente())) {
				   m.setNIF_Paciente(vista.getTextField_1());
			   }
			   if(!vista.getTextField_2().equals(m.getCultivo())) {
				   m.setCultivo(vista.getTextField_2());
			   }
			
			   Solucion s = manager.createQuery("select a from Solucion a where a.Solución ='"+vista.getListaSol().getSelectedValue()+"'",Solucion.class).getResultList().get(0);
			   if(!s.equals(m.getSolucion())) {
				   m.setSolucion(s);
			   }
			   manager.persist(m);
			   tx.commit();
			} catch (Exception e1) {
			   e1.printStackTrace();
			   tx.rollback();
			}
			actualizarTablaMuestra(manager);
			
			break;			
			
			
		case "INSERTAR":
			   tx = manager.getTransaction();
			   tx.begin();

			   try {
				  Solucion s = manager.createQuery("select a from Solucion a where a.Solución ='"+vista.getListaSol().getSelectedValue()+"'",Solucion.class).getResultList().get(0);
			      manager.persist(new Muestra(vista.getTextField_1(),vista.getTextField_2(),s));
			      tx.commit();
			   } catch (Exception e3) {
			      e3.printStackTrace();
			      tx.rollback();
			   }
			   actualizarTablaMuestra(manager);
			break;

		case "BORRAR":
			tx = manager.getTransaction();
			tx.begin();
			      
			try {
			   Muestra m = manager.find(Muestra.class, Integer.parseInt(vista.getTextField()));
			   manager.remove(m);
			   tx.commit();
			} catch (Exception e2){
			   e2.printStackTrace();
			   tx.rollback();
			}
			vista.limpiar();
			actualizarTablaMuestra(manager);
			break;

		case "LIMPIAR":
			vista.limpiar();
			break;

		case "SALIR":
			System.exit(0);
			break;
						
		}
		manager.close();
		factory.close();
	}


	private void actualizarTablaMuestra(EntityManager manager) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		List<Muestra> resultList = manager.createQuery("SELECT A FROM  Muestra A", Muestra.class)
				.getResultList();
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
		vista.setModeloTabla(modeloTabla);
	}
}
