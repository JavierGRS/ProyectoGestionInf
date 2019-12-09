package tablas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicioSesion implements ActionListener {

	
	private VistaInicio vista;
	
	
	public ControladorInicioSesion(VistaInicio vista) {
		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ENTRAR")) {
			vista.frame.setVisible(false);
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
	}

}
