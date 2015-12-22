package modele.deplacement;

import java.util.Observable;

import modele.composant.Fantome;
import modele.jeu.Labyrinthe;

public class BrainRandom extends Observable implements Runnable{

	private Labyrinthe map;
	private Fantome gosth;
	
	public BrainRandom(Labyrinthe map, Fantome gosth){
		this.map = map;
		this.gosth = gosth;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		while(true){
			this.gosth.randomDirection();
			boolean avance = true;
			
			switch(this.gosth.getDirection()){
			case 'h':
				while(avance){
					
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						this.gosth.setPosition(this.gosth.getX()-2, this.gosth.getY());
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.setChanged();
						this.notifyObservers("map");
					}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'g')){avance = false;}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'd')){avance = false;}
				}
				
				break;
			case 'g':
				while(avance){
					
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						this.gosth.setPosition(this.gosth.getX(), this.gosth.getY()-2);
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.setChanged();
						this.notifyObservers("map");
					}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'h')){avance = false;}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'b')){avance = false;}
				}
				break;
			case 'd':
				while(avance){
					
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						this.gosth.setPosition(this.gosth.getX(), this.gosth.getY()+2);
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.setChanged();
						this.notifyObservers("map");
					}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'h')){avance = false;}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'b')){avance = false;}
				}
				break;
			case 'b':
				while(avance){
					
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						this.gosth.setPosition(this.gosth.getX()+2, this.gosth.getY());
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.setChanged();
						this.notifyObservers("map");
					}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'g')){avance = false;}
					else if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'd')){avance = false;}
				}
				break;
			}
			
			this.setChanged();
			this.notifyObservers("map");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
