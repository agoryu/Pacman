package vue.jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PacVie extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean vivant;

	public PacVie() {
		this.vivant = true;
	}

	public void setVivant() {
		this.vivant = false;
	}
	
	public void paint(Graphics g) {
		if(vivant) {
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			g.setColor(Color.BLACK);
			g.fillArc(0, 0, 30, 30, 320, 90);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 30, 30);
		}
	}
}
