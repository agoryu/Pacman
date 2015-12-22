package controler.fenetre;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vue.fenetre.FenetreScore;


public class GameOverControler implements ActionListener {

	private JFrame f;
	public  GameOverControler(JFrame f) {
		this.f=f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//new Thread(new Audio("ressource/musique_mp3/pacman_beginning.mp3"));
			new FenetreScore();
			this.f.dispose();

	}

}