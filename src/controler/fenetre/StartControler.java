package controler.fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vue.fenetre.InitialisationMap;


public class StartControler implements ActionListener {

	private Thread t;
	private JFrame f;
	
	public StartControler(JFrame f,Thread t) {
		this.f=f;
		this.t=t;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.t.stop();
		this.f.dispose();
		InitialisationMap menuInit = new InitialisationMap(t);
		menuInit.init();
	}
}
