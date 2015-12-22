package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controler.fenetre.CommencerControler;

public class InitialisationMap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private JLabel titre;
	private JComboBox theme;
	private JComboBox ComboMap;
	private JButton commencer;
	private Thread t;
	
	public InitialisationMap(Thread t) {
		this.setTitle("Initialisation");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.t = t;
	}
	
	public void init() {
		container = new JPanel();
		container.setBackground(new Color(4,2,4));
		container.setLayout(new BorderLayout());
		
		//gestion titre
		titre = new JLabel(new ImageIcon("ressource/image/pacman_init.gif"));
	
		container.add(titre, BorderLayout.NORTH);
		
		JPanel panCombo = new JPanel();
		panCombo.setBackground(new Color(4,2,4));
		
		//gestion theme
		String[] nomTheme = {"classique", "enfer", "chateau bowser","star wars","pokemon","jurassirk parc"};
		theme = new JComboBox(nomTheme);
		panCombo.add(theme);
		
		//gestion map
		//permet de récupérer toutes les map du dossier map
		File file = new File("ressource/map");
		String[] listeMap = file.list();
		
		ComboMap = new JComboBox(listeMap);
		panCombo.add(ComboMap);
		container.add(panCombo, BorderLayout.CENTER);
		
		//gestion bouton commencer
		commencer = new JButton("commencer");
		commencer.addActionListener(new CommencerControler(this,t));
		container.add(commencer, BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setVisible(true);
	}

	public JComboBox getTheme() {
		return theme;
	}

	public JComboBox getComboMap() {
		return ComboMap;
	}
	
	
	

}
