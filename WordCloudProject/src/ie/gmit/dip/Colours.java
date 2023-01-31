package ie.gmit.dip;

import java.awt.Color;


public interface Colours {


	public default Color getColour(int i) {

		Color[] colour = {
				new Color(0xff0000),	//Red
				new Color(0x0000FF),	//Blue
				new Color(0xA52A2A),	//Brown
				new Color(0xff0000),	//Red
				new Color(0x00FFFF),	//Cyan
				new Color(0x008B8B), 	//DarkCyan
				new Color(0xA9A9A9),	//DarkGray
				new Color(0x8B0000),	//DArkRed
				new Color(0xFFD700),	//Gold
				new Color(0x808080),	//Gray
				new Color(0x32CD32),	//LimeGreen
				new Color(0x800000), 	//Maroon
				new Color(0xFF00FF), 	//Magenta	
				new Color(0xC0C0C0),	//Silver
				new Color(0xff0000),	//Red
				new Color(0x0000FF),	//Blue
				new Color(0xA52A2A),	//Brown
				new Color(0xff0000),	//Red
				new Color(0x00FFFF),	//Cyan
				new Color(0x008B8B), 	//DarkCyan
				new Color(0xA9A9A9),	//DarkGray
				new Color(0x8B0000),	//DArkRed
				new Color(0xFFD700),	//Gold
				new Color(0x808080),	//Gray
				new Color(0x32CD32),	//LimeGreen
				new Color(0x800000), 	//Maroon
				new Color(0xFF00FF), 	//Magenta	
				new Color(0xC0C0C0),	//Silver
				new Color(0xff0000),	//Red
				new Color(0x0000FF),	//Blue

				
		};

		return colour[i];
	}//End of getColour method

}//End of class
