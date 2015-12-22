package vue.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.jeu.Jeu;
import modele.jeu.Labyrinthe;
import vue.general.AfficherImage;

public class EcranJeu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private LabGraphique mapG;
	private Jeu game;
	private AfficherImage titre;
	private ScoreVie scoreVie;
	private HighScore hs;
	private JPanel panLab;
	
	public EcranJeu(JFrame f, Jeu game, Labyrinthe map, int theme) {
		
		this.mapG=new LabGraphique(map, theme);
		this.titre=new AfficherImage("ressource/image/titre_pacman.jpg");
		this.game=game;
		this.hs = new HighScore(game.getScore());
		this.scoreVie = new ScoreVie(f,game.getScore());
	}
	
	public void init() {
		//initiation de tout les panel utilisé
				this.scoreVie.init();
				this.hs.init();
				
				//modification sur container principal
				this.setBackground(Color.BLACK);
				this.setLayout(new BorderLayout());
				
				//ajout de l'observer au jeu
				this.game.addObserver(this.mapG);
				this.game.addObserver(scoreVie.getPanVie());
				this.game.getScore().addObserver(this.scoreVie.getPanScore());
				
				//gestion du titre
				this.titre.setPreferredSize(new Dimension(300, 300));
				
				//gestion Labyrinthe graphique
				panLab = new JPanel();
				panLab.add(mapG);
				panLab.setBackground(Color.BLACK);
				mapG.setPreferredSize(new Dimension(900, 1000));
				
				//ajout des différent panel
				//this.container.add(titre, BorderLayout.NORTH);
				this.add(scoreVie, BorderLayout.WEST);
				this.add(panLab, BorderLayout.CENTER);
				this.add(hs, BorderLayout.EAST);
	}

}
