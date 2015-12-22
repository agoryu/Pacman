package modele.composant;

public class SuperGomme extends Composant {
	
	public SuperGomme(int x, int y){
		super(x, y, 28, 28);
		this.nom = 'o';
	}

	@Override
	public boolean estTraversable(){
		return true;
	}
}
