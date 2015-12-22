package vue.general;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Police {

	public Police() {
		// TODO Auto-generated constructor stub
	}
	
	public Font getNewPolice(String police) {
		Font f = null;
		try {
			File file = new File(police);
			
			//créé une police avec la police charger
			f = Font.createFont(Font.TRUETYPE_FONT, file);
			f = f.deriveFont((float)20.0);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		catch(FontFormatException e2) {
			e2.printStackTrace();
		}
		
		return f;
	}

}
