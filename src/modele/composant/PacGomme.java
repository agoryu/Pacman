package modele.composant;

public class PacGomme extends Composant{

	public PacGomme(int x, int y) {
		super(x, y, 30, 30);
		this.nom='.';
	}
	
	public boolean estTraversable(){
		return true;
	}
}