package modele.composant;

import java.util.Random;

public class Fantome extends Composant{
	
	private int numero;
	private char direction;
	private boolean mangeable;
	
	public Fantome(int x, int y, int numero) {
		super(x, y, 24, 24);
		this.numero=numero;
		this.nom='F';
		this.mangeable = false;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction=direction;
	}
	
	public boolean estTraversable(){
		return true;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean getMangeable() {
		return mangeable;
	}
	
	public void setMangeable(boolean mangeable) {
		this.mangeable = mangeable;
	}
	
	public void randomDirection(){
		Random rm = new Random();
		int alea = rm.nextInt(4);
		switch(alea){
		case 0:
			this.direction = 'h';
			break;
		case 1:
			this.direction = 'g';
			break;
		case 2:
			this.direction = 'd';
			break;
		case 3:
			this.direction = 'b';
			break;
		}
	}
}
