/** Create a program that draws lines from the center of a window to form a circle.  
 * The circle has a radius of 200 pixels and contains a line every pi/12 degrees.  
 * Look up the Java Math class for helpful functions.  
 * You may modify LineExample to create this program **/
import java.awt.Color;
public class Challenge {
	public static void main(String[] args) {
		// initialize EZ to create our drawing canvas
		EZ.initialize(500, 500);
		
		// set up the background color of our canvas
		EZ.setBackgroundColor(new Color(0, 150, 0));
		
		// set up the color for our lines
		Color lineColor = new Color(255, 255, 0);
		
		// the starting point for all of our lines will be at the center point
		// (250, 250)
		float startingX = 250.0f, startingY = 250.0f;
		
		// the radius of our circle (length of the lines)
		float radius = 200.0f;
		
		// the angle between start and our line
		float angle = 0.0f;
		
		// iterate until angle == 2PI and draw lines to form a circle
		while (angle <= 2 * Math.PI) {
			EZ.addLine((int)startingX, (int)startingY, 
					(int)(startingX + Math.sin(angle) * radius),
					(int)(startingY + Math.cos(angle) * radius), 
					lineColor, 2);
			angle += Math.PI/12; 
		}
		
		EZ.refreshScreen();
	}
}
