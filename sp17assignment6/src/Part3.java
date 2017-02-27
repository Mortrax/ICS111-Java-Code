import java.awt.Color;
import java.util.Random;

public class Part3 {

	public static void main(String[] args) {
		// initialize the EZ Graphics window
		EZ.initialize(500, 500);
		
		// initialize the random number generator;
		Random randomGenerator;
		randomGenerator = new Random();
		
		// the variables that will store our RGB values
		int randomRedVal = 0;
		int randomGreenVal = 0;
		int randomBlueVal = 0;
		
		// diameter and color of the circles
		int circleDiameter = 500;
		Color nextColor;
		
		do {
			// assign random values to the RGB variables
			randomRedVal = randomGenerator.nextInt(256);
			randomGreenVal = randomGenerator.nextInt(256);
			randomBlueVal = randomGenerator.nextInt(256);
			
			// create a new color using the randomized RGB values
			nextColor = new Color(randomRedVal, randomGreenVal, randomBlueVal);
			
			// draw a new circle to the screen using the new color and diameter
			EZ.addCircle(250, 250, circleDiameter, circleDiameter, nextColor, true);
			
			// decrement the diameter by 50px
			circleDiameter -= 50;
			
			// refresh the screen to display changes
			EZ.refreshScreen();
		} while (circleDiameter > 0);
		

	}

}
