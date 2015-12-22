package vue.general;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class BoutonPerso1 extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String texte;
	
	public BoutonPerso1(String texte) {
		super(texte);
		this.texte = texte;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public void paintComponent(Graphics g) {
		this.setBackground(Color.BLACK);
		g.setColor(Color.YELLOW);
		g.drawString(texte, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
		g.draw3DRect(0, 0, this.getWidth(), this.getHeight(), true);
	}

}
