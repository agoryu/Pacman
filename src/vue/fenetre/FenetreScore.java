package vue.fenetre;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.fenetre.ExitFrame;
import vue.general.AfficherImage;
import modele.jeu.Score;



public class FenetreScore {
	
	
	private Score score;
	private JPanel panel;
	private JPanel panelHighscore;
	private JButton b;
	private JLabel l;
	private JLabel l0;
	private JLabel l1;
	private JLabel l2;
	private JFrame f;
	
	public FenetreScore(){
		f = new JFrame();
		f.setContentPane(new AfficherImage("ressource/image/noir.jpg"));
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();

		//création des panels
		panel = new JPanel();
		panelHighscore = new JPanel();
		
		//création de la classe score
		score = new Score();
		
		//ajout de l'image de l'interface
		l = new JLabel(new ImageIcon("ressource/image/highscore.png"));
		panelHighscore.add(l);
		
		//ajout couleur de fond
		panelHighscore.setBackground(new Color(77,48,96));
		f.add(panelHighscore);
		
		//ajout des score
		l0 = new JLabel("     1er         " +score.getHighscore());
		l1 = new JLabel("     2e          " +score.getScoreNum(1));
		l2 = new JLabel("     3e          " +score.getScoreNum(2));
		Font font = new Font("Arial",Font.BOLD,50);
		
		//changement couleur de police
		l0.setForeground(new Color(255,255,0));
		l2.setForeground(new Color(255,255,0));
		l1.setForeground(new Color(255,255,0));
		
		//changement type de police
		l0.setFont(font);
		l2.setFont(font);
		l1.setFont(font);
		
		//changement couleur du label( en mauve)
		l0.setBackground(new Color(255,0,255));
		l1.setBackground(new Color(255,0,255));
		l2.setBackground(new Color(255,0,255));
		
		panel.setBackground(new Color(77,48,96));
		
		panel.setLayout(new GridLayout(3,1));
		
		panel.add(l0);
		panel.add(l1);
		panel.add(l2);
		
		//ajout du bouton
		b = new JButton(new ImageIcon("ressource/image/boutonhighscore.png"));
		
		//ajout Listener
		b.addActionListener(new ExitFrame(f));
		panel.add(b);
		panel.setLayout(new GridLayout(4,1));
		f.add(panel);

		
		f.setLayout(new GridLayout(2,1));
		f.setSize(600, 600);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FenetreScore f = new FenetreScore();
	}
}
