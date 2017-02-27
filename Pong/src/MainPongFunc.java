import java.awt.Color;


public class MainPongFunc {

	static int posX = 0;			// Stores the x position of the probe
	static int posY = 200;			// Stores the y position of the probe	
	static int directionX = 5;		// Stores the x direction of the probe
	static int directionY = 5;		// Stores the y direction of the probe
	static int rotationAngle = 0;	// Stores the rotation angle of the probe
	static int saberX = 700/2;		// Stores X Position of the light saber 
	static EZImage backgroundPicture;	// Stores background picture
	static EZImage probePicture;		// Stores picture of probe
	static EZImage saberPicture;		// Stores picture of lightsaber
	static EZSound saberSound;			// Stores sound file for saber, saber class and impressive...
	static EZSound clashSound;
	static EZSound impressiveSound;
	static int bounces = 0;				// Stores the number of times the probe has bounced off the lightsaber
	
	public static void setupEZ(){
	
		EZ.initialize(700,500);    // Start up EZ and make a screen of 700 x 500 pixels in size

		EZ.setBackgroundColor(new Color(0, 0,0));  // Make the background black.

		backgroundPicture = EZ.addImage("milleniumfalcon.jpg", 450,200);
		probePicture = EZ.addImage("probe.png", 0,0);
		saberPicture = EZ.addImage("saber-blue.png", 0,0);
	
		saberSound = EZ.addSound("saberhum.wav");
		clashSound = EZ.addSound("clash.wav");
		impressiveSound = EZ.addSound("impressive.wav");
		saberSound.loop();
	}
	

	public static void moveProbe(){
		probePicture.translateTo(posX, posY); // Set the position of the probe.

		probePicture.rotateTo(rotationAngle); // Set the rotation angle of the probe.
							
		posX= posX+directionX;
		posY= posY+directionY;
		
		rotationAngle+=directionX;

		
		if (posX > 700 ) {
			directionX = -directionX;
		}
		if (posX < 0) {
			directionX = -directionX;
		}

		
		if (posY > 600 ) {		// if the ball reaches all the way to the bottom reset it to the top
			posY=0;
		}
		if (posY < 0) {
			directionY = -directionY;
		}

	}
	
	public static void controlSaber(){
		if (EZInteraction.isKeyDown('d')) {
			saberX+=10;
		} else if (EZInteraction.isKeyDown('a')) {
			saberX-=10;
		}
		
		int halfSaberWidth = saberPicture.getWidth()/2;
		
		saberPicture.translateTo(saberX,480);
		
		if ((posX < saberX+halfSaberWidth) && (posX > saberX-halfSaberWidth) && (posY > 460) && (posY < 480)){
			directionY = -directionY;
			clashSound.play();
			bounces++;
			if (bounces == 3) {
				impressiveSound.play();
				bounces = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		setupEZ();
		

		while (true) {

			moveProbe();
			controlSaber();
			
			EZ.refreshScreen();
		}
	}

}
