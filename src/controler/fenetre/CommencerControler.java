package controler.fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.fenetre.InitialisationMap;
import modele.jeu.Jeu;
import modele.jeu.Labyrinthe;
import vue.general.Audio;
import vue.fenetre.Fenetre;
import modele.deplacement.LancementThread;

public class CommencerControler implements ActionListener {

	private InitialisationMap initMap;
	private Labyrinthe map;
	@SuppressWarnings("unused")
	private Jeu game;
	private Thread t;
	
	public CommencerControler(InitialisationMap initMap, Thread t) {
		this.initMap = initMap;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int theme = 1;
		
		Thread musique = new Thread(new Audio("ressource/musique_mp3/pacman_beginning.mp3"));
		
		//preparation map
		map = new Labyrinthe((String)initMap.getComboMap().getSelectedItem());
		map.initMap();
		Jeu game = new Jeu(map);
		
		
		//affichage fenetre de jeu
		if(initMap.getTheme().getSelectedItem().equals("classique")) theme = 1;
		if(initMap.getTheme().getSelectedItem().equals("enfer")) theme = 2;
		if(initMap.getTheme().getSelectedItem().equals("chateau bowser")) theme = 3;
		if(initMap.getTheme().getSelectedItem().equals("star wars")) theme = 4;
		if(initMap.getTheme().getSelectedItem().equals("pokemon")) theme = 5;
		if(initMap.getTheme().getSelectedItem().equals("jurassirk parc")) theme = 6;
		Fenetre f2 = new Fenetre(map, game,t, theme);
		f2.init();
		
		LancementThread start_thread = new LancementThread(map);
		game.addObserver(start_thread);
		start_thread.start();
		
		musique.start();
		
		initMap.dispose();
	}

}
