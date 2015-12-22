package vue.jeu;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.jeu.Score;
import vue.general.Police;

public class PanScore extends JPanel implements Observer {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labscore;
	private JLabel score;
	private Score point;
	
	public PanScore(Score point) {
		labscore = new JLabel("GAME SCORE :");
		score = new JLabel(point.getStringScore());
		this.point = point;
	}

	public void init() {
		
		this.setBackground(Color.BLACK);
		Police p = new Police();
		
		//gestion du label score
		this.labscore.setFont(p.getNewPolice("ressource/police/Silkscreen/slkscr.ttf"));
		this.score.setFont(p.getNewPolice("ressource/police/Silkscreen/slkscr.ttf"));
				
		this.labscore.setForeground(Color.YELLOW);
		this.score.setForeground(Color.YELLOW);
		
		JPanel panScore = new JPanel();
		panScore.setLayout(new GridLayout(2,1));
		panScore.setBackground(Color.BLACK);
		
		panScore.add(this.labscore);
		panScore.add(this.score);
		
		this.add(panScore);
		
				
	}
	
	public JLabel getLabscore() {
		return labscore;
	}

	public JLabel getScore() {
		return score;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.getScore().setText(this.point.getStringScore());

	}

}
