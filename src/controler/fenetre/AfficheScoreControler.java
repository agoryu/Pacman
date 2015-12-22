package controler.fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.fenetre.FenetreScore;

public class AfficheScoreControler implements ActionListener {
	
	private Thread t;
	private JFrame f;
	
	public AfficheScoreControler(JFrame f,Thread t) {
		this.f=f;
		this.t=t;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		this.f.dispose();
		this.t.stop();
		new FenetreScore();

	}

}
