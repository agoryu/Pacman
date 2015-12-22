package vue.general;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio implements Runnable {

	private Player p;
	public Audio(String music) {
		try {
			BufferedInputStream buf = new BufferedInputStream(new FileInputStream(music));
			p = new Player(buf);
		} catch(Exception e) {e.printStackTrace();}
	
	}
	
	public void run() {
		try {
			p.play();
		} catch(JavaLayerException e) {e.printStackTrace();}
	}
	
	public void close() {
		p.close();
	}

}
