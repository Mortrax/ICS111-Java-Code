import java.awt.Color;


public class Part1 {

	// create screen dimensions
	static int screenWidth = 800;
	static int screenHeight = 600;
	
	public static void main(String[] args) {
		
		// setup EZ graphics system
		EZ.initialize(screenWidth, screenHeight);

		// make the background grey
		EZ.setBackgroundColor(new Color(100, 100, 100));  

		// create a circle
		EZCircle myCircle = EZ.addCircle(600, 300, 80, 80, Color.ORANGE, true);
		
		// main loop
		while (true) {
		
			/* movement based on 'wasd' keyboard input */
			
			// right
			if(EZInteraction.isKeyDown('d')) { 
				myCircle.translateBy(5f, 0f); 
			}
			
			// down?
			else if(EZInteraction.isKeyDown('s')) {
				myCircle.translateBy(0f, 5f);
			}
			
			// left?
			else if(EZInteraction.isKeyDown('a')) {
				myCircle.translateBy(-5f, 0f);
			}
			
			// up?
			else if(EZInteraction.isKeyDown('w')) {
				myCircle.translateBy(0f, -5f);
			}
			
			
			/* boundaries */
			
			// get relevant values
			int x = myCircle.getXCenter();
			int y = myCircle.getYCenter();
			int width = myCircle.getWidth();
			int height = myCircle.getHeight();
			
			// right side
			if( x + width/2 > screenWidth ) {
				myCircle.translateTo(screenWidth - width/2, y);
			}
			
			// left side?
			if(x - width/2 < 0) {
				myCircle.translateTo(0 + width/2, y);
			}
			
			// top side?
			if(y - height/2 < 0) {
				myCircle.translateTo(x, 0 + height/2);
			}
			// bottom side?
			if(y + height/2 > screenHeight) {
				myCircle.translateTo(x,  screenHeight - height/2);
			}
			
			// refresh graphics
			EZ.refreshScreen();
			
		}
		
	}
	
	
}
