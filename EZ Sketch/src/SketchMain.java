import java.awt.Color;


public class SketchMain {
	
	// declare static variables to maintain the state of our buttons
	
	static EZRectangle nextButton;
	static EZRectangle redButton;
	static EZRectangle blueButton;
	static EZRectangle greenButton;
	
	
	// initialize variables that represent the appearance and position 
	// of the Next Line button	
	static Color nextButtonColor = Color.lightGray;
	static Color nextTextColor = Color.black;
	static int nextButtonX = 50;
	static int nextButtonY = 50;
	static int nextButtonW = 75;
	static int nextButtonH = 50;
	
	// initialize variables that represent the color, dimensions, and positions
	// of our paint palette buttons; these are the buttons that will let us
	// change the line color
	static Color redButtonColor = Color.red;
	static int redButtonX = 150;
	static int redButtonY = 50;
	static int redButtonW = 50;
	static int redButtonH = 50;
	
	static Color greenButtonColor = Color.green;
	static int greenButtonX = 225;
	static int greenButtonY = 50;
	static int greenButtonW = 50;
	static int greenButtonH = 50;
	
	static Color blueButtonColor = Color.blue;
	static int blueButtonX = 300;
	static int blueButtonY = 50;
	static int blueButtonW = 50;
	static int blueButtonH = 50;
	
	// initializing the sound files for our next_line and paint palette buttons
	static EZSound nextSound = EZ.addSound("assets/button-3.wav");
	static EZSound redSound = EZ.addSound("assets/bear_growl_y.wav");
	static EZSound greenSound = EZ.addSound("assets/bird_caw1.wav");
	static EZSound blueSound = EZ.addSound("assets/cat_meow_x.wav");
		
	// function that is responsible for drawing our buttons on the screen
	public static void drawButtons() {
		// draw our Next Line button to the screen
		nextButton = EZ.addRectangle(nextButtonX, nextButtonY, nextButtonW, 
				nextButtonH, nextButtonColor, true);
		EZ.addText(nextButtonX, nextButtonY, "Next Line", nextTextColor);
		
		// draw our paint palette buttons to the screen
		redButton = EZ.addRectangle(redButtonX, redButtonY, redButtonW,
				redButtonH, redButtonColor, true);
		greenButton = EZ.addRectangle(greenButtonX, greenButtonY, greenButtonW, 
				greenButtonH, greenButtonColor, true);
		blueButton = EZ.addRectangle(blueButtonX, blueButtonY, blueButtonW, 
				blueButtonH, blueButtonColor, true);
		
		// give our buttons a nice border for aesthetics 
		EZ.addRectangle(nextButtonX, nextButtonY, nextButtonW,
				nextButtonH, Color.BLACK, false);
		EZ.addRectangle(redButtonX, redButtonY, redButtonW,
				redButtonH, Color.BLACK, false);
		EZ.addRectangle(blueButtonX, blueButtonY, blueButtonW,
				blueButtonH, Color.BLACK, false);
		EZ.addRectangle(greenButtonX, greenButtonY, greenButtonW,
				greenButtonH, Color.BLACK, false);
		
		// draw a line to demarcate our drawing area, again for aesthetics
		EZ.addLine(0, 100, 600, 100, Color.BLACK);
		
		// repaint to the screen to show changes
		EZ.refreshScreen(); 
	}
	
	// helper function that allows us to check when a button has been clicked by the user
	public static boolean wasButtonClicked(EZRectangle button, int x, int y) {
		if (EZInteraction.wasMouseLeftButtonReleased() &&
				button.isPointInElement(x, y)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// the main loop function that will run, check where the user has clicked
	// and respond accordingly, all the while updating the current x and y
	// coordinates of our mouse on the fly
	// all user interaction with the sketch window, including drawing lines
	// occurs within this main loop function
	public static void drawMainLoop() {
		// initialize the x and y coordinates that will be used to implement the
		// mouse click behavior of our sketch program and set the default color
		// to black
		Color currentColor = Color.black;
		int oldX = -1;
		int oldY = -1;
		int newX = -1;
		int newY = -1;
		

		while(true) {
			// capture the X and Y coordinates of the mouse to save typing later
			int mouseX = EZInteraction.getXMouse();
			int mouseY = EZInteraction.getYMouse();
			
			// was our next_line button clicked?
			if(wasButtonClicked(nextButton, mouseX, mouseY)) {
				// if so, play a sound
				// and reset the x and y coordinates to their default values of -1
				nextSound.play();
				oldX = -1;
				oldY = -1;
				newX = -1;
				newY = -1;
			}
			// was our red paint palette button clicked?
			else if(wasButtonClicked(redButton, mouseX, mouseY)) {
				// if so, set the current line color to red
				// play a unique sound
				// and reset the x and y coordinates to their default values of -1
				currentColor = redButtonColor;
				redSound.play();
				oldX = -1;
				oldY = -1;
				newX = -1;
				newY = -1;
			}
			// was our green paint palette button clicked?
			else if(wasButtonClicked(greenButton, mouseX, mouseY)) {
				// if so, set the current line color to green
				// play a unique sound
				// and reset the x and y coordinates to their default values of -1
				currentColor = greenButtonColor;
				greenSound.play();
				oldX = -1;
				oldY = -1;
				newX = -1;
				newY = -1;
			}
			// was our blue paint palette button clicked?
			else if(wasButtonClicked(blueButton, mouseX, mouseY)) {
				// if so, set the current line color to blue
				// play a unique sound
				// and reset the x and y coordinates to their default values of -1
				currentColor = blueButtonColor;
				blueSound.play();
				oldX = -1;
				oldY = -1;
				newX = -1;
				newY = -1;	
			}
			// have we yet to start drawing a line?
			else if(oldX == -1 && oldY == -1 && 
					EZInteraction.wasMouseLeftButtonReleased() &&
					mouseY > 100) {
				// if so set the oldX and oldY (starting X and Y for our new line)
				// to be the current mouseX and mouseY coordinates where we have clicked
				oldX = mouseX;
				oldY = mouseY;
			}
			// this is for subsequent clicks after our first click into the drawing pane
			else if(EZInteraction.wasMouseLeftButtonReleased() &&
					mouseY > 100) {
				// set the newX and newY coordinates (ending X and Y for our new line)
				// to be the current mouse X and mouseY coordinates where we have clicked
				newX = mouseX;
				newY = mouseY;
				
				// Draw the line to the screen using our previously set x and y values
				EZ.addLine(oldX, oldY, newX, newY, currentColor, 5);
				
				// set the oldX and oldY to be newX and newY, so that the next line we
				// draw will start from the end of our current line (daisy chain effect)
				oldX = newX;
				oldY = newY;
			}
			// for monitoring the behavior of our mouse clicking interface
			System.out.println(oldX + " " + oldY + " " + newX + " " + 
			newY + " " + mouseX + " " + mouseY);
			EZ.refreshScreen();
		}
	}
	
	

	public static void main(String[] args) {
		// initialize our EZ graphics library and create a window that is 500px by
		// 500px
		EZ.initialize(600, 600);
		
		// draw our buttons to the screen
		drawButtons();
		
		// run our main loop for drawing
		drawMainLoop();
		
	}
}
