package modele.jeu;

import java.util.Observable;

import javax.swing.JOptionPane;

import modele.composant.Vide;
import vue.general.Audio;
import extensions.CSVFile;

public class Jeu extends Observable {

	private Labyrinthe map;
	private Score score;
	private int pacGommeMange;
	@SuppressWarnings("unused")
	private int nbVie;
	private int nbTourFantomeMangeable;
	
	public Jeu(Labyrinthe map) {
		this.score = new Score();
		this.map=map;
		this.nbVie = 3;
		this.pacGommeMange = 0;
		nbTourFantomeMangeable = 0;
	}
	
	public void deplacementPacMan() {
		
		Thread t = new Thread(new Audio("ressource/musique_mp3/pacman_chomp.mp3"));
		
		int posX = map.getPacman().getX()/30;
		int posY = map.getPacman().getY()/30;
		
		nbTourFantomeMangeable++;
		
		//temps ou les fantomes sont mangeable par le pacman
		if(nbTourFantomeMangeable == 1000) {
			for(int i= 0; i<4; i++) {
				map.getFantome(i).setMangeable(false);
				nbTourFantomeMangeable = 0;
			}
		}
		
		//action enclenche quand le joueur gagne
		if(this.pacGommeMange == map.getPacgommeMangeable()) {
			//declenche la musique
			Thread t2 = new Thread(new Audio("ressource/musique_mp3/pacman_intermission.mp3"));
			t2.start();
			//ouvre une boite de dialogue
			JOptionPane.showMessageDialog(null, "CONGRATULATION", "victoire", JOptionPane.INFORMATION_MESSAGE);
			pacGommeMange = 0;
		}
		
		//verifie si le pacman est attraper par un fantome
		if(this.attraper()) {
			Thread t3 = new Thread(new Audio("ressource/musique_mp3/pacman_death.mp3"));
			t3.start();
			this.reinitMap();
		}
		
		switch(map.getPacman().getDirection()) {
		case 'h':
			posX = (map.getPacman().getX()-1)/30;
			
			//verification de la case devant avant de ce deplacer
			if(map.collisionProcessing(map.getPacman().getX(), map.getPacman().getY(), map.getPacman().getDirection())){
				this.action(posX, posY, t);
				map.getPacman().setPosition(map.getPacman().getX()-2, map.getPacman().getY());
				
					
				this.setChanged();
				this.notifyObservers("map");
			}
			else {
				this.setChanged();
				this.notifyObservers("map");
			}
			break;
		case 'd':
			posY = (map.getPacman().getY()+map.getPacman().getWidth()+1)/30;
			
			//verification de la case devant avant de ce deplacer
			if(map.collisionProcessing(map.getPacman().getX(), map.getPacman().getY(), map.getPacman().getDirection())){
				this.action(posX, posY, t);
				map.getPacman().setPosition(map.getPacman().getX(), map.getPacman().getY()+2);
					
				this.setChanged();
				this.notifyObservers("map");
			}
			else {
				this.setChanged();
				this.notifyObservers("map");
			}
			break;
		case 'g':
			posY = (map.getPacman().getY()+1)/30;
			
			//verification de la case devant avant de ce deplacer
			if(map.collisionProcessing(map.getPacman().getX(), map.getPacman().getY(), map.getPacman().getDirection())){
				this.action(posX, posY, t);
				map.getPacman().setPosition(map.getPacman().getX(), map.getPacman().getY()-2);
					
				this.setChanged();
				this.notifyObservers("map");
			}
			else {
				this.setChanged();
				this.notifyObservers("map");
			}
			break;
		case 'b':
			posX = (map.getPacman().getX()+map.getPacman().getHeight()+1)/30;
			
			//verification de la case devant avant de ce deplacer
			if(map.collisionProcessing(map.getPacman().getX(), map.getPacman().getY(), map.getPacman().getDirection())){
				this.action(posX, posY, t);
				map.getPacman().setPosition(map.getPacman().getX()+2, map.getPacman().getY());
					
				this.setChanged();
				this.notifyObservers("map");
			}
			else {
				this.setChanged();
				this.notifyObservers("map");
			}
			break;
		default:
			System.out.println("erreur");	
		}
		
	}
	
	public Score getScore() {
		return score;
	}
	
	public void action(int posX, int posY, Thread t) {
			
		if(map.getComposant(posX, posY).getNom() == '.'){
			//ajout du son quand pacman mange 3 pacgomme
			if(pacGommeMange%3 == 0) t.start();
			pacGommeMange++;
				
			//On augmente le score si on marche sur un pacGome
			this.score.setScore(5);
				
			//ici on ferme la bouche du pacman
			this.map.getPacman().setMange(true);
				
			//on cree un vide derriere le pacman
			map.setComposant(posX, posY, new Vide(posX,posY));
		}else if(map.getComposant(posX, posY).getNom() == 'o') {
			for(int i = 0; i<4; i++) {
				map.getFantome(i).setMangeable(true);
			}
			map.setComposant(posX, posY, new Vide(posX, posY));
		} else {
			this.map.getPacman().setMange(false);
		}
	}
	
	public boolean attraper() {
		for(int i = 0; i<4; i++) {
			if((map.getPacman().getX() == map.getFantome(i).getX()) &&
				map.getPacman().getY() == map.getFantome(i).getY()) {
				if(!map.getFantome(i).getMangeable()) {
					this.setChanged();
					this.notifyObservers("vie");
					return true;
				} else {
					map.getFantome(i).setX(10*30);
					map.getFantome(i).setY(14*30);
					this.setChanged();
					this.notifyObservers((Integer)i);
				}
			}
		}
		return false;
	}
	
	public void reinitMap() {
		CSVFile file = new CSVFile("ressource/map/"+map.getNomLab());
		
	/*	CSVFile file_sauv = new CSVFile("ressource/HighScore.csv");
		file_sauv.ajouter();
		
		*/
		
		
		int COTEE = map.getCotee();
		int cptFantome = 0;
		this.nbVie--;
		for(int i = 0; i<file.rowCount(); i++) {
			for(int j = 0; j<file.columnCount(); j++) {
				if(file.getCell(i, j).equals("P")) {
					map.getPacman().setX(i*COTEE);
					map.getPacman().setY(j*COTEE);
				}
				else if(file.getCell(i, j).equals("F")) {
					map.getFantome(cptFantome).setX(i*COTEE);
					map.getFantome(cptFantome).setY(j*COTEE);
					cptFantome++;
				}
			}
		}
		
		this.setChanged();
		this.notifyObservers("stop Thread");
		this.notifyObservers("map");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public Labyrinthe getMap(){
		return this.map;
	}
}
