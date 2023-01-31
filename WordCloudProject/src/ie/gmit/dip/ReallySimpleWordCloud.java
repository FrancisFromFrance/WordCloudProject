
package ie.gmit.dip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.plaf.ColorUIResource;


public class ReallySimpleWordCloud implements FontTypes {

	public void DrawCloud(Map<String, Integer> wordMap, int numWords, String filename) throws Exception {
		//This method draws the word cloud
		BufferedImage image = new BufferedImage(1200, 600, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		Color colour1 = new ColorUIResource(Color.red);
		

		int wordCount = 0;
		int xposition = 0;
		int yposition = 0;

		for (String key : wordMap.keySet()) {
			if (wordCount < numWords) {
				font1 = getFont(wordCount); //Set the fonts
				graphics.setFont(font1);
				colour1 = getColour(wordCount); //Sets the colours
				graphics.setColor(colour1);

				graphics.drawString(key, xposition, yposition);
				wordCount++;
				// xposition += 10;
				// yposition += 10;
				xposition = 150 + (int) (Math.random() * (1200 - 300) + 1); //Randomly puts the words onto the map
				yposition = 100 +(int) (Math.random() * (600 - 200) + 1);	
			} else {
				break;
			}

		}

		graphics.dispose();
		ImageIO.write(image, "png", new File(filename)); //Write out the image in png format
	}

	

	protected int getInt_random() {
		return int_random;
	}

	protected void setInt_random(int int_random) {
		this.int_random = int_random;
	}
	Random random = new Random(); // instance of random
	int upperbound = 25;
	int int_random = random.nextInt(upperbound);// generates random number between 0-24



}
