package modele.editeur_map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

public class GrilleModele extends Observable {

	private char[][] tabChar;
	private char elementSelectionne;
	private int cptPacman;
	private int cptFantome;

	public GrilleModele() {
		tabChar = new char[20][28];
		elementSelectionne = 'i';
		cptPacman = 1;
		cptFantome = 4;
	}
	
	public void initTab() {
		for(int i = 0; i<20; i++) {
			for(int j = 0; j<28; j++) {
				tabChar[i][j] = ' ';
			}
		}
	}
	
	public void setTabChar(int x, int y) {
		
		if(elementSelectionne == 'P' && cptPacman > 0) {
			this.tabChar[x][y] = elementSelectionne;
			cptPacman--;
		}
		
		if(elementSelectionne == 'F' && cptFantome > 0) {
			this.tabChar[x][y] = elementSelectionne;
			cptFantome--;
		}
		
		if(elementSelectionne == 'M' || elementSelectionne == 'o' || elementSelectionne == '.') this.tabChar[x][y] = elementSelectionne;
		
		this.setChanged();
		this.notifyObservers("editeur");
		
	}
	
	public void enregistrement(String nomLab) {
		//methode qui va sauvegarder un labyrinthe dans un fichier csv
		
		try {
			//le parametre false signifie que j'ecrase les donnees precedente.
			FileWriter fw = new FileWriter("ressource/map/"+nomLab+".csv", false);
			BufferedWriter output = new BufferedWriter(fw);
			
			for(int i = 0; i<20; i++) {
				for(int j = 0; j<28; j++){
					output.write(tabChar[i][j]+",");
				}
				output.write("\n");
			}
			
			output.flush();
			output.close();
		} catch(IOException e) {e.printStackTrace();}
	}
	
	public char[][] getTabChar() {
		return tabChar;
	}
	
	public void setElementSelectionne(char c) {
		this.elementSelectionne = c;
		
	}
	
	public char getElementSelectionne() {
		return elementSelectionne;
	}

	public int getCptFantome() {
		return cptFantome;
	}
	
	
}
