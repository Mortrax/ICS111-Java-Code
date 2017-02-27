import java.util.Random;
import java.awt.Color;
public class Raindrop {
	// initialize the random number generator
	static Random rand = new Random();
	
	// maximum possible raindrop diameter
	static final int maxDropDiameter = 30;
	
	// how fast the average raindrop falls
	static final int acceleration = 2;
	
	// width and height of our window
	static int screenWidth = 600;
	static int screenHeight = 600;
	
	static EZSound rain_sound = EZ.addSound("./assets/rain-01.wav");
	

	// generates a random X coordinate as the starting position for the raindrops
	public static int getRandomStartX() {
		return rand.nextInt(screenWidth);
		
	};
	
	public static int getRandomStartY() {
		return rand.nextInt(20) * -1;
	}
	
	// generates random dimension for new raindrops
	public static int getRandomDiameter() {
		return rand.nextInt(maxDropDiameter) + 10;
	}
	
	
	public static void main(String[] args) {
		
		EZ.initialize(screenWidth, screenHeight);
		
		// use an array of circles (rain drops) to track the location of each
		// rain drop in real time
		EZCircle circles[] = new EZCircle[15];
		for(int i = 0; i < 15; i++) {
			int diameter = getRandomDiameter();
			circles[i] = EZ.addCircle(getRandomStartX(), getRandomStartY(), diameter,
					diameter, Color.CYAN, true);
		}
		rain_sound.loop();
		// The main rain loop		
		while(true) {

			for(int i = 0; i < 15; i++) {
				circles[i].translateBy(0, acceleration * (i + 1));

				// check if each rain drop has hit the ground and if so return it to the
				// top of the window at a random x location
				if (circles[i].getYCenter() + circles[i].getHeight() +
						(maxDropDiameter - circles[i].getHeight()) > screenHeight) {
					circles[i].translateTo(getRandomStartX(), getRandomStartY());
					
				}
				
			}

			EZ.refreshScreen();
		}
		

	}

}
