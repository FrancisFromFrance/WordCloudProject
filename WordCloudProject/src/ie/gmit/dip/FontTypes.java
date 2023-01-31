package ie.gmit.dip;

import java.awt.Font;


public interface FontTypes extends Colours{
	//This is an interface holding the Fonts, that I can access through my Menu class
	 public default Font getFont(int i) {


	 
	Font[] fonts = { 
			 new Font(Font.MONOSPACED, Font.ITALIC, 52),
			 new Font(Font.MONOSPACED, Font.ITALIC, 50),
			 new Font(Font.SANS_SERIF, Font.BOLD, 49),
			 new Font(Font.MONOSPACED, Font.PLAIN, 46),
			 new Font(Font.SANS_SERIF, Font.BOLD, 45),
			 new Font(Font.MONOSPACED, Font.ITALIC, 44),
			 new Font(Font.MONOSPACED, Font.ITALIC, 42),
			 new Font(Font.MONOSPACED, Font.ITALIC, 40),
			 new Font(Font.SANS_SERIF, Font.BOLD, 38),
			 new Font(Font.SANS_SERIF, Font.PLAIN, 36),
			 new Font(Font.SANS_SERIF, Font.BOLD, 34),
			 new Font(Font.SANS_SERIF, Font.ITALIC, 32),
			 new Font(Font.MONOSPACED, Font.BOLD, 30),
			 new Font(Font.SANS_SERIF, Font.BOLD, 29),
			 new Font(Font.SANS_SERIF, Font.ITALIC, 28),
			 new Font(Font.MONOSPACED, Font.BOLD, 27),
			 new Font(Font.SANS_SERIF, Font.BOLD, 26),
			 new Font(Font.SANS_SERIF, Font.PLAIN, 25),
			 new Font(Font.SANS_SERIF, Font.BOLD, 23),
			 new Font(Font.MONOSPACED, Font.ITALIC, 22),
			 new Font(Font.SANS_SERIF, Font.BOLD, 20),
			 new Font(Font.SANS_SERIF, Font.BOLD, 18), 
			 new Font(Font.MONOSPACED, Font.PLAIN, 17),
			 new Font(Font.SANS_SERIF, Font.BOLD, 16),
			 new Font(Font.SANS_SERIF, Font.ITALIC,15),
			 new Font(Font.MONOSPACED, Font.BOLD, 14),
			 new Font(Font.MONOSPACED, Font.BOLD, 13),
			 new Font(Font.SANS_SERIF, Font.BOLD, 12),
			 new Font(Font.MONOSPACED, Font.ITALIC, 10),
			 new Font(Font.SANS_SERIF, Font.BOLD, 8),
			 
			 
	 };
	return fonts[i];
	}//End of getFont method

	
	 }//End of class

