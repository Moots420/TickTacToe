

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;


public class FontLoader {
public static Font a;

	  public static Font loadFont(String path,float size) {
			
			
				 try {
					a = Font.createFont(Font.TRUETYPE_FONT, MainGame.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
				 } catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			     return a;
		
	  }

}
