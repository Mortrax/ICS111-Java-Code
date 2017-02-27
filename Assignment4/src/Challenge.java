/** Create a program that draws lines from the center of a window to form a circle.  
 * The circle has a radius of 200 pixels and contains a line every pi/12 degrees.  
 * Look up the Java Math class for helpful functions.  
 * You may modify LineExample to create this program **/
import java.awt.Color;
public class Challenge {
	
	static Color lineColor;
	static float PI = (float)Math.PI;
	
	static int x = 0;
	static int y = 0;
	static float alpha = 0;
	
	// function for setting up our graphics window and setting line color
	public static void setup(int R, int G, int B) {
		// initialize EZ to create our drawing canvas
		EZ.initialize(500, 500);
		
		// set up the background color of our canvas
		EZ.setBackgroundColor(new Color(0, 150, 0));
		
		// set up the color for our lines
		lineColor = new Color(R, G, B);
	}
	
	// program which handles the drawing of our line circle with specified
	// line frequency and radius
	public static void lineCircle(float interval, int radius) {
		
		// iterate while alpha < 2PI and draw lines to form a circle
		while (alpha < Math.PI*2) {
			
			x = (int)(radius * (float) Math.cos(alpha)) + 250;
			y = (int)(radius * (float) Math.sin(alpha)) + 250;
			EZ.addLine(250, 250, x, y, lineColor, 3);
			alpha += PI/interval; 
		}
		EZ.refreshScreen();
	}
	
	public static void main(String[] args) {
		// setup our graphics
		setup(255, 0, 0);
		// draw our line circle with custom parameters
		lineCircle(24, 250);
		
	}
}