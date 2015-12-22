package vue.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.jeu.Score;
import vue.general.Police;

public class HighScore extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labHighScore;
	private JLabel highscore;
	
	public HighScore(Score score) {
		this.setPreferredSize(new Dimension(200, 200));
		labHighScore = new JLabel("HIGH SCORE :");
		highscore = new JLabel(score.getHighscore());
	}
	
	public void init() {
		Police p = new Police();
		
		//modification sur le panel
		this.setLayout(new GridLayout(2, 1));
		this.setBackground(Color.BLACK);
		
		//gestion du label score
		this.labHighScore.setFont(p.getNewPolice("ressource/police/Silkscreen/slkscr.ttf"));
		this.highscore.setFont(p.getNewPolice("ressource/police/Silkscreen/slkscr.ttf"));
		
		this.labHighScore.setForeground(Color.YELLOW);
		this.highscore.setForeground(Color.YELLOW);
		
		//panel pour le score
		JPanel panScore = new JPanel();
		panScore.setLayout(new GridLayout(3,1));
		panScore.setBackground(Color.BLACK);
		panScore.add(this.labHighScore);
		panScore.add(this.highscore);
		
		JPanel triche = new JPanel();
		triche.setBackground(Color.BLACK);
		panScore.add(triche);
		
		this.add(panScore);
	}

}
