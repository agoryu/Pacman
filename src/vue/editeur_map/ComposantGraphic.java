package vue.editeur_map;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import vue.jeu.FantomeGraphique;
import vue.jeu.PacGommeGraphique;
import vue.jeu.PacVie;
import vue.jeu.SuperPacGommeGraphique;

public class ComposantGraphic extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private char c;
	
	public ComposantGraphic(char c) {
		this.c = c;
	}
	
	public ComposantGraphic() {}
	
	public void paint(Graphics g) {
	
		if(c == 'm') {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 30, 30);
		} else if(c == 'f') {
			FantomeGraphique fantome = new FantomeGraphique(g, 1);
			fantome.paint2();
		} else if(c == '.') {
			PacGommeGraphique gomme = new PacGommeGraphique(g, 1);
			gomme.paint(0, 0, 30);
		} else if(c == 'p') {
			PacVie pacman = new PacVie();
			pacman.paint(g);
		} else if(c == 'o') {
			SuperPacGommeGraphique supergomme = new SuperPacGommeGraphique(g, 1);
			supergomme.paint(0, 0, 30);
		}
	}

}
