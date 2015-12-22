package vue.jeu;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.jeu.Labyrinthe;

public class LabGraphique extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	
	private Labyrinthe map;
	private final int TAILLE = 30;
	private int row;
	private int column;
	private int theme;
	
	public LabGraphique(Labyrinthe map, int theme) {
		this.map=map;
		row=map.getNbRow();
		column=map.getNbColumn();
		
		this.theme = theme;
	}
	
	public void paint(Graphics g) {
		
		//creation de l'ensemble des objet qui dessineront le labyrinthe
		PacmanGraphique pacman=new PacmanGraphique(g, this, theme);
		FantomeGraphique fg=new FantomeGraphique(g, theme);
		MurGraphic mur;
		PacGommeGraphique pgg = new PacGommeGraphique(g, theme);
		VideGraphique vg = new VideGraphique(g, theme);
		SuperPacGommeGraphique spgg = new SuperPacGommeGraphique(g, theme);
		
		/*il faut mettre l'image des mur dans le constructeur de MurGraphic car cela permet de
		 * charger l'image qu'une fois
		 */
		if(theme == 1) mur = new MurGraphic(g, theme);
		else if(theme == 2) mur = new MurGraphic(g, "flamme", theme);
		else if (theme == 3) mur = new MurGraphic(g, "mur", theme);
		else if (theme == 4) mur = new MurGraphic(g,"espace",theme);
		else if(theme == 5) mur = new MurGraphic(g,"herbe",theme);
		else mur = new MurGraphic(g,"marecage",theme);
		
		//boucle qui parcours l'ensemble du labyrinthe et qui dessine chaque composant
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				switch(map.getComposant(i, j).getNom()) {
				//dessine les murs
				case 'M':
					mur.paint(TAILLE*j, TAILLE*i, TAILLE);
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
				default:
					System.out.println("erreur il n'y a pas de composant");
				}
			}
		}
		//dessine pacman
		pacman.dessine();
		
		//dessine les fantomes.
		for (int i = 0; i < 4; i ++){
			fg.paint(map.getFantome(i));
		}
		
		
	}

	
	public Labyrinthe getMap() {
		return map;
	}

	public int getTAILLE() {
		return TAILLE;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(String.valueOf(arg1).equals("map")) this.repaint();
		
	}

}
