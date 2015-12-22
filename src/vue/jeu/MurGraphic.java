package vue.jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MurGraphic extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private Image image;
	private int theme;
	
	public MurGraphic(Graphics g, int theme) {
		this.g = g;
		this.theme = theme;
	}
	
	public MurGraphic(Graphics g, String nomImage, int theme) {
		this.g = g;
		this.theme = theme;
		try {
			image = ImageIO.read(new File("ressource/image/decor/"+nomImage+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(int posX, int posY, int taille) {
		
		switch(theme) {
		case 1:
			g.setColor(Color.BLUE);
			g.fillRect(posX, posY, taille, taille);
			break;
		case 2:
			this.paintComponent(posX, posY, taille);
			break;
		case 3:
			this.paintComponent(posX, posY, taille);
			break;
		case 4:
			this.paintComponent(posX, posY, taille);
			break;
		case 5:
			this.paintComponent(posX, posY, taille);
			break;
		case 6:
			this.paintComponent(posX, posY, taille);
			break;
		}
	}
	
	public void paintComponent(int posX, int posY, int taille){
		super.paintComponents(this.g);
		g.drawImage(image, posX, posY, taille, taille, this);
	}

}
