package controler.fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vue.fenetre.MenuDemarrage;

public class ExitFrame implements ActionListener {

	private JFrame f;
	
	public ExitFrame(JFrame f){
		this.f=f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		f.dispose();
		new MenuDemarrage();
	}

}
