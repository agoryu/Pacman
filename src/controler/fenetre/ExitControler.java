package controler.fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;

public class ExitControler extends Observable implements ActionListener {
	private Thread t;
	private JFrame f;
	public ExitControler(JFrame f,Thread t) {
		this.f=f;
		this.t=t;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.t.stop();
		this.f.dispose();
		this.setChanged();
		this.notifyObservers("stop Thread");
		System.exit(0);
	}

}
