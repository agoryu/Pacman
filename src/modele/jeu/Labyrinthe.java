package modele.jeu;

import modele.composant.Composant;
import modele.composant.Fantome;
import modele.composant.Mur;
import modele.composant.PacGomme;
import modele.composant.PacMan;
import modele.composant.SuperGomme;
import modele.composant.Vide;
import extensions.CSVFile;


public class Labyrinthe {

	private Composant [][] map;
	private PacMan pacman;
	private Fantome ennemie[];
	private CSVFile load;
	private int nbPacgommeMangeable;
	private String nomLab;
	
	private final int COTEE = 30;
	
	public Labyrinthe(String nomLab) {
		//chargement csv
		this.load=new CSVFile("ressource/map/"+nomLab);
		ennemie=new Fantome[4];
		this.map=new Composant[load.rowCount()][load.columnCount()];
		this.nbPacgommeMangeable = 0;
		this.nomLab = nomLab;
	}
	
	public String getNomLab() {
		return nomLab;
	}
	
	public PacMan getPacman() {
		return pacman;
	}
	
	public void setPacman(PacMan pacman) {
		this.pacman=pacman;
	}
	
	public Fantome getFantome(int nb) {
		return ennemie[nb];
	}
	
	public Composant getComposant(int x, int y) {
		return map[x][y];
	}
	
	public void setComposant(int x, int y, Composant composant) {
		this.map[x][y]=composant;
	}
	
	public int getNbColumn() {
		return load.columnCount();
	}
	
	public int getNbRow() {
		return load.rowCount();
	}
	
	public int getCotee(){
		return this.COTEE;
	}
	
	public boolean collisionProcessing(int posX, int posY, char direction){
		switch(direction){
		case 'h':
			for(int i = posY; i <= posY+24; i++){
				int caseX = (posX-1)/30;
				int caseY = i/30; 
				if(!map[caseX][caseY].estTraversable()){
					return false;
				}
			}
			break;
		case 'b':
			for(int i = posY; i < posY+24; i++){
				int caseX = (posX+31)/30;
				int caseY = i/30; 
				if(!map[caseX][caseY].estTraversable()){
					return false;
				}
			}
			break;
		case 'g':
			for(int i = posX; i < posX+24; i++){
				int caseX = i/30;
				int caseY = (posY-1)/30; 
				if(!map[caseX][caseY].estTraversable()){
					return false;
				}
			}
			break;
		case 'd':
			for(int i = posX; i < posX+24; i++){
				int caseX = i/30;
				int caseY = (posY+31)/30; 
				if(!map[caseX][caseY].estTraversable()){
					return false;
				}
			}
			break;
		}
		return true;
	}
	
	public void initMap(){
		int cptFantome=0;
		
		System.out.println("Debut de l'initialisation");
		//boucle qui passe sur tout le CSVFile et ajoute les élément a la map
		for(int i=0; i<load.rowCount(); i++) {
			for(int j=0; j<load.columnCount(); j++) {
				
				int px = i*COTEE;
				int py = j*COTEE;
				
				//ajout mur
				if(load.getCell(i, j).equals("M")) {
					map[i][j]=new Mur(px, py);
				}
				
				//ajout gomme
				if(load.getCell(i, j).equals(".")) {
					map[i][j]=new PacGomme(px, py);
					nbPacgommeMangeable++;
				}
				
				//ajout pacman
				if(load.getCell(i, j).equals("P")) {
					map[i][j]=new Vide(px, py);
					this.pacman = new PacMan(px+2, py+2);
				}
				
				//ajout fantome
				if(load.getCell(i, j).equals("F")) {
					ennemie[cptFantome]=new Fantome(px+2, py+2, cptFantome);
					map[i][j] = new Vide(px, py);
					cptFantome++;
				}
				if(load.getCell(i, j).equals(" ")) {
					map[i][j]=new Vide(px, py);
				}
				if(load.getCell(i,j).equals("o")){
					map[i][j] = new SuperGomme(px,py);
				}

			}
		}
		
	}
	
	public int getPacgommeMangeable() {
		return this.nbPacgommeMangeable;
	}
	
	public void afficheMap() {
		for(int i=0; i<this.getNbRow(); i++) {
			for(int j=0; j<this.getNbColumn(); j++) {
				System.out.print(this.map[i][j].getNom());
			}
			System.out.println("\n");
		}
	}
}
