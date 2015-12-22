package vue.jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modele.composant.Fantome;

public class FantomeGraphique extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private int theme;
	private int x;
	private int y;
	private int taille;
	private boolean init;
	
	public FantomeGraphique(Graphics g, int theme) {
		this.g=g;
		this.theme = theme;
		init = false;
		
	}
	
	public FantomeGraphique(Graphics g, int theme, int x, int y, int taille) {
		this.g=g;
		this.theme = theme;
		
		this.x = x;
		this.y = y;
		this.taille = taille;
		
		init = true;
	}

	public void paint(Fantome ghost) {
		
		if(!init) {
			this.x = ghost.getX();
			this.y = ghost.getY();
			this.taille = 26;
		}
		
		//couleur du fond
		switch(this.theme) {
		case 1:
			g.setColor(Color.BLACK);
			g.fillRect(y, x, taille, taille);
			break;
		case 2:
			g.setColor(Color.RED);
			g.fillRect(y, x, taille, taille);
			break;
		case 3:
			g.setColor(Color.BLACK);
			g.fillRect(y, x, taille, taille);
			break;
		case 5:
			g.setColor(new Color(107,201,160));
			g.fillRect(y, x, taille, taille);
			break;
		case 6:
			g.setColor(new Color(51,51,153));
			g.fillRect(y, x, taille, taille);
			break;
		default:
			g.setColor(Color.BLACK);
			g.fillRect(y, x, taille, taille);
			break;
		}
		
		//couleur du fantome
		if(!ghost.getMangeable()) {
			switch(ghost.getNumero()){
			case 0:
				g.setColor(new Color(225, 34, 20));
				break;
			case 1:
				g.setColor(new Color(235, 138, 35));
				break;
			case 2:
				g.setColor(new Color(35, 235, 218));
				break;
			case 3:
				g.setColor(new Color(240, 84, 157));
				break;
			default:
				g.setColor(new Color(225, 34, 20));
				break;
			}
		} else {
			g.setColor(Color.BLUE);
		}
		
		//forme du fantome
		g.fillOval(y+taille/10, x, taille-taille/4, taille-taille/3-taille/12);
		g.fillArc(y-taille/4, x+taille/3, taille, taille, 75, 30);
		g.fillArc(y, x+taille/3, taille, taille, 75, 30);
		g.fillArc(y+taille/4, x+taille/3, taille, taille, 75, 30);
		
		//yeux du fantome
		g.setColor(Color.WHITE);
		g.fillOval(y+taille/4, x+taille/8, taille/4, taille/4);
		g.fillOval(y+taille/2, x+taille/8, taille/4, taille/4);
		g.setColor(Color.BLUE);
		g.fillOval(y+taille/3, x+taille/6, taille/8, taille/8);
		g.fillOval(y+taille/2+taille/8, x+taille/6, taille/8, taille/8);
	}
	
	public void paint2() {
		int taille = 30;
		g.setColor(Color.RED);
		
		//forme du fantome
		g.fillOval(taille/10, 0, taille-taille/4, taille-taille/3-taille/12);
		g.fillArc(taille/4, taille/3, taille, taille, 75, 30);
		g.fillArc(0, taille/3, taille, taille, 75, 30);
		g.fillArc(0-taille/4, taille/3, taille, taille, 75, 30);
		
		//yeux du fantome
		g.setColor(Color.WHITE);
		g.fillOval(taille/4, taille/8, taille/4, taille/4);
		g.fillOval(taille/2, taille/8, taille/4, taille/4);
		g.setColor(Color.BLUE);
		g.fillOval(taille/3, taille/6, taille/8, taille/8);
		g.fillOval(taille/2+taille/8, taille/6, taille/8, taille/8);
	
	}
}
