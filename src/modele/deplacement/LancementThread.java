package modele.deplacement;

import java.util.Observable;
import java.util.Observer;

import modele.jeu.Labyrinthe;

public class LancementThread extends Thread implements Observer{

	private Labyrinthe map;
	private Thread fantome2;
	private Thread fantome3;
	private Thread fantome1;
	private Thread fantome4;
	
	public LancementThread(Labyrinthe map){
		this.map = map;
	}
	
	public void run(){
		
		// Mise en place des cerveau des Fantomes :
		
		try{
		
		this.fantome2 = new Thread(new BrainPoursuite(map, map.getFantome(1), map.getPacman()));
		this.fantome3 = new Thread(new BrainPoursuite(map, map.getFantome(2), map.getPacman()));
		this.fantome1 = new Thread(new BrainRandom(map, map.getFantome(0)));
		this.fantome4 = new Thread(new BrainRandom(map, map.getFantome(3)));
		
		//Lancement des Brain aléatoire.
		fantome1.start();	
		fantome4.start();
		
		//Lancement des Braine Poursuite.
		fantome2.start();
		} catch(IllegalThreadStateException e){
			
		}
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fantome3.start();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1.equals("stop Thread")){
			try{
				this.fantome3.interrupt();
				this.fantome2.interrupt();
				Thread.sleep(10000);
				this.fantome2.start();
				Thread.sleep(5000);
				this.fantome3.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IllegalThreadStateException e){
				
			}
		}
		else if(arg1.equals((Integer)0)){
			try {
				System.out.println("ok 3");
				this.fantome1.interrupt();
				Thread.sleep(8000);
				this.fantome1 = new Thread(new BrainRandom(map, map.getFantome(0)));
				this.fantome1.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalThreadStateException e){
				
			}
		}
		else if(arg1.equals((Integer)1)){
			try {
				System.out.println("ok 2");	
				this.fantome2.interrupt();
				Thread.sleep(8000);
				this.fantome2 = new Thread(new BrainPoursuite(map, map.getFantome(1), map.getPacman()));
				this.fantome2.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalThreadStateException e){
				
			}
		}
		else if(arg1.equals((Integer)2)){
			try {
				System.out.println("ok 1");
				this.fantome3.interrupt();
				Thread.sleep(8000);
				this.fantome3 = new Thread(new BrainPoursuite(map, map.getFantome(2), map.getPacman()));
				this.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalThreadStateException e){
				
			}
		}
		else if(arg1.equals((Integer)3)){
			try {
				System.out.println("ok 4");
				this.fantome4.interrupt();
				Thread.sleep(8000);
				this.fantome1 = new Thread(new BrainRandom(map, map.getFantome(3)));
				this.fantome4.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalThreadStateException e){
				
			}
		}
		
	}
	
}
