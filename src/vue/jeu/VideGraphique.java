package vue.jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VideGraphique extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private int theme;

	public VideGraphique(Graphics g, int theme) {
		this.g = g;
		this.theme = theme;
	}
	
	public void paint(int posX, int posY, int taille) {
		switch(this.theme) {
		case 1:
			g.setColor(Color.BLACK);
			g.fillRect(posX, posY, taille, taille);
			break;
		case 2:
			g.setColor(Color.RED);
			g.fillRect(posX, posY, taille, taille);
			break;
		case 3:
			g.setColor(Color.BLACK);
			g.fillRect(posX, posY, taille, taille);
			break;
		case 4:
			g.setColor(Color.BLACK);
			g.fillRect(posX, posY, taille, taille);
			break;
		case 5:
			g.setColor(new Color(107,201,160));
			g.fillRect(posX, posY, taille, taille);
			break;
		case 6:
			g.setColor(new Color(51,51,153));
			g.fillRect(posX, posY, taille, taille);
			break;
		}
	}

}
