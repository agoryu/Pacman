package modele.composant;


public class PacMan extends Composant{

	private char direction;
	private int vie;
	private boolean mange;
	
	public PacMan(int x, int y) {
		super(x, y, 20, 20);
		this.nom='P';
		this.vie = 3;
		this.direction='g';
		mange = false;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction=direction;
	}
	
	public int getVie(){
		return this.vie;
	}
	
	public void setVie(int vie){
		this.vie = vie;
	}
	
	public void decrementeVie(){
		this.vie--;
	}
	
	public boolean estTraversable(){
		return false;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean getMange() {
		return mange;
	}

	public void setMange(boolean mange) {
		this.mange = mange;
	}

	
}
