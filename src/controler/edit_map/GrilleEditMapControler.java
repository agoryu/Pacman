package controler.edit_map;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.editeur_map.GrilleLab;

public class GrilleEditMapControler implements MouseListener {
	
	private GrilleLab grilleGraph;

	public GrilleEditMapControler(GrilleLab grille) {
		this.grilleGraph = grille;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		grilleGraph.getGrilleModele().setTabChar(arg0.getY()/25, arg0.getX()/25);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
