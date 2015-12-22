package vue.editeur_map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.editeur_map.GrilleModele;
import controler.edit_map.ReglageControler;

public class PanReglage extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panMur;
	private JPanel panFantome;
	private JPanel panGomme;
	private JPanel panPacman;
	private JPanel panSuperGomme;
	private JLabel labGomme;
	private JLabel labFantome;
	private GrilleModele modele;
	
	public PanReglage(GrilleModele modele) {
		
		this.modele = modele;
		panMur = new JPanel();
		panFantome = new JPanel();
		panGomme = new JPanel();
		panPacman = new JPanel();
		panSuperGomme = new JPanel();
	}
	
	public void init() {
		
		this.setLayout(new GridLayout(1, 6));
		Color blanc = new Color(255, 255, 255);
		ReglageControler rg = new ReglageControler(modele, this);
		
		//mur
		
		ComposantGraphic mur = new ComposantGraphic('m');
		mur.setPreferredSize(new Dimension(30, 30));
		panMur.setBackground(blanc);
		panMur.add(mur);
		panMur.addMouseListener(rg);
		JLabel labMur = new JLabel("  mur");
		panMur.add(labMur);
		this.add(panMur);
		
		//fantome
		
		ComposantGraphic fantome = new ComposantGraphic('f');
		fantome.setPreferredSize(new Dimension(30, 30));
		panFantome.setBackground(blanc);
		panFantome.add(fantome);
		panFantome.addMouseListener(rg);
		labFantome = new JLabel("  4 x fantome");
		panFantome.add(labFantome);
		this.add(panFantome);
		
		//pacgomme
		
		ComposantGraphic pacgomme = new ComposantGraphic('.');
		pacgomme.setPreferredSize(new Dimension(30, 30));
		panGomme.setBackground(blanc);
		panGomme.add(pacgomme);
		panGomme.addMouseListener(rg);
		labGomme = new JLabel("  pacgomme");
		panGomme.add(labGomme);
		this.add(panGomme);
		
		//pacman
		
		ComposantGraphic pacman = new ComposantGraphic('p');
		pacman.setPreferredSize(new Dimension(30, 30));
		panPacman.setBackground(blanc);
		panPacman.add(pacman);
		panPacman.addMouseListener(rg);
		JLabel labPacman = new JLabel("  pacman");
		panPacman.add(labPacman);
		this.add(panPacman);
		
		//super pacgomme
		
		ComposantGraphic supergomme = new ComposantGraphic('o');
		supergomme.setPreferredSize(new Dimension(30, 30));
		panSuperGomme.setBackground(blanc);
		panSuperGomme.add(supergomme);
		panSuperGomme.addMouseListener(rg);
		JLabel labSuperGomme = new JLabel("  super pacgomme");
		panSuperGomme.add(labSuperGomme);
		this.add(panSuperGomme);
		
	}

	public JPanel getPanMur() {
		return panMur;
	}

	public JPanel getPanFantome() {
		return panFantome;
	}

	public JPanel getPanGomme() {
		return panGomme;
	}

	public JPanel getPanPacman() {
		return panPacman;
	}

	public JPanel getPanSuperGomme() {
		return panSuperGomme;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1.equals("editeur")) {
			labFantome.setText("   "+modele.getCptFantome()+" x fantome");
		}
		
	}

}
