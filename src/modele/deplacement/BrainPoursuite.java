package modele.deplacement;

import java.util.Observable;

import modele.composant.Fantome;
import modele.composant.PacMan;
import modele.jeu.Labyrinthe;

public class BrainPoursuite extends Observable implements Runnable{

	private Labyrinthe map;
	private Fantome gosth;
	
	public BrainPoursuite(Labyrinthe map, Fantome gosth, PacMan pacman){
		this.map = map;
		this.gosth = gosth;
	}
	
	public void run(){
		while(true){
			
			//System.out.println("deplacement poursuite");
			
			if(this.map.getPacman().getX() < this.gosth.getX() && this.map.getPacman().getY() <= this.gosth.getY()){
				this.gosth.setDirection('h');
				if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
					this.gosth.setX(this.gosth.getX()-2);
					this.sendNotify();
				}
				else {
					this.gosth.setDirection('g');
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'h')){
							this.gosth.setY(this.gosth.getY()-2);
							this.sendNotify();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						char dir1 = 'h';
						this.gosth.setDirection('d');
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), dir1)){
							//if(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
								this.gosth.setY(this.gosth.getY()+2);
								this.sendNotify();
							//}
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			else if(this.map.getPacman().getX() > this.gosth.getX() && this.map.getPacman().getY() >= this.gosth.getY()){
				this.gosth.setDirection('b');
				if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
					this.gosth.setX(this.gosth.getX()+2);
					this.sendNotify();
				}
				else {
					this.gosth.setDirection('d');
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'b')){
							this.gosth.setY(this.gosth.getY()+2);
							this.sendNotify();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else {
						char dir1 = 'b';
						this.gosth.setDirection('g');
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), dir1)){
							//if(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
								this.gosth.setY(this.gosth.getY()-2);
								this.sendNotify();
							//}
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			else if(this.map.getPacman().getX() <= this.gosth.getX() && this.map.getPacman().getY() > this.gosth.getY()){
				this.gosth.setDirection('d');
				if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
					this.gosth.setY(this.gosth.getY()+2);
					this.sendNotify();
				}
				else {
					this.gosth.setDirection('h');
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'd')){
							this.gosth.setX(this.gosth.getX()-2);
							this.sendNotify();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						char dir1 = 'd';
						this.gosth.setDirection('b');
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), dir1)){
							//if(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
							this.gosth.setX(this.gosth.getX()+2);
							this.sendNotify();
							//}
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			else if(this.map.getPacman().getX() >= this.gosth.getX() && this.map.getPacman().getY() < this.gosth.getY()){
				this.gosth.setDirection('g');
				if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
					this.gosth.setY(this.gosth.getY()-2);
					this.sendNotify();
				}
				else {
					this.gosth.setDirection('b');
					if(map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), 'g')){
							this.gosth.setX(this.gosth.getX()+2);
							this.sendNotify();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else {
						char dir1 = 'g';
						this.gosth.setDirection('h');
						while(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), dir1)){
							//if(!map.collisionProcessing(this.gosth.getX(), this.gosth.getY(), this.gosth.getDirection())){
								this.gosth.setX(this.gosth.getX()-2);
								this.sendNotify();
							//}
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendNotify(){
		this.setChanged();
		this.notifyObservers("map");
	}
}
