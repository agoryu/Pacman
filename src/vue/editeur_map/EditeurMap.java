package vue.editeur_map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.editeur_map.GrilleModele;
import vue.general.Audio;
import controler.edit_map.ExitEditMapControler;
import controler.edit_map.GrilleEditMapControler;
import controler.edit_map.SaveControler;

public class EditeurMap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanReglage theme;
	private JPanel composant;
	private JPanel container;
	private GrilleLab grille;
	private GrilleModele modele;
	private JButton save;
	private JButton quit;
	
	public EditeurMap() {
		
		modele = new GrilleModele();
		modele.initTab();
		
		container = new JPanel();
		
		this.setTitle("editeur map");
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
	
	public void init() {
		
		Thread t=new Thread(new Audio("ressource/musique_mp3/Little Big Planet.mp3"));
		t.start();
		
		container.setLayout(new BorderLayout());
		container.setBackground(Color.WHITE);
		
		//panel contenant l'ensemble des outils permettant de créer un labyrinthe
		composant = new JPanel();
		composant.setLayout(new GridLayout(3, 1));
		
		//composant clickable
		theme = new PanReglage(modele);
		theme.init();
		composant.add(theme);
		
		//grille
		grille = new GrilleLab(modele);
		grille.setPreferredSize(new Dimension(900, 600));
		grille.addMouseListener(new GrilleEditMapControler(grille));
		modele.addObserver(grille);
		modele.addObserver(theme);
		
		//gestion bouton save et quit
		JPanel panBouton = new JPanel();
		save = new JButton("sauvegarder");
		quit = new JButton("quitter");
		save.addActionListener(new SaveControler(modele));
		quit.addActionListener(new ExitEditMapControler(t, this));
		
		panBouton.add(save);
		panBouton.add(quit);
		
		container.add(composant, BorderLayout.CENTER);
		container.add(grille, BorderLayout.NORTH);
		container.add(panBouton, BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setVisible(true);
		
	}

}
