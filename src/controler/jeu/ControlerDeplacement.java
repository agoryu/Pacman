package controler.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modele.deplacement.MovePacman;
import modele.jeu.Jeu;
import modele.jeu.Labyrinthe;

public class ControlerDeplacement implements KeyListener {

	private Labyrinthe map;
	private MovePacman deplace;
	
	public ControlerDeplacement(Jeu game, Labyrinthe map){
		this.deplace = new MovePacman(game);
		this.map = map;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		this.deplace.interrupt();
		
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.map.getPacman().setDirection('h');		
			this.deplace.start();
			break;
		case KeyEvent.VK_RIGHT:
			this.map.getPacman().setDirection('d');
			this.deplace.start();
			break;
		case KeyEvent.VK_DOWN:
			this.map.getPacman().setDirection('b');
			this.deplace.start();
			break;
		case KeyEvent.VK_LEFT:
			this.map.getPacman().setDirection('g');
			this.deplace.start();
			break;
		default:
			System.out.println("erreur 1");	
		} 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
