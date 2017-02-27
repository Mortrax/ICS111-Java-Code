import java.awt.Color;


public class Part2 {
	
	public static void main(String[] args) {
		
		// setup screen dimensions
		int screenWidth = 800;
		int screenHeight = 600;
		
		// setup EZ graphics system.
		EZ.initialize(screenWidth, screenHeight);

		// make the background grey.
		EZ.setBackgroundColor(new Color(100, 100, 100));  

		// create rectangles
		EZRectangle rectRed = EZ.addRectangle(600, 330, 80, 80, Color.RED, true);
		EZRectangle rectGreen = EZ.addRectangle(300, 300, 80, 80, Color.GREEN, true);
		
		// main loop
		while (true) {
		
			/* movement with 'wasd' keys */
			
			// right
			if(EZInteraction.isKeyDown('d')) { 
				rectGreen.translateBy(5f, 0f); 
			}
			
			// down?
			else if(EZInteraction.isKeyDown('s')) {
				rectGreen.translateBy(0f, 5f);
			}
			
			// left?
			else if(EZInteraction.isKeyDown('a')) {
				rectGreen.translateBy(-5f, 0f);
			}
			
			// up?
			else if(EZInteraction.isKeyDown('w')) {
				rectGreen.translateBy(0f, -5f);
			}
			
			
			/* check collision between the red and green objects */

			// remove both rectangles upon collision (hint provided for removing one of them)
			if(isColliding(rectGreen, rectRed)) {
				
				// remove green rectangle
				EZ.removeEZElement(rectGreen);
				
				// remove red rectangle?
				EZ.removeEZElement(rectRed);
				
			}
			System.out.println(rectGreen.getXCenter() + " " + rectGreen.getYCenter());
			
			
			// refresh graphics
			EZ.refreshScreen();
			
		}
		
	}
	
	
	/*
	 * isOverlapX(EZRectangle, EZRectangle)
	 *
	 * Description:
	 * Tells you whether the x coordinates of two EZRectangles are overlapping.
	 * 
	 * Returns: 
	 * boolean
	 */
	public static boolean isOverlapX(EZRectangle objA, EZRectangle objB) {
		
		// get objA values
		int aX = objA.getXCenter();
		int aWidth = objA.getWidth();

		// objA relevant coordinates (hint provided)
		int aX1 = aX - aWidth/2;
		int aX2 = aX + aWidth/2;

		// get objB values?
		int bX = objB.getXCenter();
		int bWidth = objB.getWidth();
		
		// objB relevant coordinates?
		int bX1 = bX - bWidth/2;
		int bX2 = bX + bWidth/2;
		
		
		// return whether the objects are overlapping?
		return (aX1 < bX1 && aX2 > bX1) || (aX1 < bX2 && aX2 > bX2);
		
	}
	
	
	/*
	 * isOverlapY(EZRectangle, EZRectangle)
	 *
	 * Description:
	 * Tells you whether the y coordinates of two EZRectangles are overlapping.
	 * 
	 * Returns: 
	 * boolean
	 */
	// ???
	public static boolean isOverlapY(EZRectangle objA, EZRectangle objB) {
		// get Object A values
		int aY = objA.getYCenter();
		int aHeight = objA.getHeight();
		
		// get Object A relevant coordinates
		int aY1 = aY - aHeight / 2;
		int aY2 = aY + aHeight / 2;
		
		// get Object B values
		int bY = objB.getYCenter();
		int bHeight = objB.getHeight();
		
		// get Object B relevant coordinates
		int bY1 = bY - bHeight / 2;
		int bY2 = bY + bHeight / 2;
		
		return (aY1 < bY1 && aY2 > bY1) || (aY1 < bY2 && aY2 > bY2);
		
		
	}
	
	
	/*
	 * isColliding(EZRectangle, EZRectangle)
	 *
	 * Description:
	 * Tells you whether two EZRectangles are overlapping.
	 * 
	 * Returns: 
	 * boolean
	 */
	public static boolean isColliding(EZRectangle a, EZRectangle b) {
		
		return isOverlapX(a, b) && isOverlapY(a, b);
		
	}

	
}
