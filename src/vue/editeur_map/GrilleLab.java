package vue.editeur_map;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.composant.Fantome;
import modele.editeur_map.GrilleModele;

import vue.jeu.PacGommeGraphique;

import vue.jeu.FantomeGraphique;
import vue.jeu.SuperPacGommeGraphique;
import vue.jeu.VideGraphique;

public class GrilleLab extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GrilleModele modele;
	
	GrilleLab(GrilleModele modele) {
		
		this.modele = modele;
	}
	
	
	public void paint(Graphics g) {
		
		int TAILLE = 25;
		
		PacGommeGraphique pgg = new PacGommeGraphique(g, 1);
		VideGraphique vg = new VideGraphique(g, 1);
		SuperPacGommeGraphique spgg = new SuperPacGommeGraphique(g, 1);
		
		//boucle qui parcours l'ensemble du labyrinthe et qui dessine chaque composant
		for(int i=0; i<20; i++) {
			for(int j=0; j<28; j++) {
				switch(modele.getTabChar()[i][j]) {
				//dessine les murs
				case 'M':
					g.setColor(Color.BLUE);
					g.fillRect(TAILLE*j, TAILLE*i, TAILLE, TAILLE);
					break;
					//dessine les pacgommes
				case '.':
					pgg.paint(j*TAILLE, i*TAILLE, TAILLE);
					break;
					//dessine le vides qui sera different en fonction du theme
				case ' ':
					vg.paint(j*TAILLE, i*TAILLE, TAILLE);
					break;
					//dessine les super pacgomme
				case 'o':
					spgg.paint(j*TAILLE, i*TAILLE, TAILLE);
					break;
				case 'P':
					g.setColor(Color.BLACK);
					g.fillRect(j*TAILLE, i*TAILLE, TAILLE, TAILLE);
					g.setColor(Color.YELLOW);
					g.fillOval(j*TAILLE, i*TAILLE, TAILLE, TAILLE);
					g.setColor(Color.BLACK);
					g.fillArc(j*TAILLE, i*TAILLE, TAILLE, TAILLE, 330, 60);
					g.fillOval(j*TAILLE+TAILLE/4, i*TAILLE+TAILLE/4, TAILLE/5, TAILLE/5);
					break;
				case 'F':
					FantomeGraphique ghost = new FantomeGraphique(g, 1, i*TAILLE, j*TAILLE, TAILLE);
					ghost.paint(new Fantome(i, j, 1));
				default:
					System.out.println("erreur il n'y a pas de composant");
				}
				g.setColor(Color.WHITE);
				g.drawRect(j*TAILLE, i*TAILLE, TAILLE, TAILLE);
			}
		}
	}
	
	public GrilleModele getGrilleModele(){
		return this.modele;
	}


	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals("editeur")) this.repaint();
		
	}
}
