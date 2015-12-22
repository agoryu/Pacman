package vue.fenetre;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import vue.general.Audio;
import controler.fenetre.GameOverControler;



public class GameOver{
	
	private JButton bouton;
	
	public GameOver(){
		
		JFrame f = new JFrame();
		
		//musique du gameover
		new Thread(new Audio("ressource/musique_mp3/pacman_death.mp3")).start();
		
		bouton = new JButton(new ImageIcon("ressource/image/gameover_gif.gif"));
		bouton.setBackground(new Color(0,0,0));
		bouton.addActionListener(new GameOverControler(f));
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		
		f.add(bouton);
		
		
		//taille de l'image 
		f.setSize(1000,714);
		f.setResizable(false);
		f.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GameOver g = new GameOver();
	}
}