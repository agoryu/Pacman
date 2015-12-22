package controler.fenetre;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.editeur_map.EditeurMap;



public class LanceEditMapControler implements ActionListener {
	private Thread t;
	private JFrame f;
	public LanceEditMapControler(JFrame f,Thread t) {
		this.f=f;
		this.t=t;
		}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.t.stop();
		this.f.dispose();
		EditeurMap em = new EditeurMap();
		em.init();

	}

}
