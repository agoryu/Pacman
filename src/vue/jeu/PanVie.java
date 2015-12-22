package vue.jeu;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.jeu.Score;
import vue.fenetre.GameOver;

public class PanVie extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PacVie[] tabVie;
	private int nbVie;
	private JFrame f;
	
	private Score s;
	public PanVie(JFrame f, Score s) {
		this.s=s;
		this.f=f;
		tabVie = new PacVie[3];
		this.nbVie = 3;
	}
	
	public void init() {
		//gestion vie
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(3,1));
		for(int i=0; i<3; i++) {
			tabVie[i] = new PacVie();
			this.add(tabVie[i]);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals("vie")) {
			if (nbVie > 0){
				tabVie[this.nbVie-1].setVivant();
				tabVie[this.nbVie-1].repaint();
				nbVie--;
			}
			else {
				System.out.println("gameover atteins");
				
				this.f.dispose();
				new GameOver();
				
				try {
					s.ajoutScore(s.getScore());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
			}
		}
	}
}
