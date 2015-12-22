package modele.deplacement;

import modele.jeu.Jeu;

public class MovePacman extends Thread {

	private Jeu game;
	
	public MovePacman(Jeu game){
		this.game = game;
	}	
	
	public void run(){
		while(true){
				
			game.deplacementPacMan();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
