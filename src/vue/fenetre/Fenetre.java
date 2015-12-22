package vue.fenetre;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.jeu.Jeu;
import modele.jeu.Labyrinthe;
import vue.jeu.EcranJeu;
import controler.jeu.ControlerDeplacement;

public class Fenetre{

	/**
	 * 
	 */
	
	private JPanel container;
	private Jeu game;
	private Labyrinthe map;
	private EcranJeu pacmanGame;
	@SuppressWarnings("unused")
	private Thread t;
	@SuppressWarnings("unused")
	private int theme;
	private JFrame f;
	
	public Fenetre(Labyrinthe map, Jeu game,Thread t, int theme) {
		f=new JFrame();
		
		this.t=t;
		this.container=new JPanel();
		this.map=map;
		this.game=game;
		this.pacmanGame = new EcranJeu(f,game, map, theme);
		
		f.setTitle("PacMan");
		
		f.setSize(1400, 1000);
		
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void init() {
		
		this.container.setBackground(Color.BLACK);
		
		this.map.getPacman().setDirection('g');
		
		pacmanGame.init();
		//ajout controler a la map graphique
		this.f.addKeyListener(new ControlerDeplacement(this.game, this.map));
		
		this.f.setContentPane(container);
		this.container.add(pacmanGame);
		this.f.setVisible(true);
		
	}
}
