package fonts;

import java.awt.Font;

public class Fonts {
	static Font plainFont1 = new Font(Font.SANS_SERIF, Font.PLAIN,  16);
	static Font boldFont1 = new Font(Font.SANS_SERIF, Font.BOLD,  16);
	static Font terningFont = new Font(Font.SANS_SERIF, Font.BOLD,  30);
	static Font statusFontFont = new Font(Font.SANS_SERIF, Font.PLAIN,  18);
	
	public static Font getPlainFont1() {
		return plainFont1;
	}

	public static Font getBoldFont1() {
		return boldFont1;
	}
	
	public static Font getTerningFont() {
		return terningFont;
	}
	
	public static Font getStatusFontFont() {
		return statusFontFont;
	}	
	
}
