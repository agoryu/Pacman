package controler.edit_map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modele.editeur_map.GrilleModele;

public class SaveControler implements ActionListener {

	private GrilleModele modele;
	
	public SaveControler(GrilleModele modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nomLab = JOptionPane.showInputDialog("entrez le nom de votre labyrinthe");
		if(!nomLab.equals(null)) modele.enregistrement(nomLab);

	}

}
