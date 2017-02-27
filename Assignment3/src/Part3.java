import java.awt.Color;

/** Modify this program (LineExample) to instead draw a grid with 
 * horizontal lines spaced 20 units apart and vertical lines 
 * spaced 20 units apart.**/
public class Part3 {

	public static void main(String[] args) {
		// Setup EZ graphics system.
		EZ.initialize(500,500); 

		// Setup the background color of the canvas		
		EZ.setBackgroundColor(new Color(0,150,0)); 
		
		// Setup the color of our vertical and horizontal lines respectively
		Color lineColor1 = new Color(255,255,0);
		Color lineColor2 = new Color(0,255,255);
		
		//starting values of x and y
		int y = 0;
		int x = 0;
		
		// iterate and draw our horizontal lines
		while(y < 500) {
			EZ.addLine(0,y,500,y,lineColor2,3);
			y += 20;
		}
		EZ.refreshScreen();
		
		// iterate and draw our vertical lines
		while(x < 500) {
			EZ.addLine(x, 0, x, 500, lineColor1, 3);
			x += 20;
		}
		// update everything to the screen
		EZ.refreshScreen();

	}

}
