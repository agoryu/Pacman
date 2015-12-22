package modele.jeu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import extensions.CSVFile;

public class Score extends Observable {

	private int score;
	private String highscore;
	private CSVFile file;
	
	public Score() {
		score = 0;
		
		//recuperation du meilleur score
		file = new CSVFile("ressource/HighScore.csv");
		highscore = file.getCell(0, 0);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int ajout) {
		this.score += ajout;
		this.setChanged();
		this.notifyObservers("score");
	}
	

	public void ajoutScore(int score) throws IOException{
		String tab[] = new String [100];
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("ressource/HighScore.csv", false));
			System.out.println("n1");
			int i = 0;
			
			for(i=0;i<100;i++){
					System.out.println("n1 "+i);
					System.out.println(file.getCell(i,0).toString());
					tab[i]=file.getCell(i,0).toString();
			}
			
			boolean b= false;
			i = 0;
			
			while(b!=true){
			
				if(tab[i].equals("0 ")){	System.out.println("n4 "+tab[i]+"  "+i);
				tab[i]=score+"";
				b=true;
				}else{ i++;
					System.out.println("n4b "+tab[i]+"  "+i);
					}
			}
			

			for(i=0;i<100;i++){
				output.write(tab[i]+"");
				output.write("\n");
				System.out.println("n5 "+i);
			}
			
			output.flush();
			output.close();
		} catch(IOException e) {e.printStackTrace();}
	}

	public void ajoutNouveauCSV() throws IOException{
		Object tab[] = new Object [100];
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("ressource/HighScore.csv", false));
			System.out.println("n1");
			int i = 0;
			
			for(i=0;i<100;i++){
				if(i<3){
					tab[i]=6000-2000*i;
				}else{
				tab[i]=0;
				}
				System.out.println(i);
			}
			
			for(i=0;i<100;i++){
				output.write(tab[i]+"");
				output.write("\n");
			}
			
			output.flush();
			output.close();
		} catch(IOException e) {e.printStackTrace();}
	}
	

	public String getHighscore() {
		return highscore;
	}
	
	public String getScoreNum(int x){
		return file.getCell(x, 0);
	}
	
	public String getStringScore() {
		return String.valueOf(score);
	}
	
	//cette methode va creer un tableau avec les 5 meilleur score.
	//si le score du joueur est parmi les 5, il sera ajoute.
	//La methode va également écrire dans le fichier, le nouveau classement.
	public String[] getTabScore() {
		
		int cpt = 0;
		String[] tabScore = new String[5];
		
		for(int i = 0; i<5; i++) {
			if(score >  Integer.valueOf(file.getCell(cpt, 0))) {
				tabScore[i] = this.getStringScore();
			} else {
				tabScore[i] = file.getCell(cpt, 0);
				cpt++;
			}
		}
		
		//ecriture du classement dans le fichier
		try {
			//le parametre false signifie que j'ecrase les donnees precedente.
			FileWriter fw = new FileWriter("ressource/HighScore.csv", false);
			BufferedWriter output = new BufferedWriter(fw);
			
			for(int i = 0; i<5; i++) output.write(tabScore[i]);
			
			output.flush();
			output.close();
		} catch(IOException e) {e.printStackTrace();}
		
		return tabScore;
	}

}
