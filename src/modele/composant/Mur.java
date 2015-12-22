package modele.composant;

public class Mur extends Composant {

	public Mur(int x, int y) {
		super(x, y, 30, 30);
		this.nom='M';
	}
	
	public boolean estTraversable(){
		return false;
	}

}
