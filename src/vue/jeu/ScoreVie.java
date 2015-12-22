package vue.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.jeu.Score;

public class ScoreVie extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanScore panScore;
	private PanVie panVie;
	@SuppressWarnings("unused")
	private JFrame f;
	
	public ScoreVie(JFrame f, Score point) {
		this.f=f;
		this.setPreferredSize(new Dimension(250, 200));
		this.panVie = new PanVie(f,point);
		this.panScore = new PanScore(point);
	}
	
	public void init() {
		panScore.init();
		panVie.init();
		
		//modification sur le panel
		this.setLayout(new GridLayout(4, 1));
		this.setBackground(Color.BLACK);
		
		//panel pour le score
		this.add(panScore);
		this.add(panVie);
	}

	public PanScore getPanScore() {
		return panScore;
	}
	
	public PanVie getPanVie() {
		return panVie;
	}
}
