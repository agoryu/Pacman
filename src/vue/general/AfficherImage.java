package vue.general;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AfficherImage extends JPanel{
			
			/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	Image image;
	
	//"ressource/ImagePacman.jpg"
	public AfficherImage(String url){
		
		try {
			image = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		} 
	}