package vue.jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PacmanGraphique extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private LabGraphique mapG;
	private int theme;
	
	private int x;
	private int y;
	private int taille;
	
	public PacmanGraphique(Graphics g, LabGraphique labGraphique, int theme) {
		this.g=g;
		this.mapG=labGraphique;
		this.theme = theme;
		
		this.y = this.mapG.getMap().getPacman().getX();
		this.x = this.mapG.getMap().getPacman().getY();
		this.taille = this.mapG.getTAILLE()-4;
	}
	
	public PacmanGraphique(Graphics g, LabGraphique labGraphique, int theme, int x, int y, int taille) {
		this.g=g;
		this.mapG=labGraphique;
		this.theme = theme;
		
		this.x = x;
		this.y = y;
		this.taille = taille;
	}

	public void paint(Color color) {
		
		if(this.mapG.getMap().getPacman().getDirection() == 'g') {
			//corps du pacman
			g.setColor(Color.YELLOW);
			g.fillOval(x+taille/7, y+taille/7, taille/2+taille/3, taille/2+taille/3);
			
			//yeux du pacman
			g.setColor(Color.BLACK);
			g.fillOval(x+taille/2, y+taille/4, taille/5, taille/5);
			
			//changement de bouche si il mange
			g.setColor(color);
			if(!this.mapG.getMap().getPacman().getMange()) {
				g.fillArc(x, y, taille, taille, 160, 60);
			}
			
		} else if(this.mapG.getMap().getPacman().getDirection() == 'd') {
			//corps du pacman
			g.setColor(Color.YELLOW);
			g.fillOval(x+taille/7, y+taille/7, taille/2+taille/3, taille/2+taille/3);
			
			//yeux du pacman
			g.setColor(Color.BLACK);
			g.fillOval(x+taille/4, y+taille/4, taille/5, taille/5);
			
			//changement de bouche si il mange
			g.setColor(color);
			if(!this.mapG.getMap().getPacman().getMange()) {
				g.fillArc(x, y, taille, taille, 330, 60);
			}
			
		} else if(this.mapG.getMap().getPacman().getDirection() == 'h') {
			//corps du pacman
			g.setColor(Color.YELLOW);
			g.fillOval(x+taille/7, y+taille/7, taille/2+taille/3, taille/2+taille/3);
			
			//yeux du pacman
			g.setColor(Color.BLACK);
			g.fillOval(x+taille/2+taille/8, y+taille/2, taille/5, taille/5);
			
			//changement de bouche si il mange
			g.setColor(color);
			if(!this.mapG.getMap().getPacman().getMange()) {
				g.fillArc(x, y, taille, taille, 70, 60);
			}
			
		} else {
			//corps du pacman
			g.setColor(Color.YELLOW);
			g.fillOval(x+taille/7, y+taille/7, taille/2+taille/3, taille/2+taille/3);
			
			//yeux du pacman
			g.setColor(Color.BLACK);
			g.fillOval(x+taille/2+taille/8, y+taille/4, taille/5, taille/5);
			
			//changement de bouche si il mange
			g.setColor(color);
			if(!this.mapG.getMap().getPacman().getMange()) {
				g.fillArc(x, y, taille, taille, 240, 60);
			}
		}
		
	}
	
	public void dessine() {
		switch(this.theme) {
		case 1:
			this.paint(Color.BLACK);
			break;
		case 2:
			this.paint(Color.RED);
			break;
		case 3:
			this.paint(Color.BLACK);
			break;
		case 4:
			this.paint(Color.BLACK);
			break;
		case 5:
			this.paint(new Color(107,201,160));
			break;
		case 6:
			this.paint(new Color(51,51,153));
			break;
		}
	}

}
