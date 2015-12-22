package modele.composant;

public class Vide extends Composant {

	public Vide(int x, int y) {
		super(x, y, 30, 30);
		this.nom=' ';
	}

	public boolean estTraversable(){
		return true;
	}

}