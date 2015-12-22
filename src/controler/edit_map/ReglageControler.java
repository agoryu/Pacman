package controler.edit_map;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.editeur_map.GrilleModele;
import vue.editeur_map.PanReglage;

public class ReglageControler implements MouseListener {

	private GrilleModele modele;
	private PanReglage pr;
	
	public ReglageControler(GrilleModele modele, PanReglage pr) {
		this.modele = modele;
		this.pr = pr;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == pr.getPanMur()) {
			modele.setElementSelectionne('M');
		} else if(event.getSource() == pr.getPanFantome()) {
			modele.setElementSelectionne('F');
		} else if(event.getSource() == pr.getPanGomme()) {
			modele.setElementSelectionne('.');
		} else if(event.getSource() == pr.getPanPacman()) {
			modele.setElementSelectionne('P');
		} else if(event.getSource() == pr.getPanSuperGomme()) {
			modele.setElementSelectionne('o');
		}
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
