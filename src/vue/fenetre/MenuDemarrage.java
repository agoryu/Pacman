package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vue.general.AfficherImage;
import vue.general.Audio;
import controler.fenetre.AfficheScoreControler;
import controler.fenetre.ExitControler;
import controler.fenetre.LanceEditMapControler;
import controler.fenetre.StartControler;


public class MenuDemarrage{

	private JPanel PanelImage;
	private JPanel PanelButton;
	private JButton lancer;
	private JButton quitter;
	private JButton score;
	private JLabel label;
	private JButton editeurMap;
	private JPanel panel;
	private JFrame f;
	
	public MenuDemarrage(){
		f=new JFrame();
		Thread t=new Thread(new Audio("ressource/musique_mp3/pacman_menudemarrage.mp3"));
		
		
		
		f.setLayout(new BorderLayout());
		f.setContentPane(new AfficherImage("ressource/image/noir.jpg"));
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		PanelImage = new JPanel();
		label = new JLabel(" ");
		
		int rand = (int)( Math.random() * (6-1)) +1;
		System.out.println(""+rand);
		
		if(rand==1){
			t.start();
			label.setIcon(new ImageIcon("ressource/image/pacman.gif"));
		}else if(rand==2){
			t=new Thread(new Audio("ressource/musique_mp3/Jurassic Park.mp3"));
			t.start();
			label.setIcon(new ImageIcon("ressource/image/pacman_jurassirkparc.gif"));
		}else if(rand == 3){
			t=new Thread(new Audio("ressource/musique_mp3/Pokemon.mp3"));
			t.start();
			label.setIcon(new ImageIcon("ressource/image/pacman_pokemon.gif"));
		}else if(rand == 4){
			t=new Thread(new Audio("ressource/musique_mp3/Mario.mp3"));
			t.start();
			label.setIcon(new ImageIcon("ressource/image/pacman_mario.gif"));	
		}else{
			t=new Thread(new Audio("ressource/musique_mp3/Star Wars.mp3"));
			t.start();
			label.setIcon(new ImageIcon("ressource/image/pacman_starwars.gif"));	
		}
		
		
		
		
		
		
		PanelImage.add(label);
		PanelImage.setBackground(new Color(4,2,4));
		panel.add(PanelImage,BorderLayout.NORTH);
		
		PanelButton = new JPanel();
		
		//gestion lancer jeu
		lancer = new JButton();
		lancer.setBackground(new Color(4,2,4));
		lancer.setIcon(new ImageIcon("ressource/image/start.png"));
		lancer.setPreferredSize(new Dimension(100,25));
		
		//gestion quitter fenetre
		quitter = new JButton();
		quitter.setBackground(new Color(4,2,4));
		quitter.setIcon(new ImageIcon("ressource/image/about.png"));
		
		//gestion affichage score
		score = new JButton();
		score.setBackground(new Color(4,2,4));
		score.setIcon(new ImageIcon("ressource/image/score.png"));
		
		//gestion editeur map
		editeurMap = new JButton();
		editeurMap.setBackground(new Color(4, 2, 4));
		editeurMap.setIcon(new ImageIcon("ressource/image/map.png"));
		
		//ajout des controler
		lancer.addActionListener(new StartControler(f,t));
		quitter.addActionListener(new ExitControler(f,t));
		score.addActionListener(new AfficheScoreControler(f,t));
		editeurMap.addActionListener(new LanceEditMapControler(f,t));
		
		//positionnement dans la fenetre
		PanelButton.setLayout(new GridLayout(1,4));
		PanelButton.add(lancer);
		PanelButton.add(score);
		PanelButton.add(editeurMap);
		PanelButton.add(quitter);

		panel.add(PanelButton,BorderLayout.SOUTH);
		f.add(panel);
		
		f.setSize(800,550);
		f.setVisible(true);
	}

	/*public JPanel setBackgroundImage(JFrame frame, final Image image){
		JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1;
			private BufferedImage buf = (BufferedImage) image;
			
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(buf, 0,0, null);
			}
		};
		return panel;
		
	}*/
	
}