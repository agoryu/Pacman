package controler.edit_map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.editeur_map.EditeurMap;
import vue.fenetre.MenuDemarrage;

public class ExitEditMapControler implements ActionListener {

	private Thread t;
	private EditeurMap em;
	
	public ExitEditMapControler(Thread t, EditeurMap em) {
		this.t = t;
		this.em = em;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		t.stop();
		em.dispose();
		new MenuDemarrage();

	}

}
